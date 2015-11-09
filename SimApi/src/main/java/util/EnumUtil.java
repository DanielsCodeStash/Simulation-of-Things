package util;

public class EnumUtil
{

    // runs in O(n) where n is number of enums, but this solution is cleaner then the alternative (static map for each enum)
    public static <T extends Enum<?> & SerializableEnum> T fromSerializedForm(String strValue, Class<T> enumClass)
    {
        for (T enumType : enumClass.getEnumConstants())
        {
            if (enumType.toSerializedForm().equals(strValue.trim()))
            {
                return enumType;
            }
        }

        System.err.println("Could not deserialize from " + strValue + ", please check enum serialization.");
        new Throwable().printStackTrace();
        System.exit(-1);
        return null;
    }
}
