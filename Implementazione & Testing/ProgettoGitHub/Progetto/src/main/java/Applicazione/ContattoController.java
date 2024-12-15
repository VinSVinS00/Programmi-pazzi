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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContattoController implements Initializable {

    @FXML
    private Button salva;
    @FXML
    private Button ann;
    @FXML
    private TextField Fnome;
    @FXML
    private TextField Fcognome;
    @FXML
    private TextField Fnumero;
    @FXML
    private TextField Femail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void salva(ActionEvent event) throws IOException
    {
        String nome=Fnome.getText();
        String cognome=Fcognome.getText();
        String numero=Fnumero.getText();
        String email=Femail.getText();
        
        Alert alertName = new Alert(Alert.AlertType.INFORMATION);
        alertName.setTitle("ERRORE");
        alertName.setHeaderText("Errore inserimento");
        alertName.setContentText("Campo nome non compilato");
        
        Alert alertNum = new Alert(Alert.AlertType.INFORMATION);
        alertNum.setTitle("ERRORE");
        alertNum.setHeaderText("Errore inserimento");
        alertNum.setContentText("Campo numero non compilato");
        
        Alert alertMail = new Alert(Alert.AlertType.INFORMATION);
        alertMail.setTitle("ERRORE");
        alertMail.setHeaderText("Errore inserimento");
        alertMail.setContentText("La mail inserita non è valida");
        
        if(Fnome.getText().isEmpty()){
            if(alertName.showAndWait().get() == ButtonType.OK){
            }
        }

        else if(Fnumero.getText().isEmpty()){
            if(alertNum.showAndWait().get() == ButtonType.OK){
            }
        }
        
        else if(!Femail.getText().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            if(alertMail.showAndWait().get() == ButtonType.OK){
            }
        }
        
        else
        {
        try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="INSERT INTO contatto (nome, cognome, numero, mail, numero2, mail2, numero3 ,mail3, preferito) VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            pst.setString(1, nome);
            pst.setString(2, cognome);
            pst.setString(3, numero);
            pst.setString(4, email);
            pst.setString(5, "");
            pst.setString(6, "");
            pst.setString(7, "");
            pst.setString(8, "");
            pst.setInt(9, 0);
            
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
         Parent root = FXMLLoader.load(getClass().getResource("Rubrica.fxml"));
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }
    
    
     public void annulla(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Rubrica.fxml"));
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }
}
