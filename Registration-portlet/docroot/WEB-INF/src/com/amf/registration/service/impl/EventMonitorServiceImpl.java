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
import com.amf.registration.service.EventMonitorLocalServiceUtil;
import com.amf.registration.service.base.EventMonitorServiceBaseImpl;
import com.amf.registration.service.permission.EventMonitorPermissionUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;

import java.util.List;

/**
 * The implementation of the event monitor remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.amf.registration.service.EventMonitorService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Sara Liu
 * @see com.amf.registration.service.base.EventMonitorServiceBaseImpl
 * @see com.amf.registration.service.EventMonitorServiceUtil
 */
public class EventMonitorServiceImpl extends EventMonitorServiceBaseImpl {

	public List<EventMonitor> getEvent(
			long userId, long groupId, int start, int end)
		throws PortalException, SystemException {

		boolean hasViewPermission = EventMonitorPermissionUtil.contains(
			getPermissionChecker(), groupId, ActionKeys.VIEW);

		if (hasViewPermission) {
			return EventMonitorLocalServiceUtil.getEvent(start, end);
		}
		else {
			return EventMonitorLocalServiceUtil.getEvent(userId, start, end);
		}
	}

	public List<EventMonitor> getEvent(
			long userId, String eventType, long groupId, int start, int end)
		throws PortalException, SystemException {

		boolean hasViewPermission = EventMonitorPermissionUtil.contains(
			getPermissionChecker(), groupId, ActionKeys.VIEW);

		if (hasViewPermission) {
			return EventMonitorLocalServiceUtil.getEvent(eventType, start, end);
		}
		else {
			return EventMonitorLocalServiceUtil.getEvent(
				userId, eventType, start, end);
		}
	}

	public int getEventCount(long userId, long groupId)
			throws PortalException, SystemException {

		boolean hasViewPermission = EventMonitorPermissionUtil.contains(
			getPermissionChecker(), groupId, ActionKeys.VIEW);

		if (hasViewPermission) {
			return EventMonitorLocalServiceUtil.getEventCount();
		}
		else {
			return EventMonitorLocalServiceUtil.getEventCount(userId);
		}
	}

	public int getEventCount(long userId, String eventType, long groupId)
		throws PortalException, SystemException {

		boolean hasViewPermission = EventMonitorPermissionUtil.contains(
			getPermissionChecker(), groupId, ActionKeys.VIEW);

		if (hasViewPermission) {
			return EventMonitorLocalServiceUtil.getEventCount(eventType);
		}
		else {
			return EventMonitorLocalServiceUtil.getEventCount(
				userId, eventType);
		}
	}

}