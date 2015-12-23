package transportui;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

class FormattedTextFieldVerifier extends InputVerifier{
	   public boolean verify(JComponent component){
	      JFormattedTextField field = (JFormattedTextField) component;
	      //若用户的输入符合格式，则返回true，否则返回false
	      return field.isEditValid();
	   }
	}




