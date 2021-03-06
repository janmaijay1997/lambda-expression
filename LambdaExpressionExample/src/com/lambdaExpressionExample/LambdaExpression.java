package com.lambdaExpressionExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaExpression {
	
	public static void main(String args[]) {
		System.out.println("using supplier interface");
		List<String> listString=new ArrayList<String>();
		//supplier example 
		Supplier<List<String>> supplier=()->{ 
			listString.add("janmaijay");
		listString.add("rt");
		return listString;
			
		};
		System.out.println(supplier.get());
		
		System.out.println("tet");
		List<Person> personList= Arrays.asList(
				new Person(2, "janmaijay", "Bisen"),
				new Person(23, "parth", "bisen"),
				new Person(45,"Mahesh","Rajput"));
		
		//sorting based on last name
		//old fashion java 7
		/*Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				return o2.getLastName().compareToIgnoreCase(o1.getLastName());
			}
			
		});*/
		
		for(Person person:personList) {
			//System.out.println(person);
		}
		//last name contain b or not in java 7 version
		for(Person person:personList) {
			if(person.getLastName().toUpperCase().startsWith("B")) {
			System.out.println(person);
			}
		}
		 //sorting by last name using java8
		
		Collections.sort(personList,(o1,o2)->
			o1.getLastName().compareToIgnoreCase(o2.getLastName())
		);
		
		System.out.println("java 8 result ");
		for(Person person:personList) {
			System.out.println(person);
		}
		
		//last name contain b or not in java 8 version

		System.out.println("java 8 result start with b  ");
		for(Person person:personList) {
		printCondtinally(person, p->p.getLastName().toUpperCase().startsWith("B"));
		}
		//from java 8 using stream
		
		//personList.stream().sorted(Collections.so)
		
		//forEach with java 8 lambda expression
		System.out.println("using forEach of collection object java 8  lambda expression ");
		//personList.forEach(p->System.out.println(p));
		personList.forEach(System.out::println);
	}

	private static void printCondtinally(Person person, Condition condition) {

		if(condition.test(person)) {
			System.out.println(person);
		}
		
		
	}
	
	
	@FunctionalInterface
	interface Condition{
		public boolean test(Person p);
	}

}
