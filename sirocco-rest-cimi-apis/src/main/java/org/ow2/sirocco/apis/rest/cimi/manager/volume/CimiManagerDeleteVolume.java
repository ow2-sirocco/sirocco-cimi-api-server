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
package org.ow2.sirocco.apis.rest.cimi.manager.volume;

import org.ow2.sirocco.apis.rest.cimi.manager.CimiManagerDeleteAbstract;
import org.ow2.sirocco.apis.rest.cimi.request.CimiContext;
import org.ow2.sirocco.cloudmanager.core.api.IVolumeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Manage DELETE request of Volume.
 */
@Component("CimiManagerDeleteVolume")
public class CimiManagerDeleteVolume extends CimiManagerDeleteAbstract {

    @Autowired
    @Qualifier("IVolumeManager")
    private IVolumeManager manager;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.manager.CimiManagerAbstract#callService(org.ow2.sirocco.apis.rest.cimi.request.CimiContext,
     *      java.lang.Object)
     */
    @Override
    protected Object callService(final CimiContext context, final Object dataService) throws Exception {
        return this.manager.deleteVolume(context.getRequest().getId());
    }

    // /**
    // * Call after the conversion.
    // *
    // * @param request The CIMI request
    // * @param response The CIMI response
    // * @param dataService The output service data
    // */
    // @Override
    // protected void afterConvertToResponse(final CimiContext context, final
    // Object dataService) {
    // if (null == context.getResponse().getCimiData()) {
    // // Job
    // if (dataService instanceof Job) {
    // CimiJob cimi = (CimiJob) context.convertToCimi(dataService,
    // CimiJob.class);
    // context.getResponse().setCimiData(cimi);
    // context.getResponse().putHeader(Constants.HEADER_CIMI_JOB_URI,
    // cimi.getId());
    // context.getResponse().putHeader(Constants.HEADER_LOCATION,
    // cimi.getTargetResource());
    // context.getResponse().setStatus(Response.Status.ACCEPTED);
    // }
    // }
    // }
}