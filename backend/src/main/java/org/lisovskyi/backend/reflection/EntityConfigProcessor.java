//package org.lisovskyi.backend.reflection;
//
//import org.lisovskyi.backend.annotations.EntityConfig;
//
//import java.util.Map;
//
//public final class EntityConfigProcessor {
//    private EntityConfigProcessor() {
//        throw new UnsupportedOperationException("Reflection Utility class cannot be instantiated - utility class");
//    }
//
//    public static Map<String, Object> processEntityConfig(Class<?> entityClass) {
//        var annotations = entityClass.getAnnotations();
//        if (annotations.length == 0) {
//            return Map.of(
//                    "includeId", true,
//                    "includeCreatedAt", true,
//                    "includeUpdatedAt", true
//            );
//        }
//
//        for (var annotation : annotations) {
//            if (annotation.annotationType() == EntityConfig.class) {
//                var entityConfig = (EntityConfig) annotation;
//                return Map.of(
//                        "includeId", entityConfig.includeId(),
//                        "includeCreatedAt", entityConfig.includeCreatedAt(),
//                        "includeUpdatedAt", entityConfig.includeUpdatedAt()
//                );
//            }
//        }
//
//        return null;
//    }
//}
