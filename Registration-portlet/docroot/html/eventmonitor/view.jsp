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

<%@ include file="/html/eventmonitor/init.jsp" %>

<%
long groupId = themeDisplay.getScopeGroupId();

String tabs1 = ParamUtil.getString(request, "tabs1", "All");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/html/eventmonitor/view.jsp");
portletURL.setParameter("tabs1", tabs1);

boolean hasViewPermission = RegistrationPermission.contains(permissionChecker, groupId, PermissionModelNameConstants.REGISTRATION_MODEL, ActionKeys.VIEW);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
%>

<liferay-ui:tabs
	names="All,Registration,Login"
	param="tabs1"
	url="<%= portletURL.toString() %>"
/>

<liferay-ui:search-container
	emptyResultsMessage="there-are-no-events"
	iteratorURL="<%= portletURL %>"
>

<%
long userId = themeDisplay.getUserId();

List<EventMonitor> eventMonitorResults = null;

int eventMonitorCount = 0;

if (tabs1.equals(EventTypeConstants.REGISTRATION)) {
	eventMonitorResults = hasViewPermission ? EventMonitorLocalServiceUtil.getEventMonitor(EventTypeConstants.REGISTRATION, searchContainer.getStart(), searchContainer.getEnd()) : EventMonitorLocalServiceUtil.getEventMonitor(userId, EventTypeConstants.REGISTRATION, searchContainer.getStart(), searchContainer.getEnd());

	eventMonitorCount = hasViewPermission ? EventMonitorLocalServiceUtil.getEventMonitorCount(EventTypeConstants.REGISTRATION) : EventMonitorLocalServiceUtil.getEventMonitorCount(userId, EventTypeConstants.REGISTRATION);
}
else if (tabs1.equals(EventTypeConstants.LOGIN)) {
	eventMonitorResults = hasViewPermission ? EventMonitorLocalServiceUtil.getEventMonitor(EventTypeConstants.LOGIN, searchContainer.getStart(), searchContainer.getEnd()) : EventMonitorLocalServiceUtil.getEventMonitor(userId, EventTypeConstants.LOGIN, searchContainer.getStart(), searchContainer.getEnd());

	eventMonitorCount = hasViewPermission ? EventMonitorLocalServiceUtil.getEventMonitorCount(EventTypeConstants.LOGIN) : EventMonitorLocalServiceUtil.getEventMonitorCount(userId, EventTypeConstants.LOGIN);
}
else {
	eventMonitorResults = hasViewPermission ? EventMonitorLocalServiceUtil.getEventMonitor(searchContainer.getStart(), searchContainer.getEnd()) : EventMonitorLocalServiceUtil.getEventMonitor(userId, searchContainer.getStart(), searchContainer.getEnd());

	eventMonitorCount = hasViewPermission ? EventMonitorLocalServiceUtil.getEventMonitorCount() : EventMonitorLocalServiceUtil.getEventMonitorCount(userId);
}
%>

	<liferay-ui:search-container-results
		results="<%= eventMonitorResults %>"
		total="<%= eventMonitorCount %>"
	/>

	<liferay-ui:search-container-row
		className="com.amf.registration.model.EventMonitor"
		escapedModel="<%= true %>"
		keyProperty="eventMonitorId"
		modelVar="eventMonitor"
	>

		<liferay-ui:search-container-column-text
			buffer="buffer"
		>

			<%
			buffer.append(dateFormatDateTime.format(eventMonitor.getStartDate()));
			buffer.append(StringPool.THREE_SPACES);
			buffer.append(eventMonitor.getUserName());
			buffer.append(StringPool.THREE_SPACES);
			buffer.append(StringPool.OPEN_PARENTHESIS);
			buffer.append(String.valueOf(eventMonitor.getUserId()));
			buffer.append(StringPool.CLOSE_PARENTHESIS);
			buffer.append(StringPool.THREE_SPACES);
			buffer.append(eventMonitor.getIpAddress());
			buffer.append(StringPool.THREE_SPACES);
			buffer.append(eventMonitor.getEventType());
			%>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>