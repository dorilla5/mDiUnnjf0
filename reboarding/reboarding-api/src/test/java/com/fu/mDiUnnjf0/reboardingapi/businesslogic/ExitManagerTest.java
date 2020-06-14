package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;

@RunWith(MockitoJUnitRunner.class)
public class ExitManagerTest {
    @Mock
    OfficeService officeServiceMock;

    @InjectMocks
    ExitManager toTest;

    @Test
    public void testExitUser() {
        toTest.exitUser("Jani");
        verify(officeServiceMock, times(1)).exit("Jani");
    }

}
