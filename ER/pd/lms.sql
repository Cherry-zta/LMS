/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018-12-22 16:59:47                          */
/*==============================================================*/


drop index book_PK on book;

drop table if exists book;

drop table if exists borrow_curr;

drop table if exists category;

drop table if exists detailed_book;

drop table if exists detailed_user;

drop table if exists penalty;

drop table if exists record;

drop table if exists relation_book;

drop index student_PK on user;

drop table if exists user;

/*==============================================================*/
/* Table: book                                                  */
/*==============================================================*/
create table book
(
   title                varchar(50) not null,
   author               varchar(50) not null,
   location             varchar(50) not null,
   bid                  int not null,
   primary key (bid)
);

/*==============================================================*/
/* Index: book_PK                                               */
/*==============================================================*/
create unique index book_PK on book
(
   bid
);

/*==============================================================*/
/* Table: borrow_curr                                           */
/*==============================================================*/
create table borrow_curr
(
   borrow_crr_id        int not null,
   bid                  int not null,
   userid               int not null,
   borrow_time          datetime not null,
   should_return_time   datetime not null,
   primary key (borrow_crr_id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   cid                  int not null,
   category_name        varchar(20) not null,
   primary key (cid)
);

/*==============================================================*/
/* Table: detailed_book                                         */
/*==============================================================*/
create table detailed_book
(
   bid                  int not null,
   status               varchar(20) not null,
   publishing_house     varchar(50),
   series               varchar(50),
   ISBN                 varchar(13),
   borrow_times         int not null,
   category_number      varchar(20),
   author               varchar(20) not null,
   second_author        varchar(20),
   introduction         varchar(500),
   summary              varchar(500),
   author_notes         varchar(200),
   reader_notes         varchar(200),
   book_specification   varchar(50),
   douban_introduce     varchar(500),
   primary key (bid)
);

/*==============================================================*/
/* Table: detailed_user                                         */
/*==============================================================*/
create table detailed_user
(
   userid               int not null,
   ID_number            char(9) not null,
   departement          varchar(20),
   sex                  char(1),
   identify             char(18),
   company              varchar(50),
   degree               varchar(20),
   birth                date,
   borrow_max           int not null,
   appionent_max        int not null,
   entrust_max          int not null,
   phone                varchar(20),
   postcode             char(6),
   cash_pledge          float,
   position             varchar(20),
   borrow_account       int,
   break_rules_account  int,
   handing_charge       float,
   borrow_grade         int,
   address              varchar(50),
   primary key (userid)
);

/*==============================================================*/
/* Table: penalty                                               */
/*==============================================================*/
create table penalty
(
   penalty_id           int not null,
   userid               int not null,
   bid                  int not null,
   return_time          datetime not null,
   should_return_time   datetime not null,
   assessment           float not null,
   paid                 float not null,
   primary key (penalty_id)
);

/*==============================================================*/
/* Table: record                                                */
/*==============================================================*/
create table record
(
   record_id            int not null,
   bid                  int not null,
   userid               int not null,
   borrow_time          datetime not null,
   return_time          datetime not null,
   primary key (record_id)
);

/*==============================================================*/
/* Table: relation_book                                         */
/*==============================================================*/
create table relation_book
(
   bid                  int not null,
   cid                  int not null,
   primary key (bid, cid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   effective_date       date not null,
   expiry_date          date not null,
   type                 varchar(20) not null,
   profession           varchar(20) not null,
   userid               int not null,
   primary key (userid)
);

/*==============================================================*/
/* Index: student_PK                                            */
/*==============================================================*/
create unique index student_PK on user
(
   userid
);

alter table borrow_curr add constraint FK_borrow_bid foreign key (bid)
      references book (bid) on delete restrict on update restrict;

alter table borrow_curr add constraint FK_borrow_userid foreign key (userid)
      references user (userid) on delete restrict on update restrict;

alter table detailed_book add constraint FK_relationship_book foreign key (bid)
      references book (bid) on delete restrict on update restrict;

alter table detailed_user add constraint FK_relation_user foreign key (userid)
      references user (userid) on delete restrict on update restrict;

alter table penalty add constraint FK_penalty_bid foreign key (bid)
      references book (bid) on delete restrict on update restrict;

alter table penalty add constraint FK_penalty_userid foreign key (userid)
      references user (userid) on delete restrict on update restrict;

alter table record add constraint FK_record_bid foreign key (bid)
      references book (bid) on delete restrict on update restrict;

alter table record add constraint FK_record_userid foreign key (userid)
      references user (userid) on delete restrict on update restrict;

alter table relation_book add constraint FK_relation_book foreign key (bid)
      references book (bid) on delete restrict on update restrict;

alter table relation_book add constraint FK_relation_book2 foreign key (cid)
      references category (cid) on delete restrict on update restrict;

