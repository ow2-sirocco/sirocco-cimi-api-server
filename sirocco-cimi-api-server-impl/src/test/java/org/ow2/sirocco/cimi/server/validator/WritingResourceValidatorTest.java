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
package org.ow2.sirocco.cimi.server.validator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ow2.sirocco.cimi.server.domain.CimiAddress;
import org.ow2.sirocco.cimi.server.domain.CimiAddressTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiCloudEntryPoint;
import org.ow2.sirocco.cimi.server.domain.CimiCommon;
import org.ow2.sirocco.cimi.server.domain.CimiCredential;
import org.ow2.sirocco.cimi.server.domain.CimiCredentialTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiDataCommon;
import org.ow2.sirocco.cimi.server.domain.CimiDiskConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiEvent;
import org.ow2.sirocco.cimi.server.domain.CimiEventLog;
import org.ow2.sirocco.cimi.server.domain.CimiEventLogTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiForwardingGroup;
import org.ow2.sirocco.cimi.server.domain.CimiForwardingGroupNetwork;
import org.ow2.sirocco.cimi.server.domain.CimiForwardingGroupTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiJob;
import org.ow2.sirocco.cimi.server.domain.CimiMachine;
import org.ow2.sirocco.cimi.server.domain.CimiMachineConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiMachineDisk;
import org.ow2.sirocco.cimi.server.domain.CimiMachineImage;
import org.ow2.sirocco.cimi.server.domain.CimiMachineNetworkInterface;
import org.ow2.sirocco.cimi.server.domain.CimiMachineNetworkInterfaceAddress;
import org.ow2.sirocco.cimi.server.domain.CimiMachineTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiMachineTemplateVolume;
import org.ow2.sirocco.cimi.server.domain.CimiMachineTemplateVolumeTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiMachineVolume;
import org.ow2.sirocco.cimi.server.domain.CimiNetwork;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkNetworkPort;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkPort;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkPortConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkPortTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiResource;
import org.ow2.sirocco.cimi.server.domain.CimiResourceMetadata;
import org.ow2.sirocco.cimi.server.domain.CimiSystem;
import org.ow2.sirocco.cimi.server.domain.CimiSystemAddress;
import org.ow2.sirocco.cimi.server.domain.CimiSystemCredential;
import org.ow2.sirocco.cimi.server.domain.CimiSystemForwardingGroup;
import org.ow2.sirocco.cimi.server.domain.CimiSystemMachine;
import org.ow2.sirocco.cimi.server.domain.CimiSystemNetwork;
import org.ow2.sirocco.cimi.server.domain.CimiSystemNetworkPort;
import org.ow2.sirocco.cimi.server.domain.CimiSystemSystem;
import org.ow2.sirocco.cimi.server.domain.CimiSystemTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiSystemVolume;
import org.ow2.sirocco.cimi.server.domain.CimiVolume;
import org.ow2.sirocco.cimi.server.domain.CimiVolumeConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiVolumeImage;
import org.ow2.sirocco.cimi.server.domain.CimiVolumeTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiVolumeVolumeImage;
import org.ow2.sirocco.cimi.server.domain.ExchangeType;
import org.ow2.sirocco.cimi.server.domain.ImageLocation;
import org.ow2.sirocco.cimi.server.domain.collection.CimiAddressCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiAddressTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiCredentialCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiCredentialTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventLogCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventLogTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupNetworkCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiJobCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineDiskCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineImageCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineNetworkInterfaceAddressCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineNetworkInterfaceCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineVolumeCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkNetworkPortCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiResourceMetadataCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemAddressCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemCredentialCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemForwardingGroupCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemMachineCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemNetworkCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemNetworkPortCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemSystemCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemVolumeCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeImageCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeVolumeImageCollection;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cimi.server.request.CimiContextImpl;
import org.ow2.sirocco.cimi.server.request.CimiRequest;
import org.ow2.sirocco.cimi.server.request.CimiResponse;
import org.ow2.sirocco.cimi.server.validator.CimiValidatorHelper;

public class WritingResourceValidatorTest {

    private CimiRequest request;

    private CimiResponse response;

    private CimiContext context;

    @Before
    public void setUp() throws Exception {

        this.request = new CimiRequest();
        this.request.setBaseUri("http://www.sirocco.test.org/");
        this.response = new CimiResponse();
        this.context = new CimiContextImpl(this.request, this.response);
    }

    @Test
    public void testAllResourcesWithHref() throws Exception {
        CimiResource cimi = null;

        String[] ids;

        for (ExchangeType type : ExchangeType.values()) {

            cimi = this.newResource(type);

            if (null != cimi) {
                // System.out.println();
                // System.out.println(type);

                // Make IDS for the exchange type to test and its parents
                ids = new String[type.getPathType().getParentDepth() + 1];
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = String.valueOf((i + 100) * 7);
                }
                // Test HREF
                cimi.setHref(type.makeHref(this.request.getBaseUri(), ids));
                // System.out.println(cimi.getHref());
                Assert.assertTrue("Test " + type, CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

                // Make IDS as a collection only for its parents
                ids = new String[type.getPathType().getParentDepth()];
                for (int i = 0; i < ids.length; i++) {
                    ids[i] = String.valueOf((i + 100) * 7);
                }
                cimi.setHref(type.makeHref(this.request.getBaseUri(), ids));
                // System.out.println(cimi.getHref());
                if (true == type.hasIdInReference()) {
                    // The type is not a collection, is missing an ID
                    Assert.assertFalse("Test " + type, CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));
                } else {
                    // The type is a collection
                    Assert.assertTrue("Test " + type, CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));
                }

                cimi.setHref("foo");
                Assert.assertFalse("Test " + type, CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

                // Test with all other resource
                for (ExchangeType otherType : ExchangeType.values()) {
                    CimiResource cimiOther = this.newResource(otherType);
                    if ((null != cimiOther) && (type != otherType)) {
                        if (type != otherType.getSubstituteType() && otherType != type.getSubstituteType()) {
                            cimi.setHref(otherType.makeHref(this.request.getBaseUri(), "987", "123"));
                            Assert.assertFalse("Test " + type + " with " + otherType, CimiValidatorHelper.getInstance()
                                .validateToWrite(this.context, cimi));
                        }
                    }
                }
            }
        }

    }

    private CimiResource newResource(final ExchangeType type) {
        CimiResource cimi = null;
        switch (type) {
        case Action:
            cimi = null;
            break;
        case Address:
            cimi = new CimiAddress();
            break;
        case AddressCollection:
            cimi = new CimiAddressCollection();
            break;
        case AddressCreate:
            cimi = null;
            break;
        case AddressTemplate:
            cimi = new CimiAddressTemplate();
            break;
        case AddressTemplateCollection:
            cimi = new CimiAddressTemplateCollection();
            break;
        case CloudEntryPoint:
            cimi = new CimiCloudEntryPoint();
            break;
        case Credential:
            cimi = new CimiCredential();
            break;
        case CredentialCollection:
            cimi = new CimiCredentialCollection();
            break;
        case CredentialCreate:
            cimi = null;
            break;
        case CredentialTemplate:
            cimi = new CimiCredentialTemplate();
            break;
        case CredentialTemplateCollection:
            cimi = new CimiCredentialTemplateCollection();
            break;
        case Disk:
            cimi = new CimiMachineDisk();
            break;
        case DiskCollection:
            cimi = new CimiMachineDiskCollection();
            break;
        case Event:
            cimi = new CimiEvent();
            break;
        case EventCollection:
            cimi = new CimiEventCollection();
            break;
        case EventLog:
            cimi = new CimiEventLog();
            break;
        case EventLogCollection:
            cimi = new CimiEventLogCollection();
            break;
        case EventLogCreate:
            cimi = null;
            break;
        case EventLogTemplate:
            cimi = new CimiEventLogTemplate();
            break;
        case EventLogTemplateCollection:
            cimi = new CimiEventLogTemplateCollection();
            break;
        case ForwardingGroup:
            cimi = new CimiForwardingGroup();
            break;
        case ForwardingGroupCollection:
            cimi = new CimiForwardingGroupCollection();
            break;
        case ForwardingGroupCreate:
            cimi = null;
            break;
        case ForwardingGroupNetwork:
            cimi = new CimiForwardingGroupNetwork();
            break;
        case ForwardingGroupNetworkCollection:
            cimi = new CimiForwardingGroupNetworkCollection();
            break;
        case ForwardingGroupTemplate:
            cimi = new CimiForwardingGroupTemplate();
            break;
        case ForwardingGroupTemplateCollection:
            cimi = new CimiForwardingGroupTemplateCollection();
            break;
        case Job:
            cimi = new CimiJob();
            break;
        case JobCollection:
            cimi = new CimiJobCollection();
            break;
        case Machine:
            cimi = new CimiMachine();
            break;
        case MachineCollection:
            cimi = new CimiMachineCollection();
            break;
        case MachineConfiguration:
            cimi = new CimiMachineConfiguration();
            break;
        case MachineConfigurationCollection:
            cimi = new CimiMachineConfigurationCollection();
            break;
        case MachineCreate:
            cimi = null;
            break;
        case MachineImage:
            cimi = new CimiMachineImage();
            break;
        case MachineImageCollection:
            cimi = new CimiMachineImageCollection();
            break;
        case MachineNetworkInterface:
            cimi = new CimiMachineNetworkInterface();
            break;
        case MachineNetworkInterfaceCollection:
            cimi = new CimiMachineNetworkInterfaceCollection();
            break;
        case MachineNetworkInterfaceAddress:
            cimi = new CimiMachineNetworkInterfaceAddress();
            break;
        case MachineNetworkInterfaceAddressCollection:
            cimi = new CimiMachineNetworkInterfaceAddressCollection();
            break;
        case MachineTemplate:
            cimi = new CimiMachineTemplate();
            break;
        case MachineTemplateCollection:
            cimi = new CimiMachineTemplateCollection();
            break;
        case MachineTemplateVolume:
            cimi = new CimiMachineTemplateVolume();
            break;
        case MachineTemplateVolumeTemplate:
            cimi = new CimiMachineTemplateVolumeTemplate();
            break;
        case MachineVolume:
            cimi = new CimiMachineVolume();
            break;
        case MachineVolumeCollection:
            cimi = new CimiMachineVolumeCollection();
            break;
        case Network:
            cimi = new CimiNetwork();
            break;
        case NetworkCollection:
            cimi = new CimiNetworkCollection();
            break;
        case NetworkConfiguration:
            cimi = new CimiNetworkConfiguration();
            break;
        case NetworkConfigurationCollection:
            cimi = new CimiNetworkConfigurationCollection();
            break;
        case NetworkCreate:
            cimi = null;
            break;
        case NetworkNetworkPort:
            cimi = new CimiNetworkNetworkPort();
            break;
        case NetworkNetworkPortCollection:
            cimi = new CimiNetworkNetworkPortCollection();
            break;
        case NetworkTemplate:
            cimi = new CimiNetworkTemplate();
            break;
        case NetworkTemplateCollection:
            cimi = new CimiNetworkTemplateCollection();
            break;
        case NetworkPort:
            cimi = new CimiNetworkPort();
            break;
        case NetworkPortCollection:
            cimi = new CimiNetworkPortCollection();
            break;
        case NetworkPortConfiguration:
            cimi = new CimiNetworkPortConfiguration();
            break;
        case NetworkPortConfigurationCollection:
            cimi = new CimiNetworkPortConfigurationCollection();
            break;
        case NetworkPortCreate:
            cimi = null;
            break;
        case NetworkPortTemplate:
            cimi = new CimiNetworkPortTemplate();
            break;
        case NetworkPortTemplateCollection:
            cimi = new CimiNetworkPortTemplateCollection();
            break;
        case Volume:
            cimi = new CimiVolume();
            break;
        case VolumeCollection:
            cimi = new CimiVolumeCollection();
            break;
        case VolumeConfiguration:
            cimi = new CimiVolumeConfiguration();
            break;
        case VolumeConfigurationCollection:
            cimi = new CimiVolumeConfigurationCollection();
            break;
        case VolumeCreate:
            cimi = null;
            break;
        case VolumeImage:
            cimi = new CimiVolumeImage();
            break;
        case VolumeImageCollection:
            cimi = new CimiVolumeImageCollection();
            break;
        case VolumeTemplate:
            cimi = new CimiVolumeTemplate();
            break;
        case VolumeTemplateCollection:
            cimi = new CimiVolumeTemplateCollection();
            break;
        case VolumeVolumeImage:
            cimi = new CimiVolumeVolumeImage();
            break;
        case VolumeVolumeImageCollection:
            cimi = new CimiVolumeVolumeImageCollection();
            break;
        case System:
            cimi = new CimiSystem();
            break;
        case SystemCollection:
            cimi = new CimiSystemCollection();
            break;
        case SystemCreate:
            cimi = null;
            break;
        case SystemCredential:
            cimi = new CimiSystemCredential();
            break;
        case SystemCredentialCollection:
            cimi = new CimiSystemCredentialCollection();
            break;
        case SystemMachine:
            cimi = new CimiSystemMachine();
            break;
        case SystemMachineCollection:
            cimi = new CimiSystemMachineCollection();
            break;
        case SystemSystem:
            cimi = new CimiSystemSystem();
            break;
        case SystemSystemCollection:
            cimi = new CimiSystemSystemCollection();
            break;
        case SystemTemplate:
            cimi = new CimiSystemTemplate();
            break;
        case SystemTemplateCollection:
            cimi = new CimiSystemTemplateCollection();
            break;
        case SystemAddress:
            cimi = new CimiSystemAddress();
            break;
        case SystemAddressCollection:
            cimi = new CimiSystemAddressCollection();
            break;
        case SystemForwardingGroup:
            cimi = new CimiSystemForwardingGroup();
            break;
        case SystemForwardingGroupCollection:
            cimi = new CimiSystemForwardingGroupCollection();
            break;
        case SystemNetwork:
            cimi = new CimiSystemNetwork();
            break;
        case SystemNetworkCollection:
            cimi = new CimiSystemNetworkCollection();
            break;
        case SystemNetworkPort:
            cimi = new CimiSystemNetworkPort();
            break;
        case SystemNetworkPortCollection:
            cimi = new CimiSystemNetworkPortCollection();
            break;
        case SystemVolume:
            cimi = new CimiSystemVolume();
            break;
        case SystemVolumeCollection:
            cimi = new CimiSystemVolumeCollection();
            break;
        case ResourceMetadata:
            cimi = new CimiResourceMetadata();
            break;
        case ResourceMetadataCollection:
            cimi = new CimiResourceMetadataCollection();
            break;
        default:
            Assert.fail("In test method \"newResource\" : " + type.name() + " not found");
            break;
        }

        return cimi;
    }

    @Test
    public void testCimiCommon() throws Exception {
        CimiDataCommon cimi;
        Map<String, String> props;

        // --------------- OK

        cimi = new CimiCommon();
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiCommon();
        cimi.setName("A");
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiCommon();
        cimi.setName("_");
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiCommon();
        cimi.setName("0");
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiCommon();
        cimi.setName("0 A");
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiCommon();
        props = new HashMap<String, String>();
        props.put("A", "a");
        props.put("B", "b");
        cimi.setProperties(props);
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        // --------------- KO

        cimi = new CimiCommon();
        props = new HashMap<String, String>();
        cimi.setProperties(props);
        Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiCommon();
        props = new HashMap<String, String>();
        props.put("A", "a");
        props.put("B", null);
        cimi.setProperties(props);
        Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));
    }

    // @Test
    // public void testCimiCredential() throws Exception {
    //
    // CimiCredential cimi;
    // byte[] filledKeySize3 = new byte[3];
    // for (int i = 0; i < filledKeySize3.length; i++) {
    // filledKeySize3[i] = (byte) (i + 2);
    // }
    //
    // // --------------- OK
    //
    // cimi = new CimiCredential();
    // Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    //
    // cimi = new CimiCredential();
    // cimi.setKey(filledKeySize3);
    // Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    //
    // cimi = new CimiCredential();
    // cimi.setKey(new byte[1]);
    // Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    //
    // // --------------- KO
    //
    // cimi = new CimiCredential();
    // cimi.setKey(new byte[0]);
    // Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    //
    // }

    // @Test
    // public void testCimiCredentialTemplate() throws Exception {
    //
    // CimiCredentialTemplate cimi;
    // byte[] filledKeySize3 = new byte[3];
    // for (int i = 0; i < filledKeySize3.length; i++) {
    // filledKeySize3[i] = (byte) (i + 2);
    // }
    //
    // // --------------- OK
    //
    // cimi = new CimiCredentialTemplate();
    // Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    //
    // cimi = new CimiCredentialTemplate();
    // cimi.setKey(filledKeySize3);
    // Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    //
    // cimi = new CimiCredentialTemplate();
    // cimi.setKey(new byte[1]);
    // Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    //
    // // --------------- KO
    //
    // cimi = new CimiCredentialTemplate();
    // cimi.setKey(new byte[0]);
    // Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context,
    // cimi));
    // }

    @Test
    public void testCimiMachine() throws Exception {

        CimiMachine cimi;

        // --------------- OK

        cimi = new CimiMachine();
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachine();
        cimi.setCpu(11);
        cimi.setMemory(22);
        cimi.setDisks(new CimiMachineDiskCollection());
        cimi.getDisks().add(new CimiMachineDisk(123));
        cimi.getDisks().add(new CimiMachineDisk(456));
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));
    }

    @Test
    public void testCimiMachineConfiguration() throws Exception {
        CimiMachineConfiguration cimi;

        // --------------- OK

        cimi = new CimiMachineConfiguration();
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachineConfiguration();
        cimi.setCpu(11);
        cimi.setMemory(22);
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachineConfiguration();
        cimi.setCpu(11);
        cimi.setMemory(22);
        cimi.setDisks(new CimiDiskConfiguration[] {new CimiDiskConfiguration(1024, "f", "ap")});
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachineConfiguration();
        cimi.setCpu(11);
        cimi.setMemory(22);
        cimi.setDisks(new CimiDiskConfiguration[] {new CimiDiskConfiguration(1024, "f", "ap"),
            new CimiDiskConfiguration(2048, "f2", "ap2")});
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        // --------------- KO

        cimi = new CimiMachineConfiguration();
        cimi.setCpu(11);
        cimi.setMemory(22);
        cimi.setDisks(new CimiDiskConfiguration[0]);
        Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachineConfiguration();
        cimi.setCpu(11);
        cimi.setMemory(22);
        cimi.setDisks(new CimiDiskConfiguration[] {new CimiDiskConfiguration()});
        Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachineConfiguration();
        cimi.setCpu(11);
        cimi.setMemory(22);
        cimi.setDisks(new CimiDiskConfiguration[] {null, null});
        Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));
    }

    @Test
    public void testCimiMachineImage() throws Exception {
        CimiMachineImage cimi;

        // --------------- OK

        cimi = new CimiMachineImage();
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachineImage();
        cimi.setImageLocation(new ImageLocation("foo"));
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        // --------------- KO

        cimi = new CimiMachineImage();
        cimi.setImageLocation(new ImageLocation());
        Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));
    }

    @Test
    public void testCimiMachineTemplate() throws Exception {
        CimiMachineTemplate cimi;

        // --------------- OK

        cimi = new CimiMachineTemplate();
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        cimi = new CimiMachineTemplate();
        cimi.setCredential(new CimiCredential());
        cimi.setMachineConfig(new CimiMachineConfiguration());
        cimi.setMachineImage(new CimiMachineImage());
        Assert.assertTrue(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));

        // --------------- KO

        cimi = new CimiMachineTemplate();
        cimi.setCredential(new CimiCredential());
        cimi.setMachineConfig(new CimiMachineConfiguration());
        cimi.setMachineImage(new CimiMachineImage(new ImageLocation()));
        Assert.assertFalse(CimiValidatorHelper.getInstance().validateToWrite(this.context, cimi));
    }
}
