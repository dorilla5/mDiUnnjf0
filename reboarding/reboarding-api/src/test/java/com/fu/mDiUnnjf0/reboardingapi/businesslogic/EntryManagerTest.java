package com.fu.mDiUnnjf0.reboardingapi.businesslogic;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.fu.mDiUnnjf0.reboardingapi.exception.UserStatusException;

@RunWith(MockitoJUnitRunner.class)
public class EntryManagerTest {

    @Mock
    QueueService queueServiceMock;
    @Mock
    OfficeService officeServiceMock;

    @InjectMocks
    EntryManager toTest;

    @Test
    public void testEntryUser() {
        final String userName = "Jani-entry";

        ReflectionTestUtils.setField(toTest, "officeCapacity", 2);
        ReflectionTestUtils.setField(toTest, "maxRatio", 1);
        when(queueServiceMock.status(userName)).thenReturn(1);
        when(officeServiceMock.count()).thenReturn(1);
        when(officeServiceMock.staysIn(userName)).thenReturn(false);

        toTest.entryUser(userName);

        verify(queueServiceMock, times(1)).status(userName);
        verify(officeServiceMock, times(1)).count();
        verify(officeServiceMock, times(1)).staysIn(userName);
        verify(officeServiceMock, times(1)).entry(userName);
    }

    @Test
    public void testNotEntryUserCauseNotFreePlace() {
        final String userName = "Jani-entry1";

        ReflectionTestUtils.setField(toTest, "officeCapacity", 2);
        ReflectionTestUtils.setField(toTest, "maxRatio", 1);
        when(queueServiceMock.status(userName)).thenReturn(1);
        when(officeServiceMock.count()).thenReturn(2);

        assertFalse(toTest.entryUser(userName));

        verify(queueServiceMock, times(1)).status(userName);
        verify(officeServiceMock, times(1)).count();
        verify(officeServiceMock, times(0)).staysIn(userName);
        verify(officeServiceMock, times(0)).entry(userName);
    }

    @Test
    public void testNotEntryUserCauseHeIsIn() {
        final String userName = "Jani-entry2";

        ReflectionTestUtils.setField(toTest, "officeCapacity", 2);
        ReflectionTestUtils.setField(toTest, "maxRatio", 1);
        when(queueServiceMock.status(userName)).thenReturn(1);
        when(officeServiceMock.count()).thenReturn(1);
        when(officeServiceMock.staysIn(userName)).thenReturn(true);

        try {
            toTest.entryUser(userName);
            fail("Expected UserStatusException.");
        } catch (final UserStatusException expected) {
            verify(queueServiceMock, times(1)).status(userName);
            verify(officeServiceMock, times(1)).count();
            verify(officeServiceMock, times(1)).staysIn(userName);
            verify(officeServiceMock, times(0)).entry(userName);
        }
    }

    @Test
    public void testNotEntryUserCauseHeIsNotInTheQueue() {
        final String userName = "Jani-entry3";

        ReflectionTestUtils.setField(toTest, "officeCapacity", 2);
        ReflectionTestUtils.setField(toTest, "maxRatio", 1);
        when(queueServiceMock.status(userName)).thenThrow(new UserStatusException());
        try {
            toTest.entryUser(userName);
            fail("Expected UserStatusException.");
        } catch (final UserStatusException expected) {
            verify(queueServiceMock, times(1)).status(userName);
            verify(officeServiceMock, times(0)).count();
            verify(officeServiceMock, times(0)).staysIn(userName);
            verify(officeServiceMock, times(0)).entry(userName);
        }

    }

    @Test
    public void testNotEntryUserBecauseHeIsFirstInTheWaitingList() {
        final String userName = "Jani-entry4";

        ReflectionTestUtils.setField(toTest, "officeCapacity", 2);
        ReflectionTestUtils.setField(toTest, "maxRatio", 1);
        when(queueServiceMock.status(userName)).thenReturn(1);
        when(officeServiceMock.count()).thenReturn(2);
        when(officeServiceMock.staysIn(userName)).thenReturn(false);

        assertFalse(toTest.entryUser(userName));

        verify(queueServiceMock, times(1)).status(userName);
        verify(officeServiceMock, times(1)).count();
        verify(officeServiceMock, times(0)).staysIn(userName);
        verify(officeServiceMock, times(0)).entry(userName);
    }

}
