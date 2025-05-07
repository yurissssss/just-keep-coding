/**
 * 성적 관리 프로그램
 *
 * 90-100점: A
 * 80-89점: B
 * 70-79점: C
 * 60-69점: D
 * 60점 미만(59점 이하): F
 */

let score = 89; // 점수를 입력 받기 위한 변수

if (score >= 90 && score <= 100) {
  console.log('A학점입니다.');
}
if (score >= 80 && score <= 89) {
  console.log('B학점입니다.');
}
if (score >= 70 && score <= 79) {
  console.log('C학점입니다.');
}
if (score >= 60 && score <= 69) {
  console.log('D학점입니다.');
}
if (score < 60) {
  console.log('F학점입니다.');
}
