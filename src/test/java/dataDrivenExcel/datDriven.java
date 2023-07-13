package dataDrivenExcel;

import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class datDriven {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/praveendasare/Desktop/exceldata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int column = 0;
        int sheets = workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++) {

            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();
                int k = 0;
                column = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("test")) {
                        column = k;
                    }
                    k++;
                }

                while (rows.hasNext()){

                }
            }
            }
        System.out.println(column);

    }
}
