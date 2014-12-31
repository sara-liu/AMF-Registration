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

package com.amf.registration.model.impl;

import com.amf.registration.model.AMFUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing AMFUser in entity cache.
 *
 * @author Sara Liu
 * @see AMFUser
 * @generated
 */
public class AMFUserCacheModel implements CacheModel<AMFUser>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{userId=");
		sb.append(userId);

		return sb.toString();
	}

	public AMFUser toEntityModel() {
		AMFUserImpl amfUserImpl = new AMFUserImpl();

		amfUserImpl.setUserId(userId);

		amfUserImpl.resetOriginalValues();

		return amfUserImpl;
	}

	public long userId;
}