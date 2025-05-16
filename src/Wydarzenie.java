import java.util.Objects;

public class Wydarzenie {
    private String nazwa;
    private String data;
    private String miejsce;
    private int maxLiczbaMiejsc;
    private int dostępneMiejsca;
    private double cena;

    // Konstruktory
    public Wydarzenie(String nazwa, double cena) {
        this(nazwa, cena, "Nie określono", "Nie określono");
    }

    public Wydarzenie(String nazwa, double cena, String data) {
        this(nazwa, cena, data, "Nie określono");
    }

    public Wydarzenie(String nazwa, double cena, String data, String miejsce) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.data = data;
        this.miejsce = miejsce;
        this.maxLiczbaMiejsc = 100;
        this.dostępneMiejsca = this.maxLiczbaMiejsc;
    }

    // Gettery i settery
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public int getMaxLiczbaMiejsc() {
        return maxLiczbaMiejsc;
    }

    public void setMaxLiczbaMiejsc(int maxLiczbaMiejsc) {
        this.maxLiczbaMiejsc = maxLiczbaMiejsc;
    }

    public int getDostępneMiejsca() {
        return dostępneMiejsca;
    }

    public void setDostępneMiejsca(int dostępneMiejsca) {
        this.dostępneMiejsca = dostępneMiejsca;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    // Metody
    public void zarezerwujMiejsce() {
        if (dostępneMiejsca > 0) {
            dostępneMiejsca--;
        } else {
            System.out.println("Brak dostępnych miejsc na wydarzenie: " + nazwa);
        }
    }

    @Override
    public String toString() {
        return "Wydarzenie: " + nazwa +
                ", Data: " + data +
                ", Miejsce: " + miejsce +
                ", Cena: " + cena + " zł" +
                ", Dostępne miejsca: " + dostępneMiejsca + "/" + maxLiczbaMiejsc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wydarzenie that = (Wydarzenie) o;
        return Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(data, that.data) &&
                Objects.equals(miejsce, that.miejsce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, data, miejsce);
    }
}