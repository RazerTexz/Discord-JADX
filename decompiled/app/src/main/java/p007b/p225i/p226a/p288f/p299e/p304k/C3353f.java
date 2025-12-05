package p007b.p225i.p226a.p288f.p299e.p304k;

import androidx.annotation.RecentlyNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.k.f */
/* loaded from: classes3.dex */
public final class C3353f {
    public C3353f(@RecentlyNonNull String str) {
        AnimatableValueParser.m595z(str, "log tag cannot be null");
        AnimatableValueParser.m547n(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
    }
}
