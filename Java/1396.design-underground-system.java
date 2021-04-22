/*
 * @lc app=leetcode id=1396 lang=java
 *
 * [1396] Design Underground System
 */

// @lc code=start
class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> inStation;
    Map<String, Pair<Double, Integer>> time;
    public UndergroundSystem() {
        inStation = new HashMap<>();
        time = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        inStation.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> p = inStation.get(id);
        inStation.remove(id);
        String key = p.getKey() + "-" + stationName;
        double prev = (double)t - p.getValue();
        Pair<Double, Integer> state = time.getOrDefault(key, new Pair<>(0.0, 0));
        time.put(key, new Pair<>(prev + state.getKey(), state.getValue() + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Integer> p = time.get(startStation + "-" + endStation);
        
        return p.getKey() / p.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
// @lc code=end

