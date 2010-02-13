package com.web;

import java.util.Map;

import org.restlet.Client;
import org.restlet.Connector;
import org.restlet.Redirector;
import org.restlet.data.ChallengeRequest;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.CookieSetting;
import org.restlet.data.Form;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.resource.Representation;
import org.restlet.resource.Resource;
import org.restlet.resource.ResourceException;
import org.restlet.util.WrapperRequest;
import org.restlet.util.WrapperResponse;

import com.noelios.restlet.authentication.AuthenticationHelper;

public class LoginResource extends Resource {

	@Override
	public void acceptRepresentation(Representation entity)
			throws ResourceException {
		
		Form form = new Form(entity);
		
		String userId = form.getFirstValue("userId");
		String password = form.getFirstValue("password");
		
		getResponse().getCookieSettings().add(new CookieSetting("userId", userId));
		getResponse().getCookieSettings().add(new CookieSetting("password", password));

		getRequest().setChallengeResponse(new ChallengeResponse(ChallengeScheme.HTTP_BASIC, userId, password));
		getResponse().redirectSeeOther("hello");
		
	}

	@Override
	public boolean isModifiable() {
		return true;
	}
	
	

}
