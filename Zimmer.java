import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


public class Zimmer extends Moebel
{
    private EinzelZimmer[] einzelzimmer;
    private int anzahl;

    /**
     * 
     * 
     */
    public Zimmer(int anzahl, int x, int y)
    {
        xPosition = x;
        yPosition = y;
        farbe = "blau";
        orientierung = 0;
        istSichtbar = false;
        
        this.anzahl = anzahl;
    
        einzelzimmer = new EinzelZimmer[anzahl]; 
        for (int i=0;i<anzahl;i++){
            einzelzimmer[i] = new EinzelZimmer(xPosition, yPosition + i*200);
        } 
         for (int t=4; t<anzahl;t++){
            einzelzimmer[t] = new EinzelZimmer(xPosition + 250, yPosition + (t-4) *200);
        }
        for (int q=8; q<anzahl;q++){
            einzelzimmer[q] = new EinzelZimmer(xPosition + 500, yPosition + (q-8) *200);
        }
        for (int a=12; a<anzahl;a++){
            einzelzimmer[a] = new EinzelZimmer(xPosition + 750, yPosition + (a-12) *200);
        }
        for (int r=16; r<anzahl;r++){
            einzelzimmer[r] = new EinzelZimmer(xPosition + 1000, yPosition + (r-16) *200);
        }
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
     * Berechnet das zu zeichnende Shape anhand der gegebenen Daten
     */
    protected Shape gibAktuelleFigur()
    {
        GeneralPath zimmer = new GeneralPath();
        for (int i=0;i<anzahl;i++){
            zimmer.append(einzelzimmer[i].gibAktuelleFigur(), false);
        }
        
        return transformiere(zimmer);
        
    }
}

