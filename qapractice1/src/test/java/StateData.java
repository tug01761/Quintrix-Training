public class StateData extends ValueObjectBase {
	
	String abbreviation;

	StateData(String name, String abbreviation){
		super(name);
		this.abbreviation = abbreviation;
		
	}
}
