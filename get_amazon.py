import os
import shutil
 
# Using readlines()
file1 = open('amazon_6months.txt', 'r')
Lines = file1.readlines()

count = 0
# Strips the newline character
for line in Lines:
    count += 1
    if line.strip() != "" and line.split(" ")[0].split(".")[0] != "Med":
        str = line.split(" ")[0].split(".")[0]
        if len(str) == 1:
            str = "000" + str
        elif len(str) == 2:
            str = "00" + str
        elif len(str) == 3:
            str = "0" + str
        else:
            pass

        #
        print("Line{}: {}".format(count, str))

        #copy target file to a targeted folder
        # Assign directory
        directory = r"./final/"
        destination = r"./amazon_6months/"

        for filename in os.listdir(directory):
            # Open file
            if str in filename:
                print("filename " + filename)
                oldfilename = directory + filename
                newfilename = destination + filename
                shutil.copyfile(oldfilename, newfilename)
        pass



        