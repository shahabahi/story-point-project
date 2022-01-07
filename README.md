# story-point-project
Application will insert some record in inmemory database(H2) after start and if you want to change it.it is into data.sql file in /resources folder.

GET -> http://localhost:8000/plan
This method calculate and return the best plan assignment task to developers .

PUT -> http://localhost:8000/plan
This method is for update the returned best plan into database.

GET -> http://localhost:8000/issues
Return list of issues

POST -> http://localhost:8000/issues
Add new isuue to database

PUT -> http://localhost:8000/issues
Update Issue

GET -> http://localhost:8000/stories
Return list of stories

POST -> http://localhost:8000/stories
Add new story to database




