import mmap

with open("hello.txt", "r+b") as f:
    # memory-map the file, size 0 means whole file
    mm = mmap.mmap(f.fileno(), 0)
    # read content via standard file methods
    # ... and read again using standard file methods
    line = mm.readline()
    print(line)  # prints b"Hello  world!\n"
    # close the map
    mm.close()
