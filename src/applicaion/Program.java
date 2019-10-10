package applicaion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.print("Digite o Nome do Departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("Digite os dados do Funcionário");
		System.out.print("Name: ");
		String workerName  = sc.nextLine();
		System.out.print("Nível: ");
		String workerLevel  = sc.nextLine();
		System.out.print("Salario Base: ");
		double baseSalary  = sc.nextDouble();
		Worker worker = new Worker (workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department (departmentName));
		
		System.out.print("Quantos contratos para este funcionário?");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Digite os dados do contrato #" +  i + ":");
			System.out.print("Data(DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duração (horas):");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.println("Digite o mês e ano para calcular o salário (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Salario de " + monthAndYear + ":" + String.format("%.2f", worker.income(year, month)));
				
		sc.close();
		

	}

}
