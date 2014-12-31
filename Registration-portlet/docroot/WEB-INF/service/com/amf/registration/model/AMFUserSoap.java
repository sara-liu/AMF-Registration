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
public class AMFUserSoap implements Serializable {
	public static AMFUserSoap toSoapModel(AMFUser model) {
		AMFUserSoap soapModel = new AMFUserSoap();

		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static AMFUserSoap[] toSoapModels(AMFUser[] models) {
		AMFUserSoap[] soapModels = new AMFUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFUserSoap[][] toSoapModels(AMFUser[][] models) {
		AMFUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFUserSoap[] toSoapModels(List<AMFUser> models) {
		List<AMFUserSoap> soapModels = new ArrayList<AMFUserSoap>(models.size());

		for (AMFUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFUserSoap[soapModels.size()]);
	}

	public AMFUserSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _userId;
}