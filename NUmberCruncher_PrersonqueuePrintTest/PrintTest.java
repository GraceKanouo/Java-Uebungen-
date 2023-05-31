import java.io.*;
/**
 * Die Klasse PrintTest ermoeglicht es die Funktionalitaet
 * der Methoden print() und toString() aus der 
 * PersonQueue-Klasse zu testen.
 * 
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
 */
public class PrintTest
{
    public static void main(String[] args) 
    {
        PersonQueue pQueue = new PersonQueue();

        pQueue.addLast(new Person("Louisa May",      "Alcott"));
        pQueue.addLast(new Person("Jane",            "Austen"));
        pQueue.addLast(new Person("Emily",           "Bronte"));
        pQueue.addLast(new Person("Charlotte",       "Bronte"));
        pQueue.addLast(new Person("Laura-Elizabeth", "Ingalls Wilder"));

        System.out.println("Warteschlange mit print():\n");
        pQueue.print();

        System.out.println("\n\nWarteschlange mit toString():\n");
        System.out.println(pQueue.toString());
    }
}