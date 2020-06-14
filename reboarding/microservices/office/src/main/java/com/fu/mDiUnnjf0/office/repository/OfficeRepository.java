package com.fu.mDiUnnjf0.office.repository;

import com.fu.mDiUnnjf0.office.entity.OfficePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<OfficePerson, Long> {

    Boolean existsOfficePersonByUserName( final String userName );

    OfficePerson findOfficePersonByUserName( final String userName );

    Integer countOfficePersonByStatus( final Integer status );

}
