package p007b.p195g.p196a.p198b;

import p007b.p195g.p196a.p198b.p204t.JacksonFeature;

/* JADX INFO: renamed from: b.g.a.b.l, reason: use source file name */
/* JADX INFO: compiled from: StreamReadCapability.java */
/* JADX INFO: loaded from: classes3.dex */
public enum StreamReadCapability implements JacksonFeature {
    DUPLICATE_PROPERTIES(false),
    SCALARS_AS_OBJECTS(false),
    UNTYPED_SCALARS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    StreamReadCapability(boolean z2) {
        this._defaultState = z2;
    }

    @Override // p007b.p195g.p196a.p198b.p204t.JacksonFeature
    /* JADX INFO: renamed from: f */
    public boolean mo1629f() {
        return this._defaultState;
    }

    @Override // p007b.p195g.p196a.p198b.p204t.JacksonFeature
    /* JADX INFO: renamed from: g */
    public int mo1630g() {
        return this._mask;
    }
}
