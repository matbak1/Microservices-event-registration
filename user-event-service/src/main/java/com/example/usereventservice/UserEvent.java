package com.example.usereventservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mateusz on 2017-08-25.
 */
@Entity
public class UserEvent {

    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private long eventId;

    public UserEvent() {
    }

    public UserEvent(long id, long userId, long eventId) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
    }

    public UserEvent(long userId, long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "id=" + id +
                ", userId=" + userId +
                ", eventId=" + eventId +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getEventId() {
        return eventId;
    }
}
