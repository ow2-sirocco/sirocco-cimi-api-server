================================
Sirocco DMTF CIMI Implementation
================================

This module belongs to the Web tier of the Sirocco multi-cloud manager.
It contains the implementation of the DMTF CIMI 1.0 API that acts as the unified IaaS API of Sirocco.
This Web module implements all the REST machinery of the DMTF CIMI API and interacts with the business tier
of Sirocco through an internal EJB business api.

Building this module
====================

mvn clean install

Notes
=====
This Web module targets the GlassFish 4.0 container with Jersey 2 and CDI 1.1.

To workaround a bug of GlassFish 4.0 (https://java.net/jira/browse/GLASSFISH-20597), 
it is necessary to download the jersey-gf-cdi from maven central and replace this module in glassfish4/glassfish/modules:

http://repo1.maven.org/maven2/org/glassfish/jersey/containers/glassfish/jersey-gf-cdi/2.0/jersey-gf-cdi-2.0.jar





