CREATE TABLE days
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    date      VARCHAR(255),
    weight_id BIGINT,
    CONSTRAINT pk_days PRIMARY KEY (id)
);

CREATE TABLE medications
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    day_id      BIGINT,
    name        VARCHAR(255),
    quantity    INT                   NOT NULL,
    strength    INT                   NOT NULL,
    dosage_unit VARCHAR(255),
    CONSTRAINT pk_medications PRIMARY KEY (id)
);
CREATE TABLE meal
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    timestamp VARCHAR(255),
    day_id    BIGINT,
    CONSTRAINT pk_meal PRIMARY KEY (id)
);
CREATE TABLE foods
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    meal_id  BIGINT,
    name     VARCHAR(255),
    calories INT                   NOT NULL,
    carbs    INT                   NOT NULL,
    protein  INT                   NOT NULL,
    fat      INT                   NOT NULL,
    CONSTRAINT pk_foods PRIMARY KEY (id)
);
CREATE TABLE weights
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    unit    VARCHAR(255),
    "value" DOUBLE                NOT NULL,
    CONSTRAINT pk_weights PRIMARY KEY (id)
);
ALTER TABLE days
    ADD CONSTRAINT FK_DAYS_ON_WEIGHT FOREIGN KEY (weight_id) REFERENCES weights (id);
