import java.util.Scanner;

public class AccountsPayable {
	static int type;
	private static String mainFirst;
	private static String mainLast;
	private static String mainSocial;
	private static double mainGross;
	private static double mainCommission;
	private static double mainWage;
	private static double mainHours;
	private static double mainSalary;
	private static double mainBase;
	private static double basePlus10;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Employee[] hiredEmployees = new Employee[6];

		for (int i = 0; i < hiredEmployees.length; i++) {
			System.out.println("Enter employee type:\n1 - Salaried\n2 - Hourly\n3 - Comission\n4 - Base + Comission)");
			type = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter first name:");
			mainFirst = scanner.nextLine();
			System.out.println("Enter last name:");
			mainLast = scanner.nextLine();
			System.out.println("Enter SSN:");
			mainSocial = scanner.nextLine();
			switch (type) {
			case 1:
				System.out.println("Enter weekly salary amount:");
				mainSalary = scanner.nextDouble();
				scanner.nextLine();
				hiredEmployees[i] = new SalariedEmployee(mainFirst, mainLast, mainSocial, mainSalary);
				break;
			case 2:
				System.out.println("Enter hourly wage amount:");
				mainWage = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter amount of hours:");
				mainHours = scanner.nextDouble();
				scanner.nextLine();
				hiredEmployees[i] = new HourlyEmployee(mainFirst, mainLast, mainSocial, mainWage, mainHours);
				break;
			case 3:
				System.out.println("Enter gross sales amount:");
				mainGross = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter commission rate amount:");
				mainCommission = scanner.nextDouble();
				scanner.nextLine();
				hiredEmployees[i] = new CommissionEmployee(mainFirst, mainLast, mainSocial, mainGross, mainCommission);
				break;
			case 4:
				System.out.println("Enter gross sales amount:");
				mainGross = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter commission rate amount:");
				mainCommission = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter base pay amount:");
				mainBase = scanner.nextDouble();
				hiredEmployees[i] = new BasePlusCommissionEmployee(mainFirst, mainLast, mainSocial, mainGross,
						mainCommission, mainBase);
				break;
			}
		}
		for (int i = 0; i < hiredEmployees.length; i++) {
			System.out.printf("Employee number " + (i + 1) + "\n---------------------\n");
			System.out.println("First name: " + hiredEmployees[i].getFirstName());
			System.out.println("Payment amount: " + hiredEmployees[i].getPaymentAmount());
			System.out.println("\n");
		}
		for (int i = 0; i < hiredEmployees.length; i++) {
			if (hiredEmployees[i] instanceof BasePlusCommissionEmployee) {
				basePlus10 = ((BasePlusCommissionEmployee) hiredEmployees[i]).getBasePay();
				basePlus10 += (basePlus10 * 0.1);
				((BasePlusCommissionEmployee) hiredEmployees[i]).setBasePay(basePlus10);
			}
		}
		for (int i = 0; i < hiredEmployees.length; i++) {
			System.out.printf("Employee number " + (i + 1) + "\n---------------------\n");
			System.out.println("First name: " + hiredEmployees[i].getFirstName());
			System.out.println("Payment amount: " + hiredEmployees[i].getPaymentAmount());
			System.out.println("\n");
		}
	}

	public static void printEmployee(Employee employee) {
		System.out.println(employee.toString());
	}

	public static void printEmployee2(Employee employee) {
		System.out.println("First name= " + employee.getFirstName());
		System.out.println("Last name= " + employee.getLastName());
		System.out.println("SSN= " + employee.getSocialSecurityNumber());
		if (employee instanceof HourlyEmployee) {
			System.out.println("Hourly wage= " + ((HourlyEmployee) employee).getHourlyWage());
			System.out.println("Hours= " + ((HourlyEmployee) employee).getHours());
			System.out.println("Payment amount= " + ((HourlyEmployee) employee).getPaymentAmount());
		}
		if (employee instanceof SalariedEmployee) {
			System.out.println("Weekly salary= " + ((SalariedEmployee) employee).getWeeklySalary());
			System.out.println("Payment amount= " + ((SalariedEmployee) employee).getPaymentAmount());
		}
		if (employee instanceof CommissionEmployee) {
			System.out.println("Gross sales= " + ((CommissionEmployee) employee).getGrossSales());
			System.out.println("Commission rate= " + ((CommissionEmployee) employee).getCommissionRate());
			System.out.println("Payment amount= " + ((CommissionEmployee) employee).getPaymentAmount());
		}
		if (employee instanceof BasePlusCommissionEmployee) {
			System.out.println("Gross sales= " + ((CommissionEmployee) employee).getGrossSales());
			System.out.println("Commission rate= " + ((CommissionEmployee) employee).getCommissionRate());
			System.out.println("Base pay= " + ((BasePlusCommissionEmployee) employee).getBasePay());
			System.out.println("Payment amount= " + ((BasePlusCommissionEmployee) employee).getPaymentAmount());
		}
		System.out.println("\n");
	}
}
