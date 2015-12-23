package managerui;


import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
public class MyJcom extends JComboBox implements TableCellRenderer{
        // privatestatic final long serialVersionUID = -8624401777277852691L;
         public MyJcom(){
                   super();
                   addItem("ÄÐ");
                   addItem("Å®");
         }
         public Component getTableCellRendererComponent(JTable table, Object value,
                            boolean isSelected, boolean hasFocus, int row, int column) {
                   if(isSelected){
                            setForeground(table.getForeground());
                            super.setBackground(table.getBackground());
                   }else{
                            setForeground(table.getForeground());
                            setBackground(table.getBackground());
                   }
                   boolean isMale = ((Boolean)value).booleanValue();
                   setSelectedIndex(isMale? 0 : 1);
                   return this;
         }
}

	