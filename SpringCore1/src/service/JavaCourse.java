package service;

public class JavaCourse implements ICourse {

	@Override
	public boolean getTheCourse(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Java Course Is Purchased and amount paid is "+ amount);
		return true;
	}

}
