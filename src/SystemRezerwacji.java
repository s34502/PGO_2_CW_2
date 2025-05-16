import java.util.ArrayList;
import java.util.List;

public class SystemRezerwacji {
    private List<Wydarzenie> wydarzenia;
    private List<Klient> klienci;

    public SystemRezerwacji() {
        this.wydarzenia = new ArrayList<>();
        this.klienci = new ArrayList<>();
    }

    // Metody dla wydarzeń
    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        wydarzenia.add(wydarzenie);
    }

    public void dodajWydarzenie(String nazwa, double cena) {
        wydarzenia.add(new Wydarzenie(nazwa, cena));
    }

    // Metody dla klientów
    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
    }

    public void dodajKlienta(String imię, String nazwisko, String email) {
        klienci.add(new Klient(imię, nazwisko, email));
    }

    // Inne metody
    public void dokonajRezerwacji(Klient klient, Wydarzenie wydarzenie) {
        if (klienci.contains(klient) && wydarzenia.contains(wydarzenie)) {
            klient.dodajRezerwację(wydarzenie);
            System.out.println("Dokonano rezerwacji dla " + klient.getImię() + " " +
                    klient.getNazwisko() + " na " + wydarzenie.getNazwa());
        } else {
            System.out.println("Nie można dokonać rezerwacji - brak klienta lub wydarzenia w systemie");
        }
    }

    public Wydarzenie znajdźWydarzenie(String nazwa) {
        for (Wydarzenie w : wydarzenia) {
            if (w.getNazwa().equalsIgnoreCase(nazwa)) {
                return w;
            }
        }
        return null;
    }

    public Klient znajdzKlienta(String nazwisko) {
        for (Klient k : klienci) {
            if (k.getNazwisko().equalsIgnoreCase(nazwisko)) {
                return k;
            }
        }
        return null;
    }

    public void zmieńCenęWydarzenia(String nazwa, double nowaCena) {
        Wydarzenie w = znajdźWydarzenie(nazwa);
        if (w != null) {
            w.setCena(nowaCena);
            System.out.println("Zmieniono cenę wydarzenia " + nazwa + " na " + nowaCena + " zł");
        } else {
            System.out.println("Nie znaleziono wydarzenia o nazwie: " + nazwa);
        }
    }

    // Gettery
    public List<Wydarzenie> getWydarzenia() {
        return wydarzenia;
    }

    public List<Klient> getKlienci() {
        return klienci;
    }
}