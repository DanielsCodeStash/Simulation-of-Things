package util.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.ApiError;
import util.ErrorType;

import java.io.IOException;

public class JsonData
{
    private JsonNode jsonNode;

    public JsonData(String jsonString)
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            jsonNode = mapper.readTree(jsonString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new ApiError(ErrorType.BAD_REQUEST);
        }
    }

    public JsonNode getRootNode(String name, Json optionLevel) throws ApiError
    {
        JsonNode node = jsonNode.get(name);
        requireTest(node, optionLevel);
        return node;
    }

    public String getRootString(String name, Json optionLevel) throws ApiError
    {
        JsonNode node = jsonNode.get(name);
        requireTest(node, optionLevel);
        return node.asText();
    }

    private void requireTest(JsonNode node, Json optionLevel) throws ApiError
    {
        if (node == null && optionLevel == Json.REQUIRED)
        {
            throw new ApiError(ErrorType.BAD_REQUEST, "Failed to parse json");
        }
    }


}
