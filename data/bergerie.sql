

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;


CREATE TABLE joueur (
    nom text,
    couleur text,
    poids text,
    naissance text,
    id integer NOT NULL
);


ALTER TABLE joueur OWNER TO postgres;

--
-- Name: mouton_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE joueur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mouton_id_seq OWNER TO postgres;

--
-- Name: mouton_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE mouton_id_seq OWNED BY joueur.id;



ALTER TABLE ONLY joueur ALTER COLUMN id SET DEFAULT nextval('joueur_id_seq'::regclass);


--
-- PostgreSQL database dump complete
--

-- Table: public."Club"

-- DROP TABLE public."Club";

CREATE TABLE public."Club"
(
    id integer NOT NULL DEFAULT nextval('"Club_id_seq"'::regclass),
    nom text COLLATE pg_catalog."default",
    dirigeant text COLLATE pg_catalog."default",
    adresse text COLLATE pg_catalog."default",
    telephone text COLLATE pg_catalog."default",
    id_carton integer NOT NULL,
    CONSTRAINT "Club_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Club"
    OWNER to postgres;
