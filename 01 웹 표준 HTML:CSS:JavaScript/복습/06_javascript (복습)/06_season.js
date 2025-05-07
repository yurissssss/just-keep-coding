/**
 * 계절 알아맞추기
 * 3,4,5월 : 봄
 * 6,7,8월 : 여름
 * 9,10,11월 : 가을
 * 12,1,2월 : 겨울
 */

// sampling: 작동 잘 하는지 많이 넣어보기

let month = 12; // 월을 입력받기 위한 변수

switch (month) {
  case 3: // value -> 연산 안 됨    연산 되려면 expression
    console.log('봄입니다.');
    break; // default 제외하고는 모두 써줘야 함 -> 안 써주면 : default 만날 때까지 계속 내려감
  case 4:
    console.log('봄입니다.');
    break;
  case 5:
    console.log('봄입니다.');
    break;
  case 6:
    console.log('여름입니다.');
    break;
  case 7:
    console.log('여름입니다.');
    break;
  case 8:
    console.log('여름입니다.');
    break;
  case 9:
    console.log('가을입니다.');
    break;
  case 10:
    console.log('가을입니다.');
    break;
  case 11:
    console.log('가을입니다.');
    break;
  case 12:
    console.log('겨울입니다.');
    break;
  case 1:
    console.log('겨울입니다.');
    break;
  case 2:
    console.log('겨울입니다.');
    break;

  default:
    break;
}
