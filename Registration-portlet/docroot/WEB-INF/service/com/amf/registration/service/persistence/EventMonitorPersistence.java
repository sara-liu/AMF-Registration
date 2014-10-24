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

package com.amf.registration.service.persistence;

import com.amf.registration.model.EventMonitor;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the event monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see EventMonitorPersistenceImpl
 * @see EventMonitorUtil
 * @generated
 */
public interface EventMonitorPersistence extends BasePersistence<EventMonitor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventMonitorUtil} to access the event monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the event monitor in the entity cache if it is enabled.
	*
	* @param eventMonitor the event monitor
	*/
	public void cacheResult(
		com.amf.registration.model.EventMonitor eventMonitor);

	/**
	* Caches the event monitors in the entity cache if it is enabled.
	*
	* @param eventMonitors the event monitors
	*/
	public void cacheResult(
		java.util.List<com.amf.registration.model.EventMonitor> eventMonitors);

	/**
	* Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	*
	* @param eventMonitorId the primary key for the new event monitor
	* @return the new event monitor
	*/
	public com.amf.registration.model.EventMonitor create(long eventMonitorId);

	/**
	* Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitorId the primary key of the event monitor
	* @return the event monitor that was removed
	* @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor remove(long eventMonitorId)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.amf.registration.model.EventMonitor updateImpl(
		com.amf.registration.model.EventMonitor eventMonitor, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event monitor with the primary key or throws a {@link com.amf.registration.NoSuchEventMonitorException} if it could not be found.
	*
	* @param eventMonitorId the primary key of the event monitor
	* @return the event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor findByPrimaryKey(
		long eventMonitorId)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event monitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventMonitorId the primary key of the event monitor
	* @return the event monitor, or <code>null</code> if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor fetchByPrimaryKey(
		long eventMonitorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event monitors where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event monitors where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event monitors where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event monitors before and after the current event monitor in the ordered set where userId = &#63;.
	*
	* @param eventMonitorId the primary key of the current event monitor
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor[] findByUserId_PrevAndNext(
		long eventMonitorId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event monitors where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByEventType(
		java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event monitors where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByEventType(
		java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event monitors where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor findByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor fetchByEventType_First(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor findByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor fetchByEventType_Last(
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event monitors before and after the current event monitor in the ordered set where eventType = &#63;.
	*
	* @param eventMonitorId the primary key of the current event monitor
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor[] findByEventType_PrevAndNext(
		long eventMonitorId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event monitors where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @return the matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByU_ET(
		long userId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event monitors where userId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByU_ET(
		long userId, java.lang.String eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event monitors where userId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findByU_ET(
		long userId, java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor findByU_ET_First(
		long userId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor fetchByU_ET_First(
		long userId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor findByU_ET_Last(
		long userId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor fetchByU_ET_Last(
		long userId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event monitors before and after the current event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param eventMonitorId the primary key of the current event monitor
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event monitor
	* @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.EventMonitor[] findByU_ET_PrevAndNext(
		long eventMonitorId, long userId, java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchEventMonitorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event monitors.
	*
	* @return the event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.amf.registration.model.EventMonitor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event monitors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.EventMonitor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event monitors where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event monitors where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event monitors where userId = &#63; and eventType = &#63; from the database.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_ET(long userId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event monitors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event monitors where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event monitors where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventType(java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event monitors where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @return the number of matching event monitors
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_ET(long userId, java.lang.String eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event monitors.
	*
	* @return the number of event monitors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}