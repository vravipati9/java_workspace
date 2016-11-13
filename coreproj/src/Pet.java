public class Pet {
	private int petId;
	private String petType;

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}
	public Pet(int petId, String petType) {
		this.petId = petId;
		this.petType = petType;
	}
}
