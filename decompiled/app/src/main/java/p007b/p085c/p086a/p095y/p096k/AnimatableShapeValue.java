package p007b.p085c.p086a.p095y.p096k;

import android.graphics.Path;
import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ShapeKeyframeAnimation;
import p007b.p085c.p086a.p095y.p097l.ShapeData;

/* compiled from: AnimatableShapeValue.java */
/* renamed from: b.c.a.y.k.h, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super((List) list);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* renamed from: a */
    public BaseKeyframeAnimation<ShapeData, Path> mo773a() {
        return new ShapeKeyframeAnimation(this.f2738a);
    }
}
