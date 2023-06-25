package Spiel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
    import java.io.InputStreamReader;
	import java.io.BufferedReader;
	import java.io.IOException;

public class Spielfeld{ 
    public class Coordinate {
     
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

    public class Point {
        public int x, y;
    }
    
    public class Circle {
        public Point center;
        public int radius;
        public double getArea() {
            return Math.PI * radius * radius;   
        }
        public double getCircumference() {
            return 2 * Math.PI * radius;
        }
    }

    public class Punkt {
    private int x, y, groesse;

    public Punkt(int x, int y, int groesse) {
        this.x = x; this.y = y; this.groesse = groesse;
    }
    public class GamePanel extends JPanel{
        
        private final Dimension prefSize = new Dimension(1180, 780);
    }

    public static Punkt hole(int x, int y, int groesse) {
        return new Punkt(500,400, 20);
    }
}
    
    
    

    public static void main (String[] args ){
        Punkt hole1 = Punkt.hole(100, 100, 5);

        


        System.out.println("Please Enter Pixel x:");

        int Pixel1 = SystemInReader.readInt();
    
    System.out.println("Please Enter Pixel y:");
        int Pixel2 = SystemInReader.readInt();
    System.out.println("Your Point ist at");
        System.out.println("x:"+Pixel1 +" y:" +Pixel2);

    
}


}