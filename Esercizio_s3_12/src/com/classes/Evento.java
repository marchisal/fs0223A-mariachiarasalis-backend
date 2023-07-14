package com.classes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enums.TipoEvento;

@Entity
@Table(name = "events")

public class Evento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
    @Column(name = "title", nullable = false)
     private String title;
    @Column(name = "date", nullable = false)
     private LocalDate eventDate;
    @Column(name = "description", nullable = false)
     private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "privacy")
     private TipoEvento eventType;
    @Column(name = "attendees", nullable = false)
     private int attendees;

    public Evento() {
        super();
    }

	public Evento(String title, LocalDate eventDate, String description, TipoEvento eventType, int attendees) {
		super();
		this.title = title;
		this.eventDate = eventDate;
		this.description = description;
		this.eventType = eventType;
		this.attendees = attendees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TipoEvento getEventType() {
		return eventType;
	}

	public void setEventType(TipoEvento eventType) {
		this.eventType = eventType;
	}

	public int getAttendees() {
		return attendees;
	}

	public void setAttendees(int attendees) {
		this.attendees = attendees;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", title=" + title + ", eventDate=" + eventDate + ", description=" + description
				+ ", eventType=" + eventType + ", attendees=" + attendees + "]";
	}
    
    
}
