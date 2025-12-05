package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.ScaleXY;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePathValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableScaleValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableSplitDimensionPathValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p096k.AnimatableValue;

/* compiled from: AnimatableTransformParser.java */
/* renamed from: b.c.a.a0.c, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableTransformParser {

    /* renamed from: a */
    public static JsonReader2.a f2213a = JsonReader2.a.m616a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b */
    public static JsonReader2.a f2214b = JsonReader2.a.m616a("k");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c5  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimatableTransform m414a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        AnimatableFloatValue animatableFloatValue;
        AnimatableScaleValue animatableScaleValue;
        boolean z2;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableScaleValue animatableScaleValue2;
        AnimatableFloatValue animatableFloatValue3;
        AnimatableValue<PointF, PointF> animatableValue;
        AnimatableFloatValue animatableFloatValueM565r1;
        AnimatableFloatValue animatableFloatValue4;
        boolean z3 = false;
        boolean z4 = jsonReader2.mo613u() == JsonReader2.b.BEGIN_OBJECT;
        if (z4) {
            jsonReader2.mo604b();
        }
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableScaleValue animatableScaleValue3 = null;
        AnimatableValue<PointF, PointF> animatableValueM412b = null;
        AnimatableFloatValue animatableFloatValueM565r12 = null;
        AnimatableFloatValue animatableFloatValueM565r13 = null;
        AnimatablePathValue animatablePathValueM411a = null;
        AnimatableIntegerValue animatableIntegerValueM569s1 = null;
        AnimatableFloatValue animatableFloatValueM565r14 = null;
        AnimatableFloatValue animatableFloatValueM565r15 = null;
        while (jsonReader2.mo607e()) {
            switch (jsonReader2.mo615y(f2213a)) {
                case 0:
                    animatableScaleValue2 = animatableScaleValue3;
                    animatableFloatValue3 = animatableFloatValueM565r12;
                    animatableValue = animatableValueM412b;
                    jsonReader2.mo604b();
                    while (jsonReader2.mo607e()) {
                        if (jsonReader2.mo615y(f2214b) != 0) {
                            jsonReader2.mo600A();
                            jsonReader2.mo601C();
                        } else {
                            animatablePathValueM411a = AnimatablePathValueParser.m411a(jsonReader2, lottieComposition);
                        }
                    }
                    jsonReader2.mo606d();
                    animatableScaleValue3 = animatableScaleValue2;
                    animatableValueM412b = animatableValue;
                    animatableFloatValueM565r12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 1:
                    animatableFloatValue3 = animatableFloatValueM565r12;
                    animatableValueM412b = AnimatablePathValueParser.m412b(jsonReader2, lottieComposition);
                    animatableFloatValueM565r12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 2:
                    animatableFloatValue3 = animatableFloatValueM565r12;
                    animatableValue = animatableValueM412b;
                    animatableScaleValue3 = new AnimatableScaleValue(AnimatableValueParser.m553o1(jsonReader2, lottieComposition, ScaleXYParser.f2208a));
                    animatableValueM412b = animatableValue;
                    animatableFloatValueM565r12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 3:
                    lottieComposition.m669a("Lottie doesn't support 3D layers.");
                    animatableFloatValueM565r1 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, z3);
                    if (animatableFloatValueM565r1.f2738a.isEmpty()) {
                        animatableFloatValue4 = animatableFloatValueM565r1;
                        animatableScaleValue2 = animatableScaleValue3;
                        animatableFloatValue3 = animatableFloatValueM565r12;
                        animatableValue = animatableValueM412b;
                        if (((Keyframe) animatableFloatValue4.f2738a.get(0)).f2317b == 0) {
                            animatableFloatValue4.f2738a.set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.f2347l)));
                        }
                    } else {
                        animatableFloatValue4 = animatableFloatValueM565r1;
                        animatableScaleValue2 = animatableScaleValue3;
                        animatableFloatValue3 = animatableFloatValueM565r12;
                        animatableValue = animatableValueM412b;
                        animatableFloatValueM565r1.f2738a.add(new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.f2347l)));
                    }
                    animatableFloatValue5 = animatableFloatValue4;
                    animatableScaleValue3 = animatableScaleValue2;
                    animatableValueM412b = animatableValue;
                    animatableFloatValueM565r12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 4:
                    animatableFloatValueM565r1 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, z3);
                    if (animatableFloatValueM565r1.f2738a.isEmpty()) {
                    }
                    animatableFloatValue5 = animatableFloatValue4;
                    animatableScaleValue3 = animatableScaleValue2;
                    animatableValueM412b = animatableValue;
                    animatableFloatValueM565r12 = animatableFloatValue3;
                    z3 = false;
                    break;
                case 5:
                    animatableIntegerValueM569s1 = AnimatableValueParser.m569s1(jsonReader2, lottieComposition);
                    break;
                case 6:
                    animatableFloatValueM565r14 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, z3);
                    break;
                case 7:
                    animatableFloatValueM565r15 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, z3);
                    break;
                case 8:
                    animatableFloatValueM565r13 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, z3);
                    break;
                case 9:
                    animatableFloatValueM565r12 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, z3);
                    break;
                default:
                    animatableFloatValue3 = animatableFloatValueM565r12;
                    jsonReader2.mo600A();
                    jsonReader2.mo601C();
                    animatableFloatValueM565r12 = animatableFloatValue3;
                    z3 = false;
                    break;
            }
        }
        AnimatableScaleValue animatableScaleValue4 = animatableScaleValue3;
        AnimatableFloatValue animatableFloatValue6 = animatableFloatValueM565r12;
        AnimatableValue<PointF, PointF> animatableValue2 = animatableValueM412b;
        if (z4) {
            jsonReader2.mo606d();
        }
        if (animatablePathValueM411a == null || (animatablePathValueM411a.isStatic() && animatablePathValueM411a.f2722a.get(0).f2317b.equals(0.0f, 0.0f))) {
            animatablePathValueM411a = null;
        }
        if (animatableValue2 == null || (!(animatableValue2 instanceof AnimatableSplitDimensionPathValue) && animatableValue2.isStatic() && animatableValue2.mo774b().get(0).f2317b.equals(0.0f, 0.0f))) {
            animatableValue2 = null;
        }
        if (animatableFloatValue5 == null || (animatableFloatValue5.isStatic() && ((Float) ((Keyframe) animatableFloatValue5.f2738a.get(0)).f2317b).floatValue() == 0.0f)) {
            animatableScaleValue = animatableScaleValue4;
            animatableFloatValue = null;
        } else {
            animatableFloatValue = animatableFloatValue5;
            animatableScaleValue = animatableScaleValue4;
        }
        if (animatableScaleValue == null) {
            z2 = true;
        } else {
            if (animatableScaleValue.isStatic()) {
                ScaleXY scaleXY = (ScaleXY) ((Keyframe) animatableScaleValue.f2738a.get(0)).f2317b;
                if (scaleXY.f2334a == 1.0f && scaleXY.f2335b == 1.0f) {
                }
            }
            z2 = false;
        }
        AnimatableScaleValue animatableScaleValue5 = z2 ? null : animatableScaleValue;
        if (animatableFloatValueM565r13 == null || (animatableFloatValueM565r13.isStatic() && ((Float) ((Keyframe) animatableFloatValueM565r13.f2738a.get(0)).f2317b).floatValue() == 0.0f)) {
            animatableFloatValueM565r13 = null;
        }
        if (animatableFloatValue6 != null) {
            animatableFloatValue2 = animatableFloatValue6;
            boolean z5 = animatableFloatValue6.isStatic() && ((Float) ((Keyframe) animatableFloatValue2.f2738a.get(0)).f2317b).floatValue() == 0.0f;
            return new AnimatableTransform(animatablePathValueM411a, animatableValue2, animatableScaleValue5, animatableFloatValue, animatableIntegerValueM569s1, animatableFloatValueM565r14, animatableFloatValueM565r15, animatableFloatValueM565r13, !z5 ? null : animatableFloatValue2);
        }
        animatableFloatValue2 = animatableFloatValue6;
        return new AnimatableTransform(animatablePathValueM411a, animatableValue2, animatableScaleValue5, animatableFloatValue, animatableIntegerValueM569s1, animatableFloatValueM565r14, animatableFloatValueM565r15, animatableFloatValueM565r13, !z5 ? null : animatableFloatValue2);
    }
}
