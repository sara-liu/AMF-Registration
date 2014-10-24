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

import com.amf.registration.model.Address;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author Sara Liu
 * @see Address
 * @generated
 */
public class AddressCacheModel implements CacheModel<Address>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zip=");
		sb.append(zip);
		sb.append("}");

		return sb.toString();
	}

	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		if (uuid == null) {
			addressImpl.setUuid(StringPool.BLANK);
		}
		else {
			addressImpl.setUuid(uuid);
		}

		addressImpl.setAddressId(addressId);
		addressImpl.setCompanyId(companyId);
		addressImpl.setUserId(userId);

		if (address1 == null) {
			addressImpl.setAddress1(StringPool.BLANK);
		}
		else {
			addressImpl.setAddress1(address1);
		}

		if (address2 == null) {
			addressImpl.setAddress2(StringPool.BLANK);
		}
		else {
			addressImpl.setAddress2(address2);
		}

		if (city == null) {
			addressImpl.setCity(StringPool.BLANK);
		}
		else {
			addressImpl.setCity(city);
		}

		if (state == null) {
			addressImpl.setState(StringPool.BLANK);
		}
		else {
			addressImpl.setState(state);
		}

		if (zip == null) {
			addressImpl.setZip(StringPool.BLANK);
		}
		else {
			addressImpl.setZip(zip);
		}

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	public String uuid;
	public long addressId;
	public long companyId;
	public long userId;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String zip;
}