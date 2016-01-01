package com.bankrupt.download;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.bankrupt.vo.ViewTO;

public class MakeTXT {
	/** this method prints the .txt file in CSV format
	 * 
	 * @param List of ViewTO type
	 * @param String name
	 * @return
	 * @throws IOException
	 */
	public boolean csvFormat(List<ViewTO> insertVar,String name) throws IOException {
		 
	String fname=name;
	final String CSV_FILE_NAME ="C:\\Users\\training\\Desktop\\"+fname+".txt";
		
		
		
	FileWriter fw = null;
	BufferedWriter writer = null;
	File file = new File(CSV_FILE_NAME);
	if (!file.exists()) {
	file.createNewFile();
	fw = new FileWriter(file);
	writer = new BufferedWriter(fw);
	writer.write("transaction_date");
	writer.write(",");
	writer.write("transaction_id");
	writer.write(",");
	writer.write("transaction_type");
	writer.write(",");
	writer.write("amount");
	writer.write(",");
	writer.write("balance");
	writer.newLine();
	
	if (insertVar!= null) {
		
		for (ViewTO v : insertVar) 
		{
			Date tdate=v.getTransactionDate();
				
			writer.write(tdate.toString());
			writer.write(",");
			writer.write(Integer.toString(v.getTransactionId()));
			writer.write(",");
			writer.write(v.getTransactionType());
			writer.write(",");
			writer.write(Double.toString(v.getTransactionAmount()));
			writer.write(",");
			writer.write(Double.toString(v.getBalance()));
			writer.newLine();
			
		
		}
	}
	}
	else {
	fw = new FileWriter(file, true);
	writer = new BufferedWriter(fw);
	if (insertVar != null) 
	{
		for (ViewTO v : insertVar) {
			Date tdate=v.getTransactionDate();
	
			writer.write(tdate.toString());
			writer.write(",");
			writer.write(Integer.toString(v.getTransactionId()));
			writer.write(",");
			writer.write(v.getTransactionType());
			writer.write(",");
			writer.write(Double.toString(v.getTransactionAmount()));
			writer.write(",");
			writer.write(Double.toString(v.getBalance()));
			writer.newLine();
			
	}
	}
	}
	writer.flush();
	writer.close();
	fw.close();

	return true;
	}
}
