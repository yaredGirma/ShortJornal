package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity(name = "event")
public class Event implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private Long id;

	@NotEmpty(message="{NotEmpty}")
	@Column(length=1000)
	private String description;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "duration_id")
	@Valid
	private Duration duration;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "type_id")
	@Valid
	private Type type;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "frequency_id")
	@Valid
	private Frequency frequency;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "feeling_id")
	@Valid
	private Feeling feeling;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id")
	private UserCredentials user;

	@DateTimeFormat(pattern="mm-dd-yyyy")
	@NotNull(message="{NotNull}")
	@Past(message="{date.past.validation}")
	private Date date;

	public Event(Long id, String description, Duration duration, Type type, Frequency frequency, Feeling feeling,
			UserCredentials user, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.duration = duration;
		this.type = type;
		this.frequency = frequency;
		this.feeling = feeling;
		this.user = user;
		this.date = date;
	}

	public Event(String description, Duration duration, Type type, Frequency frequency, Feeling feeling,
			UserCredentials user, Date date) {
		super();
		this.description = description;
		this.duration = duration;
		this.type = type;
		this.frequency = frequency;
		this.feeling = feeling;
		this.user = user;
		this.date = date;
	}

	public Event() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public UserCredentials getUser() {
		return user;
	}

	public void setUser(UserCredentials user) {
		this.user = user;
	}

	public Feeling getFeeling() {
		return feeling;
	}

	public void setFeeling(Feeling feeling) {
		this.feeling = feeling;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
