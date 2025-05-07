let p = new Promise((resolve, reject) => {
  resolve('first!');
});

p.then((msg) => {
  console.log(msg);
  //   throw new Error('## 애러!');
  return 'second';
})
  .then((msg) => {
    console.log(msg);
    return 'third';
  })
  .then((msg) => {
    console.log(msg);
  })
  .catch((error) => {
    console.log('오류 발생==> ' + error);
  });
