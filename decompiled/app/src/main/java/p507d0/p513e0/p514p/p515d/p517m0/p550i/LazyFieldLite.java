package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.j, reason: use source file name */
/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {

    /* JADX INFO: renamed from: a */
    public volatile boolean f24145a;

    /* JADX INFO: renamed from: b */
    public volatile MessageLite f24146b;

    public int getSerializedSize() {
        if (this.f24145a) {
            return this.f24146b.getSerializedSize();
        }
        throw null;
    }

    public MessageLite getValue(MessageLite messageLite) {
        if (this.f24146b == null) {
            synchronized (this) {
                if (this.f24146b == null) {
                    try {
                        this.f24146b = messageLite;
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return this.f24146b;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.f24146b;
        this.f24146b = messageLite;
        this.f24145a = true;
        return messageLite2;
    }
}
