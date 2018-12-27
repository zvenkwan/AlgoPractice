package oopdesign.leaderboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Board {

	private static Board instance;
	
	private static TreeSet<Player> set;
	private static TreeMap<Integer, Player> map;
	
	private Board() {
		set = new TreeSet<Player>(
				new Comparator<Player>() {
					public int compare(Player p0, Player p1) {
						if(p0.getAverage() == p1.getAverage()) {
							return p0.getId() - p1.getId();
						} else {
							return Double.compare(p1.getAverage(), p0.getAverage());
						}
					}
				}
				);
		map = new TreeMap<Integer, Player>();
	}
	
	public static Board getInstance() {
		synchronized(Board.class) {
			if(instance == null) {
				instance = new Board();
			}
		}
		return instance;
	}
	
	public void addScore(int pid, int score) {
		if(map.containsKey(pid)) {
			Player p = map.get(pid);
			map.remove(pid);
			set.remove(p);
			p = p.addScore(score);
			map.put(pid, p);
			set.add(p);
		}
		else {
			Player p = new Player(pid, score);
			map.put(pid, p);
			set.add(p);
		}
	}
	
	public List<Player> max(int k) {
		List<Player> res = new ArrayList<>();
		Iterator<Player> iter = set.iterator();
		while(iter.hasNext()) {
			if(res.size() == k) {
				break;
			}
			res.add(iter.next());
		}
		return res;
	}
	
	public void reset(int pid) {
		if(map.containsKey(pid)) {
			Player p = map.remove(pid);
			set.remove(p);
			p = new Player(pid, 0);
			set.add(p);
			map.put(pid, p);
		}
	}

}
