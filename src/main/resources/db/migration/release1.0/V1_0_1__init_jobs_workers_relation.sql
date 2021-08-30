CREATE TABLE IF NOT EXISTS jobs
(
    id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS jobs_workers
(
    id BIGSERIAL PRIMARY KEY,
    worker_id UUID REFERENCES workers(id),
    job_id UUID REFERENCES jobs(id)
);