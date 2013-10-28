package org.ow2.sirocco.cimi.server;

import org.glassfish.jersey.message.MessageProperties;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
    public Application() {
        this.packages("org.ow2.sirocco.cimi.server.resource;org.ow2.sirocco.cimi.server.resource.extension;org.ow2.sirocco.cimi.server.provider");
        this.property(MessageProperties.XML_FORMAT_OUTPUT, true);
    }
}
