package ba.unsa.etf.rpr.lv2;

public class Math {

    public static double stepen(double n, int pow){
      double proizvod=1;
      for(int i=0; i<pow; i++){
          proizvod*=n;
      }
      return proizvod;
    }

    public static int fact(int n){
        int f=1;
        for(int i=2; i<=n; i++){
            f=f*i;
        }
        return f;
    }

    public static double sin(double n){
        double suma=0;
        for(int i=0; i<=6; i++){
            suma+=stepen(-1,i)*(stepen(n,2*i+1)/fact(2*i+1));
        }
        return suma;
    }
}
