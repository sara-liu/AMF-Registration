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

package com.amf.registration.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author    Sara Liu
 * @see       Address
 * @generated
 */
public class AddressWrapper implements Address, ModelWrapper<Address> {
	public AddressWrapper(Address address) {
		_address = address;
	}

	public Class<?> getModelClass() {
		return Address.class;
	}

	public String getModelClassName() {
		return Address.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("addressId", getAddressId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zip", getZip());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}
	}

	/**
	* Returns the primary key of this address.
	*
	* @return the primary key of this address
	*/
	public long getPrimaryKey() {
		return _address.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address.
	*
	* @param primaryKey the primary key of this address
	*/
	public void setPrimaryKey(long primaryKey) {
		_address.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this address.
	*
	* @return the uuid of this address
	*/
	public java.lang.String getUuid() {
		return _address.getUuid();
	}

	/**
	* Sets the uuid of this address.
	*
	* @param uuid the uuid of this address
	*/
	public void setUuid(java.lang.String uuid) {
		_address.setUuid(uuid);
	}

	/**
	* Returns the address ID of this address.
	*
	* @return the address ID of this address
	*/
	public long getAddressId() {
		return _address.getAddressId();
	}

	/**
	* Sets the address ID of this address.
	*
	* @param addressId the address ID of this address
	*/
	public void setAddressId(long addressId) {
		_address.setAddressId(addressId);
	}

	/**
	* Returns the company ID of this address.
	*
	* @return the company ID of this address
	*/
	public long getCompanyId() {
		return _address.getCompanyId();
	}

	/**
	* Sets the company ID of this address.
	*
	* @param companyId the company ID of this address
	*/
	public void setCompanyId(long companyId) {
		_address.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this address.
	*
	* @return the user ID of this address
	*/
	public long getUserId() {
		return _address.getUserId();
	}

	/**
	* Sets the user ID of this address.
	*
	* @param userId the user ID of this address
	*/
	public void setUserId(long userId) {
		_address.setUserId(userId);
	}

	/**
	* Returns the user uuid of this address.
	*
	* @return the user uuid of this address
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _address.getUserUuid();
	}

	/**
	* Sets the user uuid of this address.
	*
	* @param userUuid the user uuid of this address
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_address.setUserUuid(userUuid);
	}

	/**
	* Returns the address1 of this address.
	*
	* @return the address1 of this address
	*/
	public java.lang.String getAddress1() {
		return _address.getAddress1();
	}

	/**
	* Sets the address1 of this address.
	*
	* @param address1 the address1 of this address
	*/
	public void setAddress1(java.lang.String address1) {
		_address.setAddress1(address1);
	}

	/**
	* Returns the address2 of this address.
	*
	* @return the address2 of this address
	*/
	public java.lang.String getAddress2() {
		return _address.getAddress2();
	}

	/**
	* Sets the address2 of this address.
	*
	* @param address2 the address2 of this address
	*/
	public void setAddress2(java.lang.String address2) {
		_address.setAddress2(address2);
	}

	/**
	* Returns the city of this address.
	*
	* @return the city of this address
	*/
	public java.lang.String getCity() {
		return _address.getCity();
	}

	/**
	* Sets the city of this address.
	*
	* @param city the city of this address
	*/
	public void setCity(java.lang.String city) {
		_address.setCity(city);
	}

	/**
	* Returns the state of this address.
	*
	* @return the state of this address
	*/
	public java.lang.String getState() {
		return _address.getState();
	}

	/**
	* Sets the state of this address.
	*
	* @param state the state of this address
	*/
	public void setState(java.lang.String state) {
		_address.setState(state);
	}

	/**
	* Returns the zip of this address.
	*
	* @return the zip of this address
	*/
	public java.lang.String getZip() {
		return _address.getZip();
	}

	/**
	* Sets the zip of this address.
	*
	* @param zip the zip of this address
	*/
	public void setZip(java.lang.String zip) {
		_address.setZip(zip);
	}

	public boolean isNew() {
		return _address.isNew();
	}

	public void setNew(boolean n) {
		_address.setNew(n);
	}

	public boolean isCachedModel() {
		return _address.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_address.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _address.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _address.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_address.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _address.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_address.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressWrapper((Address)_address.clone());
	}

	public int compareTo(com.amf.registration.model.Address address) {
		return _address.compareTo(address);
	}

	@Override
	public int hashCode() {
		return _address.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.amf.registration.model.Address> toCacheModel() {
		return _address.toCacheModel();
	}

	public com.amf.registration.model.Address toEscapedModel() {
		return new AddressWrapper(_address.toEscapedModel());
	}

	public com.amf.registration.model.Address toUnescapedModel() {
		return new AddressWrapper(_address.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _address.toString();
	}

	public java.lang.String toXmlString() {
		return _address.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_address.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressWrapper)) {
			return false;
		}

		AddressWrapper addressWrapper = (AddressWrapper)obj;

		if (Validator.equals(_address, addressWrapper._address)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Address getWrappedAddress() {
		return _address;
	}

	public Address getWrappedModel() {
		return _address;
	}

	public void resetOriginalValues() {
		_address.resetOriginalValues();
	}

	private Address _address;
}