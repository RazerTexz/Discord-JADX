package b.a.q.l0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WiredHeadsetState.kt */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: WiredHeadsetState.kt */
    /* renamed from: b.a.q.l0.a$a, reason: collision with other inner class name */
    public static final class C0041a extends a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f265b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0041a(String str, boolean z2) {
            super(false, null);
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.a = str;
            this.f265b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0041a)) {
                return false;
            }
            C0041a c0041a = (C0041a) obj;
            return m.areEqual(this.a, c0041a.a) && this.f265b == c0041a.f265b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.f265b;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("PluggedIn(name=");
            sbU.append(this.a);
            sbU.append(", hasMic=");
            return b.d.b.a.a.O(sbU, this.f265b, ")");
        }
    }

    /* compiled from: WiredHeadsetState.kt */
    public static final class b extends a {
        public static final b a = new b();

        public b() {
            super(false, null);
        }

        public String toString() {
            return "WiredHeadsetState.Unplugged";
        }
    }

    public a(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
    }
}
