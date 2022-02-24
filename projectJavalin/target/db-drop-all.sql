alter table arbitri drop foreign key fk_arbitri_anagrafica_id;

alter table designatori drop foreign key fk_designatori_anagrafica_id;

alter table designazione drop foreign key fk_designazione_designatore_id;
drop index ix_designazione_designatore_id on designazione;

alter table designazione drop foreign key fk_designazione_arbitro_id;

alter table designazione drop foreign key fk_designazione_partita_id;

alter table giocatore drop foreign key fk_giocatore_squadra_id;
drop index ix_giocatore_squadra_id on giocatore;

alter table giocatore drop foreign key fk_giocatore_amm_id;
drop index ix_giocatore_amm_id on giocatore;

alter table partite drop foreign key fk_partite_calendario_id;
drop index ix_partite_calendario_id on partite;

alter table partite drop foreign key fk_partite_casa_id;

alter table partite drop foreign key fk_partite_ospite_id;

alter table referti drop foreign key fk_referti_arbitro_id;
drop index ix_referti_arbitro_id on referti;

alter table referti drop foreign key fk_referti_partita_id;

alter table users drop foreign key fk_users_arbitro_id;

alter table users drop foreign key fk_users_designatore_id;

drop table if exists anagrafica;

drop table if exists arbitri;

drop table if exists calendario;

drop table if exists designatori;

drop table if exists designazione;

drop table if exists giocatore;

drop table if exists partite;

drop table if exists referti;

drop table if exists squadre;

drop table if exists users;

