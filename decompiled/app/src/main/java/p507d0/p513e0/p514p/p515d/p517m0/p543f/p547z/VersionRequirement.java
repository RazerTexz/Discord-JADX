package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Annotations2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11697v;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: VersionRequirement.kt */
/* renamed from: d0.e0.p.d.m0.f.z.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class VersionRequirement {

    /* renamed from: a */
    public static final a f24062a = new a(null);

    /* renamed from: b */
    public final b f24063b;

    /* renamed from: c */
    public final C11697v.d f24064c;

    /* renamed from: d */
    public final Annotations2 f24065d;

    /* renamed from: e */
    public final Integer f24066e;

    /* renamed from: f */
    public final String f24067f;

    /* compiled from: VersionRequirement.kt */
    /* renamed from: d0.e0.p.d.m0.f.z.h$b */
    public static final class b {

        /* renamed from: a */
        public static final a f24068a = new a(null);

        /* renamed from: b */
        public static final b f24069b = new b(256, 256, 256);

        /* renamed from: c */
        public final int f24070c;

        /* renamed from: d */
        public final int f24071d;

        /* renamed from: e */
        public final int f24072e;

        /* compiled from: VersionRequirement.kt */
        /* renamed from: d0.e0.p.d.m0.f.z.h$b$a */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final b decode(Integer num, Integer num2) {
                return num2 != null ? new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255) : num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & Opcodes.LAND) : b.f24069b;
            }
        }

        public b(int i, int i2, int i3) {
            this.f24070c = i;
            this.f24071d = i2;
            this.f24072e = i3;
        }

        public final String asString() {
            StringBuilder sb;
            int i;
            if (this.f24072e == 0) {
                sb = new StringBuilder();
                sb.append(this.f24070c);
                sb.append('.');
                i = this.f24071d;
            } else {
                sb = new StringBuilder();
                sb.append(this.f24070c);
                sb.append('.');
                sb.append(this.f24071d);
                sb.append('.');
                i = this.f24072e;
            }
            sb.append(i);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f24070c == bVar.f24070c && this.f24071d == bVar.f24071d && this.f24072e == bVar.f24072e;
        }

        public int hashCode() {
            return (((this.f24070c * 31) + this.f24071d) * 31) + this.f24072e;
        }

        public String toString() {
            return asString();
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public VersionRequirement(b bVar, C11697v.d dVar, Annotations2 annotations2, Integer num, String str) {
        Intrinsics3.checkNotNullParameter(bVar, "version");
        Intrinsics3.checkNotNullParameter(dVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations2, "level");
        this.f24063b = bVar;
        this.f24064c = dVar;
        this.f24065d = annotations2;
        this.f24066e = num;
        this.f24067f = str;
    }

    public final C11697v.d getKind() {
        return this.f24064c;
    }

    public final b getVersion() {
        return this.f24063b;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("since ");
        sbM833U.append(this.f24063b);
        sbM833U.append(' ');
        sbM833U.append(this.f24065d);
        Integer num = this.f24066e;
        sbM833U.append(num != null ? Intrinsics3.stringPlus(" error ", num) : "");
        String str = this.f24067f;
        sbM833U.append(str != null ? Intrinsics3.stringPlus(": ", str) : "");
        return sbM833U.toString();
    }

    /* compiled from: VersionRequirement.kt */
    /* renamed from: d0.e0.p.d.m0.f.z.h$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<VersionRequirement> create(MessageLite messageLite, NameResolver nameResolver, VersionRequirement2 versionRequirement2) {
            List<Integer> versionRequirementList;
            Intrinsics3.checkNotNullParameter(messageLite, "proto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(versionRequirement2, "table");
            if (messageLite instanceof C11678c) {
                versionRequirementList = ((C11678c) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof C11679d) {
                versionRequirementList = ((C11679d) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof C11684i) {
                versionRequirementList = ((C11684i) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof C11689n) {
                versionRequirementList = ((C11689n) messageLite).getVersionRequirementList();
            } else {
                if (!(messageLite instanceof C11693r)) {
                    throw new IllegalStateException(Intrinsics3.stringPlus("Unexpected declaration: ", messageLite.getClass()));
                }
                versionRequirementList = ((C11693r) messageLite).getVersionRequirementList();
            }
            ArrayList arrayListM840a0 = outline.m840a0(versionRequirementList, "ids");
            for (Integer num : versionRequirementList) {
                Intrinsics3.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_ID);
                VersionRequirement versionRequirementCreate = create(num.intValue(), nameResolver, versionRequirement2);
                if (versionRequirementCreate != null) {
                    arrayListM840a0.add(versionRequirementCreate);
                }
            }
            return arrayListM840a0;
        }

        public final VersionRequirement create(int i, NameResolver nameResolver, VersionRequirement2 versionRequirement2) {
            Annotations2 annotations2;
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(versionRequirement2, "table");
            C11697v c11697v = versionRequirement2.get(i);
            if (c11697v == null) {
                return null;
            }
            b bVarDecode = b.f24068a.decode(c11697v.hasVersion() ? Integer.valueOf(c11697v.getVersion()) : null, c11697v.hasVersionFull() ? Integer.valueOf(c11697v.getVersionFull()) : null);
            C11697v.c level = c11697v.getLevel();
            Intrinsics3.checkNotNull(level);
            int iOrdinal = level.ordinal();
            if (iOrdinal == 0) {
                annotations2 = Annotations2.WARNING;
            } else if (iOrdinal == 1) {
                annotations2 = Annotations2.ERROR;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                annotations2 = Annotations2.HIDDEN;
            }
            Annotations2 annotations22 = annotations2;
            Integer numValueOf = c11697v.hasErrorCode() ? Integer.valueOf(c11697v.getErrorCode()) : null;
            String string = c11697v.hasMessage() ? nameResolver.getString(c11697v.getMessage()) : null;
            C11697v.d versionKind = c11697v.getVersionKind();
            Intrinsics3.checkNotNullExpressionValue(versionKind, "info.versionKind");
            return new VersionRequirement(bVarDecode, versionKind, annotations22, numValueOf, string);
        }
    }
}
