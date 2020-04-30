// Posted from EduTools plugin
import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        int nextByte = inputStream.read();
        while (nextByte != -1) {
            System.out.print(nextByte);
            nextByte = inputStream.read();
        }
    }
}