package com.bridgelabz.codinclub.service;

import com.bridgelabz.codinclub.module.Person;

public interface IAddressBook {
	
	public void addData(Person P);
	public void readData();
	public void edit(String id);
	public void sortBy(String sortBy);
	public void deleteOne(String id);
	public void delete();

}
