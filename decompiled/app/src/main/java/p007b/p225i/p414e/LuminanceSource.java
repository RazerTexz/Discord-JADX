package p007b.p225i.p414e;

import com.discord.widgets.chat.input.MentionUtils;

/* compiled from: LuminanceSource.java */
/* renamed from: b.i.e.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LuminanceSource {

    /* renamed from: a */
    public final int f13186a;

    /* renamed from: b */
    public final int f13187b;

    public LuminanceSource(int i, int i2) {
        this.f13186a = i;
        this.f13187b = i2;
    }

    /* renamed from: a */
    public abstract byte[] mo6915a();

    /* renamed from: b */
    public abstract byte[] mo6916b(int i, byte[] bArr);

    /* renamed from: c */
    public boolean mo6917c() {
        return false;
    }

    /* renamed from: d */
    public LuminanceSource mo6918d() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.f13186a;
        byte[] bArrMo6916b = new byte[i];
        StringBuilder sb = new StringBuilder((i + 1) * this.f13187b);
        for (int i2 = 0; i2 < this.f13187b; i2++) {
            bArrMo6916b = mo6916b(i2, bArrMo6916b);
            for (int i3 = 0; i3 < this.f13186a; i3++) {
                int i4 = bArrMo6916b[i3] & 255;
                sb.append(i4 < 64 ? MentionUtils.CHANNELS_CHAR : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
