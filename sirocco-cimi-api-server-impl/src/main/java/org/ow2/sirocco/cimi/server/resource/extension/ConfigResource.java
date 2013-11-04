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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 *
 */
package org.ow2.sirocco.cimi.server.resource.extension;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.ow2.sirocco.cimi.server.resource.ResourceInterceptorBinding;
import org.ow2.sirocco.cimi.server.resource.RestResourceAbstract;
import org.ow2.sirocco.cloudmanager.core.api.IConfigManager;

@ResourceInterceptorBinding
@RequestScoped
@Path("/config")
public class ConfigResource extends RestResourceAbstract {
    @EJB
    private IConfigManager configManager;

    @PUT
    public Response setConfigParameter(@QueryParam("key") final String key, @QueryParam("value") final String value) {
        this.configManager.setConfigParameter(key, value);
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
