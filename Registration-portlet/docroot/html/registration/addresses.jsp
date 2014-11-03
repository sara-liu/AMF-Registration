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

<aui:fieldset column="<%= true %>" cssClass="aui-w50">
	<liferay-ui:error key="address1-format-error" message="please-enter-a-valid-address" />

	<aui:input name="address" label="address1" required="true" />

	<liferay-ui:error key="address2-format-error" message="please-enter-a-valid-address2" />

	<aui:input name="address2" />
</aui:fieldset>
<aui:fieldset column="<%= true %>" cssClass="aui-w50">
	<aui:input name="city" required="true" />

	<aui:select name="state">

	<%
	Country country = CountryServiceUtil.getCountryByName(CountryConstants.UNITED_STATES);

	List<Region> regions = RegionServiceUtil.getRegions(country.getCountryId());

	for (Region region : regions) {
	%>

		<aui:option label="<%= region.getName() %>" value="<%= region.getName() %>" />

	<%
	}
	%>

	</aui:select>

	<aui:input label="zip" name="zip" required="true" />
</aui:fieldset>