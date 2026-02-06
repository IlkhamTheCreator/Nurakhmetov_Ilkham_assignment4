DROP TABLE IF EXISTS performers;
DROP TABLE IF EXISTS stages;

CREATE TABLE stages (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    location VARCHAR(100)
);

CREATE TABLE performers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    stage_id INT REFERENCES stages(id) ON DELETE SET NULL,
    performance_fee DECIMAL(10,2) CHECK (performance_fee > 0)
);
