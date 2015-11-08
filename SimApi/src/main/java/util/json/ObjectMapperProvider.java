package util.json;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;

public class ObjectMapperProvider implements ContextResolver<ObjectMapper>
{

    final ObjectMapper defaultObjectMapper;

    public ObjectMapperProvider()
    {
        defaultObjectMapper = getObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type)
    {
        return defaultObjectMapper;
    }

    public static ObjectMapper getObjectMapper()
    {
        return new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

}
