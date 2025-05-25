package service;

public class Telusko {
	public Telusko() {
		//super();
		System.out.println("Telusko Bean Created");
	}

	public Telusko(ICourse course) {
		super();
		this.course = course;
	}

	private ICourse course;
	
	public boolean buyTheCourse(double amount) {
		return course.getTheCourse(amount);
	}

	public void setCourse(ICourse course) {
		this.course = course;
	}
	
	

}
