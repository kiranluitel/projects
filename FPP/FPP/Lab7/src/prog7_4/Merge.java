package prog7_4;

/**
 * Merges two strings of characters
 * that are both in sorted order --
 * ordering of characters is based
 * on their unicode values. We assume
 * characters are in the set a-z, A-Z
 */
public class Merge {
	StringBuilder ret = new StringBuilder();
	String merge(String s, String t) {	
		if(s.isEmpty() && t.isEmpty()) return ret.toString();
		if(s.isEmpty()) {
			ret.append(t);
			return ret.toString();
		}
		if(t.isEmpty()) {
			ret.append(s);
			return ret.toString();
		}
		if(s.charAt(0) <= t.charAt(0)) {
			ret.append(s.charAt(0));
			return merge(s.substring(1), t);
		} else {
			ret.append(t.charAt(0));
			return merge(s, t.substring(1));
		}
		
	}
	
	

}
