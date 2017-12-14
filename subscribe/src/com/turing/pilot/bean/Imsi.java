package com.turing.pilot.bean;

import java.io.Serializable;

/**   
* @ClassName: o_imsi   
* @Description: TODO(imsi表)   
* @author 蒋天恒
* @date 2016-5-24 上午11:01:25   
*      
*/
public class Imsi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 187785278356257264L;
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
