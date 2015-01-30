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

package com.amf.registration.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EventMonitorService}.
 * </p>
 *
 * @author    Sara Liu
 * @see       EventMonitorService
 * @generated
 */
public class EventMonitorServiceWrapper implements EventMonitorService,
	ServiceWrapper<EventMonitorService> {
	public EventMonitorServiceWrapper(EventMonitorService eventMonitorService) {
		_eventMonitorService = eventMonitorService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _eventMonitorService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventMonitorService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventMonitorService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<com.amf.registration.model.EventMonitor> getEvent(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventMonitorService.getEvent(userId, groupId, start, end);
	}

	public java.util.List<com.amf.registration.model.EventMonitor> getEvent(
		long userId, java.lang.String eventType, long groupId, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventMonitorService.getEvent(userId, eventType, groupId, start,
			end);
	}

	public int getEventCount(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventMonitorService.getEventCount(userId, groupId);
	}

	public int getEventCount(long userId, java.lang.String eventType,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventMonitorService.getEventCount(userId, eventType, groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EventMonitorService getWrappedEventMonitorService() {
		return _eventMonitorService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEventMonitorService(
		EventMonitorService eventMonitorService) {
		_eventMonitorService = eventMonitorService;
	}

	public EventMonitorService getWrappedService() {
		return _eventMonitorService;
	}

	public void setWrappedService(EventMonitorService eventMonitorService) {
		_eventMonitorService = eventMonitorService;
	}

	private EventMonitorService _eventMonitorService;
}