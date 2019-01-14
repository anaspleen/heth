/**
 * 
 */
package eu.heth.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Utils class to manage JSON
 * 
 * @author tcaiati
 *
 */
public final class JSONUtils {

	/** le logger */
	private static final Logger LOG = LoggerFactory.getLogger(JSONUtils.class);

	/**
	 * Default const
	 */
	private JSONUtils() {
		// RAF
	}

	/**
	 * Transform a file to a JSON Object
	 * 
	 * @param pathFile
	 *            the path of file
	 * @return the JSON
	 * @throws IOException
	 *             exception
	 */
	public static JsonObject createJSONFromFile(String pathFile) throws IOException {
		return createJSONFromString(FileUtils.readFileToString(new File(pathFile), "UTF-8"));
	}

	/**
	 * Transform a string to a JSON Object
	 * 
	 * @param string
	 *            the string
	 * @return the JSON
	 * @throws IOException
	 *             exception
	 */
	public static JsonObject createJSONFromString(String string) {
		JsonParser parser = new JsonParser();
		return parser.parse(string).getAsJsonObject();
	}

	/**
	 * Transform a Document to a JSON Object
	 * 
	 * @param document
	 *            the document
	 * @return the json
	 */
	public static JsonObject getJSONFromDocument(Document document) {
		JsonObject res = new JsonObject();
		if (document != null) {
			String json = com.mongodb.util.JSON.serialize(document);
			res = JSONUtils.createJSONFromString(json);
		}
		return res;
	}

	/**
	 * Get the radius to send to MongoDB from radius in meter
	 * 
	 * @param radius
	 *            the radius in meter
	 * @return the radius for Mongos's request
	 */
	public static final double getRadiusFromMeterForMongoDB(double radius) {

		// https://docs.mongodb.com/manual/tutorial/calculate-distances-using-spherical-geometry-with-2d-geospatial-indexes/
		// The equatorial radius of the Earth is approximately 3,963.2 miles or
		// 6,378.1 kilometers.

		// example :
		// The following query would return documents from the places collection
		// within the circle described by the center [ -74, 40.74 ] with a
		// radius of 100 miles:
		// db.places.find( { loc: { $geoWithin: { $centerSphere: [ [ -74, 40.74
		// ] ,
		// 100 / 3963.2 ] } } } )

		// double res = radius / (6378.1 * 1000);
		double res = radius / 6378.1;
		System.out.println(res + " -----------");

		return res;
	}
}
