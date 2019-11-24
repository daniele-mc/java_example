import mmap


with open("hello.txt", "wb") as f:
    f.write(b"Escrevendo em um buffer de saida\n")

with open("hello.txt", "r+b") as f:
    mm = mmap.mmap(f.fileno(), 0)
    
    line = mm.readline()
    print(line) 
    
    mm.close()
