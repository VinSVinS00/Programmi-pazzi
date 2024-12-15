/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applicazione;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author senat
 */
public class PreferitiController implements Initializable {

    @FXML
    private TableView<Contatto> Preferiti;
    @FXML
    private TableColumn<Contatto,String> Tnome;
    @FXML
    private TableColumn<Contatto,String> Tcognome;
    @FXML
    private TableColumn<Contatto,String> Tnumero;
    @FXML
    private TableColumn<Contatto,String> Tmail;
    @FXML
    private Button rmv;
    @FXML
    private Button rtn;

    private ObservableList<Contatto> prefe= FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tnome.setCellValueFactory(new PropertyValueFactory("nome"));
        Tcognome.setCellValueFactory(new PropertyValueFactory("cognome"));
        Tnumero.setCellValueFactory(new PropertyValueFactory("numero"));
        Tmail.setCellValueFactory(new PropertyValueFactory("mail"));
        
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM contatto WHERE preferito='1' ORDER BY nome ";  //seleziono tutti i contatti con il campo "preferito = 1" ordinati per il nome
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
           
            Preferiti.setItems(prefe);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                prefe.add(new Contatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("numero"),rs.getString("mail"),rs.getString("numero2"),rs.getString("mail2"),rs.getString("numero3"),rs.getString("mail3"),rs.getInt("preferito")));
            }
            }catch(Exception e)
        {
          

        }
    }    
    
    
    public void rimuovi(ActionEvent event)
    {
        if(event.getSource() == rmv){
            try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery=  "UPDATE public.contatto SET preferito=?  WHERE numero='"+Preferiti.getSelectionModel().getSelectedItem().getNumero()+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            pst.setInt(1, 0);
           
            ResultSet rs=pst.executeQuery();
            if(!rs.next()){
                System.out.println("errore");
            }
            else{
                System.out.println("registrato");
            }
            }catch(Exception e)
        {
          

        }
        }
        prefe.remove(Preferiti.getSelectionModel().getSelectedItem());
    }
    
    
    
    
    public void ritorna(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Rubrica.fxml"));
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }
    
}
