package com.dendrytdev.org.server.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Keeps all tests in one place
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestCommentDAO.class,
	TestProblemDAO.class,
	TestLogin.class,
	TestProblemSubmitingServiceImpl.class,
	TestProductDAO.class
})
public class DendrytTestSuit{}
