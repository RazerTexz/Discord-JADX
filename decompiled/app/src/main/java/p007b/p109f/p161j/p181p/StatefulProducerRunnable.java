package p007b.p109f.p161j.p181p;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.f.j.p.e1, reason: use source file name */
/* JADX INFO: compiled from: StatefulProducerRunnable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StatefulProducerRunnable<T> implements Runnable {

    /* JADX INFO: renamed from: j */
    public final AtomicInteger f4041j = new AtomicInteger(0);

    /* JADX INFO: renamed from: k */
    public final Consumer2<T> f4042k;

    /* JADX INFO: renamed from: l */
    public final ProducerListener2 f4043l;

    /* JADX INFO: renamed from: m */
    public final String f4044m;

    /* JADX INFO: renamed from: n */
    public final ProducerContext f4045n;

    public StatefulProducerRunnable(Consumer2<T> consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        this.f4042k = consumer2;
        this.f4043l = producerListener2;
        this.f4044m = str;
        this.f4045n = producerContext;
        producerListener2.mo1358e(producerContext, str);
    }

    /* JADX INFO: renamed from: a */
    public void m1464a() {
        if (this.f4041j.compareAndSet(0, 2)) {
            mo1468e();
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo1465b(T t);

    /* JADX INFO: renamed from: c */
    public Map<String, String> mo1466c(T t) {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public abstract T mo1467d() throws Exception;

    /* JADX INFO: renamed from: e */
    public void mo1468e() {
        ProducerListener2 producerListener2 = this.f4043l;
        ProducerContext producerContext = this.f4045n;
        String str = this.f4044m;
        producerListener2.mo1360g(producerContext, str);
        producerListener2.mo1357d(producerContext, str, null);
        this.f4042k.mo1426d();
    }

    /* JADX INFO: renamed from: f */
    public void mo1469f(Exception exc) {
        ProducerListener2 producerListener2 = this.f4043l;
        ProducerContext producerContext = this.f4045n;
        String str = this.f4044m;
        producerListener2.mo1360g(producerContext, str);
        producerListener2.mo1364k(producerContext, str, exc, null);
        this.f4042k.mo1425c(exc);
    }

    /* JADX INFO: renamed from: g */
    public void mo1470g(T t) {
        ProducerListener2 producerListener2 = this.f4043l;
        ProducerContext producerContext = this.f4045n;
        String str = this.f4044m;
        producerListener2.mo1363j(producerContext, str, producerListener2.mo1360g(producerContext, str) ? mo1466c(t) : null);
        this.f4042k.mo1424b(t, 1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4041j.compareAndSet(0, 1)) {
            try {
                T tMo1467d = mo1467d();
                this.f4041j.set(3);
                try {
                    mo1470g(tMo1467d);
                } finally {
                    mo1465b(tMo1467d);
                }
            } catch (Exception e) {
                this.f4041j.set(4);
                mo1469f(e);
            }
        }
    }
}
