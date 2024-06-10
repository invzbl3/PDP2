CREATE TABLE backlog
(
    id          VARCHAR(255) PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE backlog_item
(
    id           VARCHAR(255) PRIMARY KEY,
    status       VARCHAR(255),
    story        TEXT,
    story_points INT,
    summary      TEXT,
    type         VARCHAR(255),
    product_id   VARCHAR(255),
    release_id   VARCHAR(255),
    sprint_id    VARCHAR(255),
    backlog_id   VARCHAR(255),
    FOREIGN KEY (backlog_id) REFERENCES backlog (id)
);

CREATE TABLE task
(
    id              VARCHAR(255) PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    description     TEXT,
    hours_remaining INT,
    volunteer       VARCHAR(255),
    backlog_item_id VARCHAR(255),
    FOREIGN KEY (backlog_item_id) REFERENCES backlog_item (id)
);