package free.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import twaver.ResizableNode;
import twaver.TWaverConst;
import twaver.TWaverUtil;

public class StateNode extends ResizableNode {

    private double c2000;
    private double p2005;
    private double p2010;
    private double p2015;
    private double p2020;
    private double p2025;
    private double p2030;
    private List valueList = new ArrayList();
    private int attachmentDirection = TWaverConst.ATTACHMENT_DIRECTION_TOP_RIGHT;

    public void init(
            double c2000, double p2005, double p2010,
            double p2015, double p2020, double p2025, double p2030) {

        this.c2000 = c2000;
        this.p2005 = p2005;
        this.p2010 = p2010;
        this.p2015 = p2015;
        this.p2020 = p2020;
        this.p2025 = p2025;
        this.p2030 = p2030;

        double sum = c2000 + p2005 + p2010 + p2015 + p2020 + p2025 + p2030;

        valueList.add(new Double(c2000 / sum));
        valueList.add(new Double(p2005 / sum));
        valueList.add(new Double(p2010 / sum));
        valueList.add(new Double(p2015 / sum));
        valueList.add(new Double(p2020 / sum));
        valueList.add(new Double(p2025 / sum));
        valueList.add(new Double(p2030 / sum));

        this.putCustomDrawFillColor(Color.ORANGE);
        this.putBorderColor(Color.YELLOW);
        this.putBorderStroke(TWaverConst.STROKE_SOLID_MIDDLE);
        this.putCustomDrawOutline(false);
        this.putLabelFont(TWaverUtil.getFont(Font.BOLD, 10));
        this.putLabelColor(Color.WHITE);
        this.putLabelHighlightForeground(Color.GREEN);

        int size = (int) (8 + Math.sqrt(c2000 / 300000000) * 150);
        Point point = this.getCenterLocation();
        this.setSize(size, size);
        this.setCenterLocation(point.x, point.y);
    }

    public double getC2000() {
        return c2000;
    }

    public double getP2005() {
        return p2005;
    }

    public double getP2010() {
        return p2010;
    }

    public double getP2015() {
        return p2015;
    }

    public double getP2020() {
        return p2020;
    }

    public double getP2025() {
        return p2025;
    }

    public double getP2030() {
        return p2030;
    }

    public int getAttachmentDirection() {
        return attachmentDirection;
    }

    public void setAttachmentDirection(int attachmentDirection) {
        if (this.attachmentDirection != attachmentDirection) {
            int oldValue = this.attachmentDirection;
            this.attachmentDirection = attachmentDirection;
            this.firePropertyChange("attachmentDirection", oldValue, attachmentDirection);
        }
    }

    public List getValueList() {
        return valueList;
    }
}
