package d0.e0.p.d.m0.n.m1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.a;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.g.e;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.t;
import d0.e0.p.d.m0.n.z0;
import java.util.Collection;
import java.util.List;

/* compiled from: ErrorSimpleFunctionDescriptorImpl.java */
/* loaded from: classes3.dex */
public class a extends g0 {

    /* compiled from: ErrorSimpleFunctionDescriptorImpl.java */
    /* renamed from: d0.e0.p.d.m0.n.m1.a$a, reason: collision with other inner class name */
    public class C0584a implements x.a<t0> {
        public C0584a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
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
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                    break;
                case 2:
                    objArr[0] = "modality";
                    break;
                case 4:
                    objArr[0] = "visibility";
                    break;
                case 6:
                    objArr[0] = "kind";
                    break;
                case 9:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 11:
                case 17:
                    objArr[0] = "parameters";
                    break;
                case 13:
                    objArr[0] = "substitution";
                    break;
                case 15:
                    objArr[0] = "userDataKey";
                    break;
                case 19:
                    objArr[0] = "type";
                    break;
                case 29:
                    objArr[0] = "additionalAnnotations";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 3) {
                objArr[1] = "setModality";
            } else if (i == 5) {
                objArr[1] = "setVisibility";
            } else if (i == 10) {
                objArr[1] = "setName";
            } else if (i == 12) {
                objArr[1] = "setValueParameters";
            } else if (i == 14) {
                objArr[1] = "setSubstitution";
            } else if (i == 16) {
                objArr[1] = "putUserData";
            } else if (i == 18) {
                objArr[1] = "setTypeParameters";
            } else if (i == 30) {
                objArr[1] = "setAdditionalAnnotations";
            } else if (i == 7) {
                objArr[1] = "setKind";
            } else if (i != 8) {
                switch (i) {
                    case 20:
                        objArr[1] = "setReturnType";
                        break;
                    case 21:
                        objArr[1] = "setExtensionReceiverParameter";
                        break;
                    case 22:
                        objArr[1] = "setDispatchReceiverParameter";
                        break;
                    case 23:
                        objArr[1] = "setOriginal";
                        break;
                    case 24:
                        objArr[1] = "setSignatureChange";
                        break;
                    case 25:
                        objArr[1] = "setPreserveSourceElement";
                        break;
                    case 26:
                        objArr[1] = "setDropOriginalInContainingParts";
                        break;
                    case 27:
                        objArr[1] = "setHiddenToOvercomeSignatureClash";
                        break;
                    case 28:
                        objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                        break;
                }
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                case 14:
                case 16:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 30:
                    break;
                case 2:
                    objArr[2] = "setModality";
                    break;
                case 4:
                    objArr[2] = "setVisibility";
                    break;
                case 6:
                    objArr[2] = "setKind";
                    break;
                case 9:
                    objArr[2] = "setName";
                    break;
                case 11:
                    objArr[2] = "setValueParameters";
                    break;
                case 13:
                    objArr[2] = "setSubstitution";
                    break;
                case 15:
                    objArr[2] = "putUserData";
                    break;
                case 17:
                    objArr[2] = "setTypeParameters";
                    break;
                case 19:
                    objArr[2] = "setReturnType";
                    break;
                case 29:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 3 && i != 5 && i != 10 && i != 12 && i != 14 && i != 16 && i != 18 && i != 30 && i != 7 && i != 8) {
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public /* bridge */ /* synthetic */ x build() {
            return build();
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setAdditionalAnnotations(g gVar) {
            if (gVar != null) {
                return this;
            }
            a(29);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setCopyOverrides(boolean z2) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setDispatchReceiverParameter(q0 q0Var) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setDropOriginalInContainingParts() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setExtensionReceiverParameter(q0 q0Var) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setHiddenForResolutionEverywhereBesideSupercalls() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setHiddenToOvercomeSignatureClash() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setKind(b.a aVar) {
            if (aVar != null) {
                return this;
            }
            a(6);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setModality(z zVar) {
            if (zVar != null) {
                return this;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setName(e eVar) {
            if (eVar != null) {
                return this;
            }
            a(9);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setOriginal(b bVar) {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setOwner(m mVar) {
            if (mVar != null) {
                return this;
            }
            a(0);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setPreserveSourceElement() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setReturnType(c0 c0Var) {
            if (c0Var != null) {
                return this;
            }
            a(19);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setSignatureChange() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setSubstitution(z0 z0Var) {
            if (z0Var != null) {
                return this;
            }
            a(13);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setTypeParameters(List<d0.e0.p.d.m0.c.z0> list) {
            if (list != null) {
                return this;
            }
            a(17);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setValueParameters(List<c1> list) {
            if (list != null) {
                return this;
            }
            a(11);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public x.a<t0> setVisibility(u uVar) {
            if (uVar != null) {
                return this;
            }
            a(4);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.x.a
        public t0 build() {
            return a.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d0.e0.p.d.m0.c.e eVar, t.d dVar) {
        super(eVar, null, g.f.getEMPTY(), e.special("<ERROR FUNCTION>"), b.a.DECLARATION, u0.a);
        if (eVar == null) {
            a(0);
            throw null;
        }
        if (dVar != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q
    public q b(m mVar, x xVar, b.a aVar, e eVar, g gVar, u0 u0Var) {
        if (mVar == null) {
            a(2);
            throw null;
        }
        if (aVar == null) {
            a(3);
            throw null;
        }
        if (gVar != null) {
            return this;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ b copy(m mVar, z zVar, u uVar, b.a aVar, boolean z2) {
        return copy(mVar, zVar, uVar, aVar, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public t0 copy(m mVar, z zVar, u uVar, b.a aVar, boolean z2) {
        return this;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.a
    public <V> V getUserData(a.InterfaceC0511a<V> interfaceC0511a) {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isSuspend() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x, d0.e0.p.d.m0.c.t0
    public x.a<? extends t0> newCopyBuilder() {
        return new C0584a();
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public void setOverriddenDescriptors(Collection<? extends b> collection) {
        if (collection != null) {
            return;
        }
        a(8);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.b
    public /* bridge */ /* synthetic */ x copy(m mVar, z zVar, u uVar, b.a aVar, boolean z2) {
        return copy(mVar, zVar, uVar, aVar, z2);
    }
}
