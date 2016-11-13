class DVDInfo implements Comparable<DVDInfo> {
	String title;
	String genre;
	String leadActor;
	DVDInfo(String t, String g, String a) {
		this.title = t; this.genre = g; this.leadActor = a;
	}
	@Override
	public String toString() {
		return this.title + " " + this.genre + " " + this.leadActor + "\n";
	}
//	public int compareTo(DVDInfo d) {
//		return this.title.compareTo(d.getTitle());
//	}
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLeadActor() {
		return leadActor;
	}
	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int compareTo(DVDInfo d) {
		return title.compareTo(d.getTitle()); 
	}
	
}