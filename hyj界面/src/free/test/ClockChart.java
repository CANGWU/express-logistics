package free.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import twaver.Element;
import twaver.EnumType;
import twaver.EnumTypeManager;
import twaver.Node;
import twaver.TDataBox;
import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.TaskAdapter;
import twaver.TaskScheduler;
import twaver.chart.DialChart;

public class ClockChart extends Portlet {

    private Element hour;
    private Element minute;
    private Element second;
    private TDataBox box = new TDataBox();
    private DialChart chart = new DialChart(box) {

        public String getToolTipText(Element element) {
            double value = element.getChartValue();
            if (element == hour) {
                return element.getName() + ":" + (int) (value);
            }
            return element.getName() + ":" + (int) (value * 5);
        }
    };

    public ClockChart() {
        super.initialize(chart);
        chart.setTitle("Clock");
        chart.setStartAngle(-90);
        chart.setEndAngle(270);
        chart.setMaxValue(12);
        chart.setScaleMajorCount(12);
        chart.setScaleMinorCount(4);
        chart.setScaleInside(true);
        chart.setScaleLength(12);
        chart.setScaleStyle(TWaverConst.DIAL_SCALE_STYLE_LINE);
        chart.setBallSize(8);
        chart.getLegendPane().setVisible(false);
        chart.setRingFillColor(Color.DARK_GRAY);
        chart.setRingGradientColor(Color.LIGHT_GRAY);
        chart.setRingGradientFactory(TWaverConst.GRADIENT_RADIAL_C);
        chart.setRingStroke(TWaverConst.STROKE_SOLID_5);
        chart.setValueTextVisible(false);

        Calendar calendar = Calendar.getInstance();
        double secondValue = calendar.get(Calendar.SECOND);
        double minuteValue = calendar.get(Calendar.MINUTE) + secondValue / 60d;
        double hourValue = calendar.get(Calendar.HOUR) + minuteValue / 60;

        hour = new Node();
        hour.setName("hour");
        hour.putChartDialHandLength(0.7);
        hour.putChartDialHandStyle(TWaverConst.DIAL_HAND_STYLE_ARROW);
        hour.putChartValue(hourValue);
        hour.putChartColor(Color.GREEN.darker());
        hour.putChartStroke(TWaverConst.STROKE_SOLID_6);

        minute = new Node();
        minute.setName("minute");
        minute.putChartDialHandLength(0.8);
        minute.putChartDialHandStyle(TWaverConst.DIAL_HAND_STYLE_TRIANGLE);
        minute.putChartValue(minuteValue / 5);
        minute.putChartColor(Color.ORANGE);
        minute.putChartStroke(TWaverConst.STROKE_SOLID_12);

        second = new Node();
        second.setName("second");
        second.putChartDialHandLength(0.9);
        second.putChartDialHandStyle(TWaverConst.DIAL_HAND_STYLE_LINE);
        second.putChartValue(secondValue / 5);
        second.putChartColor(Color.BLACK);
        box.addElement(hour);
        box.addElement(minute);
        box.addElement(second);

        TaskScheduler.getInstance().register(new TaskAdapter() {

            public int getInterval() {
                return 1000;
            }

            public void run(long clock) {
                if (!isRunning()) {
                    return;
                }
                Calendar calendar = Calendar.getInstance();
                double secondValue = calendar.get(Calendar.SECOND);
                double minuteValue = calendar.get(Calendar.MINUTE) + secondValue / 60d;
                double hourValue = calendar.get(Calendar.HOUR) + minuteValue / 60;
                hour.putChartValue(hourValue);
                minute.putChartValue(minuteValue / 5);
                second.putChartValue(secondValue / 5);
            }
        });
    }

    public JToolBar getControlPanel() {
        JToolBar toolbar = super.getControlPanel();
        toolbar.add(getRunButton());
        final JComboBox combobox = new JComboBox();
        final BasicComboBoxRenderer renderer = new BasicComboBoxRenderer();
        TWaverUtil.setHorizontalAlignment(renderer, TUIManager.getString(TWaverConst.TABLE_ALIGNMENT_ENUMTYPE));
        combobox.setRenderer(new ListCellRenderer() {

            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String text = null;
                Icon icon = null;
                Color background = null;
                Color foreground = null;
                if (value instanceof EnumType) {
                    EnumType enumType = (EnumType) value;
                    text = enumType.toString();
                    icon = enumType.getIcon();
                    background = enumType.getBackground();
                    foreground = enumType.getForeground();
                    if (background != null && isSelected) {
                        background = background.darker();
                    }
                }
                renderer.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
                renderer.setIcon(icon);
                renderer.setToolTipText(text);
                if (foreground != null) {
                    renderer.setForeground(foreground);
                }
                if (background != null) {
                    renderer.setBackground(background);
                }
                return renderer;
            }
        });
        combobox.setPreferredSize(new Dimension(combobox.getPreferredSize().width, 20));
        final Object[] gradientTypes = EnumTypeManager.getInstance().getEnumTypes(TWaverConst.ENUM_GRADIENT);
        final int length = gradientTypes.length;
        for (int i = 0; i < length; i++) {
            EnumType enumeration = (EnumType) gradientTypes[i];
            combobox.addItem(enumeration);
            if (TWaverConst.GRADIENT_RADIAL_C == ((Integer) (enumeration.getValue())).intValue()) {
                combobox.setSelectedIndex(i);
            }
        }
        combobox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                Object object = combobox.getSelectedItem();
                for (int i = 0; i < length; i++) {
                    EnumType enumeration = (EnumType) gradientTypes[i];
                    if (enumeration == object) {
                        chart.setRingGradientFactory(((Integer) (enumeration.getValue())).intValue());
                    }
                }
            }
        });
        toolbar.add(combobox);
        return toolbar;
    }
}
