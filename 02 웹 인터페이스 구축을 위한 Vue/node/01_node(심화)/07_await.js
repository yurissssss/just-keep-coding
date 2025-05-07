async function init() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/users');
    const users = await response.json();
    console.log(users);
  } catch (err) {
    console.error(err);
  }
}
init();

// fetch('https://jsonplaceholder.typicode.com/users')
//   .then((response) => response.json())
//   .then((data) => console.log(data))
//   // 에러 처리
//   .catch((err) => console.log(err));
