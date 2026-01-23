package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.f, reason: use source file name */
/* JADX INFO: compiled from: ClassData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassData {

    /* JADX INFO: renamed from: a */
    public final NameResolver f24625a;

    /* JADX INFO: renamed from: b */
    public final C11678c f24626b;

    /* JADX INFO: renamed from: c */
    public final BinaryVersion f24627c;

    /* JADX INFO: renamed from: d */
    public final SourceElement f24628d;

    public ClassData(NameResolver nameResolver, C11678c c11678c, BinaryVersion binaryVersion, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(c11678c, "classProto");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(sourceElement, "sourceElement");
        this.f24625a = nameResolver;
        this.f24626b = c11678c;
        this.f24627c = binaryVersion;
        this.f24628d = sourceElement;
    }

    public final NameResolver component1() {
        return this.f24625a;
    }

    public final C11678c component2() {
        return this.f24626b;
    }

    public final BinaryVersion component3() {
        return this.f24627c;
    }

    public final SourceElement component4() {
        return this.f24628d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics3.areEqual(this.f24625a, classData.f24625a) && Intrinsics3.areEqual(this.f24626b, classData.f24626b) && Intrinsics3.areEqual(this.f24627c, classData.f24627c) && Intrinsics3.areEqual(this.f24628d, classData.f24628d);
    }

    public int hashCode() {
        return this.f24628d.hashCode() + ((this.f24627c.hashCode() + ((this.f24626b.hashCode() + (this.f24625a.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ClassData(nameResolver=");
        sbM833U.append(this.f24625a);
        sbM833U.append(", classProto=");
        sbM833U.append(this.f24626b);
        sbM833U.append(", metadataVersion=");
        sbM833U.append(this.f24627c);
        sbM833U.append(", sourceElement=");
        sbM833U.append(this.f24628d);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
