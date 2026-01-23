package p007b.p225i.p226a.p242c.p245b3.p250r;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.b3.r.b, reason: use source file name */
/* JADX INFO: compiled from: SsaDialogueFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SsaDialogueFormat {

    /* JADX INFO: renamed from: a */
    public final int f5992a;

    /* JADX INFO: renamed from: b */
    public final int f5993b;

    /* JADX INFO: renamed from: c */
    public final int f5994c;

    /* JADX INFO: renamed from: d */
    public final int f5995d;

    /* JADX INFO: renamed from: e */
    public final int f5996e;

    public SsaDialogueFormat(int i, int i2, int i3, int i4, int i5) {
        this.f5992a = i;
        this.f5993b = i2;
        this.f5994c = i3;
        this.f5995d = i4;
        this.f5996e = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    @Nullable
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SsaDialogueFormat m2672a(String str) {
        byte b2;
        AnimatableValueParser.m531j(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String strM4349u1 = C3404f.m4349u1(strArrSplit[i5].trim());
            strM4349u1.hashCode();
            switch (strM4349u1.hashCode()) {
                case 100571:
                    b2 = strM4349u1.equals("end") ? (byte) 0 : (byte) -1;
                    break;
                case 3556653:
                    if (strM4349u1.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                        b2 = 1;
                        break;
                    }
                    break;
                case 109757538:
                    if (strM4349u1.equals("start")) {
                        b2 = 2;
                        break;
                    }
                    break;
                case 109780401:
                    if (strM4349u1.equals("style")) {
                        b2 = 3;
                        break;
                    }
                    break;
            }
            if (b2 == 0) {
                i2 = i5;
            } else if (b2 == 1) {
                i4 = i5;
            } else if (b2 == 2) {
                i = i5;
            } else if (b2 == 3) {
                i3 = i5;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new SsaDialogueFormat(i, i2, i3, i4, strArrSplit.length);
    }
}
