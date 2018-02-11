package com.ouyang.project.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by ouyang on 2017/8/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Test
    public void testVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
        clearInvocations(mockedList);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
//        verifyNoMoreInteractions(mockedList);
        verifyZeroInteractions(mockedList);
    }

    @Test
    public void testStub() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(999));
    }
}
