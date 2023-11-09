package ba.unsa.etf.rpr.lv3;

import java.util.Scanner;
import java.util.Set;

public class Program {
    public static Scanner ulaz=new Scanner(System.in);
    public static Imenik imenik=new Imenik();
    public static void main(String[] args){


       while(true){
           System.out.println("Unesite jednu od sljedecih opcija: 'dodaj', 'dajBroj', 'dajIme', 'naSlovo', 'izGrada', 'izGradaBrojevi' ili 'kraj' za kraj:");
           String ln=ulaz.nextLine();
           switch(ln){
               case "dodaj":
                   dodaj();
                   break;

               case "dajBroj":
                   dajBroj();
                   break;

               case "dajIme":
                   dajIme();
                   break;

               case "naSlovo":
                   naSlovo();
                   break;

               case "izGrada":
                   izGrada();
                   break;

               case "izGradaBrojevi":
                   izGradaBrojevi();
                   break;

               case "kraj":
                   System.exit(0);
                   break;
               default:
                   System.out.println("Neispravna komanda");
           }
       }
}

//Metode koje omogucavaju unos podataka za obradu u metodama pojedinacnih klasa
private static void dodaj(){
        System.out.println("Unesi ime: ");
        String ime=ulaz.nextLine();
        TelefonskiBroj br=unesiBr();
        try {
            imenik.dodaj(ime, br);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    //metoda koja kreira brojeve na osnovu potrebnog izvedenog tipa
    private static TelefonskiBroj unesiBr(){
        System.out.println("Unesi tip broja: ");
        String tip=ulaz.nextLine();

        switch(tip){
            case "fiksni":
                try{
                System.out.println("Unesi pozivni broj: ");
                String p=ulaz.nextLine();
                System.out.println("Unesi broj: ");
                String br=ulaz.nextLine();
                Grad g=Grad.ocitajGrad(p);

                    return new FiksniBroj(g,br);
                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                    break;
                }
            case "mobilni":
                System.out.println("Unesi mobilnu mrezu: ");
                int mm=ulaz.nextInt();
                ulaz.nextLine();
                System.out.println("Unesi broj: ");
                String mbr=ulaz.nextLine();
                return new MobilniBroj(mm,mbr);

            case "medjunarodni":
                System.out.println("Unesi drzavu: ");
                String d=ulaz.nextLine();
                System.out.println("Unesi broj: ");
                String medbr=ulaz.nextLine();
                return new MedjunarodniBroj(d,medbr);

        }
        return null;
    }

private static void dajBroj(){
        System.out.println("Unesi ime: ");
        String ime=ulaz.nextLine();
        String br=imenik.dajBroj(ime);
        if(br==null) System.out.println("U imeniku nema broja pod tim imenom");
        else System.out.println (br);
}

private static void dajIme(){
        System.out.println("Unesi broj: ");
        TelefonskiBroj br=unesiBr();
       String ime = imenik.dajIme(br);
        if(ime==null) System.out.println("U imeniku nema imena pod tim brojem");
        else System.out.println(ime);

}

private static void naSlovo(){
        System.out.println("Unesi prvo slobo imena: ");
        String slovo=ulaz.nextLine();
        String rez=imenik.naSlovo(slovo.toCharArray()[0]);
        System.out.println(rez);
}

private static void izGrada(){
        System.out.println("Unesi grad: ");
        String grad=ulaz.nextLine();
        try{
            Grad g=Grad.valueOf(grad);
            Set<String> rez=imenik.izGrada(g);
            for(String ime:rez){
                System.out.println(ime);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return;
        }
}

private static void izGradaBrojevi(){
        System.out.println("Unesi grad: ");
        String grad=ulaz.nextLine();
        try{
            Grad g=Grad.valueOf(grad);
            Set<TelefonskiBroj> rez=imenik.izGradaBrojevi(g);
            for(TelefonskiBroj b:rez){
                System.out.println(b.ispisi());
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return;
        }

}
}
