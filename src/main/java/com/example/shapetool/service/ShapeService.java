package com.example.shapetool.service;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public double calculateCircleArea(double radius) {

        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }

        return Math.PI * radius * radius;
    }

    public double calculateRectangleArea(double length, double width) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }

        return length * width;
    }

    public double calculateTriangleArea(double base, double height) {

        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }

        return 0.5 * base * height;
    }

    public double calculateSquareArea(double side) {

        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }

        return side * side;
    }

    public double calculateParallelogramArea(double base, double height) {

        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }

        return base * height;
    }
}