package com.adp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Powertrain
{
	private String[] content;


	private String human;

    public String[] getContent ()
    {
        return content;
    }

    public void setContent (String[] content)
    {
        this.content = content;
    }

    public String getHuman ()
    {
        return human;
    }

    @XmlElement
    public void setHuman (String human)
    {
        this.human = human;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", human = "+human+"]";
    }
}