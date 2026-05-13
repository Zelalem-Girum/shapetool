package com.example.shapetool.endpoint;

import com.example.shapetool.generated.*;

import com.example.shapetool.service.ShapeService;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ShapeEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/shapetool";

    private final ShapeService shapeService;

    public ShapeEndpoint(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    // Circle Area
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CircleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse getCircleArea(@RequestPayload CircleAreaRequest request) {

        CircleAreaResponse response = new CircleAreaResponse();

        double area = shapeService.calculateCircleArea(request.getRadius());

        response.setArea(area);

        return response;
    }

    // Rectangle Area
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RectangleAreaRequest")
    @ResponsePayload
    public RectangleAreaResponse getRectangleArea(@RequestPayload RectangleAreaRequest request) {

        RectangleAreaResponse response = new RectangleAreaResponse();

        double area = shapeService.calculateRectangleArea(
                request.getLength(),
                request.getWidth());

        response.setArea(area);

        return response;
    }

    // Triangle Area
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TriangleAreaRequest")
    @ResponsePayload
    public TriangleAreaResponse getTriangleArea(@RequestPayload TriangleAreaRequest request) {

        TriangleAreaResponse response = new TriangleAreaResponse();

        double area = shapeService.calculateTriangleArea(
                request.getBase(),
                request.getHeight());

        response.setArea(area);

        return response;
    }

    // Square Area
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SquareAreaRequest")
    @ResponsePayload
    public SquareAreaResponse getSquareArea(@RequestPayload SquareAreaRequest request) {

        SquareAreaResponse response = new SquareAreaResponse();

        double area = shapeService.calculateSquareArea(request.getSide());

        response.setArea(area);

        return response;
    }

    // Parallelogram Area
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ParallelogramAreaRequest")
    @ResponsePayload
    public ParallelogramAreaResponse getParallelogramArea(
            @RequestPayload ParallelogramAreaRequest request) {

        ParallelogramAreaResponse response = new ParallelogramAreaResponse();

        double area = shapeService.calculateParallelogramArea(
                request.getBase(),
                request.getHeight());

        response.setArea(area);

        return response;
    }
}