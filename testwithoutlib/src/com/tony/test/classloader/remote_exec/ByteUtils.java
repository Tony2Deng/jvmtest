package com.tony.test.classloader.remote_exec;

public class ByteUtils {
    // 返回从起始到后面len个字节的int值
    public static int byte2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum += n;
        }
        return sum;
    }

    public static String byte2Str(byte[] b, int offset, int len) {
        return new String(b, offset, len);
    }

    public static byte[] str2Bytes(String str) {
        return str.getBytes();
    }

    public static byte[] int2Bytes(int value, int len) {
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return bytes;
    }

    public static byte[] byteRepalce(byte[] b, int offset, int oldLen, byte[] newBytes) {
        byte[] result = new byte[b.length + newBytes.length - oldLen];
        System.arraycopy(b, 0, result, 0, offset);
        System.arraycopy(newBytes, 0, result, offset, newBytes.length);
        System.arraycopy(b, offset + oldLen, result, offset + newBytes.length, b.length - offset -oldLen);
        return result;
    }
}
