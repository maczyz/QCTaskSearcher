package modelFx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import common.SearchCriteria;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Task;
import utils.converter.TaskConverter;

public class TableOfTasksModel {

    private final ObservableList<TaskFx> taskFxObservableList = FXCollections.observableArrayList();

    // Pola filtrowania
    private ObservableList<PlannedFixInVersionFx> plannedFixInVersionFxObservableList = FXCollections.observableArrayList();
    private ObservableList<PriorityFx> priorityFxObservableList = FXCollections.observableArrayList();
    private ObservableList<StatusFx> statusFxObservableList = FXCollections.observableArrayList();
    private ObservableList<FocusAreaFx> focusAreaFxObservableList = FXCollections.observableArrayList();

    private final ObjectProperty<PlannedFixInVersionFx> plannedFixInVersionFxProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<PriorityFx> priorityFxObjectProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<StatusFx> statusFxObjectProperty = new SimpleObjectProperty<>();
    private final ObjectProperty<FocusAreaFx> focusAreaFxObjectProperty = new SimpleObjectProperty<>();

    private final List<TaskFx> taskFxList = new ArrayList<>();

    // Wczytujemy dane do comboBoxow do filtrowania wynikow oraz wypelniamy tabele wszystkimi taskami
    public void init(List<Task> tasks) {
        tasks.forEach(task -> taskFxList.add(TaskConverter.convertToTaskFx(task)));
        taskFxObservableList.setAll(taskFxList);

        initPlannedFixInVersion(tasks);
        initPriority(tasks);
        initStatus(tasks);
        initFocusArea(tasks);
    }

    private void initFocusArea(List<Task> tasks) {
        focusAreaFxObservableList.clear();
        List<FocusAreaFx> focusAreaFxList = new ArrayList<>();
        tasks.forEach(task -> {
            FocusAreaFx focusAreaFx = new FocusAreaFx();
            focusAreaFx.setFocusArea(task.getFocusArea());
            if (!focusAreaFxList.contains(focusAreaFx)) {
                focusAreaFxList.add(focusAreaFx);
            }
        });
        focusAreaFxList.sort((FocusAreaFx element1, FocusAreaFx element2) -> element1.toString().compareTo(element2.toString()));
        focusAreaFxObservableList.addAll(focusAreaFxList);
    }

    private void initStatus(List<Task> tasks) {
        statusFxObservableList.clear();
        List<StatusFx> statusFxList = new ArrayList<>();
        tasks.forEach(task -> {
            StatusFx statusFx = new StatusFx();
            statusFx.setStatus(task.getStatus());
            if (!statusFxList.contains(statusFx)) {
                statusFxList.add(statusFx);
            }
        });
        statusFxList.sort((StatusFx element1, StatusFx element2) -> element1.toString().compareTo(element2.toString()));
        statusFxObservableList.addAll(statusFxList);
    }

    private void initPriority(List<Task> tasks) {
        priorityFxObservableList.clear();
        List<PriorityFx> priorityFxList = new ArrayList<>();
        tasks.forEach(task -> {
            PriorityFx priorityFx = new PriorityFx();
            priorityFx.setPriority(task.getPriority());
            if (!priorityFxList.contains(priorityFx)) {
                priorityFxList.add(priorityFx);
            }
        });
        priorityFxList.sort((PriorityFx element1, PriorityFx element2) -> element1.toString().compareTo(element2.toString()));
        priorityFxObservableList.addAll(priorityFxList);
    }

    private void initPlannedFixInVersion(List<Task> tasks) {
        plannedFixInVersionFxObservableList.clear();
        List<PlannedFixInVersionFx> plannedFixInVersionFxList = new ArrayList<>();
        tasks.forEach(task -> {
            PlannedFixInVersionFx plannedFixInVersionFx = new PlannedFixInVersionFx();
            plannedFixInVersionFx.setPlannedFixInVersion(task.getPlannedFixInVersion());
            if (!plannedFixInVersionFxList.contains(plannedFixInVersionFx)) {
                plannedFixInVersionFxList.add(plannedFixInVersionFx);
            }
        });
        plannedFixInVersionFxList.sort((element1, element2) -> element1.toString().compareTo(element2.toString()));
        plannedFixInVersionFxObservableList.addAll((plannedFixInVersionFxList));
    }

    public void filterTasksTable(Map<SearchCriteria, String> searchCriteria) {
        List<Predicate<TaskFx>> predicates = preparePredicates(searchCriteria);
        Predicate<TaskFx> commonPredicate = buildOneCommonPredicate(predicates);
        filterWithPredicate(commonPredicate);
    }

    private List<Predicate<TaskFx>> preparePredicates(Map<SearchCriteria, String> searchCriteria) {
        List<Predicate<TaskFx>> predicates = new ArrayList<>();
        searchCriteria.forEach((key, value) -> {
            if (key == SearchCriteria.PLANNED_FIX_IN_VERSION) {
                predicates.add(taskFx -> taskFx.getPlannedFixInVersion().get() == value);
            }
            if (key == SearchCriteria.PRIORITY) {
                predicates.add(taskFx -> taskFx.getPriority().get() == value);
            }
            if (key == SearchCriteria.STATUS) {
                predicates.add(taskFx -> taskFx.getStatus().get() == value);
            }
            if (key == SearchCriteria.FOCUS_AREA) {
                predicates.add(taskFx -> taskFx.getFocusArea().get() == value);
            }
            if (key == SearchCriteria.COMMENTS_ARCHIVE) {
                predicates.add(taskFx -> taskFx.getCommentsArchive().get() == value);
            }
            if (key == SearchCriteria.BUG_ASSIGNED_TO) {
                predicates.add(taskFx -> taskFx.getBugAssignedTo().get() == value);
            }
        });
        return predicates;
    }

    private Predicate<TaskFx> buildOneCommonPredicate(List<Predicate<TaskFx>> predicates) {
        return predicates.stream()
                .reduce(p -> true, Predicate::and);
    }

    /**
     * Metoda otrzymuje jako parametr predicates, ktory jest suma wszystkich predicates - jest to zalezne od tego jakie pola wyszukiwania wypelnilismy.
     * 
     * @param predicates
     */
    private void filterWithPredicate(Predicate<TaskFx> commonPredicate) {
        List<TaskFx> filteredList = taskFxList.stream().filter(commonPredicate).collect(Collectors.toList());
        taskFxList.clear();
        taskFxList.addAll(filteredList);
        taskFxObservableList.setAll(taskFxList);
    }

    public ObservableList<TaskFx> getTaskFxObservableList() {
        return taskFxObservableList;
    }

    public ObservableList<PlannedFixInVersionFx> getPlannedFixInVersionFxObservableList() {
        return plannedFixInVersionFxObservableList;
    }

    public void setPlannedFixInVersionFxObservableList(ObservableList<PlannedFixInVersionFx> plannedFixInVersionFxObservableList) {
        this.plannedFixInVersionFxObservableList = plannedFixInVersionFxObservableList;
    }

    public ObservableList<PriorityFx> getPriorityFxObservableList() {
        return priorityFxObservableList;
    }

    public void setPriorityFxObservableList(ObservableList<PriorityFx> PriorityFxObservableList) {
        this.priorityFxObservableList = PriorityFxObservableList;
    }

    public ObservableList<StatusFx> getStatusFxObservableList() {
        return statusFxObservableList;
    }

    public void setStatusFxObservableList(ObservableList<StatusFx> statusFxObservableList) {
        this.statusFxObservableList = statusFxObservableList;
    }

    public ObservableList<FocusAreaFx> getFocusAreaFxObservableList() {
        return focusAreaFxObservableList;
    }

    public void setFocusAreaFxObservableList(ObservableList<FocusAreaFx> focusAreaFxObservableList) {
        this.focusAreaFxObservableList = focusAreaFxObservableList;
    }

    public PlannedFixInVersionFx getPlannedFixInVersionFxProperty() {
        return plannedFixInVersionFxProperty.get();
    }

    public ObjectProperty<PlannedFixInVersionFx> plannedFixInVersionFxPropertyProperty() {
        return plannedFixInVersionFxProperty;
    }

    public void setPlannedFixInVersionFxObjectProperty(PlannedFixInVersionFx plannedFixInVersionFx) {
        this.plannedFixInVersionFxProperty.set(plannedFixInVersionFx);
    }

    public PriorityFx getPriorityFxObjectProperty() {
        return priorityFxObjectProperty.get();
    }

    public ObjectProperty<PriorityFx> priorityFxPropertyProperty() {
        return priorityFxObjectProperty;
    }

    public void setPriorityFxProperty(PriorityFx priorityFx) {
        this.priorityFxObjectProperty.set(priorityFx);
    }

    public StatusFx getStatusFxObjectProperty() {
        return statusFxObjectProperty.get();
    }

    public ObjectProperty<StatusFx> statusFxPropertyProperty() {
        return statusFxObjectProperty;
    }

    public void setStatusFxObjectProperty(StatusFx statusFx) {
        this.statusFxObjectProperty.set(statusFx);
    }

    public FocusAreaFx getFocusAreaFxProperty() {
        return focusAreaFxObjectProperty.get();
    }

    public ObjectProperty<FocusAreaFx> focusAreaFxPropertyProperty() {
        return focusAreaFxObjectProperty;
    }

    public void setFocusAreaFxObjectProperty(FocusAreaFx focusAreaFx) {
        this.focusAreaFxObjectProperty.set(focusAreaFx);
    }
}
