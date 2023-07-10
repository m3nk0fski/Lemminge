package Spiel;


import Spiel.Hole;
import javax.swing.JPanel;


public class Spielfeld{


    Hole h1= Hole.setHole(50,25);
    Hole h2= Hole.setHole(100,25);
    Hole h3= Hole.setHole(150,25);
    Hole h4= Hole.setHole(50,75);
    Hole h5= Hole.setHole(100,75);
    Hole h6= Hole.setHole(150,75);
    Hole h7= Hole.setHole(50,125);
    Hole h8= Hole.setHole(100,125);
    Hole h9= Hole.setHole(150,125);



    int r = 20;
    
    /*
     *  public class Coordinate {
     
        private int x;
        private int y;
    
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }             
 
        public int getX() {
            return x;
        }
 
        public void setX(int x) {
            this.x = x;
        }
 
        public int getY() {
            return y;
        }
 
        public void setY(int y) {
            this.y = y;
        }
 
    }
     */
    
    
    

    public static void main (String[] args ){

        


        System.out.println("Please Enter Pixel x:");
        
        int x = SystemInReader.readInt();
    
    System.out.println("Please Enter Pixel y:");
        int y = SystemInReader.readInt();
        int r = 20;
        int c = x*x+y*y; int b = r*r;
        if ( c == b ) System.out.println("same number"); 
			else if (c < b) System.out.println( "Bigger number: " + b); else System.out.println("Bigger number: " + c);


    System.out.println("You hit");


        System.out.println();



}}