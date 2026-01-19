package com.luistriana.video_max.model.entity.enums;

import lombok.Getter;

@Getter
public enum MpaaRating {
    G("G"),
    PG("PG"),
    R("R"),
    PG_13("PG-13"),
    NC_17("NC-17");

    private final String dbValue;

    MpaaRating(String dbValue) {
        this.dbValue = dbValue;
    }

}
