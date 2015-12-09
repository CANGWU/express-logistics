package free.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import twaver.Element;
import twaver.MouseActionEvent;
import twaver.TWaverConst;

public class CompositionDemo extends JPanel implements PortletPanel {

    private List chartList = new ArrayList();
    private MarkerChart markerChart = new MarkerChart();
    private JapanChart japanChart = new JapanChart();
    private TravelChart travelChart = new TravelChart();
    private AdoptionChart adoptionChart = new AdoptionChart();
    private ShareChart shareChart = new ShareChart();
    private MobileChart mobileChart = new MobileChart();
    private HealthChart healthChart = new HealthChart();
    private WeatherChart weatherChart = new WeatherChart();
    private ClockChart clockChart = new ClockChart();
    private GridLayout layout = new GridLayout();
    private boolean isFullScreen = false;
    ActionListener listener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            MouseActionEvent event = (MouseActionEvent) e;
            Element element = (Element) event.getSource();
            int index = event.getIndex();
            Component comp = (Component) event.getView();
            String message;
            Double value = (Double) element.getClientProperty(TWaverConst.PROPERTYNAME_CHART_VALUE);
            if (value == null) {
                if (index < 0) {
                    message = element.getName();
                } else {
                    message = element.getName() + "," + element.getChartValues().get(index);
                }
            } else {
                message = element.getName() + "," + TWaverConst.DEFAULT_DOUBLE_FORMATER.format(value.doubleValue());
            }
            JOptionPane.showMessageDialog(comp, message);
        }
    };

    public void initialize() {
        int size = chartList.size();
        this.setLayout(layout);
        for (int i = 0; i < size; i++) {
            this.add((Portlet) chartList.get(i));
        }
    }

    public void fullScreen(Portlet portlet) {
        this.removeAll();
        isFullScreen = !isFullScreen;
        if (isFullScreen) {
            this.setLayout(new BorderLayout());
            this.add(portlet, BorderLayout.CENTER);
        } else {
            initialize();
        }
        portlet.getChart().reset();
        this.repaint();
        this.revalidate();
    }

    public CompositionDemo() {
        layout.setColumns(3);
        layout.setHgap(3);
        layout.setRows(3);
        layout.setVgap(3);

        chartList.add(markerChart);
        chartList.add(japanChart);
        chartList.add(travelChart);
        chartList.add(adoptionChart);
        chartList.add(shareChart);
        chartList.add(mobileChart);
        chartList.add(healthChart);
        chartList.add(weatherChart);
        chartList.add(clockChart);
        int size = chartList.size();
        for (int i = 0; i < size; i++) {
            ((Portlet) chartList.get(i)).getChart().addElementDoubleClickedActionListener(listener);
        }
        initialize();

        Thread t = new Thread(new Runnable() {

            public void run() {
                try {
                    while (true) {
                        if (isShowing()) {
                            SwingUtilities.invokeAndWait(new Runnable() {

                                public void run() {
                                    int size = chartList.size();
                                    for (int i = 0; i < size; i++) {
                                        ((Portlet) chartList.get(i)).run();
                                    }
                                }
                            });
                        }
                        Thread.sleep(150);
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();

    }
}
