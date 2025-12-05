package p007b.p225i.p226a.p242c.p279z2.p281i;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/* compiled from: EventMessageEncoder.java */
/* renamed from: b.i.a.c.z2.i.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventMessageEncoder {

    /* renamed from: a */
    public final ByteArrayOutputStream f9148a;

    /* renamed from: b */
    public final DataOutputStream f9149b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f9148a = byteArrayOutputStream;
        this.f9149b = new DataOutputStream(byteArrayOutputStream);
    }
}
