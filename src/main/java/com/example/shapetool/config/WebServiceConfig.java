package com.example.shapetool.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig {

    // Register SOAP servlet
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext context) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // Load XSD
    @Bean
    public XsdSchema shapeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/shapetool.xsd"));
    }

    // Auto-generate WSDL
    @Bean(name = "shapetool")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema shapeSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();

        wsdl.setPortTypeName("ShapeToolPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://example.com/shapetool");
        wsdl.setSchema(shapeSchema);

        return wsdl;
    }
}