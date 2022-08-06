CREATE TABLE contact.contact_skill (
    level JSONB NOT NULL,
    fk_contact_email TEXT NOT NULL,
    fk_skill_name TEXT NOT NULL,
    CONSTRAINT fk_contact_skill_contact_email FOREIGN KEY (fk_contact_email) REFERENCES contact.contact(email),
    CONSTRAINT fk_contact_skill_skill_name FOREIGN KEY (fk_skill_name) REFERENCES contact.skill(name),
    CONSTRAINT pk_contact_skill_contact_email_skill_name PRIMARY KEY(fk_contact_email, fk_skill_name)
);