package com.taskmanager.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.taskmanager.core.Task;
import com.taskmanager.utils.TaskManagerUtils;
public class TaskManagerTester {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
			//init phase
			boolean exit=false;
			//init data structure
			List<Task> taskList=TaskManagerUtils.populateTask();
			
			while(!exit) {
				System.out.println("Options:"
						+ " 1.Add new task"
						+ " 2.Delete a task"
						+ " 3.update Task status"
						+ " 4.display all pending tasks"
						+ " 5.Display all pending tasks for today "
						+ " 6.Display all tasks sorted by taskDate"
						+ "7. Display all tasks"
						+ " 0. Exit ");
				System.out.println("Choose an option");
				
				try {
					switch(sc.nextInt())
					{
					case 1: 
	                     //add new task
						//String taskName, String desc, LocalDate taskDate,boolean active
						System.out.println(sc.nextLine());
						System.out.println("Enter taskName");
						String nm=sc.nextLine();
						System.out.println("Enter task Description:");
						String desc=sc.nextLine();
						System.out.println("Enter taskDate");
						String date=sc.nextLine();
                        Task task=com.taskmanager.utils.TaskManagaerValidationRules.validateTaskmanagerInputs(nm,desc,date,taskList);
                        taskList.add(task);
                        System.out.println("Task added successfully"+ task);
						break;
						
					case 2: 
						//delete task 
						System.out.println("Enter task Id to delete task: ");
						com.taskmanager.utils.TaskManagaerValidationRules.deleteTask(sc.nextInt(),taskList);
						System.out.println("Task deleted successfully");
						break;
						
					case 3: 
						//update task status
						System.out.println("Enter task Id");
						System.out.println("Enter new status of task: ");
						com.taskmanager.utils.TaskManagaerValidationRules.updateTaskStatus(sc.nextInt(),sc.next(),taskList);
						System.out.println("Status of task updated!!");
						break;
						
					case 4: 
						//display all pending task
						com.taskmanager.utils.TaskManagaerValidationRules.displayPendingTasks(taskList);
						
						break;
						
					case 5: 
						//display all pending tasks for today
						com.taskmanager.utils.TaskManagaerValidationRules.displayPendingTasksForToday(taskList);

						break;
						
					case 6: 
						//display all tasks sorted by taskDate
				       com.taskmanager.utils.TaskManagaerValidationRules.displayAllTaskSortedByDate(taskList);
						break;
						
					case 7: 
						//display
						for(Task t:taskList) {
							System.out.println(t);
						}
						break;
						
					case 0:
						//exit 
						exit=true;
						break;
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
	}
}
