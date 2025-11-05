package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.a;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.j1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: FunctionDescriptorImpl.java */
/* loaded from: classes3.dex */
public abstract class q extends l implements d0.e0.p.d.m0.c.x {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public Collection<? extends d0.e0.p.d.m0.c.x> G;
    public volatile Function0<Collection<d0.e0.p.d.m0.c.x>> H;
    public final d0.e0.p.d.m0.c.x I;
    public final b.a J;
    public d0.e0.p.d.m0.c.x K;
    public Map<a.InterfaceC0511a<?>, Object> L;
    public List<z0> n;
    public List<c1> o;
    public d0.e0.p.d.m0.n.c0 p;
    public q0 q;
    public q0 r;

    /* renamed from: s, reason: collision with root package name */
    public d0.e0.p.d.m0.c.z f3271s;
    public d0.e0.p.d.m0.c.u t;
    public boolean u;
    public boolean v;
    public boolean w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f3272x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f3273y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3274z;

    /* compiled from: FunctionDescriptorImpl.java */
    public class a implements Function0<Collection<d0.e0.p.d.m0.c.x>> {
        public final /* synthetic */ d0.e0.p.d.m0.n.c1 j;

        public a(d0.e0.p.d.m0.n.c1 c1Var) {
            this.j = c1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<d0.e0.p.d.m0.c.x> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public Collection<d0.e0.p.d.m0.c.x> invoke2() {
            d0.e0.p.d.m0.p.i iVar = new d0.e0.p.d.m0.p.i();
            Iterator<? extends d0.e0.p.d.m0.c.x> it = q.this.getOverriddenDescriptors().iterator();
            while (it.hasNext()) {
                iVar.add(it.next().substitute(this.j));
            }
            return iVar;
        }
    }

    /* compiled from: FunctionDescriptorImpl.java */
    public static class b implements Function0<List<d1>> {
        public final /* synthetic */ List j;

        public b(List list) {
            this.j = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<d1> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public List<d1> invoke2() {
            return this.j;
        }
    }

    /* compiled from: FunctionDescriptorImpl.java */
    public class c implements x.a<d0.e0.p.d.m0.c.x> {
        public d0.e0.p.d.m0.n.z0 a;

        /* renamed from: b, reason: collision with root package name */
        public d0.e0.p.d.m0.c.m f3275b;
        public d0.e0.p.d.m0.c.z c;
        public d0.e0.p.d.m0.c.u d;
        public d0.e0.p.d.m0.c.x e;
        public b.a f;
        public List<c1> g;
        public q0 h;
        public q0 i;
        public d0.e0.p.d.m0.n.c0 j;
        public d0.e0.p.d.m0.g.e k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public List<z0> q;
        public d0.e0.p.d.m0.c.g1.g r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f3276s;
        public Map<a.InterfaceC0511a<?>, Object> t;
        public Boolean u;
        public boolean v;
        public final /* synthetic */ q w;

        public c(q qVar, d0.e0.p.d.m0.n.z0 z0Var, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, List<c1> list, q0 q0Var, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.g.e eVar) {
            if (z0Var == null) {
                a(0);
                throw null;
            }
            if (mVar == null) {
                a(1);
                throw null;
            }
            if (zVar == null) {
                a(2);
                throw null;
            }
            if (uVar == null) {
                a(3);
                throw null;
            }
            if (aVar == null) {
                a(4);
                throw null;
            }
            if (list == null) {
                a(5);
                throw null;
            }
            if (c0Var == null) {
                a(6);
                throw null;
            }
            this.w = qVar;
            this.e = null;
            this.i = qVar.r;
            this.l = true;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = qVar.isHiddenToOvercomeSignatureClash();
            this.q = null;
            this.r = null;
            this.f3276s = qVar.isHiddenForResolutionEverywhereBesideSupercalls();
            this.t = new LinkedHashMap();
            this.u = null;
            this.v = false;
            this.a = z0Var;
            this.f3275b = mVar;
            this.c = zVar;
            this.d = uVar;
            this.f = aVar;
            this.g = list;
            this.h = q0Var;
            this.j = c0Var;
            this.k = eVar;
        }

        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i2 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(str2);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public d0.e0.p.d.m0.c.x build() {
            return this.w.c(this);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setAdditionalAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
            return setAdditionalAnnotations(gVar);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setCopyOverrides(boolean z2) {
            return setCopyOverrides(z2);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setDispatchReceiverParameter(q0 q0Var) {
            return setDispatchReceiverParameter(q0Var);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setDropOriginalInContainingParts() {
            return setDropOriginalInContainingParts();
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setExtensionReceiverParameter(q0 q0Var) {
            return setExtensionReceiverParameter(q0Var);
        }

        public c setHasSynthesizedParameterNames(boolean z2) {
            this.u = Boolean.valueOf(z2);
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setHiddenForResolutionEverywhereBesideSupercalls() {
            return setHiddenForResolutionEverywhereBesideSupercalls();
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setHiddenToOvercomeSignatureClash() {
            return setHiddenToOvercomeSignatureClash();
        }

        public c setJustForTypeSubstitution(boolean z2) {
            this.v = z2;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setKind(b.a aVar) {
            return setKind(aVar);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setModality(d0.e0.p.d.m0.c.z zVar) {
            return setModality(zVar);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setName(d0.e0.p.d.m0.g.e eVar) {
            return setName(eVar);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setOriginal(d0.e0.p.d.m0.c.b bVar) {
            return setOriginal(bVar);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setOwner(d0.e0.p.d.m0.c.m mVar) {
            return setOwner(mVar);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setPreserveSourceElement() {
            return setPreserveSourceElement();
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setReturnType(d0.e0.p.d.m0.n.c0 c0Var) {
            return setReturnType(c0Var);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setSignatureChange() {
            return setSignatureChange();
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setSubstitution(d0.e0.p.d.m0.n.z0 z0Var) {
            return setSubstitution(z0Var);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setTypeParameters(List list) {
            return setTypeParameters((List<z0>) list);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setValueParameters(List list) {
            return setValueParameters((List<c1>) list);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x.a setVisibility(d0.e0.p.d.m0.c.u uVar) {
            return setVisibility(uVar);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setAdditionalAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
            if (gVar != null) {
                this.r = gVar;
                return this;
            }
            a(32);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setCopyOverrides(boolean z2) {
            this.l = z2;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setDispatchReceiverParameter(q0 q0Var) {
            this.i = q0Var;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setDropOriginalInContainingParts() {
            this.o = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setExtensionReceiverParameter(q0 q0Var) {
            this.h = q0Var;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setHiddenForResolutionEverywhereBesideSupercalls() {
            this.f3276s = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setHiddenToOvercomeSignatureClash() {
            this.p = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setKind(b.a aVar) {
            if (aVar != null) {
                this.f = aVar;
                return this;
            }
            a(13);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setModality(d0.e0.p.d.m0.c.z zVar) {
            if (zVar != null) {
                this.c = zVar;
                return this;
            }
            a(9);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setName(d0.e0.p.d.m0.g.e eVar) {
            if (eVar != null) {
                this.k = eVar;
                return this;
            }
            a(16);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setOriginal(d0.e0.p.d.m0.c.b bVar) {
            this.e = (d0.e0.p.d.m0.c.x) bVar;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setOwner(d0.e0.p.d.m0.c.m mVar) {
            if (mVar != null) {
                this.f3275b = mVar;
                return this;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setPreserveSourceElement() {
            this.n = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setReturnType(d0.e0.p.d.m0.n.c0 c0Var) {
            if (c0Var != null) {
                this.j = c0Var;
                return this;
            }
            a(22);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setSignatureChange() {
            this.m = true;
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setSubstitution(d0.e0.p.d.m0.n.z0 z0Var) {
            if (z0Var != null) {
                this.a = z0Var;
                return this;
            }
            a(34);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setTypeParameters(List<z0> list) {
            if (list != null) {
                this.q = list;
                return this;
            }
            a(20);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setValueParameters(List<c1> list) {
            if (list != null) {
                this.g = list;
                return this;
            }
            a(18);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public c setVisibility(d0.e0.p.d.m0.c.u uVar) {
            if (uVar != null) {
                this.d = uVar;
                return this;
            }
            a(11);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.x xVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, b.a aVar, u0 u0Var) {
        super(mVar, gVar, eVar, u0Var);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
            a(1);
            throw null;
        }
        if (eVar == null) {
            a(2);
            throw null;
        }
        if (aVar == null) {
            a(3);
            throw null;
        }
        if (u0Var == null) {
            a(4);
            throw null;
        }
        this.t = d0.e0.p.d.m0.c.t.i;
        this.u = false;
        this.v = false;
        this.w = false;
        this.f3272x = false;
        this.f3273y = false;
        this.f3274z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = null;
        this.H = null;
        this.K = null;
        this.L = null;
        this.I = xVar == null ? this : xVar;
        this.J = aVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i2 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static List<c1> getSubstitutedValueParameters(d0.e0.p.d.m0.c.x xVar, List<c1> list, d0.e0.p.d.m0.n.c1 c1Var) {
        if (list == null) {
            a(26);
            throw null;
        }
        if (c1Var != null) {
            return getSubstitutedValueParameters(xVar, list, c1Var, false, false, null);
        }
        a(27);
        throw null;
    }

    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitFunctionDescriptor(this, d);
    }

    public abstract q b(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.x xVar, b.a aVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var);

    public d0.e0.p.d.m0.c.x c(c cVar) {
        f0 f0Var;
        q0 q0Var;
        d0.e0.p.d.m0.n.c0 c0VarSubstitute;
        if (cVar == null) {
            a(23);
            throw null;
        }
        boolean[] zArr = new boolean[1];
        d0.e0.p.d.m0.c.g1.g gVarComposeAnnotations = cVar.r != null ? d0.e0.p.d.m0.c.g1.i.composeAnnotations(getAnnotations(), cVar.r) : getAnnotations();
        d0.e0.p.d.m0.c.m mVar = cVar.f3275b;
        d0.e0.p.d.m0.c.x xVar = cVar.e;
        b.a aVar = cVar.f;
        d0.e0.p.d.m0.g.e eVar = cVar.k;
        u0 source = cVar.n ? (xVar != null ? xVar : getOriginal()).getSource() : u0.a;
        if (source == null) {
            a(25);
            throw null;
        }
        q qVarB = b(mVar, xVar, aVar, eVar, gVarComposeAnnotations, source);
        List<z0> typeParameters = cVar.q;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        d0.e0.p.d.m0.n.c1 c1VarSubstituteTypeParameters = d0.e0.p.d.m0.n.o.substituteTypeParameters(typeParameters, cVar.a, qVarB, arrayList, zArr);
        if (c1VarSubstituteTypeParameters == null) {
            return null;
        }
        q0 q0Var2 = cVar.h;
        if (q0Var2 != null) {
            d0.e0.p.d.m0.n.c0 c0VarSubstitute2 = c1VarSubstituteTypeParameters.substitute(q0Var2.getType(), j1.IN_VARIANCE);
            if (c0VarSubstitute2 == null) {
                return null;
            }
            f0 f0Var2 = new f0(qVarB, new d0.e0.p.d.m0.k.a0.p.b(qVarB, c0VarSubstitute2, cVar.h.getValue()), cVar.h.getAnnotations());
            zArr[0] = (c0VarSubstitute2 != cVar.h.getType()) | zArr[0];
            f0Var = f0Var2;
        } else {
            f0Var = null;
        }
        q0 q0Var3 = cVar.i;
        if (q0Var3 != null) {
            q0 q0VarSubstitute = q0Var3.substitute(c1VarSubstituteTypeParameters);
            if (q0VarSubstitute == null) {
                return null;
            }
            zArr[0] = zArr[0] | (q0VarSubstitute != cVar.i);
            q0Var = q0VarSubstitute;
        } else {
            q0Var = null;
        }
        List<c1> substitutedValueParameters = getSubstitutedValueParameters(qVarB, cVar.g, c1VarSubstituteTypeParameters, cVar.o, cVar.n, zArr);
        if (substitutedValueParameters == null || (c0VarSubstitute = c1VarSubstituteTypeParameters.substitute(cVar.j, j1.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (c0VarSubstitute != cVar.j);
        if (!zArr[0] && cVar.v) {
            return this;
        }
        qVarB.initialize(f0Var, q0Var, arrayList, substitutedValueParameters, c0VarSubstitute, cVar.c, cVar.d);
        qVarB.setOperator(this.u);
        qVarB.setInfix(this.v);
        qVarB.setExternal(this.w);
        qVarB.setInline(this.f3272x);
        qVarB.setTailrec(this.f3273y);
        qVarB.setSuspend(this.D);
        qVarB.setExpect(this.f3274z);
        qVarB.setActual(this.A);
        qVarB.setHasStableParameterNames(this.E);
        qVarB.B = cVar.p;
        qVarB.C = cVar.f3276s;
        Boolean bool = cVar.u;
        qVarB.setHasSynthesizedParameterNames(bool != null ? bool.booleanValue() : this.F);
        if (!cVar.t.isEmpty() || this.L != null) {
            Map<a.InterfaceC0511a<?>, Object> map = cVar.t;
            Map<a.InterfaceC0511a<?>, Object> map2 = this.L;
            if (map2 != null) {
                for (Map.Entry<a.InterfaceC0511a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                qVarB.L = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                qVarB.L = map;
            }
        }
        if (cVar.m || getInitialSignatureDescriptor() != null) {
            qVarB.K = (getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this).substitute(c1VarSubstituteTypeParameters);
        }
        if (cVar.l && !getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (cVar.a.isEmpty()) {
                Function0<Collection<d0.e0.p.d.m0.c.x>> function0 = this.H;
                if (function0 != null) {
                    qVarB.H = function0;
                } else {
                    qVarB.setOverriddenDescriptors(getOverriddenDescriptors());
                }
            } else {
                qVarB.H = new a(c1VarSubstituteTypeParameters);
            }
        }
        return qVarB;
    }

    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, boolean z2) {
        return copy(mVar, zVar, uVar, aVar, z2);
    }

    public c d(d0.e0.p.d.m0.n.c1 c1Var) {
        if (c1Var != null) {
            return new c(this, c1Var.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getExtensionReceiverParameter(), getReturnType(), null);
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.a
    public q0 getDispatchReceiverParameter() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.a
    public q0 getExtensionReceiverParameter() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.c.x
    public d0.e0.p.d.m0.c.x getInitialSignatureDescriptor() {
        return this.K;
    }

    @Override // d0.e0.p.d.m0.c.b
    public b.a getKind() {
        b.a aVar = this.J;
        if (aVar != null) {
            return aVar;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        d0.e0.p.d.m0.c.z zVar = this.f3271s;
        if (zVar != null) {
            return zVar;
        }
        a(13);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    public Collection<? extends d0.e0.p.d.m0.c.x> getOverriddenDescriptors() {
        Function0<Collection<d0.e0.p.d.m0.c.x>> function0 = this.H;
        if (function0 != null) {
            this.G = function0.invoke();
            this.H = null;
        }
        Collection<? extends d0.e0.p.d.m0.c.x> collectionEmptyList = this.G;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList != null) {
            return collectionEmptyList;
        }
        a(12);
        throw null;
    }

    public d0.e0.p.d.m0.n.c0 getReturnType() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.a
    public List<z0> getTypeParameters() {
        List<z0> list = this.n;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // d0.e0.p.d.m0.c.a
    public <V> V getUserData(a.InterfaceC0511a<V> interfaceC0511a) {
        Map<a.InterfaceC0511a<?>, Object> map = this.L;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0511a);
    }

    @Override // d0.e0.p.d.m0.c.a
    public List<c1> getValueParameters() {
        List<c1> list = this.o;
        if (list != null) {
            return list;
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = this.t;
        if (uVar != null) {
            return uVar;
        }
        a(14);
        throw null;
    }

    public boolean hasStableParameterNames() {
        return this.E;
    }

    @Override // d0.e0.p.d.m0.c.a
    public boolean hasSynthesizedParameterNames() {
        return this.F;
    }

    public q initialize(q0 q0Var, q0 q0Var2, List<? extends z0> list, List<c1> list2, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar) {
        if (list == null) {
            a(5);
            throw null;
        }
        if (list2 == null) {
            a(6);
            throw null;
        }
        if (uVar == null) {
            a(7);
            throw null;
        }
        this.n = d0.t.u.toList(list);
        this.o = d0.t.u.toList(list2);
        this.p = c0Var;
        this.f3271s = zVar;
        this.t = uVar;
        this.q = q0Var;
        this.r = q0Var2;
        for (int i = 0; i < list.size(); i++) {
            z0 z0Var = list.get(i);
            if (z0Var.getIndex() != i) {
                throw new IllegalStateException(z0Var + " index is " + z0Var.getIndex() + " but position is " + i);
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c1 c1Var = list2.get(i2);
            if (c1Var.getIndex() != i2 + 0) {
                throw new IllegalStateException(c1Var + "index is " + c1Var.getIndex() + " but position is " + i2);
            }
        }
        return this;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return this.A;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return this.f3274z;
    }

    public boolean isExternal() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.C;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.B;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isInfix() {
        if (this.v) {
            return true;
        }
        Iterator<? extends d0.e0.p.d.m0.c.x> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f3272x;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isOperator() {
        if (this.u) {
            return true;
        }
        Iterator<? extends d0.e0.p.d.m0.c.x> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.x
    public boolean isSuspend() {
        return this.D;
    }

    public boolean isTailrec() {
        return this.f3273y;
    }

    public x.a<? extends d0.e0.p.d.m0.c.x> newCopyBuilder() {
        return d(d0.e0.p.d.m0.n.c1.a);
    }

    public <V> void putInUserDataMap(a.InterfaceC0511a<V> interfaceC0511a, Object obj) {
        if (this.L == null) {
            this.L = new LinkedHashMap();
        }
        this.L.put(interfaceC0511a, obj);
    }

    public void setActual(boolean z2) {
        this.A = z2;
    }

    public void setExpect(boolean z2) {
        this.f3274z = z2;
    }

    public void setExternal(boolean z2) {
        this.w = z2;
    }

    public void setHasStableParameterNames(boolean z2) {
        this.E = z2;
    }

    public void setHasSynthesizedParameterNames(boolean z2) {
        this.F = z2;
    }

    public void setInfix(boolean z2) {
        this.v = z2;
    }

    public void setInline(boolean z2) {
        this.f3272x = z2;
    }

    public void setOperator(boolean z2) {
        this.u = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        if (collection == 0) {
            a(15);
            throw null;
        }
        this.G = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((d0.e0.p.d.m0.c.x) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.C = true;
                return;
            }
        }
    }

    public void setReturnType(d0.e0.p.d.m0.n.c0 c0Var) {
        if (c0Var != null) {
            this.p = c0Var;
        } else {
            a(10);
            throw null;
        }
    }

    public void setSuspend(boolean z2) {
        this.D = z2;
    }

    public void setTailrec(boolean z2) {
        this.f3273y = z2;
    }

    public void setVisibility(d0.e0.p.d.m0.c.u uVar) {
        if (uVar != null) {
            this.t = uVar;
        } else {
            a(9);
            throw null;
        }
    }

    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        return substitute(c1Var);
    }

    public d0.e0.p.d.m0.c.x copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, boolean z2) {
        d0.e0.p.d.m0.c.x xVarBuild = newCopyBuilder().setOwner(mVar).setModality(zVar).setVisibility(uVar).setKind(aVar).setCopyOverrides(z2).build();
        if (xVarBuild != null) {
            return xVarBuild;
        }
        a(24);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    public d0.e0.p.d.m0.c.x substitute(d0.e0.p.d.m0.n.c1 c1Var) {
        if (c1Var != null) {
            return c1Var.isEmpty() ? this : d(c1Var).setOriginal((d0.e0.p.d.m0.c.b) getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
        }
        a(20);
        throw null;
    }

    public static List<c1> getSubstitutedValueParameters(d0.e0.p.d.m0.c.x xVar, List<c1> list, d0.e0.p.d.m0.n.c1 c1Var, boolean z2, boolean z3, boolean[] zArr) {
        if (list == null) {
            a(28);
            throw null;
        }
        if (c1Var != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (c1 c1Var2 : list) {
                d0.e0.p.d.m0.n.c0 type = c1Var2.getType();
                j1 j1Var = j1.IN_VARIANCE;
                d0.e0.p.d.m0.n.c0 c0VarSubstitute = c1Var.substitute(type, j1Var);
                d0.e0.p.d.m0.n.c0 varargElementType = c1Var2.getVarargElementType();
                d0.e0.p.d.m0.n.c0 c0VarSubstitute2 = varargElementType == null ? null : c1Var.substitute(varargElementType, j1Var);
                if (c0VarSubstitute == null) {
                    return null;
                }
                if ((c0VarSubstitute != c1Var2.getType() || varargElementType != c0VarSubstitute2) && zArr != null) {
                    zArr[0] = true;
                }
                arrayList.add(l0.createWithDestructuringDeclarations(xVar, z2 ? null : c1Var2, c1Var2.getIndex(), c1Var2.getAnnotations(), c1Var2.getName(), c0VarSubstitute, c1Var2.declaresDefaultValue(), c1Var2.isCrossinline(), c1Var2.isNoinline(), c0VarSubstitute2, z3 ? c1Var2.getSource() : u0.a, c1Var2 instanceof l0.b ? new b(((l0.b) c1Var2).getDestructuringVariables()) : null));
            }
            return arrayList;
        }
        a(29);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.p getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.x getOriginal() {
        d0.e0.p.d.m0.c.x xVar = this.I;
        d0.e0.p.d.m0.c.x original = xVar == this ? this : xVar.getOriginal();
        if (original != null) {
            return original;
        }
        a(18);
        throw null;
    }
}
