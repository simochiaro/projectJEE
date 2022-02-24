create table anagrafica (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  cognome                       varchar(255),
  cf                            varchar(255),
  nascita                       date,
  constraint pk_anagrafica primary key (id)
);

create table arbitri (
  id                            bigint auto_increment not null,
  categoria                     integer,
  nuova_designazione            tinyint(1),
  anagrafica_id                 bigint,
  constraint uq_arbitri_anagrafica_id unique (anagrafica_id),
  constraint pk_arbitri primary key (id)
);

create table calendario (
  id                            bigint auto_increment not null,
  constraint pk_calendario primary key (id)
);

create table designatori (
  id                            bigint auto_increment not null,
  anagrafica_id                 bigint,
  categoria                     integer,
  constraint uq_designatori_anagrafica_id unique (anagrafica_id),
  constraint pk_designatori primary key (id)
);

create table designazione (
  id                            bigint auto_increment not null,
  data                          date,
  designatore_id                bigint,
  accettata                     tinyint(1),
  arbitro_id                    bigint,
  partita_id                    bigint,
  constraint uq_designazione_arbitro_id unique (arbitro_id),
  constraint uq_designazione_partita_id unique (partita_id),
  constraint pk_designazione primary key (id)
);

create table giocatore (
  id                            bigint auto_increment not null,
  squadra_id                    bigint,
  amm_id                        bigint,
  nome                          varchar(255),
  cognome                       varchar(255),
  nascita                       datetime(6),
  constraint pk_giocatore primary key (id)
);

create table partite (
  id                            bigint auto_increment not null,
  esito                         varchar(255),
  calendario_id                 bigint,
  casa_id                       bigint,
  ospite_id                     bigint,
  categoria                     integer,
  constraint uq_partite_casa_id unique (casa_id),
  constraint uq_partite_ospite_id unique (ospite_id),
  constraint pk_partite primary key (id)
);

create table referti (
  id                            bigint auto_increment not null,
  arbitro_id                    bigint,
  esito                         varchar(255),
  partita_id                    bigint,
  constraint uq_referti_partita_id unique (partita_id),
  constraint pk_referti primary key (id)
);

create table squadre (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  constraint pk_squadre primary key (id)
);

create table users (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  arbitro_id                    bigint,
  designatore_id                bigint,
  constraint uq_users_arbitro_id unique (arbitro_id),
  constraint uq_users_designatore_id unique (designatore_id),
  constraint pk_users primary key (id)
);

alter table arbitri add constraint fk_arbitri_anagrafica_id foreign key (anagrafica_id) references anagrafica (id) on delete restrict on update restrict;

alter table designatori add constraint fk_designatori_anagrafica_id foreign key (anagrafica_id) references anagrafica (id) on delete restrict on update restrict;

create index ix_designazione_designatore_id on designazione (designatore_id);
alter table designazione add constraint fk_designazione_designatore_id foreign key (designatore_id) references designatori (id) on delete restrict on update restrict;

alter table designazione add constraint fk_designazione_arbitro_id foreign key (arbitro_id) references arbitri (id) on delete restrict on update restrict;

alter table designazione add constraint fk_designazione_partita_id foreign key (partita_id) references partite (id) on delete restrict on update restrict;

create index ix_giocatore_squadra_id on giocatore (squadra_id);
alter table giocatore add constraint fk_giocatore_squadra_id foreign key (squadra_id) references squadre (id) on delete restrict on update restrict;

create index ix_giocatore_amm_id on giocatore (amm_id);
alter table giocatore add constraint fk_giocatore_amm_id foreign key (amm_id) references referti (id) on delete restrict on update restrict;

create index ix_partite_calendario_id on partite (calendario_id);
alter table partite add constraint fk_partite_calendario_id foreign key (calendario_id) references calendario (id) on delete restrict on update restrict;

alter table partite add constraint fk_partite_casa_id foreign key (casa_id) references squadre (id) on delete restrict on update restrict;

alter table partite add constraint fk_partite_ospite_id foreign key (ospite_id) references squadre (id) on delete restrict on update restrict;

create index ix_referti_arbitro_id on referti (arbitro_id);
alter table referti add constraint fk_referti_arbitro_id foreign key (arbitro_id) references arbitri (id) on delete restrict on update restrict;

alter table referti add constraint fk_referti_partita_id foreign key (partita_id) references partite (id) on delete restrict on update restrict;

alter table users add constraint fk_users_arbitro_id foreign key (arbitro_id) references arbitri (id) on delete restrict on update restrict;

alter table users add constraint fk_users_designatore_id foreign key (designatore_id) references designatori (id) on delete restrict on update restrict;

