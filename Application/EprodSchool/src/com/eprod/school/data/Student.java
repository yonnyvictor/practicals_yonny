package com.eprod.school.data;


import java.util.Date;

public class Student {
    private int id;
    private String firstName;
    private String middleName;
    private String otherName;
    private String surname;
    private String gender;
    private String admissionNumber;
    private String parentalStatus;
    private String father;
    private String fatherContact;
    private String mother;
    private String motherContact;
    private String county;
    private String constituency;
    private String district;
    private String address;
    private String photo;
    private int siblings;
    private Date dob;
    private Date admissionDate;
    private int createdBy;
    private Date created;
    private int modifiedBy;
    private Date modified;
    private String status;
    

    public Student() {
    }

    public Student(int id, String admissionNumber, String firstName, String middleName, String otherName,
                   String surname, String gender, String parentalStatus, String father, String fatherContact,
                   String mother, String motherContact, String address, String district, String constituency,
                   String county, String photo, int siblings, Date dob, Date admissionDate, Date created,
                   int createdBy, Date modified, int modifiedBy, String status) {
        this.id = id;
        this.admissionNumber = admissionNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.otherName = otherName;
        this.surname = surname;
        this.gender = gender;
        this.parentalStatus = parentalStatus;
        this.father = father;
        this.fatherContact = fatherContact;
        this.mother = mother;
        this.motherContact = motherContact;
        this.constituency = constituency;
        this.district = district;
        this.address = address;
        this.county = county;
        this.photo = photo;
        this.siblings = siblings;
        this.dob = dob;
        this.admissionDate = admissionDate;
        this.created = created;
        this.createdBy = createdBy;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getParentalStatus() {
        return parentalStatus;
    }

    public void setParentalStatus(String parentalStatus) {
        this.parentalStatus = parentalStatus;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getFatherContact() {
        return fatherContact;
    }

    public void setFatherContact(String fatherContact) {
        this.fatherContact = fatherContact;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getMotherContact() {
        return motherContact;
    }

    public void setMotherContact(String motherContact) {
        this.motherContact = motherContact;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSiblings() {
        return siblings;
    }

    public void setSiblings(int siblings) {
        this.siblings = siblings;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
