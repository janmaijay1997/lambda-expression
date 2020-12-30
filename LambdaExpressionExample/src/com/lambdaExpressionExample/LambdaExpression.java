package com.lambdaExpressionExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {
	
	public static void main(String args[]) {
		
		List<Person> personList= Arrays.asList(
				new Person(2, "janmaijay", "Bisen"),
				new Person(23, "parth", "bisen"),
				new Person(45,"Mahesh","Rajput"));
		
		//sorting based on last name
		//old fashion java 7
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				return o2.getLastName().compareToIgnoreCase(o1.getLastName());
			}
			
		});
		
		for(Person person:personList) {
			//System.out.println(person);
		}
		//last name contain b or not in java 7 version
		for(Person person:personList) {
			if(person.getLastName().toUpperCase().startsWith("B")) {
			System.out.println(person);
			}
		}
		
	}
	
	

}
