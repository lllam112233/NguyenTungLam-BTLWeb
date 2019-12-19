package Day4;

import java.text.DecimalFormat;

public class ImplementTesting {

	public static void main(String[] args) {
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		
		//Init
		Student student1 = new Student("Nguyen Van A", "HaNoi", 3);
		Student student2 = new Student("Nguyen Van  B", "Da Nang", 3);
		Student student3 = new Student("Nguyen Van  C", "Ho Chi Minh", 3);
		
		Teacher teacher1 = new Teacher("Giao vien A", "TP. HCM", 2);
		Teacher teacher2 = new Teacher("Giao vien B", "TP. Ha Noi", 1);
		
		Student[] students = new Student[3];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		
		Teacher[] teachers = new Teacher[2];
		teachers[0] = teacher1;
		teachers[1] = teacher2;
		
		
		//Add courses for teachers
		teachers[0].addCourse("Java programming");
		teachers[0].addCourse("Android programming");
		teachers[1].addCourse("Contributed programming");
		
		//Add courses and grades for students
		for (int i = 0; i < students.length; i++) {
			students[i].addCourseGrade("Java programming", (i+8));
			students[i].addCourseGrade("Android programming", (i+5));
			students[i].addCourseGrade("Contributed programming", (i+3));
		}
		
		System.out.println();
		System.out.println("--------- Thông tin giảng viên ---------");
		for (int i = 0; i < teachers.length; i++) {
			System.out.println(" Giảng viên " + (i+1));
			System.out.println(" Họ và tên: " + teachers[i].getName());
			System.out.println(" Địa chỉ: " + teachers[i].getAddress());
			System.out.print(" Các môn giảng dạy: ");
			teachers[i].printCourses();
			System.out.println();
		}
		
		System.out.println("--------- Thông tin sinh viên ---------");
		for (int i = 0; i < students.length; i++) {
			System.out.println(" Sinh viên: " + (i+1));
			System.out.println(" Họ và tên: " + students[i].getName());
			System.out.println(" Địa chỉ: " + students[i].getAddress());
			System.out.println(" Các môn học:");
			students[i].printGrades();
			System.out.println(" Điểm trung bình các môn học: " + decimalFormat.format(students[i].getAverageGrade()));
			System.out.println();
		}
	}

}
