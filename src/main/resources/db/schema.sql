create table account(
    accountId VARCHAR(50) NOT NULL ,
    name varchar(50) not null ,
    password varchar(50) not null ,
    cashAmount integer,
    primary key (accountId)
);
create table record(
    accountid varchar(50) not null  ,
    recordtype varchar(50) not null ,
    recordid integer not null ,
    recordbody varchar(100),
    primary key (recordid)
);
create table account_record(
    accountid varchar(50) not null ,
    recordcount integer,
    primary key (accountid)
);
