package p007b.p225i.p226a.p242c.p243a3;

import android.util.Pair;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MaskingMediaSource;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.a3.a */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2529a implements MediaSource2.b {

    /* renamed from: a */
    public final /* synthetic */ CompositeMediaSource f5473a;

    /* renamed from: b */
    public final /* synthetic */ Object f5474b;

    public /* synthetic */ C2529a(CompositeMediaSource compositeMediaSource, Object obj) {
        this.f5473a = compositeMediaSource;
        this.f5474b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSource2.b
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo2445a(MediaSource2 mediaSource2, Timeline timeline) {
        MaskingMediaSource.a aVar;
        MediaSource2.a aVarM2460b;
        MaskingMediaSource.a aVar2;
        CompositeMediaSource compositeMediaSource = this.f5473a;
        Object obj = this.f5474b;
        Objects.requireNonNull(compositeMediaSource);
        MaskingMediaSource maskingMediaSource = (MaskingMediaSource) compositeMediaSource;
        if (maskingMediaSource.f5719q) {
            MaskingMediaSource.a aVar3 = maskingMediaSource.f5716n;
            maskingMediaSource.f5716n = new MaskingMediaSource.a(timeline, aVar3.f5722m, aVar3.f5723n);
            MaskingMediaPeriod maskingMediaPeriod = maskingMediaSource.f5717o;
            if (maskingMediaPeriod != null) {
                maskingMediaSource.m2592v(maskingMediaPeriod.f5711p);
            }
        } else {
            if (!timeline.m3331q()) {
                timeline.m3330n(0, maskingMediaSource.f5714l);
                Timeline.c cVar = maskingMediaSource.f5714l;
                long j = cVar.f7365z;
                Object obj2 = cVar.f7353n;
                MaskingMediaPeriod maskingMediaPeriod2 = maskingMediaSource.f5717o;
                if (maskingMediaPeriod2 != null) {
                    long j2 = maskingMediaPeriod2.f5706k;
                    maskingMediaSource.f5716n.mo3327h(maskingMediaPeriod2.f5705j.f5732a, maskingMediaSource.f5715m);
                    long j3 = maskingMediaSource.f5715m.f7342n + j2;
                    long j4 = j3 != maskingMediaSource.f5716n.m3330n(0, maskingMediaSource.f5714l).f7365z ? j3 : j;
                    Pair<Object, Long> pairM3328j = timeline.m3328j(maskingMediaSource.f5714l, maskingMediaSource.f5715m, 0, j4);
                    Object obj3 = pairM3328j.first;
                    long jLongValue = ((Long) pairM3328j.second).longValue();
                    if (maskingMediaSource.f5720r) {
                        MaskingMediaSource.a aVar4 = maskingMediaSource.f5716n;
                        aVar = new MaskingMediaSource.a(timeline, aVar4.f5722m, aVar4.f5723n);
                    } else {
                        aVar = new MaskingMediaSource.a(timeline, obj2, obj3);
                    }
                    maskingMediaSource.f5716n = aVar;
                    MaskingMediaPeriod maskingMediaPeriod3 = maskingMediaSource.f5717o;
                    if (maskingMediaPeriod3 != null) {
                        maskingMediaSource.m2592v(jLongValue);
                        MediaSource2.a aVar5 = maskingMediaPeriod3.f5705j;
                        Object obj4 = aVar5.f5732a;
                        if (maskingMediaSource.f5716n.f5723n != null && obj4.equals(MaskingMediaSource.a.f5721l)) {
                            obj4 = maskingMediaSource.f5716n.f5723n;
                        }
                        aVarM2460b = aVar5.m2460b(obj4);
                    }
                }
                maskingMediaSource.f5720r = true;
                maskingMediaSource.f5719q = true;
                maskingMediaSource.m2553r(maskingMediaSource.f5716n);
                if (aVarM2460b == null) {
                    MaskingMediaPeriod maskingMediaPeriod4 = maskingMediaSource.f5717o;
                    Objects.requireNonNull(maskingMediaPeriod4);
                    maskingMediaPeriod4.m2590d(aVarM2460b);
                    return;
                }
                return;
            }
            if (maskingMediaSource.f5720r) {
                MaskingMediaSource.a aVar6 = maskingMediaSource.f5716n;
                aVar2 = new MaskingMediaSource.a(timeline, aVar6.f5722m, aVar6.f5723n);
            } else {
                aVar2 = new MaskingMediaSource.a(timeline, Timeline.c.f7345j, MaskingMediaSource.a.f5721l);
            }
            maskingMediaSource.f5716n = aVar2;
        }
        aVarM2460b = null;
        maskingMediaSource.f5720r = true;
        maskingMediaSource.f5719q = true;
        maskingMediaSource.m2553r(maskingMediaSource.f5716n);
        if (aVarM2460b == null) {
        }
    }
}
