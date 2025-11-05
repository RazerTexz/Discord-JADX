package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.h;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public enum j implements h.a {
    DECLARATION(0),
    FAKE_OVERRIDE(1),
    DELEGATION(2),
    SYNTHESIZED(3);

    private final int value;

    j(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h.a
    public final int getNumber() {
        return this.value;
    }
}
