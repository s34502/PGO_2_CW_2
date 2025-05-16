public class Main {
    public static void main(String[] args) {
        SystemRezerwacji system = new SystemRezerwacji();

        // Dodaj wydarzenia i klientów
        Wydarzenie koncert = new Wydarzenie("Koncert Symphony", 120.0);
        Wydarzenie teatr = new Wydarzenie("Hamlet", 85.0, "2023-12-15", "Teatr Narodowy");
        system.dodajWydarzenie(koncert);
        system.dodajWydarzenie(teatr);

        Klient klient1 = new Klient("Jan", "Kowalski", "jan@example.com");
        Klient klient2 = new Klient("Anna", "Nowak");
        system.dodajKlienta(klient1);
        system.dodajKlienta(klient2);

        // Dokonaj rezerwacji
        system.dokonajRezerwacji(klient1, koncert);
        system.dokonajRezerwacji(klient1, teatr);
        system.dokonajRezerwacji(klient2, koncert);

        // Wyświetl rezerwacje klienta
        System.out.println("\nRezerwacje klienta " + klient1.getImię() + " " +
                klient1.getNazwisko() + ":");
        klient1.wyświetlRezerwacje();

        // Pobierz referencje do wydarzenia z systemu
        Wydarzenie koncertRef = system.znajdźWydarzenie("Koncert Symphony");

        // Modyfikacja wydarzenia przez referencję
        System.out.println("\nZmiana ceny koncertu z " + koncertRef.getCena() + " na 150.0 zł");
        koncertRef.setCena(150.0);

        // Sprawdź czy zmiany są widoczne w rezerwacjach klientów
        System.out.println("\nRezerwacje klienta " + klient1.getImię() + " " +
                klient1.getNazwisko() + " po zmianie ceny:");
        klient1.wyświetlRezerwacje();

        System.out.println("\nRezerwacje klienta " + klient2.getImię() + " " +
                klient2.getNazwisko() + " po zmianie ceny:");
        klient2.wyświetlRezerwacje();

        // Klient anuluje rezerwacje
        System.out.println("\nKlient " + klient1.getImię() + " anuluje rezerwacje na teatr:");
        klient1.anulujRezerwacje(teatr);
        klient1.wyświetlRezerwacje();

        // Sprawdź liczbę dostępnych miejsc na koncercie
        System.out.println("\nDostępne miejsca na koncercie: " + koncert.getDostępneMiejsca() +
                " z " + koncert.getMaxLiczbaMiejsc());
    }
}