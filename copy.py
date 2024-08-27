import os
import shutil
 
# Assign directory
directory = r"./problems"
destination = r"./final/"
 
# Iterate over files in directory
count = 0
list = []
for folder in os.listdir(directory):
    print("!folder " + folder)
    # Open file
    newfolder = "./problems/" + folder
    print("!newfolder " + newfolder)
    for name in os.listdir(newfolder):
        # print("name " + name)
        filename = os.path.join(folder, "README.md")
        # print("filename " + filename)
        if os.path.exists(filename) is True:
            with open(filename) as f:
                #print(f"Content of '{name}'")
                # Read content of file
                #print(f.read())
                newfilename = destination + folder + '.html'
                shutil.copyfile(filename, newfilename)
                #print("True")
                count = count + 1
                    
        else:
            
            newfilename = destination + folder + '.html'
            with open(newfilename, 'w') as fp: 
                pass
            list.append(newfilename)
    
    print("count ", count)