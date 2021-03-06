public class JavaMethodsHomework {
    public static void main(String[] args) {
        //1 задание. Високосный год.
        int year = (int)(Math.random() * 5000);
        if (isLeapYear(year)) {
            System.out.println("Year " + year + " - is leap");
        } else {
            System.out.println(year + " - is not leap");
        }

        //2 задание. Кол-во дней в месяце.
        int month = (int)(Math.random() * 12 + 1);
        System.out.println("Month " + month + " of year " + year + " have " + amountOfDays(month, year) + " days");

        //3 задание. Длина окружности(радиус).
        System.out.println("Circumference equals " + circumference(2.5));

        //4 задание. Площадь круга(диаметр).
        System.out.println("Circle area equals " + circleArea(5));

        //5 задание. Проверка наличия обеих субстрок в строке. Не использовать методы класса String
        String string = "fjkkjkwmeowjokmwepechen0ikow;efpechenushkasetu;sld,sjiw';ldds";
        String substring1 = "pechenushka";
        String substring2 = "meow";
        System.out.println(isSubstring(string, substring1, substring2));

        //6 задание. Проверка наличия субстроки в конце строки. Не использовать методы класса String
        String substring3 = "ldds";
        System.out.println(endsWithSubstring(string, substring3));

        //7 задание. Составление массива с заданной длинной из степеней двойки.
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

        //8 задание. Сумма дробных частей всех чисел массива.
        double[] doubleArray = {2.6, 17.9, 5.6, 3.3};
        System.out.println(sumOfFractionalParts(doubleArray));

        //9 задание. Вернуть перевернутый массив, не изменяя исходный.
        System.out.println();
        System.out.println("array does not change");
        double[] arrayForReverse  = {2.6, 17.9, 5.6, 3.3};
        for (double i : arrayForReverse) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < reverseArrayWithoutChanges(arrayForReverse).length; i++)
            System.out.print(reverseArrayWithoutChanges(arrayForReverse)[i] + " ");
        System.out.println();
        for (double i : arrayForReverse) System.out.print(i + " ");

        //10 задание. Перевернуть массив, записать в исходный.
        System.out.println();
        System.out.println();
        System.out.println("the array is changing");
        double[] changeableArray  = {2.6, 17.9, 5.6, 3.3};
        for (double i : changeableArray) System.out.print(i + " ");
        reverseArrayWithChanges(changeableArray);
        System.out.println();
        for (double i : changeableArray) System.out.print(i + " ");
    }
    //1 задание. Високосный год.
    public static boolean isLeapYear(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }
    //2 задание. Кол-во дней в месяце.
    public static int amountOfDays(int month, int year) {
        return month == 2 ? (isLeapYear(year) ? 29 : 28) : (month == 4 || month == 6 || month == 9 || month == 11 ? 30 : 31);
    }
    //3 задание. Длина окружности(радиус).
    public static double circumference(double radius) {
        return (2 * radius * Math.PI);
    }
    //4 задание. Площадь круга(диаметр).
    public static double circleArea(double diameter) {
        return (Math.PI * diameter * diameter / 4);
    }
    //5 задание. Проверка наличия обеих субстрок в строке. Не использовать методы класса String
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
                }
                if (stringContainsSubstring2) break;
            }
        }
        return stringContainsSubstring1 && stringContainsSubstring2;
    }
    //6 задание. Проверка наличия субстроки в конце строки. Не использовать методы класса String
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
        return stringEndWithSubstring;
    }
    //7 задание. Составление массива с заданной длинной из степеней двойки.
    public static int[] getArrayOfPowersOfTwo(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) array[i] = (int) Math.pow(2, i);
        return array;
    }
    //8 задание. Сумма дробных частей всех чисел массива.
    public static double sumOfFractionalParts(double[] array) {
        for (int i = 0; i < array.length; i++) array[i] = array[i] - (int) array[i];
        double sum = 0;
        for (double i: array) sum += i;
        return sum;
        /**Я не понимаю, почему java считает результат формулы
         * для первого элемента(2.6), как 0.6000000000..
         * для второго элемента(17.9), как 0.89999999999.. и т.д.
         * В итоге получается неточное значение: 2.399999999999998
         */
    }
    //9 задание. Вернуть перевернутый массив, не изменяя исходный.
    public static double[] reverseArrayWithoutChanges(double[] array) {
        double[] reversedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) reversedArray[i] = array[array.length - 1 - i];
        return reversedArray;
    }
    //10 задание. Перевернуть массив, записать в исходный.
    public static void reverseArrayWithChanges(double[] array) {
        double[] reversedArray = new double[array.length];
        System.arraycopy(array, 0, reversedArray, 0, reversedArray.length);
        for (int i = 0; i < reversedArray.length; i++) array[i] = reversedArray[reversedArray.length - 1 - i];
    }
}