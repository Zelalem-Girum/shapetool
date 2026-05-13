package com.example.shapetool.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CircleAreaRequest", namespace = "http://example.com/shapetool")
@XmlAccessorType(XmlAccessType.FIELD)
public class CircleAreaRequest {

    @XmlElement(required = true)
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
