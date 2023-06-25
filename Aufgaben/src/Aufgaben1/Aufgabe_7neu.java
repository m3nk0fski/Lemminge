package Aufgaben1;

	public class Aufgabe_7neu {
		
		public static double calculateRest( double Price,double money) {
			double Rest = Price-money;
			return Rest;
			}
		
		public static double Change(double Rest, double money) {
			double change = (Rest-money) * (-1);
			return change;
			}
		
		
		
		public static void main(String[]args) {
			
			
			/*ein Getr�nk kostet 0.85ct 0.05ct bis 2 Euro gehen rein und raus
			
				*/
		System.out.println("press button to get drinks (...insert number of drinks)");
		int Drinks = SystemInReader.readInt();
		final double Price = Drinks*0.85;
		 System.out.println("Price " + Price + " �");
		 double Rest,Money;
		 
		 Rest = calculateRest(Price,Money=SystemInReader.readDouble());
		 System.out.println("Price " +Rest+ " �");
		 
		 for  (Rest= calculateRest(Price,Money=SystemInReader.readDouble()); 
				 Change(Price,Money=SystemInReader.readDouble())<0;
				 calculateRest(Price,Money=SystemInReader.readDouble())) {
			 System.out.println(Money);
		 }
		
		}
			
			}
		