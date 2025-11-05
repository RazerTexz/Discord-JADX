package b.i.a.c.z2.i;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/* compiled from: EventMessageEncoder.java */
/* loaded from: classes3.dex */
public final class b {
    public final ByteArrayOutputStream a;

    /* renamed from: b, reason: collision with root package name */
    public final DataOutputStream f1322b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.f1322b = new DataOutputStream(byteArrayOutputStream);
    }
}
