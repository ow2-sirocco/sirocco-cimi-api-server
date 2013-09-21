package org.ow2.sirocco.cimi.server.test.util;

import javax.enterprise.inject.Produces;

import org.easymock.EasyMock;
import org.ow2.sirocco.cimi.server.manager.resourcemetadata.IResourceMetadataManager;
import org.ow2.sirocco.cloudmanager.core.api.ICredentialsManager;
import org.ow2.sirocco.cloudmanager.core.api.IEventManager;
import org.ow2.sirocco.cloudmanager.core.api.IJobManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineImageManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineManager;
import org.ow2.sirocco.cloudmanager.core.api.INetworkManager;
import org.ow2.sirocco.cloudmanager.core.api.ISystemManager;
import org.ow2.sirocco.cloudmanager.core.api.IVolumeManager;

public class ManagerProducers {
    static IMachineManager machineManager = EasyMock.createMock(IMachineManager.class);

    static IMachineImageManager machineImageManager = EasyMock.createMock(IMachineImageManager.class);;

    static ICredentialsManager credentialsManager = EasyMock.createMock(ICredentialsManager.class);;

    static INetworkManager managerNetwork = EasyMock.createMock(INetworkManager.class);;

    static IEventManager managerEvent = EasyMock.createMock(IEventManager.class);;

    static IVolumeManager managerVolume = EasyMock.createMock(IVolumeManager.class);;

    static ISystemManager managerSystem = EasyMock.createMock(ISystemManager.class);

    static IJobManager managerJob = EasyMock.createMock(IJobManager.class);

    static IResourceMetadataManager managerMetada = EasyMock.createMock(IResourceMetadataManager.class);

    @Produces
    IMachineManager getMachineManager() {
        return ManagerProducers.machineManager;
    }

    @Produces
    IMachineImageManager getMachineImageManager() {
        return ManagerProducers.machineImageManager;
    }

    @Produces
    ICredentialsManager getCredentialsManager() {
        return ManagerProducers.credentialsManager;
    }

    @Produces
    IJobManager getJobManager() {
        return ManagerProducers.managerJob;
    }

    @Produces
    INetworkManager getNetworkManager() {
        return ManagerProducers.managerNetwork;
    }

    @Produces
    ISystemManager getSystemManager() {
        return ManagerProducers.managerSystem;
    }

    @Produces
    IVolumeManager getVolumeManager() {
        return ManagerProducers.managerVolume;
    }

    @Produces
    IEventManager getEventManager() {
        return ManagerProducers.managerEvent;
    }

    @Produces
    IResourceMetadataManager getResourceMetadataManager() {
        return ManagerProducers.managerMetada;
    }

}
