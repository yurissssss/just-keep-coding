function displayA() {
  console.log('A');
}
function displayB() {
  // 2초 후 출력
  setTimeout(() => {
    console.log('B');
  }, 2000);
}
function displayC() {
  console.log('C');
}

// 함수 실행
displayA();
displayB();
displayC();
