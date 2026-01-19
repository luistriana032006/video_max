package com.luistriana.video_max.model.entity.converter;

import com.luistriana.video_max.model.entity.enums.MpaaRating;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MpaaRatingConverter implements AttributeConverter<MpaaRating, String> {

    /**
     * como funciona este metodo y que hace ??
     */
    @Override
    public String convertToDatabaseColumn(MpaaRating rating) {
        if (rating == null) {
            return null;
        }
        return rating.getDbValue();
    }

    /**
     * como funciona este metodo y que hace
     */
    @Override
    public MpaaRating convertToEntityAttribute(String dbValue) {
        if (dbValue == null) {
            return null;
        }
        for (MpaaRating rating : MpaaRating.values()) {

            if (rating.getDbValue().equals(dbValue)) {
                return rating;
            }

        }
        throw new IllegalArgumentException("rating desconocido" + dbValue);

    }

}
