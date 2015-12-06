package free.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.AbstractChart;
import twaver.swing.TExpandPane;

public abstract class Portlet extends JPanel implements Runnable {

    private boolean running = true;
    private static JFileChooser chooser;
    private AbstractChart chart;

    public void initialize(AbstractChart chart) {
        this.chart = chart;
        JToolBar toolbar = getControlPanel();
        TExpandPane searchPopup = new TExpandPane(toolbar, TExpandPane.SOUTH, true, false);

        this.setLayout(new BorderLayout());
        this.add(chart, BorderLayout.CENTER);
        this.add(searchPopup, BorderLayout.SOUTH);
    }

    public AbstractChart getChart() {
        return chart;
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = new JToolBar();
        toolbar.setRollover(true);
        toolbar.setFloatable(false);

        JButton export = createButton("/resource/image/network/exportToImage.png");
        export.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (chooser == null) {
                    chooser = TWaverUtil.createImageFileChooser();
                }
                chart.exportImage(chooser, true);
            }
        });
        toolbar.add(export);

        JButton zoomIn = createButton("/resource/image/network/zoomIn.png");
        zoomIn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.zoomIn();
            }
        });
        toolbar.add(zoomIn);

        JButton zoomOut = createButton("/resource/image/network/zoomOut.png");
        zoomOut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.zoomOut();
            }
        });
        toolbar.add(zoomOut);

        JButton reset = createButton("/resource/image/network/zoomReset.png");
        reset.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.reset();
            }
        });
        toolbar.add(reset);

        JButton fullScreen = createButton("/resource/image/network/fullScreen.png");
        fullScreen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                PortletPanel container = (PortletPanel) Portlet.this.getParent();
                container.fullScreen(Portlet.this);
            }
        });
        toolbar.add(fullScreen);
        return toolbar;
    }

    private JButton createButton(String icon) {
        JButton button = new JButton(TWaverUtil.getIcon(icon));
        button.setMargin(TWaverConst.NONE_INSETS);
        return button;
    }

    public JButton getRunButton() {
        final JButton button = createButton("/free/test/stop.gif");
        button.setMargin(TWaverConst.NONE_INSETS);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (isRunning()) {
                    stopRun();
                    button.setIcon(TWaverUtil.getIcon("/free/test/start.gif"));
                } else {
                    startRun();
                    button.setIcon(TWaverUtil.getIcon("/free/test/stop.gif"));
                }
            }
        });
        return button;
    }

    public void startRun() {
        this.running = true;
    }

    public void stopRun() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void run() {
    }
}
