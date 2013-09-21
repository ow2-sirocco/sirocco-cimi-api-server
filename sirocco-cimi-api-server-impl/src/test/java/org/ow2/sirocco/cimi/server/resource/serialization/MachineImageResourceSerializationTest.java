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
package org.ow2.sirocco.cimi.server.resource.serialization;

import java.io.StringReader;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import junit.framework.Assert;
import net.javacrumbs.jsonunit.JsonAssert;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Ignore;
import org.junit.Test;
import org.ow2.sirocco.cimi.server.request.CimiStringParams;
import org.ow2.sirocco.cimi.server.resource.serialization.json.JsonLocator;
import org.ow2.sirocco.cimi.server.resource.serialization.xml.XmlLocator;
import org.ow2.sirocco.cimi.server.utils.Constants;
import org.ow2.sirocco.cimi.server.utils.ConstantsPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore
public class MachineImageResourceSerializationTest extends SerializationTestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MachineImageResourceSerializationTest.class);

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageJson() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE + "/0").request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get();
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImage-0.json"),
            new StringReader(entityResponse));

        // JSON : id = 1
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE + "/1").request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get();
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImage-1.json"),
            new StringReader(entityResponse));

        // JSON : id = 2
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE + "/2").request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImage-2.json"),
            new StringReader(entityResponse));
    }

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageXml() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE + "/0").request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get();
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImage-0.xml"),
            new StringReader(entityResponse));

        // XML : id = 1
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE + "/1").request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get();
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImage-1.xml"),
            new StringReader(entityResponse));

        // XML : id = 2
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE + "/2").request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImage-2.xml"),
            new StringReader(entityResponse));
    }

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageCollectionJson() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE).request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 0).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-0.json"), new StringReader(
                entityResponse));

        // JSON : id = 1
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE).request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 1).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-1.json"), new StringReader(
                entityResponse));

        // JSON : id = 3
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE).request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-3.json"), new StringReader(
                entityResponse));

        // JSON : id = 3, expand
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE)
            .queryParam(Constants.PARAM_CIMI_EXPAND, CimiStringParams.ALL).request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).get();

        // clientResponse =
        // this.target().path(ConstantsPath.MACHINE_IMAGE).request(MediaType.APPLICATION_JSON_TYPE)
        // .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
        // .header(Constants.HEADER_SIROCCO_INFO_TEST_ID,
        // 3).header(Constants.HEADER_SIROCCO_INFO_TEST_EXPAND, true)
        // .get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-3-expand.json"),
            new StringReader(entityResponse));
    }

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageCollectionXml() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE).request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 0).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImageCollection-0.xml"),
            new StringReader(entityResponse));

        // XML : id = 1
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE).request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 1).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImageCollection-1.xml"),
            new StringReader(entityResponse));

        // XML : id = 3
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE).request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImageCollection-3.xml"),
            new StringReader(entityResponse));

        // XML : id = 3, expand
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE)
            .queryParam(Constants.PARAM_CIMI_EXPAND, CimiStringParams.ALL).request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).get();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class,
            "MachineImageCollection-3-expand.xml"), new StringReader(entityResponse));
    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageJson() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-0.json"),
                    MediaType.APPLICATION_JSON));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "Job-0.json"), new StringReader(
            entityResponse));

        // JSON : id = 1
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/1")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-1.json"),
                    MediaType.APPLICATION_JSON));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "Job-1.json"), new StringReader(
            entityResponse));

        // JSON : id = 2
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/2")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-2.json"),
                    MediaType.APPLICATION_JSON));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "Job-2.json"), new StringReader(
            entityResponse));

    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageJsonMalformed() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-0_malformed.json"),
                    MediaType.APPLICATION_JSON));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(500, statusResponse);
    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageXml() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-0.xml"),
                    MediaType.APPLICATION_XML));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "Job-0.xml"), new StringReader(
            entityResponse));

        // XML : id = 1
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/1")
            .request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-1.xml"),
                    MediaType.APPLICATION_XML));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "Job-1.xml"), new StringReader(
            entityResponse));

        // XML : id = 2
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/2")
            .request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-2.xml"),
                    MediaType.APPLICATION_XML));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "Job-2.xml"), new StringReader(
            entityResponse));

    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageXmlMalformed() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .put(
                Entity.entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-0_malformed.xml"),
                    MediaType.APPLICATION_XML));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(400, statusResponse);
    }

    /**
     * Test POST.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPostMachineImageJson() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;
        MultivaluedMap<String, String> heardersResponse;

        // JSON : id = 1
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .post(
                Entity.entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-1.json"),
                    MediaType.APPLICATION_JSON));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);
        heardersResponse = clientResponse.getStringHeaders();

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", heardersResponse);

        Assert.assertEquals(202, statusResponse);

        Assert.assertTrue(heardersResponse.containsKey(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertTrue(heardersResponse.get(Constants.HEADER_CIMI_JOB_URI).get(0).endsWith("idValue_1"));

        Assert.assertTrue(heardersResponse.containsKey(Constants.HEADER_LOCATION));
        Assert.assertTrue(heardersResponse.get(Constants.HEADER_LOCATION).get(0)
            .endsWith(ConstantsPath.MACHINE_IMAGE + "/" + "targetResourceValue_1"));

        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "Job-1.json"), new StringReader(
            entityResponse));
    }

    /**
     * Test POST.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPostMachineImageXml() throws Exception {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;
        MultivaluedMap<String, String> heardersResponse;

        // XML : id = 1
        clientResponse = this
            .target()
            .path(ConstantsPath.MACHINE_IMAGE)
            .request(MediaType.APPLICATION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .post(
                Entity.entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-1.xml"),
                    MediaType.APPLICATION_XML));

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);
        heardersResponse = clientResponse.getStringHeaders();

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", heardersResponse);

        Assert.assertEquals(202, statusResponse);
        System.out.println(heardersResponse.get(Constants.HEADER_CIMI_JOB_URI));
        System.out.println(heardersResponse.get(Constants.HEADER_LOCATION));

        Assert.assertTrue(heardersResponse.containsKey(Constants.HEADER_CIMI_JOB_URI));
        Assert.assertTrue(heardersResponse.get(Constants.HEADER_CIMI_JOB_URI).get(0).endsWith("idValue_1"));

        Assert.assertTrue(heardersResponse.containsKey(Constants.HEADER_LOCATION));
        Assert.assertTrue(heardersResponse.get(Constants.HEADER_LOCATION).get(0)
            .endsWith(ConstantsPath.MACHINE_IMAGE + "/" + "targetResourceValue_1"));

        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "Job-1.xml"), new StringReader(
            entityResponse));
    }

    @Test
    public final void testDeleteMachineImage() {
        Response clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON and XML : id = 0
        clientResponse = this.target().path(ConstantsPath.MACHINE_IMAGE + "/0").request()
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).delete();

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.readEntity(String.class);

        MachineImageResourceSerializationTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("STATUS: {}", statusResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        MachineImageResourceSerializationTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getStringHeaders());

        Assert.assertEquals(200, statusResponse);
    }

}
