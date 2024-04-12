package edu.upc.dsa.models;

public class Dron {
    private String idDron;
    private String name;
    private String fabricant;
    private String model;
    private double flownHours;
    private int repair = 0;

    public Dron(String idDron, String name,String fabricant, String model){
        this.idDron = idDron;
        this.fabricant = fabricant;
        this.name = name;
        this.model = model;
        this.flownHours = flownHours;
        this.repair=repair;
    }

    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFlownHours() {
        return flownHours;
    }

    public void setFlownHours(double flownHours) {
        this.flownHours = flownHours;
    }

    public int getRepair() {
        return repair;
    }

    public void setRepair(int repair) {
        this.repair = repair;
    }
}
