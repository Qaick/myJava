package play.spring.one;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration // wraps bean in proxy
@ComponentScan(basePackages = "play.spring.one")
public class Main1
{

	public @interface B { };

	public static void main(String... args)
	{
//		Collections.unmodifiableCollection(new A)

		Main1.class.getAnnotation(Autowired.class);


		AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(Main1.class);
		//		System.out.println(annotationContext.getBeanDefinition("org.springframework.context.annotation.internalCommonAnnotationProcessor"));
		//		System.out.println(annotationContext.getBeanDefinition("beanExample"));

//				System.out.println(Arrays.toString(annotationContext.getBeanDefinitionNames()));

		annotationContext.getBean(BeanExample.class).print();
//		annotationContext.registerBean(BeanExample.class);
		//		annotationContext.getBean(BeanExample.class).print();
		//		System.out.println(annotationContext.getBean(BeanExample.class));
		//		System.out.println("postProcessors: " + annotationContext.getBeanFactoryPostProcessors());
		//		System.out.println(Arrays.toString(annotationContext.getBeanDefinitionNames()));
		//		Arrays.stream(annotationContext.getBeanDefinitionNames())
		//				.forEach(s -> System.out.println(s));

		//		annotationContext.removeBeanDefinition("beanExample"); // preDestroy is called!!!
		annotationContext.registerShutdownHook();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~ XML");
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("config.xml");
//		System.out.println(Arrays.toString(xmlContext.getBeanDefinitionNames()));
//		System.out.println(xmlContext.getBeanFactoryPostProcessors());
//		xmlContext.removeBeanDefinition("beanExample"); // preDestroy is called!!!
		System.out.println(xmlContext.getBeanFactory().getBeanDefinition("beanExample"));
        xmlContext.registerShutdownHook(); // shutdown context on JVM shutdown

//		new Thread(() ->{while(true){}}).start();
	}

	@Bean()
	public static Boolean bool()
	{
		return Boolean.TRUE;
	}

	// TODO why it doesn't work??
//	@Bean
//	public static BeanPostProcessor bpp() // internalCommonAnnotationProcessor
//	{
//		System.out.println("Main1.bool2");
//		return new CommonAnnotationBeanPostProcessor();
//	}

	@Bean
	public static BeanPostProcessor bpp2() { // if not static there is printed some error
		return new BeanPostProcessor()
		{
			public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
			{
				System.out.println("*bean = " + bean + ", beanName = " + beanName);
				return null;
			}

			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
			{
				return null;
			}
		};
	}
}
