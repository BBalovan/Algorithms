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
		Integer[] testArray = { 14, 57, 84, 22, 22, 1, 3, 44, 77, 98, 10, 13,36,72,128,888,666, 43 };
		String[] stringArray1 = { "alma", "k�rte", "anan�sz","barack", "mang�" };
		String[] stringArray2 = {"alma","anan�sz","eper","mandarin","narancs" };
		String[] stringArray3 = {"anan�sz","alma","eper","mandarin","mang�"};
		String normalString = "megszents�gtelen�thetetlens�gesked�seitek�rt";
		
		showCommonFruit(Arrays.asList(stringArray1), Arrays.asList(stringArray2), Arrays.asList(stringArray3));
		//asdasdasdasd
		hattalossz(Arrays.asList(testArray));
		
		reverseString(normalString);

		customSort(Arrays.asList(testArray));

		getMaxValue(0, Arrays.asList(testArray));

		primSzam(81);
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
	
	public static String reverseString(String normalString) {
		
		int lenght = normalString.length();
		String reverse = "";
		
		for (int i = lenght - 1; i >= 0; i--)
			reverse = reverse + normalString.charAt(i);
		
		return reverse;
	}
	
	public static List<Integer> hattalossz(List<Integer>unsortedList) {
		List<Integer> localUnsortedList = new ArrayList<Integer>(unsortedList);
		List<Integer> sixList = new ArrayList<Integer>();
		
		for (int item : localUnsortedList) {
			if (item%2==0 && item%3 == 0)
				sixList.add(item);
		}
		return sixList;
		
	}
	public static List<String> showCommonFruit(List<String>fruitList1, List<String>fruitList2, List<String>fruitList3) {
		List<String>localFruitList1 = new ArrayList<String>(fruitList1);
		List<String>localFruitList2 = new ArrayList<String>(fruitList2);
		List<String>localFruitList3 = new ArrayList<String>(fruitList3);
		List<String>finalList = new ArrayList<String>();
		
		for (String item : localFruitList1){
			for (String item2 : localFruitList2) {
				for (String item3 : localFruitList3) {
					if (item.equals(item3) && item.equals(item2)) {
						finalList.add(item);
					}
				}
			}
		}

		return finalList;
	}
}
