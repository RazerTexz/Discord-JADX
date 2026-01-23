package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y, reason: use source file name */
/* JADX INFO: compiled from: ProtoContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ProtoContainer {

    /* JADX INFO: renamed from: a */
    public final NameResolver f24691a;

    /* JADX INFO: renamed from: b */
    public final TypeTable f24692b;

    /* JADX INFO: renamed from: c */
    public final SourceElement f24693c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y$a */
    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class a extends ProtoContainer {

        /* JADX INFO: renamed from: d */
        public final C11678c f24694d;

        /* JADX INFO: renamed from: e */
        public final a f24695e;

        /* JADX INFO: renamed from: f */
        public final ClassId f24696f;

        /* JADX INFO: renamed from: g */
        public final C11678c.c f24697g;

        /* JADX INFO: renamed from: h */
        public final boolean f24698h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11678c c11678c, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, a aVar) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics3.checkNotNullParameter(c11678c, "classProto");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
            this.f24694d = c11678c;
            this.f24695e = aVar;
            this.f24696f = NameResolverUtil.getClassId(nameResolver, c11678c.getFqName());
            C11678c.c cVar = Flags2.f24034e.get(c11678c.getFlags());
            this.f24697g = cVar == null ? C11678c.c.CLASS : cVar;
            Boolean bool = Flags2.f24035f.get(c11678c.getFlags());
            Intrinsics3.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
            this.f24698h = bool.booleanValue();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ProtoContainer
        public FqName debugFqName() {
            FqName fqNameAsSingleFqName = this.f24696f.asSingleFqName();
            Intrinsics3.checkNotNullExpressionValue(fqNameAsSingleFqName, "classId.asSingleFqName()");
            return fqNameAsSingleFqName;
        }

        public final ClassId getClassId() {
            return this.f24696f;
        }

        public final C11678c getClassProto() {
            return this.f24694d;
        }

        public final C11678c.c getKind() {
            return this.f24697g;
        }

        public final a getOuterClass() {
            return this.f24695e;
        }

        public final boolean isInner() {
            return this.f24698h;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y$b */
    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class b extends ProtoContainer {

        /* JADX INFO: renamed from: d */
        public final FqName f24699d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FqName fqName, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
            this.f24699d = fqName;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ProtoContainer
        public FqName debugFqName() {
            return this.f24699d;
        }
    }

    public ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24691a = nameResolver;
        this.f24692b = typeTable;
        this.f24693c = sourceElement;
    }

    public abstract FqName debugFqName();

    public final NameResolver getNameResolver() {
        return this.f24691a;
    }

    public final SourceElement getSource() {
        return this.f24693c;
    }

    public final TypeTable getTypeTable() {
        return this.f24692b;
    }

    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + debugFqName();
    }
}
