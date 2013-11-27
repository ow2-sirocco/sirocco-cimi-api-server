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
package org.ow2.sirocco.cimi.server.manager;

import javax.inject.Inject;

import org.ow2.sirocco.cimi.domain.ExchangeType;
import org.ow2.sirocco.cimi.server.configuration.ConfigurationException;
import org.ow2.sirocco.cloudmanager.core.api.ICredentialsManager;
import org.ow2.sirocco.cloudmanager.core.api.IEventManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineImageManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineManager;
import org.ow2.sirocco.cloudmanager.core.api.INetworkManager;
import org.ow2.sirocco.cloudmanager.core.api.ISystemManager;
import org.ow2.sirocco.cloudmanager.core.api.IVolumeManager;
import org.ow2.sirocco.cloudmanager.model.cimi.Resource;

/**
 * Implementation of a calling EJB helper.
 */
public class CallServiceHelperImpl implements CallServiceHelper {

    @Inject
    private ICredentialsManager managerCredentials;

    @Inject
    private IMachineImageManager managerMachineImage;

    @Inject
    private IMachineManager managerMachine;

    @Inject
    private INetworkManager managerNetwork;

    @Inject
    private IEventManager managerEvent;

    @Inject
    private IVolumeManager managerVolume;

    @Inject
    private ISystemManager managerSystem;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.manager.CallServiceHelper#find(org.ow2.sirocco.cimi.domain.ExchangeType,
     *      java.lang.String)
     */
    @Override
    public Resource find(final ExchangeType type, final String idToFind) throws Exception {
        Resource found = null;
        switch (type) {
        case Address:
            found = this.managerNetwork.getAddressByUuid(idToFind);
            break;
        case Credential:
            found = this.managerCredentials.getCredentialsByUuid(idToFind);
            break;
        case EventLog:
            found = this.managerEvent.getEventLogByUuid(idToFind);
            break;
        case ForwardingGroup:
            found = this.managerNetwork.getForwardingGroupByUuid(idToFind);
            break;
        case Machine:
            found = this.managerMachine.getMachineByUuid(idToFind);
            break;
        case MachineConfiguration:
            found = this.managerMachine.getMachineConfigurationByUuid(idToFind);
            break;
        case MachineImage:
            found = this.managerMachineImage.getMachineImageByUuid(idToFind);
            break;
        case Network:
            found = this.managerNetwork.getNetworkByUuid(idToFind);
            break;
        case NetworkPort:
            found = this.managerNetwork.getNetworkPortByUuid(idToFind);
            break;
        case NetworkConfiguration:
            found = this.managerNetwork.getNetworkConfigurationByUuid(idToFind);
            break;
        case NetworkPortConfiguration:
            found = this.managerNetwork.getNetworkPortConfigurationByUuid(idToFind);
            break;
        case System:
            found = this.managerSystem.getSystemByUuid(idToFind);
            break;
        case Volume:
            found = this.managerVolume.getVolumeByUuid(idToFind);
            break;
        case VolumeConfiguration:
            found = this.managerVolume.getVolumeConfigurationByUuid(idToFind);
            break;
        case VolumeImage:
            found = this.managerVolume.getVolumeImageByUuid(idToFind);
            break;
        default:
            throw new ConfigurationException("Impossible calling service with this type :" + type);
        }
        return found;
    }

}
