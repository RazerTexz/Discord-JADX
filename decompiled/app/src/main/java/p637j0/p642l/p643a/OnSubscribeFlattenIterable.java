package p637j0.p642l.p643a;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.OnSubscribeFlattenIterable2;
import p658rx.Producer;

/* compiled from: OnSubscribeFlattenIterable.java */
/* renamed from: j0.l.a.m, reason: use source file name */
/* loaded from: classes3.dex */
public class OnSubscribeFlattenIterable implements Producer {

    /* renamed from: j */
    public final /* synthetic */ OnSubscribeFlattenIterable2.a f26909j;

    public OnSubscribeFlattenIterable(OnSubscribeFlattenIterable2 onSubscribeFlattenIterable2, OnSubscribeFlattenIterable2.a aVar) {
        this.f26909j = aVar;
    }

    @Override // p658rx.Producer
    /* renamed from: j */
    public void mo10704j(long j) {
        OnSubscribeFlattenIterable2.a aVar = this.f26909j;
        Objects.requireNonNull(aVar);
        if (j > 0) {
            C3404f.m4276c0(aVar.f26924o, j);
            aVar.m10773b();
        } else if (j < 0) {
            throw new IllegalStateException(outline.m877t("n >= 0 required but it was ", j));
        }
    }
}
