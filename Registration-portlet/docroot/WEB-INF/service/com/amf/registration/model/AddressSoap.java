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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Sara Liu
 * @generated
 */
public class AddressSoap implements Serializable {
	public static AddressSoap toSoapModel(Address model) {
		AddressSoap soapModel = new AddressSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZip(model.getZip());

		return soapModel;
	}

	public static AddressSoap[] toSoapModels(Address[] models) {
		AddressSoap[] soapModels = new AddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressSoap[][] toSoapModels(Address[][] models) {
		AddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressSoap[] toSoapModels(List<Address> models) {
		List<AddressSoap> soapModels = new ArrayList<AddressSoap>(models.size());

		for (Address model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressSoap[soapModels.size()]);
	}

	public AddressSoap() {
	}

	public long getPrimaryKey() {
		return _addressId;
	}

	public void setPrimaryKey(long pk) {
		setAddressId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	private String _uuid;
	private long _addressId;
	private long _companyId;
	private long _userId;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
}