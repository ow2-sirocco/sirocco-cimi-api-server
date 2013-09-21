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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
import org.ow2.sirocco.cimi.domain.ActionType;
import org.ow2.sirocco.cimi.domain.CimiAction;
import org.ow2.sirocco.cimi.domain.CimiCredential;
import org.ow2.sirocco.cimi.domain.CimiMachine;
import org.ow2.sirocco.cimi.domain.CimiMachineConfiguration;
import org.ow2.sirocco.cimi.domain.CimiMachineCreate;
import org.ow2.sirocco.cimi.domain.CimiMachineImage;
import org.ow2.sirocco.cimi.domain.CimiMachineTemplate;
import org.ow2.sirocco.cimi.domain.ExchangeType;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerActionMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerCreateMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerDeleteMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerReadMachine;
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerUpdateMachine;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cimi.server.request.CimiContextImpl;
import org.ow2.sirocco.cimi.server.request.CimiExpand;
import org.ow2.sirocco.cimi.server.request.CimiRequest;
import org.ow2.sirocco.cimi.server.request.CimiResponse;
import org.ow2.sirocco.cimi.server.request.CimiSelect;
import org.ow2.sirocco.cimi.server.request.IdRequest;
import org.ow2.sirocco.cimi.server.request.RequestParams;
import org.ow2.sirocco.cimi.server.test.util.ManagerProducers;
import org.ow2.sirocco.cimi.server.utils.Constants;
import org.ow2.sirocco.cimi.server.utils.ConstantsPath;
import org.ow2.sirocco.cloudmanager.core.api.ICredentialsManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineImageManager;
import org.ow2.sirocco.cloudmanager.core.api.IMachineManager;
import org.ow2.sirocco.cloudmanager.model.cimi.CloudResource;
import org.ow2.sirocco.cloudmanager.model.cimi.Credentials;
import org.ow2.sirocco.cloudmanager.model.cimi.Job;
import org.ow2.sirocco.cloudmanager.model.cimi.Machine;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineConfiguration;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineCreate;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineImage;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineTemplate;

/**
 * Basic tests "end to end" for managers Machine.
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({ManagerProducers.class, CimiManagerActionMachine.class, CimiManagerReadMachine.class,
    CimiManagerUpdateMachine.class, CimiManagerDeleteMachine.class, CimiManagerCreateMachine.class,
    CallServiceHelperImpl.class, MergeReferenceHelperImpl.class})
public class CimiManagersMachineTest {

    @Inject
    private IMachineManager service;

    @Inject
    private IMachineImageManager serviceImage;

    @Inject
    private ICredentialsManager serviceCredentials;

    @Inject
    @Manager("CimiManagerActionMachine")
    private CimiManager managerAction;

    @Inject
    @Manager("CimiManagerCreateMachine")
    private CimiManager managerCreate;

    @Inject
    @Manager("CimiManagerDeleteMachine")
    private CimiManager managerDelete;

    @Inject
    @Manager("CimiManagerReadMachine")
    private CimiManager managerRead;

    @Inject
    @Manager("CimiManagerUpdateMachine")
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
        RequestParams params = new RequestParams();
        params.setCimiSelect(new CimiSelect());
        params.setCimiExpand(new CimiExpand());
        this.request.setParams(params);

        this.response = new CimiResponse();
        this.context = new CimiContextImpl(this.request, this.response);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        EasyMock.reset(this.service);
        EasyMock.reset(this.serviceCredentials);
        EasyMock.reset(this.serviceImage);
    }

    @Test
    public void testActionStart() throws Exception {
        Machine target = new Machine();
        target.setId(1789);

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAction("start");

        EasyMock.expect(this.service.startMachine("1", null)).andReturn(job);
        EasyMock.replay(this.service);

        CimiAction cimi = new CimiAction();
        cimi.setAction(ActionType.START.getPath());
        this.request.setIds(new IdRequest("1"));
        this.request.setCimiData(cimi);
        this.managerAction.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/1789", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

    @Test
    public void testActionStop() throws Exception {
        Machine target = new Machine();
        target.setId(7);

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAction("stop");

        EasyMock.expect(this.service.stopMachine("1", true, null)).andReturn(job);
        EasyMock.replay(this.service);

        CimiAction cimi = new CimiAction();
        cimi.setAction(ActionType.STOP.getPath());
        cimi.setForce(true);
        this.request.setIds(new IdRequest("1"));
        this.request.setCimiData(cimi);
        this.managerAction.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/7", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

    @Test
    public void testCreate() throws Exception {
        Machine target = new Machine();
        target.setId(789);

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAffectedResources(Collections.<CloudResource> singletonList(target));
        job.setAction("add");

        EasyMock.expect(this.service.createMachine(EasyMock.anyObject(MachineCreate.class))).andReturn(job);
        EasyMock.replay(this.service);

        CimiMachineTemplate template = new CimiMachineTemplate();
        template.setMachineConfig(new CimiMachineConfiguration(1, 2));
        CimiMachineImage cimiMachineImage = new CimiMachineImage();
        cimiMachineImage.setImageLocation("foo");
        template.setMachineImage(cimiMachineImage);
        CimiMachineCreate cimi = new CimiMachineCreate();
        cimi.setMachineTemplate(template);
        this.request.setCimiData(cimi);

        this.managerCreate.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/789", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

    @Test
    public void testCreateWithRef() throws Exception {
        Machine target = new Machine();
        target.setId(654);

        MachineTemplate reference = new MachineTemplate();
        reference.setId(13);
        reference.setName("nameValue");

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAffectedResources(Collections.<CloudResource> singletonList(target));
        job.setAction("add");

        EasyMock.expect(this.service.getMachineTemplateById("13")).andReturn(reference);
        EasyMock.expect(this.service.createMachine(EasyMock.anyObject(MachineCreate.class))).andReturn(job);
        EasyMock.replay(this.service);

        CimiMachineTemplate template = new CimiMachineTemplate(this.request.getBaseUri()
            + ExchangeType.MachineTemplate.getPathType().getPathname() + "/13");
        CimiMachineCreate cimi = new CimiMachineCreate();
        cimi.setMachineTemplate(template);
        this.request.setCimiData(cimi);

        this.managerCreate.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/654", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

    @Test
    public void testCreateWithTemplateByValueAndOtherByReference() throws Exception {
        MachineConfiguration refConf = new MachineConfiguration();
        refConf.setId(123);
        refConf.setName("machineConfiguration");
        MachineImage refImage = new MachineImage();
        refImage.setId(234);
        refImage.setName("machineImage");
        Credentials refCredentials = new Credentials();
        refCredentials.setId(345);
        refCredentials.setName("credentials");

        Machine target = new Machine();
        target.setId(654);

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAffectedResources(Collections.<CloudResource> singletonList(target));
        job.setAction("add");

        EasyMock.expect(this.serviceCredentials.getCredentialsById("345")).andReturn(refCredentials);
        EasyMock.replay(this.serviceCredentials);
        EasyMock.expect(this.serviceImage.getMachineImageById("234")).andReturn(refImage);
        EasyMock.replay(this.serviceImage);
        EasyMock.expect(this.service.getMachineConfigurationById("123")).andReturn(refConf);
        EasyMock.expect(this.service.createMachine(EasyMock.anyObject(MachineCreate.class))).andReturn(job);
        EasyMock.replay(this.service);

        CimiMachineTemplate template = new CimiMachineTemplate();
        template.setMachineConfig(new CimiMachineConfiguration(this.request.getBaseUri()
            + ExchangeType.MachineConfiguration.getPathType().getPathname() + "/123"));
        template.setMachineImage(new CimiMachineImage(this.request.getBaseUri()
            + ExchangeType.MachineImage.getPathType().getPathname() + "/234"));
        template.setCredential(new CimiCredential(this.request.getBaseUri()
            + ExchangeType.Credential.getPathType().getPathname() + "/345"));
        CimiMachineCreate cimi = new CimiMachineCreate();
        cimi.setMachineTemplate(template);
        this.request.setCimiData(cimi);

        this.managerCreate.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/654", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

    @Test
    public void testRead() throws Exception {
        Machine machine = new Machine();
        machine.setId(1);
        machine.setState(Machine.State.STARTED);

        EasyMock.expect(this.service.getMachineById("1")).andReturn(machine);
        EasyMock.replay(this.service);

        this.request.setIds(new IdRequest("1"));
        this.managerRead.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/1", ((CimiMachine) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testReadWithCimiSelect() throws Exception {
        List<String> list = Arrays.asList(new String[] {"name", "description"});
        Machine machine = new Machine();
        machine.setId(1);
        machine.setState(Machine.State.STARTED);

        EasyMock.expect(this.service.getMachineAttributes(EasyMock.eq("1"), EasyMock.eq(list))).andReturn(machine);
        EasyMock.replay(this.service);

        this.request.setIds(new IdRequest("1"));
        this.request.getParams().getCimiSelect().setInitialValues(new String[] {"name", "description"});
        this.managerRead.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/1", ((CimiMachine) this.response.getCimiData()).getId());
        EasyMock.verify(this.service);
    }

    @Test
    public void testDelete() throws Exception {
        Machine target = new Machine();
        target.setId(1789);

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAction("delete");

        EasyMock.expect(this.service.deleteMachine("1")).andReturn(job);
        EasyMock.replay(this.service);

        this.request.setIds(new IdRequest("1"));
        this.managerDelete.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/1789", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

    @Test
    public void testUpdate() throws Exception {
        Machine target = new Machine();
        target.setId(789);

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAction("edit");

        EasyMock.expect(this.service.updateMachine(EasyMock.anyObject(Machine.class))).andReturn(job);
        EasyMock.replay(this.service);

        CimiMachine cimi = new CimiMachine();
        cimi.setName("foo");
        this.request.setIds(new IdRequest("1"));
        this.request.setCimiData(cimi);

        this.managerUpdate.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/789", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

    @Test
    public void testUpdateWithCimiSelect() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "fooName");
        map.put("description", "fooDescription");

        Machine target = new Machine();
        target.setId(654);

        Job job = new Job();
        job.setId(123);
        job.setTargetResource(target);
        job.setAction("edit");

        EasyMock.expect(this.service.updateMachineAttributes(EasyMock.eq("1"), EasyMock.eq(map))).andReturn(job);
        EasyMock.replay(this.service);

        CimiMachine cimi = new CimiMachine();
        cimi.setName("fooName");
        cimi.setDescription("fooDescription");
        this.request.setIds(new IdRequest("1"));
        this.request.setCimiData(cimi);
        this.request.getParams().getCimiSelect().setInitialValues(new String[] {"name", "description"});

        this.managerUpdate.execute(this.context);

        Assert.assertEquals(202, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH + "/123", this.response.getHeaders().get(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertEquals(ConstantsPath.MACHINE_PATH + "/654", this.response.getHeaders().get("Location"));
        EasyMock.verify(this.service);
    }

}
