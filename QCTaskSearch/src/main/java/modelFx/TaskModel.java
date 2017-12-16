package modelFx;

import org.omg.CORBA.portable.ApplicationException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskModel {

    private final ObjectProperty<TaskFx> taskFxObjectProperty = new SimpleObjectProperty<>(new TaskFx());
    
    //Property sluzace do filtrowania
    private final ObservableList<PlannedFixInVersionFx> categoryFxObservableList = FXCollections.observableArrayList();
    private final ObservableList<PriorityFx> priorityFxObservableList = FXCollections.observableArrayList();
    private final ObservableList<StatusFx> statusFxObservableList = FXCollections.observableArrayList();
    private final ObservableList<FocusAreaFx> focusAreaFxObservableList = FXCollections.observableArrayList();
    private final ObservableList<CommentsArchiveFx> commentsArchiveFxObservableList = FXCollections.observableArrayList();
    
    public void init() throws ApplicationException {
        initPlannedFixInVersionList();
        initPriorityList();
        initStatusList();
        initFocusAreaList();
        initCommentsArchiveList();
    }

    private void initCommentsArchiveList() {
        // TODO Auto-generated method stub
        
    }

    private void initFocusAreaList() {
        // TODO Auto-generated method stub
        
    }

    private void initStatusList() {
        // TODO Auto-generated method stub
        
    }

    private void initPriorityList() {
        // TODO Auto-generated method stub
        
    }

    private void initPlannedFixInVersionList() {
        // TODO Auto-generated method stub
        
    }
}
