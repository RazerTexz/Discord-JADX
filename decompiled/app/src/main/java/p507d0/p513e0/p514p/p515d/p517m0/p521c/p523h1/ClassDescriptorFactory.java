package p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;

/* compiled from: ClassDescriptorFactory.kt */
/* renamed from: d0.e0.p.d.m0.c.h1.b, reason: use source file name */
/* loaded from: classes3.dex */
public interface ClassDescriptorFactory {
    ClassDescriptor createClass(ClassId classId);

    Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName);

    boolean shouldCreateClass(FqName fqName, Name name);
}
