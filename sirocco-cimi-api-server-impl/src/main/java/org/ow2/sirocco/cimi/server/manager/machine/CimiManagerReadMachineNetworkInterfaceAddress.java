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
package org.ow2.sirocco.cimi.server.manager.machine;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.ow2.sirocco.cimi.domain.CimiMachineNetworkInterfaceAddress;
import org.ow2.sirocco.cimi.server.manager.CimiManagerReadAbstract;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cimi.server.request.IdRequest;
import org.ow2.sirocco.cloudmanager.core.api.IMachineManager;
import org.ow2.sirocco.cloudmanager.core.api.QueryResult;
import org.ow2.sirocco.cloudmanager.core.api.exception.ResourceNotFoundException;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineNetworkInterfaceAddress;

/**
 * Manage READ request of Address of a NetworkInterface of a Machine.
 */
@org.ow2.sirocco.cimi.server.manager.Manager("CimiManagerReadMachineNetworkInterfaceAddress")
public class CimiManagerReadMachineNetworkInterfaceAddress extends CimiManagerReadAbstract {

    @Inject
    private IMachineManager manager;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.cimi.server.manager.CimiManagerAbstract#callService(org.ow2.sirocco.cimi.server.request.CimiContext,
     *      java.lang.Object)
     */
    @Override
    protected Object callService(final CimiContext context, final Object dataService) throws Exception {
        MachineNetworkInterfaceAddress out = null;
        QueryResult<MachineNetworkInterfaceAddress> results = this.manager.getMachineNetworkInterfaceAddresses(context
            .getRequest().getIds().getId(IdRequest.Type.RESOURCE_GRAND_PARENT), context.getRequest().getIdParent());
        if (null != results.getItems()) {
            Integer id = Integer.valueOf(context.getRequest().getId());
            for (MachineNetworkInterfaceAddress item : results.getItems()) {
                if (id == item.getId()) {
                    out = item;
                    break;
                }
            }
            if (null == out) {
                throw new ResourceNotFoundException();
            }
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
        CimiMachineNetworkInterfaceAddress cimi = (CimiMachineNetworkInterfaceAddress) context.convertToCimi(dataService,
            CimiMachineNetworkInterfaceAddress.class);
        context.getResponse().setCimiData(cimi);
        context.getResponse().setStatus(Response.Status.OK);
    }

}
