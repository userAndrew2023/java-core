import java.io.*;

public class ReadTicTacToe {

    public static void main(String[] args) {
        File file = new File("tic_tac_toe.dat");
        int[] cells = new int[9];

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int packedData = 0;
            packedData |= (dis.readByte() & 0xFF);
            packedData |= (dis.readByte() & 0xFF) << 8;
            packedData |= (dis.readByte() & 0xFF) << 16;

            for (int i = 0; i < cells.length; i++) {
                cells[i] = (packedData >> (2 * i)) & 0x03;
            }

            System.out.println("Данные прочитаны из файла:");
            for (int cell : cells) {
                System.out.print(cell + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
