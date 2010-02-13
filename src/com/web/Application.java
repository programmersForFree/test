package com.web;

import org.restlet.Guard;
import org.restlet.Restlet;
import org.restlet.Router;
import org.restlet.data.ChallengeScheme;

public class Application extends org.restlet.Application {

	@Override
	public Restlet createRoot() {
		
		Router router = new Router(getContext());
	
		HelloWorldGuard guard = new HelloWorldGuard(getContext(), ChallengeScheme.HTTP_BASIC, "Authentication needed");
		guard.getSecrets().put("bruno", "test".toCharArray());
		guard.setNext(HelloWorldResource.class);
		router.attach("/hello", guard);
		router.attach("/Login", LoginResource.class);
		router.attach("/test", HtmlResource.class);
		return router;
		
		
	}
	
	

}
