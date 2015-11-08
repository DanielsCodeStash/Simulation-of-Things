package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stopwatch
{
    private final String name;

    private long start;
    private long end = -1;

    private List<SubLap> subLaps = new ArrayList<>();
    private SubLap lastSubLap = null;

    public static void main(String[] args) throws InterruptedException
    {
        Stopwatch stopwatch = new Stopwatch("test watch");

        stopwatch.startSubLap("lap test 1");
        Thread.sleep(3424);
        stopwatch.startSubLap("lap test 2");
        Thread.sleep(3424);

        stopwatch.printReport();

    }

    public Stopwatch(String name)
    {
        this.name = name;
        start = getCurrentTime();
    }

    public Stopwatch()
    {
        this.name = "unnamed";
        start = getCurrentTime();
    }

    public void startSubLap(String name)
    {
        if(lastSubLap != null)
        {
            endLastSubLap();
        }

        lastSubLap = new SubLap(name, getCurrentTime());
        subLaps.add(lastSubLap);
    }

    public void endLastSubLap()
    {
        lastSubLap.end = getCurrentTime();
        lastSubLap = null;
    }

    public void end()
    {
        end = getCurrentTime();
    }

    public String getReport()
    {
        if(end == -1)
        {
            end();
        }

        if(lastSubLap != null)
        {
            endLastSubLap();
        }

        String out = "_stopwatch " + name + "_" + "\n";
        out += " total: " + getTimeDiff(start, end) + "\n";
        for(SubLap lap : subLaps)
        {
            out += " " + lap.name + ": " + getTimeDiff(lap.start, lap.end) + "\n";
        }
        return out;
    }

    public void printReport()
    {
        System.out.println(getReport());
    }

    private class SubLap
    {
        public String name;
        public long start;
        public long end;

        public SubLap(String name, long start)
        {
            this.name = name;
            this.start = start;
        }
    }

    private long getCurrentTime()
    {
        return new Date().getTime();
    }

    private static String getTimeDiff(long from, long to)
    {
        long ms = to - from;

        int millis  = (int) ms % 1000;
        int seconds = (int) (ms / 1000) % 60 ;
        int minutes = (int) ((ms / (1000*60)) % 60);
        int hours   = (int) ((ms / (1000*60*60)) % 24);

        boolean largerUnitFound = false;
        String out = "";

        if(hours != 0)
        {
            largerUnitFound = true;
            out += hours + "h ";
        }

        if(largerUnitFound || minutes != 0)
        {
            if(largerUnitFound)
                out += addPadding(minutes, 2) + "m ";
            else
                out += minutes + "m ";

            largerUnitFound = true;
        }

        if(largerUnitFound || seconds != 0)
        {
            if(largerUnitFound)
                out += addPadding(seconds, 2) + "s ";
            else
                out += seconds + "s ";

            largerUnitFound = true;
        }

        if(largerUnitFound)
            out += addPadding(millis, 3) + "ms";
        else
            out += millis + "ms";

        return out;
    }

    private static String addPadding(int value, int num)
    {
        String out = "";

        for(int i=1; i < num; i++)
        {
            int fence = (int) Math.pow(10, i);

            if(value < fence)
            {
                out += "0";
            }
        }

        return out + value;
    }

}
