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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Sara Liu
 * @generated
 */
public class EventMonitorSoap implements Serializable {
	public static EventMonitorSoap toSoapModel(EventMonitor model) {
		EventMonitorSoap soapModel = new EventMonitorSoap();

		soapModel.setEventMonitorId(model.getEventMonitorId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEventType(model.getEventType());
		soapModel.setIpAddress(model.getIpAddress());

		return soapModel;
	}

	public static EventMonitorSoap[] toSoapModels(EventMonitor[] models) {
		EventMonitorSoap[] soapModels = new EventMonitorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventMonitorSoap[][] toSoapModels(EventMonitor[][] models) {
		EventMonitorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventMonitorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventMonitorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventMonitorSoap[] toSoapModels(List<EventMonitor> models) {
		List<EventMonitorSoap> soapModels = new ArrayList<EventMonitorSoap>(models.size());

		for (EventMonitor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventMonitorSoap[soapModels.size()]);
	}

	public EventMonitorSoap() {
	}

	public long getPrimaryKey() {
		return _eventMonitorId;
	}

	public void setPrimaryKey(long pk) {
		setEventMonitorId(pk);
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
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	private long _eventMonitorId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _startDate;
	private String _eventType;
	private String _ipAddress;
}