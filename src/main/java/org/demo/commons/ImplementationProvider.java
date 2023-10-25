package org.demo.commons;

/**
 * Utility class designed to provide the implementation of a given interface. <br>
 * The implementation class name is determined using a "pattern" that must be given to the constructor.<br>
 *
 */
public class ImplementationProvider {

	private final String pattern ;
	
	/**
	 * Constructor <br>
	 * 
	 * @param pattern the implementation class name pattern (supposed to contain 2 "%s") <br>
	 *  for example "%s.impl.jdbc.%sImpl" where <br>
	 *  the first "%s" will be replaced by the interface package name <br>
	 *  the second "%s" will be replaced by the interface simple class name <br>
	 */
	public ImplementationProvider(String pattern) {
		super();
		this.pattern = pattern;
	}

	/**
	 * Returns a service instance implementing the given interface
	 * @param interfaceClass
	 * @return
	 */
	public final <T> T getServiceInstance(Class<T> interfaceClass) {
		
		String serviceImplementationClassName = buildImplementationClassName(interfaceClass) ;
		try {
			Class<?> serviceImplementationClass = ImplementationProvider.class.getClassLoader().loadClass(serviceImplementationClassName);
			return createServiceInstance(interfaceClass, serviceImplementationClass) ;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot load class " + serviceImplementationClassName, e );
		}
	}
	
	/**
	 * Builds the service implementation full class name from the given interface class name
	 * @param interfaceClass
	 * @return
	 */
	private final String buildImplementationClassName(Class<?> interfaceClass) {

		Package interfacePackage = interfaceClass.getPackage();
		String interfacePackageName = interfacePackage != null ? interfacePackage.getName()  : "";
		String interfaceSimpleName = interfaceClass.getSimpleName();
		
		String result = String.format(pattern, interfacePackageName, interfaceSimpleName);
		return result ;
	}
	
	/**
	 * Creates the service instance using the given class
	 * @param interfaceClass
	 * @param implementationClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private final <T> T createServiceInstance(Class<T> interfaceClass, Class<?> implementationClass) {
		Object instance = null ;
		try {
			instance = implementationClass.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException("Cannot create instance for class " + implementationClass.getCanonicalName(), e );
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Cannot create instance for class " + implementationClass.getCanonicalName(), e );
		}
		if ( interfaceClass.isInstance(instance) ) {
			return (T) instance ;
		}
		else {
			throw new RuntimeException("Class " + implementationClass.getCanonicalName() + " does not implement " + interfaceClass.getSimpleName() );
		}
	}
}
