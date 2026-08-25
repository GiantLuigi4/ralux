// https://en.wikipedia.org/wiki/Quadruple-precision_floating-point_format
// sign: 1bit
// exponent: 15 bit
// Significand precision: 113 bit

struct fp128 {
    int64_t high;
    int64_t low;
};

__int128 __fixtfti(struct fp128 floatingPoint) {
    printf("High: %lld\n", floatingPoint.high);
    printf("Low: %lld\n", floatingPoint.low);

    uint16_t exponent = (uint16_t) (floatingPoint.high >> 48);
    bool negative = (exponent & 0x8000) != 0;
    exponent = exponent & 0x7FFF;
    __int128 fraction = (((__int128) (floatingPoint.high & 0xFFFFFFFFFFFFULL)) << 64) + (uint64_t)floatingPoint.low;

    if (exponent == 0) return 0;

    // NaN
    if (exponent == 0x7FFF) {
        return 0;
    }

    __int128 M = ((__int128)1 << 112) | fraction;
    int32_t fexponent = (((int32_t)exponent) - 16383);

    __int128 V;
    if (fexponent >= 112) {
        int shift = fexponent - 112;
        if (shift >= 127) V = ((__int128)1 << 127) ;
        else V = M << shift;
    } else {
        int shift = 112 - fexponent;
        V = (shift >= 112) ? 0 : (M >> shift);
    }

    if (negative) {
        const __int128 LIMIT = ((__int128)1 << 127);
        if (V >= LIMIT) {
            return -(LIMIT + 1);
        }
        V *= -1;
    }

    return V;
}
