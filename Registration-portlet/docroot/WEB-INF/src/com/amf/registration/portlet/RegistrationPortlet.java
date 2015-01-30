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

import com.amf.registration.service.EventMonitorLocalServiceUtil;
import com.amf.registration.util.CountryConstants;
import com.amf.registration.util.EventTypeConstants;
import com.amf.registration.util.IpConstants;

import com.liferay.portal.AddressCityException;
import com.liferay.portal.AddressStreetException;
import com.liferay.portal.AddressZipException;
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
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
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

		String username = ParamUtil.getString(actionRequest, "username");
		String firstName = ParamUtil.getString(actionRequest, "first_name");
		String lastName = ParamUtil.getString(actionRequest, "last_name");
		String emailAddress = ParamUtil.getString(
			actionRequest, "email_address");
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
		long stateId = ParamUtil.getLong(actionRequest, "state");
		String zip = ParamUtil.getString(actionRequest, "zip");

		String securityQuestion = ParamUtil.getString(
			actionRequest, "security_question");
		String securityAnswer = ParamUtil.getString(
			actionRequest, "security_answer");

		boolean acceptedTou = ParamUtil.getBoolean(
			actionRequest, "accepted_tou");

		Country country = CountryServiceUtil.getCountryByName(
			CountryConstants.UNITED_STATES);

		List<ListType> addressTypes = ListTypeServiceUtil.getListTypes(
				ListTypeConstants.CONTACT_ADDRESS);

		int typeId = 0;

		for (ListType addressType : addressTypes) {
			if (addressType.getName().equals("personal")) {
				typeId = addressType.getListTypeId();

				break;
			}
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			User.class.getName(), actionRequest);

		validate(
			firstName, lastName, emailAddress, username, birthdayMonth,
			birthdayDay, birthdayYear, password1, password2, homePhone,
			mobilePhone, address, address2, city, zip, securityQuestion,
			securityAnswer, acceptedTou);

		User user = UserLocalServiceUtil.addUser(
			0, themeDisplay.getCompanyId(), false, password1, password2, false,
			username, emailAddress, 0, null, LocaleUtil.getDefault(), firstName,
			null, lastName, 0, 0, male, birthdayMonth, birthdayDay,
			birthdayYear, null, null, null, null, null, false, serviceContext);

		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);

		UserLocalServiceUtil.updateReminderQuery(
			user.getUserId(), securityQuestion, securityAnswer);

		UserLocalServiceUtil.updateAgreedToTermsOfUse(
			user.getUserId(), acceptedTou);

		List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes(
			ListTypeConstants.CONTACT_PHONE);

		for (ListType phoneType : phoneTypes) {
			if (phoneType.getName().equals("personal") &&
				Validator.isNotNull(homePhone)) {

				PhoneLocalServiceUtil.addPhone(
					user.getUserId(), Contact.class.getName(),
					user.getContactId(), homePhone, null,
					phoneType.getListTypeId(), false);
			}
			else if (phoneType.getName().equals("mobile-phone") &&
					 Validator.isNotNull(mobilePhone)) {

				PhoneLocalServiceUtil.addPhone(
					user.getUserId(), Contact.class.getName(),
					user.getContactId(), mobilePhone, null,
					phoneType.getListTypeId(), false);
			}
		}

		AddressLocalServiceUtil.addAddress(
			user.getUserId(), Contact.class.getName(), user.getContactId(),
			address, address2, StringPool.BLANK, city, zip, stateId,
			country.getCountryId(), typeId, false, true);

		EventMonitorLocalServiceUtil.addEvent(
			user.getCompanyId(), user.getUserId(), user.getScreenName(),
			EventTypeConstants.REGISTRATION, IpConstants.DEFAULT);
	}

	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof AddressCityException ||
			cause instanceof AddressStreetException ||
			cause instanceof AddressZipException ||
			cause instanceof ContactBirthdayException ||
			cause instanceof ContactFirstNameException ||
			cause instanceof ContactLastNameException ||
			cause instanceof DuplicateUserEmailAddressException ||
			cause instanceof DuplicateUserScreenNameException ||
			cause instanceof PhoneNumberException ||
			cause instanceof TermsOfUseException ||
			cause instanceof UserEmailAddressException ||
			cause instanceof UserPasswordException ||
			cause instanceof UserReminderQueryException ||
			cause instanceof UserScreenNameException) {

			return true;
		}

		return false;
	}

	protected void validate(
			String firstName, String lastName, String emailAddress,
			String username, int birthdayMonth, int birthdayDay,
			int birthdayYear, String password1, String password2,
			String homePhone, String mobilePhone, String address,
			String address2, String city, String zip, String securityQuestion,
			String securityAnswer, boolean acceptedTou)
		throws Exception {

		if (!Validator.isAlphanumericName(firstName) ||
			(firstName.length() > 50)) {

			throw new ContactFirstNameException();
		}

		if (!Validator.isAlphanumericName(lastName) ||
			(lastName.length() > 50)) {

			throw new ContactLastNameException();
		}

		if (Validator.isNull(emailAddress) || (emailAddress.length() > 75)) {
			throw new UserEmailAddressException();
		}

		if ((username.length() < 4) || (username.length() > 16) ||
			!Validator.isAlphanumericName(username)) {

			throw new UserScreenNameException();
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

		if (Validator.isNotNull(homePhone)) {
			if (!Validator.isDigit(homePhone) || (homePhone.length() != 10)) {
				throw new PhoneNumberException();
			}
		}

		if (Validator.isNotNull(mobilePhone)) {
			if (!Validator.isDigit(mobilePhone) ||
				(mobilePhone.length() != 10)) {

				throw new PhoneNumberException();
			}
		}

		if (!Validator.isAlphanumericName(address) || (address.length() > 75)) {
			throw new AddressStreetException();
		}

		if (Validator.isNotNull(address2) &&
			(!Validator.isAlphanumericName(address2) ||
			 (address2.length() > 75))) {

			throw new AddressStreetException();
		}

		if (!Validator.isAlphanumericName(city) || (city.length() > 75)) {
			throw new AddressCityException();
		}

		if (!Validator.isDigit(zip) || (zip.length() != 5)) {
			throw new AddressZipException();
		}

		if (Validator.isNull(securityQuestion) ||
			Validator.isNull(securityAnswer) ||
			!Validator.isAlphanumericName(securityAnswer) ||
			(securityAnswer.length() > 75)) {

			throw new UserReminderQueryException();
		}

		if (acceptedTou == false) {
			throw new TermsOfUseException();
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