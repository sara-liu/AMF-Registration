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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing EventMonitor in entity cache.
 *
 * @author Sara Liu
 * @see EventMonitor
 * @generated
 */
public class EventMonitorCacheModel implements CacheModel<EventMonitor>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{eventMonitorId=");
		sb.append(eventMonitorId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	public EventMonitor toEntityModel() {
		EventMonitorImpl eventMonitorImpl = new EventMonitorImpl();

		eventMonitorImpl.setEventMonitorId(eventMonitorId);
		eventMonitorImpl.setCompanyId(companyId);
		eventMonitorImpl.setUserId(userId);

		if (userName == null) {
			eventMonitorImpl.setUserName(StringPool.BLANK);
		}
		else {
			eventMonitorImpl.setUserName(userName);
		}

		if (startDate == Long.MIN_VALUE) {
			eventMonitorImpl.setStartDate(null);
		}
		else {
			eventMonitorImpl.setStartDate(new Date(startDate));
		}

		if (eventType == null) {
			eventMonitorImpl.setEventType(StringPool.BLANK);
		}
		else {
			eventMonitorImpl.setEventType(eventType);
		}

		if (ipAddress == null) {
			eventMonitorImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			eventMonitorImpl.setIpAddress(ipAddress);
		}

		eventMonitorImpl.resetOriginalValues();

		return eventMonitorImpl;
	}

	public long eventMonitorId;
	public long companyId;
	public long userId;
	public String userName;
	public long startDate;
	public String eventType;
	public String ipAddress;
}