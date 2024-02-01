package com.tony.test.classloader.remote_exec;

public class ClassModifier {
    // 常量池起始偏移量
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    // CONSTANT_UTF8_INFO的起始标志
    private static final int CONSTANT_UTF8_INFO_TAG = 1;

    // 常量池1种常量所占长度，CONSTANT_UTF8_INFO不定长除外
    private static final int[] CONSTANT_INFO_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    private static final int U1 = 1;

    private static final int U2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }

    /**
     * 修改常量池中指定CONSTANT_UTF8_INFO值为oldStr内容为newStr
     */
    public byte[] modifyUtf8Constant(String oldStr, String newStr) {
        int cpc = getConstantPoolSize();
        int offset = CONSTANT_POOL_COUNT_INDEX + U2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.byte2Int(classByte, offset, U1);
            if (tag == CONSTANT_UTF8_INFO_TAG) {
                int len = ByteUtils.byte2Int(classByte, offset + U1, U2);
                offset += (U1 + U2);
                String str = ByteUtils.byte2Str(classByte, offset, len);
                if (oldStr.equalsIgnoreCase(str)) {
                    byte[] strBytes = ByteUtils.str2Bytes(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(), U2);
                    classByte = ByteUtils.byteRepalce(classByte, offset -U2, U2, strLen);
                    classByte = ByteUtils.byteRepalce(classByte, offset, len, strBytes);
                    return classByte;
                } else {
                    offset += len;
                }
            } else {
                offset += CONSTANT_INFO_LENGTH[tag];
            }
        }
        return classByte;
    }

    public int getConstantPoolSize() {
        return ByteUtils.byte2Int(classByte, CONSTANT_POOL_COUNT_INDEX, U2);
    }
}
