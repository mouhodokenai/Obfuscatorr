import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaCodeCompressor {

    public static void main(String[] args) {
        try {
            // Открываем файл для чтения
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Veterinarians.java"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            boolean inBlockComment = false;


        while ((line = bufferedReader.readLine()) != null) {
            if (!inBlockComment) {

                // Удаление всех комментариев

                if (line.contains("/*")) {
                    inBlockComment = true;
                } else {
                    if (!line.contains("//")){
                        stringBuilder.append(line);
                    }
                }
            }

            if (inBlockComment && line.contains("*/")) {
                inBlockComment = false;
            }

        }
            bufferedReader.close();

            // Открываем файл для записи
            BufferedWriter writer = new BufferedWriter(new FileWriter("Veterinarians.java"));

            // Удаляем избыточные пробелы, включая пробелы перед/после разделителей
            // Заменяем последовательности пробелов на одиночные пробелы
            writer.write(stringBuilder.toString().replaceAll("\\s+(?=[;{}()=,|])|(?<=[;{}()=,|])\\s+", "").replaceAll("\\s+", " "));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
