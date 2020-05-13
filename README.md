# SQAExam
Final Assignment for Software Quality Assurance module

## Team Version Control
Branching, in version control and software configuration management, is the duplication of an object under version control so that modifications can occur in parallel along multiple branches. These are all the branches that were created for my project and how they fit in GitFlow.
#### *Master*
The default branch name in Git is master. The “master” branch in Git is not a special branch, it is where the project begins and where the final project containing all documentation and code will be at the end. No changes will be made directly to this branch but instead pull requests from the develop or hotfix branch will update it. Once the QA is satisfied with the quality, the release branch is merged into master. 
 Note: Any commit in master is a merge commit, either release or a hotfix branch, and represents a new release that would be put into production. As my documentation is all just text files I have branched them straight from here for easy merging but in general you should only merge from the develop or hotfix branches.
#### *Develop*
The develop branch is the stable developer's branch. In traditional source control software the develop branch is your repo server. It is the branch all developers have in common. It is the branch you start development with. This branch is where any near final changes are located before making it into the master branch this branch only takes pull requests from either the feature or release branch.
#### *Documentation*
This is similar to the develop branch, but instead it wil be used to handle changes in README file instead of code.
#### *Feature Branches*
All features / new functions / major refactoring’s are done in here in feature branches, which branch off and are merged back into the develop branch, after they are reviewed of course. 
#### *Release Branches*
When enough features have accumulated or the next release time frame comes near, a new release branch is branched off develop. It is solely dedicated to testing/bug fixing and any clean-up necessary.
#### *Hotfix* 
If a major problem is found after release, a quick fix can be developed in a hotfix branch, that is branched off the master. This is the only branch that should ever branch off of master. I have all my documentation branched from the master but as I mentioned before this is because they are only text files.
