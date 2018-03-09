/**
 * 
 */
package cherishIdea.generateObj;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;

/***
 * Description: 该类列举了创建对象的几种方式</br>
 * @author chenxingmei
 * @date 2018年3月9日 
 */
public class GenerateObject {

	/***
	 * Description: 通过new关键字创建一个对象</br>
	 * @author chenxingmei
	 * @date 2018年3月9日
	 */
	public static Employee newObject() {
		Employee employee = new Employee();
		return employee;
	}
	
	/***
	 * Description: 通过反射的方法创建对象(一)</br>
	 * @author chenxingmei
	 * @date 2018年3月9日
	 */
	public static Employee newInstanceObject() {
		Employee employee = null;
		try {
			employee = Employee.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	/***
	 * Description: 通过反射的方法创建对象（二）</br>
	 * @author chenxingmei
	 * @date 2018年3月9日
	 */
	public static Employee getInstanteObject() {
		Constructor<Employee> constructor;
		Employee employee = null;
		try {
			constructor = Employee.class.getConstructor(Employee.class);
			employee = constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	/***
	 * Description: 通过克隆创建对象</br>
	 * @author chenxingmei
	 * @date 2018年3月9日
	 */
	public static Employee clonObject(Employee param) {
		if (null == param) {
			return new Employee();
		}
		Employee employee = null;
		try {
			employee = (Employee) param.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} 
		return employee;
	}
	
	/***
	 * Description: 通过反序列化创建对象</br>
	 * @author chenxingmei
	 * @date 2018年3月9日
	 */
	@SuppressWarnings("resource")
	public static Employee seriObject() {
		ObjectInputStream in = null;
		Employee employee = null;
		try {
			in = new ObjectInputStream(new FileInputStream("data.obj"));
			employee = (Employee) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
