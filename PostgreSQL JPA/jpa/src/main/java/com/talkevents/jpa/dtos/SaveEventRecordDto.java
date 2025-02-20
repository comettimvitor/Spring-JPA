package com.talkevents.jpa.dtos;

import com.talkevents.jpa.entities.Location;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record SaveEventRecordDto (
        String name,
        LocalDateTime date,
        Set<UUID> attendees,
        Location location
){}
