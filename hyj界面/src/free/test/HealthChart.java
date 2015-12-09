package free.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JToolBar;

import twaver.Element;
import twaver.ElementCallbackHandler;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.Marker;
import twaver.chart.PercentChart;

public class HealthChart extends Portlet {

    private TDataBox box = new TDataBox();
    private PercentChart chart = new PercentChart(box);

    public HealthChart() {
        super.initialize(chart);
        chart.setTitle("Server Health Monitor");
        chart.setGradient(true);
        chart.setPercentLabelFont(new Font("Forte", Font.PLAIN, 13));
        chart.setPercentLabelColor(Color.blue);
        chart.setSegmentCount(10);
        chart.setMarkerStartPosition(TWaverConst.PERCENT_MARKER_START_WITH_BOTTOM);
        this.addElement("CPU", 16, 50, 90, TWaverConst.PERCENT_STYLE_SEGMENT).setUserObject(Boolean.TRUE);
        this.addElement("Memory", 70, 60, 80, TWaverConst.PERCENT_STYLE_PLANE).setUserObject(Boolean.FALSE);
        this.addElement("Storage", 64, 30, 60, TWaverConst.PERCENT_STYLE_SOLID).setUserObject(Boolean.TRUE);
    }

    private Element addElement(String name, double current, int marker1, int marker2, int style) {
        List markers = new ArrayList();
        Marker marker = new Marker();
        marker.setColor(Color.GREEN);
        marker.setTextColor(marker.getColor());
        marker.setValue(0);
        marker.setText("0%");
        markers.add(marker);

        marker = new Marker();
        marker.setColor(Color.ORANGE);
        marker.setTextColor(marker.getColor());
        marker.setValue(marker1);
        marker.setText(marker1 + "%");
        markers.add(marker);

        marker = new Marker();
        marker.setColor(Color.RED);
        marker.setTextColor(marker.getColor());
        marker.setValue(marker2);
        marker.setText(marker2 + "%");
        markers.add(marker);

        Element element = new Node();
        element.putChartPercentSpareFill(true);
        element.setName(name);
        element.putChartValue(current);
        element.putChartPercentStyle(style);
        element.putChartMarkers(markers);

        box.addElement(element);
        return element;
    }

    public void run() {
        if (!isRunning()) {
            return;
        }
        box.iterator(new ElementCallbackHandler() {

            public boolean processElement(Element element) {
                double value = element.getChartValue();
                if (Boolean.TRUE.equals(element.getUserObject())) {
                    value += 2;
                    if (value >= 100) {
                        element.setUserObject(Boolean.FALSE);
                    }
                } else {
                    value -= 2;
                    if (value <= 0) {
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
        final JComboBox prorateCombobox = new JComboBox();
        prorateCombobox.addItem("0.1");
        prorateCombobox.addItem("0.2");
        prorateCombobox.addItem("0.3");
        prorateCombobox.addItem("0.4");
        prorateCombobox.addItem("0.5");
        prorateCombobox.addItem("0.6");
        prorateCombobox.addItem("0.7");
        prorateCombobox.addItem("0.8");
        prorateCombobox.addItem("0.9");
        prorateCombobox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                String value = prorateCombobox.getSelectedItem().toString();
                chart.setSegmentSectionProrate(Double.valueOf(value).doubleValue());
            }
        });
        prorateCombobox.setSelectedItem("0.5");
        prorateCombobox.setPreferredSize(new Dimension(prorateCombobox.getPreferredSize().width, 20));
        toolbar.add(prorateCombobox);
        final JComboBox combobox = new JComboBox();
        combobox.addItem("horizontal");
        combobox.addItem("vertical ");
        combobox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (combobox.getSelectedIndex() == 0) {
                    chart.setPercentType(TWaverConst.PERCENT_TYPE_HORIZONTAL);
                    chart.setPercentLabelCenter(false);
                } else if (combobox.getSelectedIndex() == 1) {
                    chart.setPercentType(TWaverConst.PERCENT_TYPE_VERTICAL);
                    chart.setPercentLabelCenter(true);
                }
            }
        });
        combobox.setPreferredSize(new Dimension(combobox.getPreferredSize().width, 20));
        toolbar.add(combobox);
        final JComboBox position = new JComboBox();
        position.addItem("Default");
        position.addItem("InnerDefault");
        position.addItem("Top");
        position.addItem("Bottom");
        position.addItem("Left");
        position.addItem("Right");
        position.addItem("InnerTop");
        position.addItem("InnerBottom");
        position.addItem("InnerLeft");
        position.addItem("InnerRight");

        position.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (position.getSelectedIndex() == 2) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_TOP);
                } else if (position.getSelectedIndex() == 3) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_BOTTOM);
                } else if (position.getSelectedIndex() == 4) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_LEFT);
                } else if (position.getSelectedIndex() == 5) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_RIGHT);
                } else if (position.getSelectedIndex() == 6) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_INNER_TOP);
                } else if (position.getSelectedIndex() == 7) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_INNER_BOTTOM);
                } else if (position.getSelectedIndex() == 8) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_INNER_LEFT);
                } else if (position.getSelectedIndex() == 9) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_INNER_RIGHT);
                } else if (position.getSelectedIndex() == 1) {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_INNER_DEFAULT);
                } else {
                    chart.setMarkerPosition(TWaverConst.PERCENT_MARKER_POSITION_DEFAULT);
                }
            }
        });
        position.setSelectedIndex(0);
        position.setPreferredSize(new Dimension(position.getPreferredSize().width, 20));
        toolbar.add(position);
        return toolbar;
    }
}
