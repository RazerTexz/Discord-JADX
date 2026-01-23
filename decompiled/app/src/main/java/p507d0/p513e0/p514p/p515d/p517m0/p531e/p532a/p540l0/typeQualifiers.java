package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.e, reason: use source file name */
/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeQualifiers {

    /* JADX INFO: renamed from: a */
    public static final a f23450a = new a(null);

    /* JADX INFO: renamed from: b */
    public static final typeQualifiers f23451b = new typeQualifiers(null, null, false, false, 8, null);

    /* JADX INFO: renamed from: c */
    public final typeQualifiers3 f23452c;

    /* JADX INFO: renamed from: d */
    public final typeQualifiers2 f23453d;

    /* JADX INFO: renamed from: e */
    public final boolean f23454e;

    /* JADX INFO: renamed from: f */
    public final boolean f23455f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.e$a */
    /* JADX INFO: compiled from: typeQualifiers.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final typeQualifiers getNONE() {
            return typeQualifiers.access$getNONE$cp();
        }
    }

    public typeQualifiers(typeQualifiers3 typequalifiers3, typeQualifiers2 typequalifiers2, boolean z2, boolean z3) {
        this.f23452c = typequalifiers3;
        this.f23453d = typequalifiers2;
        this.f23454e = z2;
        this.f23455f = z3;
    }

    public static final /* synthetic */ typeQualifiers access$getNONE$cp() {
        return f23451b;
    }

    public final typeQualifiers2 getMutability() {
        return this.f23453d;
    }

    public final typeQualifiers3 getNullability() {
        return this.f23452c;
    }

    public final boolean isNotNullTypeParameter() {
        return this.f23454e;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.f23455f;
    }

    public /* synthetic */ typeQualifiers(typeQualifiers3 typequalifiers3, typeQualifiers2 typequalifiers2, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typequalifiers3, typequalifiers2, z2, (i & 8) != 0 ? false : z3);
    }
}
