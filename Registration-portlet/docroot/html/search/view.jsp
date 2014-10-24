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

<%@ include file="/html/search/init.jsp" %>

<%
long groupId = themeDisplay.getScopeGroupId();
%>

<portlet:actionURL name="searchUser" var="searchUserURL" />

<aui:form action="<%= searchUserURL %>" method="post" name="fm">
	<liferay-ui:error exception="<%= RegistrationAddressZipException.class %>" message="please-enter-a-valid-zip" />

	<aui:input label="enter-us-zip" name="zip" />

	<aui:button type="submit" value="search" />
</aui:form>