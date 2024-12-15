/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicazioneTest;

import Applicazione.ArchivioController;
import Applicazione.Contatto;
import Applicazione.RubricaController;
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


public class ArchivioControllerTest {
    
    public ArchivioControllerTest() {
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

    /**
     * Test of archivia method, of class ArchivioController.
     */
    @Test
    public void testArchivia() {
        System.out.println("archivia");
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com","987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        ArchivioController instance = new ArchivioController();
        RubricaController rubrica = new RubricaController();
        rubrica.setContats(contatto);
        
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
        
    
        
    
    }
}
    

