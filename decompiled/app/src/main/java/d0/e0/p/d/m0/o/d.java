package d0.e0.p.d.m0.o;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.o.c;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public final class d {
    public final d0.e0.p.d.m0.g.e a;

    /* renamed from: b, reason: collision with root package name */
    public final Regex f3547b;
    public final Collection<d0.e0.p.d.m0.g.e> c;
    public final Function1<x, String> d;
    public final d0.e0.p.d.m0.o.b[] e;

    /* compiled from: modifierChecks.kt */
    public static final class a extends o implements Function1 {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((x) obj);
        }

        public final Void invoke(x xVar) {
            m.checkNotNullParameter(xVar, "<this>");
            return null;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends o implements Function1 {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((x) obj);
        }

        public final Void invoke(x xVar) {
            m.checkNotNullParameter(xVar, "<this>");
            return null;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class c extends o implements Function1 {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((x) obj);
        }

        public final Void invoke(x xVar) {
            m.checkNotNullParameter(xVar, "<this>");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(d0.e0.p.d.m0.g.e eVar, Regex regex, Collection<d0.e0.p.d.m0.g.e> collection, Function1<? super x, String> function1, d0.e0.p.d.m0.o.b... bVarArr) {
        this.a = null;
        this.f3547b = regex;
        this.c = collection;
        this.d = function1;
        this.e = bVarArr;
    }

    public final d0.e0.p.d.m0.o.c checkAll(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        d0.e0.p.d.m0.o.b[] bVarArr = this.e;
        int length = bVarArr.length;
        int i = 0;
        while (i < length) {
            d0.e0.p.d.m0.o.b bVar = bVarArr[i];
            i++;
            String strInvoke = bVar.invoke(xVar);
            if (strInvoke != null) {
                return new c.b(strInvoke);
            }
        }
        String strInvoke2 = this.d.invoke(xVar);
        return strInvoke2 != null ? new c.b(strInvoke2) : c.C0587c.f3546b;
    }

    public final boolean isApplicable(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        if (this.a != null && !m.areEqual(xVar.getName(), this.a)) {
            return false;
        }
        if (this.f3547b != null) {
            String strAsString = xVar.getName().asString();
            m.checkNotNullExpressionValue(strAsString, "functionDescriptor.name.asString()");
            if (!this.f3547b.matches(strAsString)) {
                return false;
            }
        }
        Collection<d0.e0.p.d.m0.g.e> collection = this.c;
        return collection == null || collection.contains(xVar.getName());
    }

    public /* synthetic */ d(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.o.b[] bVarArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, bVarArr, (Function1<? super x, String>) ((i & 4) != 0 ? a.j : function1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.o.b[] bVarArr, Function1<? super x, String> function1) {
        m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(bVarArr, "checks");
        m.checkNotNullParameter(function1, "additionalChecks");
        d0.e0.p.d.m0.o.b[] bVarArr2 = new d0.e0.p.d.m0.o.b[bVarArr.length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        this.a = eVar;
        this.f3547b = null;
        this.c = null;
        this.d = function1;
        this.e = bVarArr2;
    }

    public /* synthetic */ d(Regex regex, d0.e0.p.d.m0.o.b[] bVarArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, bVarArr, (Function1<? super x, String>) ((i & 4) != 0 ? b.j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Regex regex, d0.e0.p.d.m0.o.b[] bVarArr, Function1<? super x, String> function1) {
        m.checkNotNullParameter(regex, "regex");
        m.checkNotNullParameter(bVarArr, "checks");
        m.checkNotNullParameter(function1, "additionalChecks");
        d0.e0.p.d.m0.o.b[] bVarArr2 = new d0.e0.p.d.m0.o.b[bVarArr.length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        this((d0.e0.p.d.m0.g.e) null, regex, (Collection<d0.e0.p.d.m0.g.e>) null, function1, bVarArr2);
    }

    public /* synthetic */ d(Collection collection, d0.e0.p.d.m0.o.b[] bVarArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Collection<d0.e0.p.d.m0.g.e>) collection, bVarArr, (Function1<? super x, String>) ((i & 4) != 0 ? c.j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Collection<d0.e0.p.d.m0.g.e> collection, d0.e0.p.d.m0.o.b[] bVarArr, Function1<? super x, String> function1) {
        m.checkNotNullParameter(collection, "nameList");
        m.checkNotNullParameter(bVarArr, "checks");
        m.checkNotNullParameter(function1, "additionalChecks");
        d0.e0.p.d.m0.o.b[] bVarArr2 = new d0.e0.p.d.m0.o.b[bVarArr.length];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        this((d0.e0.p.d.m0.g.e) null, (Regex) null, collection, function1, bVarArr2);
    }
}
