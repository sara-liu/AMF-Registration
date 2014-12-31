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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the a m f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see AMFUserPersistenceImpl
 * @see AMFUserUtil
 * @generated
 */
public interface AMFUserPersistence extends BasePersistence<AMFUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFUserUtil} to access the a m f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the a m f user in the entity cache if it is enabled.
	*
	* @param amfUser the a m f user
	*/
	public void cacheResult(com.amf.registration.model.AMFUser amfUser);

	/**
	* Caches the a m f users in the entity cache if it is enabled.
	*
	* @param amfUsers the a m f users
	*/
	public void cacheResult(
		java.util.List<com.amf.registration.model.AMFUser> amfUsers);

	/**
	* Creates a new a m f user with the primary key. Does not add the a m f user to the database.
	*
	* @param userId the primary key for the new a m f user
	* @return the new a m f user
	*/
	public com.amf.registration.model.AMFUser create(long userId);

	/**
	* Removes the a m f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user that was removed
	* @throws com.amf.registration.NoSuchAMFUserException if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.AMFUser remove(long userId)
		throws com.amf.registration.NoSuchAMFUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.amf.registration.model.AMFUser updateImpl(
		com.amf.registration.model.AMFUser amfUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a m f user with the primary key or throws a {@link com.amf.registration.NoSuchAMFUserException} if it could not be found.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user
	* @throws com.amf.registration.NoSuchAMFUserException if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.AMFUser findByPrimaryKey(long userId)
		throws com.amf.registration.NoSuchAMFUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a m f user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user, or <code>null</code> if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.AMFUser fetchByPrimaryKey(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the a m f users.
	*
	* @return the a m f users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.AMFUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.amf.registration.model.AMFUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.amf.registration.model.AMFUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the a m f users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a m f users.
	*
	* @return the number of a m f users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}