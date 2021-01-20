package logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Kamp {




    int kamp_id;
    Hold hjemmehold;
    Hold udehold;
    LocalDate dato;
    LocalTime tidspunkt;

    public Kamp(String hjemmehold, String udehold, LocalDate dato, LocalTime tidspunkt) {
        this.hjemmehold = hjemmehold;
        this.udehold = udehold;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
    }

    public int getId() {
        return kamp_id;
    }

    public void setId(int kamp_id) {
        this.kamp_id = kamp_id;
    }

    public Hold getHjemmehold() {
        return hjemmehold;
    }

    public void setHjemmehold(String hjemmehold) {
        this.hjemmehold = hjemmehold;
    }

    public String getUdehold() {
        return udehold;
    }

    public void setUdehold(String udehold) {
        this.udehold = udehold;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(LocalTime tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Kamp{" +
                "hjemmehold='" + hjemmehold + '\'' +
                ", udehold='" + udehold + '\'' +
                ", dato=" + dato +
                ", tidspunkt=" + tidspunkt +
                '}';
    }
}
