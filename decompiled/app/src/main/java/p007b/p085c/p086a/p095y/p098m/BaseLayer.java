package p007b.p085c.p086a.p095y.p098m;

import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;

/* compiled from: BaseLayer.java */
/* renamed from: b.c.a.y.m.a, reason: use source file name */
/* loaded from: classes.dex */
public class BaseLayer implements BaseKeyframeAnimation.b {

    /* renamed from: a */
    public final /* synthetic */ BaseLayer2 f2835a;

    public BaseLayer(BaseLayer2 baseLayer2) {
        this.f2835a = baseLayer2;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* renamed from: a */
    public void mo709a() {
        BaseLayer2 baseLayer2 = this.f2835a;
        boolean z2 = baseLayer2.f2852q.m739j() == 1.0f;
        if (z2 != baseLayer2.f2858w) {
            baseLayer2.f2858w = z2;
            baseLayer2.f2849n.invalidateSelf();
        }
    }
}
