# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table menuItems (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_menuItems primary key (id))
;

create table pics (
  id                        bigint auto_increment not null,
  menu_item_id              bigint,
  src                       varchar(255),
  constraint pk_pics primary key (id))
;

alter table pics add constraint fk_pics_menuItem_1 foreign key (menu_item_id) references menuItems (id) on delete restrict on update restrict;
create index ix_pics_menuItem_1 on pics (menu_item_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table menuItems;

drop table pics;

SET FOREIGN_KEY_CHECKS=1;

