package free.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JToolBar;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.PieChart;

public class ShareChart extends Portlet {

    private TDataBox box = new TDataBox();
    private PieChart chart = new PieChart(box);

    public ShareChart() {
        super.initialize(chart);
        addElement("Sprint", 23, Color.BLUE);
        addElement("Verizon", 26, Color.YELLOW);
        addElement("AT&T", 26, Color.GREEN);
        addElement("T-Mobile", 11, Color.MAGENTA);
        addElement("Alltel", 5, Color.CYAN);
        addElement("Rest", 9, Color.RED);

        chart.setTitle("US Carrier Market Share");
        chart.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
        chart.setHollow(true);
        chart.set3D(true);
    }

    private void addElement(String name, double value, Color color) {
        Element element = new Node();
        element.setName(name);
        element.putChartValue(value);
        element.putChartColor(color);
        box.addElement(element);
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        toolbar.add(getRunButton());
        final JCheckBox percentage = new JCheckBox("Percentage");
        percentage.setPreferredSize(new Dimension(percentage.getPreferredSize().width, 20));
        percentage.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.setValueTextPercent(percentage.isSelected());
            }
        });

        final JCheckBox hollow = new JCheckBox("Hollow");
        hollow.setPreferredSize(new Dimension(hollow.getPreferredSize().width, 20));
        hollow.setSelected(true);
        hollow.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.setHollow(hollow.isSelected());
            }
        });

        final JCheckBox is3d = new JCheckBox("3D", false);
        is3d.setPreferredSize(new Dimension(is3d.getPreferredSize().width, 20));
        is3d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.set3D(is3d.isSelected());
            }
        });
        is3d.setSelected(true);

        toolbar.add(percentage);
        toolbar.add(hollow);
        toolbar.add(is3d);
        return toolbar;
    }

    public void run() {
        if (box.getSelectionModel().size() == 0 && isRunning()) {
            chart.setStartAngle(chart.getStartAngle() + 1);
        }
    }
}
