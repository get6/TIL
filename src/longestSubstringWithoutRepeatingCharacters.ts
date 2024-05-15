export function lengthOfLongestSubstring(s: string): number {
  const lastSeen: { [key: string]: number } = {};
  let maxLength = 0;
  let start = 0; // 중복이 발생한 문자열의 시작 인덱스 + 1

  for (let end = 0; end < s.length; end++) {
    const currentChar = s[end];
    // lastSeen에 해당 문자열이 있고 start보다 크거나 같다면 start를 lastSeen[currentChar] + 1로 설정
    if (currentChar in lastSeen && lastSeen[currentChar] >= start) {
      start = lastSeen[currentChar] + 1;
    }
    lastSeen[currentChar] = end;
    // 현재까지의 문자열 길이(end - start + 1)와 maxLength 중 큰 값을 maxLength로 설정
    maxLength = Math.max(maxLength, end - start + 1);
  }

  return maxLength;
}

// 다른 사람의 풀이
// export function lengthOfLongestSubstring(s: string): number {
//   const arr: string[] = [];
//   let len = 0;

//   for (const c of s) {
//     const index = arr.indexOf(c);
//     if (index !== -1) {
//       arr.splice(0, index + 1);
//     }
//     arr.push(c);
//     len = Math.max(len, arr.length);
//   }
//   return len;
// }
