/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicazioneTest;

import Applicazione.ArchivioController;
import Applicazione.Contatto;
import Applicazione.MostraController;
import Applicazione.RubricaController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giuse
 */
public class TestIntegrazione {
    
    public TestIntegrazione() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void TestFlusso() throws IOException {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com" ,0);
        RubricaController rubrica = new RubricaController();
        rubrica.setContats(contatto);
        
        try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM rubrica WHERE numero='"+contatto.getNumero()+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            ResultSet rs=pst.executeQuery();
            
                
                assertEquals(rs.getString("nome"),contatto.getNome());
                assertEquals(rs.getString("cognome"),contatto.getCognome());
                assertEquals(rs.getString("numero"),contatto.getNumero());
                assertEquals(rs.getString("numero2"),contatto.getNumero2());
                assertEquals(rs.getString("numero3"),contatto.getNumero3());
                assertEquals(rs.getString("mail"),contatto.getMail());
                assertEquals(rs.getString("mail2"),contatto.getMail2());
                assertEquals(rs.getString("mail3"),contatto.getMail3());
                assertTrue(rs.getInt("preferito")==contatto.getPreferito());
            }catch(Exception e){}
        
        ArchivioController instance = new ArchivioController();
        
        instance.archivia(contatto.getNumero());
        
        Contatto temp;
        temp = null;
        
            try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM archivio WHERE numero='"+contatto.getNumero()+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            ResultSet rs=pst.executeQuery();
            
                while(rs.next())
                { 
                    temp=new Contatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("numero"),rs.getString("mail"),rs.getString("numero2"),rs.getString("mail2"),rs.getString("numero3"),rs.getString("mail3"), rs.getInt("preferito"));
                
                }
                assertEquals("123456789",temp.getNumero());
            }catch(Exception e){}
            
        MostraController show = new MostraController();
        show.mostra(contatto.getNumero());
        
        try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM contatto WHERE numero='"+contatto.getNumero()+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            ResultSet rs=pst.executeQuery();
            
                while(rs.next())
                { 
                assertEquals(rs.getString("nome"),contatto.getNome());
                assertEquals(rs.getString("cognome"),contatto.getCognome());
                assertEquals(rs.getString("numero"),contatto.getNumero());
                assertEquals(rs.getString("numero2"),contatto.getNumero2());
                assertEquals(rs.getString("numero3"),contatto.getNumero3());
                assertEquals(rs.getString("mail"),contatto.getMail());
                assertEquals(rs.getString("mail2"),contatto.getMail2());
                assertEquals(rs.getString("mail3"),contatto.getMail3());
                assertTrue(rs.getInt("preferito")==contatto.getPreferito());
                
                }
        
        }catch(Exception e)
        {
          

        }
    }
}
