package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.x.d, reason: use source file name */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class SizeSelectors implements SizeSelectors7 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ float f14253a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ float f14254b;

    public SizeSelectors(float f, float f2) {
        this.f14253a = f;
        this.f14254b = f2;
    }

    @Override // p007b.p452o.p453a.p473x.SizeSelectors7
    /* JADX INFO: renamed from: a */
    public boolean mo4369a(@NonNull Size3 size3) {
        float fM7450i = AspectRatio2.m7447f(size3.f14251j, size3.f14252k).m7450i();
        float f = this.f14253a;
        float f2 = this.f14254b;
        return fM7450i >= f - f2 && fM7450i <= f + f2;
    }
}
