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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.easymock.EasyMock;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ow2.sirocco.cimi.domain.collection.CimiJobCollection;
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
import org.ow2.sirocco.cimi.server.manager.machine.CimiManagerUpdateMachine;
import org.ow2.sirocco.cimi.server.request.CimiContext;
import org.ow2.sirocco.cimi.server.request.CimiContextImpl;
import org.ow2.sirocco.cimi.server.request.CimiExpand;
import org.ow2.sirocco.cimi.server.request.CimiFilter;
import org.ow2.sirocco.cimi.server.request.CimiIntegerParam;
import org.ow2.sirocco.cimi.server.request.CimiRequest;
import org.ow2.sirocco.cimi.server.request.CimiResponse;
import org.ow2.sirocco.cimi.server.request.CimiSelect;
import org.ow2.sirocco.cimi.server.request.RequestParams;
import org.ow2.sirocco.cimi.server.test.util.ManagerProducers;
import org.ow2.sirocco.cimi.server.utils.ConstantsPath;
import org.ow2.sirocco.cloudmanager.core.api.IJobManager;
import org.ow2.sirocco.cloudmanager.core.api.QueryResult;
import org.ow2.sirocco.cloudmanager.model.cimi.Job;

/**
 * Basic tests "end to end" for managers JobCollection.
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({ManagerProducers.class, CimiManagerActionMachine.class, CimiManagerReadMachine.class,
    CimiManagerUpdateMachine.class, CimiManagerDeleteMachine.class, CimiManagerCreateMachine.class,
    CimiManagerReadCloudEntryPoint.class, CimiManagerReadCredentialCollection.class,
    CimiManagerReadCredentialTemplateCollection.class, CimiManagerCreateCredentialTemplate.class,
    CimiManagerDeleteCredentialTemplate.class, CimiManagerReadCredentialTemplate.class,
    CimiManagerUpdateCredentialTemplate.class, CimiManagerCreateCredential.class, CimiManagerDeleteCredential.class,
    CimiManagerReadCredential.class, CimiManagerUpdateCredential.class, CimiManagerReadJobCollection.class,
    CallServiceHelperImpl.class, MergeReferenceHelperImpl.class})
public class CimiManagersJobCollectionTest {

    @Inject
    private IJobManager service;

    @Inject
    @Manager("CimiManagerReadJobCollection")
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
        RequestParams params = new RequestParams();
        params.setCimiSelect(new CimiSelect());
        params.setCimiExpand(new CimiExpand());
        params.setCimiFilter(new CimiFilter());
        params.setCimiFirst(new CimiIntegerParam());
        params.setCimiLast(new CimiIntegerParam());
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
    }

    @Test
    public void testRead() throws Exception {
        Job item;

        List<Job> list = new ArrayList<Job>();
        for (int i = 0; i < 3; i++) {
            item = new Job();
            item.setId(i + 13);
            list.add(item);
        }
        QueryResult<Job> jobQueryResult = new QueryResult<Job>(list.size(), list);
        EasyMock.expect(this.service.getJobs()).andReturn(jobQueryResult);
        EasyMock.replay(this.service);

        this.manager.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH, ((CimiJobCollection) this.response.getCimiData()).getId());
        CimiJobCollection cimiCollect = (CimiJobCollection) this.response.getCimiData();
        Assert.assertNotNull(cimiCollect.getArray());
        Assert.assertEquals(3, cimiCollect.getArray().length);
        for (int i = 0; i < cimiCollect.getArray().length; i++) {
            Assert.assertEquals(ConstantsPath.JOB_PATH + "/" + (i + 13), cimiCollect.getArray()[i].getId());
        }
        EasyMock.verify(this.service);
    }

    @Test
    public void testReadWithFirstLastFilterSelect() throws Exception {
        QueryResult<Job> results = new QueryResult<Job>(0, new ArrayList<Job>());
        EasyMock.expect(
            this.service.getJobs(EasyMock.eq(9), EasyMock.eq(99),
                EasyMock.eq(Arrays.asList(new String[] {"filterOne", "filterTwo"})),
                EasyMock.eq(Arrays.asList(new String[] {"selectOne", "selectTwo"})))).andReturn(results);
        EasyMock.replay(this.service);

        this.request.getParams().getCimiFirst().setInitialValue("10");
        this.request.getParams().getCimiLast().setInitialValue("100");
        this.request.getParams().getCimiFilter().setInitialValues(new String[] {"filterOne,filterTwo"});
        this.request.getParams().getCimiSelect().setInitialValues(new String[] {"selectOne, selectTwo"});
        this.manager.execute(this.context);

        Assert.assertEquals(200, this.response.getStatus());
        Assert.assertEquals(ConstantsPath.JOB_PATH, ((CimiJobCollection) this.response.getCimiData()).getId());

        EasyMock.verify(this.service);
    }
}
