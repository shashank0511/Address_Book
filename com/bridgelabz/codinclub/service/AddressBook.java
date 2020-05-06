package com.bridgelabz.codinclub.service;
import java.util.*;
import java.io.*;

import com.bridgelabz.codinclub.module.Person;
import com.bridgelabz.codinclub.util.Util;

public class AddressBook implements IAddressBook{
	 private static final String CSV_HEADER = "ID,First_Name, Last_Name, Address, City, State, Phone, Pincode";
	
	
	private static Scanner sc = new Scanner(System.in);
	//@Override
	public void addData(Person P){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("AddressBook.csv",true);
			fileWriter.append(CSV_HEADER);
		    fileWriter.append('\n');
			fileWriter.append(P.getId());
			fileWriter.append(',');
			fileWriter.append(P.getfirstName());
			fileWriter.append(',');
			fileWriter.append(P.getlastName());
			fileWriter.append(',');
			fileWriter.append(P.getAddress());
			fileWriter.append(',');
			fileWriter.append(P.getCity());
			fileWriter.append(',');
			fileWriter.append(P.getState());
			fileWriter.append(',');
			fileWriter.append(P.getPhone());
			fileWriter.append(',');
			fileWriter.append(P.getPincode());
			fileWriter.append('\n');
			System.out.println("Write CSV successfully!");
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Flushing/closing error!");
				e.printStackTrace();
			}
		}
	}//function_addData

	public void readData() {
		List<Person> Persons = Util.getData();
		for (Person Per : Persons) {
			System.out.println(Per);
		}
	}//function_readData

	public void edit(String id){
		BufferedReader fileReader = null;
		int found = 0;
		try {
			List<Person> Persons = new ArrayList<Person>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("AddressBook.csv"));
			while ((line = fileReader.readLine()) != null) {
				String[] details = line.split(",");
				if (details.length > 0) {
					if(details[0].equals(id)){
						System.out.println("Enter an option:");
						System.out.println("1.Address 2.pincode");
						int op = sc.nextInt();
						found = 1;
						switch(op){
							case 1:System.out.println("Enter new address:");
								sc.nextLine();
								String add = sc.nextLine();
								Person P1 = new Person(details[0],details[1],details[2],details[3],details[4],details[5],
										details[6],details[7]);

								Persons.add(P1);
								break;
							case 2:boolean flag;
								do{
									System.out.println("Enter new pincode:");
									String pincode = sc.next();
									flag = Util.checkInt(pincode);
										if(flag){
											Person P2 = new Person(details[0],details[1],details[2],details[3],details[4],
													details[5],details[6],details[7]);
											Persons.add(P2);
										}else{
											System.out.println("invalid Entry for pncode:");
										}
								}while(flag == false);
								break;
							default :System.out.println("Enter a valid option:");
						}
					}else{
						Person P = new Person(details[0],details[1],details[2],details[3],details[4],details[5],
								details[6],(details[7]));

						Persons.add(P);
					}
				}
			}//while
			for (Person p : Persons){
				System.out.println(p);
			}
			if(found == 1){
				try{
					delete();
					for (Person p : Persons){
						addData(p);
					}
					System.out.println("Data Updated Successfully.....");
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				System.out.println("ID Not Found!.....");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}//functionEdit

	public void sortBy(String sortBy){
		List<Person> listPersons = Util.getData();
		switch(sortBy){
			case "firstName":
					Collections.sort(listPersons, Person.firstNameComp);
					for(Person p: listPersons){
						System.out.println(p);
					}
					break;
			case "lastName":
					Collections.sort(listPersons, Person.lastNameComp);
					for(Person p: listPersons){
						System.out.println(p);
					}
					break;
			case "pincode":
					Collections.sort(listPersons, Person.PincodeComp);
					for(Person p: listPersons){
						System.out.println(p);
					}
					break;
			default :System.out.println("can't sort by "+sortBy);
		}
	}//sortData

	public void deleteOne(String id){
		BufferedReader fileReader = null;
		int found = 0;
		try {
			List<Person> PersonList = new ArrayList<Person>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("AddressBook.csv"));
			while ((line = fileReader.readLine()) != null) {
				String[] details = line.split(",");
				if (details.length > 0) {
					if(details[0].equals(id)){
						//skip data...
						found = 1;
					}else{
						Person P = new Person(details[0],details[1],details[2],details[3],details[4],details[5],
								details[6],details[7]);

						PersonList.add(P);
					}
				}
			}//while
			if(found == 1){
				try{
					delete();
					for (Person p : PersonList){
						addData(p);
					}
				System.out.println("Data Deleted Successfully.....");
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				System.out.println("ID Not Found!.....");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}//deleteOne

	public void delete(){
		try{
			FileWriter fwriter = new FileWriter("AddressBook.csv",false);
			BufferedWriter write = new BufferedWriter(fwriter);
			write.write("");
			write.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}//delete
}//class


