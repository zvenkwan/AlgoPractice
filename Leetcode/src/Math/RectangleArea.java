package Math;
/**
 * 223. Rectangle Area
 * @author zg55
 *Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sx = Math.max(A,E);
        int sy = Math.max(B,F);
        int ex = Math.min(C,G);
        int ey = Math.min(D,H);
        int crossarea = ex>sx&&ey>sy?(ex-sx)*(ey-sy):0;
        return (C-A)*(D-B)+(G-E)*(H-F)-crossarea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
