package world.draw.fill;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import util.SerializableEnum;

public enum FillType implements SerializableEnum
{
    SOLID, GRADIENT;

    @JsonCreator
    public static Fill fromSerializedForm(String string)
    {
        return null;
    }

    @JsonValue
    public String toSerializedForm()
    {
        switch (this)
        {
            case SOLID:
                return "solid";
            case GRADIENT:
                return "gradient";
            default:
                System.err.println("Cant serializa filltype");
                return null;
        }
    }
}
