package Day4;
public class Teacher extends Person{
	private int numCourses = 0;
	private String[] courses;
	public Teacher(String name, String address, int numCourses) {
		super(name, address);
		this.numCourses = numCourses;
		
		this.courses = new String[numCourses];
		for (int i = 0; i < this.courses.length; i++) {
			this.courses[i] = "";
		}
	}

	public int getNumCourses() {
		return numCourses;
	}

	public String[] getCourses() {
		return courses;
	}

	public boolean isEmpty() {
		for (int i = 0; i < getNumCourses(); i++) {
			if (!getCourses()[i].equals("")) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFull() {
		for (int i = 0; i < getNumCourses(); i++) {
			if (getCourses()[i].equals("")) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isDuplicate(String course) {
		for (int i = 0; i < getNumCourses(); i++) {
			if (getCourses()[i].equals(course)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addCourse(String course) {
		boolean isDupicate = isDuplicate(course);
		boolean isFull = isFull();
		if (!isDupicate && !isFull) {
			for (int i = 0; i < getNumCourses(); i++) {
				if (getCourses()[i].equals("")) {
					getCourses()[i] = course;
					return true;
				}
			}
		}else if (isFull) {
			System.out.println("Error: You can't add more course for this teacher (" + getName() + ")");
		} else {
			System.out.println("Error: The " + course + " course is already exist");
		}
		return false;
	}
	
	public boolean removeCourse(String course) {
		for (int i = 0; i < getCourses().length; i++) {
			if (getCourses()[i].equals(course)) {
				getCourses()[i] = "";
				return true;
			}
		}
		return false;
	}
	
	public void printCourses() {
		for (int i = 0; i < getCourses().length-1; i++) {
			System.out.print(getCourses()[i] + ", ");
		}
		System.out.print(getCourses()[getCourses().length - 1]);
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Teacher: " + getName() + "(" + getAddress() + ")";
	}
}
