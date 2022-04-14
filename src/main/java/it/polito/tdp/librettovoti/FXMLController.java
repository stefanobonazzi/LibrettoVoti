package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.librettovoti.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;
	
	@FXML
	private ComboBox<Integer> cmbEliminaVoti;
	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private TextField txtNome;

    @FXML
    private Label txtStatus;

    @FXML
    private TextArea txtVoti;

    @FXML
    void handleNuovoVoto(ActionEvent event) {
    	
    	//1. Acquisizione e controllo dati
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();
    	
    	//1.1 Controllo di validità
    	if(nome.equals("") || punti == null) {
    		txtStatus.setText("Errore: occorre inserie nome e voto.");
    		return;
    	}
    	
    	//2. Esecuzione dell'operazione (chidi al modello di farla)
    	boolean ok = model.add(new Voto(nome, punti, LocalDate.now()));
    	
    	//3. Visualizzazione e aggiornamento del risultato
    	if(ok) {
    	List<Voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato " + voti.size() + " esami.\n");
    	for(Voto v: voti)
    		txtVoti.appendText(v.toString() + "\n");
    	
    	txtNome.clear();
    	cmbPunti.setValue(null);
    	txtStatus.setText("");
    	} else {
    		txtStatus.setText("Errore: esame già presente");
    	}
    }

    public void setModel(Libretto model) {
    	this.model = model;
    	
    	List<Voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato " + voti.size() + " esami.\n");
    	for(Voto v: voti)
    		txtVoti.appendText(v.toString() + "\n");
    }
    
   
    @FXML
    void handleMiglioraLibretto(ActionEvent event) {
    	/*
    	Libretto l = model.miglioraLibretto();
    	
    	txtVoti.appendText("\nLibretto migliiorato:\n");
    	for(Voto v: l.getVoti())
    		txtVoti.appendText(v.toString() + "\n");
    	*/
    }
    
    @FXML
    void handleEliminaVoti(ActionEvent event) {
    	/*
    	model.cancellaVotiMinodiDi(cmbEliminaVoti.getValue());
    	
    	List<Voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato " + voti.size() + " esami.\n");
    	for(Voto v: voti)
    		txtVoti.appendText(v.toString() + "\n");
    		*/
    }
    
    
    @FXML
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbPunti.getItems().clear();
        for(int p=18; p<=30; p++) {
        	cmbPunti.getItems().add(p);
        }
        
        cmbEliminaVoti.getItems().clear();
        for(int pp=18; pp<=30; pp++) {
        	cmbEliminaVoti.getItems().add(pp);
        }

    }

}

