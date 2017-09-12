import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		try {
			if(index < 0 || index > students.length - 1)
				throw new IllegalArgumentException();
			return students[index];
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
		return null;
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		try {
			if(students == null && (index < 0 || index > students.length - 1))
				throw new IllegalArgumentException();
			for(int i = 0; i < students.length - 1; i++)
				this.students[i] = students[i];
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException();
			for(int i = students.length - 1; i > 0; i--)
				students[i + 1] = students[i];
			students[0] = student;
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException();
			students[students.length] = (student);
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		try {
			if(students == null && (index < 0 || index > students.length - 1))
				throw new IllegalArgumentException();
			students[index] = student;
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		try {
			if(index < 0 || index > students.length - 1)
				throw new IllegalArgumentException();
			int i;
			for(i = index; i < students.length - 1; i++)
				students[i] = students[i + 1];
			remove(i);
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		try {
			if(student == null)
				throw new IllegalArgumentException();
			int i;
			for(i = 0; i < students.length - 1; i++) {
				if(students[i] == student)
					remove(i);
			}
			if(i == students.length)
				throw new IllegalArgumentException("Student not exist");
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		try {
			if(index < 0 || index > students.length - 1)
				throw new IllegalArgumentException();
			int i;
			for(i = index; i < students.length - 1; i++)
				remove(i);
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		try {
			if(student == null)
				throw new IllegalArgumentException();
			int i;
			for(i = 0; i < students.length - 1; i++) {
				if(students[i] == student) {
					for(int j = i; j < students.length - 1; j++)
						remove(i);
					break;
				}
			}
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		try {
			if(index < 0 || index > students.length - 1)
				throw new IllegalArgumentException();
			int i;
			for(i = 0; i < index; i++)
				remove(i);
			for(i = 0; i < students.length - index; i++)
				students[i] = students[index + i];
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		try {
			if(student == null)
				throw new IllegalArgumentException();
			int i, j;
			for(i = students.length - 1; i > 0; i--) {
				if(students[i] == student)
					break;
			}
			j = i;
			for(i = j; i > 0; i--)
				remove(i);
			for(i = 0; i < students.length - j; i++)
				students[i] = students[j + i];
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Student temp;
		for(int i = 0; i < students.length - 2; i++) {
			for(int j = i + 1; j < students.length - 1; i++) {
				if(students[i].getId() > students[j].getId()) {
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		int length = students.length;
		Student[] arr = new Student[length];
		try {
			int i, j;
			if(date == null)
				throw new IllegalArgumentException();
			for(i = 0, j = 0; i < length - 1; i++) {
				if(students[i].getBirthDate() == date) {
						 arr[j] = students[i];
						 j++;
				}
			}
		}
		catch(IllegalArgumentException iae) {
			iae.getStackTrace();
		}
		return arr;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max_avg = 0;
		for(int i = 0; i < students.length - 1; i++) {
			if(max_avg < students[i].getAvgMark())
				max_avg = students[i].getAvgMark();
		}
		Student[] arr = new Student[students.length];
		for(int i = 0, k = 0; i < students.length - 1; i++) {
			if(max_avg == students[i].getAvgMark()) {
				arr[k] = students[i];
				k++;
			}	
		}
		return arr;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
