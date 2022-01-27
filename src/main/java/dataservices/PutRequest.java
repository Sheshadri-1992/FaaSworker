package dataservices;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import miscellaneous.Constants;
import thriftservices.Argument;
import thriftservices.Location;

public class PutRequest {
	
	private JSONObject myJSONObject;
	private String filename;
	
	public PutRequest(){
		myJSONObject = new JSONObject();
	}

	public void prepareJSONObject(String event_function_id, List<Argument> parameterArray) {
		
		myJSONObject = new JSONObject();
		filename = event_function_id;
		
		try {
			for(Argument arg : parameterArray) {
				String paramName = arg.getArgName();
				byte[] paramValue = arg.getArgPayload();
				
				myJSONObject.put(paramName, paramValue);
			}	
		}catch(JSONException e) {
			e.printStackTrace();
		}

	}

	public void writeJSONLocally() {
		try {
			FileWriter myFileWriter = new FileWriter(Constants.EDGE_PARAMS_DIRECTORY+filename);
			myFileWriter.write(myJSONObject.toString());
			myFileWriter.flush();
			myFileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeJSONRemotely(Location deviceLocation) {
		/** This function would never be called **/
	}
}

/** Code on how to convert bytes to string and back 
 * https://stackoverflow.com/questions/20706783/put-byte-array-to-json-and-vice-versa
 * **/
//byte[] bytes = getByteArr();
//String base64String = Base64.encodeBase64String(bytes);
//byte[] backToBytes = Base64.decodeBase64(base64String);