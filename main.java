
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) throws IOException {
        //Считываем с консоли число N
        int n = in.nextInt();
        //переход к следующей строке
        // (избегаем захвата лишних символов в буфере)
        in.nextLine();
        //создаем массив строк длинной n
        String[] w = new String[n];
        // Вводим n строк в массив w
        for (int i = 0; i < n; i++)
            w[i] = in.nextLine();
        //сортировка пузырьком
        for (int j = 1; j < n ; j++) {
            for (int i = 0; i < n-j; i++) {
                //Сравниваем длины строк
                if (w[i].length() > w[i+ 1].length()) {
                    // Меняем местами, если длина строки i больше, чем у i+1
                    String z = w[i];
                    w[i] = w[i+1];
                    w[i+1] = z;
                }
                // Если длины одинаковые,то выстраиваем строки
                //в алфавитном порядке
                else if (w[i].length() == w[i+1].length()) {
                    if (w[i].compareTo(w[i+1]) > 0) {
                        String r = w[i];
                        w[i] = w[i+1];
                        w[i+1] = r;
                    }

                }

            }
        }
        // Выводим отсортированные строки
        for (int i = 0 ; i < w.length ; i++)
            out.print(w[i] + " ");
        System.out.println();
        // Находим строку с максимальной длиной
        int max = 0;
        String maxw = "";
        for (int i = 0; i < w.length; i++) {
            if (w[i].length() >= max) {
                max = w[i].length();
                maxw = w[i];
            }
        }
        out.println(maxw);

        // Копируем массив w в новый массив group
        String [] group = new String [n];
        for (int i = 0; i < group.length; i++){
            group[i] = w[i];
        }
        // Сортируем пузырьком буквы в каждой строке
        for (int k = 0; k < group.length; k++){
            // Преобразуем строку в массив символов
            char[] Array = group[k].toCharArray();
            for (int i = 1; i < Array.length; i++) {
                for (int j = 0; j < Array.length - i; j++) {
                    if (Array[j] > Array[j + 1]) {
                        char group1 = Array[j];
                        Array[j] = Array[j + 1];
                        Array[j + 1] = group1;
                    }
                }
            }
            // Преобразуем отсортированный массив символов обратно в строковый
            group[k] = new String(Array);
        }
        // Флаг для нахождения одинаковых строк
        boolean flag = false;
        for (int i = 0 ; i < w.length ; i++){
            String str = w[i];
            for (int j = 0; j < w.length; j++){
                // Если отсортированная строка совпадает с другой строкой
                //Добавляем строку w[j] к str
                if (group[i].equals(group[j]) && i != j){
                    str += " " + w[j];
                    flag = true;
                    // помечаем строку group[j] как обработанную
                    group[j] = w[j];
                }
            }
            // Выводим строки с одинаковыми символами в алфавитном порядке
            // и сброс флага
            if (flag) {
                System.out.println(str);
                flag = false;
            }
        }
        // Преобразуем гласные буквы в строках(гласная заменяется
        // на следущую букву в алфавите)
        // Проходим по всем строкам массива w
        for (int i = 0 ; i < w.length ; i++){
            for (int j = 0; j < w[i].length(); j++){
                if ("AEIOUYyaeiouАИОУЭЫЮаиоуэыю".indexOf(w[i].charAt(j)) != -1){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + (char)(w[i].charAt(j) + 1) + str2;
                }
                //с буквами е,ё,я работаем отдельно
                else if (w[i].charAt(j) == 'Ё'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'Ж' + str2;

                }
                else if (w[i].charAt(j) == 'ё'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'ж' + str2;
                }
                else if (w[i].charAt(j) == 'Е'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'Ё' + str2;
                }
                else if (w[i].charAt(j) == 'е'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'ё' + str2;
                }
                else if (w[i].charAt(j) == 'я'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'а' + str2;
                }
                else if (w[i].charAt(j) == 'Я'){
                    String str1 = w[i].substring(0, j);
                    String str2 = w[i].substring(j + 1);
                    w[i] = str1 + 'А' + str2;
                }
            }

        }
        // Выводим измененные строки
        for (int i = 0 ; i < w.length ; i++)
            out.print(w[i] + " ");
    }

}
            

