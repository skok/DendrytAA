package com.dendrytdev.org.server.test.base;

import java.io.File;

import org.junit.*;
import com.google.appengine.api.datastore.dev.LocalDatastoreService;
import com.google.appengine.tools.development.ApiProxyLocalImpl;
import com.google.apphosting.api.ApiProxy;


/**
 * Dendryt Base TestCase class 
 *
 */
public class DendrytTestCaseBase {
	

    @Before
    public void setUp() throws Exception {
        ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment());
        ApiProxy.setDelegate(new ApiProxyLocalImpl(new File(".")){});       
        ApiProxyLocalImpl proxy = (ApiProxyLocalImpl) ApiProxy.getDelegate();

		proxy.setProperty(LocalDatastoreService.NO_STORAGE_PROPERTY, Boolean.TRUE.toString()); 
//        with this there will be no storage between junit tests
    }


    @After
    public void tearDown() throws Exception {
        // not strictly necessary to null these out but there's no harm either
        ApiProxy.setDelegate(null);
        ApiProxy.setEnvironmentForCurrentThread(null);
    }	
}
