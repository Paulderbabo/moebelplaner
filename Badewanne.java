
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;


/**
 * Ein Stuhl, der manipuliert werden kann und sich selbst auf einer Leinwand zeichnet.
 * 
 * @author Claus Albowski
 * @version 2.2  (aug 07)
 */
public class Badewanne extends Moebel
{



    /**
     * Erzeuge einen neuen Stuhl mit einer Standardfarbe und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public Badewanne(int x, int y, String f, int o, int b, int t) {
        xPosition = x; 
        yPosition = y; 
        farbe = "rot";
        orientierung = 0;
        istSichtbar = false;
        breite = 180;
        tiefe  = 80;
    }
    
    /**
     * Berechnet das zu zeichnende Shape anhand der gegebenen Daten
     * [ Zum Anzeigen der Attributwerte über Inspect muss hier die Sichtbarkeit 
     *  auf public gesetzt werden. ]
     */
    protected Shape gibAktuelleFigur() {
        // einen GeneralPath definieren
        GeneralPath badewanne = new GeneralPath();
        Rectangle2D umriss1 = new Rectangle2D.Double(0,0,breite,tiefe);
        badewanne.append(umriss1,false);  
        
       Line2D obererRand = new Line2D.Double(0.1*tiefe, 0.1*tiefe, breite - 0.5*tiefe, 0.1*tiefe);
       Line2D linkerRand = new Line2D.Double(0.1*tiefe, 0.1*tiefe, 0.1*tiefe, 0.9*tiefe);
       Line2D untererRand = new Line2D.Double(0.1*tiefe, 0.9*tiefe, breite - 0.5*tiefe, 0.9*tiefe);
       Arc2D bogen = new Arc2D.Double(breite - 0.9*tiefe, 0.1*tiefe, 0.8*tiefe, 0.8*tiefe, 270, 180, Arc2D.OPEN);
       badewanne.append(obererRand, false);
       badewanne.append(linkerRand, false);
       badewanne.append(untererRand, false);
       badewanne.append(bogen, false);
       
       Ellipse2D ablauf = new Ellipse2D.Double(0.1*breite, 0.5*tiefe-2, 4, 4);
       badewanne.append(ablauf, false);
       
       // transformieren
        AffineTransform t = new AffineTransform();
        t.translate(xPosition, yPosition);
        Rectangle2D umriss = badewanne.getBounds2D();
        t.rotate(Math.toRadians(orientierung),umriss.getX()+umriss.getWidth()/2,umriss.getY()+umriss.getHeight()/2);
        return  t.createTransformedShape(badewanne);
    }
}

