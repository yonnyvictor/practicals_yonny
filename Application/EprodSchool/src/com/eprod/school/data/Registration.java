package com.eprod.school.data;

import java.util.Date;

public class Registration {
    private int id;
    private int yearId;
    private int classId;
    private int streamId;
    private int studentId;
    private String mode;
    private Date date;
    private int createdBy;
    private Date created;
    private int modifiedBy;
    private Date modified;
    private String status;
    private Level level;
    private Student student;
    private Stream stream;
    private User createdByUser;
    private User modifiedByUser;


    public Registration() {
    }

    public Registration(int id, int yearId, int classId, int streamId, int studentId, String mode, Date date, Date created, int createdBy,
                        Date modified, int modifiedBy, String status) {
        this.id = id;
        this.yearId = yearId;
        this.classId = classId;
        this.streamId = streamId;
        this.studentId = studentId;
        this.mode = mode;
        this.date = date;
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

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStreamId() {
        return streamId;
    }

    public void setStreamId(int streamId) {
        this.streamId = streamId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public User getModifiedByUser() {
        return modifiedByUser;
    }

    public void setModifiedByUser(User modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }
}
