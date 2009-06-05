package com.dendrytdev.org.server.test2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestUserAddition.class,
	TestDeleteUsers.class,
	TestSetChangesUser.class,
	TestAddGroupsAndProducts.class,
	TestRemoveGroupsAndProducts.class,
	TestServicer.class
	
})

public class TestSuite2 {
	
}
