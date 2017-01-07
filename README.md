# Git Useful Commands #

### To get repository from Github ###

* `` git clone https://github.com/vvsrk/restwebservices.git ``

### To commit below are the steps: ###
* `` git get index.html (or) git get . or git get -A ``

to view the status

* `` git status ``

(If any new files)

* ``git add . ``

* `` git commit -m "modifications commited"``

* ``git push  (or) git push -f origin master``

* ``git pull``



### Push existing project into Github ###

1) Create repository in Github (ex: https://github.com/vvsrk/rest_workspace.git)

2) Move to the folder which you want to checkIngit

3) Run below commandsgit

* ``git init``
* ``git add .``
* ``git commit -m "Initial commit"``
* ``git remote add origin <project url> (ex: https://github.com/vvsrk/rest_workspace.git)``
* ``git push -f origin master``

### If we want to change the ::project url:: after we created the URL.  ###
ex: ``git remote set-url origin https://github.com/vvsrk/rest_workspace.git``

### Ignore some of the folders: ###
1) create file with name .gitignore in root directory(`` touch .gitignore``)
2) specify the list of folder which we want to ignore ending with slash (ex: ``folder1\``) 

### determine the URL that a local Git repository was originally cloned from? ###
* `` git config --get remote.origin.url``

## If git command screen is asking for User Id and Pwd every time, we can avoid this by executing these properties from cmd scr##
* ``config --global user.email "githubuserId@gmail.com" ``
* ``config --global user.name "githubuserId" ``


#Creating Branch in GitHub and Merge to Master#
#goto folder where our master is located(d:\JavaPractice\rest_workspace>)#
``d:\JavaPractice\rest_workspace>git branch git_branch_test``
``d:\JavaPractice\rest_workspace>git checkout git_branch_test``
``d:\JavaPractice\rest_workspace>git status``
``d:\JavaPractice\rest_workspace>git add .``
``d:\JavaPractice\rest_workspace>git commit -m "added to test branching"``

#(After commiting that only the branch will displays in GitHub)#
#If we want to switch to Master#
``d:\JavaPractice\rest_workspace>git checkout master``

#Note: Once we switched to Master, the files which we created will not apper in Master#

#####Merge#####
#When we want to Merge it to Master, first we have to checkout Master then Merge with branch#
``d:\JavaPractice\rest_workspace>git merge git_branch_test``

#Once we push then only it will update in Master#
``git push -u origin master``


``d:\JavaPractice\rest_workspace>git branch -d git_branch_test`` // only deletes from local

#To Delete from Remote#
``git push origin --delete git_branch_test``

