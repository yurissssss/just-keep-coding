let obj1 = { name: '박문수', age: 29 };
// 전개 연산자 : 새로운 객체 obj2에 obj1 내부의 값 복사해서 저장
// 새로운 속성 추가
let obj2 = { ...obj1, email: 'mspark@gmail.com' };

console.log(obj2);
