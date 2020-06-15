package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;
import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;

@RunWith(MockitoJUnitRunner.class)
public class StatusManagerTest {

    @Mock
    QueueService queueServiceMock;
    @Mock
    OfficeService officeServiceMock;

    @InjectMocks
    StatusManager toTest;

    @Test
    public void testUserStatus() {
        final String userName = "Jani";

        when(queueServiceMock.status(userName)).thenReturn(1);

        assertEquals(1, toTest.status(userName));

        verify(queueServiceMock, times(1)).status(userName);
    }
}
