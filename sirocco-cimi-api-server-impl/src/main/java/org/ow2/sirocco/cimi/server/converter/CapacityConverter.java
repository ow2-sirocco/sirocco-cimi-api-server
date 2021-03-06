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

import org.ow2.sirocco.cimi.domain.CimiCapacity;
import org.ow2.sirocco.cimi.domain.CimiDiskConfiguration;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cloudmanager.model.cimi.DiskTemplate;

/**
 * Convert the data of the CIMI model and the service model in both directions.
 * <p>
 * Converted classes:
 * <ul>
 * <li>CIMI model: {@link CimiCapacity}</li>
 * <li>Service model: {@link Disk} or {@link DiskTemplate}</li>
 * </ul>
 * </p>
 */
@Deprecated
public class CapacityConverter implements CimiConverter {
    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.converter.CimiConverter#toCimi(org.ow2.sirocco.cimi.server.utils.CimiContextImpl,
     *      java.lang.Object)
     */
    @Override
    public Object toCimi(final CimiContext context, final Object dataService) {
        CimiCapacity cimi = null;
        if (null != dataService) {
            cimi = new CimiCapacity();
            this.copyToCimi(context, dataService, cimi);
        }
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
        // if (dataService instanceof DiskTemplate) {
        // this.doCopyToCimi(context, (DiskTemplate) dataService, (CimiCapacity)
        // dataCimi);
        // } else {
        // this.doCopyToCimi(context, (Disk) dataService, (CimiCapacity)
        // dataCimi);
        // }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.converter.CimiConverter#toService(org.ow2.sirocco.cimi.server.utils.CimiContextImpl,
     *      java.lang.Object)
     */
    @Override
    public Object toService(final CimiContext context, final Object dataCimi) {
        Object service = null;
        if (null != dataCimi) {
            if (dataCimi instanceof CimiDiskConfiguration) {
                service = new DiskTemplate();
            } else {
                // service = new Disk();
            }
            this.copyToService(context, dataCimi, service);
        }
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
        // if (dataCimi instanceof CimiDiskConfiguration) {
        // this.doCopyToService(context, ((CimiDiskConfiguration)
        // dataCimi).getCapacity(), (DiskTemplate) dataService);
        // } else if (dataCimi instanceof CimiMachineDisk) {
        // this.doCopyToService(context, ((CimiMachineDisk)
        // dataCimi).getCapacity(), (Disk) dataService);
        // } else {
        // if (dataService instanceof DiskTemplate) {
        // this.doCopyToService(context, (CimiCapacity) dataCimi, (DiskTemplate)
        // dataService);
        // } else {
        // this.doCopyToService(context, (CimiCapacity) dataCimi, (Disk)
        // dataService);
        // }
        // }
    }

    /**
     * Copy data from a service object to a CIMI object.
     * 
     * @param context The current context
     * @param dataService Source service object
     * @param dataCimi Destination CIMI object
     */
    // protected void doCopyToCimi(final CimiContext context, final Disk
    // dataService, final CimiCapacity dataCimi) {
    // dataCimi.setQuantity(HelperConverter.toInteger(dataService.getQuantity()));
    // dataCimi.setUnits((String)
    // context.convertNextCimi(dataService.getUnits(), StorageUnit.class));
    // }

    /**
     * Copy data from a service object to a CIMI object.
     * 
     * @param context The current context
     * @param dataService Source service object
     * @param dataCimi Destination CIMI object
     */
    // protected void doCopyToCimi(final CimiContext context, final DiskTemplate
    // dataService, final CimiCapacity dataCimi) {
    // dataCimi.setQuantity(HelperConverter.toInteger(dataService.getQuantity()));
    // dataCimi.setUnits((String) context.convertNextCimi(dataService.getUnit(),
    // StorageUnit.class));
    // }

    /**
     * Copy data from a CIMI object to a service object.
     * 
     * @param context The current context
     * @param dataCimi Source CIMI object
     * @param dataService Destination Service object
     */
    // protected void doCopyToService(final CimiContext context, final
    // CimiCapacity dataCimi, final Disk dataService) {
    // dataService.setQuantity(HelperConverter.toFloat(dataCimi.getQuantity()));
    // dataService.setUnit((org.ow2.sirocco.cloudmanager.model.cimi.StorageUnit)
    // context.convertNextService(
    // dataCimi.getUnits(), StorageUnit.class));
    // }

    /**
     * Copy data from a CIMI object to a service object.
     * 
     * @param context The current context
     * @param dataCimi Source CIMI object
     * @param dataService Destination Service object
     */
    // protected void doCopyToService(final CimiContext context, final
    // CimiCapacity dataCimi, final DiskTemplate dataService) {
    // dataService.setQuantity(HelperConverter.toFloat(dataCimi.getQuantity()));
    // dataService.setUnit((org.ow2.sirocco.cloudmanager.model.cimi.StorageUnit)
    // context.convertNextService(
    // dataCimi.getUnits(), StorageUnit.class));
    // }
}
