package util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.ApiError;
import util.ErrorType;

import java.io.IOException;
import java.io.Serializable;

public class JsonUtil
{
    public static String mapToJson(Object obj)
    {

        ObjectMapper mapper = ObjectMapperProvider.getObjectMapper();
        mapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);


        try
        {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public static <T extends Serializable> T fromJson(String jsonData, java.lang.Class<T> valueType)
    {
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            return mapper.readValue(jsonData, valueType);
        } catch (IOException e)
        {
            e.printStackTrace();
            throw new ApiError(ErrorType.BAD_REQUEST, "Failed to parse json: 24");
        }
    }

    public static <T extends Serializable> T fromJson(JsonNode jsonData, java.lang.Class<T> valueType)
    {
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            return mapper.treeToValue(jsonData, valueType);
        } catch (IOException e)
        {
            e.printStackTrace();
            throw new ApiError(ErrorType.BAD_REQUEST, "Failed to parse json: 23");
        }
    }
}
