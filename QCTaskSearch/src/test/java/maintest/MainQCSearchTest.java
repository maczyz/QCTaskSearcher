package maintest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Task;
import utils.ExcelUtils;

public class MainQCSearchTest {

    private List<Task> tasks;
    private static final String FILE_NAME = "qctasks.xlsx";

    @Test
    public void readExcelFile() {
        tasks = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_NAME).getFile());
        tasks = ExcelUtils.readExcel(file.getAbsolutePath());
        assertThat(tasks.size(), is(44193));
    }

    @Test
    public void searchTasksWithParameters() {
        
    }
}
