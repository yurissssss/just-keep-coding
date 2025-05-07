/**
 * 성적 관리 프로그램
 *
 * 90-100점: A -> 9,10
 * 80-89점: B -> 8
 * 70-79점: C -> 7
 * 60-69점: D -> 6
 * 60점 미만(59점 이하): F
 */

let score = 71;
score = Math.floor(score / 10);
console.log('score: ', score);

switch (score) {
  case 10:
  case 9:
    console.log('A학점입니다.');
    break;
  case 8:
    console.log('B학점입니다.');
    break;
  case 7:
    console.log('C학점입니다.');
    break;
  case 6:
    console.log('D학점입니다.');
    break;
  default:
    console.log('F학점입니다.');
    break;
}
