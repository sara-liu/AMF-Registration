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

import com.amf.registration.model.Address;
import com.amf.registration.service.base.AddressLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

public class AddressLocalServiceImpl extends AddressLocalServiceBaseImpl {

	public Address addAddress(
			long userId, String address1, String address2, String city,
			String state, String zip, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		long addressId = counterLocalService.increment();

		Address address = addressPersistence.create(addressId);

		address.setUuid(serviceContext.getUuid());
		address.setCompanyId(serviceContext.getCompanyId());
		address.setUserId(user.getUserId());
		address.setAddress1(address1);
		address.setAddress2(address2);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);

		addressPersistence.update(address, false);

		return address;
	}

	public int countByZip(String zip) throws PortalException, SystemException {
		return addressFinder.countByZip(zip);
	}

	public List findByZip(String zip, int start, int end)
		throws PortalException, SystemException {

		return addressFinder.findByZip(zip, start, end);
	}

}