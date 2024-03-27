function solution(x) {
  let answer = true;

  let arr = String(x).split('');

  let sum = 0;

  arr.map((e) => (sum += Number(e)));

  return x % sum === 0 ? true : false;
}
