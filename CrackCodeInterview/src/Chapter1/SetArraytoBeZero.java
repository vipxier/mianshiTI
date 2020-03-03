package Chapter1;
import utils.ArrayUtils;

public class SetArraytoBeZero {

	public static void setZero(int[][] array, int index_x, int index_y) {
		if (array == null || array.length == 0 || array.length - 1 < index_x) {
			return;
		}

		for (int i = 0; i < array[index_x].length; i++) {
			array[index_x][i] = 0;
		}

		for (int i = 0; i < array.length; i++) {
			array[i][index_y] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		
		ArrayUtils.printDoubleDimentionArray(array);
		setZero(array , 5, 7);
		ArrayUtils.printDoubleDimentionArray(array);
	}
}
