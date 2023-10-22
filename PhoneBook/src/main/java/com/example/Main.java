import java.sql.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Comparator;

class PhoneBook {
  private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

  public void add(String name, String phoneNum) {
    if (phoneBook.containsKey(name)) {
      ArrayList<String> addNew = phoneBook.get(name);
      addNew.add(phoneNum);
      phoneBook.put(name, addNew);
    } else {
      ArrayList<String> addNum = new ArrayList<>();
      addNum.add(phoneNum);
      phoneBook.put(name, addNum);
    }
  }

  public static void printPhoneBook() {
    List<List> phoneBookValues = new ArrayList<>(phoneBook.values());
    List<String> phoneBookKeys = new ArrayList<>(phoneBook.keySet());
    List<Integer> valueSizes = new ArrayList<>();

    for (List item : phoneBookValues) {
      valueSizes.add(item.size());
    }

    Integer[] arrValues = valueSizes.toArray(new Integer[0]);
    String[] arrKeys = phoneBookKeys.toArray(new String[0]);
    Map<String, Integer> sortedValues = new LinkedHashMap<>();

    for (int i = 0; i < arrKeys.length; i++) {
      sortedValues.put(arrKeys[i], arrValues[i]);
    }
  
    List<Map.Entry<String, Integer>> entries = new ArrayList<>(sortedValues.entrySet());
    Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        return a.getValue().compareTo(b.getValue());
      }
    });

    Map<String, Integer> sortedMap = new LinkedHashMap<>();

    for (Map.Entry<String, Integer> entry : entries) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    List<String> reversedKeyList = new ArrayList<>(sortedMap.keySet());
    Collections.reverse(reversedKeyList);

    for (String key : reversedKeyList) {
      System.out.println(key + ": " + phoneBook.get(key));
    }
  }

  public static void main(String[] args) {
    String name1 = "Иванов";
    String name2 = "Петров";
    String name3 = "Сидоров";
    String phone1 = "+ 7 917 123 45 67";
    String phone2 = "+ 7 952 123 45 67";
    String phone3 = "+ 7 987 123 45 67";

    PhoneBook myPhoneBook = new PhoneBook();
    myPhoneBook.add(name1, phone1);
    myPhoneBook.add(name1, phone2);
    myPhoneBook.add(name2, phone1);
    myPhoneBook.add(name2, phone2);
    myPhoneBook.add(name2, phone3);
    myPhoneBook.add(name3, phone1);

    PhoneBook.printPhoneBook();
  }
}