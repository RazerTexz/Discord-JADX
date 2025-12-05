package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FieldDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.ExtensionReceiver;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.DescriptorSubstitutor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartSet;

/* compiled from: PropertyDescriptorImpl.java */
/* renamed from: d0.e0.p.d.m0.c.i1.c0, reason: use source file name */
/* loaded from: classes3.dex */
public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {

    /* renamed from: A */
    public final boolean f22819A;

    /* renamed from: B */
    public ReceiverParameterDescriptor f22820B;

    /* renamed from: C */
    public ReceiverParameterDescriptor f22821C;

    /* renamed from: D */
    public List<TypeParameterDescriptor> f22822D;

    /* renamed from: E */
    public PropertyGetterDescriptorImpl f22823E;

    /* renamed from: F */
    public PropertySetterDescriptor f22824F;

    /* renamed from: G */
    public boolean f22825G;

    /* renamed from: H */
    public FieldDescriptor f22826H;

    /* renamed from: I */
    public FieldDescriptor f22827I;

    /* renamed from: q */
    public final Modality f22828q;

    /* renamed from: r */
    public DescriptorVisibility2 f22829r;

    /* renamed from: s */
    public Collection<? extends PropertyDescriptor> f22830s;

    /* renamed from: t */
    public final PropertyDescriptor f22831t;

    /* renamed from: u */
    public final CallableMemberDescriptor.a f22832u;

    /* renamed from: v */
    public final boolean f22833v;

    /* renamed from: w */
    public final boolean f22834w;

    /* renamed from: x */
    public final boolean f22835x;

    /* renamed from: y */
    public final boolean f22836y;

    /* renamed from: z */
    public final boolean f22837z;

    /* compiled from: PropertyDescriptorImpl.java */
    /* renamed from: d0.e0.p.d.m0.c.i1.c0$a */
    public class a {

        /* renamed from: a */
        public DeclarationDescriptor f22838a;

        /* renamed from: b */
        public Modality f22839b;

        /* renamed from: c */
        public DescriptorVisibility2 f22840c;

        /* renamed from: e */
        public CallableMemberDescriptor.a f22842e;

        /* renamed from: h */
        public ReceiverParameterDescriptor f22845h;

        /* renamed from: i */
        public Name f22846i;

        /* renamed from: j */
        public KotlinType f22847j;

        /* renamed from: d */
        public PropertyDescriptor f22841d = null;

        /* renamed from: f */
        public TypeSubstitution5 f22843f = TypeSubstitution5.f24899a;

        /* renamed from: g */
        public boolean f22844g = true;

        public a() {
            this.f22838a = PropertyDescriptorImpl.this.getContainingDeclaration();
            this.f22839b = PropertyDescriptorImpl.this.getModality();
            this.f22840c = PropertyDescriptorImpl.this.getVisibility();
            this.f22842e = PropertyDescriptorImpl.this.getKind();
            this.f22845h = PropertyDescriptorImpl.this.f22820B;
            this.f22846i = PropertyDescriptorImpl.this.getName();
            this.f22847j = PropertyDescriptorImpl.this.getType();
        }

        /* renamed from: a */
        public static /* synthetic */ void m9395a(int i) {
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

        public PropertyDescriptor build() {
            ReceiverParameterDescriptor receiverParameterDescriptorSubstitute;
            ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
            PropertySetterDescriptorImpl propertySetterDescriptorImpl;
            storage6<AbstractC11815g<?>> storage6Var;
            PropertyDescriptorImpl propertyDescriptorImpl = PropertyDescriptorImpl.this;
            Objects.requireNonNull(propertyDescriptorImpl);
            CallableMemberDescriptor.a aVar = CallableMemberDescriptor.a.FAKE_OVERRIDE;
            DeclarationDescriptor declarationDescriptor = this.f22838a;
            Modality modality = this.f22839b;
            DescriptorVisibility2 descriptorVisibility2 = this.f22840c;
            PropertyDescriptor propertyDescriptor = this.f22841d;
            CallableMemberDescriptor.a aVar2 = this.f22842e;
            Name name = this.f22846i;
            SourceElement sourceElement = SourceElement.f23099a;
            PropertyDescriptorImpl propertyDescriptorImplMo9394b = propertyDescriptorImpl.mo9394b(declarationDescriptor, modality, descriptorVisibility2, propertyDescriptor, aVar2, name, sourceElement);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptorImpl.getTypeParameters();
            ArrayList arrayList = new ArrayList(typeParameters.size());
            TypeSubstitutor2 typeSubstitutor2SubstituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(typeParameters, this.f22843f, propertyDescriptorImplMo9394b, arrayList);
            KotlinType kotlinType = this.f22847j;
            Variance variance = Variance.OUT_VARIANCE;
            KotlinType kotlinTypeSubstitute = typeSubstitutor2SubstituteTypeParameters.substitute(kotlinType, variance);
            if (kotlinTypeSubstitute == null) {
                return null;
            }
            ReceiverParameterDescriptor receiverParameterDescriptor = this.f22845h;
            if (receiverParameterDescriptor != null) {
                receiverParameterDescriptorSubstitute = receiverParameterDescriptor.substitute(typeSubstitutor2SubstituteTypeParameters);
                if (receiverParameterDescriptorSubstitute == null) {
                    return null;
                }
            } else {
                receiverParameterDescriptorSubstitute = null;
            }
            ReceiverParameterDescriptor receiverParameterDescriptor2 = propertyDescriptorImpl.f22821C;
            if (receiverParameterDescriptor2 != null) {
                KotlinType kotlinTypeSubstitute2 = typeSubstitutor2SubstituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
                if (kotlinTypeSubstitute2 == null) {
                    return null;
                }
                receiverParameterDescriptorImpl = new ReceiverParameterDescriptorImpl(propertyDescriptorImplMo9394b, new ExtensionReceiver(propertyDescriptorImplMo9394b, kotlinTypeSubstitute2, propertyDescriptorImpl.f22821C.getValue()), propertyDescriptorImpl.f22821C.getAnnotations());
            } else {
                receiverParameterDescriptorImpl = null;
            }
            propertyDescriptorImplMo9394b.setType(kotlinTypeSubstitute, arrayList, receiverParameterDescriptorSubstitute, receiverParameterDescriptorImpl);
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = propertyDescriptorImpl.f22823E;
            if (propertyGetterDescriptorImpl2 == null) {
                propertyGetterDescriptorImpl = null;
            } else {
                Annotations4 annotations = propertyGetterDescriptorImpl2.getAnnotations();
                Modality modality2 = this.f22839b;
                DescriptorVisibility2 visibility = propertyDescriptorImpl.f22823E.getVisibility();
                if (this.f22842e == aVar && DescriptorVisibilities.isPrivate(visibility.normalize())) {
                    visibility = DescriptorVisibilities.f23090h;
                }
                DescriptorVisibility2 descriptorVisibility22 = visibility;
                boolean zIsDefault = propertyDescriptorImpl.f22823E.isDefault();
                boolean zIsExternal = propertyDescriptorImpl.f22823E.isExternal();
                boolean zIsInline = propertyDescriptorImpl.f22823E.isInline();
                CallableMemberDescriptor.a aVar3 = this.f22842e;
                PropertyDescriptor propertyDescriptor2 = this.f22841d;
                propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(propertyDescriptorImplMo9394b, annotations, modality2, descriptorVisibility22, zIsDefault, zIsExternal, zIsInline, aVar3, propertyDescriptor2 == null ? null : propertyDescriptor2.getGetter(), sourceElement);
            }
            if (propertyGetterDescriptorImpl != null) {
                KotlinType returnType = propertyDescriptorImpl.f22823E.getReturnType();
                propertyGetterDescriptorImpl.setInitialSignatureDescriptor(PropertyDescriptorImpl.m9393c(typeSubstitutor2SubstituteTypeParameters, propertyDescriptorImpl.f22823E));
                propertyGetterDescriptorImpl.initialize(returnType != null ? typeSubstitutor2SubstituteTypeParameters.substitute(returnType, variance) : null);
            }
            PropertySetterDescriptor propertySetterDescriptor = propertyDescriptorImpl.f22824F;
            if (propertySetterDescriptor == null) {
                propertySetterDescriptorImpl = null;
            } else {
                Annotations4 annotations2 = propertySetterDescriptor.getAnnotations();
                Modality modality3 = this.f22839b;
                DescriptorVisibility2 visibility2 = propertyDescriptorImpl.f22824F.getVisibility();
                if (this.f22842e == aVar && DescriptorVisibilities.isPrivate(visibility2.normalize())) {
                    visibility2 = DescriptorVisibilities.f23090h;
                }
                DescriptorVisibility2 descriptorVisibility23 = visibility2;
                boolean zIsDefault2 = propertyDescriptorImpl.f22824F.isDefault();
                boolean zIsExternal2 = propertyDescriptorImpl.f22824F.isExternal();
                boolean zIsInline2 = propertyDescriptorImpl.f22824F.isInline();
                CallableMemberDescriptor.a aVar4 = this.f22842e;
                PropertyDescriptor propertyDescriptor3 = this.f22841d;
                propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(propertyDescriptorImplMo9394b, annotations2, modality3, descriptorVisibility23, zIsDefault2, zIsExternal2, zIsInline2, aVar4, propertyDescriptor3 == null ? null : propertyDescriptor3.getSetter(), sourceElement);
            }
            if (propertySetterDescriptorImpl != null) {
                List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, propertyDescriptorImpl.f22824F.getValueParameters(), typeSubstitutor2SubstituteTypeParameters, false, false, null);
                if (substitutedValueParameters == null) {
                    propertyDescriptorImplMo9394b.setSetterProjectedOut(true);
                    substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, DescriptorUtils2.getBuiltIns(this.f22838a).getNothingType(), propertyDescriptorImpl.f22824F.getValueParameters().get(0).getAnnotations()));
                }
                if (substitutedValueParameters.size() != 1) {
                    throw new IllegalStateException();
                }
                propertySetterDescriptorImpl.setInitialSignatureDescriptor(PropertyDescriptorImpl.m9393c(typeSubstitutor2SubstituteTypeParameters, propertyDescriptorImpl.f22824F));
                propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
            }
            FieldDescriptor fieldDescriptor = propertyDescriptorImpl.f22826H;
            FieldDescriptorImpl fieldDescriptorImpl = fieldDescriptor == null ? null : new FieldDescriptorImpl(fieldDescriptor.getAnnotations(), propertyDescriptorImplMo9394b);
            FieldDescriptor fieldDescriptor2 = propertyDescriptorImpl.f22827I;
            propertyDescriptorImplMo9394b.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, fieldDescriptorImpl, fieldDescriptor2 != null ? new FieldDescriptorImpl(fieldDescriptor2.getAnnotations(), propertyDescriptorImplMo9394b) : null);
            if (this.f22844g) {
                SmartSet smartSetCreate = SmartSet.create();
                Iterator<? extends PropertyDescriptor> it = propertyDescriptorImpl.getOverriddenDescriptors().iterator();
                while (it.hasNext()) {
                    smartSetCreate.add(it.next().substitute(typeSubstitutor2SubstituteTypeParameters));
                }
                propertyDescriptorImplMo9394b.setOverriddenDescriptors(smartSetCreate);
            }
            if (propertyDescriptorImpl.isConst() && (storage6Var = propertyDescriptorImpl.f22908p) != null) {
                propertyDescriptorImplMo9394b.setCompileTimeInitializer(storage6Var);
            }
            return propertyDescriptorImplMo9394b;
        }

        public a setCopyOverrides(boolean z2) {
            this.f22844g = z2;
            return this;
        }

        public a setKind(CallableMemberDescriptor.a aVar) {
            if (aVar != null) {
                this.f22842e = aVar;
                return this;
            }
            m9395a(10);
            throw null;
        }

        public a setModality(Modality modality) {
            if (modality != null) {
                this.f22839b = modality;
                return this;
            }
            m9395a(6);
            throw null;
        }

        public a setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            this.f22841d = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        public a setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                this.f22838a = declarationDescriptor;
                return this;
            }
            m9395a(0);
            throw null;
        }

        public a setSubstitution(TypeSubstitution5 typeSubstitution5) {
            if (typeSubstitution5 != null) {
                this.f22843f = typeSubstitution5;
                return this;
            }
            m9395a(15);
            throw null;
        }

        public a setVisibility(DescriptorVisibility2 descriptorVisibility2) {
            if (descriptorVisibility2 != null) {
                this.f22840c = descriptorVisibility2;
                return this;
            }
            m9395a(8);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyDescriptorImpl(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(declarationDescriptor, annotations4, name, null, z2, sourceElement);
        if (declarationDescriptor == null) {
            m9392a(0);
            throw null;
        }
        if (annotations4 == null) {
            m9392a(1);
            throw null;
        }
        if (modality == null) {
            m9392a(2);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            m9392a(3);
            throw null;
        }
        if (name == null) {
            m9392a(4);
            throw null;
        }
        if (aVar == null) {
            m9392a(5);
            throw null;
        }
        if (sourceElement == null) {
            m9392a(6);
            throw null;
        }
        this.f22830s = null;
        this.f22828q = modality;
        this.f22829r = descriptorVisibility2;
        this.f22831t = propertyDescriptor == null ? this : propertyDescriptor;
        this.f22832u = aVar;
        this.f22833v = z3;
        this.f22834w = z4;
        this.f22835x = z5;
        this.f22836y = z6;
        this.f22837z = z7;
        this.f22819A = z8;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m9392a(int i) {
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

    /* renamed from: c */
    public static FunctionDescriptor m9393c(TypeSubstitutor2 typeSubstitutor2, PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (propertyAccessorDescriptor == null) {
            m9392a(26);
            throw null;
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor2);
        }
        return null;
    }

    public static PropertyDescriptorImpl create(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, CallableMemberDescriptor.a aVar, SourceElement sourceElement, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        if (declarationDescriptor == null) {
            m9392a(7);
            throw null;
        }
        if (annotations4 == null) {
            m9392a(8);
            throw null;
        }
        if (modality == null) {
            m9392a(9);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            m9392a(10);
            throw null;
        }
        if (name == null) {
            m9392a(11);
            throw null;
        }
        if (aVar == null) {
            m9392a(12);
            throw null;
        }
        if (sourceElement != null) {
            return new PropertyDescriptorImpl(declarationDescriptor, null, annotations4, modality, descriptorVisibility2, z2, name, aVar, sourceElement, z3, z4, z5, z6, z7, z8);
        }
        m9392a(13);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    /* renamed from: b */
    public PropertyDescriptorImpl mo9394b(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.a aVar, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            m9392a(27);
            throw null;
        }
        if (modality == null) {
            m9392a(28);
            throw null;
        }
        if (descriptorVisibility2 == null) {
            m9392a(29);
            throw null;
        }
        if (aVar == null) {
            m9392a(30);
            throw null;
        }
        if (name != null) {
            return new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility2, isVar(), name, aVar, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
        }
        m9392a(31);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        return copy(declarationDescriptor, modality, descriptorVisibility2, aVar, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.f22823E;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.f22824F;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor
    public FieldDescriptor getBackingField() {
        return this.f22826H;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor
    public FieldDescriptor getDelegateField() {
        return this.f22827I;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.VariableDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.f22820B;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.VariableDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.f22821C;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor
    public /* bridge */ /* synthetic */ PropertyGetterDescriptor getGetter() {
        return getGetter();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public CallableMemberDescriptor.a getKind() {
        CallableMemberDescriptor.a aVar = this.f22832u;
        if (aVar != null) {
            return aVar;
        }
        m9392a(34);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.f22828q;
        if (modality != null) {
            return modality;
        }
        m9392a(19);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collectionEmptyList = this.f22830s;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList != null) {
            return collectionEmptyList;
        }
        m9392a(36);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.VariableDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type != null) {
            return type;
        }
        m9392a(18);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor
    public PropertySetterDescriptor getSetter() {
        return this.f22824F;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.VariableDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.f22822D;
        if (list != null) {
            return list;
        }
        StringBuilder sbM833U = outline.m833U("typeParameters == null for ");
        sbM833U.append(toString());
        throw new IllegalStateException(sbM833U.toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithVisibility, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = this.f22829r;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        m9392a(20);
        throw null;
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor) {
        initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, null, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isActual() {
        return this.f22836y;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor
    public boolean isConst() {
        return this.f22834w;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor
    public boolean isDelegated() {
        return this.f22819A;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExpect() {
        return this.f22835x;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExternal() {
        return this.f22837z;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor
    public boolean isLateInit() {
        return this.f22833v;
    }

    public boolean isSetterProjectedOut() {
        return this.f22825G;
    }

    public a newCopyBuilder() {
        return new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != 0) {
            this.f22830s = collection;
        } else {
            m9392a(35);
            throw null;
        }
    }

    public void setSetterProjectedOut(boolean z2) {
        this.f22825G = z2;
    }

    public void setType(KotlinType kotlinType, List<? extends TypeParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (kotlinType == null) {
            m9392a(14);
            throw null;
        }
        if (list == null) {
            m9392a(15);
            throw null;
        }
        setOutType(kotlinType);
        this.f22822D = new ArrayList(list);
        this.f22821C = receiverParameterDescriptor2;
        this.f22820B = receiverParameterDescriptor;
    }

    public void setVisibility(DescriptorVisibility2 descriptorVisibility2) {
        if (descriptorVisibility2 != null) {
            this.f22829r = descriptorVisibility2;
        } else {
            m9392a(16);
            throw null;
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        PropertyDescriptor propertyDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setOriginal(null).setModality(modality).setVisibility(descriptorVisibility2).setKind(aVar).setCopyOverrides(z2).build();
        if (propertyDescriptorBuild != null) {
            return propertyDescriptorBuild;
        }
        m9392a(37);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor
    public PropertyGetterDescriptorImpl getGetter() {
        return this.f22823E;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor, FieldDescriptor fieldDescriptor, FieldDescriptor fieldDescriptor2) {
        this.f22823E = propertyGetterDescriptorImpl;
        this.f22824F = propertySetterDescriptor;
        this.f22826H = fieldDescriptor;
        this.f22827I = fieldDescriptor2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public PropertyDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        if (typeSubstitutor2 != null) {
            return typeSubstitutor2.isEmpty() ? this : newCopyBuilder().setSubstitution(typeSubstitutor2.getSubstitution()).setOriginal(getOriginal()).build();
        }
        m9392a(22);
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
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.f22831t;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        m9392a(33);
        throw null;
    }
}
