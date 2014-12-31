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
 * This class is a wrapper for {@link AMFUser}.
 * </p>
 *
 * @author    Sara Liu
 * @see       AMFUser
 * @generated
 */
public class AMFUserWrapper implements AMFUser, ModelWrapper<AMFUser> {
	public AMFUserWrapper(AMFUser amfUser) {
		_amfUser = amfUser;
	}

	public Class<?> getModelClass() {
		return AMFUser.class;
	}

	public String getModelClassName() {
		return AMFUser.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this a m f user.
	*
	* @return the primary key of this a m f user
	*/
	public long getPrimaryKey() {
		return _amfUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this a m f user.
	*
	* @param primaryKey the primary key of this a m f user
	*/
	public void setPrimaryKey(long primaryKey) {
		_amfUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this a m f user.
	*
	* @return the user ID of this a m f user
	*/
	public long getUserId() {
		return _amfUser.getUserId();
	}

	/**
	* Sets the user ID of this a m f user.
	*
	* @param userId the user ID of this a m f user
	*/
	public void setUserId(long userId) {
		_amfUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this a m f user.
	*
	* @return the user uuid of this a m f user
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _amfUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this a m f user.
	*
	* @param userUuid the user uuid of this a m f user
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_amfUser.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _amfUser.isNew();
	}

	public void setNew(boolean n) {
		_amfUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _amfUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_amfUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _amfUser.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _amfUser.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_amfUser.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _amfUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_amfUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AMFUserWrapper((AMFUser)_amfUser.clone());
	}

	public int compareTo(com.amf.registration.model.AMFUser amfUser) {
		return _amfUser.compareTo(amfUser);
	}

	@Override
	public int hashCode() {
		return _amfUser.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.amf.registration.model.AMFUser> toCacheModel() {
		return _amfUser.toCacheModel();
	}

	public com.amf.registration.model.AMFUser toEscapedModel() {
		return new AMFUserWrapper(_amfUser.toEscapedModel());
	}

	public com.amf.registration.model.AMFUser toUnescapedModel() {
		return new AMFUserWrapper(_amfUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _amfUser.toString();
	}

	public java.lang.String toXmlString() {
		return _amfUser.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_amfUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFUserWrapper)) {
			return false;
		}

		AMFUserWrapper amfUserWrapper = (AMFUserWrapper)obj;

		if (Validator.equals(_amfUser, amfUserWrapper._amfUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AMFUser getWrappedAMFUser() {
		return _amfUser;
	}

	public AMFUser getWrappedModel() {
		return _amfUser;
	}

	public void resetOriginalValues() {
		_amfUser.resetOriginalValues();
	}

	private AMFUser _amfUser;
}