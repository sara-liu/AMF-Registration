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

package com.amf.registration.service.impl;

import com.amf.registration.model.EventMonitor;
import com.amf.registration.service.base.EventMonitorLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the event monitor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.amf.registration.service.EventMonitorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sara Liu
 * @see com.amf.registration.service.base.EventMonitorLocalServiceBaseImpl
 * @see com.amf.registration.service.EventMonitorLocalServiceUtil
 */
public class EventMonitorLocalServiceImpl
	extends EventMonitorLocalServiceBaseImpl {

	public EventMonitor addEventMonitor(
			long userId, String userName, long companyId, String eventType,
			String ipAddress)
		throws SystemException {

		Date now = new Date();

		long eventMonitorId = counterLocalService.increment();

		EventMonitor eventMonitor = eventMonitorPersistence.create(
			eventMonitorId);

		eventMonitor.setUserId(userId);
		eventMonitor.setUserName(userName);
		eventMonitor.setStartDate(now);
		eventMonitor.setCompanyId(companyId);
		eventMonitor.setEventType(eventType);
		eventMonitor.setIpAddress(ipAddress);

		eventMonitorPersistence.update(eventMonitor, false);

		return eventMonitor;
	}

	public List<EventMonitor> getEventMonitor(int start, int end)
		throws SystemException {

		return eventMonitorPersistence.findAll(start, end);
	}

	public List<EventMonitor> getEventMonitor(long userId, int start, int end)
		throws SystemException {

		return eventMonitorPersistence.findByUserId(userId);
	}

	public List<EventMonitor> getEventMonitor(
			long userId, String eventType, int start, int end)
		throws SystemException {

		return eventMonitorPersistence.findByU_ET(userId, eventType);
	}

	public List<EventMonitor> getEventMonitor(
			String eventType, int start, int end)
		throws SystemException {

		return eventMonitorPersistence.findByEventType(eventType);
	}

	public int getEventMonitorCount() throws SystemException {
		return eventMonitorPersistence.countAll();
	}

	public int getEventMonitorCount(long userId) throws SystemException {
		return eventMonitorPersistence.countByUserId(userId);
	}

	public int getEventMonitorCount(long userId, String eventType)
		throws SystemException {

		return eventMonitorPersistence.countByU_ET(userId, eventType);
	}

	public int getEventMonitorCount(String eventType) throws SystemException {
		return eventMonitorPersistence.countByEventType(eventType);
	}

}