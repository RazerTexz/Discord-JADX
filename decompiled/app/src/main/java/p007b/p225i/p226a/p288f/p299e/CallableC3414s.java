package p007b.p225i.p226a.p288f.p299e;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p299e.p308o.C3399a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3402d;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.s */
/* loaded from: classes3.dex */
public final /* synthetic */ class CallableC3414s implements Callable {

    /* renamed from: j */
    public final boolean f9608j;

    /* renamed from: k */
    public final String f9609k;

    /* renamed from: l */
    public final AbstractBinderC3419x f9610l;

    public CallableC3414s(boolean z2, String str, AbstractBinderC3419x abstractBinderC3419x) {
        this.f9608j = z2;
        this.f9609k = str;
        this.f9610l = abstractBinderC3419x;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean z2 = this.f9608j;
        String str = this.f9609k;
        AbstractBinderC3419x abstractBinderC3419x = this.f9610l;
        Object[] objArr = new Object[5];
        objArr[0] = true != (!z2 && C3255b0.m4016b(str, abstractBinderC3419x, true, false).f9320b) ? "not allowed" : "debug cert rejected";
        objArr[1] = str;
        MessageDigest messageDigestM4185a = C3399a.m4185a(Constants.SHA1);
        Objects.requireNonNull(messageDigestM4185a, "null reference");
        byte[] bArrDigest = messageDigestM4185a.digest(abstractBinderC3419x.mo4379g());
        int length = bArrDigest.length;
        char[] cArr = new char[length + length];
        int i = 0;
        for (byte b2 : bArrDigest) {
            int i2 = b2 & 255;
            int i3 = i + 1;
            char[] cArr2 = C3402d.f9586b;
            cArr[i] = cArr2[i2 >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        objArr[2] = new String(cArr);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = "12451000.false";
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", objArr);
    }
}
