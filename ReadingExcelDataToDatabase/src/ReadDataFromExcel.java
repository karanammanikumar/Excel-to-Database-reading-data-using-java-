import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.mani.beans.Student;

public class ReadDataFromExcel {
	public static void main(String args[]) throws IOException {
		SessionFactory sf = new AnnotationConfiguration().configure("com/mani/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		FileInputStream file = new FileInputStream(new File("C:/Users/mani/Desktop/data.xlsx")); 
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		XSSFSheet sheet = workbook.getSheetAt(1); 
        Row row;
        for(int i=1; i<=sheet.getLastRowNum(); i++){  //points to the starting of excel i.e excel first row
            row = (Row) sheet.getRow(i);  //sheet number
            
            
	            String id;
				if( row.getCell(0)==null) { id = "0"; }
	            else id= row.getCell(0).toString();

                   String name;
				if( row.getCell(1)==null) { name = "null";}  //suppose excel cell is empty then its set to 0 the variable
                   else name = row.getCell(1).toString();   //else copies cell data to name variable

                   String address;
				if( row.getCell(2)==null) { address = "null";   }
                   else  address   = row.getCell(2).toString();
		Transaction t = session.beginTransaction();
	    Student std = new Student();
	    std.setId(Double.parseDouble(id));
	    std.setName(name);
	    std.setAddress(address);
	    System.out.println(std.getId()+" "+std.getName()+" "+std.getAddress());
	    session.saveOrUpdate(std);
	    t.commit();		
        }
		file.close();
	}


}
