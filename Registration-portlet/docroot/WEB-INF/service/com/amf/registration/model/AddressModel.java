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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Address service. Represents a row in the &quot;Registration_Address&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.amf.registration.model.impl.AddressModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.amf.registration.model.impl.AddressImpl}.
 * </p>
 *
 * @author Sara Liu
 * @see Address
 * @see com.amf.registration.model.impl.AddressImpl
 * @see com.amf.registration.model.impl.AddressModelImpl
 * @generated
 */
public interface AddressModel extends BaseModel<Address> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a address model instance should use the {@link Address} interface instead.
	 */

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this address.
	 *
	 * @return the uuid of this address
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this address.
	 *
	 * @param uuid the uuid of this address
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	public long getAddressId();

	/**
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	public void setAddressId(long addressId);

	/**
	 * Returns the company ID of this address.
	 *
	 * @return the company ID of this address
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this address.
	 *
	 * @param companyId the company ID of this address
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this address.
	 *
	 * @return the user ID of this address
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this address.
	 *
	 * @param userId the user ID of this address
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this address.
	 *
	 * @return the user uuid of this address
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this address.
	 *
	 * @param userUuid the user uuid of this address
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the address1 of this address.
	 *
	 * @return the address1 of this address
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this address.
	 *
	 * @param address1 the address1 of this address
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the address2 of this address.
	 *
	 * @return the address2 of this address
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this address.
	 *
	 * @param address2 the address2 of this address
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the city of this address.
	 *
	 * @return the city of this address
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this address.
	 *
	 * @param city the city of this address
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this address.
	 *
	 * @return the state of this address
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this address.
	 *
	 * @param state the state of this address
	 */
	public void setState(String state);

	/**
	 * Returns the zip of this address.
	 *
	 * @return the zip of this address
	 */
	@AutoEscape
	public String getZip();

	/**
	 * Sets the zip of this address.
	 *
	 * @param zip the zip of this address
	 */
	public void setZip(String zip);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Address address);

	public int hashCode();

	public CacheModel<Address> toCacheModel();

	public Address toEscapedModel();

	public Address toUnescapedModel();

	public String toString();

	public String toXmlString();
}