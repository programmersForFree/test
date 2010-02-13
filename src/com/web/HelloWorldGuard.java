package com.web;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Guard;
import org.restlet.Restlet;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.CookieSetting;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.resource.Resource;
import org.restlet.util.Resolver;
import org.restlet.util.WrapperRequest;


public class HelloWorldGuard extends Guard {

	public HelloWorldGuard(Context context, ChallengeScheme scheme, String realm)
			throws IllegalArgumentException {
		
		super(context, scheme, realm);
	}

	
	@Override
	public int authenticate(Request request) {
	
		String userId = request.getCookies().getFirstValue("userId");
		String password = request.getCookies().getFirstValue("password");
		
		if (request.getChallengeResponse() == null)
			request.setChallengeResponse(new ChallengeResponse(ChallengeScheme.HTTP_BASIC, userId, password));
		
		
		return super.authenticate(request);
		
		
	}

	/* (non-Javadoc)
	 * @see org.restlet.Guard#challenge(org.restlet.data.Response, boolean)
	 */
	@Override
	public void challenge(Response response, boolean stale) {
		response.redirectSeeOther("../index2.jsp");
	}




	
	
}