import java.util.ArrayList;

public class TestSchoolRecords {

	public static void main(String[] args) {
		Student student1 = new Student("Emily Johnston", "45 Willow Lane", "123-1122", "emily.j@school.com", "Junior");
		Student student2 = new Student("Michael Brown", "89 Pinecrest Ave", "634-3344", "michael.b@school.com",
				"Senior");

		Faculty faculty1 = new Faculty("Dr. Sarah Lee", "23 Oakwood Drive", "666-5566", "sarah.lee@school.com",
				"Room 305", 85000, "2019-08-15", "10AM-4PM", "Senior");
		Faculty faculty2 = new Faculty("James Carter", "12 Maple Street", "454-7788", "james.c@school.com",
				"Room 412", 79000, "2017-03-22", "11AM-5PM", "Junior");

		Staff staff1 = new Staff("Linda Martinez", "67 Birchwood Road", "234-9900", "linda.m@school.com", "Building A",
				52000, "2020-11-10", "HR Manager");
		Staff staff2 = new Staff("Robert Wilson", "34 Cedar Lane", "456-1212", "robert.w@school.com", "Building B",
				48000, "2022-02-05", "IT Support");

		
		Database db = new Database();
		db.writePerson(student1);
		db.writePerson(student2);
		db.writePerson(faculty1);
		db.writePerson(faculty2);
		db.writePerson(staff1);
		db.writePerson(staff2);

	
		ArrayList<String> records = db.readDatabase();
		System.out.println("=== Records from Database ===");
		for (String record : records) {
			System.out.println(record);
		}
	}

}
