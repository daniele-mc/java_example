import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class WriteExample {
    private static String bigTextFile = "test.txt";

    public static void main(String[] args) throws Exception {
        File file = new File(bigTextFile);

        //deletamos o arquivo, pois vamos acessar-lo de outra maneira
        file.delete();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8 * 8); // 0 -> posição onde vai começar a mapear os arquivos, e apos isso o tamanho pre definido 

            buffer.put("Escrevendo em um Buffer de saida".getBytes());

            fileChannel.close();
        }
    }

}