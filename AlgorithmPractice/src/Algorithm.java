import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

		try {
			PrintStream out = new PrintStream(System.out, true, "UTF-8");
			System.setOut(out);
		} catch (Exception e) {
		}

		Integer[] testArray = { 14, 57, 84, 22, 22, 1, 3, 44, 77, 98, 10, 13,
				36, 72, 128, 888, 666, 43 };
		String[] stringArray1 = { "alma", "körte", "ananász", "barack", "mangó" };
		String[] stringArray2 = { "alma", "ananász", "eper", "mandarin",
				"narancs" };
		String[] stringArray3 = { "ananász", "vadalma", "eper", "mandarin",
				"mangó" };
		String normalString = "megszentségteleníthetetlenségeskedéseitekért";
		String pal = "qqqqqqqqq	saw";

		List<String> commons = showCommonFruit(Arrays.asList(stringArray1),
				Arrays.asList(stringArray2), Arrays.asList(stringArray3));
		hattalossz(Arrays.asList(testArray));

		reverseString(normalString);

		customSort(Arrays.asList(testArray));

		getMaxValue(0, Arrays.asList(testArray));

		primSzam(81);
		Arrays.asList(testArray);

		getEvenNumbers(Arrays.asList(testArray));

		getAnswer(0, 0, 0);
		
		String zsivany = palindrome(pal);
		System.out.println(zsivany);
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

	public static List<Integer> hattalossz(List<Integer> unsortedList) {
		List<Integer> localUnsortedList = new ArrayList<Integer>(unsortedList);
		List<Integer> sixList = new ArrayList<Integer>();

		for (int item : localUnsortedList) {
			if (item % 2 == 0 && item % 3 == 0)
				sixList.add(item);
		}
		return sixList;

	}

	public static List<String> showCommonFruit(List<String> fruitList1,
			List<String> fruitList2, List<String> fruitList3) {
		List<String> localFruitList1 = new ArrayList<String>(fruitList1);
		List<String> localFruitList2 = new ArrayList<String>(fruitList2);
		List<String> localFruitList3 = new ArrayList<String>(fruitList3);
		List<String> finalList = new ArrayList<String>();

		for (String item : localFruitList1) {
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
	
	public static int getAnswer(int dollar, int hanydollar, int ingyen) {
		int z = 0;
		int n = dollar;			//hány dollár van a zsebben
		int c = hanydollar;		//mennyibe kerül a csoki
		int m = ingyen;			//hány csoki után van egy csoki ingyen
		int answer = 0;
		
		while (n >= c) {
			n = n-c;
			answer++;
			z++;
			if (z == m) {
				answer++;
				z = 1;
			}
		}
		
		return answer;
		
	}

	public static String palindrome(String palstring) {
		String answer = "NO";
		List<String> charList = new ArrayList<String>();
		char[] charArray = palstring.toCharArray();
		for (char c : charArray) {
			charList.add(String.valueOf(c));
		}
		Collections.sort(charList);
		long uaChar = 0; // hányadszorra fordul elő a char
		String y = ""; // azon karakter értéke, mely óta nem történt karakter
		// értékében változás
		long paratlanok = 0; // méri, hányszor fordult elő páratlan számú
		// karakter
		for (int i = 1; i < charList.size(); i++) {
			y = charList.get(i);
			String prev = charList.get(i - 1);
			if (y.equals(prev))
				uaChar++;
			else if (i != 0) {
				if (uaChar % 2 != 0) {
					paratlanok++;
					uaChar = 1;
				} else
					uaChar = 1;
			}
		}
		if (paratlanok > 1)
			answer = "NO";
		else
			answer = "YES";

		return answer;
	}
}
