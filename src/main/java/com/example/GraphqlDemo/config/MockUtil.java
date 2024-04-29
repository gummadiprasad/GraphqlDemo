package com.example.GraphqlDemo.config;

//import com.example.GraphqlDemo.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Objects;


@UtilityClass
public final class MockUtil {
    private static Logger LOGGER= LoggerFactory.getLogger(MockUtil.class);
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static <T> T getMock(final String mockJsonFileName, Class<T> type) {
        try {
            String mockJsonString = IOUtils.toString(Objects.requireNonNull(MockUtil.class.getClassLoader().
                    getResourceAsStream(getJsonPath(mockJsonFileName))), StandardCharsets.UTF_8);
            return JSON_MAPPER.readValue(mockJsonString, type);
        } catch (Exception e) {
            LOGGER.error("Unable to read mock api response data", e);
        }
        return null;
    }

    private static String getJsonPath(String mockJsonFileName) {
        return "mock/" + mockJsonFileName + ".json";
    }
}
