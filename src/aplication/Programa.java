package aplication;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entites.Dados;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Dados> list = new ArrayList<Dados>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("Emplyoee" + (i + 1) + ": ");
			System.out.println();

			System.out.print("id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: "); 
				id = sc.nextInt();
			}

			System.out.print("name: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.print("salary: ");
			Double salary = sc.nextDouble();
			Dados emp = new Dados(id, name, salary);
			list.add(emp);
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Dados emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); 
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		System.out.println();
		System.out.println("List of employees:");   
		for (Dados obj : list) {
			System.out.println(obj);
		}
		
		
		
		sc.close();
	}

	public static boolean hasId(List<Dados> list, int id) {
		Dados emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); 
		return emp != null;
	}
}
