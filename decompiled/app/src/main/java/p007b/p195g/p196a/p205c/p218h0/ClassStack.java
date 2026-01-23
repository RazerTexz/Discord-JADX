package p007b.p195g.p196a.p205c.p218h0;

import java.util.ArrayList;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.g.a.c.h0.c, reason: use source file name */
/* JADX INFO: compiled from: ClassStack.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassStack {

    /* JADX INFO: renamed from: a */
    public final ClassStack f4902a;

    /* JADX INFO: renamed from: b */
    public final Class<?> f4903b;

    /* JADX INFO: renamed from: c */
    public ArrayList<ResolvedRecursiveType> f4904c;

    public ClassStack(ClassStack classStack, Class<?> cls) {
        this.f4902a = classStack;
        this.f4903b = cls;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[ClassStack (self-refs: ");
        ArrayList<ResolvedRecursiveType> arrayList = this.f4904c;
        sbM833U.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
        sbM833U.append(')');
        for (ClassStack classStack = this; classStack != null; classStack = classStack.f4902a) {
            sbM833U.append(' ');
            sbM833U.append(classStack.f4903b.getName());
        }
        sbM833U.append(']');
        return sbM833U.toString();
    }

    public ClassStack(Class<?> cls) {
        this.f4902a = null;
        this.f4903b = cls;
    }
}
