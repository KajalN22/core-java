package com.taskmanager.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.taskmanager.core.Status;
import com.taskmanager.core.Task;
//String taskName, String desc, LocalDate taskDate,Status status boolean active
public class TaskManagerUtils {

	public static List<Task> populateTask() {
		       Task task1 = new Task("Complete project proposal", "Write a detailed proposal for the upcoming project", LocalDate.of(2024, 6, 10));
		       Task task2 = new  Task("Prepare presentation slides", "Create slides for the project presentation",LocalDate.of(2024, 6, 15));
		       Task  task3 = new Task("Review project documentation", "Go through project documentation for accuracy",LocalDate.of(2024, 6, 12));
		       Task  task4 = new Task("Attend project meeting", "Participate in the weekly project meeting", LocalDate.of(2024, 6, 14));
		       Task task5 = new Task("Submit progress report", "Submit the weekly progress report to the team lead", LocalDate.of(2024, 6,13));
		       Task task6 = new Task("Follow up with clients", "Contact clients for feedback on the recent service", LocalDate.of(2024, 6, 16));
               Task[] tasks= {task1,task2,task3,task4,task5,task6};
		       ArrayList<Task> taskList= new ArrayList<>();
				for (Task t:tasks)
					taskList.add(t);
				return taskList;
	}
	
	
}
