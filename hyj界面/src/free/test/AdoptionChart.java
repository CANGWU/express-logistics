package free.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;

public class AdoptionChart extends Portlet {

    private TDataBox box = new TDataBox();
    private BarChart chart = new BarChart(box);

    public AdoptionChart() {
        super.initialize(chart);
        chart.setTitle("Enterprise 2.0 Adoption");
        chart.setYAxisText("<html>North American and European IT<br>decision-makers at enterprises and SMBs</html>");
        chart.setBarType(TWaverConst.BAR_TYPE_PERCENT);
        chart.addXScaleText("Small");
        chart.addXScaleText("Medium-Small");
        chart.addXScaleText("Medium-Large");
        chart.addXScaleText("Large");
        chart.addXScaleText("Very-Large");
        chart.addXScaleText("Global2000");
        chart.setValueTextCenter(true);
        addElement("Not Considering", 0.68, 0.58, 0.52, 0.44, 0.44, 0.37, Color.GREEN.darker().darker());
        addElement("Considering Only", 0.12, 0.16, 0.15, 0.15, 0.16, 0.12, Color.GREEN.darker());
        addElement("Buying", 0.2, 0.26, 0.33, 0.41, 0.40, 0.51, Color.GREEN);
    }

    public void addElement(String name, double v1, double v2, double v3, double v4, double v5, double v6, Color color) {
        Element node = new Node();
        node.putChartColor(color);
        node.setName(name);
        node.addChartValue(v1);
        node.addChartValue(v2);
        node.addChartValue(v3);
        node.addChartValue(v4);
        node.addChartValue(v5);
        node.addChartValue(v6);
        box.addElement(node);
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        final JCheckBox checkBox = new JCheckBox("Value");
        checkBox.setPreferredSize(new Dimension(checkBox.getPreferredSize().width + 5, 20));
        checkBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.setPercentTypeValueVisible(checkBox.isSelected());
            }
        });
        toolbar.add(checkBox);
        JLabel label = new JLabel("Bundle:");
        toolbar.add(label);
        final JComboBox combobox = new JComboBox();
        combobox.setPreferredSize(new Dimension(combobox.getPreferredSize().width, 20));
        combobox.setLightWeightPopupEnabled(true);
        combobox.addItem("1");
        combobox.addItem("2");
        combobox.addItem("3");
        toolbar.add(combobox);
        combobox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                chart.setBundleSize((new Integer(combobox.getSelectedItem().toString())).intValue());
            }
        });
        return toolbar;
    }
}
