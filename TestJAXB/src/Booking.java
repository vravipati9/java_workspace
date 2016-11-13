import java.lang.reflect.Field;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "booking")
@XmlAccessorType(XmlAccessType.FIELD)
class Booking {

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "contact")
	private int contact;

	@XmlElement(name = "startDate")
	private Date startDate;

	@XmlElement(name = "endDate")
	private Date endDate;

	@XmlElement(name = "address")
	private String address;

	public Booking() {
	}

	public Booking(String name, int contact, Date startDate, Date endDate,
			String address) {
		this.name = name;
		this.contact = contact;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Booking{" + "name=" + name + ", contact=" + contact
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", address=" + address + '}';
	}

}
