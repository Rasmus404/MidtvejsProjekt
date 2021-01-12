package sample;

import java.time.LocalDate;
import java.time.LocalTime;

public class Kamp {


    String hjemmehold;
    String udehold;
    LocalDate dato;
    LocalTime tidspunkt;

    public Kamp(String hjemmehold, String udehold, LocalDate dato, LocalTime tidspunkt) {
        this.hjemmehold = hjemmehold;
        this.udehold = udehold;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
    }

    public String getHjemmehold() {
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







}
