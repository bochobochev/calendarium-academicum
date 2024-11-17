package org.calendarium.calendarium.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static java.util.UUID.fromString;

public class ParseUtil {

    private static final Logger logger = LoggerFactory.getLogger(ParseUtil.class);

    public static UUID getUuidFromString(String id) {
        UUID guid = null;
        try {
            guid = fromString(id);
        } catch (IllegalArgumentException illegalArgumentException) {
            logger.warn("Invalid UUID: {}", id);
        }

        return guid;
    }
}
