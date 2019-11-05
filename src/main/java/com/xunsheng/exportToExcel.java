package com.xunsheng;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class exportToExcel {
    private static final String[] columns = {"No.", "Login ID", "No. of Repositories", "No. of Followers", "Following Count", "No. of Gists"};


    public void exportExcel(ArrayList<GitHubAccount> follower) throws IOException, InterruptedException {

        // Create a Workbook.
        Workbook workbook = new XSSFWorkbook();

        // Create Submitted Sheet.
        Sheet sheet1 = workbook.createSheet("Zhamri's Github Followers");

        // Create a Font for styling header cells.
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);


        // Create a CellStyle with the font.
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);


        //set border style for header cells.
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);

        //set text to center.
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);


        //create a  CellStyle with border.
        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);

        //Create row.
        Row headerRow = sheet1.createRow(0);

        // Create cells.
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);

        }

        // Print data to row.
        int rowNum = 1;
        for (GitHubAccount followerTable : follower) {
            Row row = sheet1.createRow(rowNum++);


            Cell column1 = row.createCell(0);
            column1.setCellValue((rowNum-1));
            column1.setCellStyle(cellStyle);

            Cell column2 = row.createCell(1);
            column2.setCellValue(followerTable.getLogin());
            column2.setCellStyle(cellStyle);

            Cell column3 = row.createCell(2);
            column3.setCellValue(followerTable.getRepoNo());
            column3.setCellStyle(cellStyle);

            Cell column4 = row.createCell(3);
            column4.setCellValue(followerTable.getFollowers());
            column4.setCellStyle(cellStyle);

            Cell column5 = row.createCell(4);
            column5.setCellValue(followerTable.getFollowing());
            column5.setCellStyle(cellStyle);

            Cell column6 = row.createCell(5);
            column6.setCellValue(followerTable.getGists());
            column6.setCellStyle(cellStyle);

        }

        // Resize all columns to fit the content size.
        for (int i = 0; i < columns.length; i++) {
            sheet1.autoSizeColumn(i);
        }




        // Write the output to a file.
        FileOutputStream fileOut = new FileOutputStream("Report.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        //Message for processing excel file.
        System.out.println("\n\n\n"+"Generating an Excel file for the report..");
        Thread.sleep(2000);
        System.out.println("An Excel file named 'Report' has been generated.");

    }



}
