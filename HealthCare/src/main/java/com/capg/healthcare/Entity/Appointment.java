package com.capg.healthcare.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "APPOINTMENT")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@SequenceGenerator(sequenceName = "appointment_seq", allocationSize = 1, name = "appointment_seq")
	private long appointmentId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "centerId", nullable = false)
	private DiagnosticCenter center;

	 @OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "userId", nullable = false)
	 private Users user;

	private Date datetime;

	private boolean approved;

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	

	public Appointment(long appointmentId, DiagnosticCenter center, Users user, Date datetime, boolean approved) {
		super();
		this.appointmentId = appointmentId;
		this.center = center;
		this.user = user;
		this.datetime = datetime;
		this.approved = approved;
	}

	public Appointment() {
		super();
		
	}
}