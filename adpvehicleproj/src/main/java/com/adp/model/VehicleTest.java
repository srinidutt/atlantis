package com.adp.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleTest vt = new VehicleTest();
		vt.execute();
	}	
	public void execute(){
		 JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Vehicles.class);
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        ClassLoader classLoader = getClass().getClassLoader();
	        File xml = new File(classLoader.getResource("vehicles.xml").getFile());
	        Vehicles vehicles = (Vehicles) unmarshaller.unmarshal(xml);
	        Marshaller marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(vehicles, System.out);
	        Vehicle[] vehicleList = vehicles.getVehicle();	        
	        for(Vehicle vehicle:vehicleList){
	        	checkVehicle(vehicle);
	        }
	        System.out.println("vehicles" + vehicleList[0] );
	        
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Big Wheel plastic Human 3 plastic (front, rear left, rear right) 
	Bicycle metal Human 2 metal (front, rear) 
	Motorcycle metal Internal Combustion 2 metal (front, rear) 
	*/
	public Map<String, String> createDecistionTable(){
		Map<String, String> hm = new HashMap<String,String>();		
		hm.put("Big Wheel", "plastic,human,3-plastic");
		hm.put("Bicycle metal", "metal,human,2-metal");
		hm.put("Car", "plastic,human,4-metal");
		hm.put("Motorcycle", "metal,Internal Combustion,2-metal");
		return hm;
	}
	
	public String checkVehicle(Vehicle vehicle) {
		String str = null;
		Wheel[] wheelList= vehicle.getWheels().getWheel();
		int whnum = vehicle.getNumofWheels();
		System.out.println(whnum);
		String wheels="";
		if(whnum>0)
		 wheels = whnum+"-"+(String)wheelList[0].getMaterial();
		System.out.println(wheels);
		String frame = vehicle.getFrame().getMaterial();
		System.out.println(frame);
		String powertrain = vehicle.getPowertrain();
		System.out.println(powertrain);
		String value = frame+","+powertrain+","+wheels;
		System.out.println(value);
		String key = getKeyFromValue(value);
		System.out.println("**********" +  key);
		return str;
		
	}
	
	public String getKeyFromValue(String val){
		Map<String, String> hm = createDecistionTable();
		String str=null;
		for(String st: hm.keySet()){
			if(val.equals(hm.get(st))){
				str = st;
				break;
			}
		}
		return str;
		
	}
	

}
