package free.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.RadarChart;

public class WeatherChart extends Portlet {

    private TDataBox box = new TDataBox();
    private RadarChart chart = new RadarChart(box);

    public WeatherChart() {
        super.initialize(chart);
        chart.setScaleMajorCount(5);
        chart.setRingMinVisible(false);
        chart.setShapeFillGradient(false);
        chart.setRadarFillColor(new Color(50, 170, 160));
        chart.setAxisTextFont(new Font("dialog", Font.PLAIN, 12));
        chart.setScaleMajorCount(4);
        chart.setTitle("Weather Status");
        chart.setScaleMajorTextVisible(false);

        chart.addAxisText("Rainy");
        chart.addAxisText("Snowy");
        chart.addAxisText("Windy");
        chart.addAxisText("Cloudy");
        chart.addAxisText("Iced");
        chart.addAxisText("Fine");
        List janList = new ArrayList();
        janList.add("0.1");
        janList.add("0.4");
        janList.add("0.6");
        janList.add("0.4");
        janList.add("0.5");
        janList.add("0.2");
        List febList = new ArrayList();
        febList.add("0.4");
        febList.add("0.2");
        febList.add("0.5");
        febList.add("0.6");
        febList.add("0.2");
        febList.add("0.5");

        chart.setScaleMaxValue(0.8);
        addElement("Jan.", Color.GREEN, TWaverConst.INFLEXION_STYLE_CIRCLE, TWaverConst.STROKE_SOLID_1, janList);
        addElement("Feb.", Color.ORANGE, TWaverConst.INFLEXION_STYLE_CIRCLE, TWaverConst.STROKE_SOLID_1, febList);
    }

    public void addElement(String name, Color color, int style, String stroke, List list) {
        Element element = new Node();
        element.setName(name);
        element.putChartColor(color);
        element.putChartInflexionStyle(style);
        element.putChartStroke(stroke);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            element.addChartValue(Double.valueOf(list.get(i).toString()).doubleValue());
        }
        box.addElement(element);
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        final JCheckBox checkBox = new JCheckBox("Fill");
        checkBox.setPreferredSize(new Dimension(checkBox.getPreferredSize().width + 5, 20));
        checkBox.setSelected(true);
        checkBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.setAreaFill(checkBox.isSelected());
            }
        });

        final JComboBox combobox = new JComboBox();
        combobox.setPreferredSize(new Dimension(combobox.getPreferredSize().width, 20));
        combobox.addItem("Line");
        combobox.addItem("Ellipse");
        combobox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (combobox.getSelectedItem().toString().equals("Line")) {
                    chart.setRingStyle(TWaverConst.RADAE_RING_STYLE_LINE);
                } else {
                    chart.setRingStyle(TWaverConst.RADAE_RING_STYLE_ELLIPSE);
                }
            }
        });
        toolbar.add(checkBox);
        toolbar.add(combobox);
        return toolbar;
    }
}
