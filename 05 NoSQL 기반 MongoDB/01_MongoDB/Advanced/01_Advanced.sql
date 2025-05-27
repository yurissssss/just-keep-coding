— p2 (문제 1) —
(문제 1-1) 
create collection -> users

db.users.insert({username: “smith”})

(문제 1-2)
db.users.update({username: “smith”},
    {
	$set: {
		favorites: {
			cities: [“Chicago” “Cheyenne”],
			movies: [“Casablanca”, “For a Few Dollars More”, “The Sting”]
		}
	}
})
		


— p3 (문제 2) —

(문제 2-1) 
db.users.insert({username: “jones”})

(문제 2-2)
db.users.update({username: “jones”},
	{$set: {
	     favorites: {
		movies: [“Casablanca”, “Rocky”]
		}
	}
})


— p4 (문제 3) —

(문제 3-1) 
db.users.find({“favorites.movies”: “Casablanca”}).pretty()


— p5 (문제 4) —

(문제 4-1) 
db.users.updateMany({“favorites.movies”: “Casablanca”},  // filter: “Casablanca” 영화를 좋아하는 사용자
	{$addToSet: {“favorites.movies”: “The Maltese Falcon”}},  // addToSet: 중복 없이 배열에 추가 (Set 성질 반영)
	{upsert: false})  // 해당 항목이 없는 경우 무시


— p7 (문제 5) —

(문제 5-1) 
create collection -> numbers

for (let i = 0; i < 20000; i++) {
	db.numbers.insert({num: i})
}

(문제 5-2)
db.numbers.count()  // 20000


— p8 (문제 6) —

(문제 6-1) 
db.numbers.find({num: {“gte”: 20, “lte”: 25}})

(문제 6-2)
db.numbers.find({num: {"gte": 20, "lte": 25}}).explain("executionStats")


— p9 (문제 9) —

(문제 7-1) 
db.numbers.ensureIndex({num: 1})

(문제 7-2)
db.numbers.getIndexes()

(문제 7-3)
db.numbers.find({num: {"$gte": 20, "$lte": 25}}).explain("executionStats")
