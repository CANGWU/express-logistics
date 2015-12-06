package free.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import twaver.PopupMenuGenerator;
import twaver.TView;
import twaver.TWaverConst;
import twaver.chart.LineChart;

public class HistoryChart extends LineChart {

    private int valuesCount = 0;
    private LineChart rangeChart = null;
    private LineChart volumeChart = null;
    private Point startPoint = null;
    private Point endPoint = null;
    private Point lastPoint = null;

    public void paintChart(Graphics2D g2d, int width, int height) {
        super.paintChart(g2d, width, height);
        if (startPoint != null && endPoint != null) {
            Rectangle bounds = this.getBackgroundBounds();
            g2d.setColor(new Color(0, 255, 0, 128));
            int x = Math.min(startPoint.x, endPoint.x);
            int y = bounds.y;
            int w = Math.abs(endPoint.x - startPoint.x);
            int h = bounds.height;
            g2d.fillRect(x, y, w, h);
        }
    }

    private boolean isValidEvent(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Rectangle bounds = this.getBackgroundBounds();
            bounds.grow(1, 1);
            if (bounds.contains(e.getPoint())) {
                return true;
            }
        }
        return false;
    }

    private boolean isInsideEvent(MouseEvent e) {
        if (startPoint != null && endPoint != null) {
            if (e.getX() >= startPoint.x && e.getX() <= endPoint.getX()) {
                return true;
            }
            if (e.getX() >= endPoint.x && e.getX() <= startPoint.getX()) {
                return true;
            }
        }
        return false;
    }

    public void mousePressed(MouseEvent e) {
        lastPoint = null;
        if (isValidEvent(e)) {
            if (isInsideEvent(e)) {
                this.lastPoint = e.getPoint();
            } else {
                this.startPoint = e.getPoint();
                this.endPoint = e.getPoint();
                this.lastPoint = null;
            }
            this.changeRange();
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (isValidEvent(e) && this.startPoint != null) {
            if (lastPoint != null) {
                int offset = this.lastPoint.x - e.getX();
                this.startPoint.x -= offset;
                this.endPoint.x -= offset;
                this.lastPoint = e.getPoint();
            } else {
                this.endPoint = e.getPoint();
            }
            this.changeRange();
        }
    }

    private void changeRange() {
        this.getChartPane().repaint();

        if (this.startPoint.x == this.endPoint.x) {
            this.rangeChart.setStartIndex(0);
            this.rangeChart.setEndIndex(Integer.MAX_VALUE);
            this.volumeChart.setStartIndex(0);
            this.volumeChart.setEndIndex(Integer.MAX_VALUE);
            this.rangeChart.setXScaleTextSpanCount(30);
            this.volumeChart.setXScaleTextSpanCount(30);
        } else {
            double x1 = this.getStartX();
            double x2 = this.getEndX();
            double w = (x2 - x1) / (this.valuesCount - 1);
            int s = (int) ((startPoint.x - x1) / w);
            int e = (int) ((endPoint.x - x1) / w);
            if (s > e) {
                int tmp = e;
                e = s;
                s = tmp;
            }
            if (s < 0) {
                s = 0;
            }
            if (e > this.valuesCount) {
                e = this.valuesCount;
            }

            this.rangeChart.setStartIndex(s);
            this.rangeChart.setEndIndex(e);
            this.volumeChart.setStartIndex(s);
            this.volumeChart.setEndIndex(e);

            int span = Math.max(1, 15 * (e - s) / rangeChart.getBackgroundBounds().width - 1);
            this.rangeChart.setXScaleTextSpanCount(span);
            this.volumeChart.setXScaleTextSpanCount(span);
        }

    }

    public HistoryChart(LineChart rangeChart, LineChart volumeChart, int valuesCount) {
        this.rangeChart = rangeChart;
        this.volumeChart = volumeChart;
        this.valuesCount = valuesCount;
        this.setEnableXTranslate(false);
        this.setEnableXZoom(false);
        this.setEnableYTranslate(false);
        this.setEnableYZoom(false);
        this.setLineType(TWaverConst.LINE_TYPE_AREA);
        this.setValueSpanCount(7);
        this.setXScaleTextSpanCount(35);
        this.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
        this.setLowerLimit(0);
        this.setYScaleTextVisible(true);
        this.setYScaleValueGap(100);
        this.setLegendLayout(TWaverConst.LEGEND_LAYOUT_VERTICAL);
        this.getLegendPane().setVisible(false);
        this.setEnableToolTipText(false);

        this.setPopupMenuGenerator(new PopupMenuGenerator() {

            public JPopupMenu generate(TView tview, MouseEvent mouseEvent) {
                JPopupMenu popup = new JPopupMenu();
                popup.add(createMenuItem(1, 15));
                popup.add(createMenuItem(3, 30));
                popup.add(createMenuItem(7, 35));
                popup.add(createMenuItem(15, 45));
                popup.add(createMenuItem(30, 60));
                popup.add(createMenuItem(60, 60));
                popup.add(createMenuItem(120, 120));
                return popup;
            }
        });
    }

    private JMenuItem createMenuItem(final int valueSpanCount, final int textSpanCount) {
        JMenuItem item = new JMenuItem("Value Span:" + valueSpanCount + "|Text Span:" + textSpanCount);
        item.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                HistoryChart.this.setValueSpanCount(valueSpanCount);
                HistoryChart.this.setXScaleTextSpanCount(textSpanCount);
            }
        });
        return item;
    }
}
