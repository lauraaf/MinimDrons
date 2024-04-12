package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.FlightPlan;
import edu.upc.dsa.models.Pilot;
import org.apache.log4j.Logger;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DronsManagerImpl implements DronManager{
    private static DronManager instance;
    final static Logger logger = Logger.getLogger(DronsManagerImpl.class);
    List<Dron> listdrons;
    LinkedList<Pilot> listpilots;
    LinkedList<Dron> almacen;
    List<FlightPlan> listflightPlan;


    public static DronManager getInstance() {
        if (instance==null) instance = new DronsManagerImpl();
        return instance;
    }
    public DronsManagerImpl(){
        this.listdrons = new ArrayList<>();
        this.listpilots = new LinkedList<>();
        this.almacen = new LinkedList<>();
        this.listflightPlan = new ArrayList<>();
    }
    public int size() {
        int ret = this.listdrons.size();
        logger.info("size " + ret);

        return ret;
    }



    @Override
    public List<Dron> dronesbyFlownHours() {
        List<Dron> list = listdrons;
        //list.sort((p1,p2)-> Double.compare(p1.getFlownHours(), p2.getFlownHours()));
        return list;
    }

    @Override
    public List<Pilot> pilotesbyFlownHours() {
        List<Pilot> list = listpilots;
        //list.sort((p1,p2)-> Double.compare(p1.getFlownHours(), p2.getFlownHours()));
        return list;
    }

    @Override
    public List<FlightPlan> pilotFlightPlans(Pilot pilot) {
        List<FlightPlan> list = new ArrayList<>();
        FlightPlan fp;
        String id = pilot.getId();
        int i=0;
        for (i=0; i< listflightPlan.size();i++){
            fp = listflightPlan.get(i);
            if(fp.getIdPiloto().equals(id)){
                list.add(fp);
            }

        }
        return list;
    }

    @Override
    public List<FlightPlan> dronFlightPlans(Dron dron) {
        List<FlightPlan> list = new ArrayList<>();
        FlightPlan fp;
        String id = dron.getIdDron();
        int i=0;
        for (i=0; i< listflightPlan.size();i++){
            fp = listflightPlan.get(i);
            if(fp.getIdDron().equals(id)){
                list.add(fp);
            }

        }
        return list;
    }


    @Override
    public void addDron(String idDron, String name, String fabricant, String model) {
        logger.info("Comprovem que aquest dron no existeix");
        if(listdrons.contains(idDron)){
            logger.error("Aquest Dron ja existeix");
        }
        Dron dron = new Dron(idDron, name, fabricant, model);
        listdrons.add(dron);
        logger.info("S'ha afegit el dron correctament");
    }

    @Override
    public void addPilot(String idPilot, String name, String surname) {
        logger.info("Comprovem que aquest pilot no existeix");
        if(listpilots.contains(idPilot)){
            logger.error("Aquest Pilot ja existeix");
        }
        Pilot pilot = new Pilot(idPilot, name, surname);
        listpilots.add(pilot);
        logger.info("S'ha afegit el pilot correctament");
    }

    @Override
    public void storeDron(Dron dron) {
        logger.info("comprovem que el dron existeix");
        String idDron = dron.getIdDron();
        if(listdrons.contains(idDron)){
           almacen.addLast(dron);
           logger.info("El dron es troba dins el almacen");
        }
        else{
            logger.error("El dron amd id: "+idDron+", ja existeix");
        }
    }

    /*@Override
    public void repairDron(Dron dron) {
        logger.info("Comprovem que el dron existeix i que esta al almacen");
        if(almacen.contains(dron)){
            almacen.remove(dron);
        }
        else{
            logger.error("El dron no necessitava reparació");
        }
    }*/
    @Override
    public void repararDron() {
        //Agafem el primer dron que esta al almacen
        Dron dron = almacen.getFirst();
        dron.setRepair(1);
        almacen.remove(dron);
        logger.info("El Dron ha sigut reparat, i es troba fora del almacen");
    }

    @Override
    public int numDron() {
        return listdrons.size();
    }

    @Override
    public int numPilots() {
        return this.listpilots.size();
    }

    @Override
    public int numFlightPlans() {
        return this.listflightPlan.size();
    }

    @Override
    public void bookFlightPlan(String idDron, double fecha, double duration, double initialPos, double destPos, String idPilot) {
        FlightPlan fp = new FlightPlan(idDron, fecha, initialPos, destPos, idPilot, duration);
        logger.info("comprovem que aquest flight plan no existeix");
        if(listflightPlan.contains(fp)){
            logger.error("Aquest FLight Plan ja existeix");
        }
        listflightPlan.add(fp);
        logger.info("Flight Plan Reservat");
    }
}
