package ie.lyit.serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.book.Book;
//
public class BookSerializer {
	private ArrayList<Book> books;
	
	private final String FILENAME = "book.ser";
	public BookSerializer() {
		books = new ArrayList<Book>();
		
	}
	
	public void add() {
		Book book= new Book();
		book.read();
		books.add(book);
	}
	
	public Book view() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Libary Number Of Book: ");
		int bookToView = keyboard.nextInt();
		
		for(Book tmpBook:books) {
			if(tmpBook.getLibraryNumber() == bookToView) {
				System.out.print(tmpBook);
				return tmpBook;
			}
		}
		return null;
	}
	
	public void delete() {
		Book bookToDelete = view();
		if(bookToDelete != null);
			books.remove(bookToDelete);
	}
	
	public void edit() {
		Book bookToEdit = view();
		
		if(bookToEdit != null) {
			bookToEdit.read();
			
			int index = books.indexOf(bookToEdit);
			books.set(index,  bookToEdit);
		}
		
	}
	
	public void list() {
		for(Book tmpBook:books)
			System.out.println(tmpBook);
	}
	
	public void serializeBooks() {
		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
			os.writeObject(books);
			
			os.close();
		}
		
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file" + FILENAME + ".");
		}
		
		catch(IOException ioE) {
			System.out.println(ioE.getMessage());
		}
		
	}
		
		public void deserializeBooks() {
			try {
				FileInputStream fileStream = new FileInputStream(FILENAME);
				
				ObjectInputStream is = new ObjectInputStream(fileStream);
				
				books=(ArrayList<Book>)is.readObject();
				
				is.close();
			}
			
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file" + FILENAME + ".");
			}
			
			catch(IOException ioE) {
				System.out.println(ioE.getMessage());
			}
			
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			
		
	}
	
}
