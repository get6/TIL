import { lengthOfLongestSubstring } from '../src/longestSubstringWithoutRepeatingCharacters';

test('longestSubstringWithoutRepeatingCharacters', () => {
  expect(lengthOfLongestSubstring('abcabcbb')).toBe(3);
  expect(lengthOfLongestSubstring('bbbbb')).toBe(1);
  expect(lengthOfLongestSubstring('pwwkew')).toBe(3);
  expect(lengthOfLongestSubstring('')).toBe(0);
  expect(lengthOfLongestSubstring('dvdf')).toBe(3);
});
