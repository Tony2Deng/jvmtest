package com.tony.test.oom;

/**
 */
public class StackSizeOut {
    private static int stackDeep = 1;

    public static void stackLeak() {
        long mun1, mun2, mun3, mun4, mun5, mun6, mun7, mun8, mun9, mun10,
             mun11, mun12, mun13, mun14, mun15, mun16, mun17, mun18, mun19, mun20,
             mun21, mun22, mun23, mun24, mun25, mun26, mun27, mun28, mun29, mun30,
             mun31, mun32, mun33, mun34, mun35, mun36, mun37, mun38, mun39, mun40,
             mun41, mun42, mun43, mun44, mun45, mun46, mun47, mun48, mun49, mun50,
             mun51, mun52, mun53, mun54, mun55, mun56, mun57, mun58, mun59, mun60,
             mun61, mun62, mun63, mun64, mun65, mun66, mun67, mun68, mun69, mun70,
             mun71, mun72, mun73, mun74, mun75, mun76, mun77, mun78, mun79, mun80,
             mun81, mun82, mun83, mun84, mun85, mun86, mun87, mun88, mun89, mun90,
             mun91, mun92, mun93, mun94, mun95, mun96, mun97, mun98, mun99, mun100;
        stackDeep++;
        stackLeak();

        mun1 = mun2 = mun3 = mun4 = mun5 = mun6 = mun7 = mun8 = mun9 = mun10 =
                mun11 = mun12 = mun13 = mun14 = mun15 = mun16 = mun17 = mun18 = mun19 = mun20 =
                        mun21 = mun22 = mun23 = mun24 = mun25 = mun26 = mun27 = mun28 = mun29 = mun30 =
                                mun31 = mun32 = mun33 = mun34 = mun35 = mun36 = mun37 = mun38 = mun39 = mun40 =
                                        mun41 = mun42 = mun43 = mun44 = mun45 = mun46 = mun47 = mun48 = mun49 = mun50 =
                                                mun51 = mun52 = mun53 = mun54 = mun55 = mun56 = mun57 = mun58 = mun59 = mun60 =
                                                        mun61 = mun62 = mun63 = mun64 = mun65 = mun66 = mun67 = mun68 = mun69 = mun70 =
                                                                mun71 = mun72 = mun73 = mun74 = mun75 = mun76 = mun77 = mun78 = mun79 = mun80 =
                                                                        mun81 = mun82 = mun83 = mun84 = mun85 = mun86 = mun87 = mun88 = mun89 = mun90 =
                                                                                mun91 = mun92 = mun93 = mun94 = mun95 = mun96 = mun97 = mun98 = mun99 = mun100 = 0;
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Error e) {
            System.out.println("deep:" + stackDeep);
            throw e;
        }
    }

/*
deep:6241
Exception in thread "main" java.lang.StackOverflowError
	at com.tony.test.oom.StackSizeOut.stackLeak(StackSizeOut.java:20)
	at com.tony.test.oom.StackSizeOut.stackLeak(StackSizeOut.java:20)
	at com.tony.test.oom.StackSizeOut.stackLeak(StackSizeOut.java:20)
	at com.tony.test.oom.StackSizeOut.stackLeak(StackSizeOut.java:20)
	at com.tony.test.oom.StackSizeOut.stackLeak(StackSizeOut.java:20)
	at com.tony.test.oom.StackSizeOut.stackLeak(StackSizeOut.java:20)

*/

}
