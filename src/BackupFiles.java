import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class BackupFiles {

    public static void main(String[] args) {
        File sourceDir = new File(".");
        File backupDir = new File("./backup");

        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        try (Stream<Path> files = Files.list(sourceDir.toPath())) {
            files.forEach(file -> {
                if (Files.isRegularFile(file)) {
                    File destFile = new File(backupDir, file.getFileName().toString());
                    try {
                        Files.copy(file, destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Файл скопирован: " + file.getFileName());
                    } catch (IOException e) {
                        System.err.println("Ошибка при копировании файла: " + file.getFileName());
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
