package p007b.p085c.p086a.p095y.p096k;

import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.TextKeyframeAnimation;
import p007b.p085c.p086a.p095y.DocumentData;

/* JADX INFO: renamed from: b.c.a.y.k.j, reason: use source file name */
/* JADX INFO: compiled from: AnimatableTextFrame.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {
    public AnimatableTextFrame(List<Keyframe<DocumentData>> list) {
        super((List) list);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* JADX INFO: renamed from: a */
    public BaseKeyframeAnimation mo773a() {
        return new TextKeyframeAnimation(this.f2738a);
    }
}
