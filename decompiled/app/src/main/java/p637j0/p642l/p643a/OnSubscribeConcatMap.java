package p637j0.p642l.p643a;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p637j0.p642l.p643a.OnSubscribeConcatMap2;
import p658rx.Producer;

/* compiled from: OnSubscribeConcatMap.java */
/* renamed from: j0.l.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public class OnSubscribeConcatMap implements Producer {

    /* renamed from: j */
    public final /* synthetic */ OnSubscribeConcatMap2.c f26790j;

    public OnSubscribeConcatMap(OnSubscribeConcatMap2 onSubscribeConcatMap2, OnSubscribeConcatMap2.c cVar) {
        this.f26790j = cVar;
    }

    @Override // p658rx.Producer
    /* renamed from: j */
    public void mo10704j(long j) {
        OnSubscribeConcatMap2.c cVar = this.f26790j;
        Objects.requireNonNull(cVar);
        if (j > 0) {
            cVar.f26822m.mo10704j(j);
        } else if (j < 0) {
            throw new IllegalArgumentException(outline.m877t("n >= 0 required but it was ", j));
        }
    }
}
