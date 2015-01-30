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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the event monitor local service. This utility wraps {@link com.amf.registration.service.impl.EventMonitorLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sara Liu
 * @see EventMonitorLocalService
 * @see com.amf.registration.service.base.EventMonitorLocalServiceBaseImpl
 * @see com.amf.registration.service.impl.EventMonitorLocalServiceImpl
 * @generated
 */
public class EventMonitorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.amf.registration.service.impl.EventMonitorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the event monitor to the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.EventMonitor addEventMonitor(
		com.amf.registration.model.EventMonitor eventMonitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEventMonitor(eventMonitor);
	}

	/**
	* Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	*
	* @param eventMonitorId the primary key for the new event monitor
	* @return the new event monitor
	*/
	public static com.amf.registration.model.EventMonitor createEventMonitor(
		long eventMonitorId) {
		return getService().createEventMonitor(eventMonitorId);
	}

	/**
	* Deletes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitorId the primary key of the event monitor
	* @return the event monitor that was removed
	* @throws PortalException if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.EventMonitor deleteEventMonitor(
		long eventMonitorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventMonitor(eventMonitorId);
	}

	/**
	* Deletes the event monitor from the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.EventMonitor deleteEventMonitor(
		com.amf.registration.model.EventMonitor eventMonitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEventMonitor(eventMonitor);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.amf.registration.model.EventMonitor fetchEventMonitor(
		long eventMonitorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEventMonitor(eventMonitorId);
	}

	/**
	* Returns the event monitor with the primary key.
	*
	* @param eventMonitorId the primary key of the event monitor
	* @return the event monitor
	* @throws PortalException if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.EventMonitor getEventMonitor(
		long eventMonitorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventMonitor(eventMonitorId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the event monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of event monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.EventMonitor> getEventMonitors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventMonitors(start, end);
	}

	/**
	* Returns the number of event monitors.
	*
	* @return the number of event monitors
	* @throws SystemException if a system exception occurred
	*/
	public static int getEventMonitorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventMonitorsCount();
	}

	/**
	* Updates the event monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.EventMonitor updateEventMonitor(
		com.amf.registration.model.EventMonitor eventMonitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEventMonitor(eventMonitor);
	}

	/**
	* Updates the event monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @param merge whether to merge the event monitor with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the event monitor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.EventMonitor updateEventMonitor(
		com.amf.registration.model.EventMonitor eventMonitor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEventMonitor(eventMonitor, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.amf.registration.model.EventMonitor addEvent(
		long companyId, long userId, java.lang.String userName,
		java.lang.String eventType, java.lang.String ipAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEvent(companyId, userId, userName, eventType, ipAddress);
	}

	public static java.util.List<com.amf.registration.model.EventMonitor> getEvent(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEvent(start, end);
	}

	public static java.util.List<com.amf.registration.model.EventMonitor> getEvent(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEvent(userId, start, end);
	}

	public static java.util.List<com.amf.registration.model.EventMonitor> getEvent(
		long userId, java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEvent(userId, eventType, start, end);
	}

	public static java.util.List<com.amf.registration.model.EventMonitor> getEvent(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEvent(eventType, start, end);
	}

	public static int getEventCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventCount();
	}

	public static int getEventCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventCount(userId);
	}

	public static int getEventCount(long userId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventCount(userId, eventType);
	}

	public static int getEventCount(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEventCount(eventType);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventMonitorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventMonitorLocalService.class.getName());

			if (invokableLocalService instanceof EventMonitorLocalService) {
				_service = (EventMonitorLocalService)invokableLocalService;
			}
			else {
				_service = new EventMonitorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EventMonitorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(EventMonitorLocalService service) {
	}

	private static EventMonitorLocalService _service;
}