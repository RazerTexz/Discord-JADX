package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: modifierChecks.kt */
/* renamed from: d0.e0.p.d.m0.o.c */
/* loaded from: classes3.dex */
public abstract class AbstractC12021c {

    /* renamed from: a */
    public final boolean f24900a;

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.c$a */
    public static final class a extends AbstractC12021c {

        /* renamed from: b */
        public static final a f24901b = new a();

        public a() {
            super(false, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.c$b */
    public static final class b extends AbstractC12021c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(false, null);
            Intrinsics3.checkNotNullParameter(str, "error");
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.c$c */
    public static final class c extends AbstractC12021c {

        /* renamed from: b */
        public static final c f24902b = new c();

        public c() {
            super(true, null);
        }
    }

    public AbstractC12021c(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24900a = z2;
    }

    public final boolean isSuccess() {
        return this.f24900a;
    }
}
