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

import com.amf.registration.model.EventMonitor;
import com.amf.registration.model.EventMonitorModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the EventMonitor service. Represents a row in the &quot;Registration_EventMonitor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.amf.registration.model.EventMonitorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventMonitorImpl}.
 * </p>
 *
 * @author Sara Liu
 * @see EventMonitorImpl
 * @see com.amf.registration.model.EventMonitor
 * @see com.amf.registration.model.EventMonitorModel
 * @generated
 */
public class EventMonitorModelImpl extends BaseModelImpl<EventMonitor>
	implements EventMonitorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event monitor model instance should use the {@link com.amf.registration.model.EventMonitor} interface instead.
	 */
	public static final String TABLE_NAME = "Registration_EventMonitor";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eventMonitorId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "eventType", Types.VARCHAR },
			{ "ipAddress", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Registration_EventMonitor (eventMonitorId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,startDate DATE null,eventType VARCHAR(75) null,ipAddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Registration_EventMonitor";
	public static final String ORDER_BY_JPQL = " ORDER BY eventMonitor.startDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Registration_EventMonitor.startDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.amf.registration.model.EventMonitor"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.amf.registration.model.EventMonitor"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.amf.registration.model.EventMonitor"),
			true);
	public static long EVENTTYPE_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.amf.registration.model.EventMonitor"));

	public EventMonitorModelImpl() {
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

	public Class<?> getModelClass() {
		return EventMonitor.class;
	}

	public String getModelClassName() {
		return EventMonitor.class.getName();
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
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_columnBitmask = -1L;

		_startDate = startDate;
	}

	public String getEventType() {
		if (_eventType == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventType;
		}
	}

	public void setEventType(String eventType) {
		_columnBitmask |= EVENTTYPE_COLUMN_BITMASK;

		if (_originalEventType == null) {
			_originalEventType = _eventType;
		}

		_eventType = eventType;
	}

	public String getOriginalEventType() {
		return GetterUtil.getString(_originalEventType);
	}

	public String getIpAddress() {
		if (_ipAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _ipAddress;
		}
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EventMonitor.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EventMonitor toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EventMonitor)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public EventMonitor toUnescapedModel() {
		return (EventMonitor)this;
	}

	@Override
	public Object clone() {
		EventMonitorImpl eventMonitorImpl = new EventMonitorImpl();

		eventMonitorImpl.setEventMonitorId(getEventMonitorId());
		eventMonitorImpl.setCompanyId(getCompanyId());
		eventMonitorImpl.setUserId(getUserId());
		eventMonitorImpl.setUserName(getUserName());
		eventMonitorImpl.setStartDate(getStartDate());
		eventMonitorImpl.setEventType(getEventType());
		eventMonitorImpl.setIpAddress(getIpAddress());

		eventMonitorImpl.resetOriginalValues();

		return eventMonitorImpl;
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

		if (!(obj instanceof EventMonitor)) {
			return false;
		}

		EventMonitor eventMonitor = (EventMonitor)obj;

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
	public void resetOriginalValues() {
		EventMonitorModelImpl eventMonitorModelImpl = this;

		eventMonitorModelImpl._originalUserId = eventMonitorModelImpl._userId;

		eventMonitorModelImpl._setOriginalUserId = false;

		eventMonitorModelImpl._originalEventType = eventMonitorModelImpl._eventType;

		eventMonitorModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EventMonitor> toCacheModel() {
		EventMonitorCacheModel eventMonitorCacheModel = new EventMonitorCacheModel();

		eventMonitorCacheModel.eventMonitorId = getEventMonitorId();

		eventMonitorCacheModel.companyId = getCompanyId();

		eventMonitorCacheModel.userId = getUserId();

		eventMonitorCacheModel.userName = getUserName();

		String userName = eventMonitorCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			eventMonitorCacheModel.userName = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			eventMonitorCacheModel.startDate = startDate.getTime();
		}
		else {
			eventMonitorCacheModel.startDate = Long.MIN_VALUE;
		}

		eventMonitorCacheModel.eventType = getEventType();

		String eventType = eventMonitorCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			eventMonitorCacheModel.eventType = null;
		}

		eventMonitorCacheModel.ipAddress = getIpAddress();

		String ipAddress = eventMonitorCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			eventMonitorCacheModel.ipAddress = null;
		}

		return eventMonitorCacheModel;
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

	private static ClassLoader _classLoader = EventMonitor.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EventMonitor.class
		};
	private long _eventMonitorId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _startDate;
	private String _eventType;
	private String _originalEventType;
	private String _ipAddress;
	private long _columnBitmask;
	private EventMonitor _escapedModel;
}