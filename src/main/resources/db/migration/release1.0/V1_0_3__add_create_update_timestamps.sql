ALTER TABLE jobs
    ADD COLUMN created_at       DATE NOT NULL DEFAULT now(),
    ADD COLUMN last_modified_at DATE;


ALTER TABLE workers
    ADD COLUMN created_at       DATE NOT NULL DEFAULT now(),
    ADD COLUMN last_modified_at DATE;

ALTER TABLE jobs_workers
    ADD COLUMN created_at       DATE NOT NULL DEFAULT now(),
    ADD COLUMN last_modified_at DATE;