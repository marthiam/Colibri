import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Mariam
 *
 */
public class Jeu {
	private Grille grille;
	
	public Jeu(){
		
	}
	
	public static void chargerNiveau(String filename ){
		try {
			   InputStream ips=new FileInputStream(filename);
			   InputStreamReader ipsr=new InputStreamReader(ips);
			   BufferedReader br=new BufferedReader(ipsr);
			   String ligne;
			   while ((ligne=br.readLine())!=null) 
			    System.out.println(ligne);
			   br.close();
			  }
			  catch (Exception e) {
			   System.out.println(e.toString());
			  } 
	}
	
	public static void main(String[] args) {
		chargerNiveau("Colibri/levels.txt");
	}

}
