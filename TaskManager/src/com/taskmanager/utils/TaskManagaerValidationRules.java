package com.taskmanager.utils;

import java.time.LocalDate;
import java.util.List;

import com.taskmanager.core.Status;
import com.taskmanager.core.Task;
import com.taskmanager.customExceptions.TaskmanagerExceptions;

public class TaskManagaerValidationRules {

	public static Task validateTaskmanagerInputs(String taskName, String description, String taskDate, List<Task> taskList)
			throws TaskmanagerExceptions  {
		  
		LocalDate date=LocalDate.parse(taskDate);
		
		return new Task(taskName,description,date);
	}

	public static void deleteTask(int id, List<Task> taskList) throws TaskmanagerExceptions {
		int flag=0;
	       for(Task task:taskList)
	       {
	    	   if(task.getTaskId()==id)
	    	   {
	    		   flag=1;
	    		   continue;
	    	   }
	        }
 	   if(flag==0) {
 		   throw new TaskmanagerExceptions("Task with ID "+id+" not found");
 	   }
		for(Task task:taskList)
		{
			if(task.getTaskId()==(id)) {
				task.setActive(false);
			}			
		}
	}

	public static void updateTaskStatus(int id, String newStatus, List<Task> taskList) throws TaskmanagerExceptions {
		int flag=0;
	       for(Task task:taskList)
	       {
	    	   if(task.getTaskId()==id)
	    	   {
	    		   flag=1;
	    		   continue;
	    	   }
	        }
	       if(flag==0)
	    	   throw new TaskmanagerExceptions("Task id not found");
	        
		for(Task task:taskList) 
		{
			if(task.getTaskId()==id)
			{
				task.setStatus(Status.valueOf(newStatus.toUpperCase()));
			}
		}
		
	}

	public static List<Task> displayPendingTasks(List<Task> taskList) throws TaskmanagerExceptions{
		int found=1;
		for(Task task:taskList)
		{
			if(task.getStatus()==Status.PENDING)
			{
				found=0;
				System.out.println(task);
			}
			if (found==1)	
				throw new TaskmanagerExceptions("Task with status:Pending NOT FOUND");
		}
		return taskList;
		
		
	}

	public static List<Task> displayPendingTasksForToday(List<Task> taskList) throws TaskmanagerExceptions {
	
		LocalDate today=LocalDate.now();
		for(Task task:taskList)
		{
			if(task.getStatus()==Status.PENDING && task.getTaskDate().equals(today))
			{ 
				
				System.out.println(task);
			//throw new TaskmanagerExceptions("Task with status=Pending and date=today is NOT FOUND");
			}
//			else
//				System.out.println("no task found!!");
		}
		 
		return taskList;
		
		
	}

	public static void displayAllTaskSortedByDate(List<Task> taskList) {
		
		taskList.sort((t1,t2)->t1.getTaskDate().compareTo(t2.getTaskDate()));
		for(Task t:taskList)
		{
			System.out.println(t);
		}
		
	}

	
	
	}

	

