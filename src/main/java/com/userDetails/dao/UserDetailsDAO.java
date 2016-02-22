package com.userDetails.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.userDetails.dto.UserDetailsDTO;


//This class is to read data from 
public class UserDetailsDAO {
    private static String userDetailsErrFile = "test_data_Err.xlsx";
    private static String userDetailsFile = "F:\\programing\\java\\SeleniumFramework\\basedOnPageFactory\\resources\\test_data.xlsx";
    private static List<UserDetailsDTO> UserDetailsList;
    private static List<UserDetailsDTO> UserDetailsErrorList;
    
    
    public static List<UserDetailsDTO> readData() throws Exception {     

        	UserDetailsList = new ArrayList<UserDetailsDTO>();
        	UserDetailsErrorList = new ArrayList<UserDetailsDTO>();

            File file = new File(userDetailsFile);

            if (!file.exists()) {
                    System.out.println("No input file to process");
                    System.exit(0);
            }

            final FileInputStream fileStream = new FileInputStream(file);

            // Get the workbook instance for XLSX file
            final XSSFWorkbook workbook = new XSSFWorkbook(fileStream);

            // Get first sheet from the workbook
            final XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows from first sheet
            final Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                final UserDetailsDTO userDetails = new UserDetailsDTO();
                final Row row = rowIterator.next();

                if (0 == row.getRowNum()) {
                    continue;
                }

                // For each row, iterate through each columns
                try {
                	userDetails.setUserName(row.getCell(0) != null ? row.getCell(0).getStringCellValue():null);
                } catch (final Exception e) {
                	userDetails.setUserName(row.getCell(0).toString());
                }
                
                try {
                	userDetails.setPassword(row.getCell(0) != null ? row.getCell(0).getStringCellValue():null);
                } catch (final Exception e) {
                	userDetails.setPassword(row.getCell(0).toString());
                }
                
                UserDetailsList.add(userDetails);                
            }
            System.out.print("came");
            return UserDetailsList;
         
        }
}//end UserDetailsDTO
