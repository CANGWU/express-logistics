package managerui;

import java.awt.Component;  
import javax.swing.JTable;  
import javax.swing.table.TableCellRenderer;  
  
class CheckBoxRenderer implements TableCellRenderer {  
  
    public CheckBoxRenderer(JTable table) {
		// TODO Auto-generated constructor stub
    	
	}

	

	public Component getTableCellRendererComponent(JTable table, Object value,  
            boolean isSelected, boolean hasFocus, int row, int column) {  
        if (value == null)  
            return null;  
        return (Component) value;  
    }  
}  
