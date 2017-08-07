package com.cdi.crud.infra.rest;


import com.cdi.crud.infra.exception.CustomException;
import com.cdi.crud.infra.security.CustomAuthorizer;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by rmpestano on 12/20/14.
 */
@RestSecured
@Interceptor
public class RestSecuredImpl implements Serializable{
	private static final long serialVersionUID = 0L;
	
    @Inject
    CustomAuthorizer authorizer;

    @Inject
    Instance<HttpServletRequest> request;


    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        String currentUser = request.get().getHeader("user");
         if( currentUser != null){
             authorizer.login(currentUser);
         } else{
             throw new CustomException("Access forbidden");
         }
        return context.proceed();
    }

}
