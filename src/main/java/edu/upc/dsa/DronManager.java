package edu.upc.dsa;

import edu.upc.dsa.exceptions.DronYaExiste;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.FlightPlan;
import edu.upc.dsa.models.Pilot;

import java.util.List;

public interface DronManager {
    public List<Dron> dronesbyFlownHours();
    public List<Pilot> pilotesbyFlownHours();
    public List<FlightPlan> pilotFlightPlans(Pilot pilot);
    public List<FlightPlan> dronFlightPlans(Dron dron);
    public void addDron(String idDron, String name, String fabricant, String model) throws DronYaExiste;
    public void addPilot(String idPilot, String name, String surname);
    public void storeDron(Dron dron);
    //public void repairDron(Dron dron);
    public void bookFlightPlan(String idDron, double fecha, double duration, double initialPos, double destPos, String idPilot);
    public int size();
    public void repararDron();

    int numDron();

    int numPilots();

    int numFlightPlans();


}
