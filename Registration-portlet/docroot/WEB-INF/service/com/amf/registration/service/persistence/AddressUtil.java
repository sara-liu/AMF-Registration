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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the address service. This utility wraps {@link AddressPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see AddressPersistence
 * @see AddressPersistenceImpl
 * @generated
 */
public class AddressUtil {
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
	public static void clearCache(Address address) {
		getPersistence().clearCache(address);
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
	public static List<Address> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Address> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Address update(Address address, boolean merge)
		throws SystemException {
		return getPersistence().update(address, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Address update(Address address, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(address, merge, serviceContext);
	}

	/**
	* Caches the address in the entity cache if it is enabled.
	*
	* @param address the address
	*/
	public static void cacheResult(com.amf.registration.model.Address address) {
		getPersistence().cacheResult(address);
	}

	/**
	* Caches the addresses in the entity cache if it is enabled.
	*
	* @param addresses the addresses
	*/
	public static void cacheResult(
		java.util.List<com.amf.registration.model.Address> addresses) {
		getPersistence().cacheResult(addresses);
	}

	/**
	* Creates a new address with the primary key. Does not add the address to the database.
	*
	* @param addressId the primary key for the new address
	* @return the new address
	*/
	public static com.amf.registration.model.Address create(long addressId) {
		return getPersistence().create(addressId);
	}

	/**
	* Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the address
	* @return the address that was removed
	* @throws com.amf.registration.NoSuchAddressException if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address remove(long addressId)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(addressId);
	}

	public static com.amf.registration.model.Address updateImpl(
		com.amf.registration.model.Address address, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(address, merge);
	}

	/**
	* Returns the address with the primary key or throws a {@link com.amf.registration.NoSuchAddressException} if it could not be found.
	*
	* @param addressId the primary key of the address
	* @return the address
	* @throws com.amf.registration.NoSuchAddressException if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address findByPrimaryKey(
		long addressId)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(addressId);
	}

	/**
	* Returns the address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressId the primary key of the address
	* @return the address, or <code>null</code> if a address with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address fetchByPrimaryKey(
		long addressId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(addressId);
	}

	/**
	* Returns all the addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.Address> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.amf.registration.model.Address> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.amf.registration.model.Address> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last address in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.amf.registration.model.Address[] findByUuid_PrevAndNext(
		long addressId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(addressId, uuid, orderByComparator);
	}

	/**
	* Returns all the addresses where zip = &#63;.
	*
	* @param zip the zip
	* @return the matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.Address> findByZip(
		java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZip(zip);
	}

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
	public static java.util.List<com.amf.registration.model.Address> findByZip(
		java.lang.String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZip(zip, start, end);
	}

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
	public static java.util.List<com.amf.registration.model.Address> findByZip(
		java.lang.String zip, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZip(zip, start, end, orderByComparator);
	}

	/**
	* Returns the first address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address findByZip_First(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZip_First(zip, orderByComparator);
	}

	/**
	* Returns the first address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address fetchByZip_First(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByZip_First(zip, orderByComparator);
	}

	/**
	* Returns the last address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address
	* @throws com.amf.registration.NoSuchAddressException if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address findByZip_Last(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZip_Last(zip, orderByComparator);
	}

	/**
	* Returns the last address in the ordered set where zip = &#63;.
	*
	* @param zip the zip
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching address, or <code>null</code> if a matching address could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.Address fetchByZip_Last(
		java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByZip_Last(zip, orderByComparator);
	}

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
	public static com.amf.registration.model.Address[] findByZip_PrevAndNext(
		long addressId, java.lang.String zip,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchAddressException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByZip_PrevAndNext(addressId, zip, orderByComparator);
	}

	/**
	* Returns all the addresses.
	*
	* @return the addresses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.Address> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.amf.registration.model.Address> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.amf.registration.model.Address> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the addresses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the addresses where zip = &#63; from the database.
	*
	* @param zip the zip
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByZip(zip);
	}

	/**
	* Removes all the addresses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of addresses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of addresses where zip = &#63;.
	*
	* @param zip the zip
	* @return the number of matching addresses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByZip(zip);
	}

	/**
	* Returns the number of addresses.
	*
	* @return the number of addresses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AddressPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AddressPersistence)PortletBeanLocatorUtil.locate(com.amf.registration.service.ClpSerializer.getServletContextName(),
					AddressPersistence.class.getName());

			ReferenceRegistry.registerReference(AddressUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AddressPersistence persistence) {
	}

	private static AddressPersistence _persistence;
}