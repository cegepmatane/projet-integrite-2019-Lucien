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
	insert into journal(moment, operation, objet, description) VALUES(NOW(), 'edition', 'robot', 'test');
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
