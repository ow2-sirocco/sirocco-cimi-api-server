package org.ow2.sirocco.cimi.server.resource.serialization.mock;

import javax.enterprise.inject.Alternative;

import org.ow2.sirocco.cimi.server.manager.Manager;

public class MockManagers {

    @Alternative
    @Manager("CimiManagerCreateCredential")
    public static class MockCreateCredentialManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateCredentialTemplate")
    public static class MockCreateCredentialTemplateManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateMachine")
    public static class MockCreateMachineManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateMachineTemplate")
    public static class MockCreateMachineTemplateManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateMachineImage")
    public static class MockCreateMachineImageManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateMachineConfiguration")
    public static class MockCreateMachineConfigurationManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateVolume")
    public static class MockCreateVolumeManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateVolumeTemplate")
    public static class MockCreateVolumeTemplateManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateVolumeImage")
    public static class MockCreateVolumeImageManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerCreateVolumeConfiguration")
    public static class MockCreateVolumeConfigurationManager extends MockCimiManagerCreate {
    }

    @Alternative
    @Manager("CimiManagerDeleteCredential")
    public static class MockDeleteCredentialManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteCredentialTemplate")
    public static class MockDeleteCredentialTemplateManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteJob")
    public static class MockDeleteJobManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteMachine")
    public static class MockDeleteMachineManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteMachineTemplate")
    public static class MockDeleteMachineTemplateManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteMachineImage")
    public static class MockDeleteMachineImageManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteMachineConfiguration")
    public static class MockDeleteMachineConfigurationManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteVolume")
    public static class MockDeleteVolumeManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteVolumeTemplate")
    public static class MockDeleteVolumeTemplateManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteVolumeImage")
    public static class MockDeleteVolumeImageManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerDeleteVolumeConfiguration")
    public static class MockDeleteVolumeConfigurationManager extends MockCimiManagerDelete {
    }

    @Alternative
    @Manager("CimiManagerReadCloudEntryPoint")
    public static class MockReadCEPManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadCredential")
    public static class MockReadCredentialManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadCredentialCollection")
    public static class MockReadCredentialCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadCredentialTemplate")
    public static class MockReadCredentialTemplateManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadCredentialTemplateCollection")
    public static class MockReadCredentialTemplateCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadJob")
    public static class MockReadJobManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadJobCollection")
    public static class MockReadJobCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachine")
    public static class MockReadMachineManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachineCollection")
    public static class MockReadMachineCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachineTemplate")
    public static class MockReadMachineTemplateManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachineTemplateCollection")
    public static class MockReadMachineTemplateCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachineImage")
    public static class MockReadMachineImageManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachineImageCollection")
    public static class MockReadMachineImageCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachineConfiguration")
    public static class MockReadMachineConfigManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadMachineConfigurationCollection")
    public static class MockReadMachineConfigCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolume")
    public static class MockReadVolumeManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolumeCollection")
    public static class MockReadVolumeCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolumeTemplate")
    public static class MockReadVolumeTemplateManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolumeTemplateCollection")
    public static class MockReadVolumeTemplateCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolumeImage")
    public static class MockReadVolumeImageManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolumeImageCollection")
    public static class MockReadVolumeImageCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolumeConfiguration")
    public static class MockReadVolumeConfigManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerReadVolumeConfigurationCollection")
    public static class MockReadVolumeConfigCollectionManager extends MockCimiManagerRead {
    }

    @Alternative
    @Manager("CimiManagerUpdateCloudEntryPoint")
    public static class MockUpdateCEPManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateCredential")
    public static class MockUpdateCrdentialManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateCredentialTemplate")
    public static class MockUpdateCredentialTemplateManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateJob")
    public static class MockUpdateJobManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateJobCollection")
    public static class MockUpdateJobCollectionManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachine")
    public static class MockUpdateMachineManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachineCollection")
    public static class MockUpdateMachineCollectionManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachineTemplate")
    public static class MockUpdateMachineTemplateManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachineTemplateCollection")
    public static class MockUpdateMachineTemplateCollectionManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachineImage")
    public static class MockUpdateMachineImageManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachineImageCollection")
    public static class MockUpdateMachineImageCollectionManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachineConfiguration")
    public static class MockUpdateMachineConfigManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateMachineConfigurationCollection")
    public static class MockUpdateMachineConfigCollectionManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateVolume")
    public static class MockUpdateVolumeManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateVolumeTemplate")
    public static class MockUpdateVolumeTemplateManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateVolumeImage")
    public static class MockUpdateVolumeImageManager extends MockCimiManagerUpdate {
    }

    @Alternative
    @Manager("CimiManagerUpdateVolumeConfiguration")
    public static class MockUpdateVolumeConfigManager extends MockCimiManagerUpdate {
    }

}
