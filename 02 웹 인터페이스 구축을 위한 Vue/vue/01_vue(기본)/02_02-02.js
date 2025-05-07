let msg = 'GLOBAL';
function outer() {
  let msg = 'OUTER';
  console.log(msg); // OUTER
  if (true) {
    let msg = 'BLOCK';
    console.log(msg); // BLOCK
  }
}
outer();
