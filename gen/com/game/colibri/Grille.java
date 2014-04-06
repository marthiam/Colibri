import java.util.LinkedList;
import java.util.Random;



/**
 * 
 */

/**
 * @author Mariam
 *
 */
public class Grille {
	
	private int largeur ;
	private int hauteur ;
	private Colibri colibri;
	public static char vide=0;
	public static char menhir=2;
	public static char fleur=1;
	public static char oiseau = 3;
	private LinkedList<Elements> elements;
	
	/**
	 * la matrice correspondant à la grille
	 */
	private char [][] matrice; 
	
	
	/**
	 * Constructeur 
	 * 		Construit une grille vide
	 * 
	 * @param largeur
	 * @param hauteur
	 */
	public Grille(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.matrice=new char[largeur][hauteur];
		initMatrice();
	}


	/**
	 * Ajoute un element a la grille
	 * @param element
	 */
	public void ajouter(Elements element) {
		this.elements.add(element);
		if(element.getPosition().x<this.hauteur && element.getPosition().y<largeur){
			char res = 0;
			if (element instanceof Colibri){
				res = oiseau;
				this.colibri = (Colibri)element;
			}else if (element instanceof Fleur){
				res = fleur;
			}else if (element instanceof Menhir){
				res = menhir;
			}
			this.matrice[element.getPosition().x][element.getPosition().y]=res;
			System.out.println(res);
			}else{
			 System.err.print("Position non valide");
			}
		}
	/**
	 * 	Supprime un element de la grille 
	 * @param element
	 */
	public void enveler(Elements element){
		this.elements.remove(element);
		this.matrice[element.getPosition().x][element.getPosition().y] = vide;
		}
	/**
	 *       modifie la position d'un element sur la grille 
	 * @param old_coordonnee
	 * @param new_coordonnee
	 * @param element
	 */
	public void changerPosition (Coordonnee new_coordonnee, Elements element){
		this.enveler(element);
		element.setPosition(new_coordonnee);
		this.ajouter(element);	
	}
	
	
	/**
	 * 	initialise les elements qui se trouvent sur la grille 
	 */
	public void initMatrice(){
		elements =new LinkedList<Elements>();
		for (int j = 0; j < this.hauteur; j++) {
			for (int i = 0; i < this.largeur; i++) {
				this.matrice[i][j] = vide;
			}
		}
	}
	
	/**
	 * 	permet de deplacer un objet sur la grille vers la droite
	 * @param element
	 */
	public void deplacerADroite(Elements element){
		int x=element.getPosition().x;
		int y=element.getPosition().y;
		for(int i=y+1;i<this.largeur;i++){
			if(matrice[x][i]==fleur){
				matrice[x][i]=0;
			}else if(matrice[x][i]==menhir){
				 if(i!=y+1){
					 this.changerPosition( new Coordonnee(x,i-1), element);
					 return;
				 }else{
					 return;
				 }
			}
		}
		this.changerPosition(new Coordonnee(x,largeur-1), element);
	}
	
	
	/**
	 * 	permet de deplacer un objet sur la grille vers la gauche
	 * @param element
	 */
	public void deplacerAGauche(Elements element){
		int x=element.getPosition().x;
		int y=element.getPosition().y;
		for(int i=y-1;i>=0;i--){
			if(matrice[x][i]==fleur){
				matrice[x][i]=0;
			}else if(matrice[x][i]==menhir){
				 if(i!=y-1){
					 this.changerPosition(new Coordonnee(x,i+1), element);
					 return;
				 }else{
					 return;
				 }
			}
		}
		this.changerPosition(new Coordonnee(x,0), element);
	}
	
	/**
	 * 	permet de deplacer un objet sur la grille vers le bas
	 * @param element
	 */
	public void deplacerEnBas(Elements element){
		int x=element.getPosition().x;
		int y=element.getPosition().y;
		for(int i=x+1;i<this.hauteur;i++){
			if(matrice[i][y]==fleur){
				matrice[i][y]=0;
			}else if(matrice[i][y]==menhir){
				 if(i!=x+1){
					 
					 this.changerPosition(new Coordonnee(i-1,y), element);
					 
					 return;
				 }else{
					 return;
				 }
			}
		}
		 this.changerPosition(new Coordonnee(hauteur-1,y), element);
	}
	/**
	 * 	permet de deplacer un objet sur la grille vers le haut 
	 * @param element
	 */
	public void deplacerEnHaut(Elements element){
		int x=element.getPosition().x;
		int y=element.getPosition().y;
		for(int i=x-1;i>=0;i--){
			if(matrice[i][y]==fleur){
				matrice[i][y]=0;
			}else if(matrice[i][y]==menhir){
				 if(i!=x-1){
					 this.changerPosition(new Coordonnee(i+1,y), element);
					 return;
				 }else{
					 return;
				 }
			}
		}
		this.changerPosition( new Coordonnee(0,y), element);
	}
	
	/**
	 * Affiche matrice et ses differents elements 
	 */
	public void afficherMatrice(){
		for (int i = 0; i < this.largeur; i++) {
			System.out.print("I");
			for (int j = 0; j < this.hauteur; j++) {
				if(matrice[i][j]==fleur){
					System.out.print('*');
				}else if(matrice[i][j]==menhir){
					System.out.print('!');
				}else if(matrice[i][j]==oiseau){
					System.out.print('$');
				}
				else{
					System.out.print("_");
				}
			}
			System.out.print("I");
			System.out.print("\n");
		}
		
		
	}
	
	
	/**
	 * Genere un coordonnée aléatoirement 
	 * @return les coordonnées d'un point pris aléatoirement sur la grille 
	 */
	public Coordonnee generate() {
		Random rnd = new Random();
		int x = rnd.nextInt(this.largeur);
		int y = rnd.nextInt(this.hauteur);
		Coordonnee c = new Coordonnee(x, y);
		return c;
	}
	/**
	 * @return the largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * @return the hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * @return the colibri
	 */
	public Colibri getColibri() {
		return colibri;
	}

	/**
	 * @param largeur the largeur to set
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * @param colibri the colibri to set
	 */
	public void setColibri(Colibri colibri) {
		this.colibri = colibri;
	}

	/**
	 * @return the matrice
	 */
	public char[][] getMatrice() {
		return matrice;
	}

	/**
	 * @param matrice the matrice to set
	 */
	public void setMatrice(char[][] matrice) {
		this.matrice = matrice;
	}



}
