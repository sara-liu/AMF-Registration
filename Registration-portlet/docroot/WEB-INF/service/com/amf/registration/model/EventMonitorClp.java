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

import com.amf.registration.service.ClpSerializer;
import com.amf.registration.service.EventMonitorLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sara Liu
 */
public class EventMonitorClp extends BaseModelImpl<EventMonitor>
	implements EventMonitor {
	public EventMonitorClp() {
	}

	public Class<?> getModelClass() {
		return EventMonitor.class;
	}

	public String getModelClassName() {
		return EventMonitor.class.getName();
	}

	public long getPrimaryKey() {
		return _eventMonitorId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEventMonitorId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_eventMonitorId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventMonitorId", getEventMonitorId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("startDate", getStartDate());
		attributes.put("eventType", getEventType());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventMonitorId = (Long)attributes.get("eventMonitorId");

		if (eventMonitorId != null) {
			setEventMonitorId(eventMonitorId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	public long getEventMonitorId() {
		return _eventMonitorId;
	}

	public void setEventMonitorId(long eventMonitorId) {
		_eventMonitorId = eventMonitorId;

		if (_eventMonitorRemoteModel != null) {
			try {
				Class<?> clazz = _eventMonitorRemoteModel.getClass();

				Method method = clazz.getMethod("setEventMonitorId", long.class);

				method.invoke(_eventMonitorRemoteModel, eventMonitorId);
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

		if (_eventMonitorRemoteModel != null) {
			try {
				Class<?> clazz = _eventMonitorRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventMonitorRemoteModel, companyId);
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

		if (_eventMonitorRemoteModel != null) {
			try {
				Class<?> clazz = _eventMonitorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eventMonitorRemoteModel, userId);
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;

		if (_eventMonitorRemoteModel != null) {
			try {
				Class<?> clazz = _eventMonitorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_eventMonitorRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_eventMonitorRemoteModel != null) {
			try {
				Class<?> clazz = _eventMonitorRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_eventMonitorRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;

		if (_eventMonitorRemoteModel != null) {
			try {
				Class<?> clazz = _eventMonitorRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_eventMonitorRemoteModel, eventType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;

		if (_eventMonitorRemoteModel != null) {
			try {
				Class<?> clazz = _eventMonitorRemoteModel.getClass();

				Method method = clazz.getMethod("setIpAddress", String.class);

				method.invoke(_eventMonitorRemoteModel, ipAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventMonitorRemoteModel() {
		return _eventMonitorRemoteModel;
	}

	public void setEventMonitorRemoteModel(BaseModel<?> eventMonitorRemoteModel) {
		_eventMonitorRemoteModel = eventMonitorRemoteModel;
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

		Class<?> remoteModelClass = _eventMonitorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventMonitorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EventMonitorLocalServiceUtil.addEventMonitor(this);
		}
		else {
			EventMonitorLocalServiceUtil.updateEventMonitor(this);
		}
	}

	@Override
	public EventMonitor toEscapedModel() {
		return (EventMonitor)ProxyUtil.newProxyInstance(EventMonitor.class.getClassLoader(),
			new Class[] { EventMonitor.class }, new AutoEscapeBeanHandler(this));
	}

	public EventMonitor toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		EventMonitorClp clone = new EventMonitorClp();

		clone.setEventMonitorId(getEventMonitorId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setStartDate(getStartDate());
		clone.setEventType(getEventType());
		clone.setIpAddress(getIpAddress());

		return clone;
	}

	public int compareTo(EventMonitor eventMonitor) {
		int value = 0;

		value = DateUtil.compareTo(getStartDate(), eventMonitor.getStartDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventMonitorClp)) {
			return false;
		}

		EventMonitorClp eventMonitor = (EventMonitorClp)obj;

		long primaryKey = eventMonitor.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{eventMonitorId=");
		sb.append(getEventMonitorId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", ipAddress=");
		sb.append(getIpAddress());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.amf.registration.model.EventMonitor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventMonitorId</column-name><column-value><![CDATA[");
		sb.append(getEventMonitorId());
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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipAddress</column-name><column-value><![CDATA[");
		sb.append(getIpAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventMonitorId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _startDate;
	private String _eventType;
	private String _ipAddress;
	private BaseModel<?> _eventMonitorRemoteModel;
}