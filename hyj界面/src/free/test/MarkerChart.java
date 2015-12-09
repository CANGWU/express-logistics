package free.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JToolBar;

import twaver.Element;
import twaver.ElementCallbackHandler;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.BarChart;
import twaver.chart.Marker;

public class MarkerChart extends Portlet {

    private TDataBox box = new TDataBox();
    private BarChart chart = new BarChart(box) {

        public Color getColor(Element element) {
            double value = element.getChartValue();
            if (value < -70) {
                return Color.RED;
            }
            if (value > 70) {
                return Color.ORANGE;
            }
            return Color.GREEN;
        }
    };

    public MarkerChart() {
        super.initialize(chart);
        chart.setSelectedOffset(0);
        chart.setShadowOffset(0);
        chart.setGradient(true);
        chart.setUpperLimit(100);
        chart.setLowerLimit(-100);
        chart.setYScaleValueGap(10);
        chart.setYScaleTextVisible(true);
        chart.setYScaleMinTextVisible(true);

        Marker marker = new Marker(70, Color.ORANGE);
        marker.setText("high level marker");
        marker.setColor(Color.ORANGE);
        chart.addMarker(marker);

        marker = new Marker(-70, Color.RED);
        marker.setText("low level marker");
        marker.setColor(Color.RED);
        chart.addMarker(marker);

        for (int i = 1; i < 8; i++) {
            Element element = new Node();
            element.putChartValue(TWaverUtil.getRandomInt(100));
            element.setUserObject(TWaverUtil.getRandomBoolean());
            element.setName("C" + i);
            box.addElement(element);
        }
    }

    public void run() {
        if (!isRunning()) {
            return;
        }
        box.iterator(new ElementCallbackHandler() {

            public boolean processElement(Element element) {
                double value = element.getChartValue();
                if (Boolean.TRUE.equals(element.getUserObject())) {
                    value += 3;
                    if (value >= 98) {
                        element.setUserObject(Boolean.FALSE);
                    }
                } else {
                    value -= 3;
                    if (value <= -98) {
                        element.setUserObject(Boolean.TRUE);
                    }
                }
                element.putChartValue(value);
                return true;
            }
        });
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        toolbar.add(getRunButton());
        final JComboBox combobox = new JComboBox();
        combobox.setPreferredSize(new Dimension(combobox.getPreferredSize().width, 20));
        combobox.addItem("South");
        combobox.addItem("East");
        combobox.addItem("West");
        combobox.addItem("North");

        combobox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (combobox.getSelectedItem().toString().equals("South")) {
                    chart.setLegendLayout(TWaverConst.LEGEND_LAYOUT_HORIZONTAL);
                    chart.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_HORIZONTAL);
                } else if (combobox.getSelectedItem().toString().equals("East")) {
                    chart.setLegendLayout(TWaverConst.LEGEND_LAYOUT_VERTICAL);
                    chart.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_HORIZONTAL);
                } else if (combobox.getSelectedItem().toString().equals("West")) {
                    chart.setLegendLayout(TWaverConst.LEGEND_LAYOUT_VERTICAL_WEST);
                    chart.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_HORIZONTAL);
                } else if (combobox.getSelectedItem().toString().equals("North")) {
                    chart.setLegendLayout(TWaverConst.LEGEND_LAYOUT_HORIZONTAL_NORTH);
                    chart.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_VERTICAL);
                }
            }
        });

        toolbar.add(combobox);

        return toolbar;
    }
}
