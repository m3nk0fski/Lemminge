package Spiel;

import Spiel.Spielfeld;

public class Hole {
    private double x,y;

    public Hole (double x, double y) {
        
        this.x = x;this.y =y;
    }
    
    public double getX() {
        return x;
    }
 
    public void setX(int x) {
        this.x = x;
    }
 
    public double getY() {
        return y;
    }
 
    public void setY(int y) {
        this.y = y;
    }
        
    public static Hole setHole(double x, double y){
        return new Hole (x,y);
    }
    
    public static String getHit (int x, int y){








        return String.valueOf Hole
    }
        
            /* Wenn ein Punkt der geklickt wird mit einem Loch verglichen werden soll einfach 
            *die Abstände der Koordinaten beide quadrieren und
            * mit dem Radius^2 vergleichen. Wenn r^2 kleiner ist ist der Klick im Kreis*/

    
    }
