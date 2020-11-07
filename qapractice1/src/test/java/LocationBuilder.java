public class LocationBuilder {
	
	public LocationBuilder(){
		locationbuilt = new LocationBuilt();
	}
	
	LocationBuilt locationbuilt;

	public LocationBuilder withState(StateData state)
	{
		locationbuilt.state = state;
		return this;
	}
	
	public LocationBuilder withCity(CityData city)
	{
		locationbuilt.city = city;
		return this;
	}
	
	public LocationBuilder withCounty(CountyData county)
	{
		locationbuilt.county = county;
		return this;
	}
	
	public LocationBuilt build(){
		return locationbuilt;
	}
	
}
