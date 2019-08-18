package com.onmobile.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.onmobile.stepDefinitions.Launcher;


public class ExcelReader {

	public static HashMap<String,String> storeValues = new HashMap<String, String>();
	
	public static String DataFilePath = PropertyReader.readItem("EXCEL_FILE_PATH"); 

/*	@SuppressWarnings("deprecation")
	public static List<HashMap<String,String>> data()
	{


		List<HashMap<String,String>> mydata = new ArrayList<>();
		try
		{

			FileInputStream fs = new FileInputStream(DataFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("TestData");
			
			Row HeaderRow = sheet.getRow(0);

			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
			{
				Row currentRow = sheet.getRow(i);
				
				HashMap<String,String> currentHash = new HashMap<String,String>();
				for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
				{
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(currentCell.getStringCellValue() + "\t");

						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}

				}
				mydata.add(currentHash);
			}

			fs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return mydata;

	}	
	@SuppressWarnings("deprecation")
	public static HashMap<String, LinkedHashMap<Integer, List>> loadExcelLines(String DataFilePath)
    {
		
        // Used the LinkedHashMap and LikedList to maintain the order
        HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();

        LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();

        String sheetName = null;
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        ArrayList<String> table = new ArrayList<String>();
        try
        {
            fis = new FileInputStream(DataFilePath);
            // Create an excel workbook from the file system
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            // Get the first sheet on the workbook.
            for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            {
                XSSFSheet sheet = workBook.getSheetAt(i);
                // XSSFSheet sheet = workBook.getSheetAt(0);
                sheetName = workBook.getSheetName(i);
            //    table=ReadHeadingAndData(sheetName);
                System.out.println(table);
                
            }
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return outerMap;

    }*/
	
	@SuppressWarnings("deprecation")
	public static LinkedHashMap<String, String> ReadHeadingAndData() throws IOException {
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
