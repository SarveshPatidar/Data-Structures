package com.datastructure.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  	Problem Statement - Design a Leaderboard class, which has 3 functions:

	addScore(playerId, score): Update the leaderboard by adding score to the given player's score.If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
	
	top(K): Return the score sum of the top K players.
	
	reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
	
	Initially, the leaderboard is empty.
	
 */


public class LeaderBoard {
	
	 Map<Integer, Integer> map;

	    public LeaderBoard() {
	        map = new HashMap<Integer, Integer>();
	    }
	    
	    public void addScore(int playerId, int score) {
	        if(!map.containsKey(playerId)) {
				map.put(playerId,score);
			}else {
				int prevScore = map.get(playerId);
				map.put(playerId, prevScore+score);
			}
	    }
	    
	    public int top(int K) {
	        int result =0;
			List<Integer> list = new ArrayList<>(map.keySet());
			Collections.sort(list, (a,b) -> {
				return map.get(b)-map.get(a);
				
			});
			List<Integer> subList = list.subList(0, K);
			for(int i=0; i<K;i++) {
				result += map.get(subList.get(i));
			}
			return result;
	    }
	    
	    public void reset(int playerId) {
	        map.put(playerId, 0);
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeaderBoard leaderboard = new LeaderBoard ();
		leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
		leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
		leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
		leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
		leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
		leaderboard.top(1);           // returns 73;
		leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
		leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
		leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
		leaderboard.top(3);           // returns 141 = 51 + 51 + 39;

	}

}
