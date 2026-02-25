package org.lisovskyi.backend.enums;

import lombok.Getter;

@Getter
public enum Platform implements BaseEnum {
    FACEBOOK("facebook"),
    INSTAGRAM("instagram"),
    TWITTER("twitter"),
    LINKEDIN("linkedin"),
    TELEGRAM("telegram");

    private final String platformName;

    Platform(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String getValue() {
        return platformName;
    }
}
