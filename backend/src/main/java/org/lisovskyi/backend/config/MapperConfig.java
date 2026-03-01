package org.lisovskyi.backend.config;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MapperConfig {}
