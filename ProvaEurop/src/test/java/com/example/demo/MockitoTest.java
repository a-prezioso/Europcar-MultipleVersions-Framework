//package com.example.demo;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//
////is possible to instantiate mockito in this method
//@RunWith(MockitoJUnitRunner.class)
//public class MockitoTest {
//	
//	//it is also possible to instantiate mockito in this method
////	@BeforeAll
////	public void init() {
////		MockitoAnnotations.initMocks(this);
////	}
//// finish method
//	
////	at least using another method
////	@Rule
////	public MockitoRule initRule = MockitoJUnit.rule();
////finish other method
//	
//	
//	//using mock annotation to simulate an arraylist
//	@Mock
//	List<String> mockedList;
//	 
//	@Test
//	public void whenUseMockAnnotation_thenMockIsInjected() {
//	    mockedList.add("one");
//	    verify(mockedList).add("one");
//	    assertEquals(0, mockedList.size());
//	 
//	    when(mockedList.size()).thenReturn(100);
//	    assertEquals(100, mockedList.size());
//	}
//	
//	@Test
//	public void whenNotUseMockAnnotation_thenCorrect() {
//	    List<String> mockList = Mockito.mock(ArrayList.class);
//	     
//	    mockList.add("one");
//	    Mockito.verify(mockList).add("one");
//	    assertEquals(0, mockList.size());
//	 
//	    Mockito.when(mockList.size()).thenReturn(100);
//	    assertEquals(100, mockList.size());
//	}
//	
//	
//	
//	//is a piece of mock
//	@Spy
//	List<String> spiedList = new ArrayList<>();
//	
//	@Test
//	public void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
//	    spiedList.add("one");
//	    spiedList.add("two");
//	 
//	    Mockito.verify(spiedList).add("one");
//	    Mockito.verify(spiedList).add("two");
//	 
//	    assertEquals(2, spiedList.size());
//	 
//	    Mockito.doReturn(100).when(spiedList).size();
//	    assertEquals(100, spiedList.size());
//	}
//
//	//differente way of spy using
//	@Test
//	public void whenNotUseSpyAnnotation_thenCorrect() {
//	    List<String> spyList = Mockito.spy(new ArrayList<String>());
//	     
//	    spyList.add("one");
//	    spyList.add("two");
//	 
//	    Mockito.verify(spyList).add("one");
//	    Mockito.verify(spyList).add("two");
//	 
//	    assertEquals(2, spyList.size());
//	 
//	    Mockito.doReturn(100).when(spyList).size();
//	    assertEquals(100, spyList.size());
//	}
//	
//	
//	
//	
//	///Captor
//	@Test
//	public void whenNotUseCaptorAnnotation_thenCorrect() {
//	    List<String> mockList = Mockito.mock(List.class);
//	    ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
//	 
//	    mockList.add("one");
//	    Mockito.verify(mockList).add(arg.capture());
//	 
//	    assertEquals("one", arg.getValue());
//	}
//	
//	
//	//different way of using captor with annotations
//	@Mock
//	List<String> mockedList2;
//	 
//	@Captor
//	ArgumentCaptor argCaptor;
//	 
//	@Test
//	public void whenUseCaptorAnnotation_thenTheSam() {
//	    mockedList2.add("one");
//	    Mockito.verify(mockedList).add((String) argCaptor.capture());
//	 
//	    assertEquals("one", argCaptor.getValue());
//	}
//	
//	
//	
//	//using inject mocks
//	@Mock
//	Map<String, String> wordMap;
//	 
//	@InjectMocks
//	MyDictionary dic = new MyDictionary();
//	 
//	@Test
//	public void whenUseInjectMocksAnnotation_thenCorrect() {
//	    Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
//	 
//	    assertEquals("aMeaning", dic.getMeaning("aWord"));
//	}
//	
//	
//	//control of exception
//	public class MockitoAnnotationsUninitializedUnitTest {
//		 
//	    @Mock
//	    List<String> mockedList;
//	 
//	    @Test(expected = NullPointerException.class)
//	    public void whenMockitoAnnotationsUninitialized_thenNPEThrown() {
//	        Mockito.when(mockedList.size()).thenReturn(1);
//	    }
//	}
//	
//}
