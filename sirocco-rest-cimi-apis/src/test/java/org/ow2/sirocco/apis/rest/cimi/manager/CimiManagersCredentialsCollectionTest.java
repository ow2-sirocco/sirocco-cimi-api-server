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
package org.ow2.sirocco.apis.rest.cimi.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ow2.sirocco.apis.rest.cimi.domain.CimiCredentialsCollection;
import org.ow2.sirocco.apis.rest.cimi.request.CimiContext;
import org.ow2.sirocco.apis.rest.cimi.request.CimiContextImpl;
import org.ow2.sirocco.apis.rest.cimi.request.CimiExpand;
import org.ow2.sirocco.apis.rest.cimi.request.CimiRequest;
import org.ow2.sirocco.apis.rest.cimi.request.CimiResponse;
import org.ow2.sirocco.apis.rest.cimi.request.CimiSelect;
import org.ow2.sirocco.apis.rest.cimi.request.RequestHeader;
import org.ow2.sirocco.apis.rest.cimi.utils.ConstantsPath;
import org.ow2.sirocco.cloudmanager.core.api.ICredentialsManager;
import org.ow2.sirocco.cloudmanager.model.cimi.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Basic tests "end to end" for managers CredentialsCollection.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context/managerContext.xml"})
public class CimiManagersCredentialsCollectionTest {

    @Autowired
    @Qualifier("ICredentialsManager")
    private ICredentialsManager service;

    @Autowired
    @Qualifier("CimiManagerReadCredentialsCollection")
    private CimiManager manager;

    private CimiRequest request;

    private CimiResponse response;

    private CimiContext context;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        this.request = new CimiRequest();
        this.request.setBaseUri("/");
        RequestHeader header = new RequestHeader();
        header.setCimiSelect(new CimiSelect());
        header.setCimiExpand(new CimiExpand());
        this.request.setHeader(header);

        this.response = new CimiResponse();
        this.context = new CimiContextImpl(this.request, this.response);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        EasyMock.reset(this.service);
    }

    @Test
    public void testRead() throws Exception {
        Credentials item;
        List<Credentials> list = new ArrayList<Credentials>();
        for (int i = 0; i < 3; i++) {
            item = new Credentials();
            item.setId(i + 13);
            list.add(item);
        }

        EasyMock.expect(this.service.getCredentials()).andReturn(list);
        EasyMock.replay(this.service);

        this.manager.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH, ((CimiCredentialsCollection) this.response.getCimiData()).getId());
        CimiCredentialsCollection cimiCollect = (CimiCredentialsCollection) this.response.getCimiData();
        Assert.assertNotNull(cimiCollect.getArray());
        Assert.assertEquals(3, cimiCollect.getArray().length);
        for (int i = 0; i < cimiCollect.getArray().length; i++) {
            Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH + "/" + (i + 13), cimiCollect.getArray()[i].getHref());
        }
        EasyMock.verify(this.service);
    }

    @Test
    // FIXME Adapt to the last CIMI specification
    public void testReadWithCimiSelectAttributes() throws Exception {

        List<Credentials> list = new ArrayList<Credentials>();
        EasyMock.expect(
            this.service.getCredentials(EasyMock.eq(Arrays.asList(new String[] {"operations"})), EasyMock.eq((String) null)))
            .andReturn(list);
        EasyMock.replay(this.service);

        this.request.getHeader().getCimiSelect().setSelects(new String[] {"operations"});
        this.manager.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH, ((CimiCredentialsCollection) this.response.getCimiData()).getId());

        EasyMock.verify(this.service);
    }

    @Test
    // FIXME Adapt to the last CIMI specification
    public void testReadWithCimiSelectArrays() throws Exception {
        Credentials item;
        List<Credentials> list = new ArrayList<Credentials>();
        for (int i = 0; i < 23; i++) {
            item = new Credentials();
            item.setId(i + 13);
            list.add(item);
        }

        EasyMock.expect(
            this.service.getCredentials(EasyMock.eq(1), EasyMock.eq(23),
                EasyMock.eq(Arrays.asList(new String[] {"machineImages"})))).andReturn(list);
        EasyMock.replay(this.service);

        this.request.getHeader().getCimiSelect().setSelects(new String[] {"machineImages[1-23]"});
        this.manager.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH, ((CimiCredentialsCollection) this.response.getCimiData()).getId());
        CimiCredentialsCollection cimiCollect = (CimiCredentialsCollection) this.response.getCimiData();
        Assert.assertNotNull(cimiCollect.getArray());
        Assert.assertEquals(23, cimiCollect.getArray().length);
        for (int i = 0; i < cimiCollect.getArray().length; i++) {
            Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH + "/" + (i + 13), cimiCollect.getArray()[i].getHref());
        }
        EasyMock.verify(this.service);
    }
}