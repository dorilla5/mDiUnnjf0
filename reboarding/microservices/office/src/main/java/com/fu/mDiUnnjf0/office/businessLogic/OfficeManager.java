package com.fu.mDiUnnjf0.office.businessLogic;

import com.fu.mDiUnnjf0.office.entity.OfficePerson;
import com.fu.mDiUnnjf0.office.model.Status;
import com.fu.mDiUnnjf0.office.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Business logic class for handling queue operations. Now there is not much logic, but later, who knows...
 */
@Component
public class OfficeManager {

    @Autowired
    private OfficeRepository officeRepository;

    public void enter( final String userName ) {
        OfficePerson newItem = new OfficePerson();
        newItem.setUserName(userName);
        newItem.setStatus(Status.ENTERED.getDbEnum());
        officeRepository.save(newItem);
    }

    public void exit( final String userName ) {
        final OfficePerson officePersonByUserName = officeRepository.findOfficePersonByUserName(userName);
        officePersonByUserName.setStatus(Status.EXITED.getDbEnum());
        officeRepository.save(officePersonByUserName);
    }

    public Boolean isInTheOffice( final String userName ) {
        return officeRepository.existsOfficePersonByUserName(userName);
    }

    public Integer countPeople() {
        return officeRepository.countOfficePersonByStatus(Status.ENTERED.getDbEnum());
    }
}
