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
package org.ow2.sirocco.cimi.server.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ow2.sirocco.cimi.domain.CimiComponentDescriptor;
import org.ow2.sirocco.cimi.domain.CimiSystemTemplate;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cloudmanager.model.cimi.extension.Visibility;
import org.ow2.sirocco.cloudmanager.model.cimi.system.ComponentDescriptor;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemTemplate;

/**
 * Convert the data of the CIMI model and the service model in both directions.
 * <p>
 * Converted classes:
 * <ul>
 * <li>CIMI model: {@link CimiSystemTemplate}</li>
 * <li>Service model: {@link SystemTemplate}</li>
 * </ul>
 * </p>
 */
public class SystemTemplateConverter extends ObjectCommonConverter {

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.converter.CimiConverter#toCimi(org.ow2.sirocco.cimi.server.utils.CimiContextImpl,
     *      java.lang.Object)
     */
    @Override
    public Object toCimi(final CimiContext context, final Object dataService) {
        CimiSystemTemplate cimi = new CimiSystemTemplate();
        this.copyToCimi(context, dataService, cimi);
        return cimi;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.converter.CimiConverter#copyToCimi(org.ow2.sirocco.cimi.server.utils.CimiContextImpl,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void copyToCimi(final CimiContext context, final Object dataService, final Object dataCimi) {
        this.doCopyToCimi(context, (SystemTemplate) dataService, (CimiSystemTemplate) dataCimi);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.converter.CimiConverter#toService(org.ow2.sirocco.cimi.server.utils.CimiContextImpl,
     *      java.lang.Object)
     */
    @Override
    public Object toService(final CimiContext context, final Object dataCimi) {
        SystemTemplate service = new SystemTemplate();
        this.copyToService(context, dataCimi, service);
        return service;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.converter.CimiConverter#copyToService
     *      (org.ow2.sirocco.cimi.server.utils.CimiContextImpl,
     *      java.lang.Object, java.lang.Object)
     */
    @Override
    public void copyToService(final CimiContext context, final Object dataCimi, final Object dataService) {
        this.doCopyToService(context, (CimiSystemTemplate) dataCimi, (SystemTemplate) dataService);
    }

    /**
     * Copy data from a service object to a CIMI object.
     * 
     * @param context The current context
     * @param dataService Source service object
     * @param dataCimi Destination CIMI object
     */
    protected void doCopyToCimi(final CimiContext context, final SystemTemplate dataService, final CimiSystemTemplate dataCimi) {
        this.fill(context, dataService, dataCimi);
        if (true == context.mustBeExpanded(dataCimi)) {
            // ComponentDescriptor
            if ((null != dataService.getComponentDescriptors()) && (dataService.getComponentDescriptors().size() > 0)) {
                List<CimiComponentDescriptor> listCimis = new ArrayList<CimiComponentDescriptor>();
                for (ComponentDescriptor itemService : dataService.getComponentDescriptors()) {
                    listCimis
                        .add((CimiComponentDescriptor) context.convertNextCimi(itemService, CimiComponentDescriptor.class));
                }
                dataCimi.setComponentDescriptors(listCimis.toArray(new CimiComponentDescriptor[listCimis.size()]));
            }
            dataCimi.setVisibility(dataService.getVisibility().toString());
            // FIXME EventLogTemplate
            // dataCimi.setEventLogTemplate((CimiEventLogTemplate)
            // context.convertNextCimi(dataService.getEventLogTemplate(),
            // CimiEventLogTemplate.class));
        }
    }

    /**
     * Copy data from a CIMI object to a service object.
     * 
     * @param context The current context
     * @param dataCimi Source CIMI object
     * @param dataService Destination Service object
     */
    protected void doCopyToService(final CimiContext context, final CimiSystemTemplate dataCimi,
        final SystemTemplate dataService) {
        this.fill(context, dataCimi, dataService);
        // ComponentDescriptor
        Set<ComponentDescriptor> listServices = new HashSet<ComponentDescriptor>();
        if ((null != dataCimi.getListComponentDescriptors()) && (dataCimi.getListComponentDescriptors().size() > 0)) {
            for (CimiComponentDescriptor itemCimi : dataCimi.getComponentDescriptors()) {
                listServices.add((ComponentDescriptor) context.convertNextService(itemCimi));
            }
        }
        dataService.setComponentDescriptors(listServices);
        if (dataCimi.getVisibility() != null) {
            dataService.setVisibility(Visibility.valueOf(dataCimi.getVisibility()));
        }
        // FIXME EventLogTemplate
        // dataService.setEventLogTemplate((EventLogTemplate)
        // context.convertNextService(dataCimi.getEventLogTemplate()));
    }

}
