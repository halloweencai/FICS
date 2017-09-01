/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/7/20 11:45:15                           */
/*==============================================================*/


drop table if exists AdvancedGroupInfo;

drop table if exists AdvancedPersonalInfo;

drop table if exists CountAdvancedGroupInfo;

drop table if exists CountAdvancedPersonalInfo;

drop table if exists DataDict;

drop table if exists ExcelAddress;

drop table if exists Honor;

drop table if exists SystemUser;

/*==============================================================*/
/* Table: AdvancedGroupInfo                                     */
/*==============================================================*/
create table AdvancedGroupInfo
(
   unitName             varchar(20) not null,
   cityOwnedIndutries   varchar(20) not null,
   personInCharge       varchar(20) not null,
   telephoneNumber      bigint not null,
   outstandingDeeds     varchar(100),
   primary key (unitName, cityOwnedIndutries)
);

/*==============================================================*/
/* Table: AdvancedPersonalInfo                                  */
/*==============================================================*/
create table AdvancedPersonalInfo
(
   IDNumber             varchar(18) not null,
   name                 varchar(20) not null,
   sex                  varchar(2) not null,
   nation               varchar(20) not null,
   birthday             date not null,
   politicalStatus      varchar(20) not null,
   degreeOfEducation    varchar(20) not null,
   telephoneNumber      char(11) not null,
   workplace            varchar(30) not null,
   job                  varchar(20) not null,
   healthStatus         varchar(50),
   cityOwnedIndutries   varchar(50) not null,
   employmentStatus     varchar(10),
   familyTrouble        text,
   outstandingDeeds     text,
   honoraryTitle        varchar(20),
   treament             varchar(20),
   modelWorkerStatus    varchar(10),
   modelWorkerTitle     varchar(20),
   primary key (IDNumber)
);

/*==============================================================*/
/* Table: CountAdvancedGroupInfo                                */
/*==============================================================*/
create table CountAdvancedGroupInfo
(
   year                 date not null,
   countryAdvancedProductionCompanyNumber int,
   countryMayDayAwardCompanyNumber int,
   provinceAdvancedProductionCompanyNumber int,
   siChuanMayDayCompanyNumber int,
   countryPioneerWorkerNumber int,
   siChuanPioneerWorkerNumber int,
   cityPioneerWorkerNumber int,
   companyPioneerWorkerNumber int,
   primary key (year)
);

/*==============================================================*/
/* Table: CountAdvancedPersonalInfo                             */
/*==============================================================*/
create table CountAdvancedPersonalInfo
(
   year                 date not null,
   allPersonNumber      int,
   deadAdvancedPersonNum int,
   retireAdvancedPersonNum int,
   workingAdvancedPersonNum int,
   companyLeaderNum     int,
   institutionLeaderNum int,
   companyModelWorkerNum int,
   institutionModelWorkerNum int,
   staffModelWorkerNum  int,
   agricultureModelWorkerNum int,
   privateCompanyModelWorkerNum int,
   primary key (year)
);

/*==============================================================*/
/* Table: DataDict                                              */
/*==============================================================*/
create table DataDict
(
   no                   smallint not null,
   dataItem             varchar(20) not null,
   dataType             varchar(20) not null,
   dataStream           varchar(20) not null,
   dataStorage          varchar(20) not null,
   processingProcedure  varchar(20) not null,
   primary key (no)
);

/*==============================================================*/
/* Table: ExcelAddress                                          */
/*==============================================================*/
create table ExcelAddress
(
   no                   smallint not null,
   type                 varchar(10) not null,
   address              varchar(30) not null,
   primary key (no)
);

/*==============================================================*/
/* Table: Honor                                                 */
/*==============================================================*/
create table Honor
(
   fileNo               int not null,
   IDNumber             varchar(18),
   fileName             varchar(20) not null,
   honorContent         text not null,
   grantUnit            varchar(20) not null,
   grantTime            date not null,
   dispatchUnit         varchar(20) not null,
   dispatchTime         date not null,
   record               varchar(50) not null,
   honorTitleTreatment  varchar(20) not null,
   outstandingDeeds     text not null,
   basisOfAsserting     varchar(100) not null,
   advice               varchar(50) not null,
   primary key (fileNo)
);

/*==============================================================*/
/* Table: SystemUser                                            */
/*==============================================================*/
create table SystemUser
(
   user                 varchar(10) not null,
   password             char(16) not null,
   UserPermission       int not null,
   userUnit             varchar(20) not null,
   email                varchar(30) not null,
   sex                  varchar(5) not null,
   IDNumber             varchar(18) not null,
   telephoneNumber      bigint not null,
   primary key (user)
);

alter table Honor add constraint FK_Relationship_1 foreign key (IDNumber)
      references AdvancedPersonalInfo (IDNumber) on delete restrict on update restrict;

