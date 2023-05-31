import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
/**
 * Die Test-Klasse PersonQueueTest, testen die Funktionalitaet 
 * der Methoden aus der Klasse PersonQueue.
 *
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
 */
public class PersonQueueTest
{
    //________________________SIZE____________________________________

    @Test
    public void testSize_anzahl_der_elemente_im_array_mit_5_erwarte_5() 
    {
        PersonQueue pQueue = new PersonQueue();

        pQueue.addLast(new Person("Louisa May",      "Alcott"));
        pQueue.addLast(new Person("Jane",            "Austen"));
        pQueue.addLast(new Person("Emily",           "Bronte"));
        pQueue.addLast(new Person("Charlotte",       "Bronte"));
        pQueue.addLast(new Person("Laura-Elizabeth", "Ingalls Wilder"));

        assertEquals(5, pQueue.size());
    }

    @Test
    public void testSize_anzahl_der_elemente_im_array_mit_3_erwarte_3() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Louisa May", "Alcott"));
        pQueue.addLast(new Person("Jane",       "Austen"));
        pQueue.addLast(new Person("Emily",      "Bronte"));

        assertEquals(3, pQueue.size());
    }

    @Test
    public void testSize_anzahl_der_elemente_im_array_mit_4_erwarte_4() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Louisa",    "Alcott"));
        pQueue.addLast(new Person("Jane",      "Austen"));
        pQueue.addLast(new Person("Emily",     "Bronte"));
        pQueue.addLast(new Person("Charlotte", "Bronte"));

        assertEquals(4, pQueue.size());
    }

    @Test
    public void testSize_anzahl_der_elemente_im_array_mit_leerem_Array() 
    {
        PersonQueue pQueue = new PersonQueue();

        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{
                    pQueue.size();
            });
    }

    
    //________________________REMOVE_FIRST___________________________
    
    @Test
    public void testremoveFirst_erwarte_rueckgabe_der_der_ersten_person() 
    {
        PersonQueue pQueue = new PersonQueue();
        Person expectedPerson = new Person("Jane", "Austen");
        pQueue.addLast(expectedPerson);
        pQueue.addLast(new Person("Emily", "Bronte"));
        Person actualPerson = pQueue.removeFirst();
        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void testRemoveFirst_Person_aus_leerer_Queue_loeschen_erwartet_Exception() 
    {
        PersonQueue pQueue = new PersonQueue();

        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{
                    pQueue.removeFirst();
            });
    }

    
    //________________________GET___________________________________
    
    @Test
    public void testGet_mit_index_1_erwarte_korrekte_rueckgabe() 
    {
        PersonQueue personQueue = new PersonQueue();

        Person person1 = new Person("Louisa", "Alcott");
        Person person2 = new Person("Jane",   "Austen");
        personQueue.addLast(person1);
        personQueue.addLast(person2);

        Person aufgerufenePerson = personQueue.get(1);

        assertEquals(person2, aufgerufenePerson);
    }   

    @Test
    public void test_get_mit_ungueltigem_Index_erwartet_Exception() 
    {
        PersonQueue pQueue = new PersonQueue(3);

        pQueue.addLast(new Person("Charlotte", "Bronte"));
        pQueue.addLast(new Person("Laura",     "Ingalls"));
        pQueue.addLast(new Person("Emily",     "Bronte"));

        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{
                    pQueue.get(5);
            });
    }

    
    //________________________ADD_LAST___________________________
    
    @Test
    public void testAddLast_anzahl_der_elemente_im_array_mit_3_erwarte_3() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Louisa", "Alcott"));
        pQueue.addLast(new Person("Jane",   "Austen"));
        pQueue.addLast(new Person("Emily",  "Bronte"));

        assertEquals(pQueue.size(), 3);
    }

    @Test
    public void testAddLast_Person_in_volle_Queue_hinzufuegen_erwartet_Exception() 
    {
        PersonQueue pQueue = new PersonQueue(1);

        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{
                    pQueue.addLast(new Person("Jane",  "Austen"));
                    pQueue.addLast(new Person("Emily", "Bronte"));
            });
    }

    
    //________________________PRINT___________________________
    
    @Test
    void testPrint_mit_3_Personen_im_Array() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Louisa", "Alcott"));
        pQueue.addLast(new Person("Jane",   "Austen"));
        pQueue.addLast(new Person("Emily",  "Bronte"));

        pQueue.print();

        assertEquals(pQueue.size(), 3);
    }

    
    //________________________SMALLEST___________________________
    
    @Test
    public void testSmallest_mit_1_Person_im_Array() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Emily", "Bronte"));

        assertEquals(pQueue.smallest(), "Bronte Emily");
    }

    @Test
    public void testSmallest_mit_3_Personen_im_Array() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Louisa", "Alcott"));
        pQueue.addLast(new Person("Jane",   "Austen"));
        pQueue.addLast(new Person("Emily",  "Bronte"));

        assertEquals(pQueue.smallest(), "Alcott Louisa");
    }

    @Test
    public void testSmallest_mit_3_Personen_im_Array_nur_KBS() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("louisa", "alcott"));
        pQueue.addLast(new Person("jane",   "austen"));
        pQueue.addLast(new Person("emily",  "bronte"));

        assertEquals(pQueue.smallest(), "alcott louisa");
    }

    @Test
    public void testSmallest_mit_3_Personen_im_Array_nur_GBS() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("LOUISA", "ALCOTT"));
        pQueue.addLast(new Person("JANE",   "AUSTEN"));
        pQueue.addLast(new Person("EMILY",  "BRONTE"));

        assertEquals(pQueue.smallest(), "ALCOTT LOUISA");
    }

    @Test
    public void testSmallest_mit_3_Personen_und_zwei_gleichen_Nachnamen() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Charlotte", "Bronte"));
        pQueue.addLast(new Person("Laura",     "Ingalls"));
        pQueue.addLast(new Person("Emily",     "Bronte"));

        assertEquals(pQueue.smallest(), "Bronte Charlotte");
    }

    @Test
    public void testSmallest_mit_3_Personen_und_2_gleichen_Nachnamen_andere_Reihenfolge() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Emily",     "Bronte"));
        pQueue.addLast(new Person("Laura",     "Ingalls"));
        pQueue.addLast(new Person("Charlotte", "Bronte"));

        assertEquals(pQueue.smallest(), "Bronte Charlotte");
    }

    @Test
    public void testSmallest_mit_3_Personen_und_Doppelnamen_mit_LZ() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Edith",     "Wharton"));
        pQueue.addLast(new Person("Laura",     "Ingalls Wilder"));
        pQueue.addLast(new Person("Mary",      "Ingalls"));

        assertEquals(pQueue.smallest(), "Ingalls Mary");
    }

    @Test
    public void testSmallest_mit_3_Personen_und_Doppelnamen_mit_BS() 
    {
        PersonQueue pQueue = new PersonQueue(5);

        pQueue.addLast(new Person("Edith",     "Wharton"));
        pQueue.addLast(new Person("Laura",     "Ingalls-Wilder"));
        pQueue.addLast(new Person("Mary",      "Ingalls"));

        assertEquals(pQueue.smallest(), "Ingalls Mary");
    }

    @Test
    public void testSmallest_mit_2_gleichen_Nachnamen_und_Doppelnamen_mit_LZ_und_BS() 
    {
        PersonQueue pQueue = new PersonQueue();

        pQueue.addLast(new Person("Louisa May",      "Alcott"));
        pQueue.addLast(new Person("Jane",            "Austen"));
        pQueue.addLast(new Person("Emily",           "Bronte"));
        pQueue.addLast(new Person("Charlotte",       "Bronte"));
        pQueue.addLast(new Person("Laura-Elizabeth", "Ingalls Wilder"));

        assertEquals(pQueue.smallest(), "Alcott Louisa May");
    }

    @Test
    public void testSmallest_leeres_Array_erwartet_Exception() 
    {
        PersonQueue pQueue = new PersonQueue(1);

        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{
                    pQueue.smallest();
            });
    }
}
