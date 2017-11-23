-- Table: public.departaments

-- DROP TABLE public.departaments;

CREATE TABLE public.departaments
(
    departament character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT departaments_pkey PRIMARY KEY (departament)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.departaments
    OWNER to postgres;