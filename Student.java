package Day4;

public class Student extends Person{
	private int numCourse = 0;
	private String[] courses = { }; // danh sach khoa hoc
	private int[] grades = { };
	public Student(String name, String address, int numCourse) {
		super(name, address);
		this.numCourse = numCourse;
		
		this.grades = new int[numCourse];
		this.courses = new String[numCourse];
		for (int i = 0; i < this.courses.length; i++) {
			this.grades[i] = -1;
			this.courses[i] = "";
		}
	}
	
	public String[] getCourses() {
		return courses;
	}

	public int[] getGrades() {
		return grades;
	}

	
	public boolean isEmpty() {
		for (int i = 0; i < getGrades().length; i++) {
			if (getGrades()[i] != -1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFull() {
		for (int i = 0; i < getGrades().length; i++) {
			if (getGrades()[i] == -1) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isDuplicate(String course) {
		for (int i = 0; i < getCourses().length; i++) {
			if (getCourses()[i].equals(course)) {
				return true;
			}
		}
		return false;
	}

	
	public void addCourseGrade(String course, int grade) {
		boolean isDuplicate = isDuplicate(course);
		boolean isFull = isFull();
		if (!(isDuplicate && isFull)) {
			for (int i = 0; i < getCourses().length; i++) {
				if (getCourses()[i].equals("")) {
					getCourses()[i] = course;
					getGrades()[i] = grade;
					break;
				}
			}
		}else if (isFull) {
			System.out.println("Error: You can't add more course for this student (" + getName() + ")");
		} else {
			System.out.println("Error: The " + course + " course is already exist");
		}
	}
	
	public void printGrades() {
		boolean isEmpty = isEmpty();
		if (!isEmpty) {
			for (int i = 0; i < getCourses().length; i++) {
				System.out.println("    > " + getCourses()[i] + " - điểm: " + getGrades()[i]);
			}
		}else {
			System.out.println("Error: This student(" + getName() + ") don't have any course to print grade");
		}
	}
	
	public double getAverageGrade() {
		boolean isEmpty = isEmpty();
		if (!isEmpty) {
			int sumCourses = 0, countCourses = 0;
			for (int i = 0; i < getGrades().length; i++) {
				if (getGrades()[i] != -1) {
					sumCourses += getGrades()[i];
					countCourses++;
				}
			}
			return sumCourses*1.0/countCourses;
		}else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return "Student: " + getName() + "(" + getAddress() + ")";
	}
}
