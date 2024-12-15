--
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0
-- Dumped by pg_dump version 17.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "Rubrica";
--
-- Name: Rubrica; Type: DATABASE; Schema: -; Owner: www
--

CREATE DATABASE "Rubrica" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Italian_Italy.1252';


ALTER DATABASE "Rubrica" OWNER TO www;

\connect "Rubrica"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: archivio; Type: TABLE; Schema: public; Owner: www
--

CREATE TABLE public.archivio (
    nome character varying NOT NULL,
    cognome character varying,
    numero character varying NOT NULL,
    mail character varying,
    numero2 character varying,
    mail2 character varying,
    numero3 character varying,
    mail3 character varying,
    preferito integer
);


ALTER TABLE public.archivio OWNER TO www;

--
-- Name: contatto; Type: TABLE; Schema: public; Owner: www
--

CREATE TABLE public.contatto (
    nome character varying,
    cognome character varying,
    numero character varying NOT NULL,
    mail character varying,
    numero2 character varying,
    mail2 character varying,
    numero3 character varying,
    mail3 character varying,
    preferito integer
);


ALTER TABLE public.contatto OWNER TO www;

--
-- Data for Name: archivio; Type: TABLE DATA; Schema: public; Owner: www
--

COPY public.archivio (nome, cognome, numero, mail, numero2, mail2, numero3, mail3, preferito) FROM stdin;
\.
COPY public.archivio (nome, cognome, numero, mail, numero2, mail2, numero3, mail3, preferito) FROM '$$PATH$$/4848.dat';

--
-- Data for Name: contatto; Type: TABLE DATA; Schema: public; Owner: www
--

COPY public.contatto (nome, cognome, numero, mail, numero2, mail2, numero3, mail3, preferito) FROM stdin;
\.
COPY public.contatto (nome, cognome, numero, mail, numero2, mail2, numero3, mail3, preferito) FROM '$$PATH$$/4847.dat';

--
-- Name: archivio archivio_pkey; Type: CONSTRAINT; Schema: public; Owner: www
--

ALTER TABLE ONLY public.archivio
    ADD CONSTRAINT archivio_pkey PRIMARY KEY (numero);


--
-- Name: contatto contatto_pkey; Type: CONSTRAINT; Schema: public; Owner: www
--

ALTER TABLE ONLY public.contatto
    ADD CONSTRAINT contatto_pkey PRIMARY KEY (numero);


--
-- PostgreSQL database dump complete
--

