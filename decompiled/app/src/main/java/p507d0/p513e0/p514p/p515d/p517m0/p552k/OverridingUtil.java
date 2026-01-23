package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyAccessorDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.ExternalOverridabilityCondition;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.flexibleTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeCheckerContext;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker2;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartSet;
import p507d0.p580t._Collections;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.k, reason: use source file name */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class OverridingUtil {

    /* JADX INFO: renamed from: a */
    public static final List<ExternalOverridabilityCondition> f24410a = _Collections.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));

    /* JADX INFO: renamed from: b */
    public static final OverridingUtil f24411b;

    /* JADX INFO: renamed from: c */
    public static final KotlinTypeChecker.a f24412c;

    /* JADX INFO: renamed from: d */
    public final KotlinTypeRefiner f24413d;

    /* JADX INFO: renamed from: e */
    public final KotlinTypeChecker.a f24414e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$a */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class a implements KotlinTypeChecker.a {
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9938a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker.a
        public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                m9938a(0);
                throw null;
            }
            if (typeConstructor2 != null) {
                return typeConstructor.equals(typeConstructor2);
            }
            m9938a(1);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$b */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class b<D> implements Function2<D, D, Tuples2<CallableDescriptor, CallableDescriptor>> {
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Tuples2<CallableDescriptor, CallableDescriptor> invoke(Object obj, Object obj2) {
            return invoke((CallableDescriptor) obj, (CallableDescriptor) obj2);
        }

        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Ld0/e0/p/d/m0/c/a;Ld0/e0/p/d/m0/c/a;>; */
        public Tuples2 invoke(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            return new Tuples2(callableDescriptor, callableDescriptor2);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$c */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class c implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public CallableMemberDescriptor invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return invoke2(callableMemberDescriptor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$d */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public static class d {

        /* JADX INFO: renamed from: a */
        public static final d f24415a = new d(a.OVERRIDABLE, "SUCCESS");

        /* JADX INFO: renamed from: b */
        public final a f24416b;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$d$a */
        /* JADX INFO: compiled from: OverridingUtil.java */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public d(a aVar, String str) {
            if (aVar == null) {
                m9939a(3);
                throw null;
            }
            if (str != null) {
                this.f24416b = aVar;
            } else {
                m9939a(4);
                throw null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void m9939a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2];
            if (i == 1 || i == 2) {
                objArr[0] = "debugMessage";
            } else if (i == 3) {
                objArr[0] = "success";
            } else if (i != 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            if (i == 1) {
                objArr[2] = "incompatible";
            } else if (i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                throw new IllegalStateException(str2);
            }
            throw new IllegalArgumentException(str2);
        }

        public static d conflict(String str) {
            if (str != null) {
                return new d(a.CONFLICT, str);
            }
            m9939a(2);
            throw null;
        }

        public static d incompatible(String str) {
            if (str != null) {
                return new d(a.INCOMPATIBLE, str);
            }
            m9939a(1);
            throw null;
        }

        public static d success() {
            d dVar = f24415a;
            if (dVar != null) {
                return dVar;
            }
            m9939a(0);
            throw null;
        }

        public a getResult() {
            a aVar = this.f24416b;
            if (aVar != null) {
                return aVar;
            }
            m9939a(5);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.k$e */
    /* JADX INFO: compiled from: OverridingUtil.java */
    public class e extends ClassicTypeCheckerContext {

        /* JADX INFO: renamed from: j */
        public final Map<TypeConstructor, TypeConstructor> f24421j;

        public e(Map<TypeConstructor, TypeConstructor> map) {
            super(true, true, true, OverridingUtil.this.f24413d);
            this.f24421j = map;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9940a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1 || i == 3) {
                objArr[0] = "b";
            } else {
                objArr[0] = "a";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            if (i == 2 || i == 3) {
                objArr[2] = "areEqualTypeConstructorsByAxioms";
            } else {
                objArr[2] = "areEqualTypeConstructors";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.ClassicTypeCheckerContext
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean areEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
            boolean z2;
            if (typeConstructor == null) {
                m9940a(0);
                throw null;
            }
            if (typeConstructor2 == null) {
                m9940a(1);
                throw null;
            }
            if (!super.areEqualTypeConstructors(typeConstructor, typeConstructor2)) {
                if (typeConstructor == null) {
                    m9940a(2);
                    throw null;
                }
                if (typeConstructor2 == null) {
                    m9940a(3);
                    throw null;
                }
                if (!OverridingUtil.this.f24414e.equals(typeConstructor, typeConstructor2)) {
                    Map<TypeConstructor, TypeConstructor> map = this.f24421j;
                    if (map != null) {
                        TypeConstructor typeConstructor3 = map.get(typeConstructor);
                        TypeConstructor typeConstructor4 = this.f24421j.get(typeConstructor2);
                        if ((typeConstructor3 != null && typeConstructor3.equals(typeConstructor2)) || (typeConstructor4 != null && typeConstructor4.equals(typeConstructor))) {
                            z2 = true;
                        }
                        if (z2) {
                            return false;
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
            }
            return true;
        }
    }

    static {
        a aVar = new a();
        f24412c = aVar;
        f24411b = new OverridingUtil(aVar, KotlinTypeRefiner.a.f24807a);
    }

    public OverridingUtil(KotlinTypeChecker.a aVar, KotlinTypeRefiner kotlinTypeRefiner) {
        if (aVar == null) {
            m9930a(4);
            throw null;
        }
        if (kotlinTypeRefiner == null) {
            m9930a(5);
            throw null;
        }
        this.f24414e = aVar;
        this.f24413d = kotlinTypeRefiner;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0184  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m9930a(int i) {
        String str;
        int i2;
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 3:
            default:
                objArr[0] = "equalityAxioms";
                break;
            case 4:
                objArr[0] = "axioms";
                break;
            case 6:
            case 7:
                objArr[0] = "candidateSet";
                break;
            case 8:
                objArr[0] = "transformFirst";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 11:
                objArr[0] = "f";
                break;
            case 12:
                objArr[0] = "g";
                break;
            case 13:
            case 15:
                objArr[0] = "descriptor";
                break;
            case 16:
                objArr[0] = "result";
                break;
            case 17:
            case 20:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 18:
            case 21:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
            case 42:
                objArr[0] = "firstParameters";
                break;
            case 41:
            case 43:
                objArr[0] = "secondParameters";
                break;
            case 44:
                objArr[0] = "typeInSuper";
                break;
            case 45:
                objArr[0] = "typeInSub";
                break;
            case 46:
            case 49:
            case 75:
                objArr[0] = "typeChecker";
                break;
            case 47:
                objArr[0] = "superTypeParameter";
                break;
            case 48:
                objArr[0] = "subTypeParameter";
                break;
            case 50:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 51:
                objArr[0] = "membersFromSupertypes";
                break;
            case 52:
                objArr[0] = "membersFromCurrent";
                break;
            case 53:
            case 59:
            case 62:
            case 84:
            case 87:
            case 94:
                objArr[0] = "current";
                break;
            case 54:
            case 60:
            case 64:
            case 85:
            case 104:
                objArr[0] = "strategy";
                break;
            case 55:
                objArr[0] = "overriding";
                break;
            case 56:
                objArr[0] = "fromSuper";
                break;
            case 57:
                objArr[0] = "fromCurrent";
                break;
            case 58:
                objArr[0] = "descriptorsFromSuper";
                break;
            case 61:
            case 63:
                objArr[0] = "notOverridden";
                break;
            case 65:
            case 67:
            case 71:
                objArr[0] = "a";
                break;
            case 66:
            case 68:
            case 73:
                objArr[0] = "b";
                break;
            case 69:
                objArr[0] = "candidate";
                break;
            case 70:
            case 86:
            case 91:
            case 107:
                objArr[0] = "descriptors";
                break;
            case 72:
                objArr[0] = "aReturnType";
                break;
            case 74:
                objArr[0] = "bReturnType";
                break;
            case 76:
            case 83:
                objArr[0] = "overridables";
                break;
            case 77:
            case 99:
                objArr[0] = "descriptorByHandle";
                break;
            case 92:
                objArr[0] = "classModality";
                break;
            case 95:
                objArr[0] = "toFilter";
                break;
            case 97:
            case 102:
                objArr[0] = "overrider";
                break;
            case 98:
            case 103:
                objArr[0] = "extractFrom";
                break;
            case 100:
                objArr[0] = "onConflict";
                break;
            case 105:
            case 106:
                objArr[0] = "memberDescriptor";
                break;
        }
        if (i == 9 || i == 10) {
            objArr[1] = "filterOverrides";
        } else if (i == 14) {
            objArr[1] = "getOverriddenDeclarations";
        } else if (i == 19) {
            objArr[1] = "isOverridableBy";
        } else if (i == 93) {
            objArr[1] = "getMinimalModality";
        } else if (i == 96) {
            objArr[1] = "filterVisibleFakeOverrides";
        } else if (i != 101) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            objArr[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        default:
                            switch (i) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    objArr[1] = "selectMostSpecificMember";
                                    break;
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            objArr[1] = "determineModalityForFakeOverride";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "extractMembersOverridableInBothWays";
        }
        switch (i) {
            case 1:
                objArr[2] = "createWithTypeRefiner";
                break;
            case 2:
            case 3:
                objArr[2] = "create";
                break;
            case 4:
            case 5:
                objArr[2] = "<init>";
                break;
            case 6:
                objArr[2] = "filterOutOverridden";
                break;
            case 7:
            case 8:
                objArr[2] = "filterOverrides";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                break;
            case 11:
            case 12:
                objArr[2] = "overrides";
                break;
            case 13:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 15:
            case 16:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 17:
            case 18:
            case 20:
            case 21:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeChecker";
                break;
            case 42:
            case 43:
                objArr[2] = "createTypeCheckerContext";
                break;
            case 44:
            case 45:
            case 46:
                objArr[2] = "areTypesEquivalent";
                break;
            case 47:
            case 48:
            case 49:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 55:
            case 56:
                objArr[2] = "isVisibleForOverride";
                break;
            case 57:
            case 58:
            case 59:
            case 60:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case 61:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 62:
            case 63:
            case 64:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 65:
            case 66:
                objArr[2] = "isMoreSpecific";
                break;
            case 67:
            case 68:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case 76:
            case 77:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 83:
            case 84:
            case 85:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 86:
            case 87:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 91:
            case 92:
                objArr[2] = "getMinimalModality";
                break;
            case 94:
            case 95:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
            case 102:
            case 103:
            case 104:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 105:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 106:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 107:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithEqualityAxioms";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    /* JADX INFO: renamed from: c */
    public static void m9931c(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            m9930a(15);
            throw null;
        }
        if (set == null) {
            m9930a(16);
            throw null;
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
            return;
        }
        if (callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
        Iterator<? extends CallableMemberDescriptor> it = callableMemberDescriptor.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            m9931c(it.next(), set);
        }
    }

    public static OverridingUtil create(KotlinTypeRefiner kotlinTypeRefiner, KotlinTypeChecker.a aVar) {
        if (kotlinTypeRefiner == null) {
            m9930a(2);
            throw null;
        }
        if (aVar != null) {
            return new OverridingUtil(aVar, kotlinTypeRefiner);
        }
        m9930a(3);
        throw null;
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            return new OverridingUtil(f24412c, kotlinTypeRefiner);
        }
        m9930a(1);
        throw null;
    }

    /* JADX INFO: renamed from: d */
    public static List<KotlinType> m9932d(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        Iterator<ValueParameterDescriptor> it = callableDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f0, code lost:
    
        if (r4 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f2, code lost:
    
        r0 = p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities.f23090h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f5, code lost:
    
        r0 = p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities.f23089g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f7, code lost:
    
        r0 = ((p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor) selectMostSpecificMember(r6, new p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil.c())).copy(r12, r2, r0, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor.a.FAKE_OVERRIDE, false);
        r13.setOverriddenDescriptors(r0, r6);
        r13.addFakeOverride(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0111, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m9933e(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy2 overridingStrategy2) {
        Modality modality;
        if (collection == null) {
            m9930a(83);
            throw null;
        }
        if (classDescriptor == null) {
            m9930a(84);
            throw null;
        }
        if (overridingStrategy2 == null) {
            m9930a(85);
            throw null;
        }
        if (classDescriptor == null) {
            m9930a(94);
            throw null;
        }
        if (collection == null) {
            m9930a(95);
            throw null;
        }
        List listFilter = _Collections.filter(collection, new OverridingUtil3(classDescriptor));
        if (listFilter == null) {
            m9930a(96);
            throw null;
        }
        boolean zIsEmpty = listFilter.isEmpty();
        Collection<? extends CallableMemberDescriptor> collection2 = zIsEmpty ? collection : listFilter;
        Iterator<? extends CallableMemberDescriptor> it = collection2.iterator();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (it.hasNext()) {
                CallableMemberDescriptor next = it.next();
                int iOrdinal = next.getModality().ordinal();
                if (iOrdinal == 0) {
                    modality = Modality.FINAL;
                    break;
                }
                if (iOrdinal == 1) {
                    throw new IllegalStateException("Member cannot have SEALED modality: " + next);
                }
                if (iOrdinal == 2) {
                    z3 = true;
                } else if (iOrdinal == 3) {
                    z4 = true;
                }
            } else {
                if (classDescriptor.isExpect() && classDescriptor.getModality() != Modality.ABSTRACT && classDescriptor.getModality() != Modality.SEALED) {
                    z2 = true;
                }
                if (z3 && !z4) {
                    modality = Modality.OPEN;
                } else if (z3 || !z4) {
                    HashSet hashSet = new HashSet();
                    Iterator<? extends CallableMemberDescriptor> it2 = collection2.iterator();
                    while (it2.hasNext()) {
                        hashSet.addAll(getOverriddenDeclarations(it2.next()));
                    }
                    Set<CallableMemberDescriptor> setFilterOutOverridden = filterOutOverridden(hashSet);
                    Modality modality2 = classDescriptor.getModality();
                    if (setFilterOutOverridden == null) {
                        m9930a(91);
                        throw null;
                    }
                    if (modality2 == null) {
                        m9930a(92);
                        throw null;
                    }
                    Modality modality3 = Modality.ABSTRACT;
                    for (CallableMemberDescriptor callableMemberDescriptor : setFilterOutOverridden) {
                        Modality modality4 = (z2 && callableMemberDescriptor.getModality() == Modality.ABSTRACT) ? modality2 : callableMemberDescriptor.getModality();
                        if (modality4.compareTo(modality3) < 0) {
                            modality3 = modality4;
                        }
                    }
                    if (modality3 == null) {
                        m9930a(93);
                        throw null;
                    }
                    Modality modality5 = modality3;
                } else {
                    modality = z2 ? classDescriptor.getModality() : Modality.ABSTRACT;
                    if (modality == null) {
                        m9930a(90);
                        throw null;
                    }
                }
            }
        }
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h, Collection<H> collection, Function1<H, CallableDescriptor> function1, Function1<H, Unit> function12) {
        if (h == null) {
            m9930a(97);
            throw null;
        }
        if (collection == null) {
            m9930a(98);
            throw null;
        }
        if (function1 == null) {
            m9930a(99);
            throw null;
        }
        if (function12 == null) {
            m9930a(100);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        CallableDescriptor callableDescriptorInvoke = function1.invoke(h);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor callableDescriptorInvoke2 = function1.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                d.a bothWaysOverridability = getBothWaysOverridability(callableDescriptorInvoke, callableDescriptorInvoke2);
                if (bothWaysOverridability == d.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == d.a.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> set) {
        if (set != null) {
            return filterOverrides(set, !set.isEmpty() && DescriptorUtils2.isTypeRefinementEnabled(DescriptorUtils2.getModule(set.iterator().next())), null, new b());
        }
        m9930a(6);
        throw null;
    }

    public static <D> Set<D> filterOverrides(Set<D> set, boolean z2, Function0<?> function0, Function2<? super D, ? super D, Tuples2<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            m9930a(7);
            throw null;
        }
        if (function2 == null) {
            m9930a(8);
            throw null;
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                Tuples2<CallableDescriptor, CallableDescriptor> tuples2Invoke = function2.invoke(obj, (Object) it.next());
                CallableDescriptor callableDescriptorComponent1 = tuples2Invoke.component1();
                CallableDescriptor callableDescriptorComponent2 = tuples2Invoke.component2();
                if (!overrides(callableDescriptorComponent1, callableDescriptorComponent2, z2, true)) {
                    if (overrides(callableDescriptorComponent2, callableDescriptorComponent1, z2, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    public static DescriptorVisibility2 findMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        DescriptorVisibility2 descriptorVisibility2;
        if (collection == null) {
            m9930a(107);
            throw null;
        }
        if (collection.isEmpty()) {
            return DescriptorVisibilities.f23093k;
        }
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        loop0: while (true) {
            descriptorVisibility2 = null;
            while (it.hasNext()) {
                DescriptorVisibility2 visibility = it.next().getVisibility();
                if (descriptorVisibility2 != null) {
                    Integer numCompare = DescriptorVisibilities.compare(visibility, descriptorVisibility2);
                    if (numCompare == null) {
                        break;
                    }
                    if (numCompare.intValue() > 0) {
                    }
                }
                descriptorVisibility2 = visibility;
            }
        }
        if (descriptorVisibility2 == null) {
            return null;
        }
        Iterator<? extends CallableMemberDescriptor> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numCompare2 = DescriptorVisibilities.compare(descriptorVisibility2, it2.next().getVisibility());
            if (numCompare2 == null || numCompare2.intValue() < 0) {
                return null;
            }
        }
        return descriptorVisibility2;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m9934g(CallableDescriptor callableDescriptor, KotlinType kotlinType, CallableDescriptor callableDescriptor2, KotlinType kotlinType2, Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2) {
        if (kotlinType == null) {
            m9930a(72);
            throw null;
        }
        if (kotlinType2 != null) {
            return tuples2.getFirst().isSubtypeOf(tuples2.getSecond(), kotlinType.unwrap(), kotlinType2.unwrap());
        }
        m9930a(74);
        throw null;
    }

    public static d getBasicOverridabilityProblem(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z2;
        if (callableDescriptor == null) {
            m9930a(38);
            throw null;
        }
        if (callableDescriptor2 == null) {
            m9930a(39);
            throw null;
        }
        boolean z3 = callableDescriptor instanceof FunctionDescriptor;
        if ((z3 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z2 = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return d.incompatible("Member kind mismatch");
        }
        if (!z3 && !z2) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        }
        if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return d.incompatible("Name mismatch");
        }
        d dVarIncompatible = (callableDescriptor.getExtensionReceiverParameter() == null) != (callableDescriptor2.getExtensionReceiverParameter() == null) ? d.incompatible("Receiver presence mismatch") : callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size() ? d.incompatible("Value parameter number mismatch") : null;
        if (dVarIncompatible != null) {
            return dVarIncompatible;
        }
        return null;
    }

    public static d.a getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil overridingUtil = f24411b;
        d.a result = overridingUtil.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        d.a result2 = overridingUtil.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        d.a aVar = d.a.OVERRIDABLE;
        if (result == aVar && result2 == aVar) {
            return aVar;
        }
        d.a aVar2 = d.a.CONFLICT;
        return (result == aVar2 || result2 == aVar2) ? aVar2 : d.a.INCOMPATIBLE;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            m9930a(13);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m9931c(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: h */
    public static boolean m9935h(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        Integer numCompare = DescriptorVisibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return numCompare == null || numCompare.intValue() >= 0;
    }

    public static boolean isMoreSpecific(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            m9930a(65);
            throw null;
        }
        if (callableDescriptor2 == null) {
            m9930a(66);
            throw null;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        KotlinType returnType2 = callableDescriptor2.getReturnType();
        if (!m9935h(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2M9937f = f24411b.m9937f(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
        if (callableDescriptor instanceof FunctionDescriptor) {
            return m9934g(callableDescriptor, returnType, callableDescriptor2, returnType2, tuples2M9937f);
        }
        if (!(callableDescriptor instanceof PropertyDescriptor)) {
            StringBuilder sbM833U = outline.m833U("Unexpected callable: ");
            sbM833U.append(callableDescriptor.getClass());
            throw new IllegalArgumentException(sbM833U.toString());
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        PropertySetterDescriptor setter2 = propertyDescriptor2.getSetter();
        if ((setter == null || setter2 == null) ? true : m9935h(setter, setter2)) {
            return (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) ? tuples2M9937f.getFirst().equalTypes(tuples2M9937f.getSecond(), returnType.unwrap(), returnType2.unwrap()) : (propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && m9934g(callableDescriptor, returnType, callableDescriptor2, returnType2, tuples2M9937f);
        }
        return false;
    }

    public static boolean isVisibleForOverride(MemberDescriptor memberDescriptor, MemberDescriptor memberDescriptor2) {
        if (memberDescriptor == null) {
            m9930a(55);
            throw null;
        }
        if (memberDescriptor2 != null) {
            return !DescriptorVisibilities.isPrivate(memberDescriptor2.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor);
        }
        m9930a(56);
        throw null;
    }

    public static <D extends CallableDescriptor> boolean overrides(D d2, D d3, boolean z2, boolean z3) {
        if (d2 == null) {
            m9930a(11);
            throw null;
        }
        if (d3 == null) {
            m9930a(12);
            throw null;
        }
        if (!d2.equals(d3) && DescriptorEquivalenceForOverrides.f24391a.areEquivalent(d2.getOriginal(), d3.getOriginal(), z2, z3)) {
            return true;
        }
        CallableDescriptor original = d3.getOriginal();
        Iterator it = DescriptorUtils.getAllOverriddenDescriptors(d2).iterator();
        while (it.hasNext()) {
            if (DescriptorEquivalenceForOverrides.f24391a.areEquivalent(original, (CallableDescriptor) it.next(), z2, z3)) {
                return true;
            }
        }
        return false;
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor callableMemberDescriptor, Function1<CallableMemberDescriptor, Unit> function1) {
        DescriptorVisibility2 descriptorVisibility2;
        if (callableMemberDescriptor == null) {
            m9930a(105);
            throw null;
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == DescriptorVisibilities.f23089g) {
                resolveUnknownVisibilityForMember(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != DescriptorVisibilities.f23089g) {
            return;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        DescriptorVisibility2 descriptorVisibility2FindMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (descriptorVisibility2FindMaxVisibility == null) {
            descriptorVisibility2FindMaxVisibility = null;
            break;
        }
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.a.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor3 : overriddenDescriptors) {
                if (callableMemberDescriptor3.getModality() != Modality.ABSTRACT && !callableMemberDescriptor3.getVisibility().equals(descriptorVisibility2FindMaxVisibility)) {
                    descriptorVisibility2FindMaxVisibility = null;
                    break;
                }
            }
        } else {
            descriptorVisibility2FindMaxVisibility = descriptorVisibility2FindMaxVisibility.normalize();
        }
        if (descriptorVisibility2FindMaxVisibility == null) {
            if (function1 != null) {
                function1.invoke(callableMemberDescriptor);
            }
            descriptorVisibility2 = DescriptorVisibilities.f23087e;
        } else {
            descriptorVisibility2 = descriptorVisibility2FindMaxVisibility;
        }
        if (callableMemberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility2);
            Iterator<PropertyAccessorDescriptor> it = ((PropertyDescriptor) callableMemberDescriptor).getAccessors().iterator();
            while (it.hasNext()) {
                resolveUnknownVisibilityForMember(it.next(), descriptorVisibility2FindMaxVisibility == null ? null : function1);
            }
            return;
        }
        if (callableMemberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility2);
            return;
        }
        PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = (PropertyAccessorDescriptorImpl) callableMemberDescriptor;
        propertyAccessorDescriptorImpl.setVisibility(descriptorVisibility2);
        if (descriptorVisibility2 != propertyAccessorDescriptorImpl.getCorrespondingProperty().getVisibility()) {
            propertyAccessorDescriptorImpl.setDefault(false);
        }
    }

    public static <H> H selectMostSpecificMember(Collection<H> collection, Function1<H, CallableDescriptor> function1) {
        H h;
        boolean z2;
        if (collection == null) {
            m9930a(76);
            throw null;
        }
        if (function1 == null) {
            m9930a(77);
            throw null;
        }
        if (collection.size() == 1) {
            H h2 = (H) _Collections.first(collection);
            if (h2 != null) {
                return h2;
            }
            m9930a(78);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        List map = _Collections.map(collection, function1);
        H h3 = (H) _Collections.first(collection);
        CallableDescriptor callableDescriptorInvoke = function1.invoke(h3);
        for (H h4 : collection) {
            CallableDescriptor callableDescriptorInvoke2 = function1.invoke(h4);
            if (callableDescriptorInvoke2 == null) {
                m9930a(69);
                throw null;
            }
            if (map == null) {
                m9930a(70);
                throw null;
            }
            Iterator it = map.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                if (!isMoreSpecific(callableDescriptorInvoke2, (CallableDescriptor) it.next())) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                arrayList.add(h4);
            }
            if (isMoreSpecific(callableDescriptorInvoke2, callableDescriptorInvoke) && !isMoreSpecific(callableDescriptorInvoke, callableDescriptorInvoke2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 != null) {
                return h3;
            }
            m9930a(79);
            throw null;
        }
        if (arrayList.size() == 1) {
            H h5 = (H) _Collections.first((Iterable) arrayList);
            if (h5 != null) {
                return h5;
            }
            m9930a(80);
            throw null;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                h = null;
                break;
            }
            h = (H) it2.next();
            if (!flexibleTypes2.isFlexible(function1.invoke(h).getReturnType())) {
                break;
            }
        }
        if (h != null) {
            return h;
        }
        H h6 = (H) _Collections.first((Iterable) arrayList);
        if (h6 != null) {
            return h6;
        }
        m9930a(82);
        throw null;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m9936b(KotlinType kotlinType, KotlinType kotlinType2, Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2) {
        if (kotlinType == null) {
            m9930a(44);
            throw null;
        }
        if (kotlinType2 == null) {
            m9930a(45);
            throw null;
        }
        if (tuples2 == null) {
            m9930a(46);
            throw null;
        }
        if (KotlinType2.isError(kotlinType) && KotlinType2.isError(kotlinType2)) {
            return true;
        }
        return tuples2.getFirst().equalTypes(tuples2.getSecond(), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    /* JADX INFO: renamed from: f */
    public final Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> m9937f(List<TypeParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
        e eVar;
        if (list == null) {
            m9930a(40);
            throw null;
        }
        if (list2 == null) {
            m9930a(41);
            throw null;
        }
        NewKotlinTypeChecker2 newKotlinTypeChecker2 = new NewKotlinTypeChecker2(this.f24413d);
        if (list == null) {
            m9930a(42);
            throw null;
        }
        if (list2 == null) {
            m9930a(43);
            throw null;
        }
        if (list.isEmpty()) {
            eVar = new e(null);
        } else {
            HashMap map = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
            }
            eVar = new e(map);
        }
        return new Tuples2<>(newKotlinTypeChecker2, eVar);
    }

    public void generateOverridesInFunctionGroup(Name name, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, ClassDescriptor classDescriptor, OverridingStrategy2 overridingStrategy2) {
        if (name == null) {
            m9930a(50);
            throw null;
        }
        if (collection == null) {
            m9930a(51);
            throw null;
        }
        if (collection2 == null) {
            m9930a(52);
            throw null;
        }
        if (classDescriptor == null) {
            m9930a(53);
            throw null;
        }
        if (overridingStrategy2 == null) {
            m9930a(54);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
            if (callableMemberDescriptor == null) {
                m9930a(57);
                throw null;
            }
            if (collection == null) {
                m9930a(58);
                throw null;
            }
            if (classDescriptor == null) {
                m9930a(59);
                throw null;
            }
            if (overridingStrategy2 == null) {
                m9930a(60);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            SmartSet smartSetCreate = SmartSet.create();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                d.a result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
                boolean zIsVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2);
                int iOrdinal = result.ordinal();
                if (iOrdinal == 0) {
                    if (zIsVisibleForOverride) {
                        smartSetCreate.add(callableMemberDescriptor2);
                    }
                    arrayList.add(callableMemberDescriptor2);
                } else if (iOrdinal == 2) {
                    if (zIsVisibleForOverride) {
                        overridingStrategy2.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                    }
                    arrayList.add(callableMemberDescriptor2);
                }
            }
            overridingStrategy2.setOverriddenDescriptors(callableMemberDescriptor, smartSetCreate);
            linkedHashSet.removeAll(arrayList);
        }
        if (classDescriptor == null) {
            m9930a(62);
            throw null;
        }
        if (overridingStrategy2 == null) {
            m9930a(64);
            throw null;
        }
        if (linkedHashSet.size() < 2 ? true : _Collections.all(linkedHashSet, new OverridingUtil2(((CallableMemberDescriptor) linkedHashSet.iterator().next()).getContainingDeclaration()))) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                m9933e(Collections.singleton((CallableMemberDescriptor) it.next()), classDescriptor, overridingStrategy2);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(linkedHashSet);
        while (!linkedList.isEmpty()) {
            CallableMemberDescriptor callableMemberDescriptorFindMemberWithMaxVisibility = VisibilityUtil.findMemberWithMaxVisibility(linkedList);
            if (callableMemberDescriptorFindMemberWithMaxVisibility == null) {
                m9930a(102);
                throw null;
            }
            m9933e(extractMembersOverridableInBothWays(callableMemberDescriptorFindMemberWithMaxVisibility, linkedList, new OverridingUtil4(), new OverridingUtil5(overridingStrategy2, callableMemberDescriptorFindMemberWithMaxVisibility)), classDescriptor, overridingStrategy2);
        }
    }

    public d isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            m9930a(17);
            throw null;
        }
        if (callableDescriptor2 == null) {
            m9930a(18);
            throw null;
        }
        d dVarIsOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (dVarIsOverridableBy != null) {
            return dVarIsOverridableBy;
        }
        m9930a(19);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c9, code lost:
    
        r15.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d isOverridableByWithoutExternalConditions(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z2) {
        if (callableDescriptor == null) {
            m9930a(28);
            throw null;
        }
        if (callableDescriptor2 == null) {
            m9930a(29);
            throw null;
        }
        d basicOverridabilityProblem = getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if (basicOverridabilityProblem != null) {
            return basicOverridabilityProblem;
        }
        List<KotlinType> listM9932d = m9932d(callableDescriptor);
        List<KotlinType> listM9932d2 = m9932d(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        if (typeParameters.size() != typeParameters2.size()) {
            int i = 0;
            while (true) {
                ArrayList arrayList = (ArrayList) listM9932d;
                if (i >= arrayList.size()) {
                    d dVarConflict = d.conflict("Type parameter number mismatch");
                    if (dVarConflict != null) {
                        return dVarConflict;
                    }
                    m9930a(32);
                    throw null;
                }
                if (!KotlinTypeChecker.f24806a.equalTypes((KotlinType) arrayList.get(i), (KotlinType) ((ArrayList) listM9932d2).get(i))) {
                    d dVarIncompatible = d.incompatible("Type parameter number mismatch");
                    if (dVarIncompatible != null) {
                        return dVarIncompatible;
                    }
                    m9930a(31);
                    throw null;
                }
                i++;
            }
        } else {
            Tuples2<NewKotlinTypeChecker2, ClassicTypeCheckerContext> tuples2M9937f = m9937f(typeParameters, typeParameters2);
            int i2 = 0;
            while (true) {
                boolean z3 = true;
                if (i2 < typeParameters.size()) {
                    TypeParameterDescriptor typeParameterDescriptor = typeParameters.get(i2);
                    TypeParameterDescriptor typeParameterDescriptor2 = typeParameters2.get(i2);
                    if (typeParameterDescriptor == null) {
                        m9930a(47);
                        throw null;
                    }
                    if (typeParameterDescriptor2 == null) {
                        m9930a(48);
                        throw null;
                    }
                    List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                    ArrayList arrayList2 = new ArrayList(typeParameterDescriptor2.getUpperBounds());
                    if (upperBounds.size() != arrayList2.size()) {
                        z3 = false;
                        break;
                    }
                    for (KotlinType kotlinType : upperBounds) {
                        ListIterator listIterator = arrayList2.listIterator();
                        while (listIterator.hasNext()) {
                            if (m9936b(kotlinType, (KotlinType) listIterator.next(), tuples2M9937f)) {
                                break;
                            }
                        }
                        z3 = false;
                    }
                    if (!z3) {
                        d dVarIncompatible2 = d.incompatible("Type parameter bounds mismatch");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        m9930a(33);
                        throw null;
                    }
                    i2++;
                } else {
                    int i3 = 0;
                    while (true) {
                        ArrayList arrayList3 = (ArrayList) listM9932d;
                        if (i3 >= arrayList3.size()) {
                            if ((callableDescriptor instanceof FunctionDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && ((FunctionDescriptor) callableDescriptor).isSuspend() != ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
                                d dVarConflict2 = d.conflict("Incompatible suspendability");
                                if (dVarConflict2 != null) {
                                    return dVarConflict2;
                                }
                                m9930a(35);
                                throw null;
                            }
                            if (z2) {
                                KotlinType returnType = callableDescriptor.getReturnType();
                                KotlinType returnType2 = callableDescriptor2.getReturnType();
                                if (returnType != null && returnType2 != null) {
                                    if (!(KotlinType2.isError(returnType2) && KotlinType2.isError(returnType)) && !tuples2M9937f.getFirst().isSubtypeOf(tuples2M9937f.getSecond(), returnType2.unwrap(), returnType.unwrap())) {
                                        d dVarConflict3 = d.conflict("Return type mismatch");
                                        if (dVarConflict3 != null) {
                                            return dVarConflict3;
                                        }
                                        m9930a(36);
                                        throw null;
                                    }
                                }
                            }
                            d dVarSuccess = d.success();
                            if (dVarSuccess != null) {
                                return dVarSuccess;
                            }
                            m9930a(37);
                            throw null;
                        }
                        if (!m9936b((KotlinType) arrayList3.get(i3), (KotlinType) ((ArrayList) listM9932d2).get(i3), tuples2M9937f)) {
                            d dVarIncompatible3 = d.incompatible("Value parameter type mismatch");
                            if (dVarIncompatible3 != null) {
                                return dVarIncompatible3;
                            }
                            m9930a(34);
                            throw null;
                        }
                        i3++;
                    }
                }
            }
        }
    }

    public d isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z2) {
        ExternalOverridabilityCondition.a aVar = ExternalOverridabilityCondition.a.CONFLICTS_ONLY;
        if (callableDescriptor == null) {
            m9930a(20);
            throw null;
        }
        if (callableDescriptor2 != null) {
            d dVarIsOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z2);
            boolean z3 = dVarIsOverridableByWithoutExternalConditions.getResult() == d.a.OVERRIDABLE;
            for (ExternalOverridabilityCondition externalOverridabilityCondition : f24410a) {
                if (externalOverridabilityCondition.getContract() != aVar && (!z3 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.a.SUCCESS_ONLY)) {
                    int iOrdinal = externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (iOrdinal == 0) {
                        z3 = true;
                    } else {
                        if (iOrdinal == 1) {
                            d dVarConflict = d.conflict("External condition failed");
                            if (dVarConflict != null) {
                                return dVarConflict;
                            }
                            m9930a(22);
                            throw null;
                        }
                        if (iOrdinal == 2) {
                            d dVarIncompatible = d.incompatible("External condition");
                            if (dVarIncompatible != null) {
                                return dVarIncompatible;
                            }
                            m9930a(23);
                            throw null;
                        }
                    }
                }
            }
            if (!z3) {
                return dVarIsOverridableByWithoutExternalConditions;
            }
            for (ExternalOverridabilityCondition externalOverridabilityCondition2 : f24410a) {
                if (externalOverridabilityCondition2.getContract() == aVar) {
                    int iOrdinal2 = externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (iOrdinal2 == 0) {
                        StringBuilder sbM833U = outline.m833U("Contract violation in ");
                        sbM833U.append(externalOverridabilityCondition2.getClass().getName());
                        sbM833U.append(" condition. It's not supposed to end with success");
                        throw new IllegalStateException(sbM833U.toString());
                    }
                    if (iOrdinal2 == 1) {
                        d dVarConflict2 = d.conflict("External condition failed");
                        if (dVarConflict2 != null) {
                            return dVarConflict2;
                        }
                        m9930a(25);
                        throw null;
                    }
                    if (iOrdinal2 == 2) {
                        d dVarIncompatible2 = d.incompatible("External condition");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        m9930a(26);
                        throw null;
                    }
                }
            }
            d dVarSuccess = d.success();
            if (dVarSuccess != null) {
                return dVarSuccess;
            }
            m9930a(27);
            throw null;
        }
        m9930a(21);
        throw null;
    }
}
