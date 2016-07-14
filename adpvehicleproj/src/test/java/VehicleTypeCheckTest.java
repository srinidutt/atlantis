import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.adp.model.Frame;
import com.adp.model.Vehicle;
import com.adp.model.Vehicles;
import com.adp.model.Wheel;
import com.adp.model.Wheels;

public class VehicleTypeCheckTest {

	VehicleTypeCheck vt = null;
	Vehicles vehicles = new Vehicles();
	Vehicle vehicle = new Vehicle();

	/**
	 * setup the initial data.
	 */
	@Before
	public void setUp() {
		vehicles = new Vehicles();
		vehicle = new Vehicle();
		vehicle.setId("vehicle1");
		Frame frame = new Frame();
		frame.setMaterial("plastic");
		vehicle.setFrame(frame);
		vehicle.setPowertrain("human");
		Wheels wheels = new Wheels();
		Wheel[] wheel = new Wheel[3];
		Wheel w1 =new Wheel();
		w1.setMaterial("plastic");
		w1.setMaterial("plastic");
		wheel[0]=w1;
		wheel[1]=w1;
		wheel[2]=w1;
		wheels.setWheel(wheel);
		vehicle.setWheels(wheels);

	}

	/**
	 * Test to perform whether the xml is valid or not
	 */
	@Test
	public void testProcessXMLTest() {
		vt = new VehicleTypeCheck();
		Vehicle[] vehicleList = vt.processXML("vehicles.xml");
		Vehicle vehicle = vehicleList[0];
		assertEquals("plastic",vehicle.getFrame().getMaterial());
		assertEquals(3,vehicle.getNumofWheels());
		assertEquals("human",vehicle.getPowertrain().trim());
	}

	/**
	 * Test to perform invalid file
	 */
	@Test
	public void testProcessXMLInvalidFileTest() {
		vt = new VehicleTypeCheck();
		Vehicle[] vehicleList = vt.processXML("vehicles1.xls");
		assertNull(vehicleList);

	}

	/**
	 * Test for execute method
	 */
	@Test
	public void testExecuteTest() {
		vt = new VehicleTypeCheck();
		Vehicle[] vehicleList = new Vehicle[1];
		vehicleList[0]=vehicle;
		vehicles.setVehicle(vehicleList);
		vt.execute(vehicleList);
		vehicle = vehicleList[0];
		assertEquals("Big Wheel",vehicle.getType());

	}

	/**
	 * Test for executeRules method
	 */
	@Test
	public void executeRulesTest(){
		vt = new VehicleTypeCheck();
		System.out.println("vehicle" + vehicle);
		Vehicle returnvehicle = vt.executeRules(vehicle);
		assertEquals("Big Wheel",returnvehicle.getType());
	}



}
