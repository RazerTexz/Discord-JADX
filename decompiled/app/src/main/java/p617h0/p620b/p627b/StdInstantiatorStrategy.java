package p617h0.p620b.p627b;

import java.io.Serializable;
import p617h0.p620b.p621a.ObjectInstantiator;
import p617h0.p620b.p621a.p622b.Android10Instantiator;
import p617h0.p620b.p621a.p622b.Android17Instantiator;
import p617h0.p620b.p621a.p622b.Android18Instantiator;
import p617h0.p620b.p621a.p623c.AccessibleInstantiator;
import p617h0.p620b.p621a.p623c.ObjectInputStreamInstantiator;
import p617h0.p620b.p621a.p624d.GCJInstantiator;
import p617h0.p620b.p621a.p625e.PercInstantiator;
import p617h0.p620b.p621a.p626f.SunReflectionFactoryInstantiator;
import p617h0.p620b.p621a.p626f.UnsafeFactoryInstantiator;

/* compiled from: StdInstantiatorStrategy.java */
/* renamed from: h0.b.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public class StdInstantiatorStrategy implements InstantiatorStrategy {
    @Override // p617h0.p620b.p627b.InstantiatorStrategy
    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> cls) {
        if (PlatformDescription.m10657b("Java HotSpot") || PlatformDescription.m10657b("OpenJDK")) {
            return PlatformDescription.f26405d != null ? Serializable.class.isAssignableFrom(cls) ? new ObjectInputStreamInstantiator(cls) : new AccessibleInstantiator(cls) : new SunReflectionFactoryInstantiator(cls);
        }
        if (!PlatformDescription.m10657b("Dalvik")) {
            return PlatformDescription.m10657b("BEA") ? new SunReflectionFactoryInstantiator(cls) : PlatformDescription.m10657b("GNU libgcj") ? new GCJInstantiator(cls) : PlatformDescription.m10657b("PERC") ? new PercInstantiator(cls) : new UnsafeFactoryInstantiator(cls);
        }
        if (PlatformDescription.f26404c) {
            return new UnsafeFactoryInstantiator(cls);
        }
        int i = PlatformDescription.f26403b;
        return i <= 10 ? new Android10Instantiator(cls) : i <= 17 ? new Android17Instantiator(cls) : new Android18Instantiator(cls);
    }
}
