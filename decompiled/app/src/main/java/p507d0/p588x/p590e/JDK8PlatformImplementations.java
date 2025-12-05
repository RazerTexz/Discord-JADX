package p507d0.p588x.p590e;

import p507d0.p510c0.Random;
import p507d0.p510c0.p511f.PlatformThreadLocalRandom;
import p507d0.p588x.p589d.JDK7PlatformImplementations;

/* compiled from: JDK8PlatformImplementations.kt */
/* renamed from: d0.x.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {
    @Override // p507d0.p588x.PlatformImplementations
    public Random defaultPlatformRandom() {
        return new PlatformThreadLocalRandom();
    }
}
