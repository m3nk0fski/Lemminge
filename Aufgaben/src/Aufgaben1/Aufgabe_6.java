
package Aufgaben1;

public class Aufgabe_6 {

	public static void main(String[]args) {
		
		System.out.println( "Number: ");
		int g= SystemInReader.readInt();
		int h,i,j,k,l,m,n,o,p; //alle Variablen sind hier deklariert damit sie f�r alle Schleifen zug�nglich sind.
		

		if (g<1) {System.out.println("Error");}
		else{	for ( i = 2  ; g%i !=0; ) {} System.out.print(i); /* die geschweifte Klammer muss hier und zum Schluss
		nach der letzten if-Anweisung gesetzt werden damit die Variable aus der else-Anweisung in die n�chste if-Bedingung 
		�berf�hrt werden kann.*/
			
		
			if ((h= g/i)!= 1);			
				for ( j = 2  ; h%j !=0; j++) {} System.out.print("-"+j);
			
			
			if ((k= h/j)!= 1); 
				for ( l = 2  ; k%l !=0; l++) {} System.out.print("-"+l);
			
			
			if ((m= k/l)!= 1); 
				for ( n = 2  ; m%n !=0; n++) {} System.out.print("-"+n);
			
			
			if ((o= m/n)!= 1) ;
				for ( p = 2  ; o%p !=0; p++) {} System.out.print("-"+p);
			}/*Wenn man mit gr��eren Zahlen rechnen m�chte muss man einfach mehr if-Anweisungen einf�gen. Man kann auch eine class
			erstellen und die Zahlen immer neu einf�gen lassen.*/
		
		
		}
	}