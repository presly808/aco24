#### Choose task
* Show all tasks\
```./gradlew showAllTasks```
* Copy the task's files to your module\
```./gradlew -PmyModule=<ModuleName> -Ptask=<TaskName> copyTask```
* Example\
```./gradlew -PmyModule=SerhiiBilobrov -Ptask=week1 copyTask```
* Check your module, there must be packages of the copied task
* If you want update copy only tests in case when tests were updated use flag --PtestOnly=true
```./gradlew -PmyModule=SerhiiBilobrov -Ptask=week1 -PtestOnly copyTask```

#### The steps in order to implement a task
 
1. If you have not cloned project yet, just clone project
	a) During the cloning choose gradle
	or
	b) open in IDEA -> choose gradle.build -> Open as project
	
	Delegate all build IDEA commands to gradle
	In IDEA (Ctrl + Alt + S) 
	Build, Execution, Deployment -> Build Tool -> Gradle -> Runner
	Activate Delegate IDE build/run actions to Gradle
	Create own module using idea
	
2. Create branch (<TaskName>-<ModuleName>)\
    Before the creation ensure that current branch is `master` and\
    its was updated via (git pull)
3. switch to your branch -> Choose task, see how to choose in the top of README
4. Accomplish you task
5. Write Junit Tests (if needed)
6. Copy Common Tests, execute certain command
7. Run Tests using IDEA, after via ./gradlew check
8. Git - Add - Commit
9. Push your branch (NOT MASTER)
10. Pull Request (in GITHUB) Like asking for checking homework
11. Check status of the pull req (Tests will be run remotely(TRAVIS), Check code formatting)\
	If you have a faild build 
	go to the point (4)
12. A codereviewer will check you code and leaves some comments\
	if have problem -> go to 4th point
	else you branch will be merged into master
	
	
Quick update of your branch by master's changes (if master is updated, we want to have all new changes in our branch)
git -> repository -> fetch (update origin from github)
being on your branch you will chose (branch -> origin/master -> merge)





