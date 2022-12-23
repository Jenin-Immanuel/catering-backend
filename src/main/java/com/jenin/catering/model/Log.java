package com.jenin.catering.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "log")
public class Log {
    @Id
    @SequenceGenerator(name = "log_sequence", sequenceName ="log_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_sequence")
    private Long event_id;
    private LocalDate date;

    private String event_name;
    private String f_name;
    private String l_name;
    private String venue;

    @OneToMany(targetEntity = ExtraServices.class)
    private List<ExtraServices> extraServices;

    public List<ExtraServices> getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(List<ExtraServices> extraServices) {
        this.extraServices = extraServices;
    }

    public Log() {}

    public Log(Long event_id, LocalDate date,String event_name, String f_name, String l_name, String venue) {
        this.event_id = event_id;
        this.date = date;
        this.event_name = event_name;
        this.f_name = f_name;
        this.l_name = l_name;
        this.venue = venue;
    }

    public Log(LocalDate date, String event_name, String f_name, String l_name, String venue) {
        this.date = date;
        this.event_name = event_name;
        this.f_name = f_name;
        this.l_name = l_name;
        this.venue = venue;
    }

//    public Log(Optional<Log> logOptional) {
//        if(logOptional.isEmpty()) {
//            throw new RuntimeException("I am shit");
//        }
//        this.date = logOptional.get().getDate();
//        this.event_id = logOptional.get().getEvent_id();
//        this.event_name = logOptional.get().getEvent_name();
//        this.f_name = logOptional.get().getF_name();
//        this.l_name = logOptional.get().getL_name();
//        this.venue = logOptional.get().getVenue();
//    }

    public Long getEvent_id() {
        return event_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getVenue() {
        return venue;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        final Log objToCompare = (Log) obj;
        if(!Objects.equals(this.event_name, objToCompare.event_name))
            return false;
        if(!Objects.equals(this.venue, objToCompare.venue))
            return false;
        return Objects.equals(this.event_id, objToCompare.event_id);
    }

    @Override
    public String toString() {
        return "Log{" +
                "event_id=" + event_id +
                ", date=" + date +
                ", event_name='" + event_name + '\'' +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }
}
