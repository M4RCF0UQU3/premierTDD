

/**
 * RÃ©alisation d'une Jauge avec des entiers naturels.
 * <p>
 * Un objet Jauge dÃ©finit un niveau et un intervalle ouvert ]vigieMin, vigieMax[.
 * Le niveau d'une jauge n'est pas limitÃ© aux valeurs dans l'intervalle.
 * <p>
 * L'Ã©tat d'une jauge correspond Ã  la position de son niveau par rapport Ã 
 * l'intervalle ]vigieMin, vigieMax[.
 * Une jauge dÃ©finit trois etats :
 * <ul>
 * <li>vert niveau dans l'intervalle,
 * <li>rouge niveau supÃ©rieur Ã  l'intervalle,
 * <li>bleu niveau infÃ©rieur Ã  l'intervalle.
 * </ul>
 *
 * @author georgy
 * @since 2006-2007
 */
public class JaugeNaturel {
  private long valeur;
  private final long min;
  private final long max;

  /**
   * Construit une instance en prÃ©cisant la valeur de dÃ©part de la Jauge
   * et l'intervalle de vigie.
   *
   * @param vigieMin valeur minimale de l'intervalle de vigie.
   * @param vigieMax valeur maximale de l'intervalle de vigie.
   * @param depart   valeur initiale de la jauge.
   */
  public JaugeNaturel(long vigieMin, long vigieMax, long depart) {
	if(vigieMax<depart || depart<vigieMin){
		throw new IllegalArgumentException();
	}
	if(vigieMin == depart && depart == vigieMax){
		throw new IllegalArgumentException();
	}
    valeur = depart;
    min = vigieMin;
    max = vigieMax;
    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  /**
   * L'Ã©tat de la jauge est-il rouge ?
   *
   * @return vrai si niveau >=  vigieMax.
   *
   */
  public boolean estRouge() {
    return valeur >= max;
  }

  /**
   * L'Ã©tat de la jauge est-il vert ?
   *
   * @return vrai si niveau appartient Ã  ]vigieMin, vigieMax[.
   *
   */
  public boolean estVert() {
    //return !(estBleu() && estRouge());
    return valeur > min && valeur < max;
  }

  /**
   * L'Ã©tat de la jauge est-il bleu ?
   *
   * @return vrai si niveau <= vigieMin.
   */
  public boolean estBleu() {
    return valeur <= min;
  }

  /**
   * IncrÃ©mente le niveau d'une unitÃ©.
   * L'Ã©tat peut devenir supÃ©rieur Ã  vigieMax.
   */
  public void incrementer() {
    valeur++;
  }

  /**
   * DÃ©crÃ©mente le niveau d'une unitÃ©.
   * L'Ã©tat peut devenir infÃ©rieur Ã  la vigieMin.
   */
  public void decrementer() {
	  valeur-- ; 
  }


  /**
   * Cette mÃ©thode est hÃ©ritÃ©e de la classe {@link java.lang.Object}.
   * TrÃ¨s utile pour le dÃ©bogage, elle permet de fournir une
   * chaÃ®ne de caractÃ¨res correspondant a l'Ã©tat d'un objet.
   * <p> Un code par dÃ©faut est dÃ©finit dans
   * {@link java.lang.Object#toString() la classe Object}
   * Il faut adapter (redÃ©finir) le code de cette mÃ©thode Ã  chaque classe.
   *
   * Pour les chaÃ®nes de cararctÃ¨res, l'opÃ©rateur + correspond a la concatÃ©nation.
   * Les valeurs numÃ©riques sont alors convertit en ascii.
   * Si l'Ã©tat d'une instance de cette classe est min=-456, max=23,
   * valeur=-7, la concatÃ©nation donne la chaÃ®ne "<-7 [-456,23]>".
   */
  @Override
  public String toString() {
    return "<" + valeur + " [" + min + "," + max + "]>";
  }


public long getValeur() {
	return this.valeur;
}

public long getMin(){
  return this.min;
}

public long getMax(){
  return this.max;
}

}
