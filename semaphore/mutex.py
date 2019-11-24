import threading 
import time
import os

lock = threading.Lock()

class MutexExample:    
    def __init__(self, id):
        self.threadid = id
        self.t = threading.Thread(target=self.thread_func, args=())

    def thread_func(self):
        global lock
        print("Locking ", self.threadid)
        lock.acquire()
        for i in range(0,5):
            print(self.threadid, " Está realizando operações")
           # time.sleep(1)    
        print("Realsing ", self.threadid)
        lock.release()



if __name__== "__main__":
   
    t1 = MutexExample("t1")
    t1.t.start()

    t2 = MutexExample("t2")
    t2.t.start()
   
    t3 = MutexExample("t3")
    t3.t.start() 
    
    t4 = MutexExample("t4")
    t4.t.start()
