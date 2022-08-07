/*
 * This file is generated by jOOQ.
 */
package com.lilianj91.appcontact.generated.jooq;


import com.lilianj91.appcontact.generated.jooq.tables.ContactSkill;
import com.lilianj91.appcontact.generated.jooq.tables.Skill;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Contact extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>contact</code>
     */
    public static final Contact CONTACT = new Contact();

    /**
     * The table <code>contact.contact</code>.
     */
    public final com.lilianj91.appcontact.generated.jooq.tables.Contact CONTACT_ = com.lilianj91.appcontact.generated.jooq.tables.Contact.CONTACT_;

    /**
     * The table <code>contact.contact_skill</code>.
     */
    public final ContactSkill CONTACT_SKILL = ContactSkill.CONTACT_SKILL;

    /**
     * The table <code>contact.skill</code>.
     */
    public final Skill SKILL = Skill.SKILL;

    /**
     * No further instances allowed
     */
    private Contact() {
        super("contact", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            com.lilianj91.appcontact.generated.jooq.tables.Contact.CONTACT_,
            ContactSkill.CONTACT_SKILL,
            Skill.SKILL);
    }
}