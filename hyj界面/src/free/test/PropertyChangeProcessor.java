package free.test;

import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import twaver.TWaverConst;
import twaver.network.TNetwork;

public class PropertyChangeProcessor implements PropertyChangeListener {

    TNetwork network;

    public PropertyChangeProcessor(TNetwork network) {
        this.network = network;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (!(evt.getSource() instanceof StateNode)) {
            return;
        }
        StateNode node = (StateNode) evt.getSource();
        String name = evt.getPropertyName();
        // add or remove attachment
        if (name.equals(TWaverConst.PROPERTYNAME_SELECTED)) {
            if (node.containsAttachment("population")) {
                node.removeAttachment("population");
            } else {
                node.addAttachment("population");
            }
        }
        // adjust attachment direction
        if (name.equals(TWaverConst.PROPERTYNAME_SELECTED)
                || name.equals(TWaverConst.PROPERTYNAME_LOCATION)) {
            Point location = node.getCenterLocation();
            Point center = network.getLogicalCenterPoint();
            if (location.x > center.x && location.y < center.y) {
                node.setAttachmentDirection(TWaverConst.ATTACHMENT_DIRECTION_BOTTOM_LEFT);
            } else if (location.x > center.x && location.y > center.y) {
                node.setAttachmentDirection(TWaverConst.ATTACHMENT_DIRECTION_TOP_LEFT);
            } else if (location.x < center.x && location.y < center.y) {
                node.setAttachmentDirection(TWaverConst.ATTACHMENT_DIRECTION_BOTTOM_RIGHT);
            } else {
                node.setAttachmentDirection(TWaverConst.ATTACHMENT_DIRECTION_TOP_RIGHT);
            }
        }
    }
}
