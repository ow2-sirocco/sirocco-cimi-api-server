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
        out.setId(10);

        out.setCredentials(this.credentialsManager.getCredentials());
        out.setCredentialsTemplates(this.credentialsManager.getCredentialsTemplates());

        out.setJobs(this.jobManager.getJobs());

        out.setMachineConfigs(this.machineManager.getMachineConfigurations());
        out.setMachineImages(this.machineImageManager.getMachineImages());
        out.setMachines(this.machineManager.getMachines());
        out.setMachineTemplates(this.machineManager.getMachineTemplates());

        out.setSystems(this.systemManager.getSystems());
        out.setSystemTemplates(this.systemManager.getSystemTemplates());

        out.setVolumeConfigurations(this.volumeManager.getVolumeConfigurations());
        out.setVolumeImages(this.volumeManager.getVolumeImages());
        out.setVolumes(this.volumeManager.getVolumes());
        out.setVolumeTemplates(this.volumeManager.getVolumeTemplates());

        out.setNetworkConfigurations(this.networkManager.getNetworkConfigurations());
        out.setNetworks(this.networkManager.getNetworks());
        out.setNetworkTemplates(this.networkManager.getNetworkTemplates());

        out.setNetworkPortConfigurations(this.networkManager.getNetworkPortConfigurations());
        out.setNetworkPorts(this.networkManager.getNetworkPorts());
        out.setNetworkPortTemplates(this.networkManager.getNetworkPortTemplates());

        out.setAddresses(this.networkManager.getAddresses());
        out.setAddressTemplates(this.networkManager.getAddressTemplates());

        out.setForwardingGroups(this.networkManager.getForwardingGroups());
        out.setForwardingGroupTemplates(this.networkManager.getForwardingGroupTemplates());

        out.setEventLogs(this.eventManager.getEventLog());
        out.setEventLogTemplates(this.eventManager.getEventLogTemplates());

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
