package service;

public class DevOpsCourse implements ICourse {

	public DevOpsCourse() {
		super();
		System.out.println("DevOps Bean Created");
	}

	@Override
	public boolean getTheCourse(double amount) {
		// TODO Auto-generated method stub
		System.out.println("DevOps Is Purchased and amount paid is "+ amount);
		return true;
	}

}
