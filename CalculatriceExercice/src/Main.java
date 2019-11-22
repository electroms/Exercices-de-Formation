import java.util.Scanner;


public class Main  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Ici Alogorithme
		double nombre1 = 0;
		double nombre2 = 0;
		String op = "";
		double resultat = 0;
		String ouiNon = "";
		Scanner sc = new Scanner(System.in);
		while(!ouiNon.equals("n") && !ouiNon.equals("N")) {
			System.out.println("Entrer un nombre");
			nombre1 = sc.nextInt();
			System.out.println("Entrer un nombre");
			nombre2 = sc.nextInt();
			
			
			while (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
				System.out.println("Saisir l'opérateur");
				op = sc.next();
			}
			
			if (op.equals("+") == true) {
				resultat = addition(nombre1, nombre2);
			}
			else if (op.equals("-") == true) {
				resultat = soustraction(nombre1, nombre2);
			}
			else if (op.equals("*") == true) {
				resultat = multiplication(nombre1, nombre2);
			}
			else {
				resultat = division(nombre1, nombre2);
			}
			System.out.println("resultat : " + resultat);
			
			System.out.println("Voulez vous recommencer O/N ?");
			ouiNon = sc.next();
			}
	}
	
	//Ici méthode
			static double addition(double nb1, double nb2) {
				
				double result = 0;
				result =  nb1 + nb2;
				return result;
			}
			static double soustraction(double nb1, double nb2) {
				
				double result = 0;
				result = nb1 - nb2;
				return result;
			}
			static double multiplication(double nb1, double nb2) {
				
				double result = 0;
				result = nb1 * nb2;
				return result;
			}
			static double division(double nb1, double nb2) {
				
				double result = 0;
				result = nb1 / nb2;
				return result;
			}
}

