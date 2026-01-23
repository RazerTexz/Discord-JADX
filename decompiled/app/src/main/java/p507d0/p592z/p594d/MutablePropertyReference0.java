package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty4;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;

/* JADX INFO: renamed from: d0.z.d.p, reason: use source file name */
/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KProperty5 {
    public MutablePropertyReference0() {
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public KCallable computeReflected() {
        return Reflection2.mutableProperty0(this);
    }

    @Override // kotlin.reflect.KProperty6
    public Object getDelegate() {
        return ((KProperty5) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return mo11489getGetter();
    }

    public /* bridge */ /* synthetic */ KProperty4 getSetter() {
        return mo11490getSetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty6
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public KProperty6.Getter mo11489getGetter() {
        return ((KProperty5) getReflected()).mo11489getGetter();
    }

    @Override // kotlin.reflect.KProperty5
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public KProperty5.Setter mo11490getSetter() {
        return ((KProperty5) getReflected()).mo11490getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
