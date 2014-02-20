import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author win7
 * 
 */
public class Algorithm {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] testArray = { 14, 57, 84, 22, 22, 1, 3, 44, 77, 98, 10, 13,
				43 };
		// call here

		List<Integer> testOrder = customSort(Arrays.asList(testArray));

		int met = getMaxValue(-11, Arrays.asList(testArray));

		boolean ertek = primSzam(81);
		Arrays.asList(testArray);

		getEvenNumbers(Arrays.asList(testArray));
	}

	public static boolean primSzam(int primSzame) {

		for (int i = 2; i < primSzame; i++) {
			int result = primSzame % i;
			if (result == 0)
				return false;
		}
		return true;
	}

	private static ArrayList<Integer> getEvenNumbers(List<Integer> testArray) {

		ArrayList<Integer> evenNums = new ArrayList<Integer>();
		for (int item : testArray) {
			if (item % 2 == 0)
				evenNums.add(item);
		}
		return evenNums;
	}

	public static int getMaxValue(int current, List<Integer> testArray) {

		int localMax = current;
		for (int item : testArray) {
			if (current < item)
				localMax = getMaxValue(item, testArray);
		}
		return localMax;

	}

	public static List<Integer> customSort(List<Integer> unsortedList) {
		List<Integer> localUnsortedList = new ArrayList<Integer>(unsortedList);
		List<Integer> orderedList = new ArrayList<Integer>();
		while (localUnsortedList.size() > 0) {
			int currentMax = getMaxValue(0, localUnsortedList);
			orderedList.add(currentMax);
			localUnsortedList.remove(localUnsortedList.indexOf((currentMax)));
		}
		return orderedList;
	}

}
