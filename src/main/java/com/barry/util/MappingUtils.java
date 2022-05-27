package com.barry.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MappingUtils {

    private static final Logger LOGGER = LogManager.getLogger(MappingUtils.class);

    public static void checkIfValidateCode(String code){
        if (StringUtils.isEmpty(code)){
            LOGGER.error("Invalid code: it should not be empty");
            throw new IllegalArgumentException("Invalid code: it should not be Empty");
        }
        if(StringUtils.isBlank(code)){
            LOGGER.error("Invalid code: it should not be Blank");
            throw new IllegalArgumentException("Invalid code: it should not be Blank");
        }
    }
}
