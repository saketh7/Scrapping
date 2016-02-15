import org.jsoup.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class WebCrawler {

	public static void main(String[] args) {
	String url;
		// TODO Auto-generated method stub
try{
	 InputStream input = new BufferedInputStream(
             new FileInputStream("C:/Users/Saketh/Desktop/s1.xls"));
 POIFSFileSystem fs = new POIFSFileSystem( input );
 HSSFWorkbook wb = new HSSFWorkbook(fs);
 HSSFSheet sheet = wb.getSheetAt(0);


 Iterator rows = sheet.rowIterator();
 //while( rows.hasNext() )
 {  
     HSSFRow row = (HSSFRow) rows.next();
     System.out.println("\n");
     Iterator cells = row.cellIterator();
     //while( cells.hasNext() ) 
     {

         HSSFCell cell = (HSSFCell) cells.next();
         url=cell.getStringCellValue();
       //  System.out.print( cell.getStringCellValue()+"     " );
                 
       /*  if(HSSFCell.CELL_TYPE_NUMERIC==cell.getCellType())
         System.out.print( cell.getNumericCellValue()+"     " );
         else
         if(HSSFCell.CELL_TYPE_STRING==cell.getCellType())
             System.out.print( cell.getStringCellValue()+"     " );
         else
             if(HSSFCell.CELL_TYPE_BOOLEAN==cell.getCellType())
             System.out.print( cell.getBooleanCellValue()+"     " );
             else
                 if(HSSFCell.CELL_TYPE_BLANK==cell.getCellType())
                     System.out.print( "BLANK     " );
                     else
                 System.out.print("Unknown cell type");
*/
     }


 }

		
	Document doc=Jsoup.connect(url).get();
		
	Elements rating=doc.select("div.score"); 

	Elements s=doc.select("Meta").eq(14);
	String e=s.attr("content");
	System.out.println(" Number of users:"+e);
	System.out.println(" User Rating of Instagram:"+rating.text());
//for(Element e: s)
{
	//System.out.println(e);
	}

	}catch(Exception e)
{
		System.out.println(e);
}

}
}