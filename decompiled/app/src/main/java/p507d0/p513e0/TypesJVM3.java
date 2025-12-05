package p507d0.p513e0;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KType;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Standard2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypesJVM.kt */
/* renamed from: d0.e0.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypesJVM3 implements TypeVariable<GenericDeclaration>, Type {

    /* renamed from: j */
    public final KTypeParameter f22312j;

    public TypesJVM3(KTypeParameter kTypeParameter) {
        Intrinsics3.checkNotNullParameter(kTypeParameter, "typeParameter");
        this.f22312j = kTypeParameter;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (Intrinsics3.areEqual(getName(), typeVariable.getName()) && Intrinsics3.areEqual(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        List<KType> upperBounds = this.f22312j.getUpperBounds();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypesJVM5.access$computeJavaType((KType) it.next(), true));
        }
        Object[] array = arrayList.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        StringBuilder sbM833U = outline.m833U("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        sbM833U.append(this.f22312j);
        throw new Standard2(outline.m883w("An operation is not implemented: ", sbM833U.toString()));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.f22312j.getName();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
