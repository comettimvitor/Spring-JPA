package com.talkevents.jpa.services;

import com.talkevents.jpa.dtos.SaveEventRecordDto;
import com.talkevents.jpa.entities.Attendee;
import com.talkevents.jpa.entities.Event;
import com.talkevents.jpa.entities.Location;
import com.talkevents.jpa.repositories.AttendeeRepository;
import com.talkevents.jpa.repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;


    public EventService(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    @Transactional
    public Event saveEvent(SaveEventRecordDto eventDto) {
        var event = new Event();
        Set<Attendee> attendees = new HashSet<>(attendeeRepository.findAllById(eventDto.attendees()));
        var location = new Location();

        location.setName(eventDto.location().name());
        location.setAddress(eventDto.location().address());
        location.setCapacity(eventDto.location().capacity());

        event.setName(eventDto.name());
        event.setDate(eventDto.date());
        event.setAttendees(attendees);

        event.setLocation(location);
        location.setEvent(event);

        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
