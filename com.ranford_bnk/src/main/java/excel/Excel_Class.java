package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import TestBase.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excel_Class extends Base{
	
	
	 static  String folderpath=GetConfig("excelfolderpath");
	 static Sheet sh;
	 static Workbook wb;
	 static WritableWorkbook wwb;
	 static WritableSheet wsh;
	  public static void excelconnection(String filename,String sheetname)
	  {
		  try {
			File f=new File(folderpath+filename);
			  
			 wb= Workbook.getWorkbook(f);
			 sh= wb.getSheet(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
	public static int rows()
	{
		int rows= sh.getRows();
		return rows;    
	}
	public static int columns()
	{
		int columns= sh.getColumns();
		return columns;   
	}
  public static String readdata(int col,int row)
  {
	  String data=sh.getCell(col, row).getContents();
	return data;
  }
  
  public static void outputexcelconnection(String ifilename,String ofilename,String Sheetname)
  {
	  try {
		FileInputStream fis=new FileInputStream(folderpath+ifilename);
		  
			 wb= Workbook.getWorkbook(fis);
			 sh= wb.getSheet(Sheetname);
			 
			 FileOutputStream fos=new FileOutputStream(folderpath+ofilename);
			 
		      wwb=Workbook.createWorkbook(fos, wb);
		     
		       wsh=wwb.getSheet(Sheetname);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	     
  }
   
  public static void writedata(int col,int row,String data)
  {
	  try {
		Label l=new Label(col, row, data);
		  
		  wsh.addCell(l);
	} catch (RowsExceededException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public static void saveworkbook()
  {
	  try {
		wwb.write();
		  wwb.close();
		  wb.close();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	

}
