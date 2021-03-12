
db.auth('mongodbadmin', 'mongodbadmin')
db = db.getSiblingDB('rank_db')
db.createUser(
    {
        user: "developer",
        pwd: "devadmin",
        roles: [
            {
                role: "readWrite",
                db: "rank_db"
            }
        ]
    }
);
