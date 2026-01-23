package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyGetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.VariableDescriptor;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.m, reason: use source file name */
/* JADX INFO: compiled from: DeclarationDescriptorVisitorEmptyBodies.java */
/* JADX INFO: loaded from: classes3.dex */
public class DeclarationDescriptorVisitorEmptyBodies<R, D> implements DeclarationDescriptorVisitor<R, D> {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitClassDescriptor(ClassDescriptor classDescriptor, D d) {
        return visitDeclarationDescriptor(classDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d) {
        return visitFunctionDescriptor(constructorDescriptor, d);
    }

    public R visitDeclarationDescriptor(DeclarationDescriptor declarationDescriptor, D d) {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d) {
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitModuleDeclaration(ModuleDescriptor2 moduleDescriptor2, D d) {
        return visitDeclarationDescriptor(moduleDescriptor2, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d) {
        return visitDeclarationDescriptor(packageFragmentDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d) {
        return visitDeclarationDescriptor(packageViewDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d) {
        return visitFunctionDescriptor(propertyGetterDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d) {
        return visitFunctionDescriptor(propertySetterDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d) {
        return visitDeclarationDescriptor(receiverParameterDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d) {
        return visitDeclarationDescriptor(typeAliasDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d) {
        return visitDeclarationDescriptor(typeParameterDescriptor, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor
    public R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d) {
        return visitVariableDescriptor(valueParameterDescriptor, d);
    }

    public R visitVariableDescriptor(VariableDescriptor variableDescriptor, D d) {
        return visitDeclarationDescriptor(variableDescriptor, d);
    }
}
