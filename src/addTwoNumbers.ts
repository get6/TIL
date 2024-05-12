export class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

export function addTwoNumbers(
  l1: ListNode | null,
  l2: ListNode | null
): ListNode | null {
  let carry = 0;
  const dummyHead = new ListNode();
  let curr = dummyHead;
  while (l1 || l2) {
    const sum = (l1?.val || 0) + (l2?.val || 0) + carry;
    carry = Math.floor(sum / 10);
    curr.next = new ListNode(sum % 10);
    curr = curr.next;
    l1 = l1 ? l1.next : null;
    l2 = l2 ? l2.next : null;
  }
  if (carry) {
    curr.next = new ListNode(carry);
  }
  return dummyHead.next;
}
