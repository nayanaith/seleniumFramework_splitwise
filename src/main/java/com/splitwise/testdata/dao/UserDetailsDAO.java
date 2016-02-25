package com.splitwise.testdata.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.splitwise.testdata.dto.UserDetailsDTO;


//This class is to read data from 
public class UserDetailsDAO {

    private static String userDetailsFile = "F:\\programing\\java\\SeleniumFramework\\basedOnPageFactory\\resources\\test_data.xlsx";
    static FileInputStream fileStream ;
    private static List<UserDetailsDTO> userDetailsList;
    
    
    public static ArrayList<UserDetailsDTO> readData() throws Exception {     
    	try{
    	userDetailsList = new ArrayList<UserDetailsDTO>();
    	//UserDetailsErrorList = new ArrayList<UserDetailsDaoImpl>();

        File file = new File(userDetailsFile);

        if (!file.exists()) {
                System.out.println("No input file to process");
                System.exit(0);
        }

        fileStream = new FileInputStream(file);

        // Get the workbook instance for XLSX file
        final XSSFWorkbook workbook = new XSSFWorkbook(fileStream);

        // Get first sheet from the workbook
        final XSSFSheet sheet = workbook.getSheetAt(0);
        
        final Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            final UserDetailsDTO userDetails = new UserDetailsDTO();
            final Row row = rowIterator.next();

            if (0 == row.getRowNum()) {
                continue;
            }

            // For each row, iterate through each columns
            try {
            	userDetails.setUserName(row.getCell(0) != null ? String.valueOf((int) row.getCell(0).getNumericCellValue())
                        : null);
            } catch (final Exception e) {
            	userDetails.setUserName(row.getCell(0).toString());
            }
            
            try {
            userDetails.setPassword(row.getCell(1) != null ? String.valueOf((int) row.getCell(0).getNumericCellValue())
                    : null);
            
            } catch (final Exception e) {
            	userDetails.setPassword(row.getCell(1).toString());
            }

            userDetailsList.add(userDetails);
        }
        fileStream.close();
    } catch (final FileNotFoundException e) {
        e.printStackTrace();
    } catch (final IOException e) {
        e.printStackTrace();
    }
        return (ArrayList<UserDetailsDTO>) userDetailsList;
    }//end readData
}//end UserDetailsDAO
