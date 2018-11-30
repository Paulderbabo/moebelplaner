import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

/**
 * Ein Sessel, der manipuliert werden kann und sich selbst auf einer Leinwand zeichnet.
 * 
 * @author Claus Albowski
 * @version 2.2  (aug 07)
 */
public class Sessel extends Moebel
{   
    
    /**
     * Erzeuge einen neuen Stuhl mit einer Standardfarbe und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public Sessel(int x, int y, String f, int o, int b, int t)  {
        xPosition = x;
        yPosition = y;
        orientierung = o;
        farbe = f;
        istSichtbar = false;
        breite = b;
        tiefe  = t;
    }
    
    /**
     * Berechnet das zu zeichnende Shape anhand der gegebenen Daten
     * [ Zum Anzeigen der Attributwerte über Inspect muss hier die Sichtbarkeit 
     *  auf public gesetzt werden. ]
     */
    public Shape gibAktuelleFigur()
    {
        // GeneralPath definieren
        GeneralPath Sessel = new GeneralPath();
        Sessel.moveTo(0 , 0);
        Sessel.lineTo(breite, 0);
        Sessel.lineTo(breite, tiefe);
        Sessel.lineTo(0, tiefe);
        Sessel.lineTo(0 , 0);
        Sessel.lineTo(-5 , 0);//scheiß auf dolce und gabbana gib mir semikolons
        Sessel.lineTo(-5 , tiefe);
        Sessel.lineTo(0 , tiefe);
        
        // transformieren
        AffineTransform t = new AffineTransform();
        t.translate(xPosition, yPosition);
        Rectangle2D umriss = Sessel.getBounds2D();
        t.rotate(Math.toRadians(orientierung),umriss.getX()+umriss.getWidth()/2,umriss.getY()+umriss.getHeight()/2);
        return  t.createTransformedShape(Sessel);
    }
  
    

}
