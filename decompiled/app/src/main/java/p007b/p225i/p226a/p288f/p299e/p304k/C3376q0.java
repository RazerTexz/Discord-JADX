package p007b.p225i.p226a.p288f.p299e.p304k;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.k.q0 */
/* loaded from: classes3.dex */
public final class C3376q0 {

    /* renamed from: a */
    public static final Uri f9546a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: b */
    @Nullable
    public final String f9547b;

    /* renamed from: c */
    @Nullable
    public final String f9548c;

    /* renamed from: d */
    public final int f9549d;

    /* renamed from: e */
    public final boolean f9550e;

    public C3376q0(String str, String str2, int i, boolean z2) {
        AnimatableValueParser.m583w(str);
        this.f9547b = str;
        AnimatableValueParser.m583w(str2);
        this.f9548c = str2;
        this.f9549d = i;
        this.f9550e = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3376q0)) {
            return false;
        }
        C3376q0 c3376q0 = (C3376q0) obj;
        return AnimatableValueParser.m524h0(this.f9547b, c3376q0.f9547b) && AnimatableValueParser.m524h0(this.f9548c, c3376q0.f9548c) && AnimatableValueParser.m524h0(null, null) && this.f9549d == c3376q0.f9549d && this.f9550e == c3376q0.f9550e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9547b, this.f9548c, null, Integer.valueOf(this.f9549d), Boolean.valueOf(this.f9550e)});
    }

    public final String toString() {
        String str = this.f9547b;
        if (str != null) {
            return str;
        }
        Objects.requireNonNull((Object) null, "null reference");
        throw null;
    }
}
