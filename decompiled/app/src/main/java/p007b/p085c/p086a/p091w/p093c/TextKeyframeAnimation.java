package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p095y.DocumentData;

/* compiled from: TextKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.n, reason: use source file name */
/* loaded from: classes.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        return (DocumentData) keyframe.f2317b;
    }
}
