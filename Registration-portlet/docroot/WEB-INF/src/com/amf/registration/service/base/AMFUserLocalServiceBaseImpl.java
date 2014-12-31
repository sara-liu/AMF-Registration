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

package com.amf.registration.service.base;

import com.amf.registration.model.AMFUser;
import com.amf.registration.service.AMFUserLocalService;
import com.amf.registration.service.EventMonitorLocalService;
import com.amf.registration.service.persistence.AMFUserFinder;
import com.amf.registration.service.persistence.AMFUserPersistence;
import com.amf.registration.service.persistence.EventMonitorPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the a m f user local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.amf.registration.service.impl.AMFUserLocalServiceImpl}.
 * </p>
 *
 * @author Sara Liu
 * @see com.amf.registration.service.impl.AMFUserLocalServiceImpl
 * @see com.amf.registration.service.AMFUserLocalServiceUtil
 * @generated
 */
public abstract class AMFUserLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements AMFUserLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.amf.registration.service.AMFUserLocalServiceUtil} to access the a m f user local service.
	 */

	/**
	 * Adds the a m f user to the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the a m f user
	 * @return the a m f user that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AMFUser addAMFUser(AMFUser amfUser) throws SystemException {
		amfUser.setNew(true);

		return amfUserPersistence.update(amfUser, false);
	}

	/**
	 * Creates a new a m f user with the primary key. Does not add the a m f user to the database.
	 *
	 * @param userId the primary key for the new a m f user
	 * @return the new a m f user
	 */
	public AMFUser createAMFUser(long userId) {
		return amfUserPersistence.create(userId);
	}

	/**
	 * Deletes the a m f user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the a m f user
	 * @return the a m f user that was removed
	 * @throws PortalException if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public AMFUser deleteAMFUser(long userId)
		throws PortalException, SystemException {
		return amfUserPersistence.remove(userId);
	}

	/**
	 * Deletes the a m f user from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the a m f user
	 * @return the a m f user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public AMFUser deleteAMFUser(AMFUser amfUser) throws SystemException {
		return amfUserPersistence.remove(amfUser);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AMFUser.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return amfUserPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return amfUserPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return amfUserPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return amfUserPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public AMFUser fetchAMFUser(long userId) throws SystemException {
		return amfUserPersistence.fetchByPrimaryKey(userId);
	}

	/**
	 * Returns the a m f user with the primary key.
	 *
	 * @param userId the primary key of the a m f user
	 * @return the a m f user
	 * @throws PortalException if a a m f user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AMFUser getAMFUser(long userId)
		throws PortalException, SystemException {
		return amfUserPersistence.findByPrimaryKey(userId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return amfUserPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<AMFUser> getAMFUsers(int start, int end)
		throws SystemException {
		return amfUserPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of a m f users.
	 *
	 * @return the number of a m f users
	 * @throws SystemException if a system exception occurred
	 */
	public int getAMFUsersCount() throws SystemException {
		return amfUserPersistence.countAll();
	}

	/**
	 * Updates the a m f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the a m f user
	 * @return the a m f user that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AMFUser updateAMFUser(AMFUser amfUser) throws SystemException {
		return updateAMFUser(amfUser, true);
	}

	/**
	 * Updates the a m f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amfUser the a m f user
	 * @param merge whether to merge the a m f user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the a m f user that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AMFUser updateAMFUser(AMFUser amfUser, boolean merge)
		throws SystemException {
		amfUser.setNew(false);

		return amfUserPersistence.update(amfUser, merge);
	}

	/**
	 * Returns the a m f user local service.
	 *
	 * @return the a m f user local service
	 */
	public AMFUserLocalService getAMFUserLocalService() {
		return amfUserLocalService;
	}

	/**
	 * Sets the a m f user local service.
	 *
	 * @param amfUserLocalService the a m f user local service
	 */
	public void setAMFUserLocalService(AMFUserLocalService amfUserLocalService) {
		this.amfUserLocalService = amfUserLocalService;
	}

	/**
	 * Returns the a m f user persistence.
	 *
	 * @return the a m f user persistence
	 */
	public AMFUserPersistence getAMFUserPersistence() {
		return amfUserPersistence;
	}

	/**
	 * Sets the a m f user persistence.
	 *
	 * @param amfUserPersistence the a m f user persistence
	 */
	public void setAMFUserPersistence(AMFUserPersistence amfUserPersistence) {
		this.amfUserPersistence = amfUserPersistence;
	}

	/**
	 * Returns the a m f user finder.
	 *
	 * @return the a m f user finder
	 */
	public AMFUserFinder getAMFUserFinder() {
		return amfUserFinder;
	}

	/**
	 * Sets the a m f user finder.
	 *
	 * @param amfUserFinder the a m f user finder
	 */
	public void setAMFUserFinder(AMFUserFinder amfUserFinder) {
		this.amfUserFinder = amfUserFinder;
	}

	/**
	 * Returns the event monitor local service.
	 *
	 * @return the event monitor local service
	 */
	public EventMonitorLocalService getEventMonitorLocalService() {
		return eventMonitorLocalService;
	}

	/**
	 * Sets the event monitor local service.
	 *
	 * @param eventMonitorLocalService the event monitor local service
	 */
	public void setEventMonitorLocalService(
		EventMonitorLocalService eventMonitorLocalService) {
		this.eventMonitorLocalService = eventMonitorLocalService;
	}

	/**
	 * Returns the event monitor persistence.
	 *
	 * @return the event monitor persistence
	 */
	public EventMonitorPersistence getEventMonitorPersistence() {
		return eventMonitorPersistence;
	}

	/**
	 * Sets the event monitor persistence.
	 *
	 * @param eventMonitorPersistence the event monitor persistence
	 */
	public void setEventMonitorPersistence(
		EventMonitorPersistence eventMonitorPersistence) {
		this.eventMonitorPersistence = eventMonitorPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.amf.registration.model.AMFUser",
			amfUserLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.amf.registration.model.AMFUser");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return AMFUser.class;
	}

	protected String getModelClassName() {
		return AMFUser.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = amfUserPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AMFUserLocalService.class)
	protected AMFUserLocalService amfUserLocalService;
	@BeanReference(type = AMFUserPersistence.class)
	protected AMFUserPersistence amfUserPersistence;
	@BeanReference(type = AMFUserFinder.class)
	protected AMFUserFinder amfUserFinder;
	@BeanReference(type = EventMonitorLocalService.class)
	protected EventMonitorLocalService eventMonitorLocalService;
	@BeanReference(type = EventMonitorPersistence.class)
	protected EventMonitorPersistence eventMonitorPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private AMFUserLocalServiceClpInvoker _clpInvoker = new AMFUserLocalServiceClpInvoker();
}