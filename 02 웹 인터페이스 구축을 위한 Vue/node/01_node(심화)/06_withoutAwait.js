fetch('https://jsonplaceholder.typicode.com/users')
  .then((response) => response.json())
  .then((data) => console.log(data))
  // 에러 처리
  .catch((err) => console.log(err));
