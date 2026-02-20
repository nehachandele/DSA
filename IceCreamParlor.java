public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < arr.size(); i++) {
        
        int cost = arr.get(i);
        int complement = m - cost;
        
        if (map.containsKey(complement)) {
            // return 1-based indices
            return Arrays.asList(map.get(complement) + 1, i + 1);
        }
        
        map.put(cost, i);
    }
    
    return new ArrayList<>(); // no pair found
} public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < arr.size(); i++) {
        
        int cost = arr.get(i);
        int complement = m - cost;
        
        if (map.containsKey(complement)) {
            // return 1-based indices
            return Arrays.asList(map.get(complement) + 1, i + 1);
        }
        
        map.put(cost, i);
    }
    return new ArrayList<>(); // no pair found
}
