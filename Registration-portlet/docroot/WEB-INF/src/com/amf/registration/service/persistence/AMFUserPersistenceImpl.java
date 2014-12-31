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

import com.amf.registration.NoSuchAMFUserException;
import com.amf.registration.model.AMFUser;
import com.amf.registration.model.impl.AMFUserImpl;
import com.amf.registration.model.impl.AMFUserModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the a m f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see AMFUserPersistence
 * @see AMFUserUtil
 * @generated
 */
public class AMFUserPersistenceImpl extends BasePersistenceImpl<AMFUser>
	implements AMFUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AMFUserUtil} to access the a m f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AMFUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
			AMFUserModelImpl.FINDER_CACHE_ENABLED, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
			AMFUserModelImpl.FINDER_CACHE_ENABLED, AMFUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
			AMFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the a m f user in the entity cache if it is enabled.
	 *
	 * @param amfUser the a m f user
	 */
	public void cacheResult(AMFUser amfUser) {
		EntityCacheUtil.putResult(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
			AMFUserImpl.class, amfUser.getPrimaryKey(), amfUser);

		amfUser.resetOriginalValues();
	}

	/**
	 * Caches the a m f users in the entity cache if it is enabled.
	 *
	 * @param amfUsers the a m f users
	 */
	public void cacheResult(List<AMFUser> amfUsers) {
		for (AMFUser amfUser : amfUsers) {
			if (EntityCacheUtil.getResult(
						AMFUserModelImpl.ENTITY_CACHE_ENABLED,
						AMFUserImpl.class, amfUser.getPrimaryKey()) == null) {
				cacheResult(amfUser);
			}
			else {
				amfUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a m f users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AMFUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AMFUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a m f user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMFUser amfUser) {
		EntityCacheUtil.removeResult(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
			AMFUserImpl.class, amfUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AMFUser> amfUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMFUser amfUser : amfUsers) {
			EntityCacheUtil.removeResult(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
				AMFUserImpl.class, amfUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a m f user with the primary key. Does not add the a m f user to the database.
	 *
	 * @param userId the primary key for the new a m f user
	 * @return the new a m f user
	 */
	public AMFUser create(long userId) {
		AMFUser amfUser = new AMFUserImpl();

		amfUser.setNew(true);
		amfUser.setPrimaryKey(userId);

		return amfUser;
	}

	/**
	 * Removes the a m f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the a m f user
	 * @return the a m f user that was removed
	 * @throws com.amf.registration.NoSuchAMFUserException if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AMFUser remove(long userId)
		throws NoSuchAMFUserException, SystemException {
		return remove(Long.valueOf(userId));
	}

	/**
	 * Removes the a m f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a m f user
	 * @return the a m f user that was removed
	 * @throws com.amf.registration.NoSuchAMFUserException if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AMFUser remove(Serializable primaryKey)
		throws NoSuchAMFUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AMFUser amfUser = (AMFUser)session.get(AMFUserImpl.class, primaryKey);

			if (amfUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAMFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(amfUser);
		}
		catch (NoSuchAMFUserException nsee) {
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
	protected AMFUser removeImpl(AMFUser amfUser) throws SystemException {
		amfUser = toUnwrappedModel(amfUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, amfUser);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(amfUser);

		return amfUser;
	}

	@Override
	public AMFUser updateImpl(com.amf.registration.model.AMFUser amfUser,
		boolean merge) throws SystemException {
		amfUser = toUnwrappedModel(amfUser);

		boolean isNew = amfUser.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, amfUser, merge);

			amfUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
			AMFUserImpl.class, amfUser.getPrimaryKey(), amfUser);

		return amfUser;
	}

	protected AMFUser toUnwrappedModel(AMFUser amfUser) {
		if (amfUser instanceof AMFUserImpl) {
			return amfUser;
		}

		AMFUserImpl amfUserImpl = new AMFUserImpl();

		amfUserImpl.setNew(amfUser.isNew());
		amfUserImpl.setPrimaryKey(amfUser.getPrimaryKey());

		amfUserImpl.setUserId(amfUser.getUserId());

		return amfUserImpl;
	}

	/**
	 * Returns the a m f user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a m f user
	 * @return the a m f user
	 * @throws com.liferay.portal.NoSuchModelException if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AMFUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the a m f user with the primary key or throws a {@link com.amf.registration.NoSuchAMFUserException} if it could not be found.
	 *
	 * @param userId the primary key of the a m f user
	 * @return the a m f user
	 * @throws com.amf.registration.NoSuchAMFUserException if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AMFUser findByPrimaryKey(long userId)
		throws NoSuchAMFUserException, SystemException {
		AMFUser amfUser = fetchByPrimaryKey(userId);

		if (amfUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userId);
			}

			throw new NoSuchAMFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userId);
		}

		return amfUser;
	}

	/**
	 * Returns the a m f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a m f user
	 * @return the a m f user, or <code>null</code> if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AMFUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the a m f user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the a m f user
	 * @return the a m f user, or <code>null</code> if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AMFUser fetchByPrimaryKey(long userId) throws SystemException {
		AMFUser amfUser = (AMFUser)EntityCacheUtil.getResult(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
				AMFUserImpl.class, userId);

		if (amfUser == _nullAMFUser) {
			return null;
		}

		if (amfUser == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				amfUser = (AMFUser)session.get(AMFUserImpl.class,
						Long.valueOf(userId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (amfUser != null) {
					cacheResult(amfUser);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AMFUserModelImpl.ENTITY_CACHE_ENABLED,
						AMFUserImpl.class, userId, _nullAMFUser);
				}

				closeSession(session);
			}
		}

		return amfUser;
	}

	/**
	 * Returns all the a m f users.
	 *
	 * @return the a m f users
	 * @throws SystemException if a system exception occurred
	 */
	public List<AMFUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a m f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of a m f users
	 * @param end the upper bound of the range of a m f users (not inclusive)
	 * @return the range of a m f users
	 * @throws SystemException if a system exception occurred
	 */
	public List<AMFUser> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a m f users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of a m f users
	 * @param end the upper bound of the range of a m f users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a m f users
	 * @throws SystemException if a system exception occurred
	 */
	public List<AMFUser> findAll(int start, int end,
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

		List<AMFUser> list = (List<AMFUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AMFUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMFUSER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AMFUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AMFUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the a m f users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AMFUser amfUser : findAll()) {
			remove(amfUser);
		}
	}

	/**
	 * Returns the number of a m f users.
	 *
	 * @return the number of a m f users
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMFUSER);

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
	 * Initializes the a m f user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.amf.registration.model.AMFUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AMFUser>> listenersList = new ArrayList<ModelListener<AMFUser>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<AMFUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AMFUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AMFUserPersistence.class)
	protected AMFUserPersistence amfUserPersistence;
	@BeanReference(type = EventMonitorPersistence.class)
	protected EventMonitorPersistence eventMonitorPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_AMFUSER = "SELECT amfUser FROM AMFUser amfUser";
	private static final String _SQL_COUNT_AMFUSER = "SELECT COUNT(amfUser) FROM AMFUser amfUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "amfUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AMFUser exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AMFUserPersistenceImpl.class);
	private static AMFUser _nullAMFUser = new AMFUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AMFUser> toCacheModel() {
				return _nullAMFUserCacheModel;
			}
		};

	private static CacheModel<AMFUser> _nullAMFUserCacheModel = new CacheModel<AMFUser>() {
			public AMFUser toEntityModel() {
				return _nullAMFUser;
			}
		};
}