import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class BenchMarkTest {
    private static String bigTextFile = "test.txt";

    public static void main(String[] args) throws Exception {
        File file = new File(bigTextFile);

        // Delete the file; we will create a new file
        file.delete();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            // Get file channel in read-write mode
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8 * 8); // 0 -> posição onde vai começar a mapear os arquivos, e apos isso o tamanho pre definido 

            // Write the content using put methods
            buffer.put("Escrevendo em um Buffer de saida".getBytes());

            fileChannel.close();
        }


         try (RandomAccessFile read = new RandomAccessFile(new File(bigTextFile), "r")) {
            // Get file channel in read-only mode
            FileChannel fileChannel = read.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            // the buffer now reads the file as if it were loaded in memory.
            //System.out.println("Is Lodaded? -> " + buffer.isLoaded()); // prints false
            //System.out.println("Buffer capacity: " + buffer.capacity()); // Get the size based on content size of file

            // You can read the file from this buffer the way you like.
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print((char) buffer.get()); // Print the content of file
            }
            System.out.print("\n");
            
            fileChannel.close();
        }
    




    }



}