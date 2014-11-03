<%--
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
--%>

<%@ include file="/html/init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.amf.registration.RegistrationAddressCityException" %><%@
page import="com.amf.registration.RegistrationAddressException" %><%@
page import="com.amf.registration.RegistrationAddressStateException" %><%@
page import="com.amf.registration.RegistrationAddressZipException" %><%@
page import="com.amf.registration.model.Address" %><%@
page import="com.amf.registration.util.CountryConstants" %>

<%@ page import="com.liferay.portal.ContactBirthdayException" %><%@
page import="com.liferay.portal.ContactFirstNameException" %><%@
page import="com.liferay.portal.ContactLastNameException" %><%@
page import="com.liferay.portal.DuplicateUserEmailAddressException" %><%@
page import="com.liferay.portal.DuplicateUserScreenNameException" %><%@
page import="com.liferay.portal.PhoneNumberException" %><%@
page import="com.liferay.portal.TermsOfUseException" %><%@
page import="com.liferay.portal.UserEmailAddressException" %><%@
page import="com.liferay.portal.UserPasswordException" %><%@
page import="com.liferay.portal.UserReminderQueryException" %><%@
page import="com.liferay.portal.model.Contact" %><%@
page import="com.liferay.portal.model.Country" %><%@
page import="com.liferay.portal.model.Phone" %><%@
page import="com.liferay.portal.model.Region" %><%@
page import="com.liferay.portal.service.CountryServiceUtil" %><%@
page import="com.liferay.portal.service.RegionServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %>

<%
String currentURL = PortalUtil.getCurrentURL(request);
%>