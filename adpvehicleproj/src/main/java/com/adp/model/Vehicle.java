package com.adp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle
{
    private String[] content;

	
    private String id;

	
    private String powertrain;

	
	private Frame frame;

	
	private Wheels wheels;
	
	private String type;
	
	private String wheelMaterial;
	
	private int numofWheels;

    public int getNumofWheels() {
    	if (wheels!=null && wheels.getWheel()!=null){
    		this.numofWheels=wheels.getWheel().length;
    	}
		return numofWheels;
	}

	public void setNumofWheels(int numofWheels) {
		this.numofWheels = numofWheels;
	}

	public String getWheelMaterial() {
    	
    	if (wheels.getWheel()!=null && wheels.getWheel().length>0){
    		this.wheelMaterial=wheels.getWheel()[0].getMaterial();
    	}
    	return wheelMaterial;
	}

	public void setWheelMaterial(String wheelMaterial) {
		this.wheelMaterial = wheelMaterial;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getContent ()
    {
        return content;
    }

    public void setContent (String[] content)
    {
        this.content = content;
    }

    public String getId ()
    {
        return id;
    }
    @XmlElement
    public void setId (String id)
    {
        this.id = id;
    }

    public String getPowertrain ()
    {
        return powertrain;
    }
    @XmlElement
    public void setPowertrain (String powertrain)
    {
        this.powertrain = powertrain;
    }

    public Frame getFrame ()
    {
        return frame;
    } 
    @XmlElement
    public void setFrame (Frame frame)
    {
        this.frame = frame;
    }

    public Wheels getWheels ()
    {
        return wheels;
    }
    @XmlElement
    public void setWheels (Wheels wheels)
    {
        this.wheels = wheels;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", id = "+id+", powertrain = "+powertrain+", frame = "+frame+", wheels = "+wheels+"]";
    }
}
