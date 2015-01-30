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

String tabs1 = ParamUtil.getString(request, "tabs1", "all");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/html/eventmonitor/view.jsp");
portletURL.setParameter("tabs1", tabs1);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
%>

<liferay-ui:tabs
	names="all,registration,login"
	param="tabs1"
	url="<%= portletURL.toString() %>"
/>

<div class="result-data">
	<liferay-ui:search-container
		emptyResultsMessage="there-are-no-events"
		iteratorURL="<%= portletURL %>"
	>

		<%
		long userId = themeDisplay.getUserId();

		List<EventMonitor> eventMonitorResults = null;

		int eventMonitorCount = 0;

		if (tabs1.equals(EventTypeConstants.REGISTRATION)) {
			eventMonitorResults = EventMonitorServiceUtil.getEvent(userId, EventTypeConstants.REGISTRATION, groupId, searchContainer.getStart(), searchContainer.getEnd());

			eventMonitorCount = EventMonitorServiceUtil.getEventCount(userId, EventTypeConstants.REGISTRATION, groupId);
		}
		else if (tabs1.equals(EventTypeConstants.LOGIN)) {
			eventMonitorResults = EventMonitorServiceUtil.getEvent(userId, EventTypeConstants.LOGIN, groupId, searchContainer.getStart(), searchContainer.getEnd());

			eventMonitorCount = EventMonitorServiceUtil.getEventCount(userId, EventTypeConstants.LOGIN, groupId);
		}
		else {
			eventMonitorResults = EventMonitorServiceUtil.getEvent(userId, groupId, searchContainer.getStart(), searchContainer.getEnd());

			eventMonitorCount = EventMonitorServiceUtil.getEventCount(userId, groupId);
		}
		%>

		<liferay-ui:search-container-results
			results="<%= eventMonitorResults %>"
			total="<%= eventMonitorCount %>"
		/>

		<liferay-ui:search-container-row
			className="com.amf.registration.model.EventMonitor"
			escapedModel="<%= true %>"
			modelVar="eventMonitor"
		>

			<liferay-ui:search-container-column-text
				buffer="buffer"
			>

				<%
				buffer.append(dateFormatDateTime.format(eventMonitor.getStartDate()));
				buffer.append(StringPool.SPACE);
				buffer.append(eventMonitor.getUserName());
				buffer.append(StringPool.SPACE);
				buffer.append(StringPool.OPEN_PARENTHESIS);
				buffer.append(String.valueOf(eventMonitor.getUserId()));
				buffer.append(StringPool.CLOSE_PARENTHESIS);
				buffer.append(StringPool.THREE_SPACES);
				buffer.append(eventMonitor.getIpAddress());
				buffer.append(StringPool.SPACE);
				buffer.append(eventMonitor.getEventType());
				%>

			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>