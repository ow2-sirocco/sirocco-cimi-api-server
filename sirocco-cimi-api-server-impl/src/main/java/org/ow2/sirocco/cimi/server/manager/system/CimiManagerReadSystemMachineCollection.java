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
package org.ow2.sirocco.cimi.server.manager.system;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.ow2.sirocco.cimi.domain.collection.CimiSystemMachineCollectionRoot;
import org.ow2.sirocco.cimi.server.manager.CimiManagerReadAbstract;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cloudmanager.core.api.ISystemManager;
import org.ow2.sirocco.cloudmanager.core.api.QueryResult;
import org.ow2.sirocco.cloudmanager.model.cimi.system.SystemMachine;

/**
 * Manage READ request of Machines collection of a System.
 */
@org.ow2.sirocco.cimi.server.manager.Manager("CimiManagerReadSystemMachineCollection")
public class CimiManagerReadSystemMachineCollection extends CimiManagerReadAbstract {

    @Inject
    private ISystemManager manager;

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
            out = this.manager.getEntityListFromSystem(context.getRequest().getIdParent(), SystemMachine.class);
        } else {
            QueryResult<?> result = this.manager.getEntityListFromSystem(context.getRequest().getIdParent(),
                SystemMachine.class, context.valueOfFirst(), context.valueOfLast(), context.valuesOfFilter(),
                context.valuesOfSelect());
            out = result.getItems();
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
        CimiSystemMachineCollectionRoot cimi = (CimiSystemMachineCollectionRoot) context.convertToCimi(dataService,
            CimiSystemMachineCollectionRoot.class);
        context.getResponse().setCimiData(cimi);
        context.getResponse().setStatus(Response.Status.OK);
    }
}
