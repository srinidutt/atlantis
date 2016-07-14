package com.adp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicles
{
	
    private String content;

   
    private Vehicle[] vehicle;

    public String getContent ()
    {
        return content;
    }
    @XmlElement
    public void setContent (String content)
    {
        this.content = content;
    }

    public Vehicle[] getVehicle ()
    {
        return vehicle;
    }

    public void setVehicle (Vehicle[] vehicle)
    {
        this.vehicle = vehicle;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", vehicle = "+vehicle+"]";
    }
}
	