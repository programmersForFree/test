package com.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.restlet.Context;
import org.restlet.Redirector;
import org.restlet.data.Cookie;
import org.restlet.data.CookieSetting;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.resource.Representation;
import org.restlet.resource.Resource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.StringRepresentation;
import org.restlet.resource.Variant;

import com.noelios.restlet.ext.servlet.ServletCall;
import com.noelios.restlet.http.HttpCall;

public class HelloWorldResource extends Resource {
	
	public HelloWorldResource(Context context, Request request,
			Response response) {
		super(context, request, response);
		
		
		getVariants().add(new Variant(MediaType.TEXT_PLAIN));
	}


	
	@Override
	public Representation represent(Variant variant) throws ResourceException {
		
		String userIdCookie = getRequest().getCookies().getFirstValue("userId");
		String passwordCookie = getRequest().getCookies().getFirstValue("password");
		
		return new StringRepresentation("hello " + userIdCookie + " " + passwordCookie);
		
	}
	
	
	

}
