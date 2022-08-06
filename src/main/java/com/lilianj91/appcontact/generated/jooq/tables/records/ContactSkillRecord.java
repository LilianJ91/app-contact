/*
 * This file is generated by jOOQ.
 */
package com.lilianj91.appcontact.generated.jooq.tables.records;


import com.lilianj91.appcontact.generated.jooq.tables.ContactSkill;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ContactSkillRecord extends UpdatableRecordImpl<ContactSkillRecord> implements Record3<JSONB, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>contact.contact_skill.level</code>.
     */
    public void setLevel(JSONB value) {
        set(0, value);
    }

    /**
     * Getter for <code>contact.contact_skill.level</code>.
     */
    public JSONB getLevel() {
        return (JSONB) get(0);
    }

    /**
     * Setter for <code>contact.contact_skill.fk_contact_email</code>.
     */
    public void setFkContactEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>contact.contact_skill.fk_contact_email</code>.
     */
    public String getFkContactEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>contact.contact_skill.fk_skill_name</code>.
     */
    public void setFkSkillName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>contact.contact_skill.fk_skill_name</code>.
     */
    public String getFkSkillName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<JSONB, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<JSONB, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<JSONB> field1() {
        return ContactSkill.CONTACT_SKILL.LEVEL;
    }

    @Override
    public Field<String> field2() {
        return ContactSkill.CONTACT_SKILL.FK_CONTACT_EMAIL;
    }

    @Override
    public Field<String> field3() {
        return ContactSkill.CONTACT_SKILL.FK_SKILL_NAME;
    }

    @Override
    public JSONB component1() {
        return getLevel();
    }

    @Override
    public String component2() {
        return getFkContactEmail();
    }

    @Override
    public String component3() {
        return getFkSkillName();
    }

    @Override
    public JSONB value1() {
        return getLevel();
    }

    @Override
    public String value2() {
        return getFkContactEmail();
    }

    @Override
    public String value3() {
        return getFkSkillName();
    }

    @Override
    public ContactSkillRecord value1(JSONB value) {
        setLevel(value);
        return this;
    }

    @Override
    public ContactSkillRecord value2(String value) {
        setFkContactEmail(value);
        return this;
    }

    @Override
    public ContactSkillRecord value3(String value) {
        setFkSkillName(value);
        return this;
    }

    @Override
    public ContactSkillRecord values(JSONB value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ContactSkillRecord
     */
    public ContactSkillRecord() {
        super(ContactSkill.CONTACT_SKILL);
    }

    /**
     * Create a detached, initialised ContactSkillRecord
     */
    public ContactSkillRecord(JSONB level, String fkContactEmail, String fkSkillName) {
        super(ContactSkill.CONTACT_SKILL);

        setLevel(level);
        setFkContactEmail(fkContactEmail);
        setFkSkillName(fkSkillName);
    }
}
