package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations5;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ValueParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ExtensionReceiver;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.DescriptorSubstitutor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartList;
import p507d0.p580t._Collections;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q, reason: use source file name */
/* JADX INFO: compiled from: FunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {

    /* JADX INFO: renamed from: A */
    public boolean f22922A;

    /* JADX INFO: renamed from: B */
    public boolean f22923B;

    /* JADX INFO: renamed from: C */
    public boolean f22924C;

    /* JADX INFO: renamed from: D */
    public boolean f22925D;

    /* JADX INFO: renamed from: E */
    public boolean f22926E;

    /* JADX INFO: renamed from: F */
    public boolean f22927F;

    /* JADX INFO: renamed from: G */
    public Collection<? extends FunctionDescriptor> f22928G;

    /* JADX INFO: renamed from: H */
    public volatile Function0<Collection<FunctionDescriptor>> f22929H;

    /* JADX INFO: renamed from: I */
    public final FunctionDescriptor f22930I;

    /* JADX INFO: renamed from: J */
    public final CallableMemberDescriptor.a f22931J;

    /* JADX INFO: renamed from: K */
    public FunctionDescriptor f22932K;

    /* JADX INFO: renamed from: L */
    public Map<CallableDescriptor.a<?>, Object> f22933L;

    /* JADX INFO: renamed from: n */
    public List<TypeParameterDescriptor> f22934n;

    /* JADX INFO: renamed from: o */
    public List<ValueParameterDescriptor> f22935o;

    /* JADX INFO: renamed from: p */
    public KotlinType f22936p;

    /* JADX INFO: renamed from: q */
    public ReceiverParameterDescriptor f22937q;

    /* JADX INFO: renamed from: r */
    public ReceiverParameterDescriptor f22938r;

    /* JADX INFO: renamed from: s */
    public Modality f22939s;

    /* JADX INFO: renamed from: t */
    public DescriptorVisibility2 f22940t;

    /* JADX INFO: renamed from: u */
    public boolean f22941u;

    /* JADX INFO: renamed from: v */
    public boolean f22942v;

    /* JADX INFO: renamed from: w */
    public boolean f22943w;

    /* JADX INFO: renamed from: x */
    public boolean f22944x;

    /* JADX INFO: renamed from: y */
    public boolean f22945y;

    /* JADX INFO: renamed from: z */
    public boolean f22946z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q$a */
    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    public class a implements Function0<Collection<FunctionDescriptor>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ TypeSubstitutor2 f22947j;

        public a(TypeSubstitutor2 typeSubstitutor2) {
            this.f22947j = typeSubstitutor2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<FunctionDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public Collection<FunctionDescriptor> invoke2() {
            SmartList smartList = new SmartList();
            Iterator<? extends FunctionDescriptor> it = FunctionDescriptorImpl.this.getOverriddenDescriptors().iterator();
            while (it.hasNext()) {
                smartList.add(it.next().substitute(this.f22947j));
            }
            return smartList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q$b */
    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    public static class b implements Function0<List<VariableDescriptor>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ List f22949j;

        public b(List list) {
            this.f22949j = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<VariableDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public List<VariableDescriptor> invoke2() {
            return this.f22949j;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.q$c */
    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    public class c implements FunctionDescriptor.a<FunctionDescriptor> {

        /* JADX INFO: renamed from: a */
        public TypeSubstitution5 f22950a;

        /* JADX INFO: renamed from: b */
        public DeclarationDescriptor f22951b;

        /* JADX INFO: renamed from: c */
        public Modality f22952c;

        /* JADX INFO: renamed from: d */
        public DescriptorVisibility2 f22953d;

        /* JADX INFO: renamed from: e */
        public FunctionDescriptor f22954e;

        /* JADX INFO: renamed from: f */
        public CallableMemberDescriptor.a f22955f;

        /* JADX INFO: renamed from: g */
        public List<ValueParameterDescriptor> f22956g;

        /* JADX INFO: renamed from: h */
        public ReceiverParameterDescriptor f22957h;

        /* JADX INFO: renamed from: i */
        public ReceiverParameterDescriptor f22958i;

        /* JADX INFO: renamed from: j */
        public KotlinType f22959j;

        /* JADX INFO: renamed from: k */
        public Name f22960k;

        /* JADX INFO: renamed from: l */
        public boolean f22961l;

        /* JADX INFO: renamed from: m */
        public boolean f22962m;

        /* JADX INFO: renamed from: n */
        public boolean f22963n;

        /* JADX INFO: renamed from: o */
        public boolean f22964o;

        /* JADX INFO: renamed from: p */
        public boolean f22965p;

        /* JADX INFO: renamed from: q */
        public List<TypeParameterDescriptor> f22966q;

        /* JADX INFO: renamed from: r */
        public Annotations4 f22967r;

        /* JADX INFO: renamed from: s */
        public boolean f22968s;

        /* JADX INFO: renamed from: t */
        public Map<CallableDescriptor.a<?>, Object> f22969t;

        /* JADX INFO: renamed from: u */
        public Boolean f22970u;

        /* JADX INFO: renamed from: v */
        public boolean f22971v;

        /* JADX INFO: renamed from: w */
        public final /* synthetic */ FunctionDescriptorImpl f22972w;

        public c(FunctionDescriptorImpl functionDescriptorImpl, TypeSubstitution5 typeSubstitution5, DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, List<ValueParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, KotlinType kotlinType, Name name) {
            if (typeSubstitution5 == null) {
                m9426a(0);
                throw null;
            }
            if (declarationDescriptor == null) {
                m9426a(1);
                throw null;
            }
            if (modality == null) {
                m9426a(2);
                throw null;
            }
            if (descriptorVisibility2 == null) {
                m9426a(3);
                throw null;
            }
            if (aVar == null) {
                m9426a(4);
                throw null;
            }
            if (list == null) {
                m9426a(5);
                throw null;
            }
            if (kotlinType == null) {
                m9426a(6);
                throw null;
            }
            this.f22972w = functionDescriptorImpl;
            this.f22954e = null;
            this.f22958i = functionDescriptorImpl.f22938r;
            this.f22961l = true;
            this.f22962m = false;
            this.f22963n = false;
            this.f22964o = false;
            this.f22965p = functionDescriptorImpl.isHiddenToOvercomeSignatureClash();
            this.f22966q = null;
            this.f22967r = null;
            this.f22968s = functionDescriptorImpl.isHiddenForResolutionEverywhereBesideSupercalls();
            this.f22969t = new LinkedHashMap();
            this.f22970u = null;
            this.f22971v = false;
            this.f22950a = typeSubstitution5;
            this.f22951b = declarationDescriptor;
            this.f22952c = modality;
            this.f22953d = descriptorVisibility2;
            this.f22955f = aVar;
            this.f22956g = list;
            this.f22957h = receiverParameterDescriptor;
            this.f22959j = kotlinType;
            this.f22960k = name;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9426a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public FunctionDescriptor build() {
            return this.f22972w.mo9374c(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setAdditionalAnnotations(Annotations4 annotations4) {
            return setAdditionalAnnotations(annotations4);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setCopyOverrides(boolean z2) {
            return setCopyOverrides(z2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            return setDispatchReceiverParameter(receiverParameterDescriptor);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setDropOriginalInContainingParts() {
            return setDropOriginalInContainingParts();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            return setExtensionReceiverParameter(receiverParameterDescriptor);
        }

        public c setHasSynthesizedParameterNames(boolean z2) {
            this.f22970u = Boolean.valueOf(z2);
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setHiddenForResolutionEverywhereBesideSupercalls() {
            return setHiddenForResolutionEverywhereBesideSupercalls();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setHiddenToOvercomeSignatureClash() {
            return setHiddenToOvercomeSignatureClash();
        }

        public c setJustForTypeSubstitution(boolean z2) {
            this.f22971v = z2;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setKind(CallableMemberDescriptor.a aVar) {
            return setKind(aVar);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setModality(Modality modality) {
            return setModality(modality);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setName(Name name) {
            return setName(name);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            return setOriginal(callableMemberDescriptor);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setOwner(DeclarationDescriptor declarationDescriptor) {
            return setOwner(declarationDescriptor);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setPreserveSourceElement() {
            return setPreserveSourceElement();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setReturnType(KotlinType kotlinType) {
            return setReturnType(kotlinType);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setSignatureChange() {
            return setSignatureChange();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setSubstitution(TypeSubstitution5 typeSubstitution5) {
            return setSubstitution(typeSubstitution5);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setTypeParameters(List list) {
            return setTypeParameters((List<TypeParameterDescriptor>) list);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setValueParameters(List list) {
            return setValueParameters((List<ValueParameterDescriptor>) list);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public /* bridge */ /* synthetic */ FunctionDescriptor.a setVisibility(DescriptorVisibility2 descriptorVisibility2) {
            return setVisibility(descriptorVisibility2);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setAdditionalAnnotations(Annotations4 annotations4) {
            if (annotations4 != null) {
                this.f22967r = annotations4;
                return this;
            }
            m9426a(32);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setCopyOverrides(boolean z2) {
            this.f22961l = z2;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.f22958i = receiverParameterDescriptor;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setDropOriginalInContainingParts() {
            this.f22964o = true;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.f22957h = receiverParameterDescriptor;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setHiddenForResolutionEverywhereBesideSupercalls() {
            this.f22968s = true;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setHiddenToOvercomeSignatureClash() {
            this.f22965p = true;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setKind(CallableMemberDescriptor.a aVar) {
            if (aVar != null) {
                this.f22955f = aVar;
                return this;
            }
            m9426a(13);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setModality(Modality modality) {
            if (modality != null) {
                this.f22952c = modality;
                return this;
            }
            m9426a(9);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setName(Name name) {
            if (name != null) {
                this.f22960k = name;
                return this;
            }
            m9426a(16);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            this.f22954e = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                this.f22951b = declarationDescriptor;
                return this;
            }
            m9426a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setPreserveSourceElement() {
            this.f22963n = true;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setReturnType(KotlinType kotlinType) {
            if (kotlinType != null) {
                this.f22959j = kotlinType;
                return this;
            }
            m9426a(22);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setSignatureChange() {
            this.f22962m = true;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setSubstitution(TypeSubstitution5 typeSubstitution5) {
            if (typeSubstitution5 != null) {
                this.f22950a = typeSubstitution5;
                return this;
            }
            m9426a(34);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setTypeParameters(List<TypeParameterDescriptor> list) {
            if (list != null) {
                this.f22966q = list;
                return this;
            }
            m9426a(20);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setValueParameters(List<ValueParameterDescriptor> list) {
            if (list != null) {
                this.f22956g = list;
                return this;
            }
            m9426a(18);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor.a
        public c setVisibility(DescriptorVisibility2 descriptorVisibility2) {
            if (descriptorVisibility2 != null) {
                this.f22953d = descriptorVisibility2;
                return this;
            }
            m9426a(11);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionDescriptorImpl(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(declarationDescriptor, annotations4, name, sourceElement);
        if (declarationDescriptor == null) {
            m9424a(0);
            throw null;
        }
        if (annotations4 == null) {
            m9424a(1);
            throw null;
        }
        if (name == null) {
            m9424a(2);
            throw null;
        }
        if (aVar == null) {
            m9424a(3);
            throw null;
        }
        if (sourceElement == null) {
            m9424a(4);
            throw null;
        }
        this.f22940t = DescriptorVisibilities.f23091i;
        this.f22941u = false;
        this.f22942v = false;
        this.f22943w = false;
        this.f22944x = false;
        this.f22945y = false;
        this.f22946z = false;
        this.f22922A = false;
        this.f22923B = false;
        this.f22924C = false;
        this.f22925D = false;
        this.f22926E = true;
        this.f22927F = false;
        this.f22928G = null;
        this.f22929H = null;
        this.f22932K = null;
        this.f22933L = null;
        this.f22930I = functionDescriptor == null ? this : functionDescriptor;
        this.f22931J = aVar;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9424a(int i) {
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

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, List<ValueParameterDescriptor> list, TypeSubstitutor2 typeSubstitutor2) {
        if (list == null) {
            m9424a(26);
            throw null;
        }
        if (typeSubstitutor2 != null) {
            return getSubstitutedValueParameters(functionDescriptor, list, typeSubstitutor2, false, false, null);
        }
        m9424a(27);
        throw null;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d);
    }

    /* JADX INFO: renamed from: b */
    public abstract FunctionDescriptorImpl mo9373b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement);

    /* JADX INFO: renamed from: c */
    public FunctionDescriptor mo9374c(c cVar) {
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType kotlinTypeSubstitute;
        if (cVar == null) {
            m9424a(23);
            throw null;
        }
        boolean[] zArr = new boolean[1];
        Annotations4 annotations4ComposeAnnotations = cVar.f22967r != null ? Annotations5.composeAnnotations(getAnnotations(), cVar.f22967r) : getAnnotations();
        DeclarationDescriptor declarationDescriptor = cVar.f22951b;
        FunctionDescriptor functionDescriptor = cVar.f22954e;
        CallableMemberDescriptor.a aVar = cVar.f22955f;
        Name name = cVar.f22960k;
        SourceElement source = cVar.f22963n ? (functionDescriptor != null ? functionDescriptor : getOriginal()).getSource() : SourceElement.f23099a;
        if (source == null) {
            m9424a(25);
            throw null;
        }
        FunctionDescriptorImpl functionDescriptorImplMo9373b = mo9373b(declarationDescriptor, functionDescriptor, aVar, name, annotations4ComposeAnnotations, source);
        List<TypeParameterDescriptor> typeParameters = cVar.f22966q;
        if (typeParameters == null) {
            typeParameters = getTypeParameters();
        }
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor2 typeSubstitutor2SubstituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(typeParameters, cVar.f22950a, functionDescriptorImplMo9373b, arrayList, zArr);
        if (typeSubstitutor2SubstituteTypeParameters == null) {
            return null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = cVar.f22957h;
        if (receiverParameterDescriptor2 != null) {
            KotlinType kotlinTypeSubstitute2 = typeSubstitutor2SubstituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
            if (kotlinTypeSubstitute2 == null) {
                return null;
            }
            ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl2 = new ReceiverParameterDescriptorImpl(functionDescriptorImplMo9373b, new ExtensionReceiver(functionDescriptorImplMo9373b, kotlinTypeSubstitute2, cVar.f22957h.getValue()), cVar.f22957h.getAnnotations());
            zArr[0] = (kotlinTypeSubstitute2 != cVar.f22957h.getType()) | zArr[0];
            receiverParameterDescriptorImpl = receiverParameterDescriptorImpl2;
        } else {
            receiverParameterDescriptorImpl = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = cVar.f22958i;
        if (receiverParameterDescriptor3 != null) {
            ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = receiverParameterDescriptor3.substitute(typeSubstitutor2SubstituteTypeParameters);
            if (receiverParameterDescriptorSubstitute == null) {
                return null;
            }
            zArr[0] = zArr[0] | (receiverParameterDescriptorSubstitute != cVar.f22958i);
            receiverParameterDescriptor = receiverParameterDescriptorSubstitute;
        } else {
            receiverParameterDescriptor = null;
        }
        List<ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(functionDescriptorImplMo9373b, cVar.f22956g, typeSubstitutor2SubstituteTypeParameters, cVar.f22964o, cVar.f22963n, zArr);
        if (substitutedValueParameters == null || (kotlinTypeSubstitute = typeSubstitutor2SubstituteTypeParameters.substitute(cVar.f22959j, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (kotlinTypeSubstitute != cVar.f22959j);
        if (!zArr[0] && cVar.f22971v) {
            return this;
        }
        functionDescriptorImplMo9373b.initialize(receiverParameterDescriptorImpl, receiverParameterDescriptor, arrayList, substitutedValueParameters, kotlinTypeSubstitute, cVar.f22952c, cVar.f22953d);
        functionDescriptorImplMo9373b.setOperator(this.f22941u);
        functionDescriptorImplMo9373b.setInfix(this.f22942v);
        functionDescriptorImplMo9373b.setExternal(this.f22943w);
        functionDescriptorImplMo9373b.setInline(this.f22944x);
        functionDescriptorImplMo9373b.setTailrec(this.f22945y);
        functionDescriptorImplMo9373b.setSuspend(this.f22925D);
        functionDescriptorImplMo9373b.setExpect(this.f22946z);
        functionDescriptorImplMo9373b.setActual(this.f22922A);
        functionDescriptorImplMo9373b.setHasStableParameterNames(this.f22926E);
        functionDescriptorImplMo9373b.f22923B = cVar.f22965p;
        functionDescriptorImplMo9373b.f22924C = cVar.f22968s;
        Boolean bool = cVar.f22970u;
        functionDescriptorImplMo9373b.setHasSynthesizedParameterNames(bool != null ? bool.booleanValue() : this.f22927F);
        if (!cVar.f22969t.isEmpty() || this.f22933L != null) {
            Map<CallableDescriptor.a<?>, Object> map = cVar.f22969t;
            Map<CallableDescriptor.a<?>, Object> map2 = this.f22933L;
            if (map2 != null) {
                for (Map.Entry<CallableDescriptor.a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                functionDescriptorImplMo9373b.f22933L = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                functionDescriptorImplMo9373b.f22933L = map;
            }
        }
        if (cVar.f22962m || getInitialSignatureDescriptor() != null) {
            functionDescriptorImplMo9373b.f22932K = (getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this).substitute(typeSubstitutor2SubstituteTypeParameters);
        }
        if (cVar.f22961l && !getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (cVar.f22950a.isEmpty()) {
                Function0<Collection<FunctionDescriptor>> function0 = this.f22929H;
                if (function0 != null) {
                    functionDescriptorImplMo9373b.f22929H = function0;
                } else {
                    functionDescriptorImplMo9373b.setOverriddenDescriptors(getOverriddenDescriptors());
                }
            } else {
                functionDescriptorImplMo9373b.f22929H = new a(typeSubstitutor2SubstituteTypeParameters);
            }
        }
        return functionDescriptorImplMo9373b;
    }

    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        return copy(declarationDescriptor, modality, descriptorVisibility2, aVar, z2);
    }

    /* JADX INFO: renamed from: d */
    public c m9425d(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return new c(this, typeSubstitutor2.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getExtensionReceiverParameter(), getReturnType(), null);
        }
        m9424a(22);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.f22938r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.f22937q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.f22932K;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public CallableMemberDescriptor.a getKind() {
        CallableMemberDescriptor.a aVar = this.f22931J;
        if (aVar != null) {
            return aVar;
        }
        m9424a(19);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.f22939s;
        if (modality != null) {
            return modality;
        }
        m9424a(13);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Function0<Collection<FunctionDescriptor>> function0 = this.f22929H;
        if (function0 != null) {
            this.f22928G = function0.invoke();
            this.f22929H = null;
        }
        Collection<? extends FunctionDescriptor> collectionEmptyList = this.f22928G;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList != null) {
            return collectionEmptyList;
        }
        m9424a(12);
        throw null;
    }

    public KotlinType getReturnType() {
        return this.f22936p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.f22934n;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.a<V> aVar) {
        Map<CallableDescriptor.a<?>, Object> map = this.f22933L;
        if (map == null) {
            return null;
        }
        return (V) map.get(aVar);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.f22935o;
        if (list != null) {
            return list;
        }
        m9424a(17);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = this.f22940t;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        m9424a(14);
        throw null;
    }

    public boolean hasStableParameterNames() {
        return this.f22926E;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.f22927F;
    }

    public FunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility2 descriptorVisibility2) {
        if (list == null) {
            m9424a(5);
            throw null;
        }
        if (list2 == null) {
            m9424a(6);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            m9424a(7);
            throw null;
        }
        this.f22934n = _Collections.toList(list);
        this.f22935o = _Collections.toList(list2);
        this.f22936p = kotlinType;
        this.f22939s = modality;
        this.f22940t = descriptorVisibility2;
        this.f22937q = receiverParameterDescriptor;
        this.f22938r = receiverParameterDescriptor2;
        for (int i = 0; i < list.size(); i++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i);
            if (typeParameterDescriptor.getIndex() != i) {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i);
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            ValueParameterDescriptor valueParameterDescriptor = list2.get(i2);
            if (valueParameterDescriptor.getIndex() != i2 + 0) {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i2);
            }
        }
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return this.f22922A;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return this.f22946z;
    }

    public boolean isExternal() {
        return this.f22943w;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.f22924C;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.f22923B;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isInfix() {
        if (this.f22942v) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f22944x;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isOperator() {
        if (this.f22941u) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isSuspend() {
        return this.f22925D;
    }

    public boolean isTailrec() {
        return this.f22945y;
    }

    public FunctionDescriptor.a<? extends FunctionDescriptor> newCopyBuilder() {
        return m9425d(TypeSubstitutor2.f24745a);
    }

    public <V> void putInUserDataMap(CallableDescriptor.a<V> aVar, Object obj) {
        if (this.f22933L == null) {
            this.f22933L = new LinkedHashMap();
        }
        this.f22933L.put(aVar, obj);
    }

    public void setActual(boolean z2) {
        this.f22922A = z2;
    }

    public void setExpect(boolean z2) {
        this.f22946z = z2;
    }

    public void setExternal(boolean z2) {
        this.f22943w = z2;
    }

    public void setHasStableParameterNames(boolean z2) {
        this.f22926E = z2;
    }

    public void setHasSynthesizedParameterNames(boolean z2) {
        this.f22927F = z2;
    }

    public void setInfix(boolean z2) {
        this.f22942v = z2;
    }

    public void setInline(boolean z2) {
        this.f22944x = z2;
    }

    public void setOperator(boolean z2) {
        this.f22941u = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            m9424a(15);
            throw null;
        }
        this.f22928G = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.f22924C = true;
                return;
            }
        }
    }

    public void setReturnType(KotlinType kotlinType) {
        if (kotlinType != null) {
            this.f22936p = kotlinType;
        } else {
            m9424a(10);
            throw null;
        }
    }

    public void setSuspend(boolean z2) {
        this.f22925D = z2;
    }

    public void setTailrec(boolean z2) {
        this.f22945y = z2;
    }

    public void setVisibility(DescriptorVisibility2 descriptorVisibility2) {
        if (descriptorVisibility2 != null) {
            this.f22940t = descriptorVisibility2;
        } else {
            m9424a(9);
            throw null;
        }
    }

    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        FunctionDescriptor functionDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility2).setKind(aVar).setCopyOverrides(z2).build();
        if (functionDescriptorBuild != null) {
            return functionDescriptorBuild;
        }
        m9424a(24);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    public FunctionDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return typeSubstitutor2.isEmpty() ? this : m9425d(typeSubstitutor2).setOriginal((CallableMemberDescriptor) getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
        }
        m9424a(20);
        throw null;
    }

    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, List<ValueParameterDescriptor> list, TypeSubstitutor2 typeSubstitutor2, boolean z2, boolean z3, boolean[] zArr) {
        if (list == null) {
            m9424a(28);
            throw null;
        }
        if (typeSubstitutor2 != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (ValueParameterDescriptor valueParameterDescriptor : list) {
                KotlinType type = valueParameterDescriptor.getType();
                Variance variance = Variance.IN_VARIANCE;
                KotlinType kotlinTypeSubstitute = typeSubstitutor2.substitute(type, variance);
                KotlinType varargElementType = valueParameterDescriptor.getVarargElementType();
                KotlinType kotlinTypeSubstitute2 = varargElementType == null ? null : typeSubstitutor2.substitute(varargElementType, variance);
                if (kotlinTypeSubstitute == null) {
                    return null;
                }
                if ((kotlinTypeSubstitute != valueParameterDescriptor.getType() || varargElementType != kotlinTypeSubstitute2) && zArr != null) {
                    zArr[0] = true;
                }
                arrayList.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(functionDescriptor, z2 ? null : valueParameterDescriptor, valueParameterDescriptor.getIndex(), valueParameterDescriptor.getAnnotations(), valueParameterDescriptor.getName(), kotlinTypeSubstitute, valueParameterDescriptor.declaresDefaultValue(), valueParameterDescriptor.isCrossinline(), valueParameterDescriptor.isNoinline(), kotlinTypeSubstitute2, z3 ? valueParameterDescriptor.getSource() : SourceElement.f23099a, valueParameterDescriptor instanceof ValueParameterDescriptorImpl.b ? new b(((ValueParameterDescriptorImpl.b) valueParameterDescriptor).getDestructuringVariables()) : null));
            }
            return arrayList;
        }
        m9424a(29);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.f22930I;
        FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        m9424a(18);
        throw null;
    }
}
