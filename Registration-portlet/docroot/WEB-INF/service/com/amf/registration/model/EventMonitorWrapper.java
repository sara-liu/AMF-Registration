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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventMonitor}.
 * </p>
 *
 * @author    Sara Liu
 * @see       EventMonitor
 * @generated
 */
public class EventMonitorWrapper implements EventMonitor,
	ModelWrapper<EventMonitor> {
	public EventMonitorWrapper(EventMonitor eventMonitor) {
		_eventMonitor = eventMonitor;
	}

	public Class<?> getModelClass() {
		return EventMonitor.class;
	}

	public String getModelClassName() {
		return EventMonitor.class.getName();
	}

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

	/**
	* Returns the primary key of this event monitor.
	*
	* @return the primary key of this event monitor
	*/
	public long getPrimaryKey() {
		return _eventMonitor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event monitor.
	*
	* @param primaryKey the primary key of this event monitor
	*/
	public void setPrimaryKey(long primaryKey) {
		_eventMonitor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event monitor ID of this event monitor.
	*
	* @return the event monitor ID of this event monitor
	*/
	public long getEventMonitorId() {
		return _eventMonitor.getEventMonitorId();
	}

	/**
	* Sets the event monitor ID of this event monitor.
	*
	* @param eventMonitorId the event monitor ID of this event monitor
	*/
	public void setEventMonitorId(long eventMonitorId) {
		_eventMonitor.setEventMonitorId(eventMonitorId);
	}

	/**
	* Returns the company ID of this event monitor.
	*
	* @return the company ID of this event monitor
	*/
	public long getCompanyId() {
		return _eventMonitor.getCompanyId();
	}

	/**
	* Sets the company ID of this event monitor.
	*
	* @param companyId the company ID of this event monitor
	*/
	public void setCompanyId(long companyId) {
		_eventMonitor.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this event monitor.
	*
	* @return the user ID of this event monitor
	*/
	public long getUserId() {
		return _eventMonitor.getUserId();
	}

	/**
	* Sets the user ID of this event monitor.
	*
	* @param userId the user ID of this event monitor
	*/
	public void setUserId(long userId) {
		_eventMonitor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this event monitor.
	*
	* @return the user uuid of this event monitor
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventMonitor.getUserUuid();
	}

	/**
	* Sets the user uuid of this event monitor.
	*
	* @param userUuid the user uuid of this event monitor
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_eventMonitor.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this event monitor.
	*
	* @return the user name of this event monitor
	*/
	public java.lang.String getUserName() {
		return _eventMonitor.getUserName();
	}

	/**
	* Sets the user name of this event monitor.
	*
	* @param userName the user name of this event monitor
	*/
	public void setUserName(java.lang.String userName) {
		_eventMonitor.setUserName(userName);
	}

	/**
	* Returns the start date of this event monitor.
	*
	* @return the start date of this event monitor
	*/
	public java.util.Date getStartDate() {
		return _eventMonitor.getStartDate();
	}

	/**
	* Sets the start date of this event monitor.
	*
	* @param startDate the start date of this event monitor
	*/
	public void setStartDate(java.util.Date startDate) {
		_eventMonitor.setStartDate(startDate);
	}

	/**
	* Returns the event type of this event monitor.
	*
	* @return the event type of this event monitor
	*/
	public java.lang.String getEventType() {
		return _eventMonitor.getEventType();
	}

	/**
	* Sets the event type of this event monitor.
	*
	* @param eventType the event type of this event monitor
	*/
	public void setEventType(java.lang.String eventType) {
		_eventMonitor.setEventType(eventType);
	}

	/**
	* Returns the ip address of this event monitor.
	*
	* @return the ip address of this event monitor
	*/
	public java.lang.String getIpAddress() {
		return _eventMonitor.getIpAddress();
	}

	/**
	* Sets the ip address of this event monitor.
	*
	* @param ipAddress the ip address of this event monitor
	*/
	public void setIpAddress(java.lang.String ipAddress) {
		_eventMonitor.setIpAddress(ipAddress);
	}

	public boolean isNew() {
		return _eventMonitor.isNew();
	}

	public void setNew(boolean n) {
		_eventMonitor.setNew(n);
	}

	public boolean isCachedModel() {
		return _eventMonitor.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_eventMonitor.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _eventMonitor.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _eventMonitor.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventMonitor.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventMonitor.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventMonitor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventMonitorWrapper((EventMonitor)_eventMonitor.clone());
	}

	public int compareTo(com.amf.registration.model.EventMonitor eventMonitor) {
		return _eventMonitor.compareTo(eventMonitor);
	}

	@Override
	public int hashCode() {
		return _eventMonitor.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.amf.registration.model.EventMonitor> toCacheModel() {
		return _eventMonitor.toCacheModel();
	}

	public com.amf.registration.model.EventMonitor toEscapedModel() {
		return new EventMonitorWrapper(_eventMonitor.toEscapedModel());
	}

	public com.amf.registration.model.EventMonitor toUnescapedModel() {
		return new EventMonitorWrapper(_eventMonitor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventMonitor.toString();
	}

	public java.lang.String toXmlString() {
		return _eventMonitor.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventMonitor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventMonitorWrapper)) {
			return false;
		}

		EventMonitorWrapper eventMonitorWrapper = (EventMonitorWrapper)obj;

		if (Validator.equals(_eventMonitor, eventMonitorWrapper._eventMonitor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EventMonitor getWrappedEventMonitor() {
		return _eventMonitor;
	}

	public EventMonitor getWrappedModel() {
		return _eventMonitor;
	}

	public void resetOriginalValues() {
		_eventMonitor.resetOriginalValues();
	}

	private EventMonitor _eventMonitor;
}