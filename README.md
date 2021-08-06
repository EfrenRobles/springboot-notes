# springboot-notes

You need to create a database first to use this demo.

DB:leo_db
host: localhost

Api host: localhost
port: 8080

// to create an user
curl -X POST -H "Content-Type: application/json" -d "{\"email\":\"the.email@example.com\",\"password\":\"sEcReTwOrD123\"}" http://localhost:8080/users

// to login and get the token
curl -X POST -H "Content-Type: application/json" -d "{\"email\":\"the.email@example.com\",\"password\":\"sEcReTwOrD123\"}" http://localhost:8080/login

// save the token in a env var (windows version)
 set token="Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoidGhlLmVtYWlsQGV4YW1wbGUuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYyODI4NDA0MywiZXhwIjoxNjI4Mjg0NjQzfQ.g1uKCVJ3z8Wjd_pcGXdlEKDx1oxuhOt_HpCWbOCfe2-ic949AKkWowJY3OhtF5oOJul78zMiV3DoGnW_4fIzNw"

// Get user details
curl -X GET -H "Content-Type: application/json" -H %token% http://localhost:8080/users

// Get User Notes
curl -X GET -H "Content-Type: application/json" -H %token% http://localhost:8080/notes

// Set a note for the user
curl -X POST -d "{\"title\":\"the title\",\"note\":\"the note\"}" -H "Content-Type: application/json" -H %token% http://localhost:8080/notes

// To update a note from the user
curl -X PATCH -d "{\"id\":\"3d8c7759-3b33-4e77-8f5c-7aaf93178dcd\",\"title\":\"the title\",\"note\":\"the notes\"}" -H "Content-Type: application/json" -H %token% http://localhost:8080/notes

// To remove a note from the user
curl -X DELETE  -H "Content-Type: application/json" -H %token% http://localhost:8080/notes?id=3d8c7759-3b33-4e77-8f5c-7aaf93178dcc
