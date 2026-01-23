package p007b.p225i.p226a.p242c.p265v2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;

/* JADX INFO: renamed from: b.i.a.c.v2.g, reason: use source file name */
/* JADX INFO: compiled from: DecoderReuseEvaluation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DecoderReuseEvaluation {

    /* JADX INFO: renamed from: a */
    public final String f7926a;

    /* JADX INFO: renamed from: b */
    public final Format2 f7927b;

    /* JADX INFO: renamed from: c */
    public final Format2 f7928c;

    /* JADX INFO: renamed from: d */
    public final int f7929d;

    /* JADX INFO: renamed from: e */
    public final int f7930e;

    public DecoderReuseEvaluation(String str, Format2 format2, Format2 format22, int i, int i2) {
        AnimatableValueParser.m531j(i == 0 || i2 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f7926a = str;
        Objects.requireNonNull(format2);
        this.f7927b = format2;
        this.f7928c = format22;
        this.f7929d = i;
        this.f7930e = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DecoderReuseEvaluation.class != obj.getClass()) {
            return false;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
        return this.f7929d == decoderReuseEvaluation.f7929d && this.f7930e == decoderReuseEvaluation.f7930e && this.f7926a.equals(decoderReuseEvaluation.f7926a) && this.f7927b.equals(decoderReuseEvaluation.f7927b) && this.f7928c.equals(decoderReuseEvaluation.f7928c);
    }

    public int hashCode() {
        return this.f7928c.hashCode() + ((this.f7927b.hashCode() + outline.m863m(this.f7926a, (((this.f7929d + 527) * 31) + this.f7930e) * 31, 31)) * 31);
    }
}
