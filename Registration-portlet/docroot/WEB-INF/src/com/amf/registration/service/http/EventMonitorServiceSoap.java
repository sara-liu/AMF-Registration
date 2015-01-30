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

package com.amf.registration.service.http;

import com.amf.registration.service.EventMonitorServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.amf.registration.service.EventMonitorServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.amf.registration.model.EventMonitorSoap}.
 * If the method in the service utility returns a
 * {@link com.amf.registration.model.EventMonitor}, that is translated to a
 * {@link com.amf.registration.model.EventMonitorSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Sara Liu
 * @see       EventMonitorServiceHttp
 * @see       com.amf.registration.model.EventMonitorSoap
 * @see       com.amf.registration.service.EventMonitorServiceUtil
 * @generated
 */
public class EventMonitorServiceSoap {
	public static com.amf.registration.model.EventMonitorSoap[] getEvent(
		long userId, long groupId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.amf.registration.model.EventMonitor> returnValue = EventMonitorServiceUtil.getEvent(userId,
					groupId, start, end);

			return com.amf.registration.model.EventMonitorSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.amf.registration.model.EventMonitorSoap[] getEvent(
		long userId, java.lang.String eventType, long groupId, int start,
		int end) throws RemoteException {
		try {
			java.util.List<com.amf.registration.model.EventMonitor> returnValue = EventMonitorServiceUtil.getEvent(userId,
					eventType, groupId, start, end);

			return com.amf.registration.model.EventMonitorSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getEventCount(long userId, long groupId)
		throws RemoteException {
		try {
			int returnValue = EventMonitorServiceUtil.getEventCount(userId,
					groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getEventCount(long userId, java.lang.String eventType,
		long groupId) throws RemoteException {
		try {
			int returnValue = EventMonitorServiceUtil.getEventCount(userId,
					eventType, groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EventMonitorServiceSoap.class);
}