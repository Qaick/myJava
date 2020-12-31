package play.spring.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanExample
{
	private String str;
	@Autowired private Boolean bool;

	BeanExample(){
		System.out.println("BeanExample.BeanExample");
		System.out.println("	bool = " + bool);
	}

	@Autowired
	public void noname(Bean bean){}

	@Transactional()
	public void print() {
		System.out.println("str = " + str + ", bool = " + bool);
	}

	@PostConstruct
	public void init()
	{
		System.out.println("BeanExample.init");
		System.out.println("	bool = " + bool); // TODO why doesn't work with app?
	}

	@PreDestroy
	public void preDestroy()
	{
		System.out.println("BeanExample.preDestroy");
	}

	public void setStr(String str)
	{
		this.str = str;
	}

	public void setBool(Boolean bool)
	{
		this.bool = bool;
	}
}
