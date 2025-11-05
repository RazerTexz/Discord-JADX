package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.i.c.m.d.m.v;
import java.util.Arrays;

/* compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
/* loaded from: classes3.dex */
public final class e extends v.c.a {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f1717b;

    public e(String str, byte[] bArr, a aVar) {
        this.a = str;
        this.f1717b = bArr;
    }

    @Override // b.i.c.m.d.m.v.c.a
    @NonNull
    public byte[] a() {
        return this.f1717b;
    }

    @Override // b.i.c.m.d.m.v.c.a
    @NonNull
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.c.a)) {
            return false;
        }
        v.c.a aVar = (v.c.a) obj;
        if (this.a.equals(aVar.b())) {
            if (Arrays.equals(this.f1717b, aVar instanceof e ? ((e) aVar).f1717b : aVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1717b);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("File{filename=");
        sbU.append(this.a);
        sbU.append(", contents=");
        sbU.append(Arrays.toString(this.f1717b));
        sbU.append("}");
        return sbU.toString();
    }
}
