package team03.tests.saban;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import team03.utilities.ExcelUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {
    private TestData() { }
    private static String excelFilePath="./src/test/java/resources/SabanTestData.xlsx";
    private static List<String> excelFileSheets=new ArrayList<>();
    private static Map<String,List<Map<String,String>>> testData;   //Map<SheetName,SheetData>


    private static List<String> getSheetNames(){
        FileInputStream fileInputStream = null;
        List<String> sheetNames=new ArrayList<>();
        Workbook workbook;
        try {
            fileInputStream = new FileInputStream(excelFilePath);
            workbook = WorkbookFactory.create(fileInputStream);
            int numberOfSheets = workbook.getNumberOfSheets();
            for ( int i = 0; i < numberOfSheets; i++ ) {
                String sheetName=workbook.getSheetName(i);
                if(sheetName.startsWith("US")){
                    sheetNames.add(sheetName);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return sheetNames;
    }


    private static void readExcelFile() {
        if(testData==null){
            testData=new HashMap<>();
            //Read Sheets first
            excelFileSheets=getSheetNames();
            for(String sheetName:excelFileSheets) {

                ExcelUtils excelUtils=new ExcelUtils(excelFilePath,sheetName);
                List<Map<String,String>> allSheetData=excelUtils.getDataList();
                testData.put(sheetName,allSheetData);
            }
        }
    }

    //testCaseNumber format should be TC01, TC02
    public static Map<String,String> US01(String testCaseNumber) {
        return getDataFromSheet("US_01_TestData",testCaseNumber);
    }

    public static Map<String,String> US02(String testCaseNumber) {
        return getDataFromSheet("US_02_TestData",testCaseNumber);
    }

    private static Map<String,String> getDataFromSheet(String sheetName,String testCaseNumber){
        readExcelFile();
        List<Map<String,String>> sheetData=testData.get(sheetName);
        testCaseNumber = testCaseNumber.replaceAll("[^0-9]", "");
        int  testCaseDataRowIndex = Integer.parseInt(testCaseNumber.replaceAll("[^0-9]", ""));
        Map<String,String> testData=sheetData.get(testCaseDataRowIndex-1);
        return testData;
    }


}
