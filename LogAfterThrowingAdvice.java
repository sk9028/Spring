package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;
//기존에 다른애들은 인자가 고정이지만 throws는 하나로 고정해서 정할 수 가 없음
//예외 발생시 이쪽으로 넘어옴
public class LogAfterThrowingAdvice implements ThrowsAdvice{

	public void afterThrowing(IllegalAccessException e) throws Throwable{
		System.out.println("예외가 발생하였습니다. : "+e.getMessage());
	}
	
}
