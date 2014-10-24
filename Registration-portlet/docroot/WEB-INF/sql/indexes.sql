create index IX_2660A880 on Registration_Address (uuid_);
create index IX_BD6E32DD on Registration_Address (zip);

create index IX_AE551AB8 on Registration_EventMonitor (eventType);
create index IX_37883AF2 on Registration_EventMonitor (eventType, userId);
create index IX_528989A6 on Registration_EventMonitor (userId);
create index IX_B1E63E on Registration_EventMonitor (userId, eventType);
create index IX_48561AC8 on Registration_EventMonitor (uuid_);