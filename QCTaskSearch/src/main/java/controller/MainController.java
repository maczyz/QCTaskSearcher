package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import common.SearchCriteria;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Task;
import modelFx.FocusAreaFx;
import modelFx.PlannedFixInVersionFx;
import modelFx.PriorityFx;
import modelFx.StatusFx;
import modelFx.TableOfTasksModel;
import modelFx.TaskFx;
import utils.DialogsUtils;
import utils.ExcelUtils;

public class MainController {

    // Sekcja filtrowania tabeli
    @FXML
    private ComboBox<PlannedFixInVersionFx> plannedFixInVersionComboBox;
    @FXML
    private ComboBox<PriorityFx> priorityComboBox;
    @FXML
    private ComboBox<StatusFx> statusComboBox;
    @FXML
    private ComboBox<FocusAreaFx> focusAreaComboBox;
    @FXML
    private TextArea commentsArchiveTextArea;
    @FXML
    private TextField bugAssignedToTextField;

    @FXML
    private Button clearButton;
    @FXML
    private Button searchButton;
    @FXML
    private Label resultsCount;

    // Pola tabeli
    @FXML
    private TableColumn<TaskFx, String> approvalColumn;
    @FXML
    private TableColumn<TaskFx, String> plannedFixInVersionColumn;
    @FXML
    private TableColumn<TaskFx, String> priorityColumn;
    @FXML
    private TableColumn<TaskFx, String> severityColumn;
    @FXML
    private TableColumn<TaskFx, String> bugAssignedToColumn;
    @FXML
    private TableColumn<TaskFx, String> defectCategoryColumn;
    @FXML
    private TableColumn<TaskFx, String> statusColumn;
    @FXML
    private TableColumn<TaskFx, Number> defectIDColumn;
    @FXML
    private TableColumn<TaskFx, String> detectedByColumn;
    @FXML
    private TableColumn<TaskFx, String> detectedInVersionColumn;
    @FXML
    private TableColumn<TaskFx, String> summaryColumn;
    @FXML
    private TableColumn<TaskFx, String> focusAreaColumn;
    @FXML
    private TableColumn<TaskFx, String> detectedOnDateColumn;
    @FXML
    private TableColumn<TaskFx, String> commentsArchiveColumn;

    @FXML
    private TableView<TaskFx> tasksTableView;

    private TableOfTasksModel tableOfTasksModel;

    /*
     * Metoda wypelnia comboBoxy do filrowania danymi oraz wypelnia tabele taskow
     */
    public void initializeWindow(File file) {
        tableOfTasksModel = new TableOfTasksModel();
        try {
            List<Task> tasks = ExcelUtils.readExcel(file.getAbsolutePath());
            tableOfTasksModel.init(tasks);
            resultsCount.setText(Integer.toString(tasks.size()));
        } catch (Exception e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        fillComboBoxesWithAllPossibleValues();

        bindComboBoxes();

        bindSearchButton();

        fillTable();
    }

    private void fillComboBoxesWithAllPossibleValues() {
        this.plannedFixInVersionComboBox.setItems(this.tableOfTasksModel.getPlannedFixInVersionFxObservableList());
        this.priorityComboBox.setItems(this.tableOfTasksModel.getPriorityFxObservableList());
        this.statusComboBox.setItems(this.tableOfTasksModel.getStatusFxObservableList());
        this.focusAreaComboBox.setItems(this.tableOfTasksModel.getFocusAreaFxObservableList());
    }

    private void bindSearchButton() {
        searchButton.disableProperty().bind(plannedFixInVersionComboBox.valueProperty().isNull()
                .and(priorityComboBox.valueProperty().isNull())
                .and(statusComboBox.valueProperty().isNull())
                .and(focusAreaComboBox.valueProperty().isNull()));
    }

    private void bindComboBoxes() {
        this.tableOfTasksModel.plannedFixInVersionFxPropertyProperty().bind(this.plannedFixInVersionComboBox.valueProperty());
        this.tableOfTasksModel.priorityFxPropertyProperty().bind(this.priorityComboBox.valueProperty());
        this.tableOfTasksModel.statusFxPropertyProperty().bind(this.statusComboBox.valueProperty());
        this.tableOfTasksModel.focusAreaFxPropertyProperty().bind(this.focusAreaComboBox.valueProperty());
    }

    private void fillTable() {
        this.tasksTableView.setItems(this.tableOfTasksModel.getTaskFxObservableList());
        this.approvalColumn.setCellValueFactory(cellData -> cellData.getValue().getApproval());
        this.plannedFixInVersionColumn.setCellValueFactory(cellData -> cellData.getValue().getPlannedFixInVersion());
        this.priorityColumn.setCellValueFactory(cellData -> cellData.getValue().getPriority());
        this.severityColumn.setCellValueFactory(cellData -> cellData.getValue().getSeverity());
        this.bugAssignedToColumn.setCellValueFactory(cellData -> cellData.getValue().getBugAssignedTo());
        this.defectCategoryColumn.setCellValueFactory(cellData -> cellData.getValue().getDefectCategory());
        this.statusColumn.setCellValueFactory(cellData -> cellData.getValue().getStatus());
        this.defectIDColumn.setCellValueFactory(cellData -> cellData.getValue().getDefectId());
        this.detectedByColumn.setCellValueFactory(cellData -> cellData.getValue().getDetectedBy());
        this.detectedInVersionColumn.setCellValueFactory(cellData -> cellData.getValue().getDetectedInVersion());
        this.summaryColumn.setCellValueFactory(cellData -> cellData.getValue().getSummary());
        this.focusAreaColumn.setCellValueFactory(cellData -> cellData.getValue().getFocusArea());
        this.detectedOnDateColumn.setCellValueFactory(cellData -> cellData.getValue().getDetectedOnDate());
        this.commentsArchiveColumn.setCellValueFactory(cellData -> cellData.getValue().getCommentsArchive());
    }

    /**
     * Lista metod odpalanych bezposrednio z klienta - podpiete w SceneBuilder w polu onAction
     */
    public void closeApplication() {
        Optional<ButtonType> result = DialogsUtils.confirmationDialog();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void about() {
        DialogsUtils.dialogAboutApplication();
    }

    /**
     * Metoda odpalana na kliencie po wywolaniu z gornego menu "Wczytaj plik"
     */
    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(new Stage());
        initializeWindow(file);
    }

    /**
     * Metoda wywolana po kliknieciu na "Search"
     */
    public void searchTasks() {
        Map<SearchCriteria, String> searchCriteria = prepareCriteria();
        tableOfTasksModel.filterTasksTable(searchCriteria);
    }

    private Map<SearchCriteria, String> prepareCriteria() {
        Map<SearchCriteria, String> searchCriteria = new HashMap<>();
        if (plannedFixInVersionComboBox.getSelectionModel().getSelectedItem() != null) {
            searchCriteria.put(SearchCriteria.PLANNED_FIX_IN_VERSION, plannedFixInVersionComboBox.getSelectionModel().getSelectedItem().toString());
        }
        if (priorityComboBox.getSelectionModel().getSelectedItem() != null) {
            searchCriteria.put(SearchCriteria.PRIORITY, priorityComboBox.getSelectionModel().getSelectedItem().toString());
        }
        if (statusComboBox.getSelectionModel().getSelectedItem() != null) {
            searchCriteria.put(SearchCriteria.STATUS, statusComboBox.getSelectionModel().getSelectedItem().toString());
        }
        if (focusAreaComboBox.getSelectionModel().getSelectedItem() != null) {
            searchCriteria.put(SearchCriteria.FOCUS_AREA, focusAreaComboBox.getSelectionModel().getSelectedItem().toString());
        }
        if (!commentsArchiveTextArea.getText().isEmpty()) {
            searchCriteria.put(SearchCriteria.COMMENTS_ARCHIVE, commentsArchiveTextArea.getText());
        }
        if (!bugAssignedToTextField.getText().isEmpty()) {
            searchCriteria.put(SearchCriteria.BUG_ASSIGNED_TO, bugAssignedToTextField.getText());
        }
        return searchCriteria;
    }

}
