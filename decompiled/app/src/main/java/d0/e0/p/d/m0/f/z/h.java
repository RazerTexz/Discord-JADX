package d0.e0.p.d.m0.f.z;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.i.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* compiled from: VersionRequirement.kt */
/* loaded from: classes3.dex */
public final class h {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final b f3419b;
    public final v.d c;
    public final d0.a d;
    public final Integer e;
    public final String f;

    /* compiled from: VersionRequirement.kt */
    public static final class b {
        public static final a a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        public static final b f3420b = new b(256, 256, 256);
        public final int c;
        public final int d;
        public final int e;

        /* compiled from: VersionRequirement.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final b decode(Integer num, Integer num2) {
                return num2 != null ? new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255) : num != null ? new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & Opcodes.LAND) : b.f3420b;
            }
        }

        public b(int i, int i2, int i3) {
            this.c = i;
            this.d = i2;
            this.e = i3;
        }

        public final String asString() {
            StringBuilder sb;
            int i;
            if (this.e == 0) {
                sb = new StringBuilder();
                sb.append(this.c);
                sb.append('.');
                i = this.d;
            } else {
                sb = new StringBuilder();
                sb.append(this.c);
                sb.append('.');
                sb.append(this.d);
                sb.append('.');
                i = this.e;
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
            return this.c == bVar.c && this.d == bVar.d && this.e == bVar.e;
        }

        public int hashCode() {
            return (((this.c * 31) + this.d) * 31) + this.e;
        }

        public String toString() {
            return asString();
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public h(b bVar, v.d dVar, d0.a aVar, Integer num, String str) {
        m.checkNotNullParameter(bVar, "version");
        m.checkNotNullParameter(dVar, "kind");
        m.checkNotNullParameter(aVar, "level");
        this.f3419b = bVar;
        this.c = dVar;
        this.d = aVar;
        this.e = num;
        this.f = str;
    }

    public final v.d getKind() {
        return this.c;
    }

    public final b getVersion() {
        return this.f3419b;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("since ");
        sbU.append(this.f3419b);
        sbU.append(' ');
        sbU.append(this.d);
        Integer num = this.e;
        sbU.append(num != null ? m.stringPlus(" error ", num) : "");
        String str = this.f;
        sbU.append(str != null ? m.stringPlus(": ", str) : "");
        return sbU.toString();
    }

    /* compiled from: VersionRequirement.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<h> create(n nVar, c cVar, i iVar) {
            List<Integer> versionRequirementList;
            m.checkNotNullParameter(nVar, "proto");
            m.checkNotNullParameter(cVar, "nameResolver");
            m.checkNotNullParameter(iVar, "table");
            if (nVar instanceof d0.e0.p.d.m0.f.c) {
                versionRequirementList = ((d0.e0.p.d.m0.f.c) nVar).getVersionRequirementList();
            } else if (nVar instanceof d0.e0.p.d.m0.f.d) {
                versionRequirementList = ((d0.e0.p.d.m0.f.d) nVar).getVersionRequirementList();
            } else if (nVar instanceof d0.e0.p.d.m0.f.i) {
                versionRequirementList = ((d0.e0.p.d.m0.f.i) nVar).getVersionRequirementList();
            } else if (nVar instanceof d0.e0.p.d.m0.f.n) {
                versionRequirementList = ((d0.e0.p.d.m0.f.n) nVar).getVersionRequirementList();
            } else {
                if (!(nVar instanceof r)) {
                    throw new IllegalStateException(m.stringPlus("Unexpected declaration: ", nVar.getClass()));
                }
                versionRequirementList = ((r) nVar).getVersionRequirementList();
            }
            ArrayList arrayListA0 = b.d.b.a.a.a0(versionRequirementList, "ids");
            for (Integer num : versionRequirementList) {
                m.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_ID);
                h hVarCreate = create(num.intValue(), cVar, iVar);
                if (hVarCreate != null) {
                    arrayListA0.add(hVarCreate);
                }
            }
            return arrayListA0;
        }

        public final h create(int i, c cVar, i iVar) {
            d0.a aVar;
            m.checkNotNullParameter(cVar, "nameResolver");
            m.checkNotNullParameter(iVar, "table");
            v vVar = iVar.get(i);
            if (vVar == null) {
                return null;
            }
            b bVarDecode = b.a.decode(vVar.hasVersion() ? Integer.valueOf(vVar.getVersion()) : null, vVar.hasVersionFull() ? Integer.valueOf(vVar.getVersionFull()) : null);
            v.c level = vVar.getLevel();
            m.checkNotNull(level);
            int iOrdinal = level.ordinal();
            if (iOrdinal == 0) {
                aVar = d0.a.WARNING;
            } else if (iOrdinal == 1) {
                aVar = d0.a.ERROR;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                aVar = d0.a.HIDDEN;
            }
            d0.a aVar2 = aVar;
            Integer numValueOf = vVar.hasErrorCode() ? Integer.valueOf(vVar.getErrorCode()) : null;
            String string = vVar.hasMessage() ? cVar.getString(vVar.getMessage()) : null;
            v.d versionKind = vVar.getVersionKind();
            m.checkNotNullExpressionValue(versionKind, "info.versionKind");
            return new h(bVarDecode, versionKind, aVar2, numValueOf, string);
        }
    }
}
