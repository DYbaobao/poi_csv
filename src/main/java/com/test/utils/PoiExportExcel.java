package com.test.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.test.model.User;

public class PoiExportExcel {
   /**
    * 导出数据到多个sheet
    * @param title
    * @param list
    * @param request
    * @param response
    */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void PoiWriteExcel (String title,List list,HttpServletRequest request,HttpServletResponse response){
		OutputStream outputStream = null;
		try {
			int sheetNum = 1;//工作簿sheet编号
			int bodyRowCount = 1;//正文内容行号
			int currentRowCount = 1;//当前的行号
			int perPageNum = 5;//每个工作簿显示5条
			outputStream = new BufferedOutputStream(response.getOutputStream());//输出流
			HSSFWorkbook workbook = new HSSFWorkbook();//创建excel
			HSSFSheet sheet = workbook.createSheet(title + sheetNum);//创建工作簿
			HSSFRow row = null;//创建一行
			HSSFCell cell = null; //每个单元格
			HSSFCellStyle titleCellStyle = createTitleCellStyle(workbook);
			writeTitleContent(sheet,titleCellStyle);
			//第二行开始写入数据
			ArrayList<User> pList = new ArrayList<User>();
			pList = (ArrayList<User>) list;
			HSSFCellStyle bodyCellStyle = createBodyCellStyle(workbook);
			HSSFCellStyle dateBobyCellStyle = createDateBodyCellStyle(workbook);
            for (int i = 0; i < pList.size(); i++) {
            	//正文内容
				row = sheet.createRow(bodyRowCount);
				//第二行开始写入正文内容
				cell = row.createCell(0);//序号
				cell.setCellStyle(bodyCellStyle);
				cell.setCellValue(currentRowCount);
				cell = row.createCell(1);//姓名
				cell.setCellStyle(bodyCellStyle);
				cell.setCellValue(pList.get(i).getUserName());
				cell = row.createCell(2);//年龄
				cell.setCellStyle(bodyCellStyle);
				cell.setCellValue(pList.get(i).getAge());
				cell = row.createCell(3);//生成的编号
				cell.setCellStyle(bodyCellStyle);
				cell.setCellValue(pList.get(i).getCode());
				if (currentRowCount % perPageNum ==0) { //每个工作簿显示5行
					sheet = null;
					sheetNum ++; //工作簿编号增加1
					sheet = workbook.createSheet(title + sheetNum);//创建新的工作簿
					bodyRowCount = 0;
					writeTitleContent(sheet, titleCellStyle);//写入标题			
				}
				bodyRowCount++;//正文内容行号递增1
				currentRowCount++;//当前行号增加1
			}
            workbook.write(outputStream);
            outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		     try {
				outputStream.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * 设置正文单元样式
	 * @param workbook
	 * @return
	 */
	public static HSSFCellStyle createBodyCellStyle(HSSFWorkbook workbook) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short)8);
		font.setFontName(HSSFFont.FONT_ARIAL);//设置标题字体
		cellStyle.setFont(font);
		cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
		return cellStyle;
	}
	
	/**
	 * 设置正文单元时间样式
	 * @param workbook
	 * @return
	 */
	public static HSSFCellStyle createDateBodyCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFFont font =  workbook.createFont();
		font.setFontHeightInPoints((short)8);
		font.setFontName(HSSFFont.FONT_ARIAL);//设置标题字体
		cellStyle.setFont(font);
		cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
		HSSFDataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));
		return cellStyle;
	}
	
	/**
	 * 设置标题单元样式
	 * @param workbook
	 * @return
	 */
	public static HSSFCellStyle createTitleCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)8);
		font.setFontName(HSSFFont.FONT_ARIAL);//设置标题的字体
		cellStyle.setFont(font);
		cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);//设置列标题样式
		cellStyle.setFillBackgroundColor(HSSFColor.SKY_BLUE.index);// 设置背景色
		cellStyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER); // 居中	
		return cellStyle;		
	}
	
	public  static void writeTitleContent (HSSFSheet sheet,HSSFCellStyle cellStyle) {
		HSSFRow row = null;
		HSSFCell cell = null;
		//标题
		row = sheet.createRow(0);
		//第一行写入标题行
		cell = row.createCell(0);//编号
		cell.setCellStyle(cellStyle);
		cell.setCellValue("编号");
		cell = row.createCell(1);//姓名
		cell.setCellStyle(cellStyle);
		cell.setCellValue("姓名");
		cell = row.createCell(2);//年龄
		cell.setCellStyle(cellStyle);
		cell.setCellValue("年龄");
		cell = row.createCell(3);//生成的编号
		cell.setCellStyle(cellStyle);
		cell.setCellValue("生成的编号");
	}
}
