package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.j1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: PropertyDescriptorImpl.java */
/* loaded from: classes3.dex */
public class c0 extends n0 implements d0.e0.p.d.m0.c.n0 {
    public final boolean A;
    public q0 B;
    public q0 C;
    public List<z0> D;
    public d0 E;
    public p0 F;
    public boolean G;
    public d0.e0.p.d.m0.c.v H;
    public d0.e0.p.d.m0.c.v I;
    public final d0.e0.p.d.m0.c.z q;
    public d0.e0.p.d.m0.c.u r;

    /* renamed from: s, reason: collision with root package name */
    public Collection<? extends d0.e0.p.d.m0.c.n0> f3259s;
    public final d0.e0.p.d.m0.c.n0 t;
    public final b.a u;
    public final boolean v;
    public final boolean w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f3260x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f3261y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f3262z;

    /* compiled from: PropertyDescriptorImpl.java */
    public class a {
        public d0.e0.p.d.m0.c.m a;

        /* renamed from: b, reason: collision with root package name */
        public d0.e0.p.d.m0.c.z f3263b;
        public d0.e0.p.d.m0.c.u c;
        public b.a e;
        public q0 h;
        public d0.e0.p.d.m0.g.e i;
        public d0.e0.p.d.m0.n.c0 j;
        public d0.e0.p.d.m0.c.n0 d = null;
        public d0.e0.p.d.m0.n.z0 f = d0.e0.p.d.m0.n.z0.a;
        public boolean g = true;

        public a() {
            this.a = c0.this.getContainingDeclaration();
            this.f3263b = c0.this.getModality();
            this.c = c0.this.getVisibility();
            this.e = c0.this.getKind();
            this.h = c0.this.B;
            this.i = c0.this.getName();
            this.j = c0.this.getType();
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 2) {
                objArr[1] = "setOriginal";
            } else if (i == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i == 5) {
                objArr[1] = "setReturnType";
            } else if (i == 7) {
                objArr[1] = "setModality";
            } else if (i == 9) {
                objArr[1] = "setVisibility";
            } else if (i == 11) {
                objArr[1] = "setKind";
            } else if (i == 19) {
                objArr[1] = "setName";
            } else if (i == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i == 16) {
                objArr[1] = "setSubstitution";
            } else if (i != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public d0.e0.p.d.m0.c.n0 build() {
            q0 q0VarSubstitute;
            f0 f0Var;
            d0 d0Var;
            e0 e0Var;
            d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.k.v.g<?>> kVar;
            c0 c0Var = c0.this;
            Objects.requireNonNull(c0Var);
            b.a aVar = b.a.FAKE_OVERRIDE;
            d0.e0.p.d.m0.c.m mVar = this.a;
            d0.e0.p.d.m0.c.z zVar = this.f3263b;
            d0.e0.p.d.m0.c.u uVar = this.c;
            d0.e0.p.d.m0.c.n0 n0Var = this.d;
            b.a aVar2 = this.e;
            d0.e0.p.d.m0.g.e eVar = this.i;
            u0 u0Var = u0.a;
            c0 c0VarB = c0Var.b(mVar, zVar, uVar, n0Var, aVar2, eVar, u0Var);
            List<z0> typeParameters = c0Var.getTypeParameters();
            ArrayList arrayList = new ArrayList(typeParameters.size());
            c1 c1VarSubstituteTypeParameters = d0.e0.p.d.m0.n.o.substituteTypeParameters(typeParameters, this.f, c0VarB, arrayList);
            d0.e0.p.d.m0.n.c0 c0Var2 = this.j;
            j1 j1Var = j1.OUT_VARIANCE;
            d0.e0.p.d.m0.n.c0 c0VarSubstitute = c1VarSubstituteTypeParameters.substitute(c0Var2, j1Var);
            if (c0VarSubstitute == null) {
                return null;
            }
            q0 q0Var = this.h;
            if (q0Var != null) {
                q0VarSubstitute = q0Var.substitute(c1VarSubstituteTypeParameters);
                if (q0VarSubstitute == null) {
                    return null;
                }
            } else {
                q0VarSubstitute = null;
            }
            q0 q0Var2 = c0Var.C;
            if (q0Var2 != null) {
                d0.e0.p.d.m0.n.c0 c0VarSubstitute2 = c1VarSubstituteTypeParameters.substitute(q0Var2.getType(), j1.IN_VARIANCE);
                if (c0VarSubstitute2 == null) {
                    return null;
                }
                f0Var = new f0(c0VarB, new d0.e0.p.d.m0.k.a0.p.b(c0VarB, c0VarSubstitute2, c0Var.C.getValue()), c0Var.C.getAnnotations());
            } else {
                f0Var = null;
            }
            c0VarB.setType(c0VarSubstitute, arrayList, q0VarSubstitute, f0Var);
            d0 d0Var2 = c0Var.E;
            if (d0Var2 == null) {
                d0Var = null;
            } else {
                d0.e0.p.d.m0.c.g1.g annotations = d0Var2.getAnnotations();
                d0.e0.p.d.m0.c.z zVar2 = this.f3263b;
                d0.e0.p.d.m0.c.u visibility = c0Var.E.getVisibility();
                if (this.e == aVar && d0.e0.p.d.m0.c.t.isPrivate(visibility.normalize())) {
                    visibility = d0.e0.p.d.m0.c.t.h;
                }
                d0.e0.p.d.m0.c.u uVar2 = visibility;
                boolean zIsDefault = c0Var.E.isDefault();
                boolean zIsExternal = c0Var.E.isExternal();
                boolean zIsInline = c0Var.E.isInline();
                b.a aVar3 = this.e;
                d0.e0.p.d.m0.c.n0 n0Var2 = this.d;
                d0Var = new d0(c0VarB, annotations, zVar2, uVar2, zIsDefault, zIsExternal, zIsInline, aVar3, n0Var2 == null ? null : n0Var2.getGetter(), u0Var);
            }
            if (d0Var != null) {
                d0.e0.p.d.m0.n.c0 returnType = c0Var.E.getReturnType();
                d0Var.setInitialSignatureDescriptor(c0.c(c1VarSubstituteTypeParameters, c0Var.E));
                d0Var.initialize(returnType != null ? c1VarSubstituteTypeParameters.substitute(returnType, j1Var) : null);
            }
            p0 p0Var = c0Var.F;
            if (p0Var == null) {
                e0Var = null;
            } else {
                d0.e0.p.d.m0.c.g1.g annotations2 = p0Var.getAnnotations();
                d0.e0.p.d.m0.c.z zVar3 = this.f3263b;
                d0.e0.p.d.m0.c.u visibility2 = c0Var.F.getVisibility();
                if (this.e == aVar && d0.e0.p.d.m0.c.t.isPrivate(visibility2.normalize())) {
                    visibility2 = d0.e0.p.d.m0.c.t.h;
                }
                d0.e0.p.d.m0.c.u uVar3 = visibility2;
                boolean zIsDefault2 = c0Var.F.isDefault();
                boolean zIsExternal2 = c0Var.F.isExternal();
                boolean zIsInline2 = c0Var.F.isInline();
                b.a aVar4 = this.e;
                d0.e0.p.d.m0.c.n0 n0Var3 = this.d;
                e0Var = new e0(c0VarB, annotations2, zVar3, uVar3, zIsDefault2, zIsExternal2, zIsInline2, aVar4, n0Var3 == null ? null : n0Var3.getSetter(), u0Var);
            }
            if (e0Var != null) {
                List<d0.e0.p.d.m0.c.c1> substitutedValueParameters = q.getSubstitutedValueParameters(e0Var, c0Var.F.getValueParameters(), c1VarSubstituteTypeParameters, false, false, null);
                if (substitutedValueParameters == null) {
                    c0VarB.setSetterProjectedOut(true);
                    substitutedValueParameters = Collections.singletonList(e0.createSetterParameter(e0Var, d0.e0.p.d.m0.k.x.a.getBuiltIns(this.a).getNothingType(), c0Var.F.getValueParameters().get(0).getAnnotations()));
                }
                if (substitutedValueParameters.size() != 1) {
                    throw new IllegalStateException();
                }
                e0Var.setInitialSignatureDescriptor(c0.c(c1VarSubstituteTypeParameters, c0Var.F));
                e0Var.initialize(substitutedValueParameters.get(0));
            }
            d0.e0.p.d.m0.c.v vVar = c0Var.H;
            p pVar = vVar == null ? null : new p(vVar.getAnnotations(), c0VarB);
            d0.e0.p.d.m0.c.v vVar2 = c0Var.I;
            c0VarB.initialize(d0Var, e0Var, pVar, vVar2 != null ? new p(vVar2.getAnnotations(), c0VarB) : null);
            if (this.g) {
                d0.e0.p.d.m0.p.j jVarCreate = d0.e0.p.d.m0.p.j.create();
                Iterator<? extends d0.e0.p.d.m0.c.n0> it = c0Var.getOverriddenDescriptors().iterator();
                while (it.hasNext()) {
                    jVarCreate.add(it.next().substitute(c1VarSubstituteTypeParameters));
                }
                c0VarB.setOverriddenDescriptors(jVarCreate);
            }
            if (c0Var.isConst() && (kVar = c0Var.p) != null) {
                c0VarB.setCompileTimeInitializer(kVar);
            }
            return c0VarB;
        }

        public a setCopyOverrides(boolean z2) {
            this.g = z2;
            return this;
        }

        public a setKind(b.a aVar) {
            if (aVar != null) {
                this.e = aVar;
                return this;
            }
            a(10);
            throw null;
        }

        public a setModality(d0.e0.p.d.m0.c.z zVar) {
            if (zVar != null) {
                this.f3263b = zVar;
                return this;
            }
            a(6);
            throw null;
        }

        public a setOriginal(d0.e0.p.d.m0.c.b bVar) {
            this.d = (d0.e0.p.d.m0.c.n0) bVar;
            return this;
        }

        public a setOwner(d0.e0.p.d.m0.c.m mVar) {
            if (mVar != null) {
                this.a = mVar;
                return this;
            }
            a(0);
            throw null;
        }

        public a setSubstitution(d0.e0.p.d.m0.n.z0 z0Var) {
            if (z0Var != null) {
                this.f = z0Var;
                return this;
            }
            a(15);
            throw null;
        }

        public a setVisibility(d0.e0.p.d.m0.c.u uVar) {
            if (uVar != null) {
                this.c = uVar;
                return this;
            }
            a(8);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, boolean z2, d0.e0.p.d.m0.g.e eVar, b.a aVar, u0 u0Var, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(mVar, gVar, eVar, null, z2, u0Var);
        if (mVar == null) {
            a(0);
            throw null;
        }
        if (gVar == null) {
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
        if (eVar == null) {
            a(4);
            throw null;
        }
        if (aVar == null) {
            a(5);
            throw null;
        }
        if (u0Var == null) {
            a(6);
            throw null;
        }
        this.f3259s = null;
        this.q = zVar;
        this.r = uVar;
        this.t = n0Var == null ? this : n0Var;
        this.u = aVar;
        this.v = z3;
        this.w = z4;
        this.f3260x = z5;
        this.f3261y = z6;
        this.f3262z = z7;
        this.A = z8;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 23 && i != 33 && i != 34 && i != 36 && i != 37) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 23 && i != 33 && i != 34 && i != 36 && i != 37) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
            case 16:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 5:
            case 12:
            case 30:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 32:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 14:
                objArr[0] = "outType";
                break;
            case 15:
                objArr[0] = "typeParameters";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
                objArr[0] = "copyConfiguration";
                break;
            case 25:
                objArr[0] = "substitutor";
                break;
            case 26:
                objArr[0] = "accessorDescriptor";
                break;
            case 27:
                objArr[0] = "newOwner";
                break;
            case 28:
                objArr[0] = "newModality";
                break;
            case 29:
                objArr[0] = "newVisibility";
                break;
            case 31:
                objArr[0] = "newName";
                break;
            case 35:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        if (i == 23) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i == 33) {
            objArr[1] = "getOriginal";
        } else if (i == 34) {
            objArr[1] = "getKind";
        } else if (i == 36) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 37) {
            switch (i) {
                case 17:
                    objArr[1] = "getTypeParameters";
                    break;
                case 18:
                    objArr[1] = "getReturnType";
                    break;
                case 19:
                    objArr[1] = "getModality";
                    break;
                case 20:
                    objArr[1] = "getVisibility";
                    break;
                case 21:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
            case 15:
                objArr[2] = "setType";
                break;
            case 16:
                objArr[2] = "setVisibility";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "doSubstitute";
                break;
            case 25:
            case 26:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 35:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 23 && i != 33 && i != 34 && i != 36 && i != 37) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static d0.e0.p.d.m0.c.x c(c1 c1Var, d0.e0.p.d.m0.c.m0 m0Var) {
        if (m0Var == null) {
            a(26);
            throw null;
        }
        if (m0Var.getInitialSignatureDescriptor() != null) {
            return m0Var.getInitialSignatureDescriptor().substitute(c1Var);
        }
        return null;
    }

    public static c0 create(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, boolean z2, d0.e0.p.d.m0.g.e eVar, b.a aVar, u0 u0Var, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        if (mVar == null) {
            a(7);
            throw null;
        }
        if (gVar == null) {
            a(8);
            throw null;
        }
        if (zVar == null) {
            a(9);
            throw null;
        }
        if (uVar == null) {
            a(10);
            throw null;
        }
        if (eVar == null) {
            a(11);
            throw null;
        }
        if (aVar == null) {
            a(12);
            throw null;
        }
        if (u0Var != null) {
            return new c0(mVar, null, gVar, zVar, uVar, z2, eVar, aVar, u0Var, z3, z4, z5, z6, z7, z8);
        }
        a(13);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        return oVar.visitPropertyDescriptor(this, d);
    }

    public c0 b(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, d0.e0.p.d.m0.c.n0 n0Var, b.a aVar, d0.e0.p.d.m0.g.e eVar, u0 u0Var) {
        if (mVar == null) {
            a(27);
            throw null;
        }
        if (zVar == null) {
            a(28);
            throw null;
        }
        if (uVar == null) {
            a(29);
            throw null;
        }
        if (aVar == null) {
            a(30);
            throw null;
        }
        if (eVar != null) {
            return new c0(mVar, n0Var, getAnnotations(), zVar, uVar, isVar(), eVar, aVar, u0Var, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
        }
        a(31);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, boolean z2) {
        return copy(mVar, zVar, uVar, aVar, z2);
    }

    @Override // d0.e0.p.d.m0.c.n0
    public List<d0.e0.p.d.m0.c.m0> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        d0 d0Var = this.E;
        if (d0Var != null) {
            arrayList.add(d0Var);
        }
        p0 p0Var = this.F;
        if (p0Var != null) {
            arrayList.add(p0Var);
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.n0
    public d0.e0.p.d.m0.c.v getBackingField() {
        return this.H;
    }

    @Override // d0.e0.p.d.m0.c.n0
    public d0.e0.p.d.m0.c.v getDelegateField() {
        return this.I;
    }

    @Override // d0.e0.p.d.m0.c.i1.m0, d0.e0.p.d.m0.c.a
    public q0 getDispatchReceiverParameter() {
        return this.B;
    }

    @Override // d0.e0.p.d.m0.c.i1.m0, d0.e0.p.d.m0.c.a
    public q0 getExtensionReceiverParameter() {
        return this.C;
    }

    @Override // d0.e0.p.d.m0.c.n0
    public /* bridge */ /* synthetic */ o0 getGetter() {
        return getGetter();
    }

    @Override // d0.e0.p.d.m0.c.b
    public b.a getKind() {
        b.a aVar = this.u;
        if (aVar != null) {
            return aVar;
        }
        a(34);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        d0.e0.p.d.m0.c.z zVar = this.q;
        if (zVar != null) {
            return zVar;
        }
        a(19);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a getOriginal() {
        return getOriginal();
    }

    @Override // d0.e0.p.d.m0.c.a
    public Collection<? extends d0.e0.p.d.m0.c.n0> getOverriddenDescriptors() {
        Collection<? extends d0.e0.p.d.m0.c.n0> collectionEmptyList = this.f3259s;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList != null) {
            return collectionEmptyList;
        }
        a(36);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.m0, d0.e0.p.d.m0.c.a
    public d0.e0.p.d.m0.n.c0 getReturnType() {
        d0.e0.p.d.m0.n.c0 type = getType();
        if (type != null) {
            return type;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.n0
    public p0 getSetter() {
        return this.F;
    }

    @Override // d0.e0.p.d.m0.c.i1.m0, d0.e0.p.d.m0.c.a
    public List<z0> getTypeParameters() {
        List<z0> list = this.D;
        if (list != null) {
            return list;
        }
        StringBuilder sbU = b.d.b.a.a.U("typeParameters == null for ");
        sbU.append(toString());
        throw new IllegalStateException(sbU.toString());
    }

    @Override // d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = this.r;
        if (uVar != null) {
            return uVar;
        }
        a(20);
        throw null;
    }

    public void initialize(d0 d0Var, p0 p0Var) {
        initialize(d0Var, p0Var, null, null);
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return this.f3261y;
    }

    @Override // d0.e0.p.d.m0.c.d1
    public boolean isConst() {
        return this.w;
    }

    @Override // d0.e0.p.d.m0.c.n0
    public boolean isDelegated() {
        return this.A;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return this.f3260x;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return this.f3262z;
    }

    @Override // d0.e0.p.d.m0.c.d1
    public boolean isLateInit() {
        return this.v;
    }

    public boolean isSetterProjectedOut() {
        return this.G;
    }

    public a newCopyBuilder() {
        return new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.c.b
    public void setOverriddenDescriptors(Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        if (collection != 0) {
            this.f3259s = collection;
        } else {
            a(35);
            throw null;
        }
    }

    public void setSetterProjectedOut(boolean z2) {
        this.G = z2;
    }

    public void setType(d0.e0.p.d.m0.n.c0 c0Var, List<? extends z0> list, q0 q0Var, q0 q0Var2) {
        if (c0Var == null) {
            a(14);
            throw null;
        }
        if (list == null) {
            a(15);
            throw null;
        }
        setOutType(c0Var);
        this.D = new ArrayList(list);
        this.C = q0Var2;
        this.B = q0Var;
    }

    public void setVisibility(d0.e0.p.d.m0.c.u uVar) {
        if (uVar != null) {
            this.r = uVar;
        } else {
            a(16);
            throw null;
        }
    }

    @Override // d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.c.b
    public d0.e0.p.d.m0.c.n0 copy(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.z zVar, d0.e0.p.d.m0.c.u uVar, b.a aVar, boolean z2) {
        d0.e0.p.d.m0.c.n0 n0VarBuild = newCopyBuilder().setOwner(mVar).setOriginal(null).setModality(zVar).setVisibility(uVar).setKind(aVar).setCopyOverrides(z2).build();
        if (n0VarBuild != null) {
            return n0VarBuild;
        }
        a(37);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.n0
    public d0 getGetter() {
        return this.E;
    }

    @Override // d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.i1.k, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getOriginal() {
        return getOriginal();
    }

    public void initialize(d0 d0Var, p0 p0Var, d0.e0.p.d.m0.c.v vVar, d0.e0.p.d.m0.c.v vVar2) {
        this.E = d0Var;
        this.F = p0Var;
        this.H = vVar;
        this.I = vVar2;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public d0.e0.p.d.m0.c.n0 substitute(c1 c1Var) {
        if (c1Var != null) {
            return c1Var.isEmpty() ? this : newCopyBuilder().setSubstitution(c1Var.getSubstitution()).setOriginal(getOriginal()).build();
        }
        a(22);
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
    public d0.e0.p.d.m0.c.n0 getOriginal() {
        d0.e0.p.d.m0.c.n0 n0Var = this.t;
        d0.e0.p.d.m0.c.n0 original = n0Var == this ? this : n0Var.getOriginal();
        if (original != null) {
            return original;
        }
        a(33);
        throw null;
    }
}
