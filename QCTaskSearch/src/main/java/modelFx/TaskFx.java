package modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TaskFx {

    private final SimpleStringProperty approval = new SimpleStringProperty();
    private final SimpleStringProperty plannedFixInVersion = new SimpleStringProperty();
    private final SimpleStringProperty priority = new SimpleStringProperty();
    private final SimpleStringProperty severity = new SimpleStringProperty();
    private final SimpleStringProperty bugAssignedTo = new SimpleStringProperty();
    private final SimpleStringProperty defectCategory = new SimpleStringProperty();
    private final SimpleStringProperty status = new SimpleStringProperty();
    private final IntegerProperty defectId = new SimpleIntegerProperty();
    private final SimpleStringProperty detectedBy = new SimpleStringProperty();
    private final SimpleStringProperty detectedInVersion = new SimpleStringProperty();
    private final SimpleStringProperty environment = new SimpleStringProperty();
    private final SimpleStringProperty summary = new SimpleStringProperty();
    private final SimpleStringProperty focusArea = new SimpleStringProperty();
    private final SimpleStringProperty detectedOnDate = new SimpleStringProperty();
    private final SimpleStringProperty commentsArchive = new SimpleStringProperty();

    public SimpleStringProperty getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval.set(approval);
    }

    public SimpleStringProperty getPlannedFixInVersion() {
        return plannedFixInVersion;
    }

    public void setPlannedFixInVersion(String plannedFixInVersion) {
        this.plannedFixInVersion.set(plannedFixInVersion);
    }

    public SimpleStringProperty getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public SimpleStringProperty getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity.set(severity);
    }

    public SimpleStringProperty getBugAssignedTo() {
        return bugAssignedTo;
    }

    public void setBugAssignedTo(String bugAssignedTo) {
        this.bugAssignedTo.set(bugAssignedTo);
    }

    public SimpleStringProperty getDefectCategory() {
        return defectCategory;
    }

    public void setDefectCategory(String defectCategory) {
        this.defectCategory.set(defectCategory);
    }

    public SimpleStringProperty getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public IntegerProperty getDefectId() {
        return defectId;
    }

    public void setDefectId(Integer defectId) {
        this.defectId.set(defectId);
    }

    public SimpleStringProperty getDetectedBy() {
        return detectedBy;
    }

    public void setDetectedBy(String detectedBy) {
        this.detectedBy.set(detectedBy);
    }

    public SimpleStringProperty getDetectedInVersion() {
        return detectedInVersion;
    }

    public void setDetectedInVersion(String detectedInVersion) {
        this.detectedInVersion.set(detectedInVersion);
    }

    public SimpleStringProperty getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment.set(environment);
    }

    public SimpleStringProperty getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    public SimpleStringProperty getFocusArea() {
        return focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea.set(focusArea);
    }

    public SimpleStringProperty getDetectedOnDate() {
        return detectedOnDate;
    }

    public void setDetectedOnDate(String detectedOnDate) {
        this.detectedOnDate.set(detectedOnDate);
    }

    public SimpleStringProperty getCommentsArchive() {
        return commentsArchive;
    }

    public void setCommentsArchive(String commentsArchive) {
        this.commentsArchive.set(commentsArchive);
    }

}
