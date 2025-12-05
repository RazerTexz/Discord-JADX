package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import p507d0.p513e0.KProperty2;
import p507d0.p513e0.KProperty3;

/* compiled from: MutablePropertyReference1.java */
/* renamed from: d0.z.d.r, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KProperty2 {
    public MutablePropertyReference1() {
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.mutableProperty1(this);
    }

    @Override // p507d0.p513e0.KProperty3
    public KProperty3.a getGetter() {
        return ((KProperty2) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
