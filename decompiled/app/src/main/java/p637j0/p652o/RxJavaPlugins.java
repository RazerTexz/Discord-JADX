package p637j0.p652o;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: j0.o.o, reason: use source file name */
/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public class RxJavaPlugins {

    /* JADX INFO: renamed from: a */
    public static final RxJavaPlugins f27384a = new RxJavaPlugins();

    /* JADX INFO: renamed from: b */
    public static final RxJavaErrorHandler f27385b = new a();

    /* JADX INFO: renamed from: c */
    public final AtomicReference<RxJavaErrorHandler> f27386c = new AtomicReference<>();

    /* JADX INFO: renamed from: d */
    public final AtomicReference<RxJavaObservableExecutionHook> f27387d = new AtomicReference<>();

    /* JADX INFO: renamed from: e */
    public final AtomicReference<RxJavaSingleExecutionHook> f27388e = new AtomicReference<>();

    /* JADX INFO: renamed from: f */
    public final AtomicReference<RxJavaCompletableExecutionHook> f27389f = new AtomicReference<>();

    /* JADX INFO: renamed from: g */
    public final AtomicReference<RxJavaSchedulersHook> f27390g = new AtomicReference<>();

    /* JADX INFO: renamed from: j0.o.o$a */
    /* JADX INFO: compiled from: RxJavaPlugins.java */
    public static class a extends RxJavaErrorHandler {
    }

    /* JADX INFO: renamed from: j0.o.o$b */
    /* JADX INFO: compiled from: RxJavaPlugins.java */
    public class b extends RxJavaCompletableExecutionHook {
        public b(RxJavaPlugins rxJavaPlugins) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        r2 = "rxjava.plugin." + r7.substring(0, r7.length() - 6).substring(14) + ".impl";
        r1 = r10.getProperty(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0087, code lost:
    
        if (r1 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a8, code lost:
    
        throw new java.lang.IllegalStateException("Implementing class declaration for " + r0 + " missing: " + r2);
     */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object m10866d(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                Iterator it = properties2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String string = entry.getKey().toString();
                    if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        break;
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e2) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e2);
        } catch (ClassNotFoundException e3) {
            throw new IllegalStateException(outline.m886y(simpleName, " implementation class not found: ", property), e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(outline.m886y(simpleName, " implementation not able to be accessed: ", property), e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(outline.m886y(simpleName, " implementation not able to be instantiated: ", property), e5);
        }
    }

    /* JADX INFO: renamed from: g */
    public static Properties m10867g() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    /* JADX INFO: renamed from: a */
    public RxJavaCompletableExecutionHook m10868a() {
        if (this.f27389f.get() == null) {
            Object objM10866d = m10866d(RxJavaCompletableExecutionHook.class, m10867g());
            if (objM10866d == null) {
                this.f27389f.compareAndSet(null, new b(this));
            } else {
                this.f27389f.compareAndSet(null, (RxJavaCompletableExecutionHook) objM10866d);
            }
        }
        return this.f27389f.get();
    }

    /* JADX INFO: renamed from: b */
    public RxJavaErrorHandler m10869b() {
        if (this.f27386c.get() == null) {
            Object objM10866d = m10866d(RxJavaErrorHandler.class, m10867g());
            if (objM10866d == null) {
                this.f27386c.compareAndSet(null, f27385b);
            } else {
                this.f27386c.compareAndSet(null, (RxJavaErrorHandler) objM10866d);
            }
        }
        return this.f27386c.get();
    }

    /* JADX INFO: renamed from: c */
    public RxJavaObservableExecutionHook m10870c() {
        if (this.f27387d.get() == null) {
            Object objM10866d = m10866d(RxJavaObservableExecutionHook.class, m10867g());
            if (objM10866d == null) {
                this.f27387d.compareAndSet(null, RxJavaObservableExecutionHookDefault.f27383a);
            } else {
                this.f27387d.compareAndSet(null, (RxJavaObservableExecutionHook) objM10866d);
            }
        }
        return this.f27387d.get();
    }

    /* JADX INFO: renamed from: e */
    public RxJavaSchedulersHook m10871e() {
        if (this.f27390g.get() == null) {
            Object objM10866d = m10866d(RxJavaSchedulersHook.class, m10867g());
            if (objM10866d == null) {
                this.f27390g.compareAndSet(null, RxJavaSchedulersHook.f27391a);
            } else {
                this.f27390g.compareAndSet(null, (RxJavaSchedulersHook) objM10866d);
            }
        }
        return this.f27390g.get();
    }

    /* JADX INFO: renamed from: f */
    public RxJavaSingleExecutionHook m10872f() {
        if (this.f27388e.get() == null) {
            Object objM10866d = m10866d(RxJavaSingleExecutionHook.class, m10867g());
            if (objM10866d == null) {
                this.f27388e.compareAndSet(null, RxJavaSingleExecutionHookDefault.f27392a);
            } else {
                this.f27388e.compareAndSet(null, (RxJavaSingleExecutionHook) objM10866d);
            }
        }
        return this.f27388e.get();
    }
}
