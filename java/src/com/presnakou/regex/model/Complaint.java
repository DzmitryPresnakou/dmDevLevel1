package com.presnakou.regex.model;

import com.presnakou.regex.utils.RegexHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Complaint {
    private static long CLASS_ID = 0;
    private long id;
    private LocalDateTime time;
    private String fullName;
    private String phoneNumber;
    private String description;

    public Complaint(long id, LocalDateTime time, String fullName, String phoneNumber, String description) {
        CLASS_ID++;
        this.id = Math.max(id, CLASS_ID);
        this.time = time;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Complaint(String fullName, String phoneNumber, String description) {
        CLASS_ID++;
        this.id = CLASS_ID;
        this.time = LocalDateTime.parse(RegexHelper.getTimeDateNow(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return id == complaint.id && Objects.equals(time, complaint.time) && Objects.equals(fullName, complaint.fullName) && Objects.equals(phoneNumber, complaint.phoneNumber) && Objects.equals(description, complaint.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, fullName, phoneNumber, description);
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", time=" + time +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
