import os
import shutil
 
# Assign directory
directory = r"./"
destination = r"./final/"
 
# Iterate over files in directory
for folder in os.listdir(directory):
    print("!folder " + folder)
    # Open file
    for name in os.listdir(folder):
        print("name " + name)
        filename = os.path.join(folder, "README.md")
        print("filename " + filename)
        if os.path.exists(filename) is True:
            with open(filename) as f:
                print(f"Content of '{name}'")
                # Read content of file
                #print(f.read())
                newfilename = destination + folder + '.html'
                shutil.copyfile(filename, newfilename)
                print("True")
                    
        else:
            newfilename = destination + folder + '.html'
            with open(newfilename, 'w') as fp: 
                pass
 
    print()