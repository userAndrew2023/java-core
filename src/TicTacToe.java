import java.io.*;

public class TicTacToe {

    public static void main(String[] args) {
        int[] cells = {0, 1, 2, 3, 0, 1, 2, 3, 0};
        File file = new File("tic_tac_toe.dat");

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            int packedData = 0;
            for (int i = 0; i < cells.length; i++) {
                packedData |= (cells[i] & 0x03) << (2 * i);
            }
            dos.writeByte((packedData) & 0xFF);
            dos.writeByte((packedData >> 8) & 0xFF);
            dos.writeByte((packedData >> 16) & 0xFF);
            System.out.println("Данные записаны в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
