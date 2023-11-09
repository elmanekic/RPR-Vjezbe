package ba.unsa.etf.rpr.lv3.test;

import ba.unsa.etf.rpr.lv3.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestImenik {
    private static Imenik imenik=new Imenik();

    public static void pocetniPodaci(){

        try {
            imenik.dodaj("Elma", new FiksniBroj(Grad.SARAJEVO, "123-123"));
            imenik.dodaj("Dinela", new FiksniBroj(Grad.TRAVNIK, "234-234"));
            imenik.dodaj("Emina", new MobilniBroj(62, "345-185"));
            imenik.dodaj("Mark", new MedjunarodniBroj("+1", "6179514418"));
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
}

@Test
    public void testDodaj(){
        String ime="Hana";
        TelefonskiBroj br=null;
        assertThrows(NeispravanParametarException.class, ()->{imenik.dodaj(ime,br);});
    }
@Test
    public void testDajBroj(){
        assertEquals("123-123",imenik.dajBroj("Elma"));
    }

@Test
public void testNaSlovoNull(){
        String imena=imenik.naSlovo('C');
        assertNull(imena);
}

}