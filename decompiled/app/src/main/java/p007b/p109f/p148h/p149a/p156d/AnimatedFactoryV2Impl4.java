package p007b.p109f.p148h.p149a.p156d;

import android.graphics.Rect;
import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableBackend;
import p007b.p109f.p161j.p162a.p163a.AnimatedImageResult;
import p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendImpl;
import p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendProvider;
import p007b.p109f.p161j.p162a.p166d.AnimatedDrawableUtil;

/* compiled from: AnimatedFactoryV2Impl.java */
/* renamed from: b.f.h.a.d.c, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatedFactoryV2Impl4 implements AnimatedDrawableBackendProvider {

    /* renamed from: a */
    public final /* synthetic */ AnimatedFactoryV2Impl f3550a;

    public AnimatedFactoryV2Impl4(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        this.f3550a = animatedFactoryV2Impl;
    }

    @Override // p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendProvider
    /* renamed from: a */
    public AnimatedDrawableBackend mo1164a(AnimatedImageResult animatedImageResult, Rect rect) {
        AnimatedFactoryV2Impl animatedFactoryV2Impl = this.f3550a;
        if (animatedFactoryV2Impl.f19537g == null) {
            animatedFactoryV2Impl.f19537g = new AnimatedDrawableUtil();
        }
        return new AnimatedDrawableBackendImpl(animatedFactoryV2Impl.f19537g, animatedImageResult, rect, animatedFactoryV2Impl.f19534d);
    }
}
