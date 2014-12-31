/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.amf.registration;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Sara Liu
 */
public class NoSuchAMFUserException extends NoSuchModelException {

	public NoSuchAMFUserException() {
		super();
	}

	public NoSuchAMFUserException(String msg) {
		super(msg);
	}

	public NoSuchAMFUserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAMFUserException(Throwable cause) {
		super(cause);
	}

}