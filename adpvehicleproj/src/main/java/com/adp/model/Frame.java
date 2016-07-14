package com.adp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Frame
{
    private String[] content;
	
    private String material;

    public String[] getContent ()
    {
        return content;
    }

    public void setContent (String[] content)
    {
        this.content = content;
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
        return "ClassPojo [content = "+content+", material = "+material+"]";
    }
}
			
		
