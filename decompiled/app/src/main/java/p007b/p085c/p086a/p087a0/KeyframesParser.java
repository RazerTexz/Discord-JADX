package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.PathKeyframe;

/* compiled from: KeyframesParser.java */
/* renamed from: b.c.a.a0.r, reason: use source file name */
/* loaded from: classes.dex */
public class KeyframesParser {

    /* renamed from: a */
    public static JsonReader2.a f2279a = JsonReader2.a.m616a("k");

    /* renamed from: a */
    public static <T> List<Keyframe<T>> m632a(JsonReader2 jsonReader2, LottieComposition lottieComposition, float f, ValueParser<T> valueParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader2.mo613u() == JsonReader2.b.STRING) {
            lottieComposition.m669a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader2.mo604b();
        while (jsonReader2.mo607e()) {
            if (jsonReader2.mo615y(f2279a) != 0) {
                jsonReader2.mo601C();
            } else if (jsonReader2.mo613u() == JsonReader2.b.BEGIN_ARRAY) {
                jsonReader2.mo603a();
                if (jsonReader2.mo613u() == JsonReader2.b.NUMBER) {
                    arrayList.add(KeyframeParser.m631a(jsonReader2, lottieComposition, f, valueParser, false));
                } else {
                    while (jsonReader2.mo607e()) {
                        arrayList.add(KeyframeParser.m631a(jsonReader2, lottieComposition, f, valueParser, true));
                    }
                }
                jsonReader2.mo605c();
            } else {
                arrayList.add(KeyframeParser.m631a(jsonReader2, lottieComposition, f, valueParser, false));
            }
        }
        jsonReader2.mo606d();
        m633b(arrayList);
        return arrayList;
    }

    /* renamed from: b */
    public static <T> void m633b(List<? extends Keyframe<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Keyframe<T> keyframe = list.get(i2);
            i2++;
            Keyframe<T> keyframe2 = list.get(i2);
            keyframe.f2321f = Float.valueOf(keyframe2.f2320e);
            if (keyframe.f2318c == null && (t = keyframe2.f2317b) != null) {
                keyframe.f2318c = t;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).m742e();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i);
        if ((keyframe3.f2317b == null || keyframe3.f2318c == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
