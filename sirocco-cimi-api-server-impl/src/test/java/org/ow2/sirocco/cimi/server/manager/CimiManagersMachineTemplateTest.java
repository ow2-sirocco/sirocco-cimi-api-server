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
package org.ow2.sirocco.cimi.server.manager;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.easymock.EasyMock;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ow2.sirocco.cimi.domain.CimiMachineConfiguration;
import org.ow2.sirocco.cimi.domain.CimiMachineImage;
import org.ow2.sirocco.cimi.domain.CimiMachineTemplate;
import org.ow2.sirocco.cimi.domain.ExchangeType;
import org.ow2.sirocco.cimi.server.manager.cep.CimiManagerReadCloudEntryPoint;
import org.ow2.sirocco.cimi.server.manager.credentials.CimiManagerCreateCredential;
import org.ow2.sirocco.cimi.server.manager.credentials.CimiManagerDeleteCredential;
import org.ow2.sirocco.cimi.server.manager.credentials.CimiManagerReadCredential;
import org.ow2.sirocco.cimi.server.manager.credentials.CimiManagerReadCredentialCollection;
import org.ow2.sirocco.cimi.server.manager.credentials.CimiManagerUpdateCredential;
import org.ow2.sirocco.cimi.server.manager.credentials.template.CimiManagerCreateCredentialTemplate;
import org.ow2.sirocco.cimi.server.manager.credentials.template.CimiManagerDeleteCredentialTemplate;
import org.ow2.sirocco.cimi.server.manager.credentials.template.CimiManagerReadCredentialTemplate;
import org.ow2.sirocco.cimi.server.manager.credentials.template.CimiManagerReadCredentialTemplateCollection;
import org.ow2.sirocco.cimi.server.manager.credentials.template.CimiManagerUpdateCredentialTemplate;
import org.ow2.sirocco.cimi.server.manager.job.CimiManagerReadJobCollection;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerActionMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerCreateMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerDeleteMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerReadMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerReadMachineCollection;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerUpdateMachine;
import org.ow2.sirocco.cimi.server.manager.machine.configuration.CimiManagerCreateMachineConfiguration;
import org.ow2.sirocco.cimi.server.manager.machine.configuration.CimiManagerDeleteMachineConfiguration;
import org.ow2.sirocco.cimi.server.manager.machine.configuration.CimiManagerReadMachineConfiguration;
import org.ow2.sirocco.cimi.server.manager.machine.configuration.CimiManagerReadMachineConfigurationCollection;
import org.ow2.sirocco.cimi.server.manager.machine.configuration.CimiManagerUpdateMachineConfiguration;
import org.ow2.sirocco.cimi.server.manager.machine.image.CimiManagerCreateMachineImage;
import org.ow2.sirocco.cimi.server.manager.machine.image.CimiManagerDeleteMachineImage;
import org.ow2.sirocco.cimi.server.manager.machine.image.CimiManagerReadMachineImage;
import org.ow2.sirocco.cimi.server.manager.machine.image.CimiManagerReadMachineImageCollection;
import org.ow2.sirocco.cimi.server.manager.machine.image.CimiManagerUpdateMachineImage;
import org.ow2.sirocco.cimi.server.manager.machine.template.CimiManagerCreateMachineTemplate;
import org.ow2.sirocco.cimi.server.manager.machine.template.CimiManagerDeleteMachineTemplate;
import org.ow2.sirocco.cimi.server.manager.machine.template.CimiManagerReadMachineTemplate;
import org.ow2.sirocco.cimi.server.manager.machine.template.CimiManagerReadMachineTemplateCollection;
import org.ow2.sirocco.cimi.server.manager.machine.template.CimiManagerUpdateMachineTemplate;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cimi.server.request.CimiContextImpl;
import org.ow2.sirocco.cimi.server.request.CimiRequest;
import org.ow2.sirocco.cimi.server.request.CimiResponse;
import org.ow2.sirocco.cimi.server.request.CimiSelect;
import org.ow2.sirocco.cimi.server.request.IdRequest;
import org.ow2.sirocco.cimi.server.request.RequestParams;
import org.ow2.sirocco.cimi.server.test.util.ManagerProducers;
import org.ow2.sirocco.cimi.server.utils.Constants;
import org.ow2.sirocco.cimi.server.utils.ConstantsPath;
import org.ow2.sirocco.cloudmanager.core.api.IMachineManager;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineTemplate;

/**
 * Basic tests "end to end" for managers MachineTemplate.
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({ManagerProducers.class, CimiManagerActionMachine.class, CimiManagerReadMachine.class,
    CimiManagerUpdateMachine.class, CimiManagerDeleteMachine.class, CimiManagerCreateMachine.class,
    CimiManagerReadCloudEntryPoint.class, CimiManagerReadCredentialCollection.class,
    CimiManagerReadCredentialTemplateCollection.class, CimiManagerCreateCredentialTemplate.class,
    CimiManagerDeleteCredentialTemplate.class, CimiManagerReadCredentialTemplate.class,
    CimiManagerUpdateCredentialTemplate.class, CimiManagerCreateCredential.class, CimiManagerDeleteCredential.class,
    CimiManagerReadCredential.class, CimiManagerUpdateCredential.class, CimiManagerReadJobCollection.class,
    CimiManagerReadMachineCollection.class, CimiManagerReadMachineConfigurationCollection.class,
    CimiManagerCreateMachineConfiguration.class, CimiManagerDeleteMachineConfiguration.class,
    CimiManagerReadMachineConfiguration.class, CimiManagerUpdateMachineConfiguration.class,
    CimiManagerReadMachineImageCollection.class, CimiManagerCreateMachineImage.class, CimiManagerDeleteMachineImage.class,
    CimiManagerReadMachineImage.class, CimiManagerUpdateMachineImage.class, CimiManagerReadMachineTemplateCollection.class,
    CimiManagerCreateMachineTemplate.class, CimiManagerDeleteMachineTemplate.class, CimiManagerReadMachineTemplate.class,
    CimiManagerUpdateMachineTemplate.class, CallServiceHelperImpl.class, MergeReferenceHelperImpl.class})
public class CimiManagersMachineTemplateTest {

    @Inject
    private IMachineManager service;

    @Inject
    @Manager("CimiManagerCreateMachineTemplate")
    private CimiManager managerCreate;

    @Inject
    @Manager("CimiManagerDeleteMachineTemplate")
    private CimiManager managerDelete;

    @Inject
    @Manager("CimiManagerReadMachineTemplate")
    private CimiManager managerRead;

    @Inject
    @Manager("CimiManagerUpdateMachineTemplate")
    private CimiManager managerUpdate;

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
        RequestParams header = new RequestParams();
        header.setCimiSelect(new CimiSelect());
        this.request.setParams(header);

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
    public void testCreate() throws Exception {
        MachineTemplate create = new MachineTemplate();
        create.setUuid("789");

        EasyMock.expect(this.service.createMachineTemplate(EasyMock.anyObject(MachineTemplate.class))).andReturn(create);
        EasyMock.replay(this.service);

        CimiMachineTemplate cimi = new CimiMachineTemplate();
        cimi.setMachineConfig(new CimiMachineConfiguration(1, 2));
        CimiMachineImage cimiMachineImage = new CimiMachineImage();
        cimiMachineImage.setImageLocation("foo");
        cimi.setMachineImage(cimiMachineImage);
        this.request.setCimiData(cimi);
        this.managerCreate.execute(this.context);

        Assert.assertEquals(201, this.response.getStatus());
        Assert.assertNotNull(this.response.getHeaders());
        Assert.assertEquals(ConstantsPath.MACHINE_TEMPLATE_PATH + "/789",
            this.response.getHeaders().get(Constants.HEADER_LOCATION));
        Assert.assertEquals(ConstantsPath.MACHINE_TEMPLATE_PATH + "/789",
            ((CimiMachineTemplate) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testCreateWithRef() throws Exception {
        MachineTemplate reference = new MachineTemplate();
        reference.setUuid("13");
        reference.setName("nameValue");

        MachineTemplate create = new MachineTemplate();
        create.setUuid("789");

        EasyMock.expect(this.service.getMachineTemplateByUuid("13")).andReturn(reference);
        EasyMock.expect(this.service.createMachineTemplate(EasyMock.anyObject(MachineTemplate.class))).andReturn(create);
        EasyMock.replay(this.service);

        CimiMachineTemplate cimi = new CimiMachineTemplate(this.request.getBaseUri()
            + ExchangeType.MachineTemplate.getPathType().getPathname() + "/13");
        this.request.setCimiData(cimi);
        this.managerCreate.execute(this.context);

        Assert.assertEquals(201, this.response.getStatus());
        Assert.assertNotNull(this.response.getHeaders());
        Assert.assertEquals(ConstantsPath.MACHINE_TEMPLATE_PATH + "/789",
            this.response.getHeaders().get(Constants.HEADER_LOCATION));
        Assert.assertEquals(ConstantsPath.MACHINE_TEMPLATE_PATH + "/789",
            ((CimiMachineTemplate) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testRead() throws Exception {

        MachineTemplate machine = new MachineTemplate();
        machine.setUuid("1");
        EasyMock.expect(this.service.getMachineTemplateByUuid("1")).andReturn(machine);
        EasyMock.replay(this.service);

        this.request.setIds(new IdRequest("1"));
        this.managerRead.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.MACHINE_TEMPLATE_PATH + "/1",
            ((CimiMachineTemplate) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testDelete() throws Exception {

        this.service.deleteMachineTemplate("1");
        EasyMock.replay(this.service);

        this.request.setIds(new IdRequest("1"));
        this.managerDelete.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        EasyMock.verify(this.service);
    }

    @Test
    public void testUpdate() throws Exception {

        this.service.updateMachineTemplate(EasyMock.anyObject(MachineTemplate.class));
        EasyMock.replay(this.service);

        CimiMachineTemplate cimi = new CimiMachineTemplate();
        cimi.setName("foo");
        this.request.setIds(new IdRequest("1"));
        this.request.setCimiData(cimi);

        this.managerUpdate.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        EasyMock.verify(this.service);
    }

    @Test
    public void testUpdateWithCimiSelect() throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "fooName");
        map.put("description", "fooDescription");

        this.service.updateMachineTemplateAttributes(EasyMock.eq("1"), EasyMock.eq(map));
        EasyMock.replay(this.service);

        CimiMachineTemplate cimi = new CimiMachineTemplate();
        cimi.setName("fooName");
        cimi.setDescription("fooDescription");
        this.request.setIds(new IdRequest("1"));
        this.request.setCimiData(cimi);
        this.request.getParams().getCimiSelect().setInitialValues(new String[] {"name", "description"});

        this.managerUpdate.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        EasyMock.verify(this.service);
    }

}
