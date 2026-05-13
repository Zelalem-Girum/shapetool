package com.example.shapetool.config;

import com.example.shapetool.config.InvalidInputException;
import org.springframework.stereotype.Component;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import java.util.Properties;

@Component
public class GlobalSoapFaultHandler extends SoapFaultMappingExceptionResolver {

    public GlobalSoapFaultHandler() {
        Properties errorMappings = new Properties();
        errorMappings.setProperty(
                InvalidInputException.class.getName(),
                SoapFaultDefinition.CLIENT.toString()
        );

        setExceptionMappings(errorMappings);

        SoapFaultDefinition defaultFault = new SoapFaultDefinition();
        defaultFault.setFaultCode(SoapFaultDefinition.SERVER);
        setDefaultFault(defaultFault);
    }

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        fault.getFaultStringOrReason();
    }
}