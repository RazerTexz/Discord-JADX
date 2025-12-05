package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.PathKeyframe;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePathValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableSplitDimensionPathValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableValue;

/* compiled from: AnimatablePathValueParser.java */
/* renamed from: b.c.a.a0.a, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatablePathValueParser {

    /* renamed from: a */
    public static JsonReader2.a f2207a = JsonReader2.a.m616a("k", "x", "y");

    /* renamed from: a */
    public static AnimatablePathValue m411a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader2.mo613u() == JsonReader2.b.BEGIN_ARRAY) {
            jsonReader2.mo603a();
            while (jsonReader2.mo607e()) {
                arrayList.add(new PathKeyframe(lottieComposition, KeyframeParser.m631a(jsonReader2, lottieComposition, Utils.m659c(), PathParser2.f2288a, jsonReader2.mo613u() == JsonReader2.b.BEGIN_OBJECT)));
            }
            jsonReader2.mo605c();
            KeyframesParser.m633b(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.m628b(jsonReader2, Utils.m659c())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* renamed from: b */
    public static AnimatableValue<PointF, PointF> m412b(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        JsonReader2.b bVar = JsonReader2.b.STRING;
        jsonReader2.mo604b();
        AnimatablePathValue animatablePathValueM411a = null;
        AnimatableFloatValue animatableFloatValueM561q1 = null;
        AnimatableFloatValue animatableFloatValueM561q12 = null;
        boolean z2 = false;
        while (jsonReader2.mo613u() != JsonReader2.b.END_OBJECT) {
            int iMo615y = jsonReader2.mo615y(f2207a);
            if (iMo615y == 0) {
                animatablePathValueM411a = m411a(jsonReader2, lottieComposition);
            } else if (iMo615y != 1) {
                if (iMo615y != 2) {
                    jsonReader2.mo600A();
                    jsonReader2.mo601C();
                } else if (jsonReader2.mo613u() == bVar) {
                    jsonReader2.mo601C();
                    z2 = true;
                } else {
                    animatableFloatValueM561q12 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                }
            } else if (jsonReader2.mo613u() == bVar) {
                jsonReader2.mo601C();
                z2 = true;
            } else {
                animatableFloatValueM561q1 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
            }
        }
        jsonReader2.mo606d();
        if (z2) {
            lottieComposition.m669a("Lottie doesn't support expressions.");
        }
        return animatablePathValueM411a != null ? animatablePathValueM411a : new AnimatableSplitDimensionPathValue(animatableFloatValueM561q1, animatableFloatValueM561q12);
    }
}
