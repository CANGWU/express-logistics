package free.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.chart.LineChart;

public class MobileChart extends Portlet {

    private Element developedElement = new Node();
    private Element developingElement = new Node();
    private Element worldElement = new Node();
    private TDataBox box = new TDataBox();
    private LineChart chart = new LineChart(box);

    public MobileChart() {
        super.initialize(chart);
        chart.setTitle("<html>Mobile Cellular Telephone Subscribers<br><center>Per 100 Inhabitants,1994~2006</center></html>");
        chart.setLowerLimit(0);
        chart.setUpperLimit(100);
        chart.setYScaleValueGap(20);
        chart.setYScaleTextVisible(true);
        chart.setXScaleLineVisible(true);
        chart.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_LEFT);
        chart.setXGap(15);
        chart.setYGap(15);
        chart.setValueTextVisible(true);
        chart.setValueTextFont(TUIManager.getDefaultFont().deriveFont(9f));
        chart.setInflexionVisible(true);

        addElement(developedElement, "Developed", Color.BLUE, TWaverConst.INFLEXION_STYLE_TRIANGLE);
        addElement(worldElement, "World", Color.RED, TWaverConst.INFLEXION_STYLE_RECTANGLE);
        addElement(developingElement, "Developing", Color.GREEN, TWaverConst.INFLEXION_STYLE_DIAMOND);

        this.addValue("1994", 5.2, 1.0, 0.19);
        this.addValue("1995", 8.2, 1.6, 0.4);
        this.addValue("1996", 12.7, 2.5, 0.6);
        this.addValue("1997", 17.6, 3.7, 1.1);
        this.addValue("1998", 24.6, 5.4, 1.9);
        this.addValue("1999", 35.3, 8.2, 3.2);
        this.addValue("2000", 49.6, 12.2, 5.4);
        this.addValue("2001", 58.5, 15.7, 8.0);
        this.addValue("2002", 64.7, 18.8, 10.8);
        this.addValue("2003", 69.6, 22.6, 14.2);
        this.addValue("2004", 76.8, 27.7, 19.1);
        this.addValue("2005", 85.2, 34.4, 25.6);
        this.addValue("2006", 90.9, 41.0, 32.4);

    }

    private void addElement(Element element, String name, Color color, int style) {
        element.setName(name);
        element.putChartColor(color);
        element.putChartInflexionStyle(style);
        box.addElement(element);
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        final JCheckBox showText = new JCheckBox("Text");
        showText.setPreferredSize(new Dimension(showText.getPreferredSize().width + 5, 20));
        showText.setSelected(true);
        showText.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.setValueTextVisible(showText.isSelected());
            }
        });

        final JCheckBox inflexion = new JCheckBox("Inflexion");
        inflexion.setPreferredSize(new Dimension(inflexion.getPreferredSize().width + 5, 20));
        inflexion.setSelected(true);
        inflexion.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                chart.setInflexionVisible(inflexion.isSelected());
            }
        });

        final JComboBox lineType = new JComboBox();
        lineType.addItem("Default");
        lineType.addItem("Area");
        lineType.addItem("Pole");
        lineType.setPreferredSize(new Dimension(lineType.getPreferredSize().width, 20));
        lineType.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                int index = lineType.getSelectedIndex();
                switch (index) {
                    case 0:
                        chart.setLineType(TWaverConst.LINE_TYPE_DEFAULT);
                        break;
                    case 1:
                        chart.setLineType(TWaverConst.LINE_TYPE_AREA);
                        break;
                    case 2:
                        chart.setLineType(TWaverConst.LINE_TYPE_POLE);
                        break;
                }
            }
        });
        lineType.setSelectedIndex(0);

        toolbar.add(showText);
        toolbar.add(inflexion);
        toolbar.add(lineType);
        return toolbar;
    }

    private void addValue(String year, double developed, double world, double developing) {
        chart.addXScaleText(year);
        this.developedElement.addChartValue(developed);
        this.worldElement.addChartValue(world);
        this.developingElement.addChartValue(developing);
    }
}
