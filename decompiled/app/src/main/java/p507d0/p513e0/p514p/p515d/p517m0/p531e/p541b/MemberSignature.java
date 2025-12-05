package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MemberSignature.kt */
/* renamed from: d0.e0.p.d.m0.e.b.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class MemberSignature {

    /* renamed from: a */
    public static final a f23633a = new a(null);

    /* renamed from: b */
    public final String f23634b;

    /* compiled from: MemberSignature.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.s$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final MemberSignature fromFieldNameAndDesc(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            return new MemberSignature(str + MentionUtils.CHANNELS_CHAR + str2, null);
        }

        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature jvmMemberSignature) {
            Intrinsics3.checkNotNullParameter(jvmMemberSignature, "signature");
            if (jvmMemberSignature instanceof JvmMemberSignature.b) {
                return fromMethodNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            if (jvmMemberSignature instanceof JvmMemberSignature.a) {
                return fromFieldNameAndDesc(jvmMemberSignature.getName(), jvmMemberSignature.getDesc());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final MemberSignature fromMethod(NameResolver nameResolver, JvmProtoBuf.c cVar) {
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(cVar, "signature");
            return fromMethodNameAndDesc(nameResolver.getString(cVar.getName()), nameResolver.getString(cVar.getDesc()));
        }

        public final MemberSignature fromMethodNameAndDesc(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(str2, "desc");
            return new MemberSignature(Intrinsics3.stringPlus(str, str2), null);
        }

        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature memberSignature, int i) {
            Intrinsics3.checkNotNullParameter(memberSignature, "signature");
            return new MemberSignature(memberSignature.getSignature() + MentionUtils.MENTIONS_CHAR + i, null);
        }
    }

    public MemberSignature(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23634b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MemberSignature) && Intrinsics3.areEqual(this.f23634b, ((MemberSignature) obj).f23634b);
    }

    public final String getSignature() {
        return this.f23634b;
    }

    public int hashCode() {
        return this.f23634b.hashCode();
    }

    public String toString() {
        return outline.m820H(outline.m833U("MemberSignature(signature="), this.f23634b, ')');
    }
}
