package Aufgaben1;

	public class Aufgabe_5 {		
		public static void main(String[] args) {		
			
			System.out.println("Packages aviable: ");
			
			int d ;
			d = SystemInReader.readInt();
			
			int e = d / 50 ;
			System.out.println("trucks: " + e);
			
			int f = d - 50 * e; 
			System.out.println("rest of packages: " + f);			
		}
}
