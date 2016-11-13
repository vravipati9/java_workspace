package chapter6;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*        
 */

class Herb {
	public enum Type {ANNUAL, PERENNIAL, BIENNIAL};
	
	private final String name;
	private final Type type;
	
	public Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public String toString() {
		return name;
	}
	
	public static void main(String a[]) {
		Herb[] garden = {
	            new Herb("Basil",    Type.ANNUAL),
	            new Herb("Carroway", Type.BIENNIAL),
	            new Herb("Dill",     Type.ANNUAL),
	            new Herb("Lavendar", Type.PERENNIAL),
	            new Herb("Parsley",  Type.BIENNIAL),
	            new Herb("Rosemary", Type.PERENNIAL)
	        };
		/*
		 * To do this, you construct three sets, one for each type, and iterate through the garden,
			placing each herb in the appropriate set.
		 */
		
		Set<Herb> annualHerbset = new HashSet<Herb>();
		Set<Herb> biennialHerbset = new HashSet<Herb>();
		Set<Herb> perennialHerbset = new HashSet<Herb>();
		for (Herb herb : garden) {
			System.out.println(herb.type);
			switch (herb.type) {
			case ANNUAL:
				annualHerbset.add(herb);
				break;
			case BIENNIAL:
				biennialHerbset.add(herb);
				break;
			case PERENNIAL:
				perennialHerbset.add(herb);
				break;
			default:
				break;
			}
		}
		
		System.out.println(annualHerbset);
		System.out.println(biennialHerbset);
		System.out.println(perennialHerbset);
		
		System.out.println("---------------------Second Approach----------------------");
		/*
		 * Some programmers would do this by
			putting the sets into an array indexed by the type’s ordinal:
		 */
		Set<Herb>[] herbsByType = (Set<Herb>[])new Set[Herb.Type.values().length];
		
		for (int i=0; i<herbsByType.length; i++) 
			herbsByType[i] = new HashSet<Herb>();
		
		for (Herb herb : garden) {
			int index = herb.type.ordinal();
			herbsByType[index].add(herb);
		}
		
		// Print the results
		for (int i = 0; i < herbsByType.length; i++) {
			System.out.printf("%s: %s%n",
					Herb.Type.values()[i], herbsByType[i]);
		}
		
		System.out.println("---------------------Third Approach & Best Approach------------------");
		// Using an EnumMap to associate data with an enum
		Map<Herb.Type, Set<Herb>> herbs = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
		
		for (Herb.Type types : Herb.Type.values()) {
			herbs.put(types, new HashSet<Herb>());
		}
		
		for (Herb herb : garden) {
			herbs.get(herb.type).add(herb);
		}
		
		System.out.println(herbs);
	}
}




