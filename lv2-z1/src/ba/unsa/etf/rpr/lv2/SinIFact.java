package ba.unsa.etf.rpr.lv2;


public class SinIFact {

    public static void main(String[] args) {
        if(args.length!=2) System.err.println("Nedovoljan broj argumenata");
        else if(!args[0].equals("sin") && !args[0].equals("fact")) System.err.println("Podrzane su samo funkcije sin i fact");
        else{
            try{
                String funkcija=args[0];
                double n=Double.parseDouble(args[1]);
                switch(funkcija){
                    case "sin":
                        System.out.println("sinus("+n+")="+Math.sin(n));
                        break;

                    case "fact":
                        System.out.println("faktorijel("+n+")="+Math.fact((int)n));
                        break;
                }
            }
            catch(Exception e){
                System.err.println("Nevalidan drugi argument");
            }
        }

    }
}
