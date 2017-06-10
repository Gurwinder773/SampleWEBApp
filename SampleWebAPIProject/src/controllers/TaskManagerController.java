package controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import database.TaskManagerService;
import model.ListResponseModel;
import model.Task;
import utils.Constant;
import utils.Utils;

@RestController
public class TaskManagerController {

	TaskManagerService taskManagerService = new TaskManagerService();

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = { "Accept=application/json" })
	public ListResponseModel<Task> getAllTasks(@RequestHeader("Key") String key) {
		ListResponseModel<Task> listResponseModel = new ListResponseModel<>();
		if (key.equals(Constant.API_KEY)) {
			listResponseModel = Utils.getListReponseModel(taskManagerService.getAllTasks(), true, "");
		} else {
			listResponseModel = Utils.getListReponseModel(null, false, "Incorrect Header Key");
		}

		return listResponseModel;
	}

	@RequestMapping(value = "/tasks/archive/{taskIds}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> archieveAllTasks(@PathVariable int[] taskIds) {
		for (int i = 0; i < taskIds.length; i++) {
			taskManagerService.archiveTask(taskIds[i]);
		}

		List<Task> list = taskManagerService.getAllTasks();
		return list;
	}

	@RequestMapping(value = "/tasks/changeStatus", method = RequestMethod.POST, headers = { "Accept=application/json" })
	public ListResponseModel<Task> changeTaskStatus(@RequestHeader("Key") String key, @RequestBody Task requestTask)
			throws ParseException {
		if (key.equals(Constant.API_KEY)) {
			taskManagerService.changeTaskStatus(requestTask.getTaskId(), requestTask.getTaskStatus());
			return getAllTasks(key);
		} else {
			return Utils.getListReponseModel(null, false, "Incorrect Header Key");
		}
	}

	@RequestMapping(value = "/tasks/insert", method = RequestMethod.POST, headers = { "Accept=application/json" })
	public List<Task> addTask(@RequestHeader("Key") String key, @RequestBody Task requestTask) throws ParseException {

		System.out.println("KEY: " + key);

		if (key.equals(Constant.API_KEY)) {
			Task task = new Task();
			task.setTaskName(requestTask.getTaskName());
			task.setTaskDescription(requestTask.getTaskDescription());
			task.setTaskPriority(requestTask.getTaskPriority());
			task.setTaskStatus(requestTask.getTaskStatus());
			taskManagerService.addTask(task);
			return taskManagerService.getAllTasks();
		} else {
			return null;
		}

	}
}
