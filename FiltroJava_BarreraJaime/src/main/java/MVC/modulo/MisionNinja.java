package MVC.modulo;

import java.util.Date;

public class MisionNinja {
    private int idNinja;
    private int idMision;
    private Date fechaInicio;
    private Date fechaFin;

    public MisionNinja(int idNinja, int idMision, Date fechaInicio, Date fechaFin) {
        this.idNinja = idNinja;
        this.idMision = idMision;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdNinja() {
        return idNinja;
    }

    public void setIdNinja(int idNinja) {
        this.idNinja = idNinja;
    }

    public int getIdMision() {
        return idMision;
    }

    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
