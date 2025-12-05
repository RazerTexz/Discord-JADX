package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: constantValues.kt */
/* renamed from: d0.e0.p.d.m0.k.v.k */
/* loaded from: classes3.dex */
public abstract class AbstractC11819k extends AbstractC11815g<Unit> {

    /* renamed from: b */
    public static final a f24442b = new a(null);

    /* compiled from: constantValues.kt */
    /* renamed from: d0.e0.p.d.m0.k.v.k$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC11819k create(String str) {
            Intrinsics3.checkNotNullParameter(str, "message");
            return new b(str);
        }
    }

    /* compiled from: constantValues.kt */
    /* renamed from: d0.e0.p.d.m0.k.v.k$b */
    public static final class b extends AbstractC11819k {

        /* renamed from: c */
        public final String f24443c;

        public b(String str) {
            Intrinsics3.checkNotNullParameter(str, "message");
            this.f24443c = str;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
        public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
            return getType(moduleDescriptor2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
        public String toString() {
            return this.f24443c;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
        public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(this.f24443c);
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(message)");
            return kotlinType4CreateErrorType;
        }
    }

    public AbstractC11819k() {
        super(Unit.f27425a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public /* bridge */ /* synthetic */ Unit getValue() {
        return getValue2();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public Unit getValue2() {
        throw new UnsupportedOperationException();
    }
}
