/**
 *
 * SIROCCO
 * Copyright (C) 2011 France Telecom
 * Contact: sirocco@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * $Id$
 *
 */
package org.ow2.sirocco.apis.rest.cimi.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * Class ResourceMetadata.
 */
@XmlRootElement(name = "ResourceMetadata")
@XmlType(propOrder = {"id", "name", "typeURI", "attributes", "operations"})
@JsonPropertyOrder({"id", "name", "typeURI", "attributes", "operations"})
@JsonSerialize(include = Inclusion.NON_NULL)
public class CimiResourceMetadata extends CimiResourceAbstract {
    @XmlRootElement(name = "Attribute")
    @JsonSerialize(include = Inclusion.NON_NULL)
    public static class AttributeMetadata implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;

        private String namespace;

        private String type;

        private Boolean required;

        @XmlAttribute
        public String getName() {
            return this.name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        @XmlAttribute
        public String getNamespace() {
            return this.namespace;
        }

        public void setNamespace(final String namespace) {
            this.namespace = namespace;
        }

        @XmlAttribute
        public String getType() {
            return this.type;
        }

        public void setType(final String type) {
            this.type = type;
        }

        @XmlAttribute
        public Boolean getRequired() {
            return this.required;
        }

        public void setRequired(final Boolean required) {
            this.required = required;
        }

    }

    /** Serial number */
    private static final long serialVersionUID = 1L;

    private String typeURI;

    private String name;

    private AttributeMetadata[] attributes;

    public String getTypeURI() {
        return this.typeURI;
    }

    public void setTypeURI(final String typeURI) {
        this.typeURI = typeURI;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @XmlElement(name = "attribute")
    @JsonProperty(value = "attributes")
    public AttributeMetadata[] getAttributes() {
        return this.attributes;
    }

    public void setAttributes(final AttributeMetadata[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean hasValues() {
        boolean has = false;
        has = has || (null != this.getName());
        has = has || (null != this.getTypeURI());
        has = has || (null != this.getAttributes());
        return has;
    }

    @Override
    @JsonIgnore
    public ExchangeType getExchangeType() {
        return ExchangeType.ResourceMetadata;
    }

}
