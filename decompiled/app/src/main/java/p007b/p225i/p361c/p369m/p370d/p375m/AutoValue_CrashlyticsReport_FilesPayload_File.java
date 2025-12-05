package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
/* renamed from: b.i.c.m.d.m.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_FilesPayload_File extends CrashlyticsReport.c.a {

    /* renamed from: a */
    public final String f12538a;

    /* renamed from: b */
    public final byte[] f12539b;

    public AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr, a aVar) {
        this.f12538a = str;
        this.f12539b = bArr;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.c.a
    @NonNull
    /* renamed from: a */
    public byte[] mo6529a() {
        return this.f12539b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.c.a
    @NonNull
    /* renamed from: b */
    public String mo6530b() {
        return this.f12538a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.c.a)) {
            return false;
        }
        CrashlyticsReport.c.a aVar = (CrashlyticsReport.c.a) obj;
        if (this.f12538a.equals(aVar.mo6530b())) {
            if (Arrays.equals(this.f12539b, aVar instanceof AutoValue_CrashlyticsReport_FilesPayload_File ? ((AutoValue_CrashlyticsReport_FilesPayload_File) aVar).f12539b : aVar.mo6529a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f12538a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12539b);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("File{filename=");
        sbM833U.append(this.f12538a);
        sbM833U.append(", contents=");
        sbM833U.append(Arrays.toString(this.f12539b));
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
