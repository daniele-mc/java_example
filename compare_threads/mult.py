import threading
import timeit

global NUM_OF_THREADS
NUM_OF_THREADS = 9

def workerTh(row, col, A, B, C):
	for i in range(0, len(B)):
		C[row][col] += A[row][i] * B[i][col]

A = [[1,4],[2,5],[3,6]]
B = [[8,7,6],[5,4,3]]
C = [[0,0,0], [0,0,0], [0,0,0]]
threadcount = 0
thrd = []

start = timeit.default_timer() 
for row in range(3):
	for col in range(3):
		thrd.append(threading.Thread(target=workerTh, args=(row,col,A,B,C)))
		thrd[threadcount].start()
		threadcount += 1

for process in thrd:
	process.join()
	
end = timeit.default_timer()
print("Duração: ", (end-start))

print("A Matrix :", A)
print("B Matrix :", B)
print("Resulting C Matrix :", C)
