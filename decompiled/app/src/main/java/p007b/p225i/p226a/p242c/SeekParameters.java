package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: SeekParameters.java */
/* renamed from: b.i.a.c.j2, reason: use source file name */
/* loaded from: classes3.dex */
public final class SeekParameters {

    /* renamed from: a */
    public static final SeekParameters f7189a;

    /* renamed from: b */
    public static final SeekParameters f7190b;

    /* renamed from: c */
    public final long f7191c;

    /* renamed from: d */
    public final long f7192d;

    static {
        SeekParameters seekParameters = new SeekParameters(0L, 0L);
        f7189a = seekParameters;
        AnimatableValueParser.m531j(RecyclerView.FOREVER_NS >= 0);
        AnimatableValueParser.m531j(RecyclerView.FOREVER_NS >= 0);
        AnimatableValueParser.m531j(RecyclerView.FOREVER_NS >= 0);
        AnimatableValueParser.m531j(0 >= 0);
        AnimatableValueParser.m531j(0 >= 0);
        AnimatableValueParser.m531j(RecyclerView.FOREVER_NS >= 0);
        f7190b = seekParameters;
    }

    public SeekParameters(long j, long j2) {
        AnimatableValueParser.m531j(j >= 0);
        AnimatableValueParser.m531j(j2 >= 0);
        this.f7191c = j;
        this.f7192d = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekParameters.class != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        return this.f7191c == seekParameters.f7191c && this.f7192d == seekParameters.f7192d;
    }

    public int hashCode() {
        return (((int) this.f7191c) * 31) + ((int) this.f7192d);
    }
}
