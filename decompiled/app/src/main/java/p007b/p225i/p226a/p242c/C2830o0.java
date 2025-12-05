package p007b.p225i.p226a.p242c;

import android.os.Bundle;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Bundleable;

/* compiled from: lambda */
/* renamed from: b.i.a.c.o0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2830o0 implements Bundleable.a {

    /* renamed from: a */
    public static final /* synthetic */ C2830o0 f7260a = new C2830o0();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        Bundleable heartRating;
        int i = bundle.getInt(Integer.toString(0, 36), -1);
        if (i == 0) {
            AnimatableValueParser.m531j(bundle.getInt(HeartRating.m3303a(0), -1) == 0);
            if (bundle.getBoolean(HeartRating.m3303a(1), false)) {
                return new HeartRating(bundle.getBoolean(HeartRating.m3303a(2), false));
            }
            heartRating = new HeartRating();
        } else if (i == 1) {
            AnimatableValueParser.m531j(bundle.getInt(Integer.toString(0, 36), -1) == 1);
            float f = bundle.getFloat(Integer.toString(1, 36), -1.0f);
            if (f != -1.0f) {
                return new PercentageRating(f);
            }
            heartRating = new PercentageRating();
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException(outline.m851g(44, "Encountered unknown rating type: ", i));
                }
                AnimatableValueParser.m531j(bundle.getInt(ThumbRating.m3318a(0), -1) == 3);
                return bundle.getBoolean(ThumbRating.m3318a(1), false) ? new ThumbRating(bundle.getBoolean(ThumbRating.m3318a(2), false)) : new ThumbRating();
            }
            AnimatableValueParser.m531j(bundle.getInt(StarRating.m3304a(0), -1) == 2);
            int i2 = bundle.getInt(StarRating.m3304a(1), 5);
            float f2 = bundle.getFloat(StarRating.m3304a(2), -1.0f);
            if (f2 != -1.0f) {
                return new StarRating(i2, f2);
            }
            heartRating = new StarRating(i2);
        }
        return heartRating;
    }
}
