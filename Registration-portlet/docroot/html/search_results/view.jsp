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

<%@ include file="/html/search_results/init.jsp" %>

<%
String zip = (String)renderRequest.getParameter("zip");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/html/search_results/view.jsp");
%>

<c:choose>
	<c:when test="<%= Validator.isNotNull(zip) %>">
		<div class="result-data">
			<liferay-ui:search-container
				delta= "<%= 5 %>"
				emptyResultsMessage="no-results-found-please-try-a-different-search-criteria"
				iteratorURL="<%= portletURL %>"
			>

			<aui:fieldset label='<%= LanguageUtil.format(pageContext, "search-results-for-x", HtmlUtil.escape(zip)) %>'>

				<liferay-ui:search-container-results
					results="<%= AMFUserLocalServiceUtil.findByZip(zip, searchContainer.getStart(), searchContainer.getEnd()) %>"
					total="<%= AMFUserLocalServiceUtil.countByZip(zip) %>"
				/>

				<liferay-ui:search-container-row
					className="com.liferay.portal.model.User"
					escapedModel="<%= true %>"
					keyProperty="userId"
					modelVar="user"
				>

					<liferay-ui:search-container-column-text
						buffer="buffer"
						name='<%= LanguageUtil.format(pageContext, "search-results-for-x", HtmlUtil.escape(zip)) %>'
					>

						<%
						buffer.append(user.getFirstName());
						buffer.append(StringPool.SPACE);
						buffer.append(user.getLastName().substring(0, 1).toUpperCase());
						buffer.append(". (");
						buffer.append(user.getScreenName());
						buffer.append(") - ");
						buffer.append(user.getEmailAddress());
						%>

					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
			</aui:fieldset>

				<liferay-ui:search-iterator/>
			</liferay-ui:search-container>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="there-are-no-zip-was-entered" />
	</c:otherwise>
</c:choose>