/**
 * 
 */
package eu.heth.dao.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.bson.Document;

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
	private static final Logger LOG = Logger.getLogger(JSONUtils.class);

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
}
