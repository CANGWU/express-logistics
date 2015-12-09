package free.test;

import twaver.TWaverConst;
import twaver.chart.LineChart;

public class RangeChart extends LineChart {

    public RangeChart() {
        this.setEnableXTranslate(false);
        this.setEnableXZoom(false);
        this.setXScaleTextSpanCount(30);
        this.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
    }
}
