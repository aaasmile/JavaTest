# OnlyOneNum
## 所有元素都是成对的，只有一个元素是单一的，求问如何在O(N)的复杂度里面找出这个元素
> 思路很简单，直接累异或就好了
---
## 拓展
### 如果有两个元素是单一的
> 思路是将元素分为两组，每组都有一个单一的元素，则通过同理一步就OK了。  
> 问题是怎样才能将两个单一元素分为两组呢？

首先重复第一步操作，因为有两个独立的元素，那么结果中所有位上至少有一个为1，那么我们就可以将这个位上为1的分为一组，为0的分为一组。  
举个例子，`[2,2,3,4,3,5]`，4的二进制为`0100`，5的二进制为`0101`，最终异或的结果为`0001`，那么从右数第一位上为1的分为一组`[3,4,3]`，为0的分为一组`[2,2,5]`。然后结果就出来了，至于怎么分组，很简单，我就不解释了。  
---
### 如果所有元素不是成对，而是奇数，比如三对三对出现
> 这样子就不能按之前的方法去做了。我们可以这么想，假如都是成三对出现的，那么除去独立的元素，所有成对的元素按位累加，那么每位的个数都是3n。所以我们把所有元素按位累加，哪一位上的数是3n±1，就是这个独立元素的。