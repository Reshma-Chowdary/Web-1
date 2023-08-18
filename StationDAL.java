package simpleMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import org.json.JSONArray;
import org.json.JSONObject;

public class StationDAL {
	public JSONArray getStations(){
		JSONArray ja=new JSONArray();
		try {
			Class.forName("org.postgresql.Driver");
			Connection c=DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("select trn_start,trn_end from MadhuStations");
            while(rs.next()) {
            	JSONObject jo=new JSONObject();
            	jo.put("from",rs.getString(1));
            	jo.put("to",rs.getString(2));
            	ja.put(jo);
            }       
		
		}
		catch(Exception e) {
			
		}
		return ja;
	}
}
