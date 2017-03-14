import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;


public class TestRun extends Keyword {

	static Keyword keywordobj=new Keyword();
	
	public static void main(String[] args) throws IOException 
	{
		initDriver();
		
		for(Row row:workbook.getSheet("Testcase"))
		{
			if(row == workbook.getSheet("Testcase").getRow(0))
				continue;
			String locator=row.getCell(0).getStringCellValue();
			String locatorid=row.getCell(1).getStringCellValue();
			String keyword=row.getCell(2).getStringCellValue();
			String parameter;
					
			if(row.getCell(3)!=null)
				parameter=row.getCell(3).getStringCellValue();
			else
				
				parameter=""	;
			
			keywordobj.performAction(locator, locatorid, keyword, parameter);
			
			}
	}
	
	

}
