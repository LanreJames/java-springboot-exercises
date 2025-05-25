package service;

public class Telusko {
	private ICourse course;
	
	public boolean buyTheCourse(double amount) {
		return course.getTheCourse(amount);
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}
	
	

}
