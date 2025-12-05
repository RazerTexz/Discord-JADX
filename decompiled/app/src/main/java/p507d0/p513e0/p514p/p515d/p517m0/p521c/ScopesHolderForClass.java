package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: ScopesHolderForClass.kt */
/* renamed from: d0.e0.p.d.m0.c.r0, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScopesHolderForClass<T extends MemberScope3> {

    /* renamed from: a */
    public static final a f23077a = new a(null);

    /* renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f23078b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: c */
    public final ClassDescriptor f23079c;

    /* renamed from: d */
    public final Function1<KotlinTypeRefiner, T> f23080d;

    /* renamed from: e */
    public final KotlinTypeRefiner f23081e;

    /* renamed from: f */
    public final storage5 f23082f;

    /* compiled from: ScopesHolderForClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.r0$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends MemberScope3> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefiner, Function1<? super KotlinTypeRefiner, ? extends T> function1) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
            Intrinsics3.checkNotNullParameter(function1, "scopeFactory");
            return new ScopesHolderForClass<>(classDescriptor, storageManager, function1, kotlinTypeRefiner, null);
        }
    }

    /* compiled from: ScopesHolderForClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.r0$b */
    public static final class b extends Lambda implements Function0<T> {
        public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
        public final /* synthetic */ ScopesHolderForClass<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ScopesHolderForClass<T> scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
            super(0);
            this.this$0 = scopesHolderForClass;
            this.$kotlinTypeRefiner = kotlinTypeRefiner;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) ScopesHolderForClass.access$getScopeFactory$p(this.this$0).invoke(this.$kotlinTypeRefiner);
        }
    }

    public ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23079c = classDescriptor;
        this.f23080d = function1;
        this.f23081e = kotlinTypeRefiner;
        this.f23082f = storageManager.createLazyValue(new ScopesHolderForClass2(this));
    }

    public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefinerForOwnerModule$p(ScopesHolderForClass scopesHolderForClass) {
        return scopesHolderForClass.f23081e;
    }

    public static final /* synthetic */ Function1 access$getScopeFactory$p(ScopesHolderForClass scopesHolderForClass) {
        return scopesHolderForClass.f23080d;
    }

    public final T getScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtils2.getModule(this.f23079c))) {
            return (T) storage7.getValue(this.f23082f, this, (KProperty<?>) f23078b[0]);
        }
        TypeConstructor typeConstructor = this.f23079c.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        return !kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor) ? (T) storage7.getValue(this.f23082f, this, (KProperty<?>) f23078b[0]) : (T) kotlinTypeRefiner.getOrPutScopeForClass(this.f23079c, new b(this, kotlinTypeRefiner));
    }
}
