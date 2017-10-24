import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {
	
	JaugeNaturel jauge;

	@Before
	public void setUp() throws Exception {
		jauge = new JaugeNaturel(100, 345,67899);
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
		assertTrue("ma jauge est Verte", jauge.estVert());
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
		assertEquals("ma jauge est bien décrémentée! Youpii",val-1, jauge.getValeur());
	}

	@Test
	public void testToString() {
		assertEquals("Affichage Parfait !! ", "<50 [8,50]>", jauge.toString());
	}

	@Test
	public void testDansIntervalle() {
<<<<<<< HEAD
		assertTrue("ma jauge est dans l'intervalle",!jauge.estBleu() && jauge.estVert() && !jauge.estRouge());
		
	}
	public void testDeplacement() {
		jauge= new JaugeNaturel(100, 345,102);
		while(!jauge.estBleu()) {
			jauge.decrementer();
		}
		assertTrue(jauge.estBleu() && !jauge.estVert() && !jauge.estRouge());
		while(!jauge.estVert()) {
			jauge.incrementer();
		}
		assertTrue(!jauge.estBleu() && jauge.estVert() && !jauge.estRouge());
	}

	public void testLimiteVigieMaxInferieurVigieMin() {
		jauge= new JaugeNaturel(345, 100,150);
		assertFalse("min > max",jauge.getMin>jauge.getMax);
	}
	
	public void testMaxEgaleMin() {
		jauge= new JaugeNaturel(100, 100,100);
		assertFalse("min = max", jauge.getMin==jauge.getMax);
	}
	
=======
		
		
		assertTrue("ma jauge est dans l'intervalle",!jauge.estBleu() && jauge.estVert() && !jauge.estRouge());
		
		
	}

>>>>>>> branch 'master' of https://github.com/M4RCF0UQU3/JavaTest
	public static void main(String[] args) {
		 JaugeNaturelTest jauge = new JaugeNaturelTest();
		 try {
			 jauge.setUp();
		 }catch(Exception e){}
	}

}
