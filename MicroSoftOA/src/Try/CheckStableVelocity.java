package Try;

public class CheckStableVelocity {
	public static int solution(int[] array) {
		if (array.length < 3) {
			return 0;
		}

		int result = 0;
		for (int i = 0; i < array.length - 2; i++) {
			if (array[i + 1] - array[i] == array[i + 2] - array[i + 1]) {
				result++;

				for (int j = i + 3; j < array.length; j++) {
					if (array[j] - array[j - 1] == array[i + 2]-array[i + 1]) {
						result++;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] velocities = { -1, 1, 3, 3, 3, 2, 3, 2, 1, 0, -1, -2 };
		System.out.println(solution(velocities));
	}
}
