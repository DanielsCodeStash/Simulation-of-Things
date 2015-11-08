package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Util
{
    public static <E> List<E> collectionToList(Collection<E> coll)
    {
        if (coll instanceof List)
        {
            return (List) coll;
        }
        else
        {
            return new ArrayList(coll);
        }
    }
}
