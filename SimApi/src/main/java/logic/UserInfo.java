package logic;

public class UserInfo
{
    private String property;

    private String apartment;
    private String apartmentId;

    private Long moveInDate;
    private boolean specialCombinedElectricity = false;

    private String elSensorId;
    private String waterSensorId;
    private String tempSensorId;

    public String getApartment()
    {
        return apartment;
    }

    public UserInfo setApartment(String apartment)
    {
        this.apartment = apartment;
        return this;
    }

    public String getProperty()
    {
        return property;
    }

    public UserInfo setProperty(String property)
    {
        this.property = property;
        return this;
    }

    public String getElSensorId()
    {
        return elSensorId;
    }

    public UserInfo setElSensorId(String elSensorId)
    {
        this.elSensorId = elSensorId;
        return this;
    }

    public Long getMoveInDate()
    {
        return moveInDate;
    }

    public UserInfo setMoveInDate(Long moveInDate)
    {
        this.moveInDate = moveInDate;
        return this;
    }

    public boolean isSpecialCombinedElectricity()
    {
        return specialCombinedElectricity;
    }

    public UserInfo setSpecialCombinedElectricity(boolean specialCombinedElectricity)
    {
        this.specialCombinedElectricity = specialCombinedElectricity;
        return this;
    }

    public String getTempSensorId()
    {
        return tempSensorId;
    }

    public UserInfo setTempSensorId(String tempSensorId)
    {
        this.tempSensorId = tempSensorId;
        return this;
    }

    public String getWaterSensorId()
    {
        return waterSensorId;
    }

    public UserInfo setWaterSensorId(String waterSensorId)
    {
        this.waterSensorId = waterSensorId;
        return this;
    }

    public String getApartmentId()
    {
        return apartmentId;
    }

    public UserInfo setApartmentId(String apartmentId)
    {
        this.apartmentId = apartmentId;
        return this;
    }

    @Override
    public String toString()
    {
        return "UserInfo{" +
               "apartment='" + apartment + '\'' +
               ", property='" + property + '\'' +
               ", apartmentId='" + apartmentId + '\'' +
               ", moveInDate=" + moveInDate +
               ", specialCombinedElectricity=" + specialCombinedElectricity +
               ", elSensorId='" + elSensorId + '\'' +
               ", waterSensorId='" + waterSensorId + '\'' +
               ", tempSensorId='" + tempSensorId + '\'' +
               '}';
    }
}
