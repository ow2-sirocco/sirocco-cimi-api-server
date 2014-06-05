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
package org.ow2.sirocco.cimi.server.manager.cep;

import java.util.Collections;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.ow2.sirocco.cimi.domain.CimiCloudEntryPoint;
import org.ow2.sirocco.cimi.domain.CloudEntryPointAggregate;
import org.ow2.sirocco.cimi.server.manager.CimiManagerReadAbstract;
import org.ow2.sirocco.cimi.server.manager.resourcemetadata.IResourceMetadataManager;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cloudmanager.core.api.ICredentialsManager;
import org.ow2.sirocco.cloudmanager.core.api.IEventManager;
import org.ow2.sirocco.cloudmanager.core.api.IJobManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineImageManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineManager;
import org.ow2.sirocco.cloudmanager.core.api.INetworkManager;
import org.ow2.sirocco.cloudmanager.core.api.ISystemManager;
import org.ow2.sirocco.cloudmanager.core.api.IVolumeManager;
import org.ow2.sirocco.cloudmanager.model.cimi.Address;
import org.ow2.sirocco.cloudmanager.model.cimi.AddressTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.Credentials;
import org.ow2.sirocco.cloudmanager.model.cimi.CredentialsTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.ForwardingGroup;
import org.ow2.sirocco.cloudmanager.model.cimi.ForwardingGroupTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.Job;
import org.ow2.sirocco.cloudmanager.model.cimi.Machine;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineConfiguration;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineImage;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.Network;
import org.ow2.sirocco.cloudmanager.model.cimi.NetworkConfiguration;
import org.ow2.sirocco.cloudmanager.model.cimi.NetworkPort;
import org.ow2.sirocco.cloudmanager.model.cimi.NetworkPortConfiguration;
import org.ow2.sirocco.cloudmanager.model.cimi.NetworkPortTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.NetworkTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.Volume;
import org.ow2.sirocco.cloudmanager.model.cimi.VolumeConfiguration;
import org.ow2.sirocco.cloudmanager.model.cimi.VolumeImage;
import org.ow2.sirocco.cloudmanager.model.cimi.VolumeTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.event.EventLog;
import org.ow2.sirocco.cloudmanager.model.cimi.event.EventLogTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemTemplate;

/**
 * Manage READ request of Cloud Entry Point.
 */
@org.ow2.sirocco.cimi.server.manager.Manager("CimiManagerReadCloudEntryPoint")
public class CimiManagerReadCloudEntryPoint extends CimiManagerReadAbstract {

    @Inject
    private IMachineManager machineManager;

    @Inject
    private ICredentialsManager credentialsManager;

    @Inject
    private IMachineImageManager machineImageManager;

    @Inject
    private IJobManager jobManager;

    @Inject
    private IVolumeManager volumeManager;

    @Inject
    private ISystemManager systemManager;

    @Inject
    private INetworkManager networkManager;

    @Inject
    private IEventManager eventManager;

    @Inject
    private IResourceMetadataManager resourceMetadataManager;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.manager.CimiManagerAbstract#callService(org.ow2.sirocco.cimi.server.request.CimiContext,
     *      java.lang.Object)
     */
    @Override
    protected Object callService(final CimiContext context, final Object dataService) throws Exception {
        CloudEntryPointAggregate out = new CloudEntryPointAggregate();
        out.setUuid("dummy");

        out.setCredentials(Collections.<Credentials> emptyList());
        out.setCredentialsTemplates(Collections.<CredentialsTemplate> emptyList());

        out.setJobs(Collections.<Job> emptyList());

        out.setMachineConfigs(Collections.<MachineConfiguration> emptyList());
        out.setMachineImages(Collections.<MachineImage> emptyList());
        out.setMachines(Collections.<Machine> emptyList());
        out.setMachineTemplates(Collections.<MachineTemplate> emptyList());

        out.setSystems(Collections.<org.ow2.sirocco.cloudmanager.model.cimi.system.System> emptyList());
        out.setSystemTemplates(Collections.<SystemTemplate> emptyList());

        out.setVolumeConfigurations(Collections.<VolumeConfiguration> emptyList());
        out.setVolumeImages(Collections.<VolumeImage> emptyList());
        out.setVolumes(Collections.<Volume> emptyList());
        out.setVolumeTemplates(Collections.<VolumeTemplate> emptyList());

        out.setNetworkConfigurations(Collections.<NetworkConfiguration> emptyList());
        out.setNetworks(Collections.<Network> emptyList());
        out.setNetworkTemplates(Collections.<NetworkTemplate> emptyList());

        out.setNetworkPortConfigurations(Collections.<NetworkPortConfiguration> emptyList());
        out.setNetworkPorts(Collections.<NetworkPort> emptyList());
        out.setNetworkPortTemplates(Collections.<NetworkPortTemplate> emptyList());

        out.setAddresses(Collections.<Address> emptyList());
        out.setAddressTemplates(Collections.<AddressTemplate> emptyList());

        out.setForwardingGroups(Collections.<ForwardingGroup> emptyList());
        out.setForwardingGroupTemplates(Collections.<ForwardingGroupTemplate> emptyList());

        out.setEventLogs(Collections.<EventLog> emptyList());
        out.setEventLogTemplates(Collections.<EventLogTemplate> emptyList());

        out.setResourceMetadata(this.resourceMetadataManager.getResourceMetadata());

        // Unsupported resources :
        // meters
        // meterTemplates
        // meterConfigs

        return out;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.manager.CimiManagerAbstract#convertToResponse(org.ow2.sirocco.cimi.server.request.CimiContext,
     *      java.lang.Object)
     */
    @Override
    protected void convertToResponse(final CimiContext context, final Object dataService) throws Exception {
        CimiCloudEntryPoint cimi = (CimiCloudEntryPoint) context.convertToCimi(dataService, CimiCloudEntryPoint.class);
        context.getResponse().setCimiData(cimi);
        context.getResponse().setStatus(Response.Status.OK);
    }
}
