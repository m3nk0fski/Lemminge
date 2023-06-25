package Aufgaben1;

	public class Aufgabe_7 {
			public static void main(String[]args) {
				
				
				/*ein Getr�nk kostet 0.85ct 0.05ct bis 2 Euro gehen rein und raus
				
					*/
			System.out.println("press button to get drinks (...insert number of drinks)");
			int Drinks = SystemInReader.readInt();
			double Price = Drinks*0.85;
			
				System.out.println("Price: " +Price+ "�");
				double a = SystemInReader.readDouble();
				double Rest = Price-a;
				System.out.println("Price: " +Rest+ "�");
				
				if (Rest<0) System.out.println("heres your change: " + Rest+ "�");
				else {
			
				double b = SystemInReader.readDouble();
				Rest = Price-a-b;
				System.out.println("Price: " +Rest+ "�");
				if (Rest<0) System.out.println("heres your change: " + Rest+ "�");
				else {
				
			
				double c = SystemInReader.readDouble();
				Rest = Price-a-b-c;
				System.out.println("Price: " +Rest+ "�");
				if (Rest<0) System.out.println("heres your change: " + Rest+ "�");
				else {
					
				
				double d = SystemInReader.readDouble();
				Rest = Price-a-b-c-d;
				System.out.println("Price: " +Rest+ "�");
				if (Rest<0) System.out.println("heres your change: " + Rest+ "�");
				
						{double a1= SystemInReader.readDouble();
						Rest = Price-a1-b;
						System.out.println("Price: " +Rest+ "�");
						if (Rest<0) System.out.println("heres your change: " + Rest+ "�");
						else {
						}}}}
				}}}