package com.taskmanager.core;

import java.time.LocalDate;

public class Task{

	
	private static int count=0;
	private int taskId;
	private String taskName;
	private String desc;
	private LocalDate taskDate;
	private Status status;
    private boolean active;


   //constructor
   public Task(String taskName, String desc, LocalDate taskDate) {
	super();
	this.taskId = ++count;
	this.taskName = taskName;
	this.desc = desc;
	this.taskDate = taskDate;
	this.status=Status.PENDING;
	this.active = true;
  }

//getters setters

public int getTaskId() {
	return taskId;
}


public void setTaskId(int taskId) {
	this.taskId = taskId;
}


public String getTaskName() {
	return taskName;
}


public void setTaskName(String taskName) {
	this.taskName = taskName;
}


public String getDesc() {
	return desc;
}


public void setDesc(String desc) {
	this.desc = desc;
}


public LocalDate getTaskDate() {
	return taskDate;
}


public void setTaskDate(LocalDate taskDate) {
	this.taskDate = taskDate;
}


public Status getStatus() {
	return status;
}


public void setStatus(Status status) {
	this.status = status;
}


public boolean isActive() {
	return active;
}


public void setActive(boolean active) {
	this.active = active;
}
   //toString

@Override
public String toString() {
	return "Tasks [taskId=" + taskId + ", taskName=" + taskName + ", desc=" + desc + ", taskDate=" + taskDate
			+ ", status=" + status + ", active=" + active + "]";
}

}