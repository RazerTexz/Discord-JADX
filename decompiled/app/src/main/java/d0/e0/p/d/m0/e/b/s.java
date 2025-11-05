package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.f.a0.a;
import d0.e0.p.d.m0.f.a0.b.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MemberSignature.kt */
/* loaded from: classes3.dex */
public final class s {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final String f3382b;

    /* compiled from: MemberSignature.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final s fromFieldNameAndDesc(String str, String str2) {
            d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(str2, "desc");
            return new s(str + MentionUtilsKt.CHANNELS_CHAR + str2, null);
        }

        public final s fromJvmMemberSignature(d0.e0.p.d.m0.f.a0.b.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, "signature");
            if (eVar instanceof e.b) {
                return fromMethodNameAndDesc(eVar.getName(), eVar.getDesc());
            }
            if (eVar instanceof e.a) {
                return fromFieldNameAndDesc(eVar.getName(), eVar.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final s fromMethod(d0.e0.p.d.m0.f.z.c cVar, a.c cVar2) {
            d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
            d0.z.d.m.checkNotNullParameter(cVar2, "signature");
            return fromMethodNameAndDesc(cVar.getString(cVar2.getName()), cVar.getString(cVar2.getDesc()));
        }

        public final s fromMethodNameAndDesc(String str, String str2) {
            d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(str2, "desc");
            return new s(d0.z.d.m.stringPlus(str, str2), null);
        }

        public final s fromMethodSignatureAndParameterIndex(s sVar, int i) {
            d0.z.d.m.checkNotNullParameter(sVar, "signature");
            return new s(sVar.getSignature() + MentionUtilsKt.MENTIONS_CHAR + i, null);
        }
    }

    public s(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3382b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && d0.z.d.m.areEqual(this.f3382b, ((s) obj).f3382b);
    }

    public final String getSignature() {
        return this.f3382b;
    }

    public int hashCode() {
        return this.f3382b.hashCode();
    }

    public String toString() {
        return b.d.b.a.a.H(b.d.b.a.a.U("MemberSignature(signature="), this.f3382b, ')');
    }
}
