import java.util.HashMap;
import java.util.Set;

public class Hashmatique{
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Mother","Mother lyrics");
        trackList.put("Father","Father lyrics");
        trackList.put("Brother","Brother lyrics");
        trackList.put("Sister", "Sister lyrics");
        trackList.remove("Sister");
        
        Set<String> keys = trackList.keySet();
        for(String key: keys) {
            System.out.println(key + ":" + trackList.get(key));
        }
    }
}