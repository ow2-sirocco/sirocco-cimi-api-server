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
package org.ow2.sirocco.cimi.server.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ow2.sirocco.cimi.server.validator.GroupWrite;
import org.ow2.sirocco.cimi.server.validator.constraints.NotEmptyIfNotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class with the common attributes of multiple resources.
 */
@XmlTransient
public class CimiCommon implements CimiDataCommon {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    /**
     * Field "name".
     * <p>
     * The human readable name of this entity; assigned by the creator as a part
     * of the entity creation input.
     * </p>
     */
    private String name;

    /**
     * Field "description".
     * <p>
     * The human readable description of this entity; assigned by the creator as
     * a part of the entity creation input.
     * </p>
     */
    private String description;

    /**
     * Field "properties".
     * <p>
     * A list of key/value pairs, some of which may control one or more aspects
     * this entity. Properties may also serve as an extension point, allowing
     * Consumers to record additional information about the resource.
     * </p>
     */
    @JsonProperty
    @NotEmptyIfNotNull(groups = {GroupWrite.class})
    private Map<String, String> properties;

    private Map<String, Object> extensionAttributes;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.domain.CimiDataCommon#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.domain.CimiDataCommon#setName(java.lang
     *      .String)
     */
    @Override
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.domain.CimiDataCommon#getDescription()
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.domain.CimiDataCommon#setDescription(java
     *      .lang.String)
     */
    @Override
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.domain.CimiDataCommon#getProperties()
     */
    @Override
    @XmlTransient
    public Map<String, String> getProperties() {
        return this.properties;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.domain.CimiDataCommon#setProperties(java
     *      .util.Map)
     */
    @Override
    public void setProperties(final Map<String, String> properties) {
        this.properties = properties;
    }

    /**
     * Get all keys-values properties for JAXB.
     * 
     * @return An array with all the keys-values properties
     */
    @JsonIgnore
    @XmlElement(name = "property")
    public KeyValue[] getPropertyArray() {
        List<KeyValue> list = new ArrayList<KeyValue>();
        if (null != this.properties) {
            for (Entry<String, String> entry : this.properties.entrySet()) {
                KeyValue mapEntry = new KeyValue();
                mapEntry.key = entry.getKey();
                mapEntry.value = entry.getValue();
                list.add(mapEntry);
            }
        }
        return list.toArray(new KeyValue[list.size()]);
    }

    /**
     * Set all keys-values properties for JAXB.
     * 
     * @param props An array with all the keys-values properties
     */
    public void setPropertyArray(final KeyValue[] props) {
        this.properties = new HashMap<String, String>();
        for (KeyValue prop : props) {
            this.properties.put(prop.key, prop.value);
        }
    }

    @JsonAnySetter
    public void addExtensionAttribute(final String key, final Object value) {
        if (this.extensionAttributes == null) {
            this.extensionAttributes = new HashMap<String, Object>();
        }
        this.extensionAttributes.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getExtensionAttributes() {
        return this.extensionAttributes;
    }

    public Object getExtensionAttribute(final String key) {
        if (this.extensionAttributes != null) {
            return this.extensionAttributes.get(key);
        } else {
            return null;
        }
    }

    @XmlAnyElement
    @JsonIgnore
    public List<ExtensionAttribute> getXmlExtensionAttributes() {
        List<ExtensionAttribute> xmlExtensionAttributes = new ArrayList<ExtensionAttribute>();
        if (this.extensionAttributes != null) {
            for (Map.Entry<String, Object> entry : this.extensionAttributes.entrySet()) {
                xmlExtensionAttributes.add(new ExtensionAttribute(entry.getKey(), entry.getValue()));
            }
        }
        return xmlExtensionAttributes;
    }

    public void setXmlExtensionAttributes(final List<ExtensionAttribute> xmlExtensionAttributes) {
        if (xmlExtensionAttributes != null) {
            if (this.extensionAttributes == null) {
                this.extensionAttributes = new HashMap<String, Object>();
            }
            for (ExtensionAttribute attribute : xmlExtensionAttributes) {
                this.extensionAttributes.put(attribute.name, attribute.value);
            }
        }
    }

    /**
     * Key-value class for JAXB.
     */
    private static class KeyValue {

        @XmlAttribute
        private String key;

        @XmlValue
        private String value;
    }

    @XmlJavaTypeAdapter(ExtensionAttributeAdapter.class)
    private static class ExtensionAttribute {
        ExtensionAttribute() {
        }

        ExtensionAttribute(final String name, final Object value) {
            super();
            this.name = name;
            this.value = value;
        }

        String name;

        Object value;
    }

    public static class ExtensionAttributeAdapter extends XmlAdapter<Element, ExtensionAttribute> {

        private ClassLoader classLoader;

        private DocumentBuilder documentBuilder;

        private JAXBContext jaxbContext;

        public ExtensionAttributeAdapter() {
            this.classLoader = Thread.currentThread().getContextClassLoader();
        }

        public ExtensionAttributeAdapter(final JAXBContext jaxbContext) {
            this();
            this.jaxbContext = jaxbContext;
        }

        private DocumentBuilder getDocumentBuilder() throws Exception {
            // Lazy load the DocumentBuilder as it is not used for
            // unmarshalling.
            if (null == this.documentBuilder) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                this.documentBuilder = dbf.newDocumentBuilder();
            }
            return this.documentBuilder;
        }

        private JAXBContext getJAXBContext(final Class<?> type) throws Exception {
            if (null == this.jaxbContext) {
                // A JAXBContext was not set, so create a new one based on the
                // type.
                return JAXBContext.newInstance(type);
            }
            return this.jaxbContext;
        }

        @Override
        public Element marshal(final ExtensionAttribute attribute) throws Exception {
            if (null == attribute) {
                return null;
            }

            // 1. Build the JAXBElement to wrap the instance of
            // ExtensionAttribute.
            QName rootElement = new QName("http://schemas.dmtf.org/cimi/1", attribute.name, "");
            Object value = attribute.value;
            Class<?> type = value.getClass();
            JAXBElement<?> jaxbElement = new JAXBElement(rootElement, type, value);

            // 2. Marshal the JAXBElement to a DOM element.
            Document document = this.getDocumentBuilder().newDocument();
            Marshaller marshaller = this.getJAXBContext(type).createMarshaller();
            marshaller.marshal(jaxbElement, document);
            Element element = document.getDocumentElement();

            return element;
        }

        @Override
        public ExtensionAttribute unmarshal(final Element element) throws Exception {
            if (null == element) {
                return null;
            }
            // TODO look up type of extension attribute in CIMI resource
            // metadata
            Class<?> type = this.classLoader.loadClass("java.lang.String");

            DOMSource source = new DOMSource(element);
            Unmarshaller unmarshaller = this.getJAXBContext(type).createUnmarshaller();
            JAXBElement<?> jaxbElement = unmarshaller.unmarshal(source, type);

            // 3. Build the instance of ExtensionAttribute
            ExtensionAttribute attribute = new ExtensionAttribute();
            attribute.name = element.getLocalName();
            attribute.value = jaxbElement.getValue();
            return attribute;
        }

    }

}
