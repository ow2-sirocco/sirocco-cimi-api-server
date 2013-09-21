package org.ow2.sirocco.cimi.server.resource;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.HttpHeaders;

import org.ow2.sirocco.cimi.server.request.RequestHelper;
import org.ow2.sirocco.cloudmanager.core.api.IdentityContext;

@Interceptor
@ResourceInterceptorBinding
public class IdentityInterceptor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    IdentityContext identityContext;

    @AroundInvoke
    public Object retrieveUserNameAndTenantId(final InvocationContext ctx) throws Exception {
        if (ctx.getTarget() instanceof RestResourceAbstract) {
            RestResourceAbstract resourceBase = (RestResourceAbstract) ctx.getTarget();
            HttpHeaders headers = resourceBase.getHeaders();
            List<String> values = headers.getRequestHeader("tenantId");
            if (values != null && !values.isEmpty()) {
                this.identityContext.setTenantId(values.get(0));
            }
            values = headers.getRequestHeader("Authorization");
            if (values != null && !values.isEmpty()) {
                String userPassword[] = RequestHelper.decode(values.get(0));
                this.identityContext.setUserName(userPassword[0]);
            }

        }
        return ctx.proceed();
    }

}