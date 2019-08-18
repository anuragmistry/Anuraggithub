package com.onmobile.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelReader {

	public static HashMap<String,String> storeValues = new HashMap<String, String>();
	
	@SuppressWarnings("deprecation")
	public static LinkedHashMap<String, String> ReadHeadingAndData(String DataFilePath) throws IOException {
		LinkedHashMap<String,String> InputDataHashmap = new LinkedHashMap<String,String>();
		
		FileInputStream inp = new FileInputStream(DataFilePath);
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(inp);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {			
			e.printStackTrace();
		}  
		
		
		for (int i = 0; i < workbook.getNumberOfSheets(); i++)
		{
			Sheet sheet = workbook.getSheetAt(i);
			String sheetName = workbook.getSheetName(i); 

			ArrayList<String> table = new ArrayList<String>();
			StringBuilder rowList;
			
			
			Row row=null;
			Cell cell=null;

			Iterator<?> rows = sheet.rowIterator();

			//Reading only header details below
			Row firstrow = (Row) rows.next();
			Iterator<?> firstrowcells = firstrow.cellIterator();
			StringBuilder firstrowList = new StringBuilder();

		 while(firstrowcells.hasNext()){
				cell = (Cell) firstrowcells.next();
				firstrowList.append(sheetName+"_"+cell.getStringCellValue()+"%%");
			}	
			table.add(firstrowList.toString());



			//Reading the desired row matching ID
			while(rows.hasNext()){

				row = (Row) rows.next();
				Iterator<?> cells = row.cellIterator();
				rowList=new StringBuilder();

				while (cells.hasNext()){

					cell = (Cell) cells.next();

					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						rowList.append(cell.getStringCellValue()+"%%");
					}
					else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
						rowList.append((int)cell.getNumericCellValue()+"%%");
					}
					else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
						rowList.append(cell.getBooleanCellValue()+"%%");
					}
					else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
						rowList.append("null"+"%%");
					}
					else { 

						//U Can Handle Formula, Errors 					
					}

				}
				table.add(rowList.toString());
				////////////////////
				if(table!=null){

					String[] array = table.toArray(new String[0]);

					String[] headings = array[0].split("%%");
					String[] data = array[1].split("%%");

					for(int j=0;j<headings.length;j++){
						try{
							InputDataHashmap.put(headings[j], data[j]);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}

				}
			}

		}//end of for loop	
	
		
		return InputDataHashmap;
		
	}


}
