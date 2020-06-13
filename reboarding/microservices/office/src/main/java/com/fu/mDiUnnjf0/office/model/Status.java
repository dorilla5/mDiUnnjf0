package com.fu.mDiUnnjf0.office.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum Status {
    ENTERED(0),
    EXITED(1);

    private Integer dbEnum;
}
