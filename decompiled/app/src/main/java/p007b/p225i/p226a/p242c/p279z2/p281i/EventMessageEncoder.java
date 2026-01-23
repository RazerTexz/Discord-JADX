package p007b.p225i.p226a.p242c.p279z2.p281i;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/* JADX INFO: renamed from: b.i.a.c.z2.i.b, reason: use source file name */
/* JADX INFO: compiled from: EventMessageEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EventMessageEncoder {

    /* JADX INFO: renamed from: a */
    public final ByteArrayOutputStream f9148a;

    /* JADX INFO: renamed from: b */
    public final DataOutputStream f9149b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f9148a = byteArrayOutputStream;
        this.f9149b = new DataOutputStream(byteArrayOutputStream);
    }
}
