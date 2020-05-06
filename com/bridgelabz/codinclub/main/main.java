package com.bridgelabz.codinclub.main;
import java.util.*;

import com.bridgelabz.codinclub.service.AddressBook;
import com.bridgelabz.codinclub.util.Util;

public class main {

		public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			String opt;
			int option = 0;
			System.out.println("OPTIONS:");
			do {
				System.out.println("1.CREATE  2.OPEN  3.UPDATE  4.DELETE  5.SORT  6.QUIT");
				opt = sc.next();
				boolean checkResult = Util.checkInt(opt);
				if (checkResult){
					option = Integer.parseInt(opt);
					switch(option){
						case 1:
								Util.getPerson();
								break;
						case 2:
								AddressBook a = new AddressBook();
								a.readData();
								break;
						case 3:
								System.out.println("enter id:");
								String idE = sc.next();
								sc.nextLine();
								AddressBook a1 = new AddressBook();
								a1.edit(idE);
								break;
						case 4:
								System.out.println("1:Delete All 2:Delete One");
								int op = sc.nextInt();
								if (op == 1){
									AddressBook a2 = new AddressBook();
									try{
										a2.delete();
									}catch(Exception e){
										e.printStackTrace();
									}
								} else {
									System.out.println("Enter id:");
									String delId = sc.next();
									AddressBook a4 = new AddressBook();
									try{
										a4.deleteOne(delId);
									}catch(Exception e){
										e.printStackTrace();
									}
								}
								break;
						case 5:System.out.println("1.sortBy firstName 2.sortBy lastName 3.sortBy pincode");
								int sortBy=sc.nextInt();
								AddressBook a5 = new AddressBook();
								if(sortBy == 1){
									a5.sortBy("firstName");
								}else if (sortBy == 2){
									a5.sortBy("lastName");
								}
								else if(sortBy == 3){
									a5.sortBy("pincode");
								}else{
									 System.out.println("Enter a valid option:");
								}
								break;
						case 6: System.exit(0);break;
						default : System.out.println("Enter a valid option:");
					}//switch
				}else{
					System.out.println("Enter a valid number:");
				}
			}while(option != 6);//while
		}//main
	}//class
