import time

NUMBER_OF_INTEGERS = 0

def readConstantsFromFile():
    f = open("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt", "r")
    lines = f.readlines()
    ok = False
    for line in lines:
        if line == 'Memory Access\n':
            ok = True
        else:
            if ok == True:
                global NUMBER_OF_INTEGERS
                NUMBER_OF_INTEGERS = int(line)
                break

def staticAccess():
    file.write("Sir static\n")
    v = []
    for i in range(0, NUMBER_OF_INTEGERS):
        v.append(0)

    total_time = 0
    for j in range(10):
        startTime = time.time()
        for i in range(0, NUMBER_OF_INTEGERS):
            v[i] = i
        endTime = time.time()
        if (endTime - startTime) != 0:
            total_time += (endTime - startTime)

    mean_time = total_time / 10
    file.write("=> %.8s secunde\n" % mean_time)

readConstantsFromFile()
file = open("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AccesMemorie_Python.txt", "w")
file.write("Python\n")
file.write("Masurarea accesului la memorie a unui sir cu "+str(NUMBER_OF_INTEGERS)+" intregi \n\n")

staticAccess()
# DYNAMIC
file.write("\nSir dinamic\n")
v = []
for i in range(0, NUMBER_OF_INTEGERS):
    v.append(0)

total_time = 0
for j in range(10):
    startTime = time.time()
    for i in range(0, NUMBER_OF_INTEGERS):
        v[i] = i
    endTime = time.time()
    if (endTime - startTime) != 0:
        total_time += (endTime - startTime)

mean_time = total_time / 10
file.write("=> %.8s secunde\n" % mean_time)
