{\rtf1\ansi\ansicpg949\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset129 AppleSDGothicNeo-Regular;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red0\green0\blue0;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;\csgray\c0\c0;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf2 \cb3 \uc0\u8212  p2 (\'b9\'ae\'c1\'a6 1) \u8212 \
(\'b9\'ae\'c1\'a6 1-1) \
use tutorial\
\
(\'b9\'ae\'c1\'a6 1-2)\
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.insert(\{username: "smith"\})\
\
(\'b9\'ae\'c1\'a6 1-3)\
db.users.insert(\{username: "jones"\})\
\
(\'b9\'ae\'c1\'a6 1-4)\
db.users.find()\
\
(\'b9\'ae\'c1\'a6 1-5)\
db.users.findOne()\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p3 (\'b9\'ae\'c1\'a6 2) \u8212 \
\
(\'b9\'ae\'c1\'a6 2-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.find(\{username: "jones"\})
\fs24 \kerning1\expnd0\expndtw0 \
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0
\cf2 \
(\'b9\'ae\'c1\'a6 2-2)\
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.find(\{$or: [\
	\{username: "smith"\}, \
	\{username: "jones"\}\
]\})\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p4 (\'b9\'ae\'c1\'a6 3) \u8212 \
\
(\'b9\'ae\'c1\'a6 3-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.update(\{username: "smith"\}, \{$set: \{country: "Canada"\}\})\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \
(\'b9\'ae\'c1\'a6 3-2)\
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.find(\{username: "smith"\})\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p5 (\'b9\'ae\'c1\'a6 4) \u8212 \
\
(\'b9\'ae\'c1\'a6 4-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.update(\{username: "smith"\}, \{country: "Canada"\})  \
	-> \'bf\'a1\'b7\'af\
db.users.find(\{country: "Canada"\})
\fs24 \kerning1\expnd0\expndtw0 \
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0
\cf2 \
(\'b9\'ae\'c1\'a6 4-2)\
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.update(\{username: "smith"\}, \{$set: \{country: "Canada"\}\})
\fs24 \kerning1\expnd0\expndtw0 \

\fs26 \expnd0\expndtw0\kerning0
db.users.find(\{username: "smith"\})\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p6 (\'b9\'ae\'c1\'a6 5) \u8212 \
\
(\'b9\'ae\'c1\'a6 5-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.update(\{username: \'a1\'b0smith\'a1\'b1\}, \{$unset: \{country: 1\}\})\
db.users.find(\{username: "smith"\})
\fs24 \kerning1\expnd0\expndtw0 \

\fs26 \expnd0\expndtw0\kerning0
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p7 (\'b9\'ae\'c1\'a6 6) \u8212 \
\
(\'b9\'ae\'c1\'a6 6-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
show dbs\
\
(\'b9\'ae\'c1\'a6 6-2)\
show collections\
\
(\'b9\'ae\'c1\'a6 6-3)\
db.stats()\
db.users.stats()\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p8 (\'b9\'ae\'c1\'a6 7) \u8212 \
\
(\'b9\'ae\'c1\'a6 7-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.users.remove(\{username: \'a1\'b0smith\'a1\'b1\})\
db.users.find(\{username: \'a1\'b0smith\'a1\'b1\})\
\
(\'b9\'ae\'c1\'a6 7-2)\
db.users.remove(\{\})\
db.users.find()\
\
(\'b9\'ae\'c1\'a6 7-3)\
db.users.drop\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p10 (\'b9\'ae\'c1\'a6 8) \u8212 \
\
(\'b9\'ae\'c1\'a6 8-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
user test\
for (let i=0; i<20000; i++) \{\
	db.product.insert(\{num: i, name: \'a1\'ae\'bd\'ba\'b8\'b6\'c6\'ae\'c6\'f9\'a1\'af + i\});\
\}\
\
(\'b9\'ae\'c1\'a6 8-2)\
db.product.count()\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p11 (\'b9\'ae\'c1\'a6 9) \u8212 \
\
(\'b9\'ae\'c1\'a6 9-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.product.find().sort(\{num: -1\})\
\
(\'b9\'ae\'c1\'a6 9-2)\
db.product.find().sort(\{num: -1\}).limit(10)\
\
(\'b9\'ae\'c1\'a6 9-3)\
db.product.find()\
    .sort(\{num: -1\})\
    .skip(10 * (6 - 1))\
    .limit(10)\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p12 (\'b9\'ae\'c1\'a6 10) \u8212 \
\
(\'b9\'ae\'c1\'a6 10-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.product.find(\{$or: \
    [\
	\{num: \{$lt: 15\}\},\
	\{num: \{$gt: 19995\}\},\
    ]\
\})\
\
(\'b9\'ae\'c1\'a6 10-2)\
db.product.find(\{name: \
	\{$in: [\'a1\'ae\'bd\'ba\'b8\'b6\'c6\'ae\'c6\'f910\'a1\'af, \'a1\'ae\'bd\'ba\'b8\'b6\'c6\'ae\'c6\'f9100\'a1\'af, \'a1\'ae\'bd\'ba\'b8\'b6\'c6\'ae\'c6\'f91000\'a1\'af]\}\
\})\
\
\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardeftab720\pardirnatural\partightenfactor0

\fs24 \cf2 \kerning1\expnd0\expndtw0 \uc0\u8212  p13 (\'b9\'ae\'c1\'a6 11) \u8212 \
\
(\'b9\'ae\'c1\'a6 11-1) \
\pard\pardeftab720\partightenfactor0

\fs26 \cf2 \expnd0\expndtw0\kerning0
db.product.find(\{num: \{$lt: 5\}\}, \{_id: 0, name: 1\})}