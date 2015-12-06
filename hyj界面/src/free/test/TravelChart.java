package free.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JToolBar;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.BarChart;

public class TravelChart extends Portlet {

    private TDataBox box = new TDataBox();
    private BarChart chart = new BarChart(box);

    public TravelChart() {
        super.initialize(chart);
        chart.setTitle("Travel expenditure on legisure trips");
        chart.setBarType(TWaverConst.BAR_TYPE_LAYER);
        chart.setShadowOffset(0);
        chart.setSelectedOffset(0);
        chart.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
        chart.setXScaleTextColor(Color.CYAN.darker());

        chart.addXScaleText("Europe");
        chart.addXScaleText("Oceania");
        chart.addXScaleText("North America");
        chart.addXScaleText("<html>Africa<br>Central America<br>South America</html>");
        chart.addXScaleText("<html>HK<br>Macao</html>");
        chart.addXScaleText("Other Asian regions");

        Element before = new Node();
        Element total = new Node();

        before.putChartColor(new Color(102, 153, 255).darker());
        total.putChartColor(new Color(102, 153, 255));

        before.setName("Before the trip");
        total.setName("Total");

        before.putChartValueTextPosition(TWaverConst.POSITION_CENTER);

        before.addChartValue(2108);
        before.addChartValue(2369);
        before.addChartValue(1475);
        before.addChartValue(1826);
        before.addChartValue(459);
        before.addChartValue(821);

        total.addChartValue(5253);
        total.addChartValue(4978);
        total.addChartValue(3786);
        total.addChartValue(2991);
        total.addChartValue(2185);
        total.addChartValue(1904);

        box.addElement(before);
        box.addElement(total);

    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        final JComboBox comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension(comboBox.getPreferredSize().width, 20));
        comboBox.addItem("Group");
        comboBox.addItem("Stack");
        comboBox.addItem("Layer");
        comboBox.addItem("PerCent");
        comboBox.setSelectedIndex(2);
        comboBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (comboBox.getSelectedItem().toString().equals("Group")) {
                    chart.setBarType(TWaverConst.BAR_TYPE_GROUP);
                } else if (comboBox.getSelectedItem().toString().equals("Stack")) {
                    chart.setBarType(TWaverConst.BAR_TYPE_STACK);
                } else if (comboBox.getSelectedItem().toString().equals("Layer")) {
                    chart.setBarType(TWaverConst.BAR_TYPE_LAYER);
                } else if (comboBox.getSelectedItem().toString().equals("PerCent")) {
                    chart.setBarType(TWaverConst.BAR_TYPE_PERCENT);
                }
            }
        });
        toolbar.add(comboBox);

        return toolbar;
    }
}
