package free.test;

import twaver.TWaverConst;
import twaver.chart.LineChart;

public class VolumeChart extends LineChart {

    public VolumeChart() {
        this.setEnableYTranslate(false);
        this.setEnableYZoom(false);
        this.setLineType(TWaverConst.LINE_TYPE_POLE);
        this.setLowerLimit(0);
        this.setXScaleTextSpanCount(30);
        this.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
    }
}
