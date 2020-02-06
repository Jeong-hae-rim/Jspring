package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class StudyApp {

	public static void main(String[] args) {
		ApplicationContext factory =
				   new ClassPathXmlApplicationContext("exam2/bean1.xml");
		
		Student s1 = (Student)factory.getBean("st1");
		System.out.println(s1.getName() + "는 " + s1.getMyHomework().getHomeworkName() + "를 학습합니다.");
		//System.out.println(s1.getMyHomework().getHomeworkName());
		Student s2 = (Student)factory.getBean("st2");
		System.out.println(s2.getName() + "는 " + s2.getMyHomework().getHomeworkName() + "를 학습합니다.");
		//System.out.println(s2.getMyHomework().getHomeworkName());
		Student s3 = (Student)factory.getBean("st3");
		System.out.println(s3.getName() + "는 " + s3.getMyHomework().getHomeworkName() + "를 학습합니다.");
		//System.out.println(s3.getMyHomework().getHomeworkName());
		
		

	}

}
