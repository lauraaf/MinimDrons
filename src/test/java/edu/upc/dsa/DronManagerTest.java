package edu.upc.dsa;

import edu.upc.dsa.models.Dron;
import junit.framework.Assert;
import org.junit.Test;

public class DronManagerTest {
    DronManager dm;
    @Test
    public void addDronTest(){
        dm.addDron("1","Air10","Volotea","X23");
        dm.addDron("2","F383","Vueling", "343");
        dm.addDron("3","Air98","Iberia","x356");
        Assert.assertEquals(3,dm.numDron());;
    }
    @Test
    public void addPilotTest(){
        dm.addPilot("1","Laura","Fernandez");
        dm.addPilot("2","Ariadna","Carol");
        Assert.assertEquals(2,dm.numPilots());
    }
    @Test
    public void bookFlightPlan(){
        dm.bookFlightPlan("1",14,2, 41.2,2.13,"1");
        dm.bookFlightPlan("2",12,4,41.5,2.15,"2");
        Assert.assertEquals(2, dm.numFlightPlans());
    }
   /* @Test
    public void storeDron(){
        Dron dron = new Dron("1","Air30","Volotea","X23");
        dm.storeDron(dron);
        //Assert.assertEquals();
    }*/


}
