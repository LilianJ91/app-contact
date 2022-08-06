CREATE TABLE contact.contact (
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    full_name TEXT NOT NULL,
    birth_date TIMESTAMPTZ,
    address TEXT NOT NULL,
    email TEXT NOT NULL,
    mobile_phone_number TEXT NOT NULL,
    CONSTRAINT pk_contact_email PRIMARY KEY (email)
);