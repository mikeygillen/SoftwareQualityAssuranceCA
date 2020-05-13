# SQAExam
Final Assignment for Software Quality Assurance module

## Introduction
As part of a Software Quality management plan for an organisation you have been asked to implement an example software project. This will be a reference guide for best practices that the rest of the team can refer to. The project will demonstrate the following topics:
* Scrum sprint backlog and task estimation
* Unit testing and Test-Driven development
* Test coverage metric
* Team version-control
* Code-review checklist
### Description
You are going to create a software component in Java for storing information about Surveys and Responses. Each Survey is made up of multiple Questions (up to a maximum of 10). Every SurveyResponse should contain an answer to each Question in its Survey, where the answer will be an integer value between 1 and 5 (i.e. representing a Likert scale).
### Sprint Backlog
Sprint backlog contains a list of tasks, and the corresponding estimation associated with each task.
### Tasks and Estimations
* create a new Survey – 2
* add a question to a survey – 0.5
* get a list of all surveys – 3
* get a specific survey by name – 2
* creating a new SurveyResponse – 2
* adding an answer to a SurveyResponse – 1
* getting all SurveyResponses associated with a specific Survey – 3
* provide summary calculations including the
    1. Average – 1
    2. Standard Deviation – 2
    3. Maximum & Minimum – 1
* Finally provide summary for a specific question on a Survey
    1. Average – 0.5
    2. Standard Deviation – 0.5
    3. Maximum & Minimum – 0.5

### Task estimation
For the estimation of tasks I decided to go with the technique used by most agile teams, and use story points. Story points rate the relative effort of work in a Fibonacci-like format: 0, 0.5, 1, 2, 3, 5, 8, 13, 20, 40, 100. Each point would be roughly how much work a member could compete per hour. It is very useful as it forces the team involved to make tougher decisions around the difficulty of work;
* Once you agree on the relative effort of each story point value, you can assign points quickly without much debate.
* Story points reward team members for solving problems based on difficulty, not time spent. This keeps team members focused on shipping value, not spending time.

Because this is an individual assignment and there was no way to hold sprint meetings to collectively determine appropriate weightings for tasks I had to just create my own weightings and just trust I was estimating correctly. I based my estimations off some of the following factors;
* Have I done it before? Can I estimate from experience?
* Is it a key feature?
* Does it involve many or any CRUD elements?
* Are other features dependent on it?
* Include just one or two statements
* Includes a series of statements

I then quickly worked out how long I thought it might take me to complete each story point based on each individual task and assigned a weight accordingly. If I thought something would take 1 hour it got a score of 1, if it might take 2 then 2 points etc.

### Task Comparison for different estimates
1. Provide summary calculations for Standard Deviation – **2 Story points**
2. Standard Deviation for a specific question – **0.5 Story points**

I thought these would be good to highlight as they are tasks that I actually compared when estimating the weights, and they are practically the same task yet one was given a weight of 1.5 more. The reason for this is when thinking of the task the first question I asked myself was have I ever done anything like this before and the answer was no, I decided to add 1 to the total of this for self-learning time, and an addition 1 to implement the method. The second task, as it was similar, should not require any learning and therefore should be 1 less story point. However, as I felt much of the code and knowledge needed to implement it would already be available within the team, providing the tasks are done in the correct order, I assigned it a score of 0.5
### Velocity Metric Calculation
Velocity is the measure of the amount of work a Team can tackle during a single Sprint and is calculated at the end of the Sprint by totalling the Points for all fully completed User Stories. The calculation of the velocity metric can be worked out by first getting all the task that were fully complete and adding together all their respective weights. I.e. Two tasks complete weighted at 1 and 2 will equal 3. This number will then be divided by the number of sprints involved in completing the tasks, for this example we say it was all done in one sprint so the velocity of the team is then said to be 3/1 which equals 3.
This feeds into the preparation of the next sprint as we know to aim for a collection of tasks that equals no more than 3.
