import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {
	
	JaugeNaturel jauge;

	@Before
	public void setUp() throws Exception {
		jauge = new JaugeNaturel(100, 345, 200);
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
	public void testDansIntervalle() {
		assertTrue(!jauge.estBleu()&&jauge.estVert()&&!jauge.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		jauge = new JaugeNaturel(100, 345, 102);
		jauge.decrementer();jauge.decrementer();jauge.decrementer();
		assertTrue(jauge.estBleu()&&!jauge.estVert()&&!jauge.estRouge());
		jauge.incrementer();jauge.incrementer();jauge.incrementer();jauge.incrementer();
		assertTrue(!jauge.estBleu()&&jauge.estVert()&&!jauge.estRouge());
	}
	
	/*@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		jauge = new JaugeNaturel(100, 98, 99);
		assertFalse("jauge incoherente",jauge.getMax()<jauge.getValeur() && jauge.getValeur()<jauge.getMin());
	}*/
	
	/*@Test
	public void testMaxEgalMin() {
		jauge = new JaugeNaturel(100, 100, 100);
		assertFalse("jauge inutile, vitesse fixer à un seul rang donc improbable",jauge.getMax()<=jauge.getMin());
	}*/
	
	/*
	 * Il faut mettre deux blocs try catch dans le test ci dessous pour pouvoir connaitre quelle instanciation
	 * de JaugeNaturel a renvoyé ou non une exception.
	 * Si aucune exception n'est levée le test s'arrête lors de la vérification de la première variable,
	 * il faut donc trouver un autre moyen de renvoyer les exceptions. Ce qui va être abordé dans le 3.
	 */
	@Test//(expected=IllegalArgumentException.class)
	public void testCreationNonValide(){
		try{
			JaugeNaturel inverse = new JaugeNaturel(78, 13, 0);
			fail("Exception not thrown on inverse");
		}catch(IllegalArgumentException e1){
			try{
				JaugeNaturel egale = new JaugeNaturel(-45, -45, -45);
				fail("Exception not thrown on egale");
			}catch(IllegalArgumentException e2){
			}
		}
	}
	
	@Test
	public void testExceptionControlee() /*throws ClassNotFoundException()*/{
		try{
			throw new ClassNotFoundException("Attention");
		}catch(ClassNotFoundException e){
		}
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
