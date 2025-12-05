package p007b.p225i.p226a.p228b.p231j;

import java.util.Set;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.Transformer;
import p007b.p225i.p226a.p228b.Transport2;
import p007b.p225i.p226a.p228b.TransportFactory;

/* compiled from: TransportFactoryImpl.java */
/* renamed from: b.i.a.b.j.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class TransportFactoryImpl implements TransportFactory {

    /* renamed from: a */
    public final Set<Encoding2> f5281a;

    /* renamed from: b */
    public final TransportContext f5282b;

    /* renamed from: c */
    public final TransportInternal f5283c;

    public TransportFactoryImpl(Set<Encoding2> set, TransportContext transportContext, TransportInternal transportInternal) {
        this.f5281a = set;
        this.f5282b = transportContext;
        this.f5283c = transportInternal;
    }

    @Override // p007b.p225i.p226a.p228b.TransportFactory
    /* renamed from: a */
    public <T> Transport2<T> mo2291a(String str, Class<T> cls, Encoding2 encoding2, Transformer<T, byte[]> transformer) {
        if (this.f5281a.contains(encoding2)) {
            return new TransportImpl2(this.f5282b, str, encoding2, transformer, this.f5283c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding2, this.f5281a));
    }
}
