function solution(name, yearning, photo) {
  let answer = [];
  let tmp = new Map();
  for (let i = 0; i < name.length; i++) {
    tmp.set(name[i], yearning[i]);
  }

  for (let i = 0; i < photo.length; i++) {
    let tmpNum = 0;
    for (let j = 0; j < photo[i].length; j++) {
      tmp.has(photo[i][j]) ? (tmpNum += tmp.get(photo[i][j])) : (tmpNum += 0);
    }
    answer.push(tmpNum);
  }

  return answer;
}