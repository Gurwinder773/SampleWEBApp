package model;

public class Task {

	private int taskId;
	private String taskName;
	private String taskDescription;
	private String taskPriority;
	private String taskStatus;

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

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + taskId + ", task_name=" + taskName + ", task_description=" + taskDescription
				+ ", task_priority=" + taskPriority + ",task_status=" + taskStatus + "]";
	}

}
