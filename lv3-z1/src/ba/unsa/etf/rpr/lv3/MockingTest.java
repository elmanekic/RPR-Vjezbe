package ba.unsa.etf.rpr.lv3;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockingTest {

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
    void testSaMapom() {
        Map<String, String> mockMap = Mockito.mock(Map.class);
        when(mockMap.get("Emina")).thenReturn("062/444-555");

        assertEquals("062/444-555", mockMap.get("Emina"));
    }

    @Test
    void testImenika(){
        Imenik i= Mockito.mock(Imenik.class);
        Mockito.when(i.naSlovo('k')).thenReturn("Nema osoba");

        String poruka=i.naSlovo('k');
        assertEquals(poruka,"Nema osoba");
    }


}
