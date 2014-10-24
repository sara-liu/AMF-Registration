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
	<div class="lfr-form-row ">
		<aui:input label="mobile-phone" name="mobilePhoneNumber" />

		<aui:input label="extension" name="mobilePhoneExtension" />

		<aui:input cssClass="primary-ctrl" label="primary" name="phonePrimary" type="radio" value="<%= PhoneTypeConstants.MOBILE_PHONE %>" />

		<aui:input name="mobilePhoneTypeId" type="hidden" value="<%= PhoneTypeIdConstants.MOBILE_PHONE_TYPE_ID %>" />
	</div>
</aui:fieldset>
<aui:fieldset column="<%= true %>" cssClass="aui-w50">
	<div class="lfr-form-row">
		<aui:input label="home-phone" name="homePhoneNumber" />

		<aui:input label="extension" name="homePhoneExtension" />

		<aui:input cssClass="primary-ctrl" label="primary" name="phonePrimary" type="radio" value="<%= PhoneTypeConstants.HOME_PHONE %>" />

		<aui:input name="homePhoneTypeId" type="hidden" value="<%= PhoneTypeIdConstants.HOME_PHONE_TYPE_ID %>" />
	</div>
</aui:fieldset>