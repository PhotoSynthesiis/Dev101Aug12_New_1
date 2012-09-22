package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SystemFlowTest {
    private Class libraryController;
    private CustomerActions customerActions;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        libraryController = SystemFlow.class;
        customerActions = mock(CustomerActions.class);
    }

    @Test
    public void shouldBeAbleToViewAllTheBooksWhenChooseTheFirstChoice() throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchFieldException {
        when(customerActions.getClientChosenOption()).thenReturn(String.valueOf(1));
        Object obj = libraryController.newInstance();

        Field field = libraryController.getDeclaredField("customerActions");
        field.setAccessible(true);
        field.set(obj, customerActions);

        Method method = libraryController.getDeclaredMethod("operationsBasedOnClientChoice");
        method.setAccessible(true);
        method.invoke(obj);

        verify(customerActions).viewAllTheBooks();
    }

    @Test
    public void shouldCallShowWarningMessageMethodGivenChoiceNotProvided() throws NoSuchMethodException, NoSuchFieldException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        when(customerActions.getClientChosenOption()).thenReturn(String.valueOf(9));
        Object obj = libraryController.newInstance();
        Messages messages = mock(Messages.class);

        Field field1 = libraryController.getDeclaredField("customerActions");
        field1.setAccessible(true);
        field1.set(obj, customerActions);

        Field field2 = libraryController.getDeclaredField("messages");
        field2.setAccessible(true);
        field2.set(obj, messages);

        Method method = libraryController.getDeclaredMethod("operationsBasedOnClientChoice");
        method.setAccessible(true);

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 3000L;
//        while (endTime - System.currentTimeMillis() > 0) {
//            method.invoke(obj);
//        }

//        verify(messages).showWarningMessage();
    }
//
//    @Test
//    public void shouldBeAbleToExitTheSystem() {
//        // TODO how to implement this?
//    }
}
