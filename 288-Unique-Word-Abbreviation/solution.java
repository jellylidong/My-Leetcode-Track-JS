public class ValidWordAbbr {

    //one tip to optimize it
    //instead of storing all words with the same abbreviation to a set
    //we can use a hashmap<abbr, original_string>
    //once we know the abbr is not unique while adding abbr from the dictionary
    //we do: map.put(abbr, "")
    //then when checking isUnique
    //if map does not contains the abbr, it's unique
    //or if map contains the abbr but map.get(abbr) is not equal to current word, it's not unique
    HashMap<String, HashSet<String>> map; //key:abbr, value:set of strings with the key abbr
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String s: dictionary){
            if(s.length() > 2){
                
                int len = s.length();
                String abbr = "" + s.charAt(0) + (len-2) + s.charAt(len-1);
                if(!map.containsKey(abbr)){
                    HashSet<String> set = new HashSet<>();
                    map.put(abbr, set);
                }
                map.get(abbr).add(s);
            }
        }
    }

    public boolean isUnique(String word) {
        if(word.length() <= 2)  return true;
        else{
            int len = word.length();
            String cur = "" + word.charAt(0) + (len-2) + word.charAt(len-1);
            return !map.containsKey(cur) || (map.get(cur).size() == 1 && map.get(cur).contains(word));
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");