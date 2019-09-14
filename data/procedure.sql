-- Table: public.club

-- DROP TABLE public.club;

CREATE TABLE public.club
(
    id integer NOT NULL DEFAULT nextval('"Club_id_seq"'::regclass),
    nom text COLLATE pg_catalog."default",
    dirigeant text COLLATE pg_catalog."default",
    adresse text COLLATE pg_catalog."default",
    id_joueur integer NOT NULL,
    datecreation integer,
    CONSTRAINT "Club_pkey" PRIMARY KEY (id),
    CONSTRAINT club_id_joueur_fkey FOREIGN KEY (id_joueur)
        REFERENCES public.joueur (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.club
    OWNER to postgres;

-- Trigger: evenementajoutclub

-- DROP TRIGGER evenementajoutclub ON public.club;

CREATE TRIGGER evenementajoutclub
    BEFORE INSERT
    ON public.club
    FOR EACH ROW
EXECUTE PROCEDURE public.journaliserajoutclub();

-- Trigger: evenementediterclub

-- DROP TRIGGER evenementediterclub ON public.club;

CREATE TRIGGER evenementediterclub
    BEFORE UPDATE
    ON public.club
    FOR EACH ROW
EXECUTE PROCEDURE public.journaliserediterclub();

-- Trigger: evenementsuprimmerclub

-- DROP TRIGGER evenementsuprimmerclub ON public.club;

CREATE TRIGGER evenementsuprimmerclub
    BEFORE DELETE
    ON public.club
    FOR EACH ROW
EXECUTE PROCEDURE public.journalisersuprimmerclub();



-- Table: public.joueur

-- DROP TABLE public.joueur;

CREATE TABLE public.joueur
(
    id integer NOT NULL DEFAULT nextval('joueur_id_seq'::regclass),
    nom text COLLATE pg_catalog."default" NOT NULL,
    poids text COLLATE pg_catalog."default" NOT NULL,
    naissance text COLLATE pg_catalog."default" NOT NULL,
    age integer,
    id_joueur integer,
    CONSTRAINT joueur_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.joueur
    OWNER to postgres;

-- Trigger: evenementajoutjoueur

-- DROP TRIGGER evenementajoutjoueur ON public.joueur;

CREATE TRIGGER evenementajoutjoueur
    BEFORE INSERT
    ON public.joueur
    FOR EACH ROW
EXECUTE PROCEDURE public.journaliserajoutjoueur();

-- Trigger: evenementediterjoueur

-- DROP TRIGGER evenementediterjoueur ON public.joueur;

CREATE TRIGGER evenementediterjoueur
    BEFORE UPDATE
    ON public.joueur
    FOR EACH ROW
EXECUTE PROCEDURE public.journaliserediterjoueur();

-- Trigger: evenementsuprimmerjoueur

-- DROP TRIGGER evenementsuprimmerjoueur ON public.joueur;

CREATE TRIGGER evenementsuprimmerjoueur
    BEFORE DELETE
    ON public.joueur
    FOR EACH ROW
EXECUTE PROCEDURE public.journalisersuprimmerjoueur();




-- FUNCTION: public.journaliserajoutclub()

-- DROP FUNCTION public.journaliserajoutclub();

CREATE FUNCTION public.journaliserajoutclub()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE
    description text;
BEGIN
    description := NEW.nom;
    insert into journal(moment, operation, objet, description) VALUES(NOW(), 'ajout', 'club', description);
    return NEW;
END
$BODY$;

ALTER FUNCTION public.journaliserajoutclub()
    OWNER TO postgres;



-- FUNCTION: public.journaliserajoutjoueur()

-- DROP FUNCTION public.journaliserajoutjoueur();

CREATE FUNCTION public.journaliserajoutjoueur()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE
    description text;
BEGIN
    description := NEW.nom;
    insert into journal(moment, operation, objet, description) VALUES(NOW(), 'ajout', 'robot', 'test');
    return NEW;
END
$BODY$;

ALTER FUNCTION public.journaliserajoutjoueur()
    OWNER TO postgres;



-- FUNCTION: public.journaliserediterclub()

-- DROP FUNCTION public.journaliserediterclub();

CREATE FUNCTION public.journaliserediterclub()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE
    descriptionNouveau text;
    descriptionAncien text;
    description text;
BEGIN
    descriptionAncien := OLD.nom;
    descriptionNouveau := NEW.nom;
    description := descriptionAncien || '=>' || descriptionNouveau;
    insert into journal(moment, operation, objet, description) VALUES(NOW(), 'edition', 'club', 'test');
    return NEW;
END
$BODY$;

ALTER FUNCTION public.journaliserediterclub()
    OWNER TO postgres;




-- FUNCTION: public.journaliserediterjoueur()

-- DROP FUNCTION public.journaliserediterjoueur();

CREATE FUNCTION public.journaliserediterjoueur()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE
    descriptionNouveau text;
    descriptionAncien text;
    description text;
BEGIN
    descriptionAncien := OLD.nom;
    descriptionNouveau := NEW.nom;
    description := descriptionAncien || '=>' || descriptionNouveau;
    insert into journal(moment, operation, objet, description) VALUES(NOW(), 'edition', 'robot', 'test');
    return NEW;
END
$BODY$;

ALTER FUNCTION public.journaliserediterjoueur()
    OWNER TO postgres;




-- FUNCTION: public.journalisersuprimmerclub()

-- DROP FUNCTION public.journalisersuprimmerclub();

CREATE FUNCTION public.journalisersuprimmerclub()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE
    description text;
BEGIN
    description := NEW.nom;
    insert into journal(moment, operation, objet, description) VALUES(NOW(), 'supression', 'club', 'test');
    return NEW;
END
$BODY$;

ALTER FUNCTION public.journalisersuprimmerclub()
    OWNER TO postgres;



-- FUNCTION: public.journalisersuprimmerjoueur()

-- DROP FUNCTION public.journalisersuprimmerjoueur();

CREATE FUNCTION public.journalisersuprimmerjoueur()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
DECLARE
    description text;
BEGIN
    description := NEW.nom;
    insert into journal(moment, operation, objet, description) VALUES(NOW(), 'supression', 'robot', 'test');
    return NEW;
END
$BODY$;

ALTER FUNCTION public.journalisersuprimmerjoueur()
    OWNER TO postgres;
