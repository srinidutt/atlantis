package com.adp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Wheels
{
    private String[] content;
    
    private Wheel[] wheel;

    public String[] getContent ()
    {
        return content;
    }

    public void setContent (String[] content)
    {
        this.content = content;
    }

    public Wheel[] getWheel ()
    {
        return wheel;
    }
    @XmlElement(name="wheel")
    public void setWheel (Wheel[] wheel)
    {
        this.wheel = wheel;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", wheel = "+wheel+"]";
    }
}
