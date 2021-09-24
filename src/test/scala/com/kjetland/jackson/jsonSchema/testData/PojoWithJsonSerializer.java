package com.kjetland.jackson.jsonSchema.testData;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.kjetland.jackson.jsonSchema.testData.utils.LocalDateSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class PojoWithJsonSerializer {
    public long realLong = 4;

    public double realDouble = 4.5;

    public String realString = "str";

    @JsonSerialize(using = ToStringSerializer.class)
    public long longSerializedAsString = 5;

    @JsonSerialize(using = ToStringSerializer.class)
    public double doubleSerializedAsString = 5.5;

    @JsonSerialize(using = LocalDateSerializer.class)
    public LocalDate localDate = LocalDate.of(2000, 1,1 );

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PojoWithJsonSerializer that = (PojoWithJsonSerializer) o;

        if (realLong != that.realLong) return false;
        if (longSerializedAsString != that.longSerializedAsString) return false;
        return realString != null ? realString.equals(that.realString) : that.realString == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (realLong ^ (realLong >>> 32));
        result = 31 * result + (realString != null ? realString.hashCode() : 0);
        result = 31 * result + (int) (longSerializedAsString ^ (longSerializedAsString >>> 32));
        return result;
    }
}
