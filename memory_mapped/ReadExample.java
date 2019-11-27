import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReadExample {
    private static String bigExcelFile = "test.txt";

    public static void main(String[] args) throws Exception {
        try (RandomAccessFile file = new RandomAccessFile(new File(bigExcelFile), "r")) {
            FileChannel fileChannel = file.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            System.out.println("Is Lodaded? -> " + buffer.isLoaded()); 
            System.out.println("Buffer capacity: " + buffer.capacity());

            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print((char) buffer.get()); 
            }
            System.out.print("\n");
            
            fileChannel.close();
        }
    }
}