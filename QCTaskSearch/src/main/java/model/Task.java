package model;

public class Task {

    private String approval;
    private String plannedFixInVersion;
    private String priority;
    private String severity;
    private String bugAssignedTo;
    private String defectCategory;
    private String status;
    private Integer defectId;
    private String detectedBy;
    private String detectedInVersion;
    private String environment;
    private String summary;
    private String focusArea;
    private String detectedOnDate;
    private String commentsArchive;

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getPlannedFixInVersion() {
        return plannedFixInVersion;
    }

    public void setPlannedFixInVersion(String plannedFixInVersion) {
        this.plannedFixInVersion = plannedFixInVersion;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getBugAssignedTo() {
        return bugAssignedTo;
    }

    public void setBugAssignedTo(String bugAssignedTo) {
        this.bugAssignedTo = bugAssignedTo;
    }

    public String getDefectCategory() {
        return defectCategory;
    }

    public void setDefectCategory(String defectCategory) {
        this.defectCategory = defectCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDefectId() {
        return defectId;
    }

    public void setDefectId(Integer defectId) {
        this.defectId = defectId;
    }

    public String getDetectedBy() {
        return detectedBy;
    }

    public void setDetectedBy(String detectedBy) {
        this.detectedBy = detectedBy;
    }

    public String getDetectedInVersion() {
        return detectedInVersion;
    }

    public void setDetectedInVersion(String detectedInVersion) {
        this.detectedInVersion = detectedInVersion;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFocusArea() {
        return focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    public String getDetectedOnDate() {
        return detectedOnDate;
    }

    public void setDetectedOnDate(String detectedOnDate) {
        this.detectedOnDate = detectedOnDate;
    }

    public String getCommentsArchive() {
        return commentsArchive;
    }

    public void setCommentsArchive(String commentsArchive) {
        this.commentsArchive = commentsArchive;
    }
}
