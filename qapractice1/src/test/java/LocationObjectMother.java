public class LocationObjectMother {
	
	public static LocationBuilt newyorkcity()
	{
		  StateData stateDestination = StateDataProvider.newyork;
		  CityData cityDestination = CityDataProvider.newyorkcity;
		  LocationBuilt location = new LocationBuilder()
				  					   .withState(stateDestination)
				  					   .withCity(cityDestination)
				  					   .build();
		  
		  return location;
	}
	
	public static LocationBuilt losangeles()
	{
		  return new LocationBuilder()
				  	.withState(StateDataProvider.california)
				  	.withCity(CityDataProvider.losangeles)
				  	.withCounty(CountyDataProvider.losangeles)
				  	.build();
		  
	}

}
