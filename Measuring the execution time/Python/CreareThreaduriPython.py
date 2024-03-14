import time
from threading import Thread

NUMBER_OF_THREADS = 0

def readConstantsFromFile():
    f = open("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt", "r")
    lines = f.readlines()
    ok = False
    for line in lines:
        if line == 'Thread Creation\n':
            ok = True
        else:
            if ok == True:
                global NUMBER_OF_THREADS
                NUMBER_OF_THREADS = int(line)
                break

def createThreads():
    threads = []
    for i in range(NUMBER_OF_THREADS):
        threads.append(Thread(None))
    return threads

readConstantsFromFile()
file = open("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\CreareThreaduriPyton.txt", "w")
file.write("Python\n")
file.write("Masurarea alocarii a "+str(NUMBER_OF_THREADS)+" threaduri \n\n")

total_time = 0
j = 0
while j < 10:
    startTime = time.time()
    createThreads()
    endTime = time.time()
    if (endTime - startTime) != 0:
        total_time += (endTime - startTime)
        j = j + 1

mean_time = total_time / 10 
file.write("=> %.8s secunde\n" % mean_time)
