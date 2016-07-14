import java.io.File;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.kie.internal.KnowledgeBase;
import org.kie.internal.runtime.StatelessKnowledgeSession;

import com.adp.model.Vehicle;
import com.adp.model.Vehicles;
import com.adp.model.Wheel;
import com.adp.service.VehicleDecisionTableRulesSerivce;
import com.adp.util.Constants;


public class VehicleTypeCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleTypeCheck vt = new VehicleTypeCheck();
		Vehicle[] vehicleList = vt.processXML(Constants.vehiclexmlFile);
		vt.execute(vehicleList);
	}

	/**
	 * @return
	 */
	@SuppressWarnings("restriction")
	public Vehicle[] processXML(String xmlFile) {
		JAXBContext jc;
		Vehicle[] vehicleList = null;
		try {
			jc = JAXBContext.newInstance(Vehicles.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(xmlFile).getFile());
			Vehicles vehicles = (Vehicles) unmarshaller.unmarshal(file);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(vehicles, System.out);
			vehicleList = vehicles.getVehicle();
		} catch (JAXBException e) {
			System.out.println("JAXBException in processXML:" + e);
		} catch (Exception e){
			System.out.println("Exception in processXML:" + e);
		}
		return vehicleList;
	}

	/**
	 * @param vehicleList
	 */
	public void execute(Vehicle[] vehicleList) {
		for (Vehicle vehicle : vehicleList) {
			vehicle = executeRules(vehicle);
			System.out.println("vehicle ID: " + vehicle.getId() + " Type:" + vehicle.getType());
		}

	}
	

	/**
	 * @param vehicle
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Vehicle executeRules(Vehicle vehicle) {
		StatelessKnowledgeSession session;
		KnowledgeBase knowledgeBase = null;
		try {
			knowledgeBase = VehicleDecisionTableRulesSerivce.createKnowledgeBaseFromSpreadsheet(Constants.vehicleRulesFile);
			session = knowledgeBase.newStatelessKnowledgeSession();
			session.execute(vehicle);
		} catch (Exception e) {
			System.out.println("Exception in executeRules" + e);
		}
		
		return vehicle;
	}

}
