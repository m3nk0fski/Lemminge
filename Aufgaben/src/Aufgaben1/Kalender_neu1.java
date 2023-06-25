package Aufgaben1;

import java.util.Calendar;
/*import java.text.ParseException;
*/
import java.text.SimpleDateFormat;


public class Kalender_neu1 {


	

		//Startjahr 1940 Starttag (01.01.1940) Montag
		//Schaltjahre: Alle Jahre die durch 4 teilbar sind sind ein Schaltjahr
/*		
		int a= 366%7;
		System.out.println(a);
*/		
		//Setze Tage im Monat pro Jahr. Unterschied Schaltjahr und normales Jahr
		//Setze Startdatum Jedes Jahres
		
		
		public static String getStarttag (int jahr) {
			//Herausfinden des 1. Tages des Jahres
			int einteilungsjahr;
			
			enum Wochentag{
				Samstag,Sonntag,Montag,Dienstag,
				Mittwoch,Donnerstag,Freitag
				}
			
			einteilungsjahr= jahr-1939; 
			
			/*
			 * alle 28 Jahre wiederhohlt sich die Reihenfolge des ersten Tages im Jahr.
			 * Da man davon ausgehen kann, dass keiner mit über 80 studiert ist das erste 
			 * Rechenjahr 1940.
			 */
			
			int t=0;
			for ( t=0; (einteilungsjahr-(28*t))>28 ; t++) {}
					
			int v=einteilungsjahr-(28*t);
			
			Wochentag starttag = null; 	
			
			switch (v) {
			
				case 1,6,12,23:starttag=Wochentag.Montag;
				break;
				
				case 7,13,18,24:starttag= Wochentag.Dienstag;
				break;
				
				case 2,8,19,25: starttag= Wochentag.Mittwoch;
				break;
				
				case 3,9,14,20: starttag=Wochentag.Donnerstag;
				break;
				
				case 4,15,21,26: starttag= Wochentag.Freitag;
				break;
				
				case 5,10,16,27: starttag=Wochentag.Samstag;
				break;
				
				case 11,17,22,28: starttag=Wochentag.Sonntag;
				break;
				
				default: System.out.println("too much History");
				break;
			}	
			
			
			
			return String.valueOf(starttag);
			//System.out.println(starttag);
		}
		
		public static int getDaycount (int jahr) { 
			
			int daycount;
			if ((jahr%4)==0) 
			daycount=366;
			else {daycount =365;}
			
			return daycount;
		}

		public static Calendar getDate() { 
			/*Der aktuelle Tag soll angezeigt werden.*/
			Calendar cal = Calendar.getInstance();
			
			/*System.out.println("Today is:");  
			if( cal.get(Calendar.DATE) < 10) { System.out.print(0);}
			System.out.print(cal.get(Calendar.DATE)+".");
			if ( cal.get(Calendar.MONTH) < 10) { System.out.print(0);}
			System.out.println((cal.get(Calendar.MONTH)+1)+"."+			//da die Monatszählung bei 0 beginnt plus 1
			cal.get(Calendar.YEAR));
			*/
			
			cal.get(Calendar.DATE);
			cal.get(Calendar.MONTH);
			cal.get(Calendar.YEAR);	
			return cal;
			
			}
		
		public static int getMonth(String Monat) {
			
			String[] Month = { 									//Array wird erzeugt um die Werte nachher als Zahl wieder zu bekommen
					"Januar",
					"Februar",
					"März",
					"April",
					"Mai",
					"Juni",
					"Juli",
					"August",
					"September",
					"Oktober",
					"November",
					"Dezember"
		};
		
		int i;
		
		boolean status = false;
        for (i = 0; i < Month.length; i++) {
            status = Month[i].equals(Monat);
            if (status) break;
        }
        int n= i+1;
		if (n==13)return 0;					//Wenn kein Monatsname gefunden wurde war die Eingabe falsch und das ergebniss 13 kommt raus
		else {
        return n;
		}
		}
		
		public static int getDaycountMonth(int jahr,int month,int s) {
			
			int i=getDaycount(jahr);
			int summand=month-s,d;
			
			switch (summand) {
			 case 1:
			 case 3:
			 case 5:
			 case 7:
			 case 8:
			 case 10:
			 case 12: d = 31;
			 break;
			 case 4:
			 case 6:
			 case 9:
			 case 11: d = 30;
			 break;
			 case 2: if (i==366)
			 d = 29;
			 else
			 d = 28;
			 break;
			 default:d = 0;
			break;
			 }
			return d;
			
			
		}
		
		public static int getDayOfYear(int day,int month,int jahr) {
			
			
			int dayofyear=getDaycountMonth(jahr,month,1)+getDaycountMonth(jahr,month,2)+
					getDaycountMonth(jahr,month,3)+getDaycountMonth(jahr,month,4)+
					getDaycountMonth(jahr,month,5)+getDaycountMonth(jahr,month,6)+
					getDaycountMonth(jahr,month,7)+getDaycountMonth(jahr,month,8)+
					getDaycountMonth(jahr,month,9)+getDaycountMonth(jahr,month,10)+
					getDaycountMonth(jahr,month,11)+getDaycountMonth(jahr,month,12)+day;
			
			
			
			
			return dayofyear;
		}
		
		public static int getWeekOfYear(int day, int month, int jahr) {
			
			
			getStarttag (jahr); 
			
			int firstweek=3 ;
			
			//hier muss jetzt der String des Starttages wieder zu einer Zahl gemacht werden die
			// Anzahl der Tage der ersten Woche festlegt.
			
			
			int preweekofyear =((getDayOfYear(day,month,jahr)-firstweek)/7);
			int weekofyear;
			if (((getDayOfYear(day,month,jahr)-firstweek)/7)==preweekofyear*7) weekofyear= preweekofyear+0; 
			else weekofyear=preweekofyear+1;
			
			return weekofyear;
		}
		
		
		public static void main(String[]args) {
			
			
	        SimpleDateFormat dayFormat = new SimpleDateFormat( "EEEE" );
	        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	        Calendar date = getDate();
	        System.out.println(date + " was a " + dayFormat.format( format.format(date) ));
				
	
		
			
			
			
			
/*
			//Tage im Jahr mit getDaycount
			
			//System.out.println(getDaycount(SystemInReader.readInt()));
			System.out.println("Enter a Year: ");
			int i = getDaycount(SystemInReader.readInt());
			


			int d;
			System.out.println("Enter month:");
			int month=getMonth(SystemInReader.readln());
			switch (month) {
			 case 1:
			 case 3:
			 case 5:
			 case 7:
			 case 8:
			 case 10:
			 case 12: d = 31;
			 break;
			 case 4: 
			 case 6:
			 case 9:
			 case 11: d = 30;
			 break;
			 case 2: if (i==366)
			 d = 29;
			 else
			 d = 28;
			 break;
			 default:d = 0;
			break;
			 }
			
			System.out.println(d);
			
			
			//jahrestag = tage d jeden monats zusammengerechnet
			// Beispiel: oktober: switch 09 =30 plus switch 08 = 31 plus switch 07 = 31...
			
			System.out.println(getDayOfYear(03,07,2022));
			
			
			*/
			
			
			//which day in the Year.
			
			
			
			
			
			//System.out.println("Enter Year:");
			//getStarttag(SystemInReader.readInt());
			//getDate();
			

			
			

}}
