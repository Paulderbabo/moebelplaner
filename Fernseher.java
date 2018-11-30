
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;


/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fernseher extends Moebel
{
   
   

    /**
     * Constructor for objects of class Box
     */
    public Fernseher(int x, int y, String f, int o, int b, int t)
    {
        // initialise instance variables
        xPosition = 210; 
        yPosition = 17; 
        farbe = "rot";
        orientierung = 0;
        istSichtbar = false;
        breite = 10 ;
        tiefe  = 70;
    }

    protected Shape gibAktuelleFigur() {
        // einen GeneralPath definieren
        GeneralPath Fernseher = new GeneralPath();
        Fernseher.moveTo(0 , 0);
        Fernseher.lineTo(breite, 0);
        Fernseher.lineTo(breite, tiefe);
        Fernseher.lineTo(0, tiefe);
        Fernseher.lineTo(0 , 0);
        
        // transformieren:
        AffineTransform t = new AffineTransform();
        t.translate(xPosition, yPosition);
        Rectangle2D umriss = Fernseher.getBounds2D();
        t.rotate(Math.toRadians(orientierung),umriss.getX()+umriss.getWidth()/2,umriss.getY()+umriss.getHeight()/2);
        return  t.createTransformedShape(Fernseher);
    }
}

