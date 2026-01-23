package p007b.p008a.p041q.p042k0;

import android.content.Context;
import android.os.Process;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.k0.b, reason: use source file name */
/* JADX INFO: compiled from: AudioPermissions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioPermissions {

    /* JADX INFO: renamed from: a */
    public static final a f1643a = new a(null);

    /* JADX INFO: renamed from: b */
    public final boolean f1644b;

    /* JADX INFO: renamed from: c */
    public final boolean f1645c;

    /* JADX INFO: renamed from: d */
    public final boolean f1646d;

    /* JADX INFO: renamed from: b.a.q.k0.b$a */
    /* JADX INFO: compiled from: AudioPermissions.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AudioPermissions(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        boolean z2 = context.checkPermission("android.permission.MODIFY_AUDIO_SETTINGS", Process.myPid(), Process.myUid()) == 0;
        boolean z3 = context.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0;
        boolean z4 = context.checkPermission("android.permission.BLUETOOTH", Process.myPid(), Process.myUid()) == 0;
        this.f1644b = z2;
        this.f1645c = z3;
        this.f1646d = z4;
        if (!z2) {
            AnimatableValueParser.m517f1("AudioPermissions", "MODIFY_AUDIO_SETTINGS permission is missing");
        }
        if (!z3) {
            AnimatableValueParser.m517f1("AudioPermissions", "RECORD_AUDIO permission is missing");
        }
        if (z4) {
            return;
        }
        AnimatableValueParser.m517f1("AudioPermissions", "BLUETOOTH permission is missing");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioPermissions)) {
            return false;
        }
        AudioPermissions audioPermissions = (AudioPermissions) obj;
        return this.f1644b == audioPermissions.f1644b && this.f1645c == audioPermissions.f1645c && this.f1646d == audioPermissions.f1646d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z2 = this.f1644b;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.f1645c;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.f1646d;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("AudioPermissions(hasModifyAudioSettingsPermission=");
        sbM833U.append(this.f1644b);
        sbM833U.append(", hasRecordAudioPermission=");
        sbM833U.append(this.f1645c);
        sbM833U.append(", hasBluetoothPermission=");
        return outline.m827O(sbM833U, this.f1646d, ")");
    }
}
