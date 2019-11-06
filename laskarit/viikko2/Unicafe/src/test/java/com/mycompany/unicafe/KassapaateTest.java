/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class KassapaateTest {
    Kassapaate kassapaate;
    Maksukortti kortti;
    int edulliset;
    int maukkaat;
    
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        edulliset =0;
        maukkaat =0;
        
        
    }
    @Test
    public void luotuKassapaateOikein(){
     assertEquals(100000, kassapaate.kassassaRahaa());
     assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
     assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenLounaanKateisostoToimiiRahaaTarpeeksi(){
        kassapaate.syoEdullisesti(250);
        assertEquals(100240, kassapaate.kassassaRahaa());    
        assertEquals(10, kassapaate.syoEdullisesti(250));
        assertEquals(2, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullinenLounasKateisostoEiRahaa(){
        kassapaate.syoEdullisesti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(100,kassapaate.syoEdullisesti(100));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
        
    @Test
    public void maukasLounaanKateisostoToimiiRahaaTarpeeksi(){
        kassapaate.syoMaukkaasti(410);
        assertEquals(100400, kassapaate.kassassaRahaa());    
        assertEquals(10, kassapaate.syoMaukkaasti(410));
        assertEquals(2, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukasLounasKateisostoEiRahaa(){
        kassapaate.syoMaukkaasti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(100,kassapaate.syoMaukkaasti(100));
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void edullinenLounasKorttiostoToimii(){
        Maksukortti kortti=new Maksukortti(400);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(true, kortti.otaRahaa(0));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullinenLounasEiRahaaKorttiosto(){
        Maksukortti kortti=new Maksukortti(100);
        kassapaate.syoEdullisesti(kortti);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(100, kortti.saldo());
        assertEquals(false, kortti.otaRahaa(240));
    }
    @Test
    public void maukasLounasKorttiostoToimii(){
        Maksukortti kortti=new Maksukortti(600);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(true, kortti.otaRahaa(0));
    }
    
    @Test
    public void maukasLounasEiRahaaKorttiosto(){
        Maksukortti kortti=new Maksukortti(300);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(false, kortti.otaRahaa(400));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(300, kortti.saldo());
    }
    
    @Test
    public void KortilleRahaaLadattaessaSaldoMuuttuu(){
        Maksukortti kortti=new Maksukortti(300);
        kassapaate.lataaRahaaKortille(kortti, 200);
        assertEquals(500, kortti.saldo());
    }
    
     @Test
    public void KortilleRahaaLadattaessakassapaateArvoMuuttuu(){
        Maksukortti kortti=new Maksukortti(300);
        kassapaate.lataaRahaaKortille(kortti, 200);
        assertEquals(100200, kassapaate.kassassaRahaa());
    }
    @Test 
    public void NegatiivinenLatausEiMuuta(){
        Maksukortti kortti=new Maksukortti(300);
        kassapaate.lataaRahaaKortille(kortti, -200);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(300, kortti.saldo());
        
    }
}
