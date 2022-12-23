package com.jenin.catering.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class LogPKId implements Serializable {
    private Long event_id;
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogPKId logPKId = (LogPKId) o;
        return Objects.equals(event_id, logPKId.event_id) && Objects.equals(date, logPKId.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event_id, date);
    }
}
