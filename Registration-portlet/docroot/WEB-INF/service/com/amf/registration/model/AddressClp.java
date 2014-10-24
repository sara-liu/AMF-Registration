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

package com.amf.registration.model;

import com.amf.registration.service.AddressLocalServiceUtil;
import com.amf.registration.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sara Liu
 */
public class AddressClp extends BaseModelImpl<Address> implements Address {
	public AddressClp() {
	}

	public Class<?> getModelClass() {
		return Address.class;
	}

	public String getModelClassName() {
		return Address.class.getName();
	}

	public long getPrimaryKey() {
		return _addressId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAddressId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_addressId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("addressId", getAddressId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zip", getZip());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_addressRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressId", long.class);

				method.invoke(_addressRemoteModel, addressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_addressRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_addressRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress1", String.class);

				method.invoke(_addressRemoteModel, address1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress2", String.class);

				method.invoke(_addressRemoteModel, address2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_addressRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_addressRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;

		if (_addressRemoteModel != null) {
			try {
				Class<?> clazz = _addressRemoteModel.getClass();

				Method method = clazz.getMethod("setZip", String.class);

				method.invoke(_addressRemoteModel, zip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAddressRemoteModel() {
		return _addressRemoteModel;
	}

	public void setAddressRemoteModel(BaseModel<?> addressRemoteModel) {
		_addressRemoteModel = addressRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _addressRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_addressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AddressLocalServiceUtil.addAddress(this);
		}
		else {
			AddressLocalServiceUtil.updateAddress(this);
		}
	}

	@Override
	public Address toEscapedModel() {
		return (Address)ProxyUtil.newProxyInstance(Address.class.getClassLoader(),
			new Class[] { Address.class }, new AutoEscapeBeanHandler(this));
	}

	public Address toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		AddressClp clone = new AddressClp();

		clone.setUuid(getUuid());
		clone.setAddressId(getAddressId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setAddress1(getAddress1());
		clone.setAddress2(getAddress2());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setZip(getZip());

		return clone;
	}

	public int compareTo(Address address) {
		long primaryKey = address.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressClp)) {
			return false;
		}

		AddressClp address = (AddressClp)obj;

		long primaryKey = address.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", addressId=");
		sb.append(getAddressId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.amf.registration.model.Address");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address2</column-name><column-value><![CDATA[");
		sb.append(getAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _addressId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
	private BaseModel<?> _addressRemoteModel;
}