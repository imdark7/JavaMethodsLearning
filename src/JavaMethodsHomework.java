/**
 * Created by Dark on 15.11.2015.
 */
public class JavaMethodsHomework {
    public static void main(String[] args) {
        int year = (int)(Math.random() * 5000);
        if (isLeapYear(year)) {
            System.out.println("Year " + year + " - is leap");
        } else {
            System.out.println(year + " - is not leap");
        }

        int month = (int)(Math.random() * 12 + 1);
        System.out.println("Month " + month + " of year " + year + " have " + amountOfDays(month, year) + " days");
        System.out.println("Circumference equals " + circumference(2.5));
        System.out.println("Circle area equals " + circleArea(5));
        String string = "fjkkjkwmeowjokmwepechen0ikow;efpechenushkasetu;sld,sjiw';ldds";
        String substring1 = "pechenushka";
        String substring2 = "meow";
        System.out.println(isSubstring(string, substring1, substring2));
        String substring3 = "ldds";
        System.out.println(endsWithSubstring(string, substring3));
        int count = 12;
        int[] array = getArrayOfPowersOfTwo(count);
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.print("[" + array[i]);
            } else if (i == count - 1) {
                System.out.println(", " + array[i] + "]");
            } else {
                System.out.print(", " + array[i]);
            }
        }
        double[] doubleArray = {2.6, 17.9, 5.6, 3.3};
        System.out.println(sumOfFractionalParts(doubleArray));

        System.out.println();
        System.out.println("array does not change");
        double[] arrayForReverse  = {2.6, 17.9, 5.6, 3.3};
        for (int i = 0; i < arrayForReverse.length; i++) {
            System.out.print(arrayForReverse[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < reverseArrayWithoutChanges(arrayForReverse).length; i++) {
            System.out.print(reverseArrayWithoutChanges(arrayForReverse)[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arrayForReverse.length; i++) {
            System.out.print(arrayForReverse[i] + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("the array is changing");
        double[] changeableArray  = {2.6, 17.9, 5.6, 3.3};
        for (int i = 0; i < changeableArray.length; i++) {
            System.out.print(changeableArray[i] + " ");
        }
        reverseArrayWithChanges(changeableArray);
        System.out.println();
        for (int i = 0; i < changeableArray.length; i++) {
            System.out.print(changeableArray[i] + " ");
        }


    }

    public static boolean isLeapYear(int i) {
        if (i % 4 == 0) {
            if (i % 100 == 0) {
                if (i % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static int amountOfDays(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static double circumference(double radius) {
        return (2 * radius * Math.PI);
    }

    public static double circleArea(double diameter) {
        return (Math.PI * diameter * diameter / 4);
    }

    public static boolean isSubstring(String string, String substring1, String substring2 ) {
        //return (string.contains(substring1) && string.contains(substring2));
        char[] stringToCharArray = string.toCharArray();
        char[] substring1ToCharArray = substring1.toCharArray();
        char[] substring2ToCharArray = substring2.toCharArray();
        boolean stringContainsSubstring1 = false;
        boolean stringContainsSubstring2 = false;
        for (int i = 0; i < stringToCharArray.length; i++) {
            if (stringToCharArray[i] == substring1ToCharArray[0]) {
                for (int m = 0; m < substring1ToCharArray.length; m++) {
                    if (stringToCharArray[i + m] == substring1ToCharArray[m]) {
                        stringContainsSubstring1 = true;
                    } else {
                        stringContainsSubstring1 = false;
                        break;
                    }
                    if (stringContainsSubstring2) break;
                }
                if (stringContainsSubstring1) break;
            }
        }
        for (int i = 0; i < stringToCharArray.length; i++) {
            if (stringToCharArray[i] == substring2ToCharArray[0]) {
                for (int m = 0; m < substring2ToCharArray.length; m++) {
                    if (stringToCharArray[i + m] == substring2ToCharArray[m]) {
                        stringContainsSubstring2 = true;
                    } else {
                        stringContainsSubstring2 = false;
                        break;
                    }
                    if (stringContainsSubstring2) break;
                }
                if (stringContainsSubstring2) break;
            }
        }
        if (stringContainsSubstring1 && stringContainsSubstring2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean endsWithSubstring(String string, String substring) {
        //return string.endsWith(substring);
        char[] stringToCharArray = string.toCharArray();
        char[] substringToCharArray = substring.toCharArray();
        boolean stringEndWithSubstring = false;
        for (int i = 0; i < substringToCharArray.length; i++) {
            if (stringToCharArray[stringToCharArray.length - 1 - i] == substringToCharArray[substringToCharArray.length - 1 - i]) {
                stringEndWithSubstring = true;
            } else {
                stringEndWithSubstring = false;
                break;
            }
        }
        if (stringEndWithSubstring) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] getArrayOfPowersOfTwo(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(2, i);
        }
        return array;
    }

    public static double sumOfFractionalParts(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] - (int) array[i];
        }
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
        /**я не понимаю, почему java считает
         * array[i] = array[i] - (int) array[i]
         * дл€ первого элемента(2.6), как 0.6000000000..
         * дл€ второго элемента(17.9), как 0.89999999999.. и т.д.
         * ¬ итоге получаетс€ неточное значение: 2.399999999999998
         */
    }

    public static double[] reverseArrayWithoutChanges(double[] array) {
        double[] reversedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    public static double[] reverseArrayWithChanges(double[] array) {
        double[] reversedArray = new double[array.length];
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = array[i];
        }
        for (int i = 0; i < reversedArray.length; i++) {
            array[i] = reversedArray[reversedArray.length - 1 - i];
        }
        return array;
    }
}
