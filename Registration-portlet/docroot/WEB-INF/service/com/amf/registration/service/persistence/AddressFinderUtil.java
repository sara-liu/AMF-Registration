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

package com.amf.registration.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Sara Liu
 */
public class AddressFinderUtil {
	public static int countByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByZip(zip);
	}

	public static java.util.List<com.liferay.portal.model.User> findByZip(
		java.lang.String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByZip(zip, start, end);
	}

	public static AddressFinder getFinder() {
		if (_finder == null) {
			_finder = (AddressFinder)PortletBeanLocatorUtil.locate(com.amf.registration.service.ClpSerializer.getServletContextName(),
					AddressFinder.class.getName());

			ReferenceRegistry.registerReference(AddressFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AddressFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AddressFinderUtil.class, "_finder");
	}

	private static AddressFinder _finder;
}