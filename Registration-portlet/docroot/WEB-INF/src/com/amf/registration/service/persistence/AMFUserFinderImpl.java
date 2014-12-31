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

package com.amf.registration.service.persistence;

import com.amf.registration.model.AMFUser;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class AMFUserFinderImpl extends BasePersistenceImpl<AMFUser>
	implements AMFUserFinder {

	public static String COUNT_BY_ZIP =
		AMFUserFinder.class.getName() + ".countByZip";

	public static String FIND_BY_ZIP =
		AMFUserFinder.class.getName() + ".findByZip";

	public int countByZip(String zip) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_ZIP);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(zip);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findByZip(String zip, int start, int end)
		throws SystemException {

		Session session = null;

		List<User> users = new ArrayList<User>();

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ZIP);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("userId", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(zip);

			List<Long> userIds = (List<Long>)QueryUtil.list(
				q, getDialect(), start, end);

			for (long userId : userIds) {
				User user = UserLocalServiceUtil.fetchUser(userId);

				users.add(user);
			}

			return users;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}