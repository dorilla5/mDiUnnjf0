package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import static org.junit.Assert.fail;
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
import com.fu.mDiUnnjf0.reboardingapi.dto.RegisterResponse;
import com.fu.mDiUnnjf0.reboardingapi.exception.UserStatusException;

@RunWith(MockitoJUnitRunner.class)
public class RegisterManagerTest {

    @Mock
    QueueService queueServiceMock;
    @Mock
    OfficeService officeServiceMock;
    @Mock
    StatusManager statusManagerMock;

    @InjectMocks
    RegisterManager toTest;

    @Test
    public void testRegisterUserWaitingList() {

        final String userName = "Jani";

        when(statusManagerMock.status(userName)).thenReturn(4);
        when(queueServiceMock.status(userName)).thenThrow(new UserStatusException()).thenReturn(5);
        when(officeServiceMock.staysIn(userName)).thenReturn(false);
        final RegisterResponse response = toTest.register(userName);
        assertEquals(4, response.getWaitingListIndex());
        assertEquals(false, response.isSucceed());

        verify(queueServiceMock, times(1)).status(userName);
        verify(officeServiceMock, times(1)).staysIn(userName);
        verify(queueServiceMock, times(1)).register(userName);
        verify(statusManagerMock, times(1)).status(userName);

    }

    @Test
    public void testRegisterUserSucceed() {

        final String userName = "Jani";

        when(statusManagerMock.status(userName)).thenReturn(0);
        when(queueServiceMock.status(userName)).thenThrow(new UserStatusException()).thenReturn(0);
        when(officeServiceMock.staysIn(userName)).thenReturn(false);
        final RegisterResponse response = toTest.register(userName);
        assertEquals(0, response.getWaitingListIndex());
        assertEquals(true, response.isSucceed());

        verify(queueServiceMock, times(1)).status(userName);
        verify(officeServiceMock, times(1)).staysIn(userName);
        verify(queueServiceMock, times(1)).register(userName);
        verify(statusManagerMock, times(1)).status(userName);

    }

    @Test
    public void testRegisterUserInOffice() {

        final String userName = "Jani";
        when(queueServiceMock.status(userName)).thenThrow(new UserStatusException());
        when(officeServiceMock.staysIn(userName)).thenReturn(true);
        try {
            toTest.register(userName);
            fail("UserStatusException expected");
        } catch (final UserStatusException exception) {
            verify(queueServiceMock, times(1)).status(userName);
            verify(officeServiceMock, times(1)).staysIn(userName);
            verify(queueServiceMock, times(0)).register(userName);
            verify(statusManagerMock, times(0)).status(userName);
        }

    }

    @Test
    public void testRegisterUserInList() {

        final String userName = "Jani";
        when(queueServiceMock.status(userName)).thenReturn(5);
        try {
            toTest.register(userName);
            fail("UserStatusException expected");
        } catch (final UserStatusException exception) {
            verify(queueServiceMock, times(1)).status(userName);
            verify(officeServiceMock, times(0)).staysIn(userName);
            verify(queueServiceMock, times(0)).register(userName);
            verify(statusManagerMock, times(0)).status(userName);
        }

    }

}
