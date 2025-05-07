/**
 *구구단 프로그램

 2단 - 9단
 */
let dan = 2;
while (dan <= 9) {
  console.log(dan, '단');
  console.log('------------------');
  let i = 0;
  while (i <= 9) {
    console.log(dan, '*', i, '=', dan * i);
    i++;
  }
  console.log('------------------');
  dan++;
}
