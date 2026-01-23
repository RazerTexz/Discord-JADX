package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.b0, reason: use source file name */
/* JADX INFO: compiled from: ModuleCapability.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleCapability<T> {

    /* JADX INFO: renamed from: a */
    public final String f22681a;

    public ModuleCapability(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f22681a = str;
    }

    public String toString() {
        return this.f22681a;
    }
}
