package etatPassager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EtatPassagerTest {
  
  EtatPassager etat;

  @After
  public void tearDown() throws Exception {
      etat = null ;      
  }
  
  @Test
  public void t1_testExterieur(){
    etat = new EtatPassager(EtatPassager.Etat.DEHORS);
    assertTrue(etat.estExterieur());
    assertFalse(etat.estAssis() && etat.estDebout());
  }
  
  @Test
  public void t2_testAssis(){
    etat = new EtatPassager(EtatPassager.Etat.ASSIS);
    assertTrue(etat.estAssis());
    assertFalse(etat.estExterieur() && etat.estDebout());
  }
  
  @Test
  public void t3_testDebout(){
    etat = new EtatPassager(EtatPassager.Etat.DEBOUT);
    assertTrue(etat.estDebout());
    assertFalse(etat.estAssis() && etat.estExterieur());
  }
  
  @Test
  public void t4_testInterieur(){
    etat = new EtatPassager(EtatPassager.Etat.ASSIS);
    assertTrue(etat.estInterieur());
    etat = new EtatPassager(EtatPassager.Etat.DEBOUT);
    assertTrue(etat.estInterieur());
    etat = new EtatPassager(EtatPassager.Etat.DEHORS);
    assertFalse(etat.estInterieur());
  }
}
