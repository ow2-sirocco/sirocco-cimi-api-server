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
 * $Id: CimiMachineConfigurationCollection.java 121 2012-03-07 14:40:34Z antonma $
 *
 */
package org.ow2.sirocco.apis.rest.cimi.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * Class MachineConfigurationCollection. <p> </p>
 */
@XmlRootElement(name = "machineConfigurationCollection")
@JsonSerialize(include = Inclusion.NON_NULL)
public class CimiMachineConfigurationCollection extends CimiCommon implements Serializable {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    // ---------------------------------------- Fields

    /**
     * Field "href". <p> </p>
     */
    private String href;

    /**
     * Field "machineConfigurations". <p> </p>
     */
    private CimiMachineConfiguration[] machineConfigurations;

    // ---------------------------------------- Constructors

    /**
     * Default constructor.
     */
    public CimiMachineConfigurationCollection() {
        super();
    }

    // ---------------------------------------- ???com-accesseurs???

    /**
     * Return the value of field "machineConfigurations".
     * @return The value
     */
    public CimiMachineConfiguration[] getMachineConfigurations() {
        return this.machineConfigurations;
    }

    /**
     * Set the value of field "machineConfigurations".
     * @param machineConfigurations The value
     */
    public void setMachineConfigurations(CimiMachineConfiguration[] machineConfigurations) {
        this.machineConfigurations = machineConfigurations;
    }

    /**
     * @return the href
     */
    @XmlAttribute
    public String getHref() {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }
}
