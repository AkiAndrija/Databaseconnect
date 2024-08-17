import java.io.Serializable;

public class Izvodjac implements Serializable {
    private int id;
    private String nazivIzvodjaca;
    private String tipIzvodjaca;
    private int godinaFormacije;
    private Integer godinaRaspada;

    private String zvanicanSajt;


    public Izvodjac() {
    }

    public Izvodjac(int id, String nazivIzvodjaca, String tipIzvodjaca, int godinaFormacije, Integer godinaRaspada, String zvanicanSajt) {
        this.id=id;
        this.nazivIzvodjaca=nazivIzvodjaca;
        this.tipIzvodjaca=tipIzvodjaca;
        this.godinaFormacije=godinaFormacije;
        this.godinaRaspada=godinaRaspada;
        this.zvanicanSajt=zvanicanSajt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivIzvodjaca() {
        return this.nazivIzvodjaca;
    }

    public void setNazivIzvodjaca(String nazivIzvodjaca) {
        this.nazivIzvodjaca = nazivIzvodjaca;
    }

    public String getTipIzvodjaca() {
        return tipIzvodjaca;
    }

    public void setTipIzvodjaca(String tipIzvodjaca) {
        this.tipIzvodjaca = tipIzvodjaca;
    }

    public int getGodinaFormacije() {
        return godinaFormacije;
    }

    public void setGodinaFormacije(int godinaFormacije) {
        this.godinaFormacije = godinaFormacije;
    }

    public Integer getGodinaRaspada() {
        return godinaRaspada;
    }

    public void setGodinaRaspada(Integer godinaRaspada) {
        this.godinaRaspada = godinaRaspada;
    }

    public String getZvanicanSajt() {
        return zvanicanSajt;
    }

    public void setZvanicanSajt(String zvanicniSajt) {
        this.zvanicanSajt = zvanicniSajt;
    }

    @Override
    public String toString() {
        return getId() + "\t" + getNazivIzvodjaca() + "\t" + getTipIzvodjaca() + "\t" + getGodinaFormacije() + "\t" + getGodinaRaspada() + "\t" + getZvanicanSajt();
    }

    }
