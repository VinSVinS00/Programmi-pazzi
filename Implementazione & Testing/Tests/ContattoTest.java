/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicazioneTest;

import Applicazione.Contatto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ContattoTest {
    
    public ContattoTest() {
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
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com" ,0);
        assertEquals("Mario", contatto.getNome());
    }

    @Test
    public void testSetNome() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setNome("Luigi");
        assertEquals("Luigi", contatto.getNome());
    }

    @Test
    public void testGetCognome() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertEquals("Rossi", contatto.getCognome());
    }

    @Test
    public void testSetCognome() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setCognome("Verdi");
        assertEquals("Verdi", contatto.getCognome());
    }

    @Test
    public void testGetNumero() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertEquals("123456789", contatto.getNumero());
    }

    @Test
    public void testSetNumero() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setNumero("111222333");
        assertEquals("111222333", contatto.getNumero());
    }

    @Test
    public void testGetMail() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertEquals("mario.rossi@example.com", contatto.getMail());
    }

    @Test
    public void testSetMail() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setMail("luigi.verdi@example.com");
        assertEquals("luigi.verdi@example.com", contatto.getMail());
    }

    @Test
    public void testGetNumero2() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertEquals("987654321", contatto.getNumero2());
    }

    @Test
    public void testSetNumero2() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setNumero2("444555666");
        assertEquals("444555666", contatto.getNumero2());
    }

    @Test
    public void testGetMail2() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertEquals("rossi.mario@example.com", contatto.getMail2());
    }

    @Test
    public void testSetMail2() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setMail2("verdi.luigi@example.com");
        assertEquals("verdi.luigi@example.com", contatto.getMail2());
    }

    @Test
    public void testGetNumero3() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertEquals("555555555", contatto.getNumero3());
    }

    @Test
    public void testSetNumero3() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setNumero3("777888999");
        assertEquals("777888999", contatto.getNumero3());
    }

    @Test
    public void testGetMail3() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertEquals("mario@example.com", contatto.getMail3());
    }

    @Test
    public void testSetMail3() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setMail3("luigi@example.com");
        assertEquals("luigi@example.com", contatto.getMail3());
    }
    
    @Test
    public void testGetPreferito(){
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        assertTrue(0==contatto.getPreferito());
    }
    
    @Test
    public void testSetPreferito(){
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "mario.rossi@example.com", 
                                         "987654321", "rossi.mario@example.com", "555555555", "mario@example.com",0);
        contatto.setPreferito(1);
        assertTrue(1==contatto.getPreferito());
    }
}
