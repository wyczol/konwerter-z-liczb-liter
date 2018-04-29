package application;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;

public class PracaDomowa extends Application  {
	
	static Codec codec = new Codec();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Label label1 = new Label("Zrodlo:");
			Label label2 = new Label("Wynik Operacji:");
			Label label3 = new Label("Operacja:");
			label1.setFont(Font.font("TimesNewRoman", 13));
			label2.setFont(Font.font("TimesNewRoman", 13));
			label3.setFont(Font.font("TimesNewRoman", 13));
			Button przycisk1 = new Button("Kopiuj");
			Button przycisk2 = new Button("Wykonaj");
			RadioButton r1 = new RadioButton("kodowanie");
			RadioButton r2 = new RadioButton("dekodowanie");
			BorderPane root = new BorderPane();
			


			VBox left_vbox = new VBox(10);

			left_vbox.getChildren().add(label1);

			TextField text1 = new TextField();
			TextField text2 = new TextField();
			text1.getStyleClass().add("my-field");
			text2.getStyleClass().add("my-field");
			left_vbox.getChildren().add(text1);

			left_vbox.getChildren().add(label2);
			left_vbox.getChildren().add(przycisk1);
			left_vbox.getChildren().add(text2);
			left_vbox.getChildren().add(przycisk2);
			root.setLeft(left_vbox);
			
			VBox rightV_box = new VBox(10);
			root.setRight(rightV_box);
			rightV_box.getChildren().add(label3);
			rightV_box.getChildren().add(r1);
			rightV_box.getChildren().add(r2);
			
			ToggleGroup tgroup = new ToggleGroup();
			r1.setToggleGroup(tgroup);
			r2.setToggleGroup(tgroup);
			
			przycisk1.setOnAction (event -> {
			
						String plainText = text2.getText();
						text1.setText(plainText);
						text2.clear();
				if (tgroup.getSelectedToggle() != null) {
					System.out.println(tgroup.getSelectedToggle().getUserData().toString());
					
					
				}
			});
			
			przycisk2.setOnAction(event -> {
				
				
			    	  if (tgroup.getSelectedToggle() !=r2) {
			    		  text2.setText(codec.encode(text1.getText()));
			         }
			      
			     
			      if (tgroup.getSelectedToggle() !=r1) {
			    	  text2.setText(codec.decode(text1.getText()));
			    	  
					        
					  }
				
					
			      }
			   
				
			
			);
			Scene scene = new Scene(root, 400, 300);
			scene.getStylesheets().add(getClass().getResource("mojStyl.css").toExternalForm());
			primaryStage.setTitle("Przelicznik");
			primaryStage.setScene(scene);
			primaryStage.show();}
		catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}

	public static void main(String[] args) {
		launch(args);

	}

}
