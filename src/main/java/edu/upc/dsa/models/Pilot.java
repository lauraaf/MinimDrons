package edu.upc.dsa.models;

public class Pilot {

    private String id;
    private String name;
    private String surname;
    private double flownHours;

    public Pilot() {
        //this.id = RandomUtils.getId();
    }

    public Pilot(String id, String name, String surname) {
        this.id = id;
        this.setName(name);
        this.setSurname(surname);

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String title) {
        this.surname = surname;
    }

    public double getFlownHours() {
        return flownHours;
    }

    public void setFlownHours(double flownHours) {
        this.flownHours = flownHours;
    }

    @Override
    public String toString() {
        return "Pilot [id="+id+", name=" + name +"]";
    }

}