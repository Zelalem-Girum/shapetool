package com.example.shapetool.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.shapetool.generated.*;

@Endpoint
public class ShapeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/shapetool";

    // ================= CIRCLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "circleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circleArea(@RequestPayload CircleAreaRequest request) {

        if (request.getRadius() <= 0) {
            throw new RuntimeException("Radius must be positive");
        }

        CircleAreaResponse response = new CircleAreaResponse();
        double radius = request.getRadius();
        double area = Math.PI * radius * radius;

        response.setArea(area);
        return response;
    }

    // ================= SQUARE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "squareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse squareArea(@RequestPayload SquareAreaRequest request) {

        if (request.getSide() <= 0) {
            throw new RuntimeException("Side must be positive");
        }

        SquareAreaResponse response = new SquareAreaResponse();
        double side = request.getSide();

        response.setArea(side * side);
        return response;
    }

    // ================= RECTANGLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "rectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse rectangleArea(@RequestPayload RectangleAreaRequest request) {

        if (request.getLength() <= 0 || request.getWidth() <= 0) {
            throw new RuntimeException("Length and Width must be positive");
        }

        RectangleAreaResponse response = new RectangleAreaResponse();
        double area = request.getLength() * request.getWidth();

        response.setArea(area);
        return response;
    }

    // ================= PARALLELOGRAM =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "parallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse parallelogramArea(@RequestPayload ParallelogramAreaRequest request) {

        if (request.getBase() <= 0 || request.getHeight() <= 0) {
            throw new RuntimeException("Base and Height must be positive");
        }

        ParallelogramAreaResponse response = new ParallelogramAreaResponse();
        double area = request.getBase() * request.getHeight();

        response.setArea(area);
        return response;
    }

    // ================= TRIANGLE =================
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "triangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse triangleArea(@RequestPayload TriangleAreaRequest request) {

        if (request.getBase() <= 0 || request.getHeight() <= 0) {
            throw new RuntimeException("Base and Height must be positive");
        }

        TriangleAreaResponse response = new TriangleAreaResponse();
        double area = 0.5 * request.getBase() * request.getHeight();

        response.setArea(area);
        return response;
    }
}