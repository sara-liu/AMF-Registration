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

import com.amf.registration.model.AMFUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the a m f user service. This utility wraps {@link AMFUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see AMFUserPersistence
 * @see AMFUserPersistenceImpl
 * @generated
 */
public class AMFUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AMFUser amfUser) {
		getPersistence().clearCache(amfUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFUser> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AMFUser update(AMFUser amfUser, boolean merge)
		throws SystemException {
		return getPersistence().update(amfUser, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AMFUser update(AMFUser amfUser, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(amfUser, merge, serviceContext);
	}

	/**
	* Caches the a m f user in the entity cache if it is enabled.
	*
	* @param amfUser the a m f user
	*/
	public static void cacheResult(com.amf.registration.model.AMFUser amfUser) {
		getPersistence().cacheResult(amfUser);
	}

	/**
	* Caches the a m f users in the entity cache if it is enabled.
	*
	* @param amfUsers the a m f users
	*/
	public static void cacheResult(
		java.util.List<com.amf.registration.model.AMFUser> amfUsers) {
		getPersistence().cacheResult(amfUsers);
	}

	/**
	* Creates a new a m f user with the primary key. Does not add the a m f user to the database.
	*
	* @param userId the primary key for the new a m f user
	* @return the new a m f user
	*/
	public static com.amf.registration.model.AMFUser create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the a m f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user that was removed
	* @throws com.amf.registration.NoSuchAMFUserException if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser remove(long userId)
		throws com.amf.registration.NoSuchAMFUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userId);
	}

	public static com.amf.registration.model.AMFUser updateImpl(
		com.amf.registration.model.AMFUser amfUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(amfUser, merge);
	}

	/**
	* Returns the a m f user with the primary key or throws a {@link com.amf.registration.NoSuchAMFUserException} if it could not be found.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user
	* @throws com.amf.registration.NoSuchAMFUserException if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser findByPrimaryKey(
		long userId)
		throws com.amf.registration.NoSuchAMFUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the a m f user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user, or <code>null</code> if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the a m f users.
	*
	* @return the a m f users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.AMFUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.amf.registration.model.AMFUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.amf.registration.model.AMFUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the a m f users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of a m f users.
	*
	* @return the number of a m f users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AMFUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AMFUserPersistence)PortletBeanLocatorUtil.locate(com.amf.registration.service.ClpSerializer.getServletContextName(),
					AMFUserPersistence.class.getName());

			ReferenceRegistry.registerReference(AMFUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AMFUserPersistence persistence) {
	}

	private static AMFUserPersistence _persistence;
}