package util;


public class ApiUtil
{
    public static void assertNotNull(Object... arguments) throws ApiError
    {
        for (Object o : arguments)
        {
            if (o == null)
            {
                System.err.println("Missing argument " + ErrorType.BAD_REQUEST);
                throw new ApiError(ErrorType.BAD_REQUEST, "Missing query param");
            }
        }
    }

    public static boolean existsNotNull(Object... arguments)
    {
        for (Object o : arguments)
        {
            if (o != null)
            {
                return true;
            }
        }

        return false;
    }

}
