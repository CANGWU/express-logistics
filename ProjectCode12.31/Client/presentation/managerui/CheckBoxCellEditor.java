package managerui;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

import twaver.table.editor.AbstractCellEditor;

class CheckBoxCellEditor extends AbstractCellEditor implements TableCellEditor {
    //~ Static fields/initializers -------------------------------------------------------------------------------------
   
    private static final long serialVersionUID = 1L;
   
    //~ Instance fields ------------------------------------------------------------------------------------------------
   
    protected JCheckBox checkBox;
   
    //~ Constructors ---------------------------------------------------------------------------------------------------
   
    public CheckBoxCellEditor() {
      checkBox = new JCheckBox();
      checkBox.setHorizontalAlignment(SwingConstants.CENTER);
      // checkBox.setBackground( Color.white);
    }
   
    //~ Methods --------------------------------------------------------------------------------------------------------
   
    @Override public Object getCellEditorValue() {
      return Boolean.valueOf(checkBox.isSelected());
    }
   
    //~ ----------------------------------------------------------------------------------------------------------------
   
    @Override public Component getTableCellEditorComponent(
      JTable  table,
      Object  value,
      boolean isSelected,
      int     row,
      int     column) {
      checkBox.setSelected(((Boolean) value).booleanValue());
   
      return checkBox;
   
    }

	@Override
	public void addCellEditorListener(CellEditorListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCellEditable(EventObject arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldSelectCell(EventObject arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}
  } // end class CheckBoxCellEditor
  