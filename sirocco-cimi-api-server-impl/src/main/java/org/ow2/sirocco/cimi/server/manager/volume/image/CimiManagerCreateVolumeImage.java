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
package org.ow2.sirocco.cimi.server.manager.volume.image;

import javax.inject.Inject;

import org.ow2.sirocco.cimi.domain.CimiVolume;
import org.ow2.sirocco.cimi.domain.CimiVolumeImage;
import org.ow2.sirocco.cimi.server.converter.PathHelper;
import org.ow2.sirocco.cimi.server.manager.CimiManagerCreateAbstract;
import org.ow2.sirocco.cimi.server.manager.MergeReferenceHelper;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cloudmanager.core.api.IVolumeManager;
import org.ow2.sirocco.cloudmanager.model.cimi.Volume;
import org.ow2.sirocco.cloudmanager.model.cimi.VolumeImage;

/**
 * Manage CREATE request of Volume Image.
 */
@org.ow2.sirocco.cimi.server.manager.Manager("CimiManagerCreateVolumeImage")
public class CimiManagerCreateVolumeImage extends CimiManagerCreateAbstract {

    @Inject
    private IVolumeManager manager;

    @Inject
    private MergeReferenceHelper mergeReference;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.manager.CimiManagerAbstract#callService(org.ow2.sirocco.cimi.server.request.CimiContext,
     *      java.lang.Object)
     */
    @Override
    protected Object callService(final CimiContext context, final Object dataService) throws Exception {
        Object out = null;
        String idVolumeSnapshot = null;
        VolumeImage image = (VolumeImage) dataService;
        // Extract ID Volume of imageLocation and verify it before using the
        // service to create with snapshot
        if (null != image.getImageLocation()) {
            idVolumeSnapshot = PathHelper.extractIdString(image.getImageLocation());
            if (false == image.getImageLocation().equals(context.makeHref(CimiVolume.class, idVolumeSnapshot))) {
                idVolumeSnapshot = null;
            }
        }
        // Call services
        if (null != idVolumeSnapshot) {
            Volume volume = this.manager.getVolumeByUuid(idVolumeSnapshot);
            out = this.manager.createVolumeSnapshot(volume, (VolumeImage) dataService);
        } else {
            out = this.manager.createVolumeImage((VolumeImage) dataService);
        }
        return out;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.manager.CimiManagerAbstract#beforeConvertToDataService(org.ow2.sirocco.cimi.server.request.CimiContext)
     */
    @Override
    protected void beforeConvertToDataService(final CimiContext context) throws Exception {
        this.mergeReference.merge(context, (CimiVolumeImage) context.getRequest().getCimiData());
    }
}
