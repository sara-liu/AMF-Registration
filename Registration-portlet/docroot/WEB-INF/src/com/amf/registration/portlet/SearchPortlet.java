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

import com.liferay.portal.AddressZipException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.xml.namespace.QName;

/**
 * Portlet implementation class AMFSearchPortlet
 */
public class SearchPortlet extends MVCPortlet {

	public void searchUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws AddressZipException {

		String zip = ParamUtil.getString(actionRequest, "zip");

		if (!Validator.isDigit(zip) || (zip.length() != 5)) {
			throw new AddressZipException();
		}

		QName qName = new QName("http://amf.com/searchUser", "zip");

		actionResponse.setEvent(qName, zip);
	}

}