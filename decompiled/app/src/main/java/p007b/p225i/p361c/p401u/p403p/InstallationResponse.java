package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* compiled from: InstallationResponse.java */
@AutoValue
/* renamed from: b.i.c.u.p.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class InstallationResponse {

    /* compiled from: InstallationResponse.java */
    /* renamed from: b.i.c.u.p.d$a */
    public enum a {
        OK,
        BAD_CONFIG
    }

    @Nullable
    /* renamed from: a */
    public abstract TokenResult mo6792a();

    @Nullable
    /* renamed from: b */
    public abstract String mo6793b();

    @Nullable
    /* renamed from: c */
    public abstract String mo6794c();

    @Nullable
    /* renamed from: d */
    public abstract a mo6795d();

    @Nullable
    /* renamed from: e */
    public abstract String mo6796e();
}
