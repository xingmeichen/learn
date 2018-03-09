/**
 * 
 */
package cherishIdea.generateObj;

import java.io.Serializable;
import java.util.Date;

/***
 * Description: </br>
 * @author chenxingmei
 * @date 2018年3月9日    
 */
public class Employee implements Cloneable, Serializable {
	
	/**
	 * serialVersionUID *
	 */
	private static final long serialVersionUID = -3618983791180554553L;

	/**
	 * name *
	 */
	public String name;
	
	/**
	 * gender *
	 */
	public String gender;
	
	/**
	 * birthday *
	 */
	public Date birthday;

	/***
	 * Description: 重写克隆方法</br>
	 * @author chenxingmei
	 * @date 2018年3月9日
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Employee employee = null;
		employee = (Employee) super.clone();
		employee.birthday = (Date) super.clone();
		return employee;
	}
}
