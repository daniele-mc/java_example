import mmap

with open("hello.txt", "wb") as f:
    f.write(b"Escrevendo em um buffer de saida\n")
