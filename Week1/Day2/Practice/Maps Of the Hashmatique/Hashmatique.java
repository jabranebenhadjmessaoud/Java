import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String,String> trackList = new HashMap<>();
        trackList.put("track1", "Hello, Its Me ") ;
        trackList.put("track2", "Hello, Its farouk ") ;
        trackList.put("track3", "Hello, Its mokhtar ") ;
        trackList.put("track4", "Hello, Its helmi ") ;
        System.out.println(trackList.get("track2"));
        Set<String> keys = trackList.keySet();
        for(String key:keys){
            System.out.format(key +":"+ trackList.get(key)+"\n"); 
         }
    }
    
}
