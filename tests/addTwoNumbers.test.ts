import { ListNode, addTwoNumbers } from '../src/addTwoNumbers';

test('addTwoNumbers', () => {
  const l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
  const l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
  const result = addTwoNumbers(l1, l2);
  expect(result).toEqual(new ListNode(7, new ListNode(0, new ListNode(8))));
});
