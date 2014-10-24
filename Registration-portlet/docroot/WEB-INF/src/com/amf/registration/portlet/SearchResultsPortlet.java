/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.amf.registration.portlet;

import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ProcessEvent;

/**
 * Portlet implementation class ShowAMFSearchPortlet
 */
public class SearchResultsPortlet extends MVCPortlet {

	@ProcessEvent(qname="{http://amf.com/searchUser}zip")
	public void arrivalDestination(
		EventRequest request, EventResponse response) {

		Event event = request.getEvent();

		String zip = (String)event.getValue();

		response.setRenderParameter("zip", zip);
	}

}