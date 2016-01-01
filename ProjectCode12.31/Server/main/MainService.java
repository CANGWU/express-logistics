
import java.rmi.RemoteException;

import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;  
import javafx.stage.Stage;
import link.Helper;  

public class MainService extends Application{
	public static void main(String[] args) {  
		launch(args);  
	}  

	@Override  
	public void start(Stage primaryStage) {  
		primaryStage.setTitle("ELS Service");  
		Button Service = new Button();  
		Service.setText("Start Service");  

		Service.setOnAction(new EventHandler<ActionEvent>() {  
			@Override  
			public void handle(ActionEvent event) { 
				if(Service.getText().equals("Start Service")){
					RMILinking rmi = null;

					try {
						rmi = new RMILinking();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rmi.setRMI();  
					Service.setText("Close Service");
				}else{
					System.exit(0);
				}
			}  
		});  


		DropShadow shadow = new DropShadow();  
		//Adding the shadow when the mouse cursor is on  
		Service.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {  
			Service.setEffect(shadow);  
		});  

		//Removing the shadow when the mouse cursor is off  
		Service.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {  
			Service.setEffect(null);  
		});  

		StackPane root = new StackPane();  
		root.getChildren().add(Service);;  
		primaryStage.setScene(new Scene(root, 300, 250));  
		//       primaryStage.show(); 



		primaryStage.show(); 
	}  
}  