package com.adp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Wheel
{
    private String[] content;
	
    private String position;
	
    private String material;

    public String[] getContent ()
    {
        return content;
    }

    public void setContent (String[] content)
    {
        this.content = content;
    }

    public String getPosition ()
    {
        return position;
    }
    @XmlElement
    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getMaterial ()
    {
        return material;
    }
    @XmlElement
    public void setMaterial (String material)
    {
        this.material = material;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", position = "+position+", material = "+material+"]";
    }
}