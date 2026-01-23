package p007b.p225i.p226a.p242c.p267x2.p274i0;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.n, reason: use source file name */
/* JADX INFO: compiled from: TrackEncryptionBox.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackEncryptionBox {

    /* JADX INFO: renamed from: a */
    public final boolean f8471a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f8472b;

    /* JADX INFO: renamed from: c */
    public final TrackOutput2.a f8473c;

    /* JADX INFO: renamed from: d */
    public final int f8474d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final byte[] f8475e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TrackEncryptionBox(boolean z2, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        byte b2 = 0;
        int i4 = 1;
        AnimatableValueParser.m531j((i == 0) ^ (bArr2 == null));
        this.f8471a = z2;
        this.f8472b = str;
        this.f8474d = i;
        this.f8475e = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (!str.equals("cbc1")) {
                        b2 = -1;
                    }
                    break;
                case 3046671:
                    if (str.equals("cbcs")) {
                        b2 = 1;
                        break;
                    }
                    break;
                case 3049879:
                    if (str.equals("cenc")) {
                        b2 = 2;
                        break;
                    }
                    break;
                case 3049895:
                    if (str.equals("cens")) {
                        b2 = 3;
                        break;
                    }
                    break;
            }
            if (b2 == 0 || b2 == 1) {
                i4 = 2;
            } else if (b2 != 2 && b2 != 3) {
                outline.m856i0(str.length() + 68, "Unsupported protection scheme type '", str, "'. Assuming AES-CTR crypto mode.", "TrackEncryptionBox");
            }
        }
        this.f8473c = new TrackOutput2.a(i4, bArr, i2, i3);
    }
}
