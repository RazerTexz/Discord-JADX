package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;

/* compiled from: VariableDescriptorWithInitializerImpl.java */
/* renamed from: d0.e0.p.d.m0.c.i1.n0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {

    /* renamed from: o */
    public final boolean f22907o;

    /* renamed from: p */
    public storage6<AbstractC11815g<?>> f22908p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, KotlinType kotlinType, boolean z2, SourceElement sourceElement) {
        super(declarationDescriptor, annotations4, name, kotlinType, sourceElement);
        if (declarationDescriptor == null) {
            m9418a(0);
            throw null;
        }
        if (annotations4 == null) {
            m9418a(1);
            throw null;
        }
        if (name == null) {
            m9418a(2);
            throw null;
        }
        if (sourceElement == null) {
            m9418a(3);
            throw null;
        }
        this.f22907o = z2;
    }

    /* renamed from: a */
    public static /* synthetic */ void m9418a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor
    public AbstractC11815g<?> getCompileTimeInitializer() {
        storage6<AbstractC11815g<?>> storage6Var = this.f22908p;
        if (storage6Var != null) {
            return storage6Var.invoke();
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor
    public boolean isVar() {
        return this.f22907o;
    }

    public void setCompileTimeInitializer(storage6<AbstractC11815g<?>> storage6Var) {
        if (storage6Var != null) {
            this.f22908p = storage6Var;
        } else {
            m9418a(4);
            throw null;
        }
    }
}
