drop table if exists symbols;
drop table if exists card_faces;
drop table if exists cards;
drop table if exists sets;
drop table if exists set_types;
drop view if exists sets_statistics;

create table if not exists symbols(
    id uuid not null default gen_random_uuid() primary key,
    code varchar not null,
    image_path varchar not null
);

create table if not exists set_types (
    id uuid not null default gen_random_uuid() primary key,
    code varchar not null,
    description varchar not null
);

insert into set_types (code,description) values ('core','A yearly Magic core set (Tenth Edition, etc)');
insert into set_types (code,description) values ('expansion','A rotational expansion set in a block (Zendikar, etc)');
insert into set_types (code,description) values ('masters','A reprint set that contains no new cards (Modern Masters, etc)');
insert into set_types (code,description) values ('alchemy','An Arena set designed for Alchemy');
insert into set_types (code,description) values ('masterpiece','Masterpiece Series premium foil cards');
insert into set_types (code,description) values ('arsenal','A Commander-oriented gift set');
insert into set_types (code,description) values ('from_the_vault','From the Vault gift sets');
insert into set_types (code,description) values ('spellbook','Spellbook series gift sets');
insert into set_types (code,description) values ('premium_deck','Premium Deck Series decks');
insert into set_types (code,description) values ('duel_deck','Duel Decks');
insert into set_types (code,description) values ('draft_innovation','Special draft sets, like Conspiracy and Battlebond');
insert into set_types (code,description) values ('treasure_chest','Magic Online treasure chest prize sets');
insert into set_types (code,description) values ('commander','Commander preconstructed decks');
insert into set_types (code,description) values ('planechase','Planechase sets');
insert into set_types (code,description) values ('archenemy','Archenemy sets');
insert into set_types (code,description) values ('vanguard','Vanguard card sets');
insert into set_types (code,description) values ('funny','A funny un-set or set with funny promos (Unglued, Happy Holidays, etc)');
insert into set_types (code,description) values ('starter','A starter/introductory set (Portal, etc)');
insert into set_types (code,description) values ('box','A gift box set');
insert into set_types (code,description) values ('promo','A set that contains purely promotional cards');
insert into set_types (code,description) values ('token','A set made up of tokens and emblems.');
insert into set_types (code,description) values ('memorabilia','A set made up of gold-bordered, oversize, or trophy cards that are not legal');
insert into set_types (code,description) values ('minigame','A set that contains minigame card inserts from booster packs');

create table if not exists sets (
    id uuid not null default gen_random_uuid() primary key,
    code varchar not null,
    name varchar not null,
    total_cards int not null,
    owned_cards int not null,
    icon_path varchar not null,
    release_date date not null,
    set_type_id uuid not null,
    constraint sets_fk foreign key (set_type_id) references set_types(id)
);

create table if not exists cards (
    id uuid not null default gen_random_uuid() primary key,
    set_id uuid not null,
    cardmarket_id int,
    collector_number varchar not null,
    numeric_collector_number int not null,
    name varchar not null,
    flavor_text varchar,
    oracle_text varchar,
    mana_cost varchar,
    type_line varchar,
    rarity varchar not null,
    power varchar,
    toughness varchar,
    slug varchar not null,
    non_foil_quantity int not null,
    foil_quantity int not null,
    small_image varchar,
    normal_image varchar,
    large_image varchar,
    art_crop_image varchar,
    border_crop_image varchar,
    non_foil_price float,
    foil_price float,
    constraint cards_fk foreign key (set_id) references sets(id)
);

create table if not exists card_faces (
    id uuid not null default gen_random_uuid() primary key,
    card_id uuid not null,
    name varchar not null,
    mana_cost varchar,
    type_line varchar,
    oracle_text varchar,
    power varchar,
    toughness varchar,
    constraint cards_fk foreign key (card_id) references cards(id)
);

create or replace view sets_statistics as
select
    sets.code as code,
    sets.name as name,
    round(sum(coalesce(cards.non_foil_price,0))::numeric,2) as total_non_foil_price,
    round(sum(coalesce(cards.foil_price,0))::numeric,2) as total_foil_price
from sets inner join cards on sets.id = cards.set_id
group by sets.code, sets.name
;