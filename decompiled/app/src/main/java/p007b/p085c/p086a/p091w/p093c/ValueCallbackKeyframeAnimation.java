package p007b.p085c.p086a.p091w.p093c;

import androidx.annotation.Nullable;
import java.util.Collections;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;

/* JADX INFO: renamed from: b.c.a.w.c.p, reason: use source file name */
/* JADX INFO: compiled from: ValueCallbackKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {

    /* JADX INFO: renamed from: i */
    public final A f2641i;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, @Nullable A a) {
        super(Collections.emptyList());
        this.f2600e = lottieValueCallback;
        this.f2641i = a;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: b */
    public float mo724b() {
        return 1.0f;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: e */
    public A mo727e() {
        LottieValueCallback<A> lottieValueCallback = this.f2600e;
        A a = this.f2641i;
        float f = this.f2599d;
        return lottieValueCallback.m668a(0.0f, 0.0f, a, a, f, f, f);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: f */
    public A mo728f(Keyframe<K> keyframe, float f) {
        return mo727e();
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: g */
    public void mo729g() {
        if (this.f2600e != null) {
            super.mo729g();
        }
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: h */
    public void mo730h(float f) {
        this.f2599d = f;
    }
}
