package com.web;

import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.resource.Representation;
import org.restlet.resource.Resource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.StringRepresentation;
import org.restlet.resource.Variant;

public class HtmlResource extends Resource {

	public HtmlResource(Context context, Request request, Response response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
		getVariants().add(new Variant(MediaType.TEXT_HTML));
	}

	/* (non-Javadoc)
	 * @see org.restlet.resource.Resource#represent(org.restlet.resource.Variant)
	 */
	@Override
	public Representation represent(Variant variant) throws ResourceException {
		
		return new StringRepresentation("<html><body><p>hello</p><form></form></body></html>", MediaType.TEXT_HTML);
		
		
	}



}
