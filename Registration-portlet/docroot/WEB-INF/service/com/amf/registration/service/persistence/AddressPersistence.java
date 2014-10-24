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

import com.amf.registration.model.Address;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see AddressPersistenceImpl
 * @see AddressUtil
 * @generated
 */
public interface AddressPersistence extends BasePersistence<Address> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressUtil} to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the address in the entity cache if it is enabled.
	*
	* @param address the address
	*/
	public void cacheResult(com.amf.registration.model.Address address);

	/**
	* Caches the addresses in the entity cache if it is enabled.
	*
	* @param addresses the addresses
	*/
	public void cacheResult(
		java.util.List<com.amf.registration.model.Address> addresses);

	/**
	* Creates a new address with the primary key. Does not add the address to the database.
	*
	* @param addressId the primary key for the new address
	* @return the new address
	*/
	public com.amf.registration.model.Address create(long addressId);

	/**
	* Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the address
	* @return the address that was removed
	* @throws com.amf.registration.NoSuchAddressException if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address remove(long addressId)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.amf.registration.model.Address updateImpl(
		com.amf.registration.model.Address address, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address with the primary key or throws a {@link com.amf.registration.NoSuchAddressException} if it could not be found.
	*
	* @param addressId the primary key of the address
	* @return the address
	* @throws com.amf.registration.NoSuchAddressException if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address findByPrimaryKey(long addressId)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressId the primary key of the address
	* @return the address, or <code>null</code> if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address fetchByPrimaryKey(long addressId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the addresses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @return the range of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the addresses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the addresses before and after the current address in the ordered set where uuid = &#63;.
	*
	* @param addressId the primary key of the current address
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address
	* @throws com.amf.registration.NoSuchAddressException if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address[] findByUuid_PrevAndNext(
		long addressId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the addresses where zip = &#63;.
	*
	* @param zip the zip
	* @return the matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findByZip(
		java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the addresses where zip = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param zip the zip
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @return the range of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findByZip(
		java.lang.String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the addresses where zip = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param zip the zip
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findByZip(
		java.lang.String zip, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address findByZip_First(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address fetchByZip_First(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address findByZip_Last(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address fetchByZip_Last(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the addresses before and after the current address in the ordered set where zip = &#63;.
	*
	* @param addressId the primary key of the current address
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next address
	* @throws com.amf.registration.NoSuchAddressException if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.Address[] findByZip_PrevAndNext(
		long addressId, java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the addresses.
	*
	* @return the addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @return the range of addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of addresses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the addresses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the addresses where zip = &#63; from the database.
	*
	* @param zip the zip
	* @throws SystemException if a system exception occurred
	*/
	public void removeByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the addresses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of addresses where zip = &#63;.
	*
	* @param zip the zip
	* @return the number of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of addresses.
	*
	* @return the number of addresses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}