let obj = { result: 0 };
obj.add = function (x, y) {
  function inner() {
    // inner() 일반 함수로 호출 -> this 전역 객체
    // this.result -> 전역 공간에 새로운 result 생성
    this.result = x + y;
  }
  // 일반 함수로 호출
  // 해결 -> this.inner();
  inner();
};
obj.add(3, 4);
console.log(obj); // { result: 0 }
console.log(result); // 7
