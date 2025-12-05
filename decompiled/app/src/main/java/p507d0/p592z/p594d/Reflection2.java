package p507d0.p592z.p594d;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty5;
import kotlin.reflect.KProperty6;
import p507d0.p513e0.KClass;
import p507d0.p513e0.KProperty2;
import p507d0.p513e0.KProperty3;

/* compiled from: Reflection.java */
/* renamed from: d0.z.d.a0, reason: use source file name */
/* loaded from: classes3.dex */
public class Reflection2 {

    /* renamed from: a */
    public static final ReflectionFactory f25275a;

    /* renamed from: b */
    public static final KClass[] f25276b;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("d0.e0.p.d.d0").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f25275a = reflectionFactory;
        f25276b = new KClass[0];
    }

    public static KFunction function(FunctionReference functionReference) {
        return f25275a.function(functionReference);
    }

    public static KClass getOrCreateKotlinClass(Class cls) {
        return f25275a.getOrCreateKotlinClass(cls);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls) {
        return f25275a.getOrCreateKotlinPackage(cls, "");
    }

    public static KProperty5 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return f25275a.mutableProperty0(mutablePropertyReference0);
    }

    public static KProperty2 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return f25275a.mutableProperty1(mutablePropertyReference1);
    }

    public static KProperty6 property0(PropertyReference0 propertyReference0) {
        return f25275a.property0(propertyReference0);
    }

    public static KProperty3 property1(PropertyReference1 propertyReference1) {
        return f25275a.property1(propertyReference1);
    }

    public static String renderLambdaToString(Lambda lambda) {
        return f25275a.renderLambdaToString(lambda);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return f25275a.getOrCreateKotlinPackage(cls, str);
    }

    public static String renderLambdaToString(FunctionBase functionBase) {
        return f25275a.renderLambdaToString(functionBase);
    }
}
