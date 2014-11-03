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

<portlet:actionURL name="registrationUser" var="registrationURL" />

<aui:form action="<%= registrationURL %>" method="post" name="fm">
	<h3><liferay-ui:message key="basic-info" /></h3>

	<liferay-ui:error exception="<%= ContactBirthdayException.class %>" message="only-over-13-years-old-can-regist" />
	<liferay-ui:error exception="<%= ContactFirstNameException.class %>" message="please-enter-a-valid-first-name" />
	<liferay-ui:error exception="<%= ContactLastNameException.class %>" message="please-enter-a-valid-last-name" />
	<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= DuplicateUserScreenNameException.class %>" message="the-user-name-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%= RegistrationAddressCityException.class %>" message=" please-enter-a-valid-city" />
	<liferay-ui:error exception="<%= RegistrationAddressException.class %>" message="please-enter-a-valid-address" />
	<liferay-ui:error exception="<%= RegistrationAddressStateException.class %>" message="please-enter-a-valid-state-name" />
	<liferay-ui:error exception="<%= RegistrationAddressZipException.class %>" message="please-enter-a-valid-zip" />
	<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserPasswordException.class %>" message="please-enter-a-valid-password" />
	<liferay-ui:error exception="<%= UserReminderQueryException.class %>" message="please-enter-a-valid-security-answer" />

	<aui:fieldset column="<%= true %>" cssClass="aui-w50">
		<aui:input label="first-name" name="first_Name" required="true" />

		<aui:input label="last-name" name="last_Name" required="true" />

		<aui:input label="email-address" name="email_Address" required="true" />

		<aui:input label="username" name="username" required="true" />
	</aui:fieldset>
	<aui:fieldset column="<%= true %>" cssClass="aui-w50">
		<aui:select label="male" name="male">
			<aui:option label="male" value="true" />
			<aui:option label="female" value="false" />
		</aui:select>

		<aui:input model="<%= Contact.class %>" name="birthday" />

		<aui:input label="password" name="password1" required="true" type="password" />

		<aui:input label="confirm-password" name="password2" required="true" type="password" />
	</aui:fieldset>

	<h3><liferay-ui:message key="phone" /></h3>

	<aui:fieldset column="<%= true %>" cssClass="aui-w50">
		<aui:input label="home-phone" name="home_phone" />
	</aui:fieldset>
	<aui:fieldset column="<%= true %>" cssClass="aui-w50">
		<aui:input label="mobile-phone" name="mobile_phone" />
	</aui:fieldset>

	<h3><liferay-ui:message key="billing-address(us-only)" /></h3>

	<%@ include file="/html/registration/addresses.jsp" %>

	<h3><liferay-ui:message key="misc" /></h3>

	<aui:select label="sercurity-question" name="security_question" width="300">
		<aui:option label="what-is-your-mother's-maiden-name?" />
		<aui:option label="what-is-the-make-of-your-first-car?" />
		<aui:option label="what-is-your-high-school-mascot?" />
		<aui:option label="what-is-your-favorite-actor?" />
	</aui:select>

	<aui:input label="answer" name="security_answer" />

	<aui:input label="terms-of-use" name="accepted_Tou" type="checkbox" />

	<aui:button type="submit" />
</aui:form>