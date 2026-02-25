package org.lisovskyi.backend.enums;

import java.util.Arrays;
import java.util.Optional;

public final class EnumProcessor {
    private EnumProcessor() {
        throw new UnsupportedOperationException("EnumUtility cannot be instantiated - utility class");
    }

    public static <T extends Enum<T> & BaseEnum> Optional<T> fromValue(Class<T> enumClass, String value) {
        if (value == null || value.isBlank()) {
            return Optional.empty();
        }

        return Arrays.stream(enumClass.getEnumConstants())
                .filter(enumConstant -> enumConstant.getValue().equalsIgnoreCase(value))
                .findFirst();
    }
}
