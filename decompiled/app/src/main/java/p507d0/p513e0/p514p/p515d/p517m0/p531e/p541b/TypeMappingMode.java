package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypeMappingMode.kt */
/* renamed from: d0.e0.p.d.m0.e.b.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeMappingMode {

    /* renamed from: a */
    public static final TypeMappingMode f23638a;

    /* renamed from: b */
    public static final TypeMappingMode f23639b;

    /* renamed from: c */
    public static final TypeMappingMode f23640c;

    /* renamed from: d */
    public final boolean f23641d;

    /* renamed from: e */
    public final boolean f23642e;

    /* renamed from: f */
    public final boolean f23643f;

    /* renamed from: g */
    public final boolean f23644g;

    /* renamed from: h */
    public final boolean f23645h;

    /* renamed from: i */
    public final TypeMappingMode f23646i;

    /* renamed from: j */
    public final boolean f23647j;

    /* renamed from: k */
    public final TypeMappingMode f23648k;

    /* renamed from: l */
    public final TypeMappingMode f23649l;

    /* renamed from: m */
    public final boolean f23650m;

    /* compiled from: TypeMappingMode.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.z$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        TypeMappingMode typeMappingMode = new TypeMappingMode(false, false, false, false, false, null, false, null, null, false, AudioAttributesCompat.FLAG_ALL, null);
        f23638a = typeMappingMode;
        TypeMappingMode typeMappingMode2 = new TypeMappingMode(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION, null);
        f23639b = typeMappingMode2;
        new TypeMappingMode(false, true, false, false, false, null, false, null, null, false, PointerIconCompat.TYPE_GRABBING, null);
        f23640c = new TypeMappingMode(false, false, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        new TypeMappingMode(false, false, false, false, false, typeMappingMode2, false, null, null, true, 476, null);
        new TypeMappingMode(false, true, false, false, false, typeMappingMode, false, null, null, false, 988, null);
        new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, false, 983, null);
        new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, false, 919, null);
        new TypeMappingMode(false, false, true, false, false, typeMappingMode, false, null, null, false, 984, null);
    }

    public TypeMappingMode(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, TypeMappingMode typeMappingMode, boolean z7, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z8) {
        this.f23641d = z2;
        this.f23642e = z3;
        this.f23643f = z4;
        this.f23644g = z5;
        this.f23645h = z6;
        this.f23646i = typeMappingMode;
        this.f23647j = z7;
        this.f23648k = typeMappingMode2;
        this.f23649l = typeMappingMode3;
        this.f23650m = z8;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.f23647j;
    }

    public final boolean getMapTypeAliases() {
        return this.f23650m;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.f23642e;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.f23641d;
    }

    public final boolean isForAnnotationParameter() {
        return this.f23643f;
    }

    public final TypeMappingMode toGenericArgumentMode(Variance variance, boolean z2) {
        Intrinsics3.checkNotNullParameter(variance, "effectiveVariance");
        if (!z2 || !this.f23643f) {
            int iOrdinal = variance.ordinal();
            if (iOrdinal == 0) {
                TypeMappingMode typeMappingMode = this.f23649l;
                if (typeMappingMode != null) {
                    return typeMappingMode;
                }
            } else if (iOrdinal != 1) {
                TypeMappingMode typeMappingMode2 = this.f23646i;
                if (typeMappingMode2 != null) {
                    return typeMappingMode2;
                }
            } else {
                TypeMappingMode typeMappingMode3 = this.f23648k;
                if (typeMappingMode3 != null) {
                    return typeMappingMode3;
                }
            }
        }
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.f23641d, true, this.f23643f, this.f23644g, this.f23645h, this.f23646i, this.f23647j, this.f23648k, this.f23649l, false, 512, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TypeMappingMode(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, TypeMappingMode typeMappingMode, boolean z7, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z9 = (i & 1) != 0 ? true : z2;
        boolean z10 = (i & 2) != 0 ? true : z3;
        boolean z11 = (i & 4) != 0 ? false : z4;
        boolean z12 = (i & 8) != 0 ? false : z5;
        boolean z13 = (i & 16) != 0 ? false : z6;
        TypeMappingMode typeMappingMode4 = (i & 32) != 0 ? null : typeMappingMode;
        this(z9, z10, z11, z12, z13, typeMappingMode4, (i & 64) == 0 ? z7 : true, (i & 128) != 0 ? typeMappingMode4 : typeMappingMode2, (i & 256) != 0 ? typeMappingMode4 : typeMappingMode3, (i & 512) == 0 ? z8 : false);
    }
}
