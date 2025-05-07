/**
 *구구단 프로그램

 2단 - 9단
 */
for (let dan = 2; dan <= 9; dan++) {
  console.log(dan, '단');
  console.log('------------------');
  for (let i = 0; i <= 9; i++) {
    console.log(dan, '*', i, '=', dan * i);
  }
  console.log('------------------');
}
