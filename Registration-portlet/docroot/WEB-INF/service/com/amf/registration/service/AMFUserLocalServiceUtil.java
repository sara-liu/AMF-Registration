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

package com.amf.registration.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the a m f user local service. This utility wraps {@link com.amf.registration.service.impl.AMFUserLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sara Liu
 * @see AMFUserLocalService
 * @see com.amf.registration.service.base.AMFUserLocalServiceBaseImpl
 * @see com.amf.registration.service.impl.AMFUserLocalServiceImpl
 * @generated
 */
public class AMFUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.amf.registration.service.impl.AMFUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the a m f user to the database. Also notifies the appropriate model listeners.
	*
	* @param amfUser the a m f user
	* @return the a m f user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser addAMFUser(
		com.amf.registration.model.AMFUser amfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAMFUser(amfUser);
	}

	/**
	* Creates a new a m f user with the primary key. Does not add the a m f user to the database.
	*
	* @param userId the primary key for the new a m f user
	* @return the new a m f user
	*/
	public static com.amf.registration.model.AMFUser createAMFUser(long userId) {
		return getService().createAMFUser(userId);
	}

	/**
	* Deletes the a m f user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user that was removed
	* @throws PortalException if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser deleteAMFUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAMFUser(userId);
	}

	/**
	* Deletes the a m f user from the database. Also notifies the appropriate model listeners.
	*
	* @param amfUser the a m f user
	* @return the a m f user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser deleteAMFUser(
		com.amf.registration.model.AMFUser amfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAMFUser(amfUser);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.amf.registration.model.AMFUser fetchAMFUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAMFUser(userId);
	}

	/**
	* Returns the a m f user with the primary key.
	*
	* @param userId the primary key of the a m f user
	* @return the a m f user
	* @throws PortalException if a a m f user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser getAMFUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAMFUser(userId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.amf.registration.model.AMFUser> getAMFUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAMFUsers(start, end);
	}

	/**
	* Returns the number of a m f users.
	*
	* @return the number of a m f users
	* @throws SystemException if a system exception occurred
	*/
	public static int getAMFUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAMFUsersCount();
	}

	/**
	* Updates the a m f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param amfUser the a m f user
	* @return the a m f user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser updateAMFUser(
		com.amf.registration.model.AMFUser amfUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAMFUser(amfUser);
	}

	/**
	* Updates the a m f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param amfUser the a m f user
	* @param merge whether to merge the a m f user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the a m f user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.AMFUser updateAMFUser(
		com.amf.registration.model.AMFUser amfUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAMFUser(amfUser, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.amf.registration.service.AMFUserLocalServiceUtil} to access the a m f user local service.
	*/
	public static int countByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByZip(zip);
	}

	public static java.util.List<com.liferay.portal.model.User> findByZip(
		java.lang.String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByZip(zip, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static AMFUserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AMFUserLocalService.class.getName());

			if (invokableLocalService instanceof AMFUserLocalService) {
				_service = (AMFUserLocalService)invokableLocalService;
			}
			else {
				_service = new AMFUserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AMFUserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AMFUserLocalService service) {
	}

	private static AMFUserLocalService _service;
}