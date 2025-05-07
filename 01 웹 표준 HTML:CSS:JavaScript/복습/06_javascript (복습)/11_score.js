/**
 * 성적 관리 프로그램
 *
 * 90-100점: A
 * 80-89점: B
 * 70-79점: C
 * 60-69점: D
 * 60점 미만(59점 이하): F
 */

let score = 101;

if (score >= 90) {
  console.log('A학점입니다.');
} else if (score >= 80) {
  console.log('B학점입니다.');
} else if (score >= 70) {
  console.log('C학점입니다.');
} else if (score >= 60) {
  console.log('D학점입니다.');
} else {
  console.log('F학점입니다.');
}
