import mmap


with open("hello.txt", "wb") as f:
    for i in range(10):
        f.write(b'A')

with open("hello.txt", "r+b") as f:
    mm = mmap.mmap(f.fileno(), 0)
    
    print(mm.read())
        
    mm.close()
