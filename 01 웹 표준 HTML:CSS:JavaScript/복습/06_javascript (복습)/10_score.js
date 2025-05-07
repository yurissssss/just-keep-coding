/**
 * 성적관리 프로그램
 *
 * 90~100점: A
 * 80~89점: B
 * 70~79점: C
 * 60~69점: D
 * 60점 미만(59점이하): F
 */

let score = 101; // B학점입니다.

if (score >= 90 && score <= 100) {
  console.log('A 학점입니다.');
} else {
  if (score >= 80) {
    console.log('B 학점입니다.');
  } else {
    if (score >= 70) {
      console.log('C 학점입니다.');
    } else {
      if (score >= 60) {
        console.log('D 학점입니다.');
      } else {
        console.log('F 학점입니다.');
      }
    }
  }
}
