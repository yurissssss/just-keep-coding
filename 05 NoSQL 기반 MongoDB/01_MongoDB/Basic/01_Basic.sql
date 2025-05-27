— p2 (문제 1) —
(문제 1-1) 
use tutorial

(문제 1-2)
db.users.insert({username: "smith"})

(문제 1-3)
db.users.insert({username: "jones"})

(문제 1-4)
db.users.find()

(문제 1-5)
db.users.findOne()


— p3 (문제 2) —

(문제 2-1) 
db.users.find({username: "jones"})

(문제 2-2)
db.users.find({$or: [
	{username: "smith"}, 
	{username: "jones"}
]})


— p4 (문제 3) —

(문제 3-1) 
db.users.update({username: "smith"}, {$set: {country: "Canada"}})

(문제 3-2)
db.users.find({username: "smith"})


— p5 (문제 4) —

(문제 4-1) 
db.users.update({username: "smith"}, {country: "Canada"})  
	-> 에러
db.users.find({country: "Canada"})

(문제 4-2)
db.users.update({username: "smith"}, {$set: {country: "Canada"}})
db.users.find({username: "smith"})


— p6 (문제 5) —

(문제 5-1) 
db.users.update({username: “smith”}, {$unset: {country: 1}})
db.users.find({username: "smith"})


— p7 (문제 6) —

(문제 6-1) 
show dbs

(문제 6-2)
show collections

(문제 6-3)
db.stats()
db.users.stats()


— p8 (문제 7) —

(문제 7-1) 
db.users.remove({username: “smith”})
db.users.find({username: “smith”})

(문제 7-2)
db.users.remove({})
db.users.find()

(문제 7-3)
db.users.drop


— p10 (문제 8) —

(문제 8-1) 
user test
for (let i=0; i<20000; i++) {
	db.product.insert({num: i, name: ‘스마트폰’ + i});
}

(문제 8-2)
db.product.count()


— p11 (문제 9) —

(문제 9-1) 
db.product.find().sort({num: -1})

(문제 9-2)
db.product.find().sort({num: -1}).limit(10)

(문제 9-3)
db.product.find()
    .sort({num: -1})
    .skip(10 * (6 - 1))
    .limit(10)


— p12 (문제 10) —

(문제 10-1) 
db.product.find({$or: 
    [
	{num: {$lt: 15}},
	{num: {$gt: 19995}},
    ]
})

(문제 10-2)
db.product.find({name: 
	{$in: [‘스마트폰10’, ‘스마트폰100’, ‘스마트폰1000’]}
})


— p13 (문제 11) —

(문제 11-1) 
db.product.find({num: {$lt: 5}}, {_id: 0, name: 1})