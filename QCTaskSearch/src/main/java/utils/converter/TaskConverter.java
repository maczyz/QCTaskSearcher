package utils.converter;

import model.Task;
import modelFx.TaskFx;

public class TaskConverter {

    public static TaskFx convertToTaskFx(Task task) {
        TaskFx taskFx = new TaskFx();
        taskFx.setApproval(task.getApproval());
        taskFx.setPlannedFixInVersion(task.getPlannedFixInVersion());
        taskFx.setPriority(task.getPriority());
        taskFx.setSeverity(task.getSeverity());
        taskFx.setBugAssignedTo(task.getBugAssignedTo());
        taskFx.setDefectCategory(task.getDefectCategory());
        taskFx.setDefectId(task.getDefectId());
        taskFx.setDetectedBy(task.getDetectedBy());
        taskFx.setDetectedInVersion(task.getDetectedInVersion());
        taskFx.setEnvironment(task.getEnvironment());
        taskFx.setSummary(task.getSummary());
        taskFx.setFocusArea(task.getFocusArea());
        taskFx.setDetectedOnDate(task.getDetectedOnDate());
        taskFx.setCommentsArchive(task.getCommentsArchive());
        return taskFx;
    }
}
