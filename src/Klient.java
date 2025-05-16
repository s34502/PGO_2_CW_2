import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imię;
    private String nazwisko;
    private String email;
    private List<Wydarzenie> listaRezerwacji;

    // Konstruktory
    public Klient(String imię, String nazwisko, String email) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.email = email;
        this.listaRezerwacji = new ArrayList<>();
    }

    public Klient(String imię, String nazwisko) {
        this(imię, nazwisko, "Nie podano");
    }

    // Gettery i settery
    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Wydarzenie> getListaRezerwacji() {
        return listaRezerwacji;
    }

    // Metody
    public void dodajRezerwację(Wydarzenie wydarzenie) {
        listaRezerwacji.add(wydarzenie);
        wydarzenie.zarezerwujMiejsce();
    }

    public void wyświetlRezerwacje() {
        if (listaRezerwacji.isEmpty()) {
            System.out.println("Brak rezerwacji dla klienta " + imię + " " + nazwisko);
        } else {
            System.out.println("Rezerwacje klienta " + imię + " " + nazwisko + ":");
            for (Wydarzenie w : listaRezerwacji) {
                System.out.println("- " + w);
            }
        }
    }

    public void anulujRezerwacje(Wydarzenie wydarzenie) {
        if (listaRezerwacji.remove(wydarzenie)) {
            wydarzenie.setDostępneMiejsca(wydarzenie.getDostępneMiejsca() + 1);
            System.out.println("Anulowano rezerwację na: " + wydarzenie.getNazwa());
        } else {
            System.out.println("Klient nie ma rezerwacji na to wydarzenie");
        }
    }

    @Override
    public String toString() {
        return imię + " " + nazwisko + " (" + email + ")";
    }
}