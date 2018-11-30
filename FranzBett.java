import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;


/**
 * Ein FranzBett, der manipuliert werden kann und sich selbst auf einer Leinwand zeichnet.
 * 
 * @author Claus Albowski
 * @version 2.2  (aug 07)
 */
public class FranzBett extends Moebel
{


    /**
     * Erzeuge einen neuen FranzBett mit einer Standardfarbe und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public FranzBett(int x, int y, String f, int o, int b, int t) {
        xPosition = x;
        yPosition = y;
        farbe = f;
        orientierung = o;
        istSichtbar = false;
        breite = b;
        tiefe  = t;
    }
    
    /**
     * Berechnet das zu zeichnende Shape anhand der gegebenen Daten
     * [ Zum Anzeigen der Attributwerte ï¿½ber Inspect muss hier die Sichtbarkeit 
     *  auf public gesetzt werden. ]
     */
    public Shape gibAktuelleFigur() {
        // einen GeneralPath definieren
        GeneralPath FranzBett = new GeneralPath();
        FranzBett.moveTo(0 , 0);
        FranzBett.lineTo(breite, 0);
        FranzBett.lineTo(breite, tiefe);
        FranzBett.lineTo(0, tiefe);
        FranzBett.lineTo(0 , 0);  
        //querstreifen:
        FranzBett.lineTo(breite,tiefe);
        // transformieren:
        AffineTransform t = new AffineTransform();
        t.translate(xPosition, yPosition);
        Rectangle2D umriss = FranzBett.getBounds2D();
        t.rotate(Math.toRadians(orientierung),umriss.getX()+umriss.getWidth()/2,umriss.getY()+umriss.getHeight()/2);
        return  t.createTransformedShape(FranzBett);
    }
}
