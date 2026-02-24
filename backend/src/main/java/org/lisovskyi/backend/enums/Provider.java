package org.lisovskyi.backend.enums;

import lombok.Getter;

@Getter
public enum Provider implements BaseEnum {
    GOOGLE("google"),
    FACEBOOK("facebook"),
    GITHUB("github"),
    TWITTER("twitter"),
    LINKEDIN("linkedin"),
    APPLE("apple");

    private final String providerName;

    Provider(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String getValue() {
        return providerName;
    }
}
