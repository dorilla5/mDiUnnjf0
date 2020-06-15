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
import org.springframework.test.util.ReflectionTestUtils;

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

        ReflectionTestUtils.setField(toTest, "officeCapacity", 2);
        ReflectionTestUtils.setField(toTest, "maxRatio", 1);

        when(officeServiceMock.count()).thenReturn(1);

        when(queueServiceMock.status(userName)).thenReturn(5);

        assertEquals(4, toTest.status(userName));

        verify(queueServiceMock, times(1)).status(userName);
        verify(officeServiceMock, times(1)).count();

    }
}
