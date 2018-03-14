package Part2;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Part2")
public class Part2 {

	@POST
	@Path("Abc")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public String abc(Coordinate temp) {
		double lat1, lat2, lng1, lng2;
		lat1 = Double.parseDouble(temp.getLat1());
		lat2 = Double.parseDouble(temp.getLat2());
		lng1 = Double.parseDouble(temp.getLng1());
		lng2 = Double.parseDouble(temp.getLng2());
		String a = getDistance(lat1, lat2, lng1, lng2);
		return a;
	}

	private String getDistance(double lat1, double lat2, double lng1, double lng2) {
		double R = 6371.0;
		double x1 = Math.toRadians(lat1);
		double x2 = Math.toRadians(lat2);
		double y1 = Math.toRadians(lat2 - lat1);
		double y2 = Math.toRadians(lng2 - lng1);
		double a = Math.sin(y1 / 2) * Math.sin(y1 / 2)
				+ Math.cos(x1) * Math.cos(x2) * Math.sin(y2 / 2) * Math.sin(y2 / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double result = R * c;

		return Double.toString(result) + " km";
	}

}
