
create  table country(name varchar(30));
insert into country values('INDIA');
insert into country values('CHINA');
insert into country values('SRILANKA');

create table state(sname varchar(30),country_name varchar(30));
insert into state values('AP','INDIA');
insert into state values('UP','INDIA');
insert into state values('KA','INDIA');
insert into state values('TS','INDIA');
 
create table district(dname varchar(30),state_name varchar(30));
insert into district values('SSS','AP');
insert into district values('ATP','AP');
insert into district values('HYD','TS');
insert into district values('MBR','TS');
 
create table mandal(mname varchar(30),district_name varchar(30));
insert into mandal values('KDR','SSS');
insert into mandal values('PTP','SSS');
insert into mandal values('KLD','ATP');
insert into mandal values('RDG','ATP');

create table town(tname varchar(30),mandal_name varchar(30));
insert into town values('KDR','KDR');
insert into town values('KOTHACHERUVU','PTP');
insert into town values('NALAMADA','PTP'); 

-- rollback
-- drop table country;
-- drop table state;
-- drop table district;
-- drop table mandal;
-- drop table town;
