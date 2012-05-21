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

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ow2.sirocco.apis.rest.cimi.domain.CimiCredentials;
import org.ow2.sirocco.apis.rest.cimi.domain.CimiCredentialsCreate;
import org.ow2.sirocco.apis.rest.cimi.domain.CimiCredentialsTemplate;
import org.ow2.sirocco.apis.rest.cimi.domain.CimiEntityType;
import org.ow2.sirocco.apis.rest.cimi.request.CimiContextImpl;
import org.ow2.sirocco.apis.rest.cimi.request.CimiRequest;
import org.ow2.sirocco.apis.rest.cimi.request.CimiResponse;
import org.ow2.sirocco.apis.rest.cimi.request.CimiSelect;
import org.ow2.sirocco.apis.rest.cimi.request.RequestHeader;
import org.ow2.sirocco.apis.rest.cimi.utils.Constants;
import org.ow2.sirocco.apis.rest.cimi.utils.ConstantsPath;
import org.ow2.sirocco.cloudmanager.core.api.ICredentialsManager;
import org.ow2.sirocco.cloudmanager.model.cimi.Credentials;
import org.ow2.sirocco.cloudmanager.model.cimi.CredentialsCreate;
import org.ow2.sirocco.cloudmanager.model.cimi.CredentialsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Basic tests "end to end" for managers Credentials.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context/managerContext.xml"})
public class CimiManagersCredentialsTest {

    @Autowired
    @Qualifier("ICredentialsManager")
    private ICredentialsManager service;

    @Autowired
    @Qualifier("CimiManagerCreateCredentials")
    private CimiManager managerCreate;

    @Autowired
    @Qualifier("CimiManagerDeleteCredentials")
    private CimiManager managerDelete;

    @Autowired
    @Qualifier("CimiManagerReadCredentials")
    private CimiManager managerRead;

    @Autowired
    @Qualifier("CimiManagerUpdateCredentials")
    private CimiManager managerUpdate;

    private CimiRequest request;

    private CimiResponse response;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.request = new CimiRequest();
        this.response = new CimiResponse();

        this.request.setBaseUri("/");
        this.request.setContext(new CimiContextImpl(this.request));
        RequestHeader header = new RequestHeader();
        header.setCimiSelect(new CimiSelect());
        this.request.setHeader(header);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        EasyMock.reset(this.service);
    }

    @Test
    public void testCreate() throws Exception {
        Credentials create = new Credentials();
        create.setId(456);

        EasyMock.expect(this.service.createCredentials(EasyMock.anyObject(CredentialsCreate.class))).andReturn(create);
        EasyMock.replay(this.service);

        CimiCredentialsTemplate template = new CimiCredentialsTemplate("user", "pass", new byte[1]);
        CimiCredentialsCreate cimi = new CimiCredentialsCreate();
        cimi.setCredentialsTemplate(template);
        this.request.setCimiData(cimi);
        this.managerCreate.execute(this.request, this.response);

        Assert.assertEquals(201, this.response.getStatus());
        Assert.assertNotNull(this.response.getHeaders());
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH + "/456", this.response.getHeaders().get(Constants.HEADER_LOCATION));
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH + "/456", ((CimiCredentials) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testCreateWithRef() throws Exception {
        CredentialsTemplate reference = new CredentialsTemplate();
        reference.setId(13);
        reference.setName("nameValue");
        reference.setPassword("passwordValue");

        Credentials create = new Credentials();
        create.setId(789);

        EasyMock.expect(this.service.getCredentialsTemplateById("13")).andReturn(reference);
        EasyMock.expect(this.service.createCredentials(EasyMock.anyObject(CredentialsCreate.class))).andReturn(create);
        EasyMock.replay(this.service);

        CimiCredentialsTemplate template = new CimiCredentialsTemplate(this.request.getBaseUri()
            + CimiEntityType.CredentialsTemplate.getPathType().getPathname() + "/13");
        CimiCredentialsCreate cimi = new CimiCredentialsCreate();
        cimi.setCredentialsTemplate(template);
        this.request.setCimiData(cimi);
        this.managerCreate.execute(this.request, this.response);

        Assert.assertEquals(201, this.response.getStatus());
        Assert.assertNotNull(this.response.getHeaders());
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH + "/789", this.response.getHeaders().get(Constants.HEADER_LOCATION));
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH + "/789", ((CimiCredentials) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testRead() throws Exception {
        Credentials machine = new Credentials();
        machine.setId(321);

        EasyMock.expect(this.service.getCredentialsById("321")).andReturn(machine);
        EasyMock.replay(this.service);

        this.request.setId("321");
        this.managerRead.execute(this.request, this.response);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.CREDENTIALS_PATH + "/321", ((CimiCredentials) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testDelete() throws Exception {

        this.service.deleteCredentials("1");
        EasyMock.replay(this.service);

        this.request.setId("1");
        this.managerDelete.execute(this.request, this.response);

        Assert.assertEquals(200, this.response.getStatus());
        EasyMock.verify(this.service);
    }

    @Test
    public void testUpdate() throws Exception {

        this.service.updateCredentials(EasyMock.anyObject(Credentials.class));
        EasyMock.replay(this.service);

        CimiCredentials cimi = new CimiCredentials();
        cimi.setName("foo");
        this.request.setId("1");
        this.request.setCimiData(cimi);

        this.managerUpdate.execute(this.request, this.response);

        Assert.assertEquals(200, this.response.getStatus());
        EasyMock.verify(this.service);
    }

    @Test
    public void testUpdateWithCimiSelect() throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "fooName");
        map.put("description", "fooDescription");

        this.service.updateCredentialsAttributes(EasyMock.eq("1"), EasyMock.eq(map));
        EasyMock.replay(this.service);

        CimiCredentials cimi = new CimiCredentials();
        cimi.setName("fooName");
        cimi.setDescription("fooDescription");
        this.request.setId("1");
        this.request.setCimiData(cimi);
        this.request.getHeader().getCimiSelect().setSelects(new String[] {"name", "description"});

        this.managerUpdate.execute(this.request, this.response);

        Assert.assertEquals(200, this.response.getStatus());
        EasyMock.verify(this.service);
    }

}
