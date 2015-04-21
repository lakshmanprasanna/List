package com.example.doublylinkedist;

public class Student {
	private String firstName;
	private String lastName;
	private int redId;
	private double gpa;

	public Student(String firstName, String lastName, int id, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.redId = id;
		this.gpa = gpa;
	}

	public boolean isOnProbation() {
		if (gpa < (double) 2.85) {
			return true;
		} else
			return false;
	}

	@Override
	public String toString() {
		String studentInfo = "[" + firstName + "," + lastName + "," + redId
				+ "," + gpa + "]";
		return studentInfo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getGpa() {
		return gpa;
	}

	public int getRedId() {
		return redId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void getLastName(String lastName) {
		this.lastName = lastName;
	}

	public void getGpa(double gpa) {
		this.gpa = gpa;
	}

	public void getRedId(int redId) {
		this.redId = redId;
		}
}