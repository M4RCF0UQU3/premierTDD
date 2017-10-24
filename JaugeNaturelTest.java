import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {
	
	JaugeNaturel jauge;

	@Before
	public void setUp() throws Exception {
		jauge = new JaugeNaturel(100, 345, 67899);
	}

	@After
	public void tearDown() throws Exception {
		jauge = null ;  	
	}

	@Test
	public void testJaugeNaturel() {
		assertNotNull("Ma jauge est not null",jauge);
	}

	@Test
	public void testEstRouge() {
		assertTrue("ma jauge est Rouge", jauge.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue("ma jauge est Vert", jauge.estVert());
	}

	@Test
	public void testEstBleu() {
		assertTrue("ma jauge est Bleue", jauge.estBleu());
	}

	@Test
	public void testIncrementer() {
		long val = jauge.getValeur(); 
		jauge.incrementer();
		assertEquals("ma jauge est bien incrémentée ! Youpii",val+1, jauge.getValeur());
		
	}

	@Test
	public void testDecrementer() {
		long val = jauge.getValeur();
		jauge.decrementer();
		assertEquals("ma jauge est bien décrémenté! Youpii",val-1, jauge.getValeur());
	}

	@Test
	public void testToString() {
		assertEquals("Affichage Parfait !! ", "<50 [8,50]>", jauge.toString());
	}
	
	@Test
	public void testInferieurIntervalle(){
	  for(int i = 0; i < 2; i++){
	    if(i == 0){
	      jauge = new JaugeNaturel(12,18,3);
	    }else{
	      jauge = new JaugeNaturel(12,18,12);
	    }
	    assertTrue(jauge.estBleu());
	    assertFalse(jauge.estVert());
	    assertFalse(jauge.estRouge());
	  }
	}
	
	@Test
    public void testSuperieurIntervalle(){
      for(int i = 0; i < 2; i++){
        if(i == 0){
          jauge = new JaugeNaturel(12,18,3);
        }else{
          jauge = new JaugeNaturel(12,18,12);
        }
        assertTrue(jauge.estBleu());
        assertFalse(jauge.estVert());
        assertFalse(jauge.estRouge());
      }
    }

}
