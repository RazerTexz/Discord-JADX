package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;

/* compiled from: ClassDescriptorBase.java */
/* renamed from: d0.e0.p.d.m0.c.i1.h, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ClassDescriptorBase extends AbstractClassDescriptor {

    /* renamed from: o */
    public final DeclarationDescriptor f22875o;

    /* renamed from: p */
    public final SourceElement f22876p;

    /* renamed from: q */
    public final boolean f22877q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassDescriptorBase(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, SourceElement sourceElement, boolean z2) {
        super(storageManager, name);
        if (storageManager == null) {
            m9410a(0);
            throw null;
        }
        if (declarationDescriptor == null) {
            m9410a(1);
            throw null;
        }
        if (name == null) {
            m9410a(2);
            throw null;
        }
        if (sourceElement == null) {
            m9410a(3);
            throw null;
        }
        this.f22875o = declarationDescriptor;
        this.f22876p = sourceElement;
        this.f22877q = z2;
    }

    /* renamed from: a */
    public static /* synthetic */ void m9410a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.f22875o;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        m9410a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = this.f22876p;
        if (sourceElement != null) {
            return sourceElement;
        }
        m9410a(5);
        throw null;
    }

    public boolean isExternal() {
        return this.f22877q;
    }
}
