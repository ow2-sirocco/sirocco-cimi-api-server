/**
 *
 * SIROCCO
 * Copyright (C) 2013 France Telecom
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
 *
 */
package org.ow2.sirocco.cimi.server.converter;

import org.ow2.sirocco.cimi.domain.ProviderInfo;
import org.ow2.sirocco.cloudmanager.model.cimi.extension.ICloudProviderResource;
import org.ow2.sirocco.cloudmanager.model.cimi.extension.IMultiCloudResource;
import org.ow2.sirocco.cloudmanager.model.cimi.extension.ProviderMapping;

public class ProviderInfoConverter {
    public static ProviderInfo convert(final ICloudProviderResource providerResource) {
        if (providerResource.getCloudProviderAccount() == null) {
            return null;
        }
        ProviderInfo providerInfo = new ProviderInfo();
        providerInfo.setProviderAccountId(providerResource.getCloudProviderAccount().getId().toString());
        providerInfo.setProviderName(providerResource.getCloudProviderAccount().getCloudProvider().getDescription());
        if (providerResource.getLocation() != null) {
            providerInfo.setLocation(providerResource.getLocation().getCountryName());
        }
        providerInfo.setProviderAssignedId(providerResource.getProviderAssignedId());
        return providerInfo;
    }

    public static ProviderInfo[] convert(final IMultiCloudResource providerResource) {
        if (providerResource.getProviderMappings() == null) {
            return null;
        }
        ProviderInfo[] result = new ProviderInfo[providerResource.getProviderMappings().size()];
        int i = 0;
        for (ProviderMapping mapping : providerResource.getProviderMappings()) {
            ProviderInfo info = new ProviderInfo();
            info.setProviderAccountId(mapping.getProviderAccount().getId().toString());
            if (mapping.getProviderLocation() != null) {
                info.setLocation(mapping.getProviderLocation().getCountryName());
            }
            info.setProviderName(mapping.getProviderAccount().getCloudProvider().getDescription());
            info.setProviderAssignedId(mapping.getProviderAssignedId());
            result[i++] = info;
        }
        return result;
    }

}
