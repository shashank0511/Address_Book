package com.bridgelabz.codinclub.util;
import java.util.*;

import com.bridgelabz.codinclub.module.Person;
import com.bridgelabz.codinclub.service.AddressBook;

import java.io.*;
public class Util{
	
	private static Scanner sc = new Scanner(System.in);
	public static  boolean checkInt(String entry){
		try{
			Integer.parseInt(entry);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public static void getPerson(){
		Random r = new Random();
		int random = r.nextInt();
		String id = ""+random;
		System.out.println("enter your first name:");
		String firstName = sc.nextLine();
		System.out.println("enter your last name:");
		String lastName = sc.nextLine();
		System.out.println("enter your address");
		String add = sc.nextLine();
		System.out.println("enter your city");
		String city = sc.nextLine();
		System.out.println("enter your state");
		String state = sc.nextLine();
		System.out.println("enter your phone");
		String phone = sc.next();
		System.out.println("enter your Pin code");
		String Pincode = sc.next();
		boolean checkRes = checkInt(Pincode);
		if(checkRes){
			Person data = new Person(id,firstName,lastName,add,city,state,phone,Pincode);
			AddressBook a = new AddressBook();
			a.addData(data);
		}else{
			System.out.println("invalid Entry for pincode:");
		}
		}
			
	//getPerson
	public static final List getData(){
		BufferedReader fileReader = null;
		List<Person> Persons = new ArrayList<Person>();
		try {
			String line = " ";
			fileReader = new BufferedReader(new FileReader("AddressBook.csv"));
			/* Read customer data line by line*/
			while ((line = fileReader.readLine()) != null) {
				String[] details = line.split(",");
				if (details.length > 0) {
					Person P1 =new Person(details[0],details[1],details[2],details[3],details[4],details[5],
							details[6],details[7]);

				Persons.add(P1);
				}
			}
		}catch (Exception e) {
			  System.out.println("Reading CSV Error!");
			  e.printStackTrace();
		} finally {
		  try {
			fileReader.close();
		  } catch (IOException e) {
				System.out.println("Closing fileReader Error!");
				e.printStackTrace();
		  }
		}
		return Persons;
	}//getData
}//class