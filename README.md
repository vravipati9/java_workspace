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
