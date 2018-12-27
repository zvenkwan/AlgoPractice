/**
 * First, we need to recognize that a "generic" deck of cards can mean many things.
Generic could mean a standard deck of cards that can play a poker-like game, or it
could even stretch to Uno or Baseball cards. It is important to ask your interviewer what
she means by generic.
Let's assume that your interviewer clarifies that the deck is a standard 52-card set, like
you might see used in a blackjack or poker game. If so, the design might look like this:

 */
/**
 * @author jguan
 *1. add_score: 输入player_id和score，要你update当前的scoreboard
2. top：输入max然后让你return前max个player的avg scores
3. reset：把这个player的score为0.
之前没准备OOD但看过一点，拿到这个题慌了，最后用了个SortedMap 发现是interface，应该是TreeMap =_=从来没用过hhh
 */
package oopdesign.leaderboard;