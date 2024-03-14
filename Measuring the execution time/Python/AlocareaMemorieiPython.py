import time
import gc

NUMBER_OF_INTEGERS = 0

def readConstantsFromFile():
    f = open("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt", "r")
    lines = f.readlines()
    ok = False
    for line in lines:
        if line == 'Memory Allocation\n':
            ok = True
        else:
            if ok == True:
                global NUMBER_OF_INTEGERS
                NUMBER_OF_INTEGERS = int(line)
                break


readConstantsFromFile()
file = open("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AlocareaMemoriei_Python.txt", "w")
file.write("Python\n")
file.write("Masurarea alocarii unui sir cu "+str(NUMBER_OF_INTEGERS)+" intregi \n\n")
v = []
total_time = 0 
j = 0
while j < 10:
    startTime = time.time()
    for i in range(0, NUMBER_OF_INTEGERS):
        v.append(i)
    endTime = time.time()
    if (endTime - startTime) != 0:
        total_time += (endTime - startTime)
        j = j + 1
    v.clear()
    gc.collect()

mean_time = total_time / 10 
file.write("=> %.8s secunde\n" % mean_time)
