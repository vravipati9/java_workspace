package bo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import dao.OrderDAO;
import dao.OrderDAOImpl;

public class OrderBOImplTest {

	@Mock
	OrderDAO mockDAO;	// mock object

	OrderDAO dao = new OrderDAOImpl();	// actual object
	
	@Before
	public void initMockObjects() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPlaceOrder() {
		System.out.println(mockDAO);
		OrderBOImpl bo = new OrderBOImpl();
		bo.setOrderDAO(mockDAO);
		Mockito.when(mockDAO.processOrder()).thenReturn(true);	// we are setting the expected return type
		assertTrue(bo.placeOrder());
		Mockito.verify(mockDAO).processOrder();		// If we want to check the mock object is actually called 
													// If we comment above line, this method will fail.
	}
	
	@Test
	public void testArgumentCapture() {
		OrderBOImpl bo = new OrderBOImpl();
		bo.setOrderDAO(mockDAO);
		bo.placeOrder("Laptops");
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		
		Mockito.verify(mockDAO).processOrder(arg.capture());	
		assertEquals("Laptops", arg.getValue());
	}
	
	@Test
	public void testThenAnswer() {
		OrderBOImpl bo = new OrderBOImpl();
		bo.setOrderDAO(mockDAO);
		Mockito.when(mockDAO.getOrdersCount()).thenAnswer(new Answer() {
			public int count = 0;
		@Override
		public Object answer(InvocationOnMock invocation) throws Throwable {
			// TODO Auto-generated method stub
			return ++count;
		}
		});
		
		assertEquals(1, bo.getTotalOrders());
		assertEquals(2, bo.getTotalOrders());
		//Mockito.verify(mockDAO).processOrder();	
	}
}
