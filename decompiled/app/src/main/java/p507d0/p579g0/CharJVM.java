package p507d0.p579g0;

import kotlin.ranges.Ranges2;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: d0.g0.a, reason: use source file name */
/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class CharJVM {
    public static final int checkRadix(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        StringBuilder sbM834V = outline.m834V("radix ", i, " was not in valid range ");
        sbM834V.append(new Ranges2(2, 36));
        throw new IllegalArgumentException(sbM834V.toString());
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
