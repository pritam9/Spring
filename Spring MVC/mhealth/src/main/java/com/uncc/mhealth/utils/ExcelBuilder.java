package com.uncc.mhealth.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

/**
 *  * This class builds an Excel spreadsheet document using Apache POI library.
 *  * @author Jai Kiran  *  
 */
public class ExcelBuilder extends AbstractXlsxStreamingView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-disposition","attachment; filename=" + "SmarTrek Survey Report("+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date())+").xlsx");
		@SuppressWarnings("unchecked")
		ArrayList<HashMap<String, ArrayList<ArrayList<String>>>> excelData = (ArrayList<HashMap<String, ArrayList<ArrayList<String>>>>) model
				.get("excelData");

		for (int i = 0; i < excelData.size(); i++) {

			HashMap<String, ArrayList<ArrayList<String>>> sheetData = excelData.get(i);

			ArrayList<ArrayList<String>> sheetName = sheetData.get("SheetName");
			Sheet sheet = workbook.createSheet(sheetName.get(0).get(0));
			sheet.setDefaultColumnWidth(30);

			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);

			int rowCount = 0;

			ArrayList<ArrayList<String>> headerList = sheetData.get("header")!=null?sheetData.get("header"):null;
			if(headerList!=null){
				for (ArrayList<String> header : headerList) {
					if (header != null && header.size() > 0) {
						Row headerRow = sheet.createRow(rowCount++);
						for (int j = 0; j < header.size(); j++) {
							headerRow.createCell(j).setCellValue(header.get(j)==null?"null":header.get(j));
							headerRow.getCell(j).setCellStyle(style);
						}
					}
				}
			}

			ArrayList<ArrayList<String>> dataList = sheetData.get("data")!=null?sheetData.get("data"):null;
			if(dataList!=null){
				for (ArrayList<String> data : dataList) {
					if (data != null && data.size() > 0) {
						Row dataRow = sheet.createRow(rowCount++);
						for (int j = 0; j < data.size(); j++) {
							dataRow.createCell(j).setCellValue(data.get(j)==null?"null":data.get(j));
						}
					}
				}
			}
		}

	}

}
