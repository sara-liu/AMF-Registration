create table Registration_Address (
	uuid_ VARCHAR(75) null,
	addressId LONG not null primary key,
	companyId LONG,
	userId LONG,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zip VARCHAR(75) null
);

create table Registration_EventMonitor (
	eventMonitorId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	startDate DATE null,
	eventType VARCHAR(75) null,
	ipAddress VARCHAR(75) null
);