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

package com.amf.registration.portlet;

import com.amf.registration.RegistrationAddressCityException;
import com.amf.registration.RegistrationAddressException;
import com.amf.registration.RegistrationAddressStateException;
import com.amf.registration.RegistrationAddressZipException;
import com.amf.registration.service.AddressLocalServiceUtil;
import com.amf.registration.service.EventMonitorLocalServiceUtil;
import com.amf.registration.util.CountryConstants;
import com.amf.registration.util.EventTypeConstants;
import com.amf.registration.util.IpConstants;

import com.liferay.portal.ContactBirthdayException;
import com.liferay.portal.ContactFirstNameException;
import com.liferay.portal.ContactLastNameException;
import com.liferay.portal.DuplicateUserEmailAddressException;
import com.liferay.portal.DuplicateUserScreenNameException;
import com.liferay.portal.PhoneNumberException;
import com.liferay.portal.TermsOfUseException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.UserReminderQueryException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class AMFRegistrationPortlet
 */
public class RegistrationPortlet extends MVCPortlet {

	public void registrationUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String screenName = ParamUtil.getString(actionRequest, "username");
		String firstName = ParamUtil.getString(actionRequest, "first_Name");
		String lastName = ParamUtil.getString(actionRequest, "last_Name");
		String emailAddress = ParamUtil.getString(
			actionRequest, "email_Address");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		int birthdayMonth = ParamUtil.getInteger(
			actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		String password1 = ParamUtil.getString(actionRequest, "password1");
		String password2 = ParamUtil.getString(actionRequest, "password2");

		String homePhone = ParamUtil.getString(actionRequest,"home_phone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobile_phone");

		String address = ParamUtil.getString(actionRequest, "address");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String zip = ParamUtil.getString(actionRequest, "zip");

		String sercurityQuestion = ParamUtil.getString(
			actionRequest, "security_question");
		String sercurityAnswer = ParamUtil.getString(
			actionRequest, "security_answer");

		boolean acceptedTou = ParamUtil.getBoolean(
			actionRequest, "accepted_Tou");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			User.class.getName(), actionRequest);

		validate(
			password1, password2, emailAddress, firstName, lastName,
			birthdayMonth, birthdayDay, birthdayYear, mobilePhone,
			homePhone, address, address2, city, state, zip,
			sercurityAnswer, acceptedTou);

		User user = UserLocalServiceUtil.addUser(
			0, themeDisplay.getCompanyId(), false, password1, password2, false,
			screenName, emailAddress, 0, null, LocaleUtil.getDefault(),
			firstName, null, lastName, 0, 0, male, birthdayMonth, birthdayDay,
			birthdayYear, null, null, null, null, null, false, serviceContext);

		UserLocalServiceUtil.updateReminderQuery(
			user.getUserId(), sercurityQuestion, sercurityAnswer);

		UserLocalServiceUtil.updateAgreedToTermsOfUse(
			user.getUserId(), acceptedTou);

		List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes(
			ListTypeConstants.CONTACT_PHONE);

		for (ListType phoneType : phoneTypes) {
			if ((phoneType.getName().equals("personal") &&
				 Validator.isNotNull(homePhone)) ||
				(phoneType.getName().equals("mobile-phone") &&
				 Validator.isNotNull(mobilePhone))) {

				PhoneLocalServiceUtil.addPhone(
					user.getUserId(), Contact.class.getName(),
					user.getContactId(), mobilePhone, null,
					phoneType.getListTypeId(), false);
			}
		}

		AddressLocalServiceUtil.addAddress(
			user.getUserId(), address, address2, city, state, zip,
			serviceContext);

		EventMonitorLocalServiceUtil.addEventMonitor(
			user.getUserId(), user.getFullName(), user.getCompanyId(),
			EventTypeConstants.REGISTRATION, IpConstants.DEFAULT);
	}

	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof ContactBirthdayException ||
			cause instanceof ContactFirstNameException ||
			cause instanceof ContactLastNameException ||
			cause instanceof DuplicateUserEmailAddressException ||
			cause instanceof DuplicateUserScreenNameException ||
			cause instanceof PhoneNumberException ||
			cause instanceof RegistrationAddressCityException ||
			cause instanceof RegistrationAddressException ||
			cause instanceof RegistrationAddressStateException ||
			cause instanceof RegistrationAddressZipException ||
			cause instanceof TermsOfUseException ||
			cause instanceof UserEmailAddressException ||
			cause instanceof UserPasswordException ||
			cause instanceof UserReminderQueryException) {

			return true;
		}

		return false;
	}

	protected void validate(
			String password1, String password2, String emailAddress,
			String firstName, String lastName, int birthdayMonth,
			int birthdayDay, int birthdayYear, String mobilePhoneNumber,
			String homePhoneNumber, String address, String address2,
			String city, String state, String zip, String sercurityAnswer,
			boolean acceptedTou)
		throws Exception {

		if (!Validator.isAlphanumericName(firstName) ||
			(firstName.length() > 50)) {

			throw new ContactFirstNameException();
		}

		if (!Validator.isAlphanumericName(lastName) ||
			(lastName.length() > 50)) {

			throw new ContactLastNameException();
		}

		if (!Validator.isEmailAddress(emailAddress) ||
			(emailAddress.length() > 255)) {

			throw new UserEmailAddressException();
		}

		Date birthday = PortalUtil.getDate(
			birthdayMonth, birthdayDay, birthdayYear,
			ContactBirthdayException.class);

		Date now = new Date();

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(now);

		int age = CalendarUtil.getAge(birthday, calendar);

		if (age < 13) {
			throw new ContactBirthdayException();
		}

		validatePassword(password1, password2);

		if ((Validator.isNotNull(mobilePhoneNumber) &&
			 (mobilePhoneNumber.length() != 10)) ||
			((Validator.isNotNull(mobilePhoneNumber)) &&
			 (homePhoneNumber.length() != 10))) {

			throw new PhoneNumberException();
		}

		if (!Validator.isAlphanumericName(address) ||
			(address.length() > 255) ||
			(Validator.isNotNull(address2) && 
			 (!Validator.isAlphanumericName(address2) ||
			 (address2.length() > 255)))) {

			throw new RegistrationAddressException();
		}

		if (!Validator.isAlphanumericName(city) || (city.length() > 255)) {
			throw new RegistrationAddressCityException();
		}

		if (!Validator.isDigit(zip) || (zip.length() != 5)) {
			throw new RegistrationAddressZipException();
		}

		Country country = CountryServiceUtil.getCountryByName(
			CountryConstants.UNITED_STATES);

		List<Region> USRegions = RegionServiceUtil.getRegions(
			country.getCountryId());

		boolean isUSRegion = false;

		for (Region USRegion : USRegions) {
			if (state.equals(USRegion.getName())) {
				isUSRegion = true;
			}
		}

		if (!isUSRegion) {
			throw new RegistrationAddressStateException();
		}

		if (acceptedTou == false) {
			throw new TermsOfUseException();
		}

		if (!Validator.isAlphanumericName(sercurityAnswer) ||
			(sercurityAnswer.length() > 255)) {

			throw new UserReminderQueryException();
		}
	}

	protected void validatePassword(String password1, String password2)
		throws UserPasswordException {

		if (!password1.equals(password2)) {
			throw new UserPasswordException(
				UserPasswordException.PASSWORDS_DO_NOT_MATCH);
		}

		boolean hasUpperCase = false;
		boolean hasNumber = false;
		boolean hasSpecialCharater = false;

		for (char c : password1.toCharArray()) {
			if (!hasUpperCase && Character.isUpperCase(c)) {
				hasUpperCase = true;
			}

			if (!hasNumber && Validator.isDigit(c)) {
				hasNumber = true;
			}

			if (!hasSpecialCharater) {
				for (char character : SPECIAL_CHARACTER) {
					if (c == character) {
						hasSpecialCharater = true;
					}
				}
			}

			if (hasUpperCase && hasNumber && hasSpecialCharater) {
				break;
			}
		}

		if (!(hasUpperCase && hasNumber && hasSpecialCharater) ||
			(password1.length() < 6)) {

			throw new UserPasswordException(
				UserPasswordException.PASSWORD_INVALID);
		}
	}

	private static final char[] SPECIAL_CHARACTER = new char[] {
		'.', '!', '#', '$', '%', '&', '\'', '*', '+', '-', '/', '=', '?', '^',
		'_', '`', '{', '|', '}', '~', '@', '(', ')', '<', '>', ',', ':', ':',
		'"'
	};

}