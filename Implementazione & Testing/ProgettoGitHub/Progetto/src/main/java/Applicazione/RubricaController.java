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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author senat
 */
public class RubricaController implements Initializable {

    
    @FXML
    private Button add;
    @FXML
    private Button rmv;
    @FXML
    private Button show;
    @FXML
    private Button mod;
    @FXML
    private Button arc;
    @FXML
    private Button showA;
    @FXML
    private Button prefe;
    @FXML
    private TextField TXfind;
    
    @FXML
    private TableView<Contatto> Rubrica;
    @FXML
    private TableColumn<Contatto,String> Tnome;
    @FXML
    private TableColumn<Contatto,String> Tcognome;
    @FXML
    private TableColumn<Contatto,String> Tnumero;
    @FXML
    private TableColumn<Contatto,String> Tmail;
    
    private ObservableList<Contatto> contats= FXCollections.observableArrayList();
    
    private Parent root1;
    
   
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        Tnome.setCellValueFactory(new PropertyValueFactory("nome"));
        Tcognome.setCellValueFactory(new PropertyValueFactory("cognome"));
        Tnumero.setCellValueFactory(new PropertyValueFactory("numero"));
        Tmail.setCellValueFactory(new PropertyValueFactory("mail"));
        
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM contatto ORDER BY nome ";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
           
            Rubrica.setItems(contats);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                contats.add(new Contatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("numero"),rs.getString("mail"),rs.getString("numero2"),rs.getString("mail2"),rs.getString("numero3"),rs.getString("mail3"),rs.getInt("preferito")));
            }
            
            
            FilteredList<Contatto> filterData =new FilteredList<>(contats,b->true);
            TXfind.textProperty().addListener((observable,oldValue,newValue)->{
             filterData.setPredicate(Contatto -> {
                 if(newValue.isEmpty() || newValue== null ){
                     return true;
                 }
                 String search=newValue.toLowerCase();
                 
                 if(Contatto.getNome().toLowerCase().indexOf(search)>-1){
                     return true;
                 }else if(Contatto.getCognome().toLowerCase().indexOf(search)>-1){
                     return true;
                 }else if(Contatto.getNumero().toLowerCase().indexOf(search)>-1){
                     return true;
                 }else return false;
             });
             
            });
            
            SortedList<Contatto> sortedData=new SortedList<>(filterData);
            sortedData.comparatorProperty().bind(Rubrica.comparatorProperty());
            Rubrica.setItems(sortedData);
            
        }catch(Exception e)
        {
          

        }
        
        
        
    }    
    
    
    
    public void add(ActionEvent e) throws IOException
    {
         Parent root = FXMLLoader.load(getClass().getResource("Contatto1.fxml"));
        
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @FXML
    public void elimina(ActionEvent event) {
        if(event.getSource() == rmv)
        {
            try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="DELETE FROM contatto WHERE numero='"+Rubrica.getSelectionModel().getSelectedItem().getNumero()+"' ";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
           
            Rubrica.setItems(contats);
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
         contats.remove(Rubrica.getSelectionModel().getSelectedItem());

        }
        
    public void show(ActionEvent e) throws IOException
    {
        if(e.getSource() == show){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Mostra.fxml"));
        
        root1=loader.load();
        
        MostraController scena2=loader.getController();
        
        scena2.mostra(Rubrica.getSelectionModel().getSelectedItem().getNumero());
        
        
        
        /*Parent root = FXMLLoader.load(getClass().getResource("Mostra.fxml"));*/
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    }
     
    
    
    public void modify(ActionEvent e) throws IOException
    {
        if(e.getSource() == mod){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Modifica.fxml"));
        
        
        root1=loader.load();
        
        ModificaController scena2=loader.getController();
        
        scena2.mostra(Rubrica.getSelectionModel().getSelectedItem().getNumero());
        
        
        
        /*Parent root = FXMLLoader.load(getClass().getResource("Mostra.fxml"));*/
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    }
    
    
    
        public void archivia(ActionEvent e) throws IOException
        {
            if(e.getSource() == arc){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Archivio.fxml"));
        root1=loader.load();
        ArchivioController scena2=loader.getController();
        scena2.archivia(Rubrica.getSelectionModel().getSelectedItem().getNumero());
         contats.remove(Rubrica.getSelectionModel().getSelectedItem());
        }
            
        }
        
         public void showArchivio(ActionEvent e) throws IOException
    {
         if(e.getSource() == showA){ 
        Parent root = FXMLLoader.load(getClass().getResource("Archivio.fxml"));
        
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    }
         
         public void preferiti(ActionEvent e) throws IOException
    {
        if(e.getSource() == prefe){ 
        Parent root = FXMLLoader.load(getClass().getResource("Preferiti.fxml"));
        
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    }

    public void setContats(Contatto contatto){
        contats.add(contatto);
    }
}

