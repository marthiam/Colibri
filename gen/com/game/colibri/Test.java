
public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Grille test = new Grille(10,10);
		test.afficherMatrice();
		test.ajouter(new Fleur(new Coordonnee(1,1)));
		test.ajouter(new Menhir(new Coordonnee(2,1)));
		test.afficherMatrice();
		Colibri col =new Colibri(new Coordonnee(0,0));
		test.ajouter(col);
		test.afficherMatrice();
		test.deplacerEnBas(col);
		test.afficherMatrice();
		test.ajouter(new Menhir(new Coordonnee(9,5)));
		test.deplacerADroite(col);
		test.afficherMatrice();
		test.ajouter(new Menhir(new Coordonnee(9,2)));
		test.deplacerAGauche(col);
		test.afficherMatrice();
		test.ajouter(new Fleur(new Coordonnee(4,3)));
		test.afficherMatrice();
		test.deplacerEnHaut(col);
		test.afficherMatrice();
		
		
		
	}

}
