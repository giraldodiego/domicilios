
package domiciliosdiego;

/**
 *
 * @author Diego Giraldo
 */

public class Domicilios {
    
    public static double distance(Double lat1, Double lng1, 
                                      Double lat2, Double lng2){
     double a = (lat1-lat2)*Domicilios.distPerLat(lat1);
     double b = (lng1-lng2)*Domicilios.distPerLng(lat1);
     return Math.sqrt(a*a+b*b);
    }

    private static double distPerLng(double lat){
      return 0.0003121092*Math.pow(lat, 4)
             +0.0101182384*Math.pow(lat, 3)
                 -17.2385140059*lat*lat
             +5.5485277537*lat+111301.967182595;
    }

    private static double distPerLat(double lng){
            return -0.000000487305676*Math.pow(lng, 4)
                -0.0033668574*Math.pow(lng, 3)
                +0.4601181791*lng*lng
                -1.4558127346*lng+110579.25662316;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DomiciliosView view = new DomiciliosView();
        view.setVisible(true);
        
     }
}