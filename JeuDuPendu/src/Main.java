import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.TabableView;
/**
 * 
 */

/**
 * @author Pierre-Henry Barge
 *
 */
	
public class Main {

	
	static Scanner sc = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String lettre = "";
		String motCacher = "";
		String motTrouver = "*****";
		String choixMot = "";
		String ouiNon = "";
		int indexDuMot = 0;
		int nbCoupRest = 0;
		boolean gagner = false;
		List<String> mots = new ArrayList<String>();
		
		//getLetter();
		//System.out.println(getRandom(0, 19));
		
	       	mots.add("un");
	        mots.add("deux");
	        mots.add("cinq");
	        mots.add("rouge");
	        mots.add("membre");
	        mots.add("conseil");
	        mots.add("donner");
	        mots.add("reponse");
	        mots.add("etat");
	        mots.add("son");
	        mots.add("armement");
	        mots.add("peu");
	        mots.add("apres");
	        mots.add("vacances");
	        mots.add("annonce");
	        mots.add("mercredi");
	        mots.add("evident");
	        mots.add("regime");
	        mots.add("affirmer");
	        mots.add("arme");																
	    
	    //System.out.println(getRandom(0, 19));
	    //System.out.println(choixMot(mots));   
	    //System.out.println(genereMotTrouver("trouver"));
	    //System.out.println(getLetter()); 
	    //System.out.println(testCaractere(motCacher, lettre, motTrouver));
	    //System.out.println(testGagner("rouge", "rouge"));
	      
	        
		while(!ouiNon.toLowerCase().equals("n")) {
		    gagner = false;
		    nbCoupRest = 0;
			motCacher = choixMot(mots);
		    motTrouver = genereMotTrouver(motCacher);
		    while(gagner != true && nbCoupRest <= 10) {
		    	 System.out.println("il vous reste " + (10 - nbCoupRest) + " nombre de coup ");
		    	 System.out.println("le mot secret est : " + motTrouver);
		    	 lettre = getLetter();
		    	 motTrouver = testCaractere(motCacher, lettre, motTrouver);
		    	 gagner = testGagner(motCacher, motTrouver);
		    	 if (!gagner) {
		    	 afficherPendu(nbCoupRest); 
		    	 }
		    	 nbCoupRest = nbCoupRest +1;
		     }
		     if(gagner == true) {
		    	 System.out.println("le mot secret est : " + motTrouver);
		    	 System.out.println("Vous avez gagner" );
		      }
		      else {
		    	  System.out.println("Vous avez perdu");
		    	  System.out.println("le mot secret est : " + motCacher);
		      }
		        
		      System.out.println("Voulez vous recommencer O/N ?");
				ouiNon = sc.next();
		}
	    
	        sc.close();
		
	}
		static String getLetter(){
			String getLetter = "";
			System.out.println("Entrer une lettre");
			getLetter = sc.next();
			return getLetter;
		}
		
	static int getRandom(int min, int max) {
		int getRandom = (int)(Math.random()*(max-min))+min;
		System.out.println("");
		return getRandom;
	}
	
	static String choixMot (List<String> list) {
			String mot = "";
			int resultGetRandom = getRandom(0, list.size()-1);
			mot = list.get(resultGetRandom);
			return mot;
	}
	static String testCaractere(String motCacher, String lettre, String motTrouver) {
			StringBuilder resultTestCaractereBuilder = new StringBuilder(motTrouver);
			for(int i = 0; i < motTrouver.length(); i++) {
				if(lettre.charAt(0) == motCacher.charAt(i)) {
					resultTestCaractereBuilder.setCharAt(i,lettre.charAt(0));
				}
			}
			return resultTestCaractereBuilder.toString();
	}
	static boolean testGagner(String motCacher, String motTrouver) {
				boolean testReussi = false;
			if(motCacher.equals(motTrouver)) {
				testReussi = true;	
				}
				return testReussi;
	}
	static String genereMotTrouver(String motCache) {
			StringBuilder resultMotCache = new StringBuilder();
			for(int i = 0; i < motCache.length(); i++) {
			resultMotCache.append("*");
				}
			return resultMotCache.toString();
	}
	static void afficherPendu(int nbCoupRest) {
		String pendu[] = new String[11];
		pendu[0] = 			"";
		
		pendu[1] 	=			"\n"
					+" 			\n"
					+" 			\n"
					+" 			\n"
					+"  | 		\n"
					+" _|_ 		\n";
		
		pendu[2] 	= 			" \n"
					+" 			\n"
					+" 			\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n";
		
		pendu[3] 	= 			"\n"
					+" 			\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n";
		
		pendu[4] 	= 			"\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n";
		
		pendu[5] 	="  _		\n"	
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n";
		
		pendu[6] 	="  __		\n"	
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n"; 
		
		pendu[7] 	="  ___		\n"	
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n"; 
		
		pendu[8]	 =" ____	\n"	
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n";
		pendu[9] 	="  ____	\n"	
					+"  |   |	\n"
					+"  | 		\n"
					+"  | 		\n"
					+"  | 		\n"
					+" _|_ 		\n";
		
		
		pendu[10] 	="  ____\n"	
					+"  |   |	\n"
					+"  |   O	\n"
					+"  |  /|\\	\n"
					+"  |  / \\	\n"
					+" _|_ 		\n"; 
		System.out.print(pendu[nbCoupRest]);
	}
}




 