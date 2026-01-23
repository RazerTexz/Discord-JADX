package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12021c;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.d */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12022d {

    /* JADX INFO: renamed from: a */
    public final Name f24903a;

    /* JADX INFO: renamed from: b */
    public final Regex f24904b;

    /* JADX INFO: renamed from: c */
    public final Collection<Name> f24905c;

    /* JADX INFO: renamed from: d */
    public final Function1<FunctionDescriptor, String> f24906d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC12020b[] f24907e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.d$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends Lambda implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final a f24908j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((FunctionDescriptor) obj);
        }

        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.d$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final b f24909j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((FunctionDescriptor) obj);
        }

        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.d$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final c f24910j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((FunctionDescriptor) obj);
        }

        public final Void invoke(FunctionDescriptor functionDescriptor) {
            Intrinsics3.checkNotNullParameter(functionDescriptor, "<this>");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12022d(Name name, Regex regex, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, InterfaceC12020b... interfaceC12020bArr) {
        this.f24903a = null;
        this.f24904b = regex;
        this.f24905c = collection;
        this.f24906d = function1;
        this.f24907e = interfaceC12020bArr;
    }

    public final AbstractC12021c checkAll(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        InterfaceC12020b[] interfaceC12020bArr = this.f24907e;
        int length = interfaceC12020bArr.length;
        int i = 0;
        while (i < length) {
            InterfaceC12020b interfaceC12020b = interfaceC12020bArr[i];
            i++;
            String strInvoke = interfaceC12020b.invoke(functionDescriptor);
            if (strInvoke != null) {
                return new AbstractC12021c.b(strInvoke);
            }
        }
        String strInvoke2 = this.f24906d.invoke(functionDescriptor);
        return strInvoke2 != null ? new AbstractC12021c.b(strInvoke2) : AbstractC12021c.c.f24902b;
    }

    public final boolean isApplicable(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (this.f24903a != null && !Intrinsics3.areEqual(functionDescriptor.getName(), this.f24903a)) {
            return false;
        }
        if (this.f24904b != null) {
            String strAsString = functionDescriptor.getName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "functionDescriptor.name.asString()");
            if (!this.f24904b.matches(strAsString)) {
                return false;
            }
        }
        Collection<Name> collection = this.f24905c;
        return collection == null || collection.contains(functionDescriptor.getName());
    }

    public /* synthetic */ C12022d(Name name, InterfaceC12020b[] interfaceC12020bArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, interfaceC12020bArr, (Function1<? super FunctionDescriptor, String>) ((i & 4) != 0 ? a.f24908j : function1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12022d(Name name, InterfaceC12020b[] interfaceC12020bArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(interfaceC12020bArr, "checks");
        Intrinsics3.checkNotNullParameter(function1, "additionalChecks");
        InterfaceC12020b[] interfaceC12020bArr2 = new InterfaceC12020b[interfaceC12020bArr.length];
        System.arraycopy(interfaceC12020bArr, 0, interfaceC12020bArr2, 0, interfaceC12020bArr.length);
        this.f24903a = name;
        this.f24904b = null;
        this.f24905c = null;
        this.f24906d = function1;
        this.f24907e = interfaceC12020bArr2;
    }

    public /* synthetic */ C12022d(Regex regex, InterfaceC12020b[] interfaceC12020bArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, interfaceC12020bArr, (Function1<? super FunctionDescriptor, String>) ((i & 4) != 0 ? b.f24909j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12022d(Regex regex, InterfaceC12020b[] interfaceC12020bArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics3.checkNotNullParameter(regex, "regex");
        Intrinsics3.checkNotNullParameter(interfaceC12020bArr, "checks");
        Intrinsics3.checkNotNullParameter(function1, "additionalChecks");
        InterfaceC12020b[] interfaceC12020bArr2 = new InterfaceC12020b[interfaceC12020bArr.length];
        System.arraycopy(interfaceC12020bArr, 0, interfaceC12020bArr2, 0, interfaceC12020bArr.length);
        this((Name) null, regex, (Collection<Name>) null, function1, interfaceC12020bArr2);
    }

    public /* synthetic */ C12022d(Collection collection, InterfaceC12020b[] interfaceC12020bArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Collection<Name>) collection, interfaceC12020bArr, (Function1<? super FunctionDescriptor, String>) ((i & 4) != 0 ? c.f24910j : function1));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12022d(Collection<Name> collection, InterfaceC12020b[] interfaceC12020bArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics3.checkNotNullParameter(collection, "nameList");
        Intrinsics3.checkNotNullParameter(interfaceC12020bArr, "checks");
        Intrinsics3.checkNotNullParameter(function1, "additionalChecks");
        InterfaceC12020b[] interfaceC12020bArr2 = new InterfaceC12020b[interfaceC12020bArr.length];
        System.arraycopy(interfaceC12020bArr, 0, interfaceC12020bArr2, 0, interfaceC12020bArr.length);
        this((Name) null, (Regex) null, collection, function1, interfaceC12020bArr2);
    }
}
