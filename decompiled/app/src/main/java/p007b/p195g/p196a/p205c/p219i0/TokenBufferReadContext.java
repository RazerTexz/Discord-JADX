package p007b.p195g.p196a.p205c.p219i0;

import p007b.p195g.p196a.p198b.JsonLocation;
import p007b.p195g.p196a.p198b.JsonStreamContext;

/* compiled from: TokenBufferReadContext.java */
/* renamed from: b.g.a.c.i0.t, reason: use source file name */
/* loaded from: classes3.dex */
public class TokenBufferReadContext extends JsonStreamContext {

    /* renamed from: c */
    public final JsonStreamContext f4983c;

    /* renamed from: d */
    public final JsonLocation f4984d;

    /* renamed from: e */
    public String f4985e;

    /* renamed from: f */
    public Object f4986f;

    public TokenBufferReadContext() {
        super(0, -1);
        this.f4983c = null;
        this.f4984d = JsonLocation.f4478j;
    }

    @Override // p007b.p195g.p196a.p198b.JsonStreamContext
    /* renamed from: a */
    public String mo1673a() {
        return this.f4985e;
    }

    @Override // p007b.p195g.p196a.p198b.JsonStreamContext
    /* renamed from: d */
    public void mo1676d(Object obj) {
        this.f4986f = obj;
    }
}
