package hashing.intro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;

public class HashSetAndMap {

	public static void main(String[] args) {
		// Fn: add, remove, contains, iterator, size, isEmpty etc.
		HashSet<Person> personSet = new HashSet<>(2);
		personSet.add(new Person("P1", 35));
		personSet.add(new Person("P2", 38));
		Iterator<Person> personItr = personSet.iterator();
		while (personItr.hasNext())
			System.out.println(personItr.next());

		// Fn: put, remove, get, containsKey, containsValue, entrySet, size, isEmpty etc.
		HashMap<Integer, Person> personMap = new HashMap<>(2);
		personMap.put(1, new Person("P3", 21));
		personMap.put(2, new Person("P4", 25));
		for (Entry<Integer, Person> entry : personMap.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
	}

}

class Person {
	
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Person person = (Person) obj;
		return age == person.age && Objects.equals(name, person.name);
	}

	@Override
	public String toString() {
		return "{Name: " + name + ", age: " + age + "}";
	}
	
}
