package com.example.shapetool.service;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
