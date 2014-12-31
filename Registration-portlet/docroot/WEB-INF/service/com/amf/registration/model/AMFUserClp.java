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

import com.amf.registration.service.AMFUserLocalServiceUtil;
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
public class AMFUserClp extends BaseModelImpl<AMFUser> implements AMFUser {
	public AMFUserClp() {
	}

	public Class<?> getModelClass() {
		return AMFUser.class;
	}

	public String getModelClassName() {
		return AMFUser.class.getName();
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_amfUserRemoteModel != null) {
			try {
				Class<?> clazz = _amfUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_amfUserRemoteModel, userId);
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

	public BaseModel<?> getAMFUserRemoteModel() {
		return _amfUserRemoteModel;
	}

	public void setAMFUserRemoteModel(BaseModel<?> amfUserRemoteModel) {
		_amfUserRemoteModel = amfUserRemoteModel;
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

		Class<?> remoteModelClass = _amfUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_amfUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AMFUserLocalServiceUtil.addAMFUser(this);
		}
		else {
			AMFUserLocalServiceUtil.updateAMFUser(this);
		}
	}

	@Override
	public AMFUser toEscapedModel() {
		return (AMFUser)ProxyUtil.newProxyInstance(AMFUser.class.getClassLoader(),
			new Class[] { AMFUser.class }, new AutoEscapeBeanHandler(this));
	}

	public AMFUser toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		AMFUserClp clone = new AMFUserClp();

		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(AMFUser amfUser) {
		long primaryKey = amfUser.getPrimaryKey();

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

		if (!(obj instanceof AMFUserClp)) {
			return false;
		}

		AMFUserClp amfUser = (AMFUserClp)obj;

		long primaryKey = amfUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(3);

		sb.append("{userId=");
		sb.append(getUserId());

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("com.amf.registration.model.AMFUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private BaseModel<?> _amfUserRemoteModel;
}