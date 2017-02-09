package edu.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Capacity {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer two;
	private Integer four;
	private Integer twoCost;
	private Integer fourCost;
	@Id
	@GeneratedValue
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="twocapacity")
	public Integer getTwo() {
		return two;
	}
	public void setTwo(Integer two) {
		this.two = two;
	}
	@Column(name="fourcapacity")
	public Integer getFour() {
		return four;
	}
	public void setFour(Integer four) {
		this.four = four;
	}
	@Column(name="twocost")
	public Integer getTwoCost() {
		return twoCost;
	}
	public void setTwoCost(Integer twoCost) {
		this.twoCost = twoCost;
	}
	@Column(name="fourcost")
	public Integer getFourCost() {
		return fourCost;
	}
	public void setFourCost(Integer fourCost) {
		this.fourCost = fourCost;
	}


}
