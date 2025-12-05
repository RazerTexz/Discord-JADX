package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* renamed from: d0.e0.p.d.m0.b.q.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer extends KotlinBuiltIns {

    /* renamed from: f */
    public static final a f22612f = new a(null);

    /* renamed from: g */
    public static final KotlinBuiltIns f22613g = new JvmBuiltInsCustomizer();

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: d0.e0.p.d.m0.b.q.b$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinBuiltIns getInstance() {
            return JvmBuiltInsCustomizer.access$getInstance$cp();
        }
    }

    public JvmBuiltInsCustomizer() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        m9361d(true);
    }

    public static final /* synthetic */ KotlinBuiltIns access$getInstance$cp() {
        return f22613g;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns
    /* renamed from: h */
    public /* bridge */ /* synthetic */ PlatformDependentDeclarationFilter mo9365h() {
        return PlatformDependentDeclarationFilter.a.f22797a;
    }
}
