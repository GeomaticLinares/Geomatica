import java.util.Scanner;
public class Geomatica1 {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    //Geodesicas a Cartesianas

      double semiEjeMayor = 6378137;
      double primExcentricidad = 0.00669438;
      System.out.println("Bienvenido");
      System.out.println("*De Geodesicas a Geocentricas*");

      System.out.println("-----LATITUD GEODESICA-----");
      System.out.print("Ingrese LATITUD, separada por espacios: ");

      double gradLatitud = entrada.nextDouble();
      double minLatitud = entrada.nextDouble();
      double segLatitud = entrada.nextDouble();

      double latGrad = gradLatitud;
      double latMin = minLatitud / 60;
      double latSeg = segLatitud / 3600;
      double numNatLat = latGrad + latMin +latSeg;

      double lat;

      System.out.println("Ingrese (N)Latitud NORTE o (S)Latitud SUR?: ");
      String latitud = entrada.next();
        if (latitud.equalsIgnoreCase("s"))
          {lat=numNatLat*-1; }
        else
          {lat=numNatLat*1; }

      System.out.println("Ingrese la Altura Elipsoidal: ");
      double altElipsoidal = entrada.nextDouble();

      System.out.println("-----LONGITUD GEODESICA-----");
      System.out.print("Ingrese la LONGITUD, separada por espacios; ");
      double gradLong = entrada.nextDouble();
      double minLong = entrada.nextDouble();
      double segLong = entrada.nextDouble();

      double longGrad = gradLong;
      double longMin = minLong / 60;
      double longSeg = segLong / 3600;
      double numNatLong = longGrad + longMin + longSeg;
      double lon;

      System.out.println("Ingrese (E)Longitud ESTE o (O)Longitud OESTE?: ");
      String longitud = entrada.next();
        if (longitud.equalsIgnoreCase("o"))
          {lon=numNatLong*-1; }
        else
          {lon=numNatLong*1; }

        //RADIO DE CURVATURA DE LA PRIMERA VERTICAL
        double curVert = semiEjeMayor/
          (Math.sqrt(1-primExcentricidad*
           Math.pow(Math.sin((lat*Math.PI/180)),2)));
        System.out.println("La Vertical Prima es : "+
            String.format("%.3f",curVert));

        //CALCULO DE LA COORDENADA GEOCENTRICA X
        double coordX = (Math.cos(lat*Math.PI/180)
          *Math.cos(lon*Math.PI/180))*
            (curVert + altElipsoidal);
        System.out.println(" LA COORD. GEOCENTRICA DE X ES: "
            +String.format("%.4f",coordX));

        //CALCULO DE LA COORDENADA GEOCENTRICA Y
        double coordY = (curVert +
            altElipsoidal)*(Math.cos(lat*Math.PI/180)*
              Math.sin(lon*Math.PI/180));
        System.out.println(" LA COORD. GEOCENTRICA DE Y ES: "
              +String.format("%.4f",coordY));

        //CALCULO DE LA ALTURA GEOCENTRICA Z
        double alturaZ = (((1-
              primExcentricidad)*curVert)+altElipsoidal)*
                (Math.sin(lat*Math.PI/180));
        System.out.println("LA ALTURA GEOCENTRICA Z ES: "
              +String.format("%.4f",alturaZ));
    }
}
