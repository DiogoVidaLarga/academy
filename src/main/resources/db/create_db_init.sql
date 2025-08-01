CREATE TABLE T_TEAM
(
    id               UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name             text,
    product          text,
    created_at       TIMESTAMP,
    modified_at      TIMESTAMP,
    default_location varchar(10)
);
CREATE TABLE T_RACK
(
    id               UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    serial_number    text,
    status           varchar(10),
    team_id          UUID,
    default_location varchar(10),
    created_at       TIMESTAMP,
    modified_at      TIMESTAMP,
    assembled_at     TIMESTAMP,
    FOREIGN KEY (team_id) REFERENCES T_TEAM (id)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ID;
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_ID;
CREATE SEQUENCE IF NOT EXISTS SEQ_BOOKING_ID;
CREATE TABLE T_RACK_ASSET
(
    id        UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    asset_tag varchar(10),
    rack_id   UUID DEFAULT gen_random_uuid(),
    FOREIGN KEY (rack_id) REFERENCES T_RACK (id)
);
CREATE TABLE T_TEAM_MEMBER
(
    id          UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    team_id     uuid,
    ctw_id      text,
    name        text,
    created_at  TIMESTAMP,
    modified_at TIMESTAMP,
    FOREIGN KEY (team_id) REFERENCES T_TEAM (id)
);
CREATE TABLE T_BOOKING
(
    id            UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    rack_id       UUID,
    requester_id  UUID,
    serial_number text,
    book_from     TIMESTAMP,
    book_to       TIMESTAMP,
    created_at    TIMESTAMP,
    modified_at   TIMESTAMP,
    FOREIGN KEY (requester_id) REFERENCES T_TEAM_MEMBER (id),
    FOREIGN KEY (rack_id) REFERENCES T_RACK (id)
);
