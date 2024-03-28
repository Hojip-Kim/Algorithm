function solution(k, score) {
  let answer = [];
  let tmp = [];

  if (k < score.length) {
    for (let i = 0; i < k; i++) {
      tmp.push(score[i]);
      answer.push(Math.min(...tmp));
    }

    for (let i = k; i < score.length; i++) {
      if (score[i] > Math.min(...tmp)) {
        tmp[tmp.indexOf(Math.min(...tmp))] = score[i];
      }
      answer.push(Math.min(...tmp));
    }
  } else {
    for (let i = 0; i < score.length; i++) {
      tmp.push(score[i]);
      answer.push(Math.min(...tmp));
    }
  }
  return answer;
}
