import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ReadExample {
    private static String bigExcelFile = "test.txt";

    public static void main(String[] args) throws Exception {
        try (RandomAccessFile file = new RandomAccessFile(new File(bigExcelFile), "r")) {
            // Get file channel in read-only mode
            FileChannel fileChannel = file.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            // the buffer now reads the file as if it were loaded in memory.
            System.out.println("Is Lodaded? -> " + buffer.isLoaded()); // prints false
            System.out.println("Buffer capacity: " + buffer.capacity()); // Get the size based on content size of file

            // You can read the file from this buffer the way you like.
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print((char) buffer.get()); // Print the content of file
            }
            System.out.print("\n");
            
            fileChannel.close();
        }
    }
}