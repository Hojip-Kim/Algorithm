// 빈 병 a개 => 콜라 b병을 줌.
// n개를 주면 몇개를 받을수있는지 return answer

//2 1 20
function solution(a, b, n) {
  let answer = 0;
  while (n >= a) {
    answer += Math.floor(n / a) * b;
    n = Math.floor(n / a) * b + (n % a);
  }

  return answer;
}
