package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
   @Test
   public void saldoAlussaOikein(){
       assertEquals("saldo: 0.10", kortti.toString());
   }
   @Test
   public void kortilleVoiLadataRahaa(){
       kortti.lataaRahaa(200);
       assertEquals("saldo: 2.10", kortti.toString());
       
   }
   @Test
   public void saldoVaheneeOikein(){
       kortti.otaRahaa(8);
       assertEquals("saldo: 0.2", kortti.toString());
   }
   @Test
   public void saldoEiMuttuJosEiRahaa(){
       kortti.otaRahaa(100);
       assertEquals("saldo: 0.10", kortti.toString());
   }
   @Test
   public void saldonTulostus(){
       kortti.saldo();
       assertEquals("saldo: 0.10", kortti.toString());
   }
}
