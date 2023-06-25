package GUI;

public class Spielfeld {
    public static void main(String[] args) {
        int feldGroesse = 5;
        
        // Erstelle das Spielfeld als zweidimensionales Array
        char[][] spielfeld = new char[feldGroesse][feldGroesse];
        
        // Initialisiere das Spielfeld mit Leerzeichen
        for (int i = 0; i < feldGroesse; i++) {
            for (int j = 0; j < feldGroesse; j++) {
                spielfeld[i][j] = ' ';
            }
        }
        
        // Zeichnet das Spielfeld
        for (int i = 0; i < feldGroesse; i++) {
            for (int j = 0; j < feldGroesse; j++) {
                System.out.print(spielfeld[i][j]);
                
                if (j < feldGroesse - 1) {
                    System.out.print(" | ");
                }
            }
            
            System.out.println();
            
            if (i < feldGroesse - 1) {
                System.out.println("---------");
            }
        }
    }
}