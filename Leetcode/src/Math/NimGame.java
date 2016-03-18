package Math;
/**
 * 292. Nim Game
 * @author zg55
 *You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
Hint:

If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be the winner?
 */
public class NimGame {
	public boolean canWinNim(int n) {
//		if there are 4 stones, i will lose
//		if there are 4+(1 or 2 or 3) stones, i can make the other player facing 4 stones that he loses
//		however if there are another 4 stones more than 4-stone situation, I will be losing again because there is no way i make him 4-stone
//		similiar situation will occur if there are 8, 12, 16... stones
//		so we only need to check the number is divisible by 4
        return n%4!=0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
