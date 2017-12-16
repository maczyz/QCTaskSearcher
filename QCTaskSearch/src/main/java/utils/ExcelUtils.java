package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Task;

public class ExcelUtils {

    public static List<Task> readExcel(String path) {
        List<Task> tasks = new ArrayList<Task>();

        try {
            FileInputStream excelFile = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            // Pierwszy row to tytuly kolumn, wiec omijamy
            iterator.next();
            // Przesuwamy sie po kolejnych rows
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                tasks.add(addTaskToList(currentRow));
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    private static Task addTaskToList(Row currentRow) {
        Task task = new Task();
        task.setApproval(currentRow.getCell(0).toString());
        task.setPlannedFixInVersion(currentRow.getCell(1).toString());
        task.setPriority(currentRow.getCell(2).toString());
        task.setSeverity(currentRow.getCell(3).toString());
        task.setBugAssignedTo(currentRow.getCell(4).toString());
        task.setDefectCategory(currentRow.getCell(5).toString());
        task.setStatus(currentRow.getCell(6).toString());
        task.setDefectId(getDefectId(currentRow.getCell(7).toString()));
        task.setDetectedBy(currentRow.getCell(8).toString());
        task.setDetectedInVersion(currentRow.getCell(9).toString());
        task.setEnvironment(currentRow.getCell(10).toString());
        task.setSummary(currentRow.getCell(11).toString());
        task.setFocusArea(currentRow.getCell(12).toString());
        task.setDetectedOnDate(currentRow.getCell(13).toString());
        task.setCommentsArchive(currentRow.getCell(14).toString());
        return task;
    }

    private static Integer getDefectId(String stringToInteger) {
        return Integer.parseInt(stringToInteger.substring(0, stringToInteger.length() - 2));
    }

}
