package com.dendrytdev.org.server;

import javax.jdo.PersistenceManager;

import com.dendrytdev.org.client.bean.*;

//tu dodajemy przykladowe klasy
//nie rozbudowywac tego kodu!
//wszystkie operacje robic za pomoca funkcji z DatabaseConnector
public class AdderSampleEntities {
	public static void addSampleEntities() {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Person service1 = new Person();
		service1.setLogin("kmicic");

		Person designer1 = new Person();
		designer1.setLogin("lma");
		designer1.setFirstName("Leszek");
		designer1.setFunction(Function.DESIGNER);

		Person programmer1 = new Person();
		programmer1.setLogin("gazface");
		programmer1.setFunction(Function.PROGRAMMER);
		
		Person client1 = new Person();
		client1.setLogin("abg_group");
		client1.setFunction(Function.CLIENT);
		
		Product product1 = new Product();
		product1.setName("dendryt");
		product1.setVersion("1.0");

		Group group1 = new Group();
		group1.setName("szpitale");

		Problem problem1 = new Problem();
		problem1.setDescription("nic nie dziala!");

		problem1.setClient(client1.getLogin());
		problem1.setDesigner(designer1.getLogin());
		problem1.setProgrammer(programmer1.getLogin());

		pm.makePersistent(service1);
		pm.makePersistent(designer1);
		pm.makePersistent(programmer1);
		pm.makePersistent(product1);
		pm.makePersistent(group1);
		pm.makePersistent(problem1);

		pm.close();
	}
}
