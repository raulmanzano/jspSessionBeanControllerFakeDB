package jspjdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.manzano.ejemplo.jspjdbc.business.BusinessDelegate;


public class BusinessDelegateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetAllPrincipal() {		
		BusinessDelegate bd= new BusinessDelegate();		
		assertEquals(3, bd.getAllPrimaria().size());
	}

	@Test
	public final void testInsertarPrincipal() {
	fail("Not yet implemented"); // TODO
	
	}

}
