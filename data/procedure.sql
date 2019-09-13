--drop trigger evenementEditerJoueur On joueur;
CREATE TRIGGER evenementEditerJoueur
	BEFORE UPDATE ON joueur
		FOR EACH ROW EXECUTE PROCEDURE
		journaliserEditerJoueur();

CREATE or REPLACE FUNCTION journaliserEditerJoueur()
RETURNS trigger
LANGUAGE 'plpgsql'


AS $$
DECLARE
    descriptionNouveau text;
	descriptionAncien text;
	description text;
BEGIN
	descriptionAncien := OLD.nom;
	descriptionNouveau := NEW.nom;
	description := descriptionAncien || '=>' || descriptionNouveau;
	insert into journal(moment, operation, objet, description) VALUES(NOW(), 'edition', 'joueur', 'test');
    return NEW;
END
$$

CREATE or REPLACE FUNCTION journaliserAjoutJoueur()
RETURNS trigger
LANGUAGE 'plpgsql'


AS $$
DECLARE
    description text;
BEGIN
	description := NEW.nom;
	insert into journal(moment, operation, objet, description) VALUES(NOW(), 'ajout', 'robot', 'test');
    return NEW;
END
$$

CREATE TRIGGER evenementAjoutJoueur
	BEFORE INSERT ON joueur
		FOR EACH ROW EXECUTE PROCEDURE
		journaliserAjoutJoueur();


CREATE TRIGGER evenementsuprimmerclub
    BEFORE DELETE
    ON public.club
    FOR EACH ROW
EXECUTE PROCEDURE public.journalisersuprimmerclub();

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

CREATE TRIGGER evenementajoutclub
    BEFORE INSERT
    ON public.club
    FOR EACH ROW
EXECUTE PROCEDURE public.journaliserajoutclub();

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

CREATE TRIGGER evenementediterclub
    BEFORE UPDATE
    ON public.club
    FOR EACH ROW
EXECUTE PROCEDURE public.journaliserediterclub();

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

CREATE TRIGGER evenementsuprimmerclub
    BEFORE DELETE
    ON public.club
    FOR EACH ROW
EXECUTE PROCEDURE public.journalisersuprimmerclub();