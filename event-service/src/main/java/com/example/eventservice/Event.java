package com.example.eventservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mateusz on 2017-08-25.
 */
@Entity
public class Event {

    @Id
    @GeneratedValue

    long id;
    String eventName;
    String category;
    String localization;
    Double cost;
    int maxMemberCount;
    String description;

    public Event() {
    }

    public Event(String eventName, String category, String localization, Double cost, int maxMemberCount, String description) {
        this.eventName = eventName;
        this.category = category;
        this.localization = localization;
        this.cost = cost;
        this.maxMemberCount = maxMemberCount;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", category='" + category + '\'' +
                ", localization='" + localization + '\'' +
                ", cost=" + cost +
                ", maxMemberCount=" + maxMemberCount +
                ", description='" + description + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setMaxMemberCount(int maxMemberCount) {
        this.maxMemberCount = maxMemberCount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCategory() {
        return category;
    }

    public String getLocalization() {
        return localization;
    }

    public Double getCost() {
        return cost;
    }

    public int getMaxMemberCount() {
        return maxMemberCount;
    }

    public String getDescription() {
        return description;
    }
}
