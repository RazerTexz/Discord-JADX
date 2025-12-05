package p007b.p008a.p041q.p043l0;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WiredHeadsetState.kt */
/* renamed from: b.a.q.l0.a, reason: use source file name */
/* loaded from: classes.dex */
public abstract class WiredHeadsetState {

    /* compiled from: WiredHeadsetState.kt */
    /* renamed from: b.a.q.l0.a$a */
    public static final class a extends WiredHeadsetState {

        /* renamed from: a */
        public final String f1667a;

        /* renamed from: b */
        public final boolean f1668b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z2) {
            super(false, null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f1667a = str;
            this.f1668b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.f1667a, aVar.f1667a) && this.f1668b == aVar.f1668b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.f1667a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.f1668b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("PluggedIn(name=");
            sbM833U.append(this.f1667a);
            sbM833U.append(", hasMic=");
            return outline.m827O(sbM833U, this.f1668b, ")");
        }
    }

    /* compiled from: WiredHeadsetState.kt */
    /* renamed from: b.a.q.l0.a$b */
    public static final class b extends WiredHeadsetState {

        /* renamed from: a */
        public static final b f1669a = new b();

        public b() {
            super(false, null);
        }

        public String toString() {
            return "WiredHeadsetState.Unplugged";
        }
    }

    public WiredHeadsetState(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
    }
}
