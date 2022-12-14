/*
 * This file is generated by jOOQ.
 */
package com.lilianj91.appcontact.generated.jooq.tables.records;


import com.lilianj91.appcontact.generated.jooq.tables.Contact;

import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ContactRecord extends UpdatableRecordImpl<ContactRecord> implements Record7<String, String, String, OffsetDateTime, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>contact.contact.first_name</code>.
     */
    public void setFirstName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>contact.contact.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>contact.contact.last_name</code>.
     */
    public void setLastName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>contact.contact.last_name</code>.
     */
    public String getLastName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>contact.contact.full_name</code>.
     */
    public void setFullName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>contact.contact.full_name</code>.
     */
    public String getFullName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>contact.contact.birth_date</code>.
     */
    public void setBirthDate(OffsetDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>contact.contact.birth_date</code>.
     */
    public OffsetDateTime getBirthDate() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>contact.contact.address</code>.
     */
    public void setAddress(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>contact.contact.address</code>.
     */
    public String getAddress() {
        return (String) get(4);
    }

    /**
     * Setter for <code>contact.contact.email</code>.
     */
    public void setEmail(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>contact.contact.email</code>.
     */
    public String getEmail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>contact.contact.mobile_phone_number</code>.
     */
    public void setMobilePhoneNumber(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>contact.contact.mobile_phone_number</code>.
     */
    public String getMobilePhoneNumber() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, String, OffsetDateTime, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, String, String, OffsetDateTime, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Contact.CONTACT_.FIRST_NAME;
    }

    @Override
    public Field<String> field2() {
        return Contact.CONTACT_.LAST_NAME;
    }

    @Override
    public Field<String> field3() {
        return Contact.CONTACT_.FULL_NAME;
    }

    @Override
    public Field<OffsetDateTime> field4() {
        return Contact.CONTACT_.BIRTH_DATE;
    }

    @Override
    public Field<String> field5() {
        return Contact.CONTACT_.ADDRESS;
    }

    @Override
    public Field<String> field6() {
        return Contact.CONTACT_.EMAIL;
    }

    @Override
    public Field<String> field7() {
        return Contact.CONTACT_.MOBILE_PHONE_NUMBER;
    }

    @Override
    public String component1() {
        return getFirstName();
    }

    @Override
    public String component2() {
        return getLastName();
    }

    @Override
    public String component3() {
        return getFullName();
    }

    @Override
    public OffsetDateTime component4() {
        return getBirthDate();
    }

    @Override
    public String component5() {
        return getAddress();
    }

    @Override
    public String component6() {
        return getEmail();
    }

    @Override
    public String component7() {
        return getMobilePhoneNumber();
    }

    @Override
    public String value1() {
        return getFirstName();
    }

    @Override
    public String value2() {
        return getLastName();
    }

    @Override
    public String value3() {
        return getFullName();
    }

    @Override
    public OffsetDateTime value4() {
        return getBirthDate();
    }

    @Override
    public String value5() {
        return getAddress();
    }

    @Override
    public String value6() {
        return getEmail();
    }

    @Override
    public String value7() {
        return getMobilePhoneNumber();
    }

    @Override
    public ContactRecord value1(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public ContactRecord value2(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public ContactRecord value3(String value) {
        setFullName(value);
        return this;
    }

    @Override
    public ContactRecord value4(OffsetDateTime value) {
        setBirthDate(value);
        return this;
    }

    @Override
    public ContactRecord value5(String value) {
        setAddress(value);
        return this;
    }

    @Override
    public ContactRecord value6(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public ContactRecord value7(String value) {
        setMobilePhoneNumber(value);
        return this;
    }

    @Override
    public ContactRecord values(String value1, String value2, String value3, OffsetDateTime value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ContactRecord
     */
    public ContactRecord() {
        super(Contact.CONTACT_);
    }

    /**
     * Create a detached, initialised ContactRecord
     */
    public ContactRecord(String firstName, String lastName, String fullName, OffsetDateTime birthDate, String address, String email, String mobilePhoneNumber) {
        super(Contact.CONTACT_);

        setFirstName(firstName);
        setLastName(lastName);
        setFullName(fullName);
        setBirthDate(birthDate);
        setAddress(address);
        setEmail(email);
        setMobilePhoneNumber(mobilePhoneNumber);
    }
}
