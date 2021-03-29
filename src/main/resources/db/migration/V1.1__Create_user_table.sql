CREATE TABLE IF NOT EXISTS "user_account"
(
    "id"        SERIAL PRIMARY KEY,
    "name"      TEXT   NOT NULL,
    "telephone" TEXT   NOT NULL,
    "birthdate" TEXT   NOT NULL,
    "gender"    TEXT   NOT NULL
);