import net.webservicex.iplocationfinder.GeoIP;
import net.webservicex.iplocationfinder.GeoIPService;
import net.webservicex.iplocationfinder.GeoIPServiceSoap;


public class IPLocationFinder {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("U need to pass in 1 IP Address");
		} else {
			String ipAddress = args[0];
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap geoIpServiceSoap = ipService.getGeoIPServiceSoap();
			GeoIP geoIp = geoIpServiceSoap.getGeoIP(ipAddress);
			System.out.println("County which hosted IP Address::::"+geoIp.getCountryName());
		}
	}
}
