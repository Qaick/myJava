package play.spring.disinfection;

import java.lang.reflect.InvocationTargetException;

public class ObjectFactory
{
	private ObjectFactory() { }

	public static <T> T createObject(Class<T> clazz)
			throws IllegalAccessException, InvocationTargetException, InstantiationException
	{
		// is interface ? search for implementations : can use to initialize
		return (T) clazz.getConstructors()[0].newInstance();
	}

	void meth(){}
	protected void meth2(){}
}
