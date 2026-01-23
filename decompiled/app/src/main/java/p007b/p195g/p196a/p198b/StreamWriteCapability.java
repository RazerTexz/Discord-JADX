package p007b.p195g.p196a.p198b;

import p007b.p195g.p196a.p198b.p204t.JacksonFeature;

/* JADX INFO: renamed from: b.g.a.b.m, reason: use source file name */
/* JADX INFO: compiled from: StreamWriteCapability.java */
/* JADX INFO: loaded from: classes3.dex */
public enum StreamWriteCapability implements JacksonFeature {
    CAN_WRITE_BINARY_NATIVELY(false),
    CAN_WRITE_FORMATTED_NUMBERS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    StreamWriteCapability(boolean z2) {
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
