package com.cxp.sbt.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
/*
 * @PropertySource(value={"classpath:application.properties"})
 * 
 * @ConfigurationProperties(prefix = "persion")
 */
public class PersonTest {
	
	private String name;
	private int age;
	private float weight;
	private boolean boss;
	private String birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public boolean isBoss() {
		return boss;
	}
	public void setBoss(boolean boss) {
		this.boss = boss;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public PersonTest(String name, int age, float weight, boolean boss, String birth) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.boss = boss;
		this.birth = birth;
	}
	public PersonTest() {
		super();
	}
	@Override
	public String toString() {
		return "PersonTest [name=" + name + ", age=" + age + ", weight=" + weight + ", boss=" + boss + ", birth="
				+ birth + "]";
	}
	
	
}
