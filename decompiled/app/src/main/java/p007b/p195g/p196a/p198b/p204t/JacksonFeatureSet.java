package p007b.p195g.p196a.p198b.p204t;

import p007b.p195g.p196a.p198b.StreamWriteCapability;
import p007b.p195g.p196a.p198b.p204t.JacksonFeature;

/* compiled from: JacksonFeatureSet.java */
/* renamed from: b.g.a.b.t.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class JacksonFeatureSet<F extends JacksonFeature> {

    /* renamed from: a */
    public int f4603a;

    public JacksonFeatureSet(int i) {
        this.f4603a = i;
    }

    /* renamed from: a */
    public static <F extends JacksonFeature> JacksonFeatureSet<F> m1734a(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int iMo1630g = 0;
        for (F f : fArr) {
            if (f.mo1629f()) {
                iMo1630g |= f.mo1630g();
            }
        }
        return new JacksonFeatureSet<>(iMo1630g);
    }

    /* renamed from: b */
    public JacksonFeatureSet<F> m1735b(F f) {
        int iMo1630g = ((StreamWriteCapability) f).mo1630g() | this.f4603a;
        return iMo1630g == this.f4603a ? this : new JacksonFeatureSet<>(iMo1630g);
    }
}
