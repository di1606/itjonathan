import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Modélisation du parking. Un parking est composé d'étages
 * Mémoriasation de la liste des référence sur des objets de type classe Etage
 *
 * @author VOTRE NOM
*/
public class Parking {
		
	/* Prix par type de véhicule (CHF / quart d'heure) */	
	public static final double PRIX_NON_DEFINI = 0.0;
	public static final double PRIX_VELO = 0.25; 
	public static final double PRIX_MOTO = 0.75; 
	public static final double PRIX_VOITURE = 3.0; 
		
	/* Attributs */ 
	private ArrayList etages;
		
	/* Constructeur */ 
	public Parking () {
		etages = new ArrayList();
	}
	 
	/* Accesseurs */ 
	public ArrayList getEtages () {return etages;}
	public Etage getEtage (int noEtage) {
		int pos = etages.indexOf(new Etage(noEtage));
		return pos < 0 ? null : (Etage)etages.get(pos);
	}

	/* Ajoute un étage */
	public void add (Etage etage) {etages.add(etage);}
	 
	/* Retourne le nombre de véhicules (somme de tous les types de véhicules de l'étage) */ 
	public int getNbVehicules () {
		int total = 0;
		for(int i = 0;i < etages.size();i++ ){
			total = total +((Etage)etages.get(i)).getNbVehicules();
		}
		return total;
	}
	 
	/* Retourne le montant (sommes des montants de tous les types de véhicules de l'étage) */ 
	public double getMontant () {
		double montant = 0;
		for(int i = 0;i < etages.size();i++){
			montant = montant + ((Etage)etages.get(i)).getMontant();
		}
		return montant;
	}

	public double montantParType(int typeVehicule){
		double montant = 0;
		for(int i = 0;i < etages.size();i++){
			montant = montant + ((Etage)etages.get(i)).montantParType(typeVehicule);
		}
		return montant;
	}

	public int nbTypeVehicule(int typeVehicule){
		int nb = 0;
		for(int i = 0;i < etages.size();i++){
			nb = nb + ((Etage)etages.get(i)).nbTypeVehicule(typeVehicule);
		}
		return nb;
	}
		 
	/* Supprime le box contenant la voiture désignée par son IdVehicule
		* Tester tous les étages jusqu'à trouver le box contenant le véhicule
		* Retourne vrai si l'opération s'est bien déroulée, faux sinon
	*/	
	public boolean removeVehicule (String idVehicule) {
		for(int i = 0 ;i<etages.size();i++){
			if(((Etage)etages.get(i)).removeVehicule(idVehicule)){
				return true;
			}
		}
		return false;
	}
	 
	public String toString () {return "Parking ";}
}