package com.test.utils;

import com.test.model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;



/**
 * Created by win on 2018/9/23.
 */
public class ExpoortTable {

      //SXSSFWorkbook导出
      public static void PoiExportExcel(List<User> users, HttpServletRequest request, HttpServletResponse response) throws Exception {
          OutputStream outputStream = null;

          try {
              int bodyRowCount = 1;//正文内容行号
              outputStream = new BufferedOutputStream(response.getOutputStream());//输出流
              SXSSFWorkbook wb = new SXSSFWorkbook();
              //新建sheet
              Sheet sheet = wb.createSheet();
              //设置表头
              Row row = sheet.createRow(0);
              CellStyle style = wb.createCellStyle();
              style.setAlignment(CellStyle.ALIGN_CENTER);

              Cell cell = row.createCell(0);
              cell.setCellValue("序号");
              cell.setCellStyle(style);
              cell = row.createCell(1);
              cell.setCellValue("姓名");
              cell.setCellStyle(style);
              cell = row.createCell(2);
              cell.setCellValue("年龄");
              cell.setCellStyle(style);
              cell = row.createCell(3);
              cell.setCellValue("生成编号");
              cell.setCellStyle(style);
              for (int i = 0; i <users.size(); i++) {
                  row = sheet.createRow(bodyRowCount);
                  row.createCell(0).setCellValue(users.get(i).getId());
                  row.createCell(1).setCellValue(users.get(i).getUserName());
                  row.createCell(2).setCellValue(users.get(i).getAge());
                  row.createCell(3).setCellValue(users.get(i).getCode());
                  bodyRowCount ++;
              }
              wb.write(outputStream);
              outputStream.flush();
          }catch (Exception e) {
              e.printStackTrace();
          } finally {
              try {
                  outputStream.close();
              } catch (Exception e){
                  e.printStackTrace();
              }
          }
      }
    /**
     * 创建目标路径中文件夹
     *
     */
    public static boolean makeDirs(String folderName) {
        if (folderName == null && folderName.isEmpty()){
            return  false;
        }
        File folder = new File(folderName);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }
      //压缩文件
      public static  void ZipFiles(List<File> srcFile,File zipFile) throws Exception{
          byte [] buff = new byte[1024];
          try {
              ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
              for (int i = 0; i < srcFile.size(); i++) {
                  File file = srcFile.get(i);
                  FileInputStream in = new FileInputStream(file);
                  out.putNextEntry(new ZipEntry(file.getName()));
                  int len ;
                  while ((len = in.read(buff) ) > 0) {
                      out.write(buff, 0, len);
                  }
                  out.closeEntry();
                  in.close();
              }
              out.close();
          } catch (FileNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }


      }


}

