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
package org.ow2.sirocco.cimi.domain;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.ow2.sirocco.cimi.server.validator.GroupCreateByValue;
import org.ow2.sirocco.cimi.server.validator.ValidChild;

/**
 * Class NetworkPortTemplate.
 */
@XmlRootElement(name = "NetworkPorTemplate")
@XmlType(propOrder = {"id", "name", "description", "created", "updated", "propertyArray", "network", "networkPortConfig",
    "eventLogTemplate", "operations", "xmlExtensionAttributes"})
@JsonPropertyOrder({"resourceURI", "id", "name", "description", "created", "updated", "properties", "network",
    "networkPortConfig", "eventLogTemplate", "operations"})
@JsonSerialize(include = Inclusion.NON_NULL)
public class CimiNetworkPortTemplate extends CimiObjectCommonAbstract {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    /** Field "network". */
    @ValidChild
    @NotNull(groups = {GroupCreateByValue.class})
    private CimiNetwork network;

    /** Field "networkPortConfig". */
    @ValidChild
    @NotNull(groups = {GroupCreateByValue.class})
    private CimiNetworkPortConfiguration networkPortConfig;

    /** Field "eventLogTemplate". */
    @ValidChild
    private CimiEventLogTemplate eventLogTemplate;

    /**
     * Default constructor.
     */
    public CimiNetworkPortTemplate() {
        super();
    }

    /**
     * Parameterized constructor.
     * 
     * @param href The reference
     */
    public CimiNetworkPortTemplate(final String href) {
        super(href);
    }

    /**
     * Return the value of field "network".
     * 
     * @return The value
     */
    public CimiNetwork getNetwork() {
        return this.network;
    }

    /**
     * Set the value of field "network".
     * 
     * @param network The value
     */
    public void setNetwork(final CimiNetwork network) {
        this.network = network;
    }

    /**
     * Return the value of field "networkPortConfig".
     * 
     * @return The value
     */
    public CimiNetworkPortConfiguration getNetworkPortConfig() {
        return this.networkPortConfig;
    }

    /**
     * Set the value of field "networkPortConfig".
     * 
     * @param networkPortConfig The value
     */
    public void setNetworkPortConfig(final CimiNetworkPortConfiguration networkPortConfig) {
        this.networkPortConfig = networkPortConfig;
    }

    /**
     * Return the value of field "eventLogTemplate".
     * 
     * @return The value
     */
    public CimiEventLogTemplate getEventLogTemplate() {
        return this.eventLogTemplate;
    }

    /**
     * Set the value of field "eventLogTemplate".
     * 
     * @param eventLogTemplate The value
     */
    public void setEventLogTemplate(final CimiEventLogTemplate eventLogTemplate) {
        this.eventLogTemplate = eventLogTemplate;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.domain.CimiObjectCommonAbstract#hasValues()
     */
    @Override
    public boolean hasValues() {
        boolean has = super.hasValues();
        has = has || (null != this.getEventLogTemplate());
        has = has || (null != this.getNetwork());
        has = has || (null != this.getNetworkPortConfig());
        return has;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.domain.CimiExchange#getExchangeType()
     */
    @Override
    @XmlTransient
    @JsonIgnore
    public ExchangeType getExchangeType() {
        return ExchangeType.NetworkPortTemplate;
    }

}
