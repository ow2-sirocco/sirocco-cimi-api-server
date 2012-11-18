/**
 *
 * SIROCCO
 * Copyright (C) 2012 France Telecom
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
 */
package org.ow2.sirocco.apis.rest.cimi.manager.resourcemetadata;

import java.util.Arrays;
import java.util.List;

import org.ow2.sirocco.apis.rest.cimi.domain.CimiResourceMetadata;
import org.ow2.sirocco.apis.rest.cimi.domain.CimiResourceMetadata.AttributeMetadata;
import org.ow2.sirocco.apis.rest.cimi.domain.ExchangeType;
import org.ow2.sirocco.cloudmanager.core.api.QueryResult;
import org.ow2.sirocco.cloudmanager.core.api.exception.CloudProviderException;
import org.ow2.sirocco.cloudmanager.core.api.exception.InvalidRequestException;
import org.ow2.sirocco.cloudmanager.core.api.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component("IResourceMetadataManager")
public class ResourceMetadataManager implements IResourceMetadataManager {
    static CimiResourceMetadata credentialMetada;

    static CimiResourceMetadata credentialTemplateMetadata;
    static {
        ResourceMetadataManager.credentialMetada = new CimiResourceMetadata();
        ResourceMetadataManager.credentialMetada.setId("credential");
        ResourceMetadataManager.credentialMetada.setName("Credential");
        ResourceMetadataManager.credentialMetada.setResourceURI(ResourceMetadataManager.credentialMetada.getExchangeType()
            .getResourceURI());
        ResourceMetadataManager.credentialMetada.setTypeURI(ExchangeType.Credential.getResourceURI());
        AttributeMetadata[] attributes = new AttributeMetadata[3];
        AttributeMetadata metadata = new AttributeMetadata();
        metadata.setName("username");
        metadata.setRequired(false);
        metadata.setType("string");
        attributes[0] = metadata;
        metadata = new AttributeMetadata();
        metadata.setName("password");
        metadata.setRequired(false);
        metadata.setType("string");
        attributes[1] = metadata;
        metadata = new AttributeMetadata();
        metadata.setName("key");
        metadata.setRequired(false);
        metadata.setType("string");
        attributes[2] = metadata;
        ResourceMetadataManager.credentialMetada.setAttributes(attributes);

        ResourceMetadataManager.credentialTemplateMetadata = new CimiResourceMetadata();
        ResourceMetadataManager.credentialTemplateMetadata.setId("credentialTemplate");
        ResourceMetadataManager.credentialTemplateMetadata.setName("CredentialTemplate");
        ResourceMetadataManager.credentialTemplateMetadata.setResourceURI(ResourceMetadataManager.credentialTemplateMetadata
            .getExchangeType().getResourceURI());
        ResourceMetadataManager.credentialTemplateMetadata.setTypeURI(ExchangeType.CredentialTemplate.getResourceURI());
        attributes = new AttributeMetadata[3];
        metadata = new AttributeMetadata();
        metadata.setName("username");
        metadata.setRequired(false);
        metadata.setType("string");
        attributes[0] = metadata;
        metadata = new AttributeMetadata();
        metadata.setName("password");
        metadata.setRequired(false);
        metadata.setType("string");
        attributes[1] = metadata;
        metadata = new AttributeMetadata();
        metadata.setName("key");
        metadata.setRequired(false);
        metadata.setType("string");
        attributes[2] = metadata;
        ResourceMetadataManager.credentialTemplateMetadata.setAttributes(attributes);
    }

    @Override
    public CimiResourceMetadata getResourceMetadataById(final String id) throws ResourceNotFoundException,
        CloudProviderException {
        if ("credential".equals(id)) {
            return ResourceMetadataManager.credentialMetada;
        } else if ("credentialTemplate".equals(id)) {
            return ResourceMetadataManager.credentialTemplateMetadata;
        }
        throw new ResourceNotFoundException();
    }

    @Override
    public CimiResourceMetadata getResourceMetadataAttributes(final String id, final List<String> attributes)
        throws ResourceNotFoundException, CloudProviderException {
        // TODO
        if ("credential".equals(id)) {
            return ResourceMetadataManager.credentialMetada;
        } else if ("credentialTemplate".equals(id)) {
            return ResourceMetadataManager.credentialTemplateMetadata;
        }
        throw new ResourceNotFoundException();
    }

    @Override
    public List<CimiResourceMetadata> getResourceMetadata() throws CloudProviderException {
        return Arrays.asList(ResourceMetadataManager.credentialMetada, ResourceMetadataManager.credentialTemplateMetadata);
    }

    @Override
    public QueryResult<CimiResourceMetadata> getResourceMetadata(final int first, final int last, final List<String> filters,
        final List<String> attributes) throws InvalidRequestException, CloudProviderException {
        // TODO
        return new QueryResult<CimiResourceMetadata>(1, this.getResourceMetadata());
    }

}
