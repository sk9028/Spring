package spring.di;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
	
		/* 스프링에게 지시하는 방법으로 코드를 변경
		Exam exam = new NewlecExam();
		//ExamConsole console = new InlineExamConsole(exam); //DI
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		*/
		//부품을 생성해서 조립하고 던져주는 녀석이 스프링.
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/di/setting.xml");
			
		Exam exam = context.getBean(Exam.class);
		System.out.println(exam.toString());
		ExamConsole console = (ExamConsole) context.getBean("console"); //캐스팅이 필요함. console만 쓰면 어떤 녀석인지 잘 모르기 때문
		//ExamConsole console = context.getBean(ExamConsole.class); //위에꺼 또는 이 방식 2가지가 있음. 하지만 위에보단 아래께 더 보편적
		console.print();
	}

}
