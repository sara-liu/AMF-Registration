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

import com.amf.registration.NoSuchEventMonitorException;
import com.amf.registration.model.EventMonitor;
import com.amf.registration.model.impl.EventMonitorImpl;
import com.amf.registration.model.impl.EventMonitorModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the event monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see EventMonitorPersistence
 * @see EventMonitorUtil
 * @generated
 */
public class EventMonitorPersistenceImpl extends BasePersistenceImpl<EventMonitor>
	implements EventMonitorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventMonitorUtil} to access the event monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventMonitorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			EventMonitorModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] { String.class.getName() },
			EventMonitorModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPE = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_ET = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_ET",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ET = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_ET",
			new String[] { Long.class.getName(), String.class.getName() },
			EventMonitorModelImpl.USERID_COLUMN_BITMASK |
			EventMonitorModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_ET = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_ET",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, EventMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the event monitor in the entity cache if it is enabled.
	 *
	 * @param eventMonitor the event monitor
	 */
	public void cacheResult(EventMonitor eventMonitor) {
		EntityCacheUtil.putResult(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorImpl.class, eventMonitor.getPrimaryKey(), eventMonitor);

		eventMonitor.resetOriginalValues();
	}

	/**
	 * Caches the event monitors in the entity cache if it is enabled.
	 *
	 * @param eventMonitors the event monitors
	 */
	public void cacheResult(List<EventMonitor> eventMonitors) {
		for (EventMonitor eventMonitor : eventMonitors) {
			if (EntityCacheUtil.getResult(
						EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
						EventMonitorImpl.class, eventMonitor.getPrimaryKey()) == null) {
				cacheResult(eventMonitor);
			}
			else {
				eventMonitor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event monitors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventMonitorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventMonitorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event monitor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventMonitor eventMonitor) {
		EntityCacheUtil.removeResult(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorImpl.class, eventMonitor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventMonitor> eventMonitors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventMonitor eventMonitor : eventMonitors) {
			EntityCacheUtil.removeResult(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
				EventMonitorImpl.class, eventMonitor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	 *
	 * @param eventMonitorId the primary key for the new event monitor
	 * @return the new event monitor
	 */
	public EventMonitor create(long eventMonitorId) {
		EventMonitor eventMonitor = new EventMonitorImpl();

		eventMonitor.setNew(true);
		eventMonitor.setPrimaryKey(eventMonitorId);

		return eventMonitor;
	}

	/**
	 * Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor remove(long eventMonitorId)
		throws NoSuchEventMonitorException, SystemException {
		return remove(Long.valueOf(eventMonitorId));
	}

	/**
	 * Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event monitor
	 * @return the event monitor that was removed
	 * @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventMonitor remove(Serializable primaryKey)
		throws NoSuchEventMonitorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventMonitor eventMonitor = (EventMonitor)session.get(EventMonitorImpl.class,
					primaryKey);

			if (eventMonitor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventMonitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventMonitor);
		}
		catch (NoSuchEventMonitorException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EventMonitor removeImpl(EventMonitor eventMonitor)
		throws SystemException {
		eventMonitor = toUnwrappedModel(eventMonitor);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, eventMonitor);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(eventMonitor);

		return eventMonitor;
	}

	@Override
	public EventMonitor updateImpl(
		com.amf.registration.model.EventMonitor eventMonitor, boolean merge)
		throws SystemException {
		eventMonitor = toUnwrappedModel(eventMonitor);

		boolean isNew = eventMonitor.isNew();

		EventMonitorModelImpl eventMonitorModelImpl = (EventMonitorModelImpl)eventMonitor;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, eventMonitor, merge);

			eventMonitor.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventMonitorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventMonitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventMonitorModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(eventMonitorModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((eventMonitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventMonitorModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);

				args = new Object[] { eventMonitorModelImpl.getEventType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);
			}

			if ((eventMonitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(eventMonitorModelImpl.getOriginalUserId()),
						
						eventMonitorModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_ET, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ET,
					args);

				args = new Object[] {
						Long.valueOf(eventMonitorModelImpl.getUserId()),
						
						eventMonitorModelImpl.getEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_ET, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ET,
					args);
			}
		}

		EntityCacheUtil.putResult(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
			EventMonitorImpl.class, eventMonitor.getPrimaryKey(), eventMonitor);

		return eventMonitor;
	}

	protected EventMonitor toUnwrappedModel(EventMonitor eventMonitor) {
		if (eventMonitor instanceof EventMonitorImpl) {
			return eventMonitor;
		}

		EventMonitorImpl eventMonitorImpl = new EventMonitorImpl();

		eventMonitorImpl.setNew(eventMonitor.isNew());
		eventMonitorImpl.setPrimaryKey(eventMonitor.getPrimaryKey());

		eventMonitorImpl.setEventMonitorId(eventMonitor.getEventMonitorId());
		eventMonitorImpl.setCompanyId(eventMonitor.getCompanyId());
		eventMonitorImpl.setUserId(eventMonitor.getUserId());
		eventMonitorImpl.setUserName(eventMonitor.getUserName());
		eventMonitorImpl.setStartDate(eventMonitor.getStartDate());
		eventMonitorImpl.setEventType(eventMonitor.getEventType());
		eventMonitorImpl.setIpAddress(eventMonitor.getIpAddress());

		return eventMonitorImpl;
	}

	/**
	 * Returns the event monitor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event monitor
	 * @return the event monitor
	 * @throws com.liferay.portal.NoSuchModelException if a event monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventMonitor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the event monitor with the primary key or throws a {@link com.amf.registration.NoSuchEventMonitorException} if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor
	 * @throws com.amf.registration.NoSuchEventMonitorException if a event monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor findByPrimaryKey(long eventMonitorId)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = fetchByPrimaryKey(eventMonitorId);

		if (eventMonitor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eventMonitorId);
			}

			throw new NoSuchEventMonitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				eventMonitorId);
		}

		return eventMonitor;
	}

	/**
	 * Returns the event monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event monitor
	 * @return the event monitor, or <code>null</code> if a event monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventMonitor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the event monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventMonitorId the primary key of the event monitor
	 * @return the event monitor, or <code>null</code> if a event monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor fetchByPrimaryKey(long eventMonitorId)
		throws SystemException {
		EventMonitor eventMonitor = (EventMonitor)EntityCacheUtil.getResult(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
				EventMonitorImpl.class, eventMonitorId);

		if (eventMonitor == _nullEventMonitor) {
			return null;
		}

		if (eventMonitor == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				eventMonitor = (EventMonitor)session.get(EventMonitorImpl.class,
						Long.valueOf(eventMonitorId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (eventMonitor != null) {
					cacheResult(eventMonitor);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EventMonitorModelImpl.ENTITY_CACHE_ENABLED,
						EventMonitorImpl.class, eventMonitorId,
						_nullEventMonitor);
				}

				closeSession(session);
			}
		}

		return eventMonitor;
	}

	/**
	 * Returns all the event monitors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventMonitor> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<EventMonitor> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

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
	public List<EventMonitor> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<EventMonitor> list = (List<EventMonitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventMonitor eventMonitor : list) {
				if ((userId != eventMonitor.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EVENTMONITOR_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventMonitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<EventMonitor>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = fetchByUserId_First(userId,
				orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventMonitorException(msg.toString());
	}

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventMonitor> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = fetchByUserId_Last(userId, orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventMonitorException(msg.toString());
	}

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<EventMonitor> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public EventMonitor[] findByUserId_PrevAndNext(long eventMonitorId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = findByPrimaryKey(eventMonitorId);

		Session session = null;

		try {
			session = openSession();

			EventMonitor[] array = new EventMonitorImpl[3];

			array[0] = getByUserId_PrevAndNext(session, eventMonitor, userId,
					orderByComparator, true);

			array[1] = eventMonitor;

			array[2] = getByUserId_PrevAndNext(session, eventMonitor, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventMonitor getByUserId_PrevAndNext(Session session,
		EventMonitor eventMonitor, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTMONITOR_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EventMonitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventMonitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventMonitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventMonitor> findByEventType(String eventType)
		throws SystemException {
		return findByEventType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	public List<EventMonitor> findByEventType(String eventType, int start,
		int end) throws SystemException {
		return findByEventType(eventType, start, end, null);
	}

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
	public List<EventMonitor> findByEventType(String eventType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType, start, end, orderByComparator };
		}

		List<EventMonitor> list = (List<EventMonitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventMonitor eventMonitor : list) {
				if (!Validator.equals(eventType, eventMonitor.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EVENTMONITOR_WHERE);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventMonitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (eventType != null) {
					qPos.add(eventType);
				}

				list = (List<EventMonitor>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor
	 * @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor findByEventType_First(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = fetchByEventType_First(eventType,
				orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventMonitorException(msg.toString());
	}

	/**
	 * Returns the first event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor fetchByEventType_First(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventMonitor> list = findByEventType(eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor
	 * @throws com.amf.registration.NoSuchEventMonitorException if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor findByEventType_Last(String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = fetchByEventType_Last(eventType,
				orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventMonitorException(msg.toString());
	}

	/**
	 * Returns the last event monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor fetchByEventType_Last(String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventType(eventType);

		List<EventMonitor> list = findByEventType(eventType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public EventMonitor[] findByEventType_PrevAndNext(long eventMonitorId,
		String eventType, OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = findByPrimaryKey(eventMonitorId);

		Session session = null;

		try {
			session = openSession();

			EventMonitor[] array = new EventMonitorImpl[3];

			array[0] = getByEventType_PrevAndNext(session, eventMonitor,
					eventType, orderByComparator, true);

			array[1] = eventMonitor;

			array[2] = getByEventType_PrevAndNext(session, eventMonitor,
					eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventMonitor getByEventType_PrevAndNext(Session session,
		EventMonitor eventMonitor, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTMONITOR_WHERE);

		if (eventType == null) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
		}
		else {
			if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EventMonitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (eventType != null) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventMonitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventMonitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event monitors where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventMonitor> findByU_ET(long userId, String eventType)
		throws SystemException {
		return findByU_ET(userId, eventType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<EventMonitor> findByU_ET(long userId, String eventType,
		int start, int end) throws SystemException {
		return findByU_ET(userId, eventType, start, end, null);
	}

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
	public List<EventMonitor> findByU_ET(long userId, String eventType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_ET;
			finderArgs = new Object[] { userId, eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_ET;
			finderArgs = new Object[] {
					userId, eventType,
					
					start, end, orderByComparator
				};
		}

		List<EventMonitor> list = (List<EventMonitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventMonitor eventMonitor : list) {
				if ((userId != eventMonitor.getUserId()) ||
						!Validator.equals(eventType, eventMonitor.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EVENTMONITOR_WHERE);

			query.append(_FINDER_COLUMN_U_ET_USERID_2);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EventMonitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (eventType != null) {
					qPos.add(eventType);
				}

				list = (List<EventMonitor>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public EventMonitor findByU_ET_First(long userId, String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = fetchByU_ET_First(userId, eventType,
				orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventMonitorException(msg.toString());
	}

	/**
	 * Returns the first event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor fetchByU_ET_First(long userId, String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventMonitor> list = findByU_ET(userId, eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public EventMonitor findByU_ET_Last(long userId, String eventType,
		OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = fetchByU_ET_Last(userId, eventType,
				orderByComparator);

		if (eventMonitor != null) {
			return eventMonitor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventMonitorException(msg.toString());
	}

	/**
	 * Returns the last event monitor in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EventMonitor fetchByU_ET_Last(long userId, String eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByU_ET(userId, eventType);

		List<EventMonitor> list = findByU_ET(userId, eventType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public EventMonitor[] findByU_ET_PrevAndNext(long eventMonitorId,
		long userId, String eventType, OrderByComparator orderByComparator)
		throws NoSuchEventMonitorException, SystemException {
		EventMonitor eventMonitor = findByPrimaryKey(eventMonitorId);

		Session session = null;

		try {
			session = openSession();

			EventMonitor[] array = new EventMonitorImpl[3];

			array[0] = getByU_ET_PrevAndNext(session, eventMonitor, userId,
					eventType, orderByComparator, true);

			array[1] = eventMonitor;

			array[2] = getByU_ET_PrevAndNext(session, eventMonitor, userId,
					eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventMonitor getByU_ET_PrevAndNext(Session session,
		EventMonitor eventMonitor, long userId, String eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTMONITOR_WHERE);

		query.append(_FINDER_COLUMN_U_ET_USERID_2);

		if (eventType == null) {
			query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_1);
		}
		else {
			if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EventMonitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (eventType != null) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventMonitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventMonitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the event monitors.
	 *
	 * @return the event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public List<EventMonitor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<EventMonitor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<EventMonitor> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EventMonitor> list = (List<EventMonitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTMONITOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTMONITOR.concat(EventMonitorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EventMonitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EventMonitor>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the event monitors where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (EventMonitor eventMonitor : findByUserId(userId)) {
			remove(eventMonitor);
		}
	}

	/**
	 * Removes all the event monitors where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEventType(String eventType) throws SystemException {
		for (EventMonitor eventMonitor : findByEventType(eventType)) {
			remove(eventMonitor);
		}
	}

	/**
	 * Removes all the event monitors where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_ET(long userId, String eventType)
		throws SystemException {
		for (EventMonitor eventMonitor : findByU_ET(userId, eventType)) {
			remove(eventMonitor);
		}
	}

	/**
	 * Removes all the event monitors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EventMonitor eventMonitor : findAll()) {
			remove(eventMonitor);
		}
	}

	/**
	 * Returns the number of event monitors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTMONITOR_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEventType(String eventType) throws SystemException {
		Object[] finderArgs = new Object[] { eventType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTMONITOR_WHERE);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (eventType != null) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event monitors where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_ET(long userId, String eventType)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, eventType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_ET,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTMONITOR_WHERE);

			query.append(_FINDER_COLUMN_U_ET_USERID_2);

			if (eventType == null) {
				query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_1);
			}
			else {
				if (eventType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_ET_EVENTTYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (eventType != null) {
					qPos.add(eventType);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_ET,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of event monitors.
	 *
	 * @return the number of event monitors
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTMONITOR);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the event monitor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.amf.registration.model.EventMonitor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventMonitor>> listenersList = new ArrayList<ModelListener<EventMonitor>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<EventMonitor>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EventMonitorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = EventMonitorPersistence.class)
	protected EventMonitorPersistence eventMonitorPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EVENTMONITOR = "SELECT eventMonitor FROM EventMonitor eventMonitor";
	private static final String _SQL_SELECT_EVENTMONITOR_WHERE = "SELECT eventMonitor FROM EventMonitor eventMonitor WHERE ";
	private static final String _SQL_COUNT_EVENTMONITOR = "SELECT COUNT(eventMonitor) FROM EventMonitor eventMonitor";
	private static final String _SQL_COUNT_EVENTMONITOR_WHERE = "SELECT COUNT(eventMonitor) FROM EventMonitor eventMonitor WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "eventMonitor.userId = ?";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1 = "eventMonitor.eventType IS NULL";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 = "eventMonitor.eventType = ?";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 = "(eventMonitor.eventType IS NULL OR eventMonitor.eventType = ?)";
	private static final String _FINDER_COLUMN_U_ET_USERID_2 = "eventMonitor.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_ET_EVENTTYPE_1 = "eventMonitor.eventType IS NULL";
	private static final String _FINDER_COLUMN_U_ET_EVENTTYPE_2 = "eventMonitor.eventType = ?";
	private static final String _FINDER_COLUMN_U_ET_EVENTTYPE_3 = "(eventMonitor.eventType IS NULL OR eventMonitor.eventType = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventMonitor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventMonitor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventMonitor exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventMonitorPersistenceImpl.class);
	private static EventMonitor _nullEventMonitor = new EventMonitorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventMonitor> toCacheModel() {
				return _nullEventMonitorCacheModel;
			}
		};

	private static CacheModel<EventMonitor> _nullEventMonitorCacheModel = new CacheModel<EventMonitor>() {
			public EventMonitor toEntityModel() {
				return _nullEventMonitor;
			}
		};
}