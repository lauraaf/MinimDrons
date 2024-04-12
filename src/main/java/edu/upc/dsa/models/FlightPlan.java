package edu.upc.dsa.models;

public class FlightPlan {
    private String idDron;
    private double duration;
    private double initialPos;
    private double destPos;
    private String idPiloto;
    private double fecha;
    public FlightPlan(){

    }
    public FlightPlan(String idDron, double duration, double initialPos, double destPos, String idPiloto, double fecha){
        this.idDron = idDron;
        this.duration = duration;
        this.initialPos =initialPos;
        this.destPos = destPos;
        this.idPiloto = idPiloto;
        this.fecha = fecha;
    }

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getInitialPos() {
        return initialPos;
    }

    public void setInitialPos(double initialPos) {
        this.initialPos = initialPos;
    }

    public double getDestPos() {
        return destPos;
    }

    public void setDestPos(double destPos) {
        this.destPos = destPos;
    }

    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }

    public double getFecha() {
        return fecha;
    }

    public void setFecha(double fecha) {
        this.fecha = fecha;
    }
}
