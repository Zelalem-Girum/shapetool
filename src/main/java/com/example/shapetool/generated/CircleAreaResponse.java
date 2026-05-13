package com.example.shapetool.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CircleAreaResponse", namespace = "http://example.com/shapetool")
@XmlAccessorType(XmlAccessType.FIELD)
public class CircleAreaResponse {

    @XmlElement(required = true)
    private double area;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
