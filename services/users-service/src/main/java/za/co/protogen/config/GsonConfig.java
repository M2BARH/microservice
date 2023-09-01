package za.co.protogen.config;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class GsonConfig {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setLenient()
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .create();
    }

    private static class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(final JsonElement jsonElement, final Type type,
                                     final JsonDeserializationContext jsonDeserializationContext) {
            return LocalDate.parse(jsonElement.getAsString(), FORMATTER);
        }
    }

    private static class LocalDateSerializer implements JsonSerializer<LocalDate> {

        @Override
        public JsonElement serialize(final LocalDate dateOfBirth, final Type typeOfSrc,
                                     final JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(FORMATTER.format(dateOfBirth));
        }
    }
}
