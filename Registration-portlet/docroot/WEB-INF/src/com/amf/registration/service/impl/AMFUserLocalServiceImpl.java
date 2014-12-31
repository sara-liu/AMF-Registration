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

package com.amf.registration.service.impl;

import com.amf.registration.service.base.AMFUserLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import java.util.List;

/**
 * The implementation of the a m f user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.amf.registration.service.AMFUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sara Liu
 * @see com.amf.registration.service.base.AMFUserLocalServiceBaseImpl
 * @see com.amf.registration.service.AMFUserLocalServiceUtil
 */
public class AMFUserLocalServiceImpl extends AMFUserLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.amf.registration.service.AMFUserLocalServiceUtil} to access the a m f user local service.
	 */
	public int countByZip(String zip) throws PortalException, SystemException {
		return amfUserFinder.countByZip(zip);
	}

	public List<User> findByZip(String zip, int start, int end)
		throws PortalException, SystemException {

		return amfUserFinder.findByZip(zip, start, end);
	}

}