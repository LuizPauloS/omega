CREATE SEQUENCE profissional_id_seq AS BIGINT START WITH 1 INCREMENT BY 1;

CREATE TABLE profissional (
  id BIGINT GENERATED BY DEFAULT AS SEQUENCE profissional_id_seq PRIMARY KEY,
  nome_profissional VARCHAR(255)
);
