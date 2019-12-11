/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semangatkomputer.backend;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import semangatkomputer.backend.Pelanggan;

/**
 *
 * @author Farid Aziz
 */
public class PelangganTest extends TestCase{
    Pelanggan instance;
    
    public PelangganTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Pelanggan("Farid", "farid@gmail.com", "081333");
        System.out.format("Start Testing : %s \n", this.getName());
    }
    
    @After
    public void tearDown() {
        System.out.format("Finish Test %s\n", this.getName());
    }
    @Test
    public void testSave(){
        
        System.out.println("save test");
        this.instance.save();
        ArrayList<Pelanggan> expResult = instance.getByNamaAndEmailAndTelepon(instance.getNama(), instance.getEmail(), instance.getTelepon());
        assertTrue(expResult.size()>0);
    }
    
    @Test
    public void testSearch(){
        System.out.println("search test");
        String keyword = "farid@gmail.com";
        ArrayList<Pelanggan> result = instance.search(keyword);
        ArrayList<Pelanggan> expResult = instance.getByNamaAndEmailAndTelepon("", keyword,"");
        assertEquals(expResult.size(), result.size());
    }

    
}
