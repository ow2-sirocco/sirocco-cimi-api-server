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
package org.ow2.sirocco.apis.rest.cimi.converter;

import org.ow2.sirocco.apis.rest.cimi.domain.CimiResourceMetadata;
import org.ow2.sirocco.apis.rest.cimi.request.CimiContext;

/**
 * Convert the data of the CIMI model and the service model in both directions.
 * <p>
 * Converted classes:
 * <ul>
 * <li>CIMI model: {@link CimiResourceMetadata}</li>
 * <li>Service model: TODO</li>
 * </ul>
 * </p>
 */
public class ResourceMetadataConverter extends ObjectCommonConverter {

    @Override
    public Object toCimi(final CimiContext context, final Object dataService) {
        CimiResourceMetadata cimi = new CimiResourceMetadata();
        this.copyToCimi(context, dataService, cimi);
        return cimi;
    }

    @Override
    public void copyToCimi(final CimiContext context, final Object dataService, final Object dataCimi) {
        this.doCopyToCimi(context, (CimiResourceMetadata) dataService, (CimiResourceMetadata) dataCimi);
    }

    @Override
    public Object toService(final CimiContext context, final Object dataCimi) {
        CimiResourceMetadata service = new CimiResourceMetadata();
        this.copyToService(context, dataCimi, service);
        return service;
    }

    @Override
    public void copyToService(final CimiContext context, final Object dataCimi, final Object dataService) {
        this.doCopyToService(context, (CimiResourceMetadata) dataCimi, (CimiResourceMetadata) dataService);
    }

    protected void doCopyToCimi(final CimiContext context, final CimiResourceMetadata dataService,
        final CimiResourceMetadata dataCimi) {
        if (true == context.mustBeExpanded(dataCimi)) {
            dataCimi.setResourceURI(dataCimi.getExchangeType().getResourceURI());
            if (null != dataService.getId()) {
                dataCimi.setId(context.makeHref(dataCimi, dataService.getId().toString()));
            }
        }
        if (true == context.mustBeReferenced(dataCimi)) {
            dataCimi.setHref(context.makeHref(dataCimi, dataService.getId().toString()));
        }
        if (true == context.mustBeExpanded(dataCimi)) {
            dataCimi.setName(dataService.getName());
            dataCimi.setTypeURI(dataService.getTypeURI());
            dataCimi.setAttributes(dataService.getAttributes());
        }
    }

    protected void doCopyToService(final CimiContext context, final CimiResourceMetadata dataCimi,
        final CimiResourceMetadata dataService) {
    }

}
