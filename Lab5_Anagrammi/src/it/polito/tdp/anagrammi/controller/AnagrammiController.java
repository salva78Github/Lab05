/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.exception.AnagrammiException;
import it.polito.tdp.anagrammi.model.AnagrammiGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="idTxtParola"
    private TextField idTxtParola; // Value injected by FXMLLoader

    @FXML // fx:id="idBtCalcolaAnagrammi"
    private Button idBtCalcolaAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="idTxtAnagrammiCorretti"
    private TextArea idTxtAnagrammiCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="idTxtAnagrammiErrati"
    private TextArea idTxtAnagrammiErrati; // Value injected by FXMLLoader

    @FXML // fx:id="idBtReset"
    private Button idBtReset; // Value injected by FXMLLoader

	private AnagrammiGenerator model;

    @FXML
    void findAnagrammi(ActionEvent event) {
    	
    	String parola = idTxtParola.getText();
    	Set<String> anagrammi = model.findAnagrammi(parola);
    	try{
	    	for(String anagramma : anagrammi){
	    		if(model.isCorrect(anagramma)){
	        		idTxtAnagrammiCorretti.appendText(anagramma + "\n");
	    		}
	    		else{ 	  		
	    			idTxtAnagrammiErrati.appendText(anagramma + "\n");
	    		}	
	    	}
    	} catch(AnagrammiException ae){
    		idTxtAnagrammiErrati.setText(ae.getMessage());
	    }

    }
    
    @FXML
    void reset(ActionEvent event) {
    	idTxtParola.setText("");
    	idTxtAnagrammiCorretti.setText("");
    	idTxtAnagrammiErrati.setText("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert idTxtParola != null : "fx:id=\"idTxtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert idBtCalcolaAnagrammi != null : "fx:id=\"idBtCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert idTxtAnagrammiCorretti != null : "fx:id=\"idTxtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert idTxtAnagrammiErrati != null : "fx:id=\"idTxtAnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert idBtReset != null : "fx:id=\"idBtReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(AnagrammiGenerator model) {
		// TODO Auto-generated method stub
		this.model = model;
	}
}
