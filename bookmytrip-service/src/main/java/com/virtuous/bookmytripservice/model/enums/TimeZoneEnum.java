package com.virtuous.bookmytripservice.model.enums;

import java.time.ZoneId;

public enum TimeZoneEnum {

    AMERICA_NEW_YORK("America/New_York"),
    EUROPE_LONDON("Europe/London"),
    EUROPE_PARIS("Europe/Paris"),
    ASIA_ISTANBUL("Europe/Istanbul");

    private final String zoneId;

    TimeZoneEnum(String zoneId) {
        this.zoneId = zoneId;
    }

    public ZoneId toZoneId() {
        return ZoneId.of(zoneId);
    }

    public static TimeZoneEnum fromString(String timeZone) {
        return switch (timeZone) {
            case "Europe/Istanbul" -> ASIA_ISTANBUL;
            case "America/New_York" -> AMERICA_NEW_YORK;
            case "Europe/London" -> EUROPE_LONDON;
            case "Europe/Paris" -> EUROPE_PARIS;
            default -> throw new IllegalArgumentException("Invalid timezone: " + timeZone);
        };
    }
}
