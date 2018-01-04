/*
 * Copyright 2014 Buyforyou.cn All rights reserved
 * 
 * @author Kang.Y
 * 
 * @mail
 * 
 * @createtime 2018年1月3日 下午11:13:52
 */
package cn.nickboyer.blog.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;

import cn.nickboyer.blog.entry.Blogs;
import cn.nickboyer.blog.web.cloud.Test;

/**
 * @title
 * @description
 * @since JDK1.8
 */
@RestController
public class TestController {

	@Autowired
	private Test test;

	private static ObjectMapper mapper = new ObjectMapper();

	@RequestMapping("/hi")
	public String test(String name) {
		return test.test(name);
	}

	public static void main(String[] args) throws Exception {

		Page<Blogs> page = new Page<>();
		Blogs blog = new Blogs();
		blog.setId(1);
		blog.setHeader("测试");
		page.add(blog);

		page.setPageNum(10);
		page.setPageSize(10);
		page.setPages(10);

		String json = mapper.writeValueAsString(page);
		System.out.println(json);
		Page<Blogs> value = mapper.readValue(json, Page.class);
		System.out.println(value.toString());

		Person<Name> p = new Person();
		p.setPersonId("12");
		Name n = new Name();
		n.setId("32");
		n.setName("张三");
		p.setName(n);
		p.add(n);
		String pJson = mapper.writeValueAsString(p);
		System.out.println(pJson);
		Person<Name> readValue = mapper.readValue(pJson, Person.class);
		System.out.println(readValue.toString());

	}
}

class Person<E> extends ArrayList<E> {

	String personId;

	E name;

	/**
	 * @return personId
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * @param personId to set personId
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * @return name
	 */
	public E getName() {
		return name;
	}

	/**
	 * @param name to set name
	 */
	public void setName(E name) {
		this.name = name;
	}

	/**
	 * （no Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + "]";
	}

}

class Name {

	String id;
	String name;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id to set id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * （no Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Name [id=" + id + ", name=" + name + "]";
	}

}