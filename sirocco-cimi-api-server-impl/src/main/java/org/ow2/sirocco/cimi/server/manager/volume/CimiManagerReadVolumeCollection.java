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
package org.ow2.sirocco.cimi.server.manager.volume;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.ow2.sirocco.cimi.domain.collection.CimiVolumeCollectionRoot;
import org.ow2.sirocco.cimi.server.manager.CimiManagerReadAbstract;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cloudmanager.core.api.IVolumeManager;
import org.ow2.sirocco.cloudmanager.core.api.QueryResult;
import org.ow2.sirocco.cloudmanager.model.cimi.Volume;

/**
 * Manage READ request of Volumes collection.
 */
@org.ow2.sirocco.cimi.server.manager.Manager("CimiManagerReadVolumeCollection")
public class CimiManagerReadVolumeCollection extends CimiManagerReadAbstract {

    @Inject
    private IVolumeManager manager;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.manager.CimiManagerAbstract#callService(org.ow2.sirocco.cimi.server.request.CimiContext,
     *      java.lang.Object)
     */
    @Override
    protected Object callService(final CimiContext context, final Object dataService) throws Exception {
        Object out = null;
        if (false == context.hasParamsForReadingCollection()) {
            List<Volume> volumes = this.manager.getVolumes().getItems();
            for (Volume vol : volumes) {
                vol.setAttachments(this.manager.getVolumeAttachments(vol.getId().toString()));
            }
            out = volumes;
        } else {
            QueryResult<Volume> results = this.manager.getVolumes(context.valueOfFirst(), context.valueOfLast(),
                context.valuesOfFilter(), context.valuesOfSelect());
            for (Volume vol : results.getItems()) {
                vol.setAttachments(this.manager.getVolumeAttachments(vol.getId().toString()));
            }
            List<Volume> volumes = results.getItems();
            out = volumes;
        }
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
        CimiVolumeCollectionRoot cimi = (CimiVolumeCollectionRoot) context.convertToCimi(dataService,
            CimiVolumeCollectionRoot.class);
        context.getResponse().setCimiData(cimi);
        context.getResponse().setStatus(Response.Status.OK);
    }
}
