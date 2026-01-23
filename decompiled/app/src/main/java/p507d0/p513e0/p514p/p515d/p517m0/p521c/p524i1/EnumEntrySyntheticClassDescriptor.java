package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage3;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ClassTypeConstructorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o, reason: use source file name */
/* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {

    /* JADX INFO: renamed from: r */
    public final TypeConstructor f22909r;

    /* JADX INFO: renamed from: s */
    public final MemberScope3 f22910s;

    /* JADX INFO: renamed from: t */
    public final storage5<Set<Name>> f22911t;

    /* JADX INFO: renamed from: u */
    public final Annotations4 f22912u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a */
    /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
    public class a extends MemberScopeImpl {

        /* JADX INFO: renamed from: b */
        public final storage3<Name, Collection<? extends SimpleFunctionDescriptor>> f22913b;

        /* JADX INFO: renamed from: c */
        public final storage3<Name, Collection<? extends PropertyDescriptor>> f22914c;

        /* JADX INFO: renamed from: d */
        public final storage5<Collection<DeclarationDescriptor>> f22915d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ EnumEntrySyntheticClassDescriptor f22916e;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class C13308a implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
            public C13308a(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
                return invoke2(name);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public Collection<? extends SimpleFunctionDescriptor> invoke2(Name name) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (name != null) {
                    return aVar.m9422c(name, aVar.m9421b().getContributedFunctions(name, LookupLocation3.FOR_NON_TRACKED_SCOPE));
                }
                a.m9420a(8);
                throw null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$b */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class b implements Function1<Name, Collection<? extends PropertyDescriptor>> {
            public b(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends PropertyDescriptor> invoke(Name name) {
                return invoke2(name);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public Collection<? extends PropertyDescriptor> invoke2(Name name) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (name != null) {
                    return aVar.m9422c(name, aVar.m9421b().getContributedVariables(name, LookupLocation3.FOR_NON_TRACKED_SCOPE));
                }
                a.m9420a(4);
                throw null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$c */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class c implements Function0<Collection<DeclarationDescriptor>> {
            public c(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<DeclarationDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public Collection<DeclarationDescriptor> invoke2() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                HashSet hashSet = new HashSet();
                for (Name name : aVar.f22916e.f22911t.invoke()) {
                    LookupLocation3 lookupLocation3 = LookupLocation3.FOR_NON_TRACKED_SCOPE;
                    hashSet.addAll(aVar.getContributedFunctions(name, lookupLocation3));
                    hashSet.addAll(aVar.getContributedVariables(name, lookupLocation3));
                }
                return hashSet;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$d */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class d extends OverridingStrategy {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ Set f22920a;

            public d(a aVar, Set set) {
                this.f22920a = set;
            }

            /* JADX INFO: renamed from: a */
            public static /* synthetic */ void m9423a(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy2
            public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    m9423a(0);
                    throw null;
                }
                OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                this.f22920a.add(callableMemberDescriptor);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy
            public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    m9423a(1);
                    throw null;
                }
                if (callableMemberDescriptor2 != null) {
                    return;
                }
                m9423a(2);
                throw null;
            }
        }

        public a(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor, StorageManager storageManager) {
            if (storageManager == null) {
                m9420a(0);
                throw null;
            }
            this.f22916e = enumEntrySyntheticClassDescriptor;
            this.f22913b = storageManager.createMemoizedFunction(new C13308a(enumEntrySyntheticClassDescriptor));
            this.f22914c = storageManager.createMemoizedFunction(new b(enumEntrySyntheticClassDescriptor));
            this.f22915d = storageManager.createLazyValue(new c(enumEntrySyntheticClassDescriptor));
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void m9420a(int i) {
            String str;
            int i2;
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
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
                case 4:
                case 5:
                case 8:
                case 10:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 2:
                case 6:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 3) {
                objArr[1] = "getContributedVariables";
            } else if (i == 7) {
                objArr[1] = "getContributedFunctions";
            } else if (i == 9) {
                objArr[1] = "getSupertypeScope";
            } else if (i != 12) {
                switch (i) {
                    case 15:
                        objArr[1] = "getContributedDescriptors";
                        break;
                    case 16:
                        objArr[1] = "computeAllDeclarations";
                        break;
                    case 17:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 18:
                        objArr[1] = "getClassifierNames";
                        break;
                    case 19:
                        objArr[1] = "getVariableNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                        break;
                }
            } else {
                objArr[1] = "resolveFakeOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        /* JADX INFO: renamed from: b */
        public final MemberScope3 m9421b() {
            MemberScope3 memberScope = this.f22916e.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope != null) {
                return memberScope;
            }
            m9420a(9);
            throw null;
        }

        /* JADX INFO: renamed from: c */
        public final <D extends CallableMemberDescriptor> Collection<? extends D> m9422c(Name name, Collection<? extends D> collection) {
            if (name == null) {
                m9420a(10);
                throw null;
            }
            if (collection == null) {
                m9420a(11);
                throw null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.f24411b.generateOverridesInFunctionGroup(name, collection, Collections.emptySet(), this.f22916e, new d(this, linkedHashSet));
            return linkedHashSet;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Set<Name> getClassifierNames() {
            Set<Name> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            m9420a(18);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
            if (memberScope2 == null) {
                m9420a(13);
                throw null;
            }
            if (function1 == null) {
                m9420a(14);
                throw null;
            }
            Collection<DeclarationDescriptor> collectionInvoke = this.f22915d.invoke();
            if (collectionInvoke != null) {
                return collectionInvoke;
            }
            m9420a(15);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                m9420a(5);
                throw null;
            }
            if (lookupLocation2 == null) {
                m9420a(6);
                throw null;
            }
            Collection<? extends SimpleFunctionDescriptor> collection = (Collection) ((LockBasedStorageManager.m) this.f22913b).invoke(name);
            if (collection != null) {
                return collection;
            }
            m9420a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                m9420a(1);
                throw null;
            }
            if (lookupLocation2 == null) {
                m9420a(2);
                throw null;
            }
            Collection<? extends PropertyDescriptor> collection = (Collection) ((LockBasedStorageManager.m) this.f22914c).invoke(name);
            if (collection != null) {
                return collection;
            }
            m9420a(3);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Set<Name> getFunctionNames() {
            Set<Name> setInvoke = this.f22916e.f22911t.invoke();
            if (setInvoke != null) {
                return setInvoke;
            }
            m9420a(17);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Set<Name> getVariableNames() {
            Set<Name> setInvoke = this.f22916e.f22911t.invoke();
            if (setInvoke != null) {
                return setInvoke;
            }
            m9420a(19);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumEntrySyntheticClassDescriptor(StorageManager storageManager, ClassDescriptor classDescriptor, KotlinType kotlinType, Name name, storage5<Set<Name>> storage5Var, Annotations4 annotations4, SourceElement sourceElement) {
        super(storageManager, classDescriptor, name, sourceElement, false);
        if (storageManager == null) {
            m9419a(6);
            throw null;
        }
        if (kotlinType == null) {
            m9419a(8);
            throw null;
        }
        if (name == null) {
            m9419a(9);
            throw null;
        }
        if (storage5Var == null) {
            m9419a(10);
            throw null;
        }
        if (annotations4 == null) {
            m9419a(11);
            throw null;
        }
        if (sourceElement == null) {
            m9419a(12);
            throw null;
        }
        this.f22912u = annotations4;
        this.f22909r = new ClassTypeConstructorImpl(this, Collections.emptyList(), Collections.singleton(kotlinType), storageManager);
        this.f22910s = new a(this, storageManager);
        this.f22911t = storage5Var;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9419a(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static EnumEntrySyntheticClassDescriptor create(StorageManager storageManager, ClassDescriptor classDescriptor, Name name, storage5<Set<Name>> storage5Var, Annotations4 annotations4, SourceElement sourceElement) {
        if (storageManager == null) {
            m9419a(0);
            throw null;
        }
        if (classDescriptor == null) {
            m9419a(1);
            throw null;
        }
        if (name == null) {
            m9419a(2);
            throw null;
        }
        if (storage5Var == null) {
            m9419a(3);
            throw null;
        }
        if (annotations4 == null) {
            m9419a(4);
            throw null;
        }
        if (sourceElement != null) {
            return new EnumEntrySyntheticClassDescriptor(storageManager, classDescriptor, classDescriptor.getDefaultType(), name, storage5Var, annotations4, sourceElement);
        }
        m9419a(5);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        Annotations4 annotations4 = this.f22912u;
        if (annotations4 != null) {
            return annotations4;
        }
        m9419a(21);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9419a(16);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9419a(22);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.ENUM_ENTRY;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public Modality getModality() {
        return Modality.FINAL;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        m9419a(23);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public MemberScope3 getStaticScope() {
        MemberScope3.b bVar = MemberScope3.b.f24373b;
        if (bVar != null) {
            return bVar;
        }
        m9419a(15);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.f22909r;
        if (typeConstructor != null) {
            return typeConstructor;
        }
        m9419a(17);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            m9419a(13);
            throw null;
        }
        MemberScope3 memberScope3 = this.f22910s;
        if (memberScope3 != null) {
            return memberScope3;
        }
        m9419a(14);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f23087e;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        m9419a(20);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("enum entry ");
        sbM833U.append(getName());
        return sbM833U.toString();
    }
}
