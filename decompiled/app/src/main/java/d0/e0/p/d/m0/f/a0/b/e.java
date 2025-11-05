package d0.e0.p.d.m0.f.a0.b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JvmMemberSignature.kt */
/* loaded from: classes3.dex */
public abstract class e {

    /* compiled from: JvmMemberSignature.kt */
    public static final class a extends e {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3387b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkNotNullParameter(str2, "desc");
            this.a = str;
            this.f3387b = str2;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.e
        public String asString() {
            return getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getDesc();
        }

        public final String component1() {
            return this.a;
        }

        public final String component2() {
            return this.f3387b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.areEqual(this.a, aVar.a) && m.areEqual(this.f3387b, aVar.f3387b);
        }

        @Override // d0.e0.p.d.m0.f.a0.b.e
        public String getDesc() {
            return this.f3387b;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.e
        public String getName() {
            return this.a;
        }

        public int hashCode() {
            return this.f3387b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    /* compiled from: JvmMemberSignature.kt */
    public static final class b extends e {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3388b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkNotNullParameter(str2, "desc");
            this.a = str;
            this.f3388b = str2;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.e
        public String asString() {
            return m.stringPlus(getName(), getDesc());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.areEqual(this.a, bVar.a) && m.areEqual(this.f3388b, bVar.f3388b);
        }

        @Override // d0.e0.p.d.m0.f.a0.b.e
        public String getDesc() {
            return this.f3388b;
        }

        @Override // d0.e0.p.d.m0.f.a0.b.e
        public String getName() {
            return this.a;
        }

        public int hashCode() {
            return this.f3388b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    public e(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }
}
