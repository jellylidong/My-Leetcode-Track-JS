public class Twitter {

    /** Initialize your data structure here. */
    
    HashMap<Integer, HashSet<Integer>> followList; // key:follower, value: followees
    HashMap<Integer, List<Twit>> ts; //key: user, value: twitts
    int timer;
    
    public Twitter() {
        followList = new HashMap<>();
        ts = new HashMap<>();
        timer = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        checkUser(userId);
        ts.get(userId).add(new Twit(tweetId, timer++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        checkUser(userId);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Twit> buf = new LinkedList<>();
        for(int user: followList.get(userId)){
            List<Twit> curTs = ts.get(user);
            for(int i = 0; i < 10 && curTs.size()-1-i >= 0; i++){
                // pq.offer(curTs.get(curTs.size()-1-i));
                buf.add(curTs.get(curTs.size()-1-i));
            }
        }
        Collections.sort(buf, new Comparator<Twit>(){
        	@Override
        	public int compare(Twit t1, Twit t2){
        		return -(t1.time - t2.time);
        	}
        });
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 10 && i < buf.size(); i++)
        	ans.add(buf.get(i).id);
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);
        followList.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);
        if(followerId != followeeId)
            followList.get(followerId).remove(followeeId);
    }
    
    private void checkUser(int userId){
        if(!followList.containsKey(userId)){
            followList.put(userId, new HashSet<Integer>());
            followList.get(userId).add(userId);
            ts.put(userId, new ArrayList<Twit>());
        }
    }
    
    private class Twit{
        int id;
        int time;
        Twit(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */