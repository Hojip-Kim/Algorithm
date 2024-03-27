function solution(absolutes, signs) {
  let answer = 0;

  for (let i = 0; i < signs.length; i++) {
    signs[i] ? (absolutes[i] = absolutes[i]) : (absolutes[i] = -absolutes[i]);
  }

  absolutes.map((e) => (answer += e));

  return answer;
}