-- Table: public.orders

-- DROP TABLE public.orders;

CREATE TABLE public.orders
(
    id SERIAL,
    title character varying(200) COLLATE pg_catalog."default" NOT NULL,
    type character varying(100) COLLATE pg_catalog."default" NOT NULL,
    master character varying(100) COLLATE pg_catalog."default" NOT NULL,
    start_date timestamp without time zone,
    end_date timestamp without time zone,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT orders_master_fkey FOREIGN KEY (master, type)
        REFERENCES public.masters (full_name, departament) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.orders
    OWNER to postgres;