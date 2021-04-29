CREATE TABLE IF NOT EXISTS "product"
(
    "id_product"        SERIAL PRIMARY KEY,
    "name_product"      TEXT   NOT NULL
);
CREATE TABLE IF NOT EXISTS "sales"
(
    "id_sales"      SERIAL PRIMARY KEY,
    "id"      SERIAL  REFERENCES product,
    "id_product"    SERIAL REFERENCES product
);