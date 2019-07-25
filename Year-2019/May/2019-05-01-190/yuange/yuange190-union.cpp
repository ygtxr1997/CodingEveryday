// 娱乐一下，颇有游戏引擎程序的感觉
class Solution {
    typedef struct BITS{
        uint32_t a01:1; uint32_t a02:1;uint32_t a03:1;uint32_t a04:1;uint32_t a05:1;uint32_t a06:1;uint32_t a07:1;uint32_t a08:1;uint32_t a09:1;uint32_t a10:1;uint32_t a11:1;uint32_t a12:1;uint32_t a13:1;uint32_t a14:1;uint32_t a15:1;uint32_t a16:1;uint32_t b16:1;uint32_t b15:1;uint32_t b14:1;uint32_t b13:1;uint32_t b12:1;uint32_t b11:1;uint32_t b10:1;uint32_t b09:1;uint32_t b08:1;uint32_t b07:1;uint32_t b06:1;uint32_t b05:1;uint32_t b04:1;uint32_t b03:1;uint32_t b02:1;uint32_t b01:1;
    } BITS;
    union Union
    {
        BITS bf;
        unsigned int num;
    };
public:
    uint32_t reverseBits(uint32_t n) {
        union Union un1, un2;
        un1.num = n;
        un2.bf.a01 = un1.bf.b01;un2.bf.a02 = un1.bf.b02;un2.bf.a03 = un1.bf.b03;un2.bf.a04 = un1.bf.b04;un2.bf.a05 = un1.bf.b05;un2.bf.a06 = un1.bf.b06;un2.bf.a07 = un1.bf.b07;un2.bf.a08 = un1.bf.b08;un2.bf.a09 = un1.bf.b09;un2.bf.a10 = un1.bf.b10;un2.bf.a11 = un1.bf.b11;un2.bf.a12 = un1.bf.b12;un2.bf.a13 = un1.bf.b13;un2.bf.a14 = un1.bf.b14;un2.bf.a15 = un1.bf.b15;un2.bf.a16 = un1.bf.b16;un2.bf.b01 = un1.bf.a01;un2.bf.b02 = un1.bf.a02;un2.bf.b03 = un1.bf.a03;un2.bf.b04 = un1.bf.a04;un2.bf.b05 = un1.bf.a05;un2.bf.b06 = un1.bf.a06;un2.bf.b07 = un1.bf.a07;un2.bf.b08 = un1.bf.a08;un2.bf.b09 = un1.bf.a09;un2.bf.b10 = un1.bf.a10;un2.bf.b11 = un1.bf.a11;un2.bf.b12 = un1.bf.a12;un2.bf.b13 = un1.bf.a13;un2.bf.b14 = un1.bf.a14;un2.bf.b15 = un1.bf.a15;un2.bf.b16 = un1.bf.a16;
        return un2.num;
    }
};
