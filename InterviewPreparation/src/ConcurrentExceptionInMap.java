import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConcurrentExceptionInMap {
	public static void main(String[] args) throws Exception {
		try {
			Map<String, Integer> scores = new HashMap<>();
			scores.put("user1", 1);
			scores.put("user2", 2);
			scores.put("user3", 3);
			scores.put("user4", 4);
			scores.put("user5", 5);
			Iterator<String> usersIterator = scores.keySet().iterator();
			
			//iterator fail fast while doing modifications in the map 
			while (usersIterator.hasNext()) {
				String sKey = (String) usersIterator.next();
				scores.put("user9", 9);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
