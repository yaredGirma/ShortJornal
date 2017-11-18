package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class FeedBack implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Size(min = 2, max = 50, message = "{size.privateMessage.subject.validation}")
	private String subject;

	@Size(min = 2, max = 500, message = "{size.privateMessage.message.validation}")
	@Column(nullable = false)
	private String message;

	@Size(min = 2, max = 50, message = "{size.privateMessage.usename.validation}")
	@Column(nullable = false)
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
