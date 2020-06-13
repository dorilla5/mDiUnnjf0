package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.annotations.BeforeTest;

import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.OfficeService;
import com.fu.mDiUnnjf0.reboardingapi.businesslogic.service.QueueService;
import com.fu.mDiUnnjf0.reboardingapi.dto.RegisterResponse;

@RunWith(MockitoJUnitRunner.class)
public class RegisterManagerTest {

    public RegisterManagerTest() {

    }

    @Mock
    QueueService queueServiceMock;
    @Mock
    OfficeService officeServiceMock;

    @InjectMocks
    RegisterManager registerManagerToTest;

    @BeforeTest
    public void initMocks() {
        System.out.println("Called yeee");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        Mockito.mock(RegisterManager.class);

        final RegisterResponse response = registerManagerToTest.register("Jani");
        assertEquals(response.getWaitingListIndex(), 0);
        // verify(queueServiceMock, times(1)).register("Jani");

    }
}
