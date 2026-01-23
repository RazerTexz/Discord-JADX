package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.c.u.p.d, reason: use source file name */
/* JADX INFO: compiled from: InstallationResponse.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class InstallationResponse {

    /* JADX INFO: renamed from: b.i.c.u.p.d$a */
    /* JADX INFO: compiled from: InstallationResponse.java */
    public enum a {
        OK,
        BAD_CONFIG
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract TokenResult mo6792a();

    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract String mo6793b();

    @Nullable
    /* JADX INFO: renamed from: c */
    public abstract String mo6794c();

    @Nullable
    /* JADX INFO: renamed from: d */
    public abstract a mo6795d();

    @Nullable
    /* JADX INFO: renamed from: e */
    public abstract String mo6796e();
}
