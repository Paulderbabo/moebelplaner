import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.Color;
/**
 * Write a description of class EinzelZimmer here.
 * 
 * @author PAUL 
 * @version (V1.0)
 */
public class EinzelZimmer extends Moebel
{
    // instance variables - replace the example below with your own
    private Sessel      sessel1;
    private Tisch       tisch1;
    private FranzBett   franzBett1;
    private Sessel      sessel2;
    private Fernseher   fern1; //scheiß auf dolce und gabbana gib mir semikolons

    /**
     * Erzeuge einen neuen EinzelZimmer mit einer Standardfarbe und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public EinzelZimmer(int initX, int initY) {
        xPosition = initX; 
        yPosition = initY; 
        farbe = "white";
        orientierung = 0;
        istSichtbar = false;
        breite = 330;
        tiefe  = 60;
        sessel1 = new Sessel(10, 115, farbe, orientierung, 50, 50);
        sessel2 = new Sessel(140, 115, farbe, 180, 50, 50);
        tisch1 = new Tisch(75,115, farbe, orientierung, 50, 50);
        franzBett1 = new FranzBett(0,0, farbe, orientierung, 200, 100); 
        fern1 = new Fernseher (50 , 190,  farbe, orientierung, 20, 50);
    }
    
    /**
     * Berechnet das zu zeichnende Shape anhand der gegebenen Daten
     * [ Zum Anzeigen der Attributwerte über Inspect muss hier die Sichtbarkeit 
     *  auf public gesetzt werden. ]
     */
    public Shape gibAktuelleFigur() {
         // einen GeneralPath definieren+ EinzelZimmer 1
        GeneralPath EinzelZimmer = new GeneralPath();
        //FranzBett.moveTo(0,0);
     EinzelZimmer.append(sessel1.gibAktuelleFigur(), false);
     EinzelZimmer.append(sessel2.gibAktuelleFigur(), false);
     EinzelZimmer.append(tisch1.gibAktuelleFigur(), false);
     EinzelZimmer.append(franzBett1.gibAktuelleFigur(), false);
     EinzelZimmer.append(fern1.gibAktuelleFigur(), false);
        
         // transformieren:
        AffineTransform t = new AffineTransform();
        t.translate(xPosition, yPosition);
        Rectangle2D umriss = EinzelZimmer.getBounds2D();
        t.rotate(Math.toRadians(orientierung),umriss.getX()+umriss.getWidth()/2,umriss.getY()+umriss.getHeight()/2);
        return  t.createTransformedShape(EinzelZimmer);
    
        
    }
    
    /**
     * Mache dieses Objekt sichtbar. Wenn es bereits sichtbar ist, tue nichts.
     */
    public void zeige() {
        if (!istSichtbar) {
            istSichtbar = true;
            zeichne();
        }
    }
    
    /**
     * Mache dieses Objekt unsichtbar. Wenn es bereits unsichtbar ist, tue nichts.
     */
    public void verberge() {
        loesche(); // "tue nichts" wird in loesche() abgefangen.
        istSichtbar = false;
    }
    
    /**
     * Drehe auf den angegebenen Winkel
     */
    public void dreheAuf(int neuerWinkel) {
        loesche();
        orientierung = neuerWinkel;
        zeichne();
    }
    
    /**
     * Bewege dieses Objekt horizontal um 'entfernung' Bildschirmpunkte.
     */
    public void bewegeHorizontal(int entfernung) {
        loesche();
        xPosition += entfernung;
        zeichne();
    }
    
    /**
     * Bewege dieses objekt vertikal um 'entfernung' Bildschirmpunkte.
     */
    public void bewegeVertikal(int entfernung) {
        loesche();
        yPosition += entfernung;
        zeichne();
    }
    
    
    /**
     * Aendere die Farbe dieses Objektes in 'neueFarbe'.
     * Gueltige Angaben sind "rot", "gelb", "blau", "gruen",
     * "lila" und "schwarz".
     */
    public void aendereFarbe(String neueFarbe) {
        loesche();
        farbe = neueFarbe;
        zeichne();
    }
    
    /**
     * Zeichne dieses Objekt mit seinen aktuellen Werten auf den Bildschirm.
     */
    public void zeichne() {
        if (istSichtbar) {
            Shape figur = gibAktuelleFigur();
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.zeichne (
              this,           // leinwand kennt das Objekt
              farbe,          // definiert seine Zeichenfarbe
              figur);         // definiert seinen grafischen Aspekt
            leinwand.warte(10);
        }
    }
    
    /**
     * Loesche dieses Objekt vom Bildschirm.
     */
    public void loesche() {
        if (istSichtbar){
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.entferne(this);
        }
    }
}
