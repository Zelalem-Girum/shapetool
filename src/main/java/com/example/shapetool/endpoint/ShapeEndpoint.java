package com.example.shapetool.endpoint;

import com.example.shapetool.generated.CircleAreaRequest;
import com.example.shapetool.generated.CircleAreaResponse;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CircleAreaRequest")
    @ResponsePayload
    public CircleAreaResponse circleArea(@RequestPayload CircleAreaRequest request) {

        CircleAreaResponse response = new CircleAreaResponse();
        response.setArea(shapeService.calculateCircleArea(request.getRadius()));

        return response;
    }
}
