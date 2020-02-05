package exam1;

import java.time.LocalDateTime;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GreetingTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/beans.xml");
		
		LocalDateTime localdatetime = (LocalDateTime)factory.getBean("localdatetime");
		Greeting greet;
		int time = localdatetime.getHour();
		
		if(6<=time && time<12) {
			greet = (Greeting)factory.getBean("morning");
		} else if (12<=time && time<17) {
			greet = (Greeting)factory.getBean("afternoon");
			
		} else if (17<=time && time<22) {
			greet = (Greeting)factory.getBean("evening");
			
		} else {
			greet = (Greeting)factory.getBean("night");
			
		}
		greet.greet();
		
		
		((ClassPathXmlApplicationContext)factory).close();
		
	}

}
