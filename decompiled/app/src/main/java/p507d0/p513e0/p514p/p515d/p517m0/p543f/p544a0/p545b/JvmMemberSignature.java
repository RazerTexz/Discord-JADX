package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e, reason: use source file name */
/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JvmMemberSignature {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e$a */
    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class a extends JvmMemberSignature {

        /* JADX INFO: renamed from: a */
        public final String f23707a;

        /* JADX INFO: renamed from: b */
        public final String f23708b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            this.f23707a = str;
            this.f23708b = str2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature
        public String asString() {
            return getName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + getDesc();
        }

        public final String component1() {
            return this.f23707a;
        }

        public final String component2() {
            return this.f23708b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.f23707a, aVar.f23707a) && Intrinsics3.areEqual(this.f23708b, aVar.f23708b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature
        public String getDesc() {
            return this.f23708b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature
        public String getName() {
            return this.f23707a;
        }

        public int hashCode() {
            return this.f23708b.hashCode() + (this.f23707a.hashCode() * 31);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.e$b */
    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class b extends JvmMemberSignature {

        /* JADX INFO: renamed from: a */
        public final String f23709a;

        /* JADX INFO: renamed from: b */
        public final String f23710b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            this.f23709a = str;
            this.f23710b = str2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature
        public String asString() {
            return Intrinsics3.stringPlus(getName(), getDesc());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.f23709a, bVar.f23709a) && Intrinsics3.areEqual(this.f23710b, bVar.f23710b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature
        public String getDesc() {
            return this.f23710b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature
        public String getName() {
            return this.f23709a;
        }

        public int hashCode() {
            return this.f23710b.hashCode() + (this.f23709a.hashCode() * 31);
        }
    }

    public JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    public final String toString() {
        return asString();
    }
}
