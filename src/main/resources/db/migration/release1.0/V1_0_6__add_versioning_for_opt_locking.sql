ALTER TABLE workers
    ADD COLUMN version SMALLINT NOT NULL DEFAULT -32768;

ALTER TABLE jobs
    ADD COLUMN version SMALLINT NOT NULL DEFAULT -32768;