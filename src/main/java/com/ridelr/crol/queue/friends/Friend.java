package com.ridelr.crol.queue.friends;

import java.sql.Timestamp;

public class Friend {
    private final long id;
    private final int userId;
    private final Timestamp addedDt;
    private final Timestamp scheduledDt;
    private final Timestamp processedDt;
    private final String firstName;
    private final String lastName;
    private final String photo50;
    private final String photo100;
    private final String photo200;
    private final short sex;
    private final String bdate;
    private final short verified;

    public Friend(long id, int userId, Timestamp addedDt, Timestamp scheduledDt, Timestamp processedDt,
                  String firstName, String lastName, String photo50, String photo100, String photo200,
                  short sex, String bdate, short verified) {
        this.id = id;
        this.userId = userId;
        this.addedDt = addedDt;
        this.scheduledDt = scheduledDt;
        this.processedDt = processedDt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo50 = photo50;
        this.photo100 = photo100;
        this.photo200 = photo200;
        this.sex = sex;
        this.bdate = bdate;
        this.verified = verified;
    }

    public long getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Timestamp getAddedDt() {
        return addedDt;
    }

    public Timestamp getScheduledDt() {
        return scheduledDt;
    }

    public Timestamp getProcessedDt() {
        return processedDt;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoto50() {
        return photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public String getPhoto200() {
        return photo200;
    }

    public short getSex() {
        return sex;
    }

    public String getBdate() {
        return bdate;
    }

    public short getVerified() {
        return verified;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", userId=" + userId +
                ", addedDt=" + addedDt +
                ", scheduledDt=" + scheduledDt +
                ", processedDt=" + processedDt +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo50='" + photo50 + '\'' +
                ", photo100='" + photo100 + '\'' +
                ", photo200='" + photo200 + '\'' +
                ", sex=" + sex +
                ", bdate='" + bdate + '\'' +
                ", verified=" + verified +
                '}';
    }
}
