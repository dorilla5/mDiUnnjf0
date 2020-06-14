package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;
import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;
import com.fu.mDiUnnjf0.reboardingapi.dto.RegisterResponse;

@RunWith(MockitoJUnitRunner.class)
public class RegisterManagerTest {

    @Mock
    QueueService queueServiceMock;
    @Mock
    OfficeService officeServiceMock;

    @InjectMocks
    RegisterManager toTest;

    @Test
    public void testRegisterUser() {
        final RegisterResponse response = toTest.register("Jani");
        assertEquals(response.getWaitingListIndex(), 0);
        verify(queueServiceMock, times(1)).register("Jani");
    }
}
