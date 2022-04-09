package lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import lockedMe.FileOperationException;

public class LockedMeMain {

	public static final String path = "C:\\JavaEclipseWorkspace\\outFiles\\";
	public static Scanner sc = new Scanner(System.in);

		public static void main(String[] args) throws FileOperationException, IOException {


			System.out.println("Welcome to LockedMe.com");
			System.out.println("Developed by Siddhansh Jatale");
			
				try {
					mainMenu();
				} catch (Exception e) {
						System.out.println(e.getMessage());
						mainMenu();
				}
		}
		
		private static void moreOptions() throws FileOperationException, IOException {
		
			while(true)
			{
				System.out.println("\n1. Add File");
				System.out.println("2. Delete");
				System.out.println("3. Search");
				System.out.println("4. Return to Menu");
				System.out.println("\nEnter Option:");
				
				switch(sc.nextLine()) {
				case "1":
					addFile();
					break;
				case "2":
					deleteFile();
					break;
				case "3":
					searchFile();
					break;
				case "4":
					mainMenu();
					break;
				default:
					System.out.println("Wrong Input");
				}

			}
		}
		

		private static void closeApplication() {
			System.out.println("Thank You For Visiting..");
			System.exit(0);

		}

		private static void searchFile() throws FileOperationException, IOException{
			
			System.out.println("Enter name of file to search");
			String filename = sc.nextLine();
			filename = filename.trim().toLowerCase();
			
			
			File file = new File(path);
			List<String> allFileNames = new ArrayList<String>();
			for(String s: file.list()) {
				allFileNames.add(s);
			}
			
			if(allFileNames.contains(filename)) 
				System.out.println("File Found : " + filename );
			else
				throw new FileOperationException("File not found");

		}

		private static void deleteFile() throws FileOperationException, IOException {
			System.out.println("Enter file name to delete:");
			String filename = sc.nextLine();
			filename = filename.trim().toLowerCase();
			
			File file = new File(path + filename);
			
				if(file.delete())
					System.out.println(file.getName() + " Deleted");
				else
					throw new FileOperationException("File does not exist");
				
		}

		private static void addFile() throws FileOperationException, IOException {
			
			System.out.println("Enter file name:");
			String filename = sc.nextLine();
			filename = filename.trim().toLowerCase();
			File file = new File(path + filename);
			
			System.out.println(file);
			
				if(file.createNewFile())
					System.out.println("File Created");
				else
					throw new FileOperationException("File already exists");
			
				
		}

		private static void displayFiles() throws FileOperationException, IOException {

			File file = new File(path);
			List<File> allFiles = new ArrayList<File>();
			
			Collections.sort(allFiles);
			
			System.out.println("Files are:\n");
			
			for(String s : file.list())
				System.out.println(s);
			
		}
		
		private static void mainMenu() throws FileOperationException, IOException {
			
			System.out.println("");
			System.out.println("1. Display flie");
			System.out.println("2. More Options");
			System.out.println("3. Close Application");
			System.out.println("\nEnter Option:");
			
		
			String option = sc.nextLine();

			switch (option) {

				case "1":
					displayFiles();
					mainMenu();
					break;
				case "2":
					moreOptions();
					break;
				case "3":
					closeApplication();
					break;
				default: 
					System.out.println("Wrong Input");
			}	
			
		}
}
