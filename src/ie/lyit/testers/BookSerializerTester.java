package ie.lyit.testers;

import ie.lyit.book.*;
import ie.lyit.serialize.*;

public class BookSerializerTester {
	
	public static void main(String[] args) {
		BookSerializer bookSerializer = new BookSerializer();
		
		bookSerializer.deserializeBooks();
		Menu menuObj = new Menu();
		
		do {
			menuObj.display();
			menuObj.readOption();
			switch(menuObj.getOption()) {
			case 1:bookSerializer.add(); break;
			case 2:bookSerializer.list();break;
			case 3:bookSerializer.view();break;
			case 4:bookSerializer.edit();break;
			case 5:bookSerializer.delete();break;
			case 36:break;
			default:System.out.println("INVALID OPTION...");
			}
			
		}while(menuObj.getOption() != 6);
		
		
		bookSerializer.list();
		
		
		//bookSerializer.add();
		//1bookSerializer.add();
		
		bookSerializer.serializeBooks();
	}

}
