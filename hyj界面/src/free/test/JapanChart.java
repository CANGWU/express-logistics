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
import twaver.chart.BarChart;

public class JapanChart extends Portlet {

    private Element subOfTotal = new Node();
    private Element subOf3G = new Node();
    private TDataBox box = new TDataBox();
    private BarChart chart = new BarChart(box);

    public JapanChart() {
        super.initialize(chart);
        chart.setBarType(TWaverConst.BAR_TYPE_GROUP);
        chart.setTitle("<html>Japan's cellular subs & 3G penetration<br><center>by carrier,2005(millions)</center></html>");
        chart.setShadowOffset(10);
        chart.setYScaleTextVisible(true);
        chart.setYScaleMinTextVisible(true);
        chart.setUpperLimit(60);
        chart.setYScaleValueGap(10);

        chart.addXScaleText("NTT DoCoMo");
        chart.addXScaleText("KDDI");
        chart.addXScaleText("Vodafone");

        addElement(subOf3G, "3G subs", Color.GREEN.brighter());
        addElement(subOfTotal, "Total subs", Color.ORANGE.darker());

        addValue(subOfTotal, 50.56, 24.69, 15.11);
        addValue(subOf3G, 20.12, 20.58, 2.31);
    }

    private void addElement(Element element, String name, Color color) {
        element.setName(name);
        element.putChartColor(color);
        box.addElement(element);
    }

    private void addValue(Element element, double value1, double value2, double value3) {
        element.addChartValue(value1);
        element.addChartValue(value2);
        element.addChartValue(value3);
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        final JCheckBox check = new JCheckBox("Legend Visble");
        check.setOpaque(false);
        check.setSelected(chart.getLegendPane().isVisible());
        check.setPreferredSize(new Dimension(check.getPreferredSize().width, 20));
        check.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.getLegendPane().setVisible(check.isSelected());
            }
        });
        toolbar.add(check);
        return toolbar;
    }
}
