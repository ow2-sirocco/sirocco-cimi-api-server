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
package org.ow2.sirocco.cimi.server.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ow2.sirocco.cimi.server.converter.AddressConverter;
import org.ow2.sirocco.cimi.server.converter.AddressCreateConverter;
import org.ow2.sirocco.cimi.server.converter.AddressTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.CloudEntryPointConverter;
import org.ow2.sirocco.cimi.server.converter.ComponentDescriptorConverter;
import org.ow2.sirocco.cimi.server.converter.CredentialConverter;
import org.ow2.sirocco.cimi.server.converter.CredentialCreateConverter;
import org.ow2.sirocco.cimi.server.converter.CredentialTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.DiskConfigurationConverter;
import org.ow2.sirocco.cimi.server.converter.EventConverter;
import org.ow2.sirocco.cimi.server.converter.EventLogConverter;
import org.ow2.sirocco.cimi.server.converter.EventLogCreateConverter;
import org.ow2.sirocco.cimi.server.converter.EventLogTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.EventTypeAccessConverter;
import org.ow2.sirocco.cimi.server.converter.EventTypeAlarmConverter;
import org.ow2.sirocco.cimi.server.converter.EventTypeModelConverter;
import org.ow2.sirocco.cimi.server.converter.EventTypeStateConverter;
import org.ow2.sirocco.cimi.server.converter.ForwardingGroupConverter;
import org.ow2.sirocco.cimi.server.converter.ForwardingGroupCreateConverter;
import org.ow2.sirocco.cimi.server.converter.ForwardingGroupNetworkConverter;
import org.ow2.sirocco.cimi.server.converter.ForwardingGroupTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.JobConverter;
import org.ow2.sirocco.cimi.server.converter.MachineConfigurationConverter;
import org.ow2.sirocco.cimi.server.converter.MachineConverter;
import org.ow2.sirocco.cimi.server.converter.MachineCreateConverter;
import org.ow2.sirocco.cimi.server.converter.MachineDiskConverter;
import org.ow2.sirocco.cimi.server.converter.MachineImageConverter;
import org.ow2.sirocco.cimi.server.converter.MachineNetworkInterfaceAddressConverter;
import org.ow2.sirocco.cimi.server.converter.MachineNetworkInterfaceConverter;
import org.ow2.sirocco.cimi.server.converter.MachineTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.MachineTemplateNetworkInterfaceConverter;
import org.ow2.sirocco.cimi.server.converter.MachineTemplateVolumeConverter;
import org.ow2.sirocco.cimi.server.converter.MachineTemplateVolumeTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.MachineVolumeConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkConfigurationConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkCreateConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkNetworkPortConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkPortConfigurationConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkPortConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkPortCreateConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkPortTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.NetworkTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.ResourceMetadataConverter;
import org.ow2.sirocco.cimi.server.converter.SummaryConverter;
import org.ow2.sirocco.cimi.server.converter.SystemAddressConverter;
import org.ow2.sirocco.cimi.server.converter.SystemConverter;
import org.ow2.sirocco.cimi.server.converter.SystemCreateConverter;
import org.ow2.sirocco.cimi.server.converter.SystemCredentialConverter;
import org.ow2.sirocco.cimi.server.converter.SystemForwardingGroupConverter;
import org.ow2.sirocco.cimi.server.converter.SystemMachineConverter;
import org.ow2.sirocco.cimi.server.converter.SystemNetworkConverter;
import org.ow2.sirocco.cimi.server.converter.SystemNetworkPortConverter;
import org.ow2.sirocco.cimi.server.converter.SystemSystemConverter;
import org.ow2.sirocco.cimi.server.converter.SystemTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.SystemVolumeConverter;
import org.ow2.sirocco.cimi.server.converter.VolumeConfigurationConverter;
import org.ow2.sirocco.cimi.server.converter.VolumeConverter;
import org.ow2.sirocco.cimi.server.converter.VolumeCreateConverter;
import org.ow2.sirocco.cimi.server.converter.VolumeImageConverter;
import org.ow2.sirocco.cimi.server.converter.VolumeTemplateConverter;
import org.ow2.sirocco.cimi.server.converter.VolumeVolumeImageConverter;
import org.ow2.sirocco.cimi.server.converter.collection.AddressCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.AddressCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.AddressTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.AddressTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.CredentialCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.CredentialCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.CredentialTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.CredentialTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.EventCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.EventCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.EventLogCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.EventLogCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.EventLogTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.EventLogTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ForwardingGroupCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ForwardingGroupCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ForwardingGroupNetworkCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ForwardingGroupNetworkCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ForwardingGroupTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ForwardingGroupTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.JobCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.JobCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineConfigurationCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineConfigurationCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineDiskCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineDiskCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineImageCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineImageCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineNetworkInterfaceAddressCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineNetworkInterfaceAddressCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineNetworkInterfaceCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineNetworkInterfaceCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineVolumeCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.MachineVolumeCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkConfigurationCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkConfigurationCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkNetworkPortCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkNetworkPortCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkPortCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkPortCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkPortConfigurationCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkPortConfigurationCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkPortTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkPortTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.NetworkTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ResourceMetadataCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.ResourceMetadataCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemAddressCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemAddressCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemCredentialCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemCredentialCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemForwardingGroupCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemForwardingGroupCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemMachineCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemMachineCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemNetworkCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemNetworkCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemNetworkPortCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemNetworkPortCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemSystemCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemSystemCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemVolumeCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.SystemVolumeCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeConfigurationCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeConfigurationCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeImageCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeImageCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeTemplateCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeTemplateCollectionRootConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeVolumeImageCollectionConverter;
import org.ow2.sirocco.cimi.server.converter.collection.VolumeVolumeImageCollectionRootConverter;
import org.ow2.sirocco.cimi.server.domain.CimiAction;
import org.ow2.sirocco.cimi.server.domain.CimiAddress;
import org.ow2.sirocco.cimi.server.domain.CimiAddressCreate;
import org.ow2.sirocco.cimi.server.domain.CimiAddressTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiCloudEntryPoint;
import org.ow2.sirocco.cimi.server.domain.CimiComponentDescriptor;
import org.ow2.sirocco.cimi.server.domain.CimiCredential;
import org.ow2.sirocco.cimi.server.domain.CimiCredentialCreate;
import org.ow2.sirocco.cimi.server.domain.CimiCredentialTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiData;
import org.ow2.sirocco.cimi.server.domain.CimiDiskConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiEvent;
import org.ow2.sirocco.cimi.server.domain.CimiEventLog;
import org.ow2.sirocco.cimi.server.domain.CimiEventLogCreate;
import org.ow2.sirocco.cimi.server.domain.CimiEventLogTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiEventTypeAccess;
import org.ow2.sirocco.cimi.server.domain.CimiEventTypeAlarm;
import org.ow2.sirocco.cimi.server.domain.CimiEventTypeModel;
import org.ow2.sirocco.cimi.server.domain.CimiEventTypeState;
import org.ow2.sirocco.cimi.server.domain.CimiExchange;
import org.ow2.sirocco.cimi.server.domain.CimiForwardingGroup;
import org.ow2.sirocco.cimi.server.domain.CimiForwardingGroupCreate;
import org.ow2.sirocco.cimi.server.domain.CimiForwardingGroupNetwork;
import org.ow2.sirocco.cimi.server.domain.CimiForwardingGroupTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiJob;
import org.ow2.sirocco.cimi.server.domain.CimiMachine;
import org.ow2.sirocco.cimi.server.domain.CimiMachineConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiMachineCreate;
import org.ow2.sirocco.cimi.server.domain.CimiMachineDisk;
import org.ow2.sirocco.cimi.server.domain.CimiMachineImage;
import org.ow2.sirocco.cimi.server.domain.CimiMachineNetworkInterface;
import org.ow2.sirocco.cimi.server.domain.CimiMachineNetworkInterfaceAddress;
import org.ow2.sirocco.cimi.server.domain.CimiMachineTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiMachineTemplateNetworkInterface;
import org.ow2.sirocco.cimi.server.domain.CimiMachineTemplateVolume;
import org.ow2.sirocco.cimi.server.domain.CimiMachineTemplateVolumeTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiMachineVolume;
import org.ow2.sirocco.cimi.server.domain.CimiNetwork;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkCreate;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkNetworkPort;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkPort;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkPortConfiguration;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkPortCreate;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkPortTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiNetworkTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiResourceMetadata;
import org.ow2.sirocco.cimi.server.domain.CimiSummary;
import org.ow2.sirocco.cimi.server.domain.CimiSystem;
import org.ow2.sirocco.cimi.server.domain.CimiSystemAddress;
import org.ow2.sirocco.cimi.server.domain.CimiSystemCreate;
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
import org.ow2.sirocco.cimi.server.domain.CimiVolumeCreate;
import org.ow2.sirocco.cimi.server.domain.CimiVolumeImage;
import org.ow2.sirocco.cimi.server.domain.CimiVolumeTemplate;
import org.ow2.sirocco.cimi.server.domain.CimiVolumeVolumeImage;
import org.ow2.sirocco.cimi.server.domain.ExchangeType;
import org.ow2.sirocco.cimi.server.domain.collection.CimiAddressCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiAddressCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiAddressTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiAddressTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiCredentialCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiCredentialCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiCredentialTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiCredentialTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventLogCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventLogCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventLogTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiEventLogTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupNetworkCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupNetworkCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiForwardingGroupTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiJobCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiJobCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineConfigurationCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineDiskCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineDiskCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineImageCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineImageCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineNetworkInterfaceAddressCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineNetworkInterfaceAddressCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineNetworkInterfaceCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineNetworkInterfaceCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineVolumeCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiMachineVolumeCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkConfigurationCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkNetworkPortCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkNetworkPortCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortConfigurationCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkPortTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiNetworkTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiResourceMetadataCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiResourceMetadataCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemAddressCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemAddressCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemCredentialCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemCredentialCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemForwardingGroupCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemForwardingGroupCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemMachineCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemMachineCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemNetworkCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemNetworkCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemNetworkPortCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemNetworkPortCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemSystemCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemSystemCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemVolumeCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiSystemVolumeCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeConfigurationCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeConfigurationCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeImageCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeImageCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeTemplateCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeTemplateCollectionRoot;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeVolumeImageCollection;
import org.ow2.sirocco.cimi.server.domain.collection.CimiVolumeVolumeImageCollectionRoot;
import org.ow2.sirocco.cloudmanager.model.cimi.Address;
import org.ow2.sirocco.cloudmanager.model.cimi.AddressTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.CloudEntryPoint;
import org.ow2.sirocco.cloudmanager.model.cimi.Credentials;
import org.ow2.sirocco.cloudmanager.model.cimi.CredentialsTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.ForwardingGroup;
import org.ow2.sirocco.cloudmanager.model.cimi.ForwardingGroupTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.Job;
import org.ow2.sirocco.cloudmanager.model.cimi.Machine;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineConfiguration;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineDisk;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineImage;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineNetworkInterface;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineTemplateNetworkInterface;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineVolume;
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
import org.ow2.sirocco.cloudmanager.model.cimi.VolumeVolumeImage;
import org.ow2.sirocco.cloudmanager.model.cimi.event.AccessEventType;
import org.ow2.sirocco.cloudmanager.model.cimi.event.AlarmEventType;
import org.ow2.sirocco.cloudmanager.model.cimi.event.Event;
import org.ow2.sirocco.cloudmanager.model.cimi.event.EventLog;
import org.ow2.sirocco.cloudmanager.model.cimi.event.EventLogTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.event.ModelEventType;
import org.ow2.sirocco.cloudmanager.model.cimi.event.StateEventType;
import org.ow2.sirocco.cloudmanager.model.cimi.system.ComponentDescriptor;
import org.ow2.sirocco.cloudmanager.model.cimi.system.System;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemCredentials;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemMachine;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemNetwork;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemSystem;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemTemplate;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemVolume;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default configuration factory.
 */
public class ConfigFactory {
    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigFactory.class);

    /** Associated names */
    public static final String NAMES = "names";

    /** Converter class */
    public static final String CONVERTER = "converter";

    /** Class associate to other class (Service class associate to CIMI Class) */
    public static final String ASSOCIATE_TO = "associate-to";

    /**
     * Get the config.
     * 
     * @return The config
     */
    public Config getConfig() {
        Config config = new Config();
        config.setItems(this.buildItems());
        return config;
    }

    /**
     * Build the configuration.
     * 
     * @return A list of config items
     */
    protected List<ItemConfig> buildItems() {
        Map<Class<?>, ItemConfig> exchangeByClasses = new HashMap<Class<?>, ItemConfig>();
        // Builds
        List<ItemConfig> items = this.buildExchangeItems();
        for (ItemConfig item : items) {
            exchangeByClasses.put(item.getKlass(), item);
        }
        List<ItemConfig> serviceItems = this.buildServiceResources();
        List<ItemConfig> otherItems = this.buildOtherItems();
        // Add builds in same list
        items.addAll(serviceItems);
        items.addAll(otherItems);
        // Add associated resource service in exchange item config
        Class<?> cimiClass;
        ItemConfig cimiConfig;
        for (ItemConfig serviceConfig : serviceItems) {
            cimiClass = (Class<?>) serviceConfig.getData(ConfigFactory.ASSOCIATE_TO);
            cimiConfig = exchangeByClasses.get(cimiClass);
            if (null != cimiConfig) {
                cimiConfig.putData(ConfigFactory.ASSOCIATE_TO, serviceConfig.getKlass());
            }
        }

        return items;
    }

    /**
     * Build the configuration for {@link CimiExchange}.
     * 
     * @return A list of items config
     */
    protected List<ItemConfig> buildExchangeItems() {
        List<ItemConfig> items = new ArrayList<ItemConfig>();
        ItemConfig item = null;
        ItemConfig itemCollectionRoot = null;
        for (ExchangeType type : ExchangeType.values()) {
            item = this.buildExchangeItem(type);
            items.add(item);
            itemCollectionRoot = this.buildExchangeItemCollectionRoot(type);
            if (null != itemCollectionRoot) {
                // Add names data
                itemCollectionRoot.putData(ConfigFactory.NAMES, item.getData(ConfigFactory.NAMES));
                items.add(itemCollectionRoot);
            }
        }
        return items;
    }

    /**
     * Build the configuration for the given {@link ExchangeType}.
     * 
     * @return A item config
     */
    protected ItemConfig buildExchangeItem(final ExchangeType type) {
        ItemConfig item = null;
        Map<ExchangeType, String> referenceNames;

        switch (type) {
        case Action:
            item = new ItemConfig(CimiAction.class, ExchangeType.Action);
            break;

        case Address:
            item = new ItemConfig(CimiAddress.class, ExchangeType.Address);
            item.putData(ConfigFactory.CONVERTER, new AddressConverter());
            break;

        case AddressCollection:
            item = new ItemConfig(CimiAddressCollection.class, ExchangeType.AddressCollection);
            item.putData(ConfigFactory.CONVERTER, new AddressCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Address, "addresses");
            break;

        case AddressCreate:
            item = new ItemConfig(CimiAddressCreate.class, ExchangeType.AddressCreate);
            item.putData(ConfigFactory.CONVERTER, new AddressCreateConverter());
            break;

        case AddressTemplate:
            item = new ItemConfig(CimiAddressTemplate.class, ExchangeType.AddressTemplate);
            item.putData(ConfigFactory.CONVERTER, new AddressTemplateConverter());
            break;

        case AddressTemplateCollection:
            item = new ItemConfig(CimiAddressTemplateCollection.class, ExchangeType.AddressTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new AddressTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.AddressTemplate, "addressTemplates");
            break;

        case CloudEntryPoint:
            item = new ItemConfig(CimiCloudEntryPoint.class, ExchangeType.CloudEntryPoint);
            item.putData(ConfigFactory.CONVERTER, new CloudEntryPointConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ResourceMetadataCollection, "resourceMetadata");
            referenceNames.put(ExchangeType.SystemCollection, "systems");
            referenceNames.put(ExchangeType.SystemTemplateCollection, "systemTemplates");
            referenceNames.put(ExchangeType.MachineCollection, "machines");
            referenceNames.put(ExchangeType.MachineTemplateCollection, "machineTemplates");
            referenceNames.put(ExchangeType.MachineConfigurationCollection, "machineConfigs");
            referenceNames.put(ExchangeType.MachineImageCollection, "machineImages");
            referenceNames.put(ExchangeType.CredentialCollection, "credentials");
            referenceNames.put(ExchangeType.CredentialTemplateCollection, "credentialTemplates");
            referenceNames.put(ExchangeType.VolumeCollection, "volumes");
            referenceNames.put(ExchangeType.VolumeTemplateCollection, "volumeTemplates");
            referenceNames.put(ExchangeType.VolumeConfigurationCollection, "volumeConfigs");
            referenceNames.put(ExchangeType.VolumeImageCollection, "volumeImages");
            referenceNames.put(ExchangeType.NetworkCollection, "networks");
            referenceNames.put(ExchangeType.NetworkTemplateCollection, "networkTemplates");
            referenceNames.put(ExchangeType.NetworkConfigurationCollection, "networkConfigs");
            referenceNames.put(ExchangeType.NetworkPortCollection, "networkPorts");
            referenceNames.put(ExchangeType.NetworkPortTemplateCollection, "networkPortTemplates");
            referenceNames.put(ExchangeType.NetworkPortConfigurationCollection, "networkPortConfigs");
            referenceNames.put(ExchangeType.AddressCollection, "addresses");
            referenceNames.put(ExchangeType.AddressTemplateCollection, "addressTemplates");
            referenceNames.put(ExchangeType.ForwardingGroupCollection, "forwardingGroups");
            referenceNames.put(ExchangeType.ForwardingGroupTemplateCollection, "forwardingGroupTemplates");
            referenceNames.put(ExchangeType.JobCollection, "jobs");
            referenceNames.put(ExchangeType.EventLogCollection, "eventLogs");
            referenceNames.put(ExchangeType.EventLogTemplateCollection, "eventLogTemplates");
            referenceNames.put(ExchangeType.EventCollection, "events");
            break;

        case Credential:
            item = new ItemConfig(CimiCredential.class, ExchangeType.Credential);
            item.putData(ConfigFactory.CONVERTER, new CredentialConverter());
            break;

        case CredentialCollection:
            item = new ItemConfig(CimiCredentialCollection.class, ExchangeType.CredentialCollection);
            item.putData(ConfigFactory.CONVERTER, new CredentialCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Credential, "credentials");
            break;

        case CredentialCreate:
            item = new ItemConfig(CimiCredentialCreate.class, ExchangeType.CredentialCreate);
            item.putData(ConfigFactory.CONVERTER, new CredentialCreateConverter());
            break;

        case CredentialTemplate:
            item = new ItemConfig(CimiCredentialTemplate.class, ExchangeType.CredentialTemplate);
            item.putData(ConfigFactory.CONVERTER, new CredentialTemplateConverter());
            break;

        case CredentialTemplateCollection:
            item = new ItemConfig(CimiCredentialTemplateCollection.class, ExchangeType.CredentialTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new CredentialTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.CredentialTemplate, "credentialTemplates");
            break;

        case Disk:
            item = new ItemConfig(CimiMachineDisk.class, ExchangeType.Disk);
            item.putData(ConfigFactory.CONVERTER, new MachineDiskConverter());
            break;

        case DiskCollection:
            item = new ItemConfig(CimiMachineDiskCollection.class, ExchangeType.DiskCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineDiskCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Disk, "disks");
            break;

        case Event:
            item = new ItemConfig(CimiEvent.class, ExchangeType.Event);
            item.putData(ConfigFactory.CONVERTER, new EventConverter());
            break;

        case EventCollection:
            item = new ItemConfig(CimiEventCollection.class, ExchangeType.EventCollection);
            item.putData(ConfigFactory.CONVERTER, new EventCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Event, "events");
            break;

        case EventLog:
            item = new ItemConfig(CimiEventLog.class, ExchangeType.EventLog);
            item.putData(ConfigFactory.CONVERTER, new EventLogConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.EventCollection, "events");
            break;

        case EventLogCollection:
            item = new ItemConfig(CimiEventLogCollection.class, ExchangeType.EventLogCollection);
            item.putData(ConfigFactory.CONVERTER, new EventLogCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.EventLog, "eventLogs");
            break;

        case EventLogCreate:
            item = new ItemConfig(CimiEventLogCreate.class, ExchangeType.EventLogCreate);
            item.putData(ConfigFactory.CONVERTER, new EventLogCreateConverter());
            break;

        case EventLogTemplate:
            item = new ItemConfig(CimiEventLogTemplate.class, ExchangeType.EventLogTemplate);
            item.putData(ConfigFactory.CONVERTER, new EventLogTemplateConverter());
            break;

        case EventLogTemplateCollection:
            item = new ItemConfig(CimiEventLogTemplateCollection.class, ExchangeType.EventLogTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new EventLogTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.EventLogTemplate, "eventLogTemplates");
            break;

        case ForwardingGroup:
            item = new ItemConfig(CimiForwardingGroup.class, ExchangeType.ForwardingGroup);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ForwardingGroupNetworkCollection, "images");
            referenceNames.put(ExchangeType.EventLog, "eventLog");
            break;

        case ForwardingGroupCollection:
            item = new ItemConfig(CimiForwardingGroupCollection.class, ExchangeType.ForwardingGroupCollection);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ForwardingGroup, "forwardingGroups");
            break;

        case ForwardingGroupCreate:
            item = new ItemConfig(CimiForwardingGroupCreate.class, ExchangeType.ForwardingGroupCreate);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupCreateConverter());
            break;

        case ForwardingGroupNetwork:
            item = new ItemConfig(CimiForwardingGroupNetwork.class, ExchangeType.ForwardingGroupNetwork);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupNetworkConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Network, "network");
            break;

        case ForwardingGroupNetworkCollection:
            item = new ItemConfig(CimiForwardingGroupNetworkCollection.class, ExchangeType.ForwardingGroupNetworkCollection);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupNetworkCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ForwardingGroupNetwork, "forwardingGroupNetworks");
            break;

        case ForwardingGroupTemplate:
            item = new ItemConfig(CimiForwardingGroupTemplate.class, ExchangeType.ForwardingGroupTemplate);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupTemplateConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ForwardingGroupNetwork, "networks");
            break;

        case ForwardingGroupTemplateCollection:
            item = new ItemConfig(CimiForwardingGroupTemplateCollection.class, ExchangeType.ForwardingGroupTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ForwardingGroupTemplate, "forwardingGroupTemplates");
            break;

        case Job:
            item = new ItemConfig(CimiJob.class, ExchangeType.Job);
            item.putData(ConfigFactory.CONVERTER, new JobConverter());
            break;

        case JobCollection:
            item = new ItemConfig(CimiJobCollection.class, ExchangeType.JobCollection);
            item.putData(ConfigFactory.CONVERTER, new JobCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Job, "jobs");
            break;

        case Machine:
            item = new ItemConfig(CimiMachine.class, ExchangeType.Machine);
            item.putData(ConfigFactory.CONVERTER, new MachineConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.DiskCollection, "disks");
            referenceNames.put(ExchangeType.MachineVolumeCollection, "volumes");
            referenceNames.put(ExchangeType.MachineNetworkInterfaceCollection, "networkInterfaces");
            // referenceNames.put(ExchangeType.MachineSnapshotCollection,
            // "machineSnapshots");
            // referenceNames.put(ExchangeType.MachineMeterCollection,
            // "meters");
            break;

        case MachineCollection:
            item = new ItemConfig(CimiMachineCollection.class, ExchangeType.MachineCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Machine, "machines");
            break;

        case MachineConfiguration:
            item = new ItemConfig(CimiMachineConfiguration.class, ExchangeType.MachineConfiguration);
            item.putData(ConfigFactory.CONVERTER, new MachineConfigurationConverter());
            break;

        case MachineConfigurationCollection:
            item = new ItemConfig(CimiMachineConfigurationCollection.class, ExchangeType.MachineConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineConfigurationCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineConfiguration, "machineConfigurations");
            break;

        case MachineCreate:
            item = new ItemConfig(CimiMachineCreate.class, ExchangeType.MachineCreate);
            item.putData(ConfigFactory.CONVERTER, new MachineCreateConverter());
            break;

        case MachineImage:
            item = new ItemConfig(CimiMachineImage.class, ExchangeType.MachineImage);
            item.putData(ConfigFactory.CONVERTER, new MachineImageConverter());
            break;

        case MachineImageCollection:
            item = new ItemConfig(CimiMachineImageCollection.class, ExchangeType.MachineImageCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineImageCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineImage, "machineImages");
            break;

        case MachineNetworkInterface:
            item = new ItemConfig(CimiMachineNetworkInterface.class, ExchangeType.MachineNetworkInterface);
            item.putData(ConfigFactory.CONVERTER, new MachineNetworkInterfaceConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineNetworkInterfaceAddressCollection, "addresses");
            referenceNames.put(ExchangeType.Network, "network");
            referenceNames.put(ExchangeType.NetworkPort, "networkPort");
            break;

        case MachineNetworkInterfaceCollection:
            item = new ItemConfig(CimiMachineNetworkInterfaceCollection.class, ExchangeType.MachineNetworkInterfaceCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineNetworkInterfaceCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineNetworkInterface, "machineNetworkInterfaces");
            break;

        case MachineNetworkInterfaceAddress:
            item = new ItemConfig(CimiMachineNetworkInterfaceAddress.class, ExchangeType.MachineNetworkInterfaceAddress);
            item.putData(ConfigFactory.CONVERTER, new MachineNetworkInterfaceAddressConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Address, "address");
            break;

        case MachineNetworkInterfaceAddressCollection:
            item = new ItemConfig(CimiMachineNetworkInterfaceAddressCollection.class,
                ExchangeType.MachineNetworkInterfaceAddressCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineNetworkInterfaceAddressCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineNetworkInterfaceAddress, "addresses");
            break;

        case MachineTemplate:
            item = new ItemConfig(CimiMachineTemplate.class, ExchangeType.MachineTemplate);
            item.putData(ConfigFactory.CONVERTER, new MachineTemplateConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineConfiguration, "machineConfig");
            referenceNames.put(ExchangeType.MachineImage, "machineImage");
            referenceNames.put(ExchangeType.Credential, "credential");
            referenceNames.put(ExchangeType.Volume, "volume");
            referenceNames.put(ExchangeType.VolumeTemplate, "volumeTemplate");
            referenceNames.put(ExchangeType.Address, "address");
            referenceNames.put(ExchangeType.Network, "network");
            referenceNames.put(ExchangeType.NetworkPort, "networkPort");
            referenceNames.put(ExchangeType.EventLogTemplate, "eventLogTemplate");
            break;

        case MachineTemplateCollection:
            item = new ItemConfig(CimiMachineTemplateCollection.class, ExchangeType.MachineTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineTemplate, "machineTemplates");
            break;

        case MachineTemplateVolume:
            item = new ItemConfig(CimiMachineTemplateVolume.class, ExchangeType.MachineTemplateVolume);
            item.putData(ConfigFactory.CONVERTER, new MachineTemplateVolumeConverter());
            break;

        case MachineTemplateVolumeTemplate:
            item = new ItemConfig(CimiMachineTemplateVolumeTemplate.class, ExchangeType.MachineTemplateVolumeTemplate);
            item.putData(ConfigFactory.CONVERTER, new MachineTemplateVolumeTemplateConverter());
            break;

        case MachineVolume:
            item = new ItemConfig(CimiMachineVolume.class, ExchangeType.MachineVolume);
            item.putData(ConfigFactory.CONVERTER, new MachineVolumeConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Volume, "volume");
            break;

        case MachineVolumeCollection:
            item = new ItemConfig(CimiMachineVolumeCollection.class, ExchangeType.MachineVolumeCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineVolumeCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.MachineVolume, "volumes");
            break;

        case Network:
            item = new ItemConfig(CimiNetwork.class, ExchangeType.Network);
            item.putData(ConfigFactory.CONVERTER, new NetworkConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkNetworkPortCollection, "networkPorts");
            referenceNames.put(ExchangeType.ForwardingGroup, "forwardingGroup");
            referenceNames.put(ExchangeType.EventLog, "eventLog");
            break;

        case NetworkCollection:
            item = new ItemConfig(CimiNetworkCollection.class, ExchangeType.NetworkCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Network, "networks");
            break;

        case NetworkConfiguration:
            item = new ItemConfig(CimiNetworkConfiguration.class, ExchangeType.NetworkConfiguration);
            item.putData(ConfigFactory.CONVERTER, new NetworkConfigurationConverter());
            break;

        case NetworkConfigurationCollection:
            item = new ItemConfig(CimiNetworkConfigurationCollection.class, ExchangeType.NetworkConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkConfigurationCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkConfiguration, "networkConfigurations");
            break;

        case NetworkCreate:
            item = new ItemConfig(CimiNetworkCreate.class, ExchangeType.NetworkCreate);
            item.putData(ConfigFactory.CONVERTER, new NetworkCreateConverter());
            break;

        case NetworkNetworkPort:
            item = new ItemConfig(CimiNetworkNetworkPort.class, ExchangeType.NetworkNetworkPort);
            item.putData(ConfigFactory.CONVERTER, new NetworkNetworkPortConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkPort, "networkPort");
            break;

        case NetworkNetworkPortCollection:
            item = new ItemConfig(CimiNetworkNetworkPortCollection.class, ExchangeType.NetworkNetworkPortCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkNetworkPortCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkPort, "networkPorts");
            break;

        case NetworkTemplate:
            item = new ItemConfig(CimiNetworkTemplate.class, ExchangeType.NetworkTemplate);
            item.putData(ConfigFactory.CONVERTER, new NetworkTemplateConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkConfiguration, "networkConfig");
            referenceNames.put(ExchangeType.ForwardingGroup, "forwardingGroup");
            referenceNames.put(ExchangeType.EventLogTemplate, "eventLogTemplate");
            break;

        case NetworkTemplateCollection:
            item = new ItemConfig(CimiNetworkTemplateCollection.class, ExchangeType.NetworkTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkTemplate, "networkTemplates");
            break;

        case NetworkPort:
            item = new ItemConfig(CimiNetworkPort.class, ExchangeType.NetworkPort);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Network, "network");
            referenceNames.put(ExchangeType.EventLog, "eventLog");
            break;

        case NetworkPortCollection:
            item = new ItemConfig(CimiNetworkPortCollection.class, ExchangeType.NetworkPortCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkPort, "networkPorts");
            break;

        case NetworkPortConfiguration:
            item = new ItemConfig(CimiNetworkPortConfiguration.class, ExchangeType.NetworkPortConfiguration);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortConfigurationConverter());
            break;

        case NetworkPortConfigurationCollection:
            item = new ItemConfig(CimiNetworkPortConfigurationCollection.class, ExchangeType.NetworkPortConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortConfigurationCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkPortConfiguration, "networkPortConfigurations");
            break;

        case NetworkPortCreate:
            item = new ItemConfig(CimiNetworkPortCreate.class, ExchangeType.NetworkPortCreate);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortCreateConverter());
            break;

        case NetworkPortTemplate:
            item = new ItemConfig(CimiNetworkPortTemplate.class, ExchangeType.NetworkPortTemplate);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortTemplateConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Network, "network");
            referenceNames.put(ExchangeType.NetworkPortConfiguration, "networkPortConfig");
            referenceNames.put(ExchangeType.EventLogTemplate, "eventLogTemplate");
            break;

        case NetworkPortTemplateCollection:
            item = new ItemConfig(CimiNetworkPortTemplateCollection.class, ExchangeType.NetworkPortTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkPortTemplate, "networkPortTemplates");
            break;

        case Volume:
            item = new ItemConfig(CimiVolume.class, ExchangeType.Volume);
            item.putData(ConfigFactory.CONVERTER, new VolumeConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.VolumeVolumeImageCollection, "images");
            referenceNames.put(ExchangeType.EventLog, "eventLog");
            break;

        case VolumeCollection:
            item = new ItemConfig(CimiVolumeCollection.class, ExchangeType.VolumeCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Volume, "volumes");
            break;

        case VolumeConfiguration:
            item = new ItemConfig(CimiVolumeConfiguration.class, ExchangeType.VolumeConfiguration);
            item.putData(ConfigFactory.CONVERTER, new VolumeConfigurationConverter());
            break;

        case VolumeConfigurationCollection:
            item = new ItemConfig(CimiVolumeConfigurationCollection.class, ExchangeType.VolumeConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeConfigurationCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.VolumeConfiguration, "volumeConfigurations");
            break;

        case VolumeCreate:
            item = new ItemConfig(CimiVolumeCreate.class, ExchangeType.VolumeCreate);
            item.putData(ConfigFactory.CONVERTER, new VolumeCreateConverter());
            break;

        case VolumeImage:
            item = new ItemConfig(CimiVolumeImage.class, ExchangeType.VolumeImage);
            item.putData(ConfigFactory.CONVERTER, new VolumeImageConverter());
            break;

        case VolumeImageCollection:
            item = new ItemConfig(CimiVolumeImageCollection.class, ExchangeType.VolumeImageCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeImageCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.VolumeImage, "volumeImages");
            break;

        case VolumeTemplate:
            item = new ItemConfig(CimiVolumeTemplate.class, ExchangeType.VolumeTemplate);
            item.putData(ConfigFactory.CONVERTER, new VolumeTemplateConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.VolumeConfiguration, "volumeConfig");
            referenceNames.put(ExchangeType.VolumeImage, "volumeImage");
            referenceNames.put(ExchangeType.EventLogTemplate, "eventLogTemplate");
            break;

        case VolumeTemplateCollection:
            item = new ItemConfig(CimiVolumeTemplateCollection.class, ExchangeType.VolumeTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.VolumeTemplate, "volumeTemplates");
            break;

        case VolumeVolumeImage:
            item = new ItemConfig(CimiVolumeVolumeImage.class, ExchangeType.VolumeVolumeImage);
            item.putData(ConfigFactory.CONVERTER, new VolumeVolumeImageConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.VolumeImage, "volumeImage");
            break;

        case VolumeVolumeImageCollection:
            item = new ItemConfig(CimiVolumeVolumeImageCollection.class, ExchangeType.VolumeVolumeImageCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeVolumeImageCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.VolumeVolumeImage, "images");
            break;

        case System:
            item = new ItemConfig(CimiSystem.class, ExchangeType.System);
            item.putData(ConfigFactory.CONVERTER, new SystemConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemSystemCollection, "systems");
            referenceNames.put(ExchangeType.SystemMachineCollection, "machines");
            referenceNames.put(ExchangeType.SystemCredentialCollection, "credentials");
            referenceNames.put(ExchangeType.SystemVolumeCollection, "volumes");
            referenceNames.put(ExchangeType.SystemNetworkCollection, "networks");
            referenceNames.put(ExchangeType.SystemNetworkPortCollection, "networkPorts");
            referenceNames.put(ExchangeType.SystemAddressCollection, "addresses");
            referenceNames.put(ExchangeType.SystemForwardingGroupCollection, "forwardingGroups");
            // referenceNames.put(ExchangeType.MeterCollection, "meters");
            referenceNames.put(ExchangeType.EventLog, "eventLog");

            break;

        case SystemAddress:
            item = new ItemConfig(CimiSystemAddress.class, ExchangeType.SystemAddress);
            item.putData(ConfigFactory.CONVERTER, new SystemAddressConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Address, "address");
            break;

        case SystemAddressCollection:
            item = new ItemConfig(CimiSystemAddressCollection.class, ExchangeType.SystemAddressCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemAddressCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemAddress, "systemAddresss");
            break;

        case SystemCollection:
            item = new ItemConfig(CimiSystemCollection.class, ExchangeType.SystemCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.System, "systems");
            break;

        case SystemCreate:
            item = new ItemConfig(CimiSystemCreate.class, ExchangeType.SystemCreate);
            item.putData(ConfigFactory.CONVERTER, new SystemCreateConverter());
            break;

        case SystemCredential:
            item = new ItemConfig(CimiSystemCredential.class, ExchangeType.SystemCredential);
            item.putData(ConfigFactory.CONVERTER, new SystemCredentialConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Credential, "credential");
            break;

        case SystemCredentialCollection:
            item = new ItemConfig(CimiSystemCredentialCollection.class, ExchangeType.SystemCredentialCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemCredentialCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemCredential, "systemCredentials");
            break;

        case SystemForwardingGroup:
            item = new ItemConfig(CimiSystemForwardingGroup.class, ExchangeType.SystemForwardingGroup);
            item.putData(ConfigFactory.CONVERTER, new SystemForwardingGroupConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ForwardingGroup, "forwardingGroup");
            break;

        case SystemForwardingGroupCollection:
            item = new ItemConfig(CimiSystemForwardingGroupCollection.class, ExchangeType.SystemForwardingGroupCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemForwardingGroupCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemForwardingGroup, "systemForwardingGroups");
            break;

        case SystemMachine:
            item = new ItemConfig(CimiSystemMachine.class, ExchangeType.SystemMachine);
            item.putData(ConfigFactory.CONVERTER, new SystemMachineConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Machine, "machine");
            break;

        case SystemMachineCollection:
            item = new ItemConfig(CimiSystemMachineCollection.class, ExchangeType.SystemMachineCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemMachineCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemMachine, "systemMachines");
            break;

        case SystemNetwork:
            item = new ItemConfig(CimiSystemNetwork.class, ExchangeType.SystemNetwork);
            item.putData(ConfigFactory.CONVERTER, new SystemNetworkConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Network, "network");
            break;

        case SystemNetworkCollection:
            item = new ItemConfig(CimiSystemNetworkCollection.class, ExchangeType.SystemNetworkCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemNetworkCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemNetwork, "systemNetworks");
            break;

        case SystemNetworkPort:
            item = new ItemConfig(CimiSystemNetworkPort.class, ExchangeType.SystemNetworkPort);
            item.putData(ConfigFactory.CONVERTER, new SystemNetworkPortConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.NetworkPort, "networkPort");
            break;

        case SystemNetworkPortCollection:
            item = new ItemConfig(CimiSystemNetworkPortCollection.class, ExchangeType.SystemNetworkPortCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemNetworkPortCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemNetworkPort, "systemNetworkPorts");
            break;

        case SystemSystem:
            item = new ItemConfig(CimiSystemSystem.class, ExchangeType.SystemSystem);
            item.putData(ConfigFactory.CONVERTER, new SystemSystemConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.System, "system");
            break;

        case SystemSystemCollection:
            item = new ItemConfig(CimiSystemSystemCollection.class, ExchangeType.SystemSystemCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemSystemCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemSystem, "systemSystems");
            break;

        case SystemTemplate:
            item = new ItemConfig(CimiSystemTemplate.class, ExchangeType.SystemTemplate);
            item.putData(ConfigFactory.CONVERTER, new SystemTemplateConverter());
            break;

        case SystemTemplateCollection:
            item = new ItemConfig(CimiSystemTemplateCollection.class, ExchangeType.SystemTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemTemplateCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemTemplate, "systemTemplates");
            break;

        case SystemVolume:
            item = new ItemConfig(CimiSystemVolume.class, ExchangeType.SystemVolume);
            item.putData(ConfigFactory.CONVERTER, new SystemVolumeConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.Volume, "volume");
            break;

        case SystemVolumeCollection:
            item = new ItemConfig(CimiSystemVolumeCollection.class, ExchangeType.SystemVolumeCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemVolumeCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.SystemVolume, "systemVolumes");
            break;

        case ResourceMetadata:
            item = new ItemConfig(CimiResourceMetadata.class, ExchangeType.ResourceMetadata);
            item.putData(ConfigFactory.CONVERTER, new ResourceMetadataConverter());
            break;

        case ResourceMetadataCollection:
            item = new ItemConfig(CimiResourceMetadataCollection.class, ExchangeType.ResourceMetadataCollection);
            item.putData(ConfigFactory.CONVERTER, new ResourceMetadataCollectionConverter());
            referenceNames = new HashMap<ExchangeType, String>();
            item.putData(ConfigFactory.NAMES, referenceNames);
            referenceNames.put(ExchangeType.ResourceMetadata, "resourceMetadatas");
            break;

        default:
            ConfigFactory.LOGGER.error("Configuration not found : {}", type);
            throw new ConfigurationException("Configuration not found : " + type);
        }
        return item;
    }

    /**
     * Build the configuration for the given {@link ExchangeType}.
     * 
     * @return A item config
     */
    protected ItemConfig buildExchangeItemCollectionRoot(final ExchangeType type) {
        ItemConfig item = null;

        switch (type) {

        case AddressCollection:
            item = new ItemConfig(CimiAddressCollectionRoot.class, ExchangeType.AddressCollection);
            item.putData(ConfigFactory.CONVERTER, new AddressCollectionRootConverter());
            break;

        case AddressTemplateCollection:
            item = new ItemConfig(CimiAddressTemplateCollectionRoot.class, ExchangeType.AddressTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new AddressTemplateCollectionRootConverter());
            break;

        case CredentialCollection:
            item = new ItemConfig(CimiCredentialCollectionRoot.class, ExchangeType.CredentialCollection);
            item.putData(ConfigFactory.CONVERTER, new CredentialCollectionRootConverter());
            break;

        case CredentialTemplateCollection:
            item = new ItemConfig(CimiCredentialTemplateCollectionRoot.class, ExchangeType.CredentialTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new CredentialTemplateCollectionRootConverter());
            break;

        case DiskCollection:
            item = new ItemConfig(CimiMachineDiskCollectionRoot.class, ExchangeType.DiskCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineDiskCollectionRootConverter());
            break;

        case EventCollection:
            item = new ItemConfig(CimiEventCollectionRoot.class, ExchangeType.EventCollection);
            item.putData(ConfigFactory.CONVERTER, new EventCollectionRootConverter());
            break;

        case EventLogCollection:
            item = new ItemConfig(CimiEventLogCollectionRoot.class, ExchangeType.EventLogCollection);
            item.putData(ConfigFactory.CONVERTER, new EventLogCollectionRootConverter());
            break;

        case EventLogTemplateCollection:
            item = new ItemConfig(CimiEventLogTemplateCollectionRoot.class, ExchangeType.EventLogTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new EventLogTemplateCollectionRootConverter());
            break;

        case ForwardingGroupCollection:
            item = new ItemConfig(CimiForwardingGroupCollectionRoot.class, ExchangeType.ForwardingGroupCollection);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupCollectionRootConverter());
            break;

        case ForwardingGroupNetworkCollection:
            item = new ItemConfig(CimiForwardingGroupNetworkCollectionRoot.class, ExchangeType.ForwardingGroupNetworkCollection);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupNetworkCollectionRootConverter());
            break;

        case ForwardingGroupTemplateCollection:
            item = new ItemConfig(CimiForwardingGroupTemplateCollectionRoot.class,
                ExchangeType.ForwardingGroupTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new ForwardingGroupTemplateCollectionRootConverter());
            break;

        case JobCollection:
            item = new ItemConfig(CimiJobCollectionRoot.class, ExchangeType.JobCollection);
            item.putData(ConfigFactory.CONVERTER, new JobCollectionRootConverter());
            break;

        case MachineCollection:
            item = new ItemConfig(CimiMachineCollectionRoot.class, ExchangeType.MachineCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineCollectionRootConverter());
            break;

        case MachineConfigurationCollection:
            item = new ItemConfig(CimiMachineConfigurationCollectionRoot.class, ExchangeType.MachineConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineConfigurationCollectionRootConverter());
            break;

        case MachineImageCollection:
            item = new ItemConfig(CimiMachineImageCollectionRoot.class, ExchangeType.MachineImageCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineImageCollectionRootConverter());
            break;

        case MachineNetworkInterfaceCollection:
            item = new ItemConfig(CimiMachineNetworkInterfaceCollectionRoot.class,
                ExchangeType.MachineNetworkInterfaceCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineNetworkInterfaceCollectionRootConverter());
            break;

        case MachineNetworkInterfaceAddressCollection:
            item = new ItemConfig(CimiMachineNetworkInterfaceAddressCollectionRoot.class,
                ExchangeType.MachineNetworkInterfaceAddressCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineNetworkInterfaceAddressCollectionRootConverter());
            break;

        case MachineTemplateCollection:
            item = new ItemConfig(CimiMachineTemplateCollectionRoot.class, ExchangeType.MachineTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineTemplateCollectionRootConverter());
            break;

        case MachineVolumeCollection:
            item = new ItemConfig(CimiMachineVolumeCollectionRoot.class, ExchangeType.MachineVolumeCollection);
            item.putData(ConfigFactory.CONVERTER, new MachineVolumeCollectionRootConverter());
            break;

        case NetworkCollection:
            item = new ItemConfig(CimiNetworkCollectionRoot.class, ExchangeType.NetworkCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkCollectionRootConverter());
            break;

        case NetworkConfigurationCollection:
            item = new ItemConfig(CimiNetworkConfigurationCollectionRoot.class, ExchangeType.NetworkConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkConfigurationCollectionRootConverter());
            break;

        case NetworkNetworkPortCollection:
            item = new ItemConfig(CimiNetworkNetworkPortCollectionRoot.class, ExchangeType.NetworkNetworkPortCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkNetworkPortCollectionRootConverter());
            break;

        case NetworkPortCollection:
            item = new ItemConfig(CimiNetworkPortCollectionRoot.class, ExchangeType.NetworkPortCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortCollectionRootConverter());
            break;

        case NetworkPortConfigurationCollection:
            item = new ItemConfig(CimiNetworkPortConfigurationCollectionRoot.class,
                ExchangeType.NetworkPortConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortConfigurationCollectionRootConverter());
            break;

        case NetworkPortTemplateCollection:
            item = new ItemConfig(CimiNetworkPortTemplateCollectionRoot.class, ExchangeType.NetworkPortTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkPortTemplateCollectionRootConverter());
            break;

        case NetworkTemplateCollection:
            item = new ItemConfig(CimiNetworkTemplateCollectionRoot.class, ExchangeType.NetworkTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new NetworkTemplateCollectionRootConverter());
            break;

        case VolumeCollection:
            item = new ItemConfig(CimiVolumeCollectionRoot.class, ExchangeType.VolumeCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeCollectionRootConverter());
            break;

        case VolumeConfigurationCollection:
            item = new ItemConfig(CimiVolumeConfigurationCollectionRoot.class, ExchangeType.VolumeConfigurationCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeConfigurationCollectionRootConverter());
            break;

        case VolumeImageCollection:
            item = new ItemConfig(CimiVolumeImageCollectionRoot.class, ExchangeType.VolumeImageCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeImageCollectionRootConverter());
            break;

        case VolumeTemplateCollection:
            item = new ItemConfig(CimiVolumeTemplateCollectionRoot.class, ExchangeType.VolumeTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeTemplateCollectionRootConverter());
            break;

        case VolumeVolumeImageCollection:
            item = new ItemConfig(CimiVolumeVolumeImageCollectionRoot.class, ExchangeType.VolumeVolumeImageCollection);
            item.putData(ConfigFactory.CONVERTER, new VolumeVolumeImageCollectionRootConverter());
            break;

        case ResourceMetadataCollection:
            item = new ItemConfig(CimiResourceMetadataCollectionRoot.class, ExchangeType.ResourceMetadataCollection);
            item.putData(ConfigFactory.CONVERTER, new ResourceMetadataCollectionRootConverter());
            break;

        case SystemCollection:
            item = new ItemConfig(CimiSystemCollectionRoot.class, ExchangeType.SystemCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemCollectionRootConverter());
            break;

        case SystemAddressCollection:
            item = new ItemConfig(CimiSystemAddressCollectionRoot.class, ExchangeType.SystemAddressCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemAddressCollectionRootConverter());
            break;

        case SystemCredentialCollection:
            item = new ItemConfig(CimiSystemCredentialCollectionRoot.class, ExchangeType.SystemCredentialCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemCredentialCollectionRootConverter());
            break;

        case SystemForwardingGroupCollection:
            item = new ItemConfig(CimiSystemForwardingGroupCollectionRoot.class, ExchangeType.SystemForwardingGroupCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemForwardingGroupCollectionRootConverter());
            break;

        case SystemMachineCollection:
            item = new ItemConfig(CimiSystemMachineCollectionRoot.class, ExchangeType.SystemMachineCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemMachineCollectionRootConverter());
            break;

        case SystemNetworkCollection:
            item = new ItemConfig(CimiSystemNetworkCollectionRoot.class, ExchangeType.SystemNetworkCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemNetworkCollectionRootConverter());
            break;

        case SystemNetworkPortCollection:
            item = new ItemConfig(CimiSystemNetworkPortCollectionRoot.class, ExchangeType.SystemNetworkPortCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemNetworkPortCollectionRootConverter());
            break;

        case SystemSystemCollection:
            item = new ItemConfig(CimiSystemSystemCollectionRoot.class, ExchangeType.SystemSystemCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemSystemCollectionRootConverter());
            break;

        case SystemTemplateCollection:
            item = new ItemConfig(CimiSystemTemplateCollectionRoot.class, ExchangeType.SystemTemplateCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemTemplateCollectionRootConverter());
            break;

        case SystemVolumeCollection:
            item = new ItemConfig(CimiSystemVolumeCollectionRoot.class, ExchangeType.SystemVolumeCollection);
            item.putData(ConfigFactory.CONVERTER, new SystemVolumeCollectionRootConverter());
            break;

        case Address:
        case AddressCreate:
        case AddressTemplate:
        case CloudEntryPoint:
        case Credential:
        case CredentialCreate:
        case CredentialTemplate:
        case Event:
        case EventLog:
        case EventLogCreate:
        case EventLogTemplate:
        case ForwardingGroup:
        case ForwardingGroupCreate:
        case ForwardingGroupNetwork:
        case ForwardingGroupTemplate:
        case Disk:
        case Job:
        case Machine:
        case Action:
        case MachineConfiguration:
        case MachineCreate:
        case MachineImage:
        case MachineNetworkInterface:
        case MachineNetworkInterfaceAddress:
        case MachineTemplate:
        case MachineTemplateVolume:
        case MachineTemplateVolumeTemplate:
        case MachineVolume:
        case Network:
        case NetworkConfiguration:
        case NetworkCreate:
        case NetworkPort:
        case NetworkNetworkPort:
        case NetworkPortConfiguration:
        case NetworkPortCreate:
        case NetworkPortTemplate:
        case NetworkTemplate:
        case System:
        case SystemAddress:
        case SystemCreate:
        case SystemCredential:
        case SystemForwardingGroup:
        case SystemMachine:
        case SystemNetwork:
        case SystemNetworkPort:
        case SystemSystem:
        case SystemTemplate:
        case SystemVolume:
        case Volume:
        case VolumeConfiguration:
        case VolumeCreate:
        case VolumeImage:
        case VolumeTemplate:
        case VolumeVolumeImage:
        case ResourceMetadata:
            break;

        default:
            ConfigFactory.LOGGER.error("Configuration not found : {}", type);
            throw new ConfigurationException("Configuration not found : " + type);
        }
        return item;
    }

    /**
     * Build the configuration for service resources classes.
     * 
     * @return A list of config items
     */
    protected List<ItemConfig> buildServiceResources() {
        List<ItemConfig> items = new ArrayList<ItemConfig>();

        // CloudEntity implementation
        items.add(this.makeAssociate(Address.class, CimiAddress.class));
        items.add(this.makeAssociate(AddressTemplate.class, CimiAddressTemplate.class));
        items.add(this.makeAssociate(CloudEntryPoint.class, CimiCloudEntryPoint.class));
        items.add(this.makeAssociate(ComponentDescriptor.class, CimiComponentDescriptor.class));
        items.add(this.makeAssociate(Event.class, CimiEvent.class));
        items.add(this.makeAssociate(EventLog.class, CimiEventLog.class));
        items.add(this.makeAssociate(ForwardingGroupTemplate.class, CimiForwardingGroupTemplate.class));
        items.add(this.makeAssociate(Job.class, CimiJob.class));
        items.add(this.makeAssociate(MachineConfiguration.class, CimiMachineConfiguration.class));
        items.add(this.makeAssociate(MachineDisk.class, CimiMachineDisk.class));
        items.add(this.makeAssociate(MachineTemplateNetworkInterface.class, CimiMachineTemplateNetworkInterface.class));
        // TODO Meter
        // TODO MeterConfiguration
        // TODO MeterSample
        // TODO MeterTemplate
        items.add(this.makeAssociate(NetworkConfiguration.class, CimiNetworkConfiguration.class));
        items.add(this.makeAssociate(NetworkPortConfiguration.class, CimiNetworkPortConfiguration.class));
        items.add(this.makeAssociate(NetworkPortTemplate.class, CimiNetworkPortTemplate.class));
        items.add(this.makeAssociate(VolumeConfiguration.class, CimiVolumeConfiguration.class));
        items.add(this.makeAssociate(VolumeVolumeImage.class, CimiVolumeVolumeImage.class));

        // CloudCollectionItem implementation
        items.add(this.makeAssociate(SystemCredentials.class, CimiSystemCredential.class));
        items.add(this.makeAssociate(SystemMachine.class, CimiSystemMachine.class));
        items.add(this.makeAssociate(SystemNetwork.class, CimiSystemNetwork.class));
        items.add(this.makeAssociate(SystemSystem.class, CimiSystemSystem.class));
        items.add(this.makeAssociate(SystemVolume.class, CimiSystemVolume.class));

        // CloudTemplate implementation
        items.add(this.makeAssociate(CredentialsTemplate.class, CimiCredentialTemplate.class));
        items.add(this.makeAssociate(EventLogTemplate.class, CimiEventLogTemplate.class));
        items.add(this.makeAssociate(MachineTemplate.class, CimiMachineTemplate.class));
        items.add(this.makeAssociate(NetworkTemplate.class, CimiNetworkTemplate.class));
        items.add(this.makeAssociate(SystemTemplate.class, CimiSystemTemplate.class));
        items.add(this.makeAssociate(VolumeTemplate.class, CimiVolumeTemplate.class));

        // CloudResource implementation
        items.add(this.makeAssociate(Credentials.class, CimiCredential.class));
        items.add(this.makeAssociate(ForwardingGroup.class, CimiForwardingGroup.class));
        items.add(this.makeAssociate(Machine.class, CimiMachine.class));
        items.add(this.makeAssociate(MachineImage.class, CimiMachineImage.class));
        items.add(this.makeAssociate(MachineNetworkInterface.class, CimiMachineNetworkInterface.class));
        items.add(this.makeAssociate(MachineVolume.class, CimiMachineVolume.class));
        items.add(this.makeAssociate(Network.class, CimiNetwork.class));
        items.add(this.makeAssociate(NetworkPort.class, CimiNetworkPort.class));
        items.add(this.makeAssociate(System.class, CimiSystem.class));
        items.add(this.makeAssociate(Volume.class, CimiVolume.class));
        items.add(this.makeAssociate(VolumeImage.class, CimiVolumeImage.class));

        // EventType implementation
        items.add(this.makeAssociate(AccessEventType.class, CimiEventTypeAccess.class));
        items.add(this.makeAssociate(AlarmEventType.class, CimiEventTypeAlarm.class));
        items.add(this.makeAssociate(ModelEventType.class, CimiEventTypeModel.class));
        items.add(this.makeAssociate(StateEventType.class, CimiEventTypeState.class));

        return items;
    }

    /**
     * Make Associate Item Config.
     * 
     * @param classToConfig The class to add to the config
     * @param classToAssociate The CIMI class to associate
     * @return A associate config item
     */
    protected ItemConfig makeAssociate(final Class<?> classToConfig, final Class<? extends CimiData> classToAssociate) {
        ItemConfig item = new ItemConfig(classToConfig);
        item.putData(ConfigFactory.ASSOCIATE_TO, classToAssociate);
        return item;
    }

    /**
     * Build the configuration for other classes.
     * 
     * @return A list of config items
     */
    protected List<ItemConfig> buildOtherItems() {
        ItemConfig item;
        List<ItemConfig> items = new ArrayList<ItemConfig>();

        item = new ItemConfig(CimiDiskConfiguration.class);
        item.putData(ConfigFactory.CONVERTER, new DiskConfigurationConverter());
        items.add(item);

        item = new ItemConfig(CimiMachineTemplateNetworkInterface.class);
        item.putData(ConfigFactory.CONVERTER, new MachineTemplateNetworkInterfaceConverter());
        items.add(item);

        item = new ItemConfig(CimiComponentDescriptor.class);
        item.putData(ConfigFactory.CONVERTER, new ComponentDescriptorConverter());
        items.add(item);

        item = new ItemConfig(CimiSummary.class);
        item.putData(ConfigFactory.CONVERTER, new SummaryConverter());
        items.add(item);

        // EventType
        item = new ItemConfig(CimiEventTypeAccess.class);
        item.putData(ConfigFactory.CONVERTER, new EventTypeAccessConverter());
        items.add(item);
        item = new ItemConfig(CimiEventTypeAlarm.class);
        item.putData(ConfigFactory.CONVERTER, new EventTypeAlarmConverter());
        items.add(item);
        item = new ItemConfig(CimiEventTypeModel.class);
        item.putData(ConfigFactory.CONVERTER, new EventTypeModelConverter());
        items.add(item);
        item = new ItemConfig(CimiEventTypeState.class);
        item.putData(ConfigFactory.CONVERTER, new EventTypeStateConverter());
        items.add(item);

        return items;
    }

}