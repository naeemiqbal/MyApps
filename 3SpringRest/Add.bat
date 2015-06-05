curl -X PUT {partid: "1", partdesc: "one", productiondate: "1433131200", id: "BISM.model.Part-7"} http://localhost:8080/rest/Parts

curl -H 'Content-Type: application/json' -X PUT '{partid: "1", partdesc: "one", productiondate: "1433131200", id: "BISM.model.Part-7"} http://localhost:8080/rest/Parts

curl -H "Content-Type: application/json" -X POST -d '{"username":"xyz","password":"xyz"}' http://localhost:3000/api/login

curl -H "Content-Type: application/json" -X POST -d '{"partid": "1", "partdesc": "one", "productiondate": "1433131200", "id": "BISM.model.Part-7"}' http://localhost:8080/rest/Parts


