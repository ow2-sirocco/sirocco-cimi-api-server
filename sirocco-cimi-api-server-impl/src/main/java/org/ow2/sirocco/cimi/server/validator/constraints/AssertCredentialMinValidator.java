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
package org.ow2.sirocco.cimi.server.validator.constraints;

import javax.validation.ConstraintValidatorContext;

import org.ow2.sirocco.cimi.server.domain.CimiCredential;
import org.ow2.sirocco.cimi.server.validator.CimiContextValidatorAbstract;

/**
 * Implementation of {@link AssertCredentialMin} validator.
 **/
public class AssertCredentialMinValidator extends CimiContextValidatorAbstract<AssertCredentialMin, Object> {

    @Override
    public void initialize(final AssertCredentialMin annotation) {
        // Nothing to do
    }

    /**
     * Credential valid : if UserName OR Password exists, the two field are not
     * null.
     * 
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
     *      javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext ctx) {
        boolean valid = true;
        if (value != null) {
            CimiCredential resource = (CimiCredential) value;

            String login = (String) resource.getExtensionAttributes().get("userName");
            String pass = (String) resource.getExtensionAttributes().get("password");

            if ((null != login) || (null != pass)) {
                valid = false;
                if ((null != login) && (null != pass)) {
                    valid = true;
                }
            }
        }
        return valid;
    }
}