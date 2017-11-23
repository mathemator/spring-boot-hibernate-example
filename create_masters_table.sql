-- Table: public.masters

-- DROP TABLE public.masters;

CREATE TABLE public.masters
(
    id integer NOT NULL DEFAULT nextval('employees_employee_id_seq'::regclass),
    full_name character varying COLLATE pg_catalog."default" NOT NULL,
    departament character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employees_pkey PRIMARY KEY (id),
    CONSTRAINT masters_full_name_departament_key UNIQUE (full_name, departament),
    CONSTRAINT departaments_fkey FOREIGN KEY (departament)
        REFERENCES public.departaments (departament) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.masters
    OWNER to postgres;