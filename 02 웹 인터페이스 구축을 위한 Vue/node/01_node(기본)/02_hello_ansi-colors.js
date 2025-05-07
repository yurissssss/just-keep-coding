const c = require('ansi-colors');

const hello = function (name) {
  console.log(c.green(name) + '님, 안녕하세요?');
};

hello('홍길동');
